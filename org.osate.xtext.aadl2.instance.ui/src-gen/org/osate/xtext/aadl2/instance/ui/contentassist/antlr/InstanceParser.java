/*
 * generated by Xtext
 */
package org.osate.xtext.aadl2.instance.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.xtext.aadl2.instance.services.InstanceGrammarAccess;

public class InstanceParser extends AbstractContentAssistParser {
	
	@Inject
	private InstanceGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.xtext.aadl2.instance.ui.contentassist.antlr.internal.InternalInstanceParser createParser() {
		org.osate.xtext.aadl2.instance.ui.contentassist.antlr.internal.InternalInstanceParser result = new org.osate.xtext.aadl2.instance.ui.contentassist.antlr.internal.InternalInstanceParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getSystemInstanceAccess().getAlternatives_5(), "rule__SystemInstance__Alternatives_5");
					put(grammarAccess.getComponentCategoryAccess().getAlternatives(), "rule__ComponentCategory__Alternatives");
					put(grammarAccess.getSystemInstanceAccess().getGroup(), "rule__SystemInstance__Group__0");
					put(grammarAccess.getComponentInstanceAccess().getGroup(), "rule__ComponentInstance__Group__0");
					put(grammarAccess.getComponentInstanceAccess().getGroup_2(), "rule__ComponentInstance__Group_2__0");
					put(grammarAccess.getComponentInstanceAccess().getGroup_5(), "rule__ComponentInstance__Group_5__0");
					put(grammarAccess.getSystemOperationModeAccess().getGroup(), "rule__SystemOperationMode__Group__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_8(), "rule__ComponentCategory__Group_8__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_10(), "rule__ComponentCategory__Group_10__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_12(), "rule__ComponentCategory__Group_12__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_13(), "rule__ComponentCategory__Group_13__0");
					put(grammarAccess.getIMPLREFAccess().getGroup(), "rule__IMPLREF__Group__0");
					put(grammarAccess.getIMPLREFAccess().getGroup_0(), "rule__IMPLREF__Group_0__0");
					put(grammarAccess.getSUBREFAccess().getGroup(), "rule__SUBREF__Group__0");
					put(grammarAccess.getSUBREFAccess().getGroup_0(), "rule__SUBREF__Group_0__0");
					put(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0(), "rule__SystemInstance__CategoryAssignment_0");
					put(grammarAccess.getSystemInstanceAccess().getNameAssignment_1(), "rule__SystemInstance__NameAssignment_1");
					put(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3(), "rule__SystemInstance__ComponentImplementationAssignment_3");
					put(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_0(), "rule__SystemInstance__ComponentInstanceAssignment_5_0");
					put(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_1(), "rule__SystemInstance__SystemOperationModeAssignment_5_1");
					put(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0(), "rule__ComponentInstance__CategoryAssignment_0");
					put(grammarAccess.getComponentInstanceAccess().getNameAssignment_1(), "rule__ComponentInstance__NameAssignment_1");
					put(grammarAccess.getComponentInstanceAccess().getIndexAssignment_2_1(), "rule__ComponentInstance__IndexAssignment_2_1");
					put(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_4(), "rule__ComponentInstance__SubcomponentAssignment_4");
					put(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_5_1(), "rule__ComponentInstance__ComponentInstanceAssignment_5_1");
					put(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1(), "rule__SystemOperationMode__NameAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.xtext.aadl2.instance.ui.contentassist.antlr.internal.InternalInstanceParser typedParser = (org.osate.xtext.aadl2.instance.ui.contentassist.antlr.internal.InternalInstanceParser) parser;
			typedParser.entryRuleSystemInstance();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT" };
	}
	
	public InstanceGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(InstanceGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
