/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditorContextMenuProvider;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.features.DiagramUpdateFeature;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.ui.util.GhostPurger;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.internal.util.Log;
import org.eclipse.core.runtime.IProgressMonitor;

import java.util.Map;

public class AgeDiagramBehavior extends DiagramBehavior {
	public final static String AADL_DIAGRAM_TYPE_ID = "AADL Diagram";
	private final GhostPurger ghostPurger;
	private final DiagramService diagramService;
	private final PropertyService propertyService;
	private boolean updateInProgress = false;
	private boolean updateWhenVisible = false;
	private boolean forceNotDirty = false;
	private boolean updatingFeatureWhileForcingNotDirty = false;
	private ToolHandler toolHandler;
	private PaintListener paintListener = new PaintListener() {
		@Override
		public void paintControl(PaintEvent e) {
			if(updateWhenVisible) {
				update();
				updateWhenVisible = false;
			}
		}			
	};
	
	// Diagram change listener which refreshes the entire diagram. This is needed because there are cases where graphiti does not 
	// correctly update the diagram after shapes are moved.
	private final ResourceSetListener diagramChangeListener = new ResourceSetListener() {
		@Override
		public NotificationFilter getFilter() {
			return NotificationFilter.NOT_TOUCH;
		}

		@Override
		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			return null;
		}

		@Override
		public void resourceSetChanged(final ResourceSetChangeEvent event) {
			getRefreshBehavior().initRefresh();
			refresh();
		}

		public boolean isAggregatePrecommitListener() {
			return false;
		}

		public boolean isPostcommitOnly() {
			return true;
		}

