/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 */
package org.osate.internal.ui.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.osate.aadl2.modelsupport.FileNameConstants;
import org.osate.pluginsupport.PluginSupportPlugin;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.OsateUiPlugin;

/**
 * This class represents the OSATE > Instantiation workspace preferences.
 * @since 5.0
 */
public final class ContributedResourcesPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	private final Map<String, Boolean> originalValues = new HashMap<>();
	private List<URI> originalWorkspaceContributions;

	private Map<URI, BooleanFieldEditor> fields = new HashMap<>();
	private List<URI> workspaceContributions;

	private ListViewer workspaceList;

	public ContributedResourcesPreferencePage() {
		super(GRID);
	}

	/**
	 * Create the field editors.
	 */
	@Override
	public Control createContents(final Composite parent) {
		final IPreferenceStore prefs = getPreferenceStore();

		final SashForm sashForm = new SashForm(parent, SWT.VERTICAL);

		final Group contributedResourcesGroup = new Group(sashForm, SWT.SHADOW_ETCHED_IN);
		contributedResourcesGroup.setLayout(new GridLayout(1, true));

		contributedResourcesGroup.setText("Select Plug-in Contributed Resources to Use");
		final ScrolledComposite scroller = new ScrolledComposite(contributedResourcesGroup, SWT.V_SCROLL);
		scroller.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, true));

		final Composite editorFields = new Composite(scroller, SWT.NONE);
		for (final URI uri : PluginSupportUtil.getContributedAadl()) {
			final String preferenceNameForURI = PredeclaredProperties.getIsVisiblePreferenceNameForURI(uri);
			originalValues.put(preferenceNameForURI, prefs.getBoolean(preferenceNameForURI));
			final BooleanFieldEditor booleanEditor = new BooleanFieldEditor(
					preferenceNameForURI, uriToLabel(uri), editorFields);
			fields.put(uri, booleanEditor);
			addField(booleanEditor);
		}
		editorFields.setSize(editorFields.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scroller.setContent(editorFields);

		final List<URI> wc = PredeclaredProperties.getVisibleWorkspaceContributedResources();
		originalWorkspaceContributions = wc;
		workspaceContributions = new ArrayList<>(wc); // needs to be mutable

		final Group workpaceContributionsGroup = new Group(sashForm, SWT.SHADOW_ETCHED_IN);
		workpaceContributionsGroup.setLayout(new GridLayout(2, true));
		workpaceContributionsGroup.setText("Select Resources in the Workspace to Contribute");

		final Button addButton = new Button(workpaceContributionsGroup, SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
		addButton.setText("Add");
		addButton.setToolTipText("Add 1 or more workspace resources to the global list of" + System.lineSeparator()
				+ "contributed resources.");
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				addWorkspaceContributedResources();
				checkState();
			}
		});

		final Button removeButton = new Button(workpaceContributionsGroup, SWT.PUSH);
		removeButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
		removeButton.setText("Remove");
		removeButton.setEnabled(false);
		removeButton.setToolTipText("Remove the selected resources from the global" + System.lineSeparator()
				+ "list of contributed resources.");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				workspaceContributions.removeAll(((IStructuredSelection) workspaceList.getSelection()).toList());
				workspaceList.refresh();
				// Update the error state by checking if duplicates were removed
				checkState();
			}
		});

		workspaceList = new ListViewer(workpaceContributionsGroup); // , SWT.BORDER | SWT.MULTI);
		workspaceList.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		workspaceList.getList().setToolTipText("Hello");
		workspaceList.addSelectionChangedListener(event -> removeButton.setEnabled(!event.getSelection().isEmpty()));
		workspaceList.setContentProvider((IStructuredContentProvider) inputElement -> {
			if (inputElement == null) {
				return new String[0];
			} else {
				return ((List<?>) inputElement).toArray();
			}
		});
		workspaceList.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(final Object element) {
				return uriToLabel((URI) element);
			}
		});
		workspaceList.setInput(workspaceContributions);

		// Set up the field editors
		sashForm.setWeights(new int[] { 3, 1 });
		initialize();
		checkState();

		return sashForm;
	}

	private static String uriToLabel(final URI uri) {
		final String uriAsString = uri.toString();
		final int firstSlash = uriAsString.indexOf('/');
		final int secondSlash = uriAsString.indexOf('/', firstSlash + 1);
		return uriAsString.substring(secondSlash + 1);
	}

	@Override
	public void createFieldEditors() {
		// do nothing, we aren't used here
	}

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore(PluginSupportPlugin.getDefault().getPreferenceStore());
	}

	@Override
	public boolean performOk() {
		final boolean ok = super.performOk();

		/* Check if the preferences changed. Don't want to rebuild the workspace if they didn't */
		final IPreferenceStore prefs = getPreferenceStore();
		boolean changed = false;
		for (final Map.Entry<String, Boolean> elt : originalValues.entrySet()) {
			if (prefs.getBoolean(elt.getKey()) != elt.getValue()) {
				changed = true;
				break;
			}
		}
		if (!originalWorkspaceContributions.equals(workspaceContributions)) {
			PredeclaredProperties.setWorkspaceContributions(workspaceContributions);
			changed = true;
		}

		// build the workspace
		if (changed) {
			/*
			 * Rebuilding or cleaning the workspace doesn't seem to get the job done. It leaves
			 * dangling links and other strangeness in the workspace. The most effectively thing
			 * to do seems to be closing and reopening projects. Have no idea why.
			 *
			 * NB. THis CANNOT be a WorkspaceJob because that will cause various events to be suppressed or
			 * optimized away, and then the build won't happen correctly.
			 */
			final Job job = new Job("Contributed Resources Rebuild") {
				@Override
				public IStatus run(final IProgressMonitor monitor) {
					try {
						final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
						final List<IProject> projectsToOpenAndClose = new ArrayList<>(projects.length);

						// (1) close all the open projects
						for (final IProject project : projects) {
							if (project.isOpen()) {
								projectsToOpenAndClose.add(project);
								project.close(monitor);
							}
						}

						// (2) Reopen all the projects we closed
						for (final IProject project : projectsToOpenAndClose) {
							project.open(monitor);
						}

						return Status.OK_STATUS;
					} catch (final CoreException e) {
						return new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, "Error building workspace");
					}
				}
			};
			job.setRule(ResourcesPlugin.getWorkspace().getRoot()); // Lock the workspace?
			job.schedule();
		}

		return ok;
	}

	private void addWorkspaceContributedResources() {
		final ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(),
				ResourcesPlugin.getWorkspace().getRoot(),
				"Select AADL property sets to be treated as contributed resources.");
		dialog.open();
		final Object[] selectedResources = dialog.getResult();
		if (selectedResources != null) {
			/* Filter out non-AADL files */
			final List<URI> selectedAadl = new ArrayList<>();
			boolean filteredOut = false;
			for (final Object o : selectedResources) {
				if (o instanceof IFile) {
					final IFile f = (IFile) o;
					if (f.getFileExtension().equals(FileNameConstants.SOURCE_FILE_EXT)) {
						final URI newURI = URI.createPlatformResourceURI(f.getFullPath().toString(), false);
						selectedAadl.add(newURI);
					} else {
						filteredOut = true;
					}
				} else {
					filteredOut = true;
				}
			}
			if (!selectedAadl.isEmpty()) {
				workspaceContributions.addAll(selectedAadl);
				workspaceList.refresh();
			}
			;

			if (filteredOut) {
				MessageDialog.openInformation(getShell(), "Invalid Resources Ignored",
						"Selected resources that are not AADL files have been ignored.");
			}
		}
	}

	@Override
	protected void checkState() {
		super.checkState();
		boolean isValid = isValid();

		/*
		 * Check for duplicate package/property set names among the VISIBLE contributions.
		 * This is important because we want to be able to make a plug-in contribution invisible,
		 * and replace it with a workspace contribution.
		 */
		final Set<String> names = new HashSet<>();
		String duplicateName = null;
		for (final Map.Entry<URI, BooleanFieldEditor> elt : fields.entrySet()) {
			if (elt.getValue().getBooleanValue()) {
				final String currentName = elt.getKey().lastSegment();
				if (!names.add(currentName)) {
					duplicateName = currentName;
					break;
				}
			}
		}
		for (final URI currentURI : workspaceContributions) {
			final String currentName = currentURI.lastSegment();
			if (!names.add(currentName)) {
				duplicateName = currentName;
				break;
			}
		}

		if (duplicateName != null) {
			setErrorMessage("Resource \"" + duplicateName + "\" contributed more than once.");
			// State is definitely invalid no matter what the super call says
			isValid = false;
		} else {
			/*
			 * We didn't add any new errors, but may be invalid due to the super call, so leave isInvalid alone.
			 * But we may need to clear out the error message.
			 */
			if (isValid) {
				setErrorMessage(null);
			}
		}

		setValid(isValid);
	}

	@Override
	public void performDefaults() {
		// Set workspace contributions to default
		workspaceContributions.clear();
		workspaceContributions.addAll(PredeclaredProperties.getDefaultWorkspaceContributions());
		workspaceList.refresh();

		// Super call handles the boolean preferences and calls checkState()
		super.performDefaults();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
        if (event.getProperty().equals(FieldEditor.VALUE)) {
			checkState();
        }

		super.propertyChange(event);
    }
}