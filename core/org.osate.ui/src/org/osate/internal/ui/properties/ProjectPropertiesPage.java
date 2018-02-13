package org.osate.internal.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.ui.OsateUiPlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class ProjectPropertiesPage extends PropertyPage {
	private Text maxSOMText;
	private Preferences preferences;
	private int originalValue = -1;

	@Override
	protected Control createContents(final Composite parent) {
		// Get the project
		IProject project = Adapters.adapt(getElement(), IProject.class);
		if (project == null) {
			IResource resource = Adapters.adapt(getElement(), IResource.class);
			Assert.isNotNull(resource, "unable to adapt element to a project"); //$NON-NLS-1$
			project = resource.getProject();
		}

		// Get the project's preferences
		final IScopeContext context = new ProjectScope(project);
		preferences = context.getNode(InstantiateModel.PREFS_QUALIFIER);
		originalValue = getSOMLimit();

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		final Label label = new Label(composite, SWT.NONE);
		label.setText("Maximum Number of System Operation Modes to generate:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));

		maxSOMText = new Text(composite, SWT.BORDER);
		maxSOMText.setText(Integer.toString(getSOMLimit()));
		maxSOMText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		return composite;
	}

	private void setSOMLimit(final int limit) {
		preferences.putInt(InstantiateModel.PREF_SOM_LIMIT, limit);

		try {
			preferences.flush();
		} catch (final BackingStoreException e) {
			OsateUiPlugin.log(e);
		}
	}

	private int getSOMLimit() {
		return preferences.getInt(InstantiateModel.PREF_SOM_LIMIT, InstantiateModel.SOM_LIMIT);
	}

	@Override
	public boolean performOk() {
		final int newLimit = Integer.parseInt(maxSOMText.getText());
		setSOMLimit(newLimit);
		return true;
	}

	@Override
	protected void performDefaults() {
		setSOMLimit(InstantiateModel.SOM_LIMIT);
		maxSOMText.setText(Integer.toString(InstantiateModel.SOM_LIMIT));
		// Why? Because the default implementation does this
		updateApplyButton();
	}

	@Override
	public boolean performCancel() {
		setSOMLimit(originalValue);
		return true;
	}
}