		public boolean isPrecommitOnly() {
			return false;
		}		
	};
	
	public AgeDiagramBehavior(final IDiagramContainerUI diagramContainer, final GhostPurger ghostPurger, final DiagramService diagramService, final PropertyService propertyService) {
		super(diagramContainer);
		this.ghostPurger = ghostPurger;
		this.diagramService = diagramService;
		this.propertyService = propertyService;
	}	
	
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		final AgeDiagramEditor editor = (AgeDiagramEditor)this.getParentPart();
		if(editor != null) {
			final ActionRegistry actionRegistry = getDiagramContainer().getActionRegistry();
			@SuppressWarnings("unchecked")
			final List<String> selectionActions = getDiagramContainer().getSelectionActions();
			IAction action;
			action = new MatchSizeAction(editor);
			actionRegistry.registerAction(action);
			selectionActions.add(action.getId());
			action = new DistributeHorizontallyAction(editor);
			actionRegistry.registerAction(action);
			selectionActions.add(action.getId());
			action = new DistributeVerticallyAction(editor);
			actionRegistry.registerAction(action);
			selectionActions.add(action.getId());
			
			registerAction(new IncreaseNestingDepthAction(editor, propertyService));
	 		registerAction(new DecreaseNestingDepthAction(editor, propertyService));

 			// Register an action for each tool
	 		final ExtensionService extService = (ExtensionService)getAdapter(ExtensionService.class);
	 		toolHandler = new ToolHandler(extService, getPaletteBehavior());
	 		for(final Object tool : extService.getTools()) {
	 			registerAction(new ActivateToolAction(editor, toolHandler, tool));
	 		}
	 		
	 		editor.getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(final SelectionChangedEvent event) {
					final PictogramElement[] selectedPes = editor.getSelectedPictogramElements();
					if(selectedPes != null) {
						toolHandler.setSelectedPictogramElements(selectedPes);
					}
				}	 			
	 		});	 		
	 		toolHandler.setSelectedPictogramElements(editor.getSelectedPictogramElements());
	 			 		
	 		// Deactivate the tool when the part is deactivated or closed
	 		editor.getSite().getWorkbenchWindow().getPartService().addPartListener(new IPartListener() {
	 			@Override
	 			public void partClosed(final IWorkbenchPart part) {
	 				if (editor == part) {
	 					toolHandler.deactivateActiveTool();
	 					
	 					// Stop listening for part events
	 					editor.getSite().getWorkbenchWindow().getPartService().removePartListener(this);
	 				}	 				
	 			}

	 			@Override
	 			public void partDeactivated(final IWorkbenchPart part) {
	 				if (editor == part) {
	 					toolHandler.deactivateActiveTool();
	 				}
	 			}

	 			@Override
	 			public void partActivated(final IWorkbenchPart part) {}
	 			
	 			@Override
	 			public void partBroughtToTop(final IWorkbenchPart part) {}
	 			
	 			@Override
	 			public void partOpened(final IWorkbenchPart part) {}
	 		});
		}
	}
	
	/**
	 * Throws exception if the action for the specified tool cannot be found.
	 * @param toolId
	 * @return
	 */
	public IAction getActivateToolAction(final String toolId) {
		Objects.requireNonNull(toolId, "toolId must not be null");
		final ActionRegistry actionRegistry = getDiagramContainer().getActionRegistry();
		return Objects.requireNonNull(actionRegistry.getAction(ActivateToolAction.getActionId(toolId)), "unable to retrieve action for tool: " + toolId);
	}
	
	public void deactivateActiveTool() {
		toolHandler.deactivateActiveTool();
	}
	
	@Override
	protected void addGefListeners() {
		super.addGefListeners();
		getContentEditPart().getViewer().getControl().addPaintListener(paintListener);
	}
	
	@Override
	protected void disposeAfterGefDispose() { 
		super.disposeAfterGefDispose();
		
		if(toolHandler != null) {
			toolHandler.dispose();
		}
	}
	
	private IXtextModelListener modelListener = new IXtextModelListener() {
		@Override
		public void modelChanged(final XtextResource resource) {
			if(resource.getContents().size() > 0) {
				// Invalidate the cache
				final CachingService cachingService = (CachingService)getAdapter(CachingService.class);
				if(cachingService != null) {
					cachingService.invalidate();
				}
				
				// Update the diagram
				final EObject contents = resource.getContents().get(0);
				if(contents instanceof NamedElement) {
					updateIfDiagramResourceMatches(resource);
				}
			}					
		}	
	};

	private void updateIfDiagramResourceMatches(final Resource resource) {
		// Ensure the method is called in the UI thread
		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					updateIfDiagramResourceMatches(resource);
				}
			});
			return;
		}
		
		final Object bo = AadlElementWrapper.unwrap(getDiagramTypeProvider().getFeatureProvider().getBusinessObjectForPictogramElement(getDiagramTypeProvider().getDiagram()));
		if(bo instanceof Element) {
			if(((Element)bo).eResource() == resource) {
				update();
			}
		}
	}
	
	public void updateDiagramWhenVisible() {
		update();
	}
	
	private void update() {
		final Runnable updateDiagramRunnable = new Runnable() {
			private boolean updateQueued = false;
			
			public void run() {
				// A mutex is not needed because this runnable and other code that access variables used by this runnable are ran in the display thread
				// Don't update if update is already in progress
				if(!updateInProgress) {
					updateQueued = false;
					updateInProgress = true;
					
					try {
						// Don't update unless the diagram is visible
						if(getContentEditPart().getViewer().getControl().isVisible()) {
							// Update the entire diagram
							getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { getDiagramTypeProvider().getDiagram() });									
						} else {
							// Queue the update for when the control becomes visible
							updateWhenVisible = true;
						}
						
					} finally {
						updateInProgress = false;
					}
					
					// Check if an update has been queued
					if(updateQueued) {
						update();
					}
				
				} else {
					// Queue the update
					updateQueued = true;
				}								
			}
		};
		
		if(Display.getDefault().getThread() == Thread.currentThread()) {
			Log.info("Updating diagram synchronously - current thread is the display thread");
			updateDiagramRunnable.run();
		} else {
			Log.info("Updating diagram asynchronously - current thread is not the display thread");
			Display.getDefault().asyncExec(updateDiagramRunnable);	
		}
	}

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}	
	
	@Override
	protected DefaultPaletteBehavior createPaletteBehaviour() {
		return new DefaultPaletteBehavior(this) {
			@Override
			public void refreshPalette() {
				super.refreshPalette();
				
				// Hide palette drawers if a tool is active
				if(toolHandler != null && toolHandler.isToolActive()) {
					final PaletteRoot root = getPaletteRoot();
					for(final Object child : root.getChildren()) {
						if(child instanceof PaletteDrawer) {
							final PaletteDrawer drawer = (PaletteDrawer)child;
							drawer.setVisible(false);
						}
					}
				}
			}
		};
	}
	
	@Override
	protected void registerDiagramResourceSetListener() {
		// Do not call super method. This diagram behavior has a custom diagram change listener.
		final TransactionalEditingDomain eDomain = getEditingDomain();
		eDomain.addResourceSetListener(diagramChangeListener);
	}
	
	@Override
	protected void unregisterDiagramResourceSetListener() {
		// Do not call super method. This diagram behavior has a custom diagram change listener.
		if (diagramChangeListener != null) {
			//diagramChangeListener.stopListening();
			final TransactionalEditingDomain editingDomain = getEditingDomain();
			if (editingDomain != null) {
				editingDomain.removeResourceSetListener(diagramChangeListener);
			}
		}
	}
	
	@Override
	protected void registerBusinessObjectsListener() {
		// Do not call super method
		
		AgeXtextUtil.addModelListener(modelListener);
	}
	
	@Override
	protected void unregisterBusinessObjectsListener() {
		AgeXtextUtil.removeModelListener(modelListener);
		
		// Do not call super method
	}
	
	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {		
		return new DefaultRefreshBehavior(this) {
			@Override
			protected void autoUpdate() {
				IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
				Diagram diagram = diagramTypeProvider.getDiagram();
				IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
				IUpdateContext updateCtx = new UpdateContext(diagram);
				featureProvider.updateIfPossible(updateCtx);
				refresh();
			}
			
			@Override
			public void refresh() {
				if (Display.getCurrent() == null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							refresh();
						}
					});
					return;
				}
				
				// Update the toolbars
				if(getDiagramContainer() instanceof EditorPart) {
					((EditorPart)getDiagramContainer()).getEditorSite().getActionBars().getToolBarManager().update(true);
				}
				
				super.refresh();
			}
		};
	}
	
	public DefaultPersistencyBehavior getPersistencyBehavior() {
		return super.getPersistencyBehavior();
	}
	
	@Override
	protected ContextMenuProvider createContextMenuProvider() {
		return new DiagramEditorContextMenuProvider(getDiagramContainer().getGraphicalViewer(),
				getDiagramContainer().getActionRegistry(),
				getConfigurationProvider()) {

			@Override
			public void buildContextMenu(final IMenuManager manager) {
				// Don't populate context menu when a tool is active
				if(toolHandler == null  || !toolHandler.isToolActive()) {
					super.buildContextMenu(manager);
				}
			}					
		};
	}
	
	/**
	 * Returns the number of visible objects in the diagram. Only certain objects are checked. Used to decide whether the diagram has changed after an update
	 * @return
	 */
	private int getVisibleObjectsInDiagram() {
		int count = 0;
		final Iterator<EObject> it = getDiagramTypeProvider().getDiagram().eAllContents();
		while(it.hasNext()) {
			final EObject obj = it.next();
			if((obj instanceof Shape || obj instanceof Connection)) {
				final PictogramElement pe = (PictogramElement)obj;
				if(pe.isVisible()) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	@Override
	public Object executeFeature(final IFeature feature, final IContext context) {
		// If we are forcing the diagram to not be seen as dirty, decide whether to start using the typical dirty check
		if(forceNotDirty) {
			// Prevent the initial diagram update from making the diagram dirty if the number of objects doesn't change.			
			if(feature instanceof DiagramUpdateFeature) {
				final int startCount = getVisibleObjectsInDiagram();
				updatingFeatureWhileForcingNotDirty = true;
				final Object retValue = super.executeFeature(feature, context);
				updatingFeatureWhileForcingNotDirty = false;
				final int endCount = getVisibleObjectsInDiagram();
				if(startCount != endCount) {
					forceNotDirty = false;
				}
				return retValue;
			} else {
				if(!updatingFeatureWhileForcingNotDirty) {
					forceNotDirty = false;
				}
			}
		}
		return super.executeFeature(feature, context);
	}
	
	
	@Override
	protected void editingDomainInitialized() {
		super.editingDomainInitialized();
		
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		if(editingDomain != null) {
			final BasicCommandStack commandStack = (BasicCommandStack) editingDomain.getCommandStack();
			if(commandStack != null) {
				commandStack.addCommandStackListener(new CommandStackListener() {
					@Override
					public void commandStackChanged(EventObject event) {
						if(!updatingFeatureWhileForcingNotDirty) {
							forceNotDirty = false;
						}
					}					
				});
				
				// Since we have successfully creased a command stack listener, force the diagram to be seen as not dirty until there is a change
				forceNotDirty = true;
			}
		}
	}
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new DefaultPersistencyBehavior(this) {
			@Override
			public Diagram loadDiagram(final URI uri) {
				final Diagram diagram = super.loadDiagram(uri);
				
				if(diagram != null) {
					// Check if the diagram type is a legacy type. If so, convert it to the newer diagram type ID
					final String diagramTypeId = diagram.getDiagramTypeId();
					if("AADL Package".equals(diagramTypeId) ||
							"AADL Type".equals(diagramTypeId) ||
							"AADL Component Implementation".equals(diagramTypeId)) {						
						final TransactionalEditingDomain editingDomain = diagramBehavior.getEditingDomain();
						editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
							@Override
							protected void doExecute() {
								diagram.setDiagramTypeId(AADL_DIAGRAM_TYPE_ID);
							}				
						});	
					}
				}
				
				return diagram;
			}
			
			protected Set<Resource> save(final TransactionalEditingDomain editingDomain, final Map<Resource, Map<?, ?>> saveOptions, final IProgressMonitor monitor) {
				final Diagram diagram = getDiagramTypeProvider().getDiagram();

				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						// Delete all the ghosts
						ghostPurger.purgeGhosts(diagram);
					}				
				});				
				
				// Save the diagram				
				final Set<Resource> retValue = super.save(editingDomain, saveOptions, monitor);

				// Set the persistent properties
				diagramService.savePersistentProperties(diagram);
				
				return retValue;
			}
			
			// Keep the forceNotDirty check
			@Override
			public boolean isDirty() {
				if(forceNotDirty) {
					return false;
				}
				
				return super.isDirty();
			}
		};
	}

	// This prevents cluttering the context menu with global eclipse menu items
	@Override
	protected boolean shouldRegisterContextMenu() {
		return false;
	}
}