/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.ui.shared.Access;
import org.osate.xtext.aadl2.errormodel.ui.contentassist.antlr.AnnexAwareEntryPointFinder;
import org.osate.xtext.aadl2.errormodel.ui.outline.ErrorModelBackgroundOutlineTreeProvider;
import org.osate.xtext.aadl2.ui.containers.Aadl2ProjectsState;
import org.osate.xtext.aadl2.ui.containers.Aadl2ProjectsStateHelper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ErrorModelUiModule extends org.osate.xtext.aadl2.errormodel.ui.AbstractErrorModelUiModule {
	public ErrorModelUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.EntryPointFinder> bindEntryPointFinder() {
		return AnnexAwareEntryPointFinder.class;
	}

	@Override
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return Access.<IAllContainersState> provider(Aadl2ProjectsState.class);
	}

	public Class<? extends Aadl2ProjectsStateHelper> bindWorkspaceProjectsStateHelper() {
		return Aadl2ProjectsStateHelper.class;
	}

	// contributed by org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
	@Override
	public Class<? extends IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return ErrorModelBackgroundOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
	@Override
	public Class<? extends IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return ErrorModelBackgroundOutlineTreeProvider.class;
	}
}