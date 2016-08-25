/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.ui.views.AlisaView;
import org.osate.categories.categories.CategoryFilter;

public abstract class AlisaHandler extends AbstractHandler {
	protected static final String TERMINATE_ID = "org.osate.alisa.commands.terminate";
	protected static final String TERMINATE_ALL_ID = "org.osate.alisa.commands.terminateAll";
	protected IWorkbenchWindow window;
	protected ExecutionEvent executionEvent;

	private AlisaView alisaView;
	protected CategoryFilter filter;

	public ExecutionEvent getExecutionEvent() {
		return executionEvent;
	}

	public void setExecutionEvent(ExecutionEvent executionEvent) {
		this.executionEvent = executionEvent;
	}

	abstract protected IStatus runJob(EObject sel, CategoryFilter filter, IProgressMonitor monitor);

	abstract protected String getJobName();

	@Override
	public Object execute(ExecutionEvent event) {
		// Initialize to no filter. Will be updated in executeURI
		filter = null;

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (!(selection instanceof IStructuredSelection) || ((IStructuredSelection) selection).size() != 1) {
			return null;
		}

		Object selectedObj = ((IStructuredSelection) selection).getFirstElement();
		URI uri = null;
		if (selectedObj instanceof EObjectNode) {
			uri = ((EObjectNode) selectedObj).getEObjectURI();
		} else if (selectedObj instanceof EObject) {
			uri = EcoreUtil.getURI((EObject) selectedObj);
		} else {
			return null;
		}
		window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null) {
			return null;
		}

		return executeURI(uri);
	}

	public void prepare() {
		window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		if (window != null) {
			saveChanges(window.getActivePage().getDirtyEditors());
		}

	}

	protected void updateSelectedFilter() {

		if (alisaView == null) {
			try {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				alisaView = (AlisaView) page.showView(AlisaView.ID);
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				filter = null;
				return;
			}
		}
		filter = alisaView.getSelectedCategoryFilter();
		if (filter == null) {
			System.out.println("AlisaHandler.updateSelectedFilter() null");
		} else {
			System.out.println("AlisaHandler.updateSelectedFilter() " + filter.getName());
		}

	}

	/**
	 * For executing programmatically instead of execute and executeURI
	 * @param assuranceCaseResult
	 * @param categoryFilter null when there is no filter
	 * @param msr 
	 * @param assureURI
	 * @return
	 */
	public Object execute2(final AssuranceCaseResult assuranceCaseResult, CategoryFilter categoryFilter,
			ISchedulingRule msr) {
		filter = categoryFilter;

		URI uri = null;
		if (assuranceCaseResult instanceof EObjectNode) {
			// System.out.println("AlisaHandler.execute2() EObjectNode");
			uri = ((EObjectNode) assuranceCaseResult).getEObjectURI();
		} else if (assuranceCaseResult instanceof EObject) {
			// System.out.println("AlisaHandler.execute2() EObject");
			uri = EcoreUtil.getURI((EObject) assuranceCaseResult);
		}
		System.out.println("AlisaHandler.execute2() assuranceCaseResult name: " + assuranceCaseResult.getName());
//		System.out.println("AlisaHandler.execute2() uri from AssuranceCaseResult: " + uri.toString());
		// System.out.println("AlisaHandler.execute2() assureURI generated just checking : " + assureURI.toString());

//		window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//
//		if (window != null && !saveChanges(window.getActivePage().getDirtyEditors())) {
//			return null;
//		}

		WorkspaceJob job = getWorkspaceJob2(getJobName(), assuranceCaseResult);
		scheduleJob(job, msr, uri);

		return null;
	}

	public Object executeURI(final URI uri) {
		final XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
		if (xtextEditor == null) {
			return null;
		}
		if (!saveChanges(window.getActivePage().getDirtyEditors())) {
			return null;
		}

		updateSelectedFilter();

		WorkspaceJob job = getWorkspaceJob(getJobName(), xtextEditor, uri);
		// scheduleJob(job, new org.osate.assure.ui.views.MutexSchedulingRule(), uri);
		scheduleJob(job, ResourcesPlugin.getWorkspace().getRoot(), uri);
		return null;
	}

	/**
	 * 
	 * @param job
	 * @param msr  Set as combination of project of where aadl models is and the project with selected alisa
	 * @param uri  uri of assure file that is to be generated/updated.
	 * @return
	 */
	protected Object scheduleJob(WorkspaceJob job, ISchedulingRule msr, final URI uri) {
//		job.setRule(ResourcesPlugin.getWorkspace().getRoot()); 

		// Currently msr would have the project of the AADL and project of the alisa
//		ISchedulingRule file = ResourcesPlugin.getWorkspace().getRoot();
//		if (uri.isPlatform()) {
//			file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
//		} else if (uri.isFile()) {
//			file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toFileString()));
//		}

		System.out.println("  MultiRule>>>>>>>>>>>>scheduleJob setting: " + msr.toString());
//		job.setRule(file);
//		job.setRule(MultiRule.combine(msr, file));
		job.setRule(msr);
		job.schedule();

		// release the main thread
		return null;
	}

	protected WorkspaceJob getWorkspaceJob(String jobName, final XtextEditor xtextEditor, final URI uri) {
		WorkspaceJob job = new WorkspaceJob(getJobName()) {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) {
				return xtextEditor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {
					@Override
					public IStatus exec(XtextResource resource) throws Exception {
						EObject eobj = resource.getResourceSet().getEObject(uri, true);
						return runJob(eobj, filter, monitor);
					}
				});
			}
		};
		return job;
	}

	protected WorkspaceJob getWorkspaceJob2(String jobName, final EObject assuranceCaseResult) {
		WorkspaceJob job = new WorkspaceJob(getJobName()) {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) {
				return runJob(assuranceCaseResult, filter, monitor);
			}
		};
		return job;
	}

	protected boolean saveChanges(IEditorPart[] dirtyEditors) {
		if (dirtyEditors.length == 0) {
			return true;
		}

		if (MessageDialog.openConfirm(window.getShell(), "Save editors", "Save editors and continue?")) {
			NullProgressMonitor monitor = new NullProgressMonitor();
			for (IEditorPart e : dirtyEditors) {
				e.doSave(monitor);
			}
			return true;
		} else {
			return false;
		}
	}

//	    protected EObjectNode getEObjectNode(ISelection currentSelection) {
//	        if (currentSelection instanceof IStructuredSelection) {
//	            IStructuredSelection iss = (IStructuredSelection) currentSelection;
//	            if (iss.size() == 1) {
//	                return (EObjectNode) iss.getFirstElement();
//	            }
//	        }
//	        return null;
//	    }

	protected IWorkbenchWindow getWindow() {
		return window;
	}
}