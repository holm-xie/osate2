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
package org.osate.verify.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.verify.services.VerifyGrammarAccess;

public class VerifyParser extends AbstractContentAssistParser {
	
	@Inject
	private VerifyGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyParser createParser() {
		org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyParser result = new org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getVerificationAccess().getContentsAlternatives_0(), "rule__Verification__ContentsAlternatives_0");
					put(grammarAccess.getElseEvidenceExprAccess().getAlternatives(), "rule__ElseEvidenceExpr__Alternatives");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getAlternatives_1_1(), "rule__SingleElseEvidenceExpr__Alternatives_1_1");
					put(grammarAccess.getCompositeEvidenceExprAccess().getAlternatives(), "rule__CompositeEvidenceExpr__Alternatives");
					put(grammarAccess.getVerificationConditionAccess().getAlternatives_0(), "rule__VerificationCondition__Alternatives_0");
					put(grammarAccess.getVerificationMethodAccess().getAlternatives_2_4(), "rule__VerificationMethod__Alternatives_2_4");
					put(grammarAccess.getMethodTypeAccess().getAlternatives(), "rule__MethodType__Alternatives");
					put(grammarAccess.getDescriptionElementAccess().getAlternatives(), "rule__DescriptionElement__Alternatives");
					put(grammarAccess.getValDeclarationAccess().getAlternatives_2(), "rule__ValDeclaration__Alternatives_2");
					put(grammarAccess.getComputeDeclarationAccess().getAlternatives_2(), "rule__ComputeDeclaration__Alternatives_2");
					put(grammarAccess.getOpEqualityAccess().getAlternatives(), "rule__OpEquality__Alternatives");
					put(grammarAccess.getOpCompareAccess().getAlternatives(), "rule__OpCompare__Alternatives");
					put(grammarAccess.getOpOtherAccess().getAlternatives(), "rule__OpOther__Alternatives");
					put(grammarAccess.getOpOtherAccess().getAlternatives_5_1(), "rule__OpOther__Alternatives_5_1");
					put(grammarAccess.getOpOtherAccess().getAlternatives_6_1(), "rule__OpOther__Alternatives_6_1");
					put(grammarAccess.getOpAddAccess().getAlternatives(), "rule__OpAdd__Alternatives");
					put(grammarAccess.getOpMultiAccess().getAlternatives(), "rule__OpMulti__Alternatives");
					put(grammarAccess.getAUnaryOperationAccess().getAlternatives(), "rule__AUnaryOperation__Alternatives");
					put(grammarAccess.getOpUnaryAccess().getAlternatives(), "rule__OpUnary__Alternatives");
					put(grammarAccess.getAPrimaryExpressionAccess().getAlternatives(), "rule__APrimaryExpression__Alternatives");
					put(grammarAccess.getALiteralAccess().getAlternatives(), "rule__ALiteral__Alternatives");
					put(grammarAccess.getNumAltAccess().getAlternatives(), "rule__NumAlt__Alternatives");
					put(grammarAccess.getABooleanLiteralAccess().getAlternatives_1(), "rule__ABooleanLiteral__Alternatives_1");
					put(grammarAccess.getComponentCategoryAccess().getAlternatives(), "rule__ComponentCategory__Alternatives");
					put(grammarAccess.getNumberAccess().getAlternatives(), "rule__Number__Alternatives");
					put(grammarAccess.getNumberAccess().getAlternatives_1_0(), "rule__Number__Alternatives_1_0");
					put(grammarAccess.getNumberAccess().getAlternatives_1_1_1(), "rule__Number__Alternatives_1_1_1");
					put(grammarAccess.getVerificationPlanAccess().getGroup(), "rule__VerificationPlan__Group__0");
					put(grammarAccess.getVerificationPlanAccess().getGroup_3(), "rule__VerificationPlan__Group_3__0");
					put(grammarAccess.getVerificationPlanAccess().getGroup_7_3(), "rule__VerificationPlan__Group_7_3__0");
					put(grammarAccess.getClaimAccess().getGroup(), "rule__Claim__Group__0");
					put(grammarAccess.getClaimAccess().getGroup_2(), "rule__Claim__Group_2__0");
					put(grammarAccess.getClaimAccess().getGroup_3(), "rule__Claim__Group_3__0");
					put(grammarAccess.getClaimAccess().getGroup_5_0(), "rule__Claim__Group_5_0__0");
					put(grammarAccess.getClaimAccess().getGroup_5_1(), "rule__Claim__Group_5_1__0");
					put(grammarAccess.getClaimAccess().getGroup_5_4(), "rule__Claim__Group_5_4__0");
					put(grammarAccess.getThenEvidenceExprAccess().getGroup(), "rule__ThenEvidenceExpr__Group__0");
					put(grammarAccess.getThenEvidenceExprAccess().getGroup_1(), "rule__ThenEvidenceExpr__Group_1__0");
					put(grammarAccess.getThenEvidenceExprAccess().getGroup_1_0(), "rule__ThenEvidenceExpr__Group_1_0__0");
					put(grammarAccess.getThenEvidenceExprAccess().getGroup_1_0_0(), "rule__ThenEvidenceExpr__Group_1_0_0__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup(), "rule__SingleElseEvidenceExpr__Group__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1(), "rule__SingleElseEvidenceExpr__Group_1__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_0(), "rule__SingleElseEvidenceExpr__Group_1_0__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_0_0(), "rule__SingleElseEvidenceExpr__Group_1_0_0__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1(), "rule__SingleElseEvidenceExpr__Group_1_1_1__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1_1(), "rule__SingleElseEvidenceExpr__Group_1_1_1_1__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1_2(), "rule__SingleElseEvidenceExpr__Group_1_1_1_2__0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1_3(), "rule__SingleElseEvidenceExpr__Group_1_1_1_3__0");
					put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup(), "rule__CompositeElseEvidenceExpr__Group__0");
					put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup_1(), "rule__CompositeElseEvidenceExpr__Group_1__0");
					put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup_1_0(), "rule__CompositeElseEvidenceExpr__Group_1_0__0");
					put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup_1_0_0(), "rule__CompositeElseEvidenceExpr__Group_1_0_0__0");
					put(grammarAccess.getQuantifiedEvidenceExprAccess().getGroup(), "rule__QuantifiedEvidenceExpr__Group__0");
					put(grammarAccess.getQuantifiedEvidenceExprAccess().getGroup_4(), "rule__QuantifiedEvidenceExpr__Group_4__0");
					put(grammarAccess.getCompositeEvidenceExprAccess().getGroup_0(), "rule__CompositeEvidenceExpr__Group_0__0");
					put(grammarAccess.getVAReferenceAccess().getGroup(), "rule__VAReference__Group__0");
					put(grammarAccess.getVAReferenceAccess().getGroup_2(), "rule__VAReference__Group_2__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup(), "rule__VerificationActivity__Group__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_1(), "rule__VerificationActivity__Group_1__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_2(), "rule__VerificationActivity__Group_2__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_3(), "rule__VerificationActivity__Group_3__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_5(), "rule__VerificationActivity__Group_5__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_5_1(), "rule__VerificationActivity__Group_5_1__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_8(), "rule__VerificationActivity__Group_8__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_8_1(), "rule__VerificationActivity__Group_8_1__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_10(), "rule__VerificationActivity__Group_10__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_10_3(), "rule__VerificationActivity__Group_10_3__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_10_3_1(), "rule__VerificationActivity__Group_10_3_1__0");
					put(grammarAccess.getVerificationActivityAccess().getGroup_11(), "rule__VerificationActivity__Group_11__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup(), "rule__VerificationCondition__Group__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_0_0(), "rule__VerificationCondition__Group_0_0__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_0_1(), "rule__VerificationCondition__Group_0_1__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_2(), "rule__VerificationCondition__Group_2__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_4_1(), "rule__VerificationCondition__Group_4_1__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_4_1_2(), "rule__VerificationCondition__Group_4_1_2__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_4_1_2_1(), "rule__VerificationCondition__Group_4_1_2_1__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_4_1_4(), "rule__VerificationCondition__Group_4_1_4__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_4_1_4_3(), "rule__VerificationCondition__Group_4_1_4_3__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_4_1_4_3_1(), "rule__VerificationCondition__Group_4_1_4_3_1__0");
					put(grammarAccess.getVerificationConditionAccess().getGroup_4_1_5(), "rule__VerificationCondition__Group_4_1_5__0");
					put(grammarAccess.getVerificationMethodRegistryAccess().getGroup(), "rule__VerificationMethodRegistry__Group__0");
					put(grammarAccess.getVerificationMethodRegistryAccess().getGroup_3(), "rule__VerificationMethodRegistry__Group_3__0");
					put(grammarAccess.getVerificationMethodRegistryAccess().getGroup_5(), "rule__VerificationMethodRegistry__Group_5__0");
					put(grammarAccess.getFormalParameterAccess().getGroup(), "rule__FormalParameter__Group__0");
					put(grammarAccess.getFormalParameterAccess().getGroup_2(), "rule__FormalParameter__Group_2__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup(), "rule__VerificationMethod__Group__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_2(), "rule__VerificationMethod__Group_2__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_2_1(), "rule__VerificationMethod__Group_2_1__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_2_1_1(), "rule__VerificationMethod__Group_2_1_1__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_2_3(), "rule__VerificationMethod__Group_2_3__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_2_3_2(), "rule__VerificationMethod__Group_2_3_2__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_2_3_2_1(), "rule__VerificationMethod__Group_2_3_2_1__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_3(), "rule__VerificationMethod__Group_3__0");
					put(grammarAccess.getVerificationMethodAccess().getGroup_5_3(), "rule__VerificationMethod__Group_5_3__0");
					put(grammarAccess.getResoluteMethodAccess().getGroup(), "rule__ResoluteMethod__Group__0");
					put(grammarAccess.getJavaMethodAccess().getGroup(), "rule__JavaMethod__Group__0");
					put(grammarAccess.getManualMethodAccess().getGroup(), "rule__ManualMethod__Group__0");
					put(grammarAccess.getPluginMethodAccess().getGroup(), "rule__PluginMethod__Group__0");
					put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
					put(grammarAccess.getRationaleAccess().getGroup(), "rule__Rationale__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup(), "rule__Uncertainty__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_0(), "rule__Uncertainty__Group_2_0__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_1(), "rule__Uncertainty__Group_2_1__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_2(), "rule__Uncertainty__Group_2_2__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_3(), "rule__Uncertainty__Group_2_3__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_4(), "rule__Uncertainty__Group_2_4__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_5(), "rule__Uncertainty__Group_2_5__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_6(), "rule__Uncertainty__Group_2_6__0");
					put(grammarAccess.getValDeclarationAccess().getGroup(), "rule__ValDeclaration__Group__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_2_0(), "rule__ValDeclaration__Group_2_0__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_2_0_0(), "rule__ValDeclaration__Group_2_0_0__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup(), "rule__ComputeDeclaration__Group__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_2_0(), "rule__ComputeDeclaration__Group_2_0__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_2_0_0(), "rule__ComputeDeclaration__Group_2_0_0__0");
					put(grammarAccess.getAPropertyReferenceAccess().getGroup(), "rule__APropertyReference__Group__0");
					put(grammarAccess.getAVariableReferenceAccess().getGroup(), "rule__AVariableReference__Group__0");
					put(grammarAccess.getShowValueAccess().getGroup(), "rule__ShowValue__Group__0");
					put(grammarAccess.getShowValueAccess().getGroup_1(), "rule__ShowValue__Group_1__0");
					put(grammarAccess.getImageReferenceAccess().getGroup(), "rule__ImageReference__Group__0");
					put(grammarAccess.getIMGREFAccess().getGroup(), "rule__IMGREF__Group__0");
					put(grammarAccess.getIMGREFAccess().getGroup_0(), "rule__IMGREF__Group_0__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup(), "rule__AOrExpression__Group__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup_1(), "rule__AOrExpression__Group_1__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup_1_0(), "rule__AOrExpression__Group_1_0__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup_1_0_0(), "rule__AOrExpression__Group_1_0_0__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup(), "rule__AAndExpression__Group__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup_1(), "rule__AAndExpression__Group_1__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup_1_0(), "rule__AAndExpression__Group_1_0__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup_1_0_0(), "rule__AAndExpression__Group_1_0_0__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup(), "rule__AEqualityExpression__Group__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup_1(), "rule__AEqualityExpression__Group_1__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0(), "rule__AEqualityExpression__Group_1_0__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0_0(), "rule__AEqualityExpression__Group_1_0_0__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup(), "rule__ARelationalExpression__Group__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup_1(), "rule__ARelationalExpression__Group_1__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup_1_0(), "rule__ARelationalExpression__Group_1_0__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup_1_0_0(), "rule__ARelationalExpression__Group_1_0_0__0");
					put(grammarAccess.getOpCompareAccess().getGroup_1(), "rule__OpCompare__Group_1__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup(), "rule__AOtherOperatorExpression__Group__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup_1(), "rule__AOtherOperatorExpression__Group_1__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup_1_0(), "rule__AOtherOperatorExpression__Group_1_0__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup_1_0_0(), "rule__AOtherOperatorExpression__Group_1_0_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_2(), "rule__OpOther__Group_2__0");
					put(grammarAccess.getOpOtherAccess().getGroup_5(), "rule__OpOther__Group_5__0");
					put(grammarAccess.getOpOtherAccess().getGroup_5_1_0(), "rule__OpOther__Group_5_1_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_5_1_0_0(), "rule__OpOther__Group_5_1_0_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_6(), "rule__OpOther__Group_6__0");
					put(grammarAccess.getOpOtherAccess().getGroup_6_1_0(), "rule__OpOther__Group_6_1_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_6_1_0_0(), "rule__OpOther__Group_6_1_0_0__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup(), "rule__AAdditiveExpression__Group__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1(), "rule__AAdditiveExpression__Group_1__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0(), "rule__AAdditiveExpression__Group_1_0__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0(), "rule__AAdditiveExpression__Group_1_0_0__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup(), "rule__AMultiplicativeExpression__Group__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1(), "rule__AMultiplicativeExpression__Group_1__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0(), "rule__AMultiplicativeExpression__Group_1_0__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0(), "rule__AMultiplicativeExpression__Group_1_0_0__0");
					put(grammarAccess.getAUnaryOperationAccess().getGroup_0(), "rule__AUnaryOperation__Group_0__0");
					put(grammarAccess.getAIntegerTermAccess().getGroup(), "rule__AIntegerTerm__Group__0");
					put(grammarAccess.getARealTermAccess().getGroup(), "rule__ARealTerm__Group__0");
					put(grammarAccess.getANumericRangeTermAccess().getGroup(), "rule__ANumericRangeTerm__Group__0");
					put(grammarAccess.getANumericRangeTermAccess().getGroup_3(), "rule__ANumericRangeTerm__Group_3__0");
					put(grammarAccess.getASetTermAccess().getGroup(), "rule__ASetTerm__Group__0");
					put(grammarAccess.getASetTermAccess().getGroup_2(), "rule__ASetTerm__Group_2__0");
					put(grammarAccess.getASetTermAccess().getGroup_2_1(), "rule__ASetTerm__Group_2_1__0");
					put(grammarAccess.getAListTermAccess().getGroup(), "rule__AListTerm__Group__0");
					put(grammarAccess.getAListTermAccess().getGroup_3(), "rule__AListTerm__Group_3__0");
					put(grammarAccess.getAListTermAccess().getGroup_3_1(), "rule__AListTerm__Group_3_1__0");
					put(grammarAccess.getAParenthesizedExpressionAccess().getGroup(), "rule__AParenthesizedExpression__Group__0");
					put(grammarAccess.getABooleanLiteralAccess().getGroup(), "rule__ABooleanLiteral__Group__0");
					put(grammarAccess.getANullLiteralAccess().getGroup(), "rule__ANullLiteral__Group__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_8(), "rule__ComponentCategory__Group_8__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_10(), "rule__ComponentCategory__Group_10__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_12(), "rule__ComponentCategory__Group_12__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_13(), "rule__ComponentCategory__Group_13__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup(), "rule__AadlClassifierReference__Group__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1(), "rule__AadlClassifierReference__Group_1__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_2(), "rule__AadlClassifierReference__Group_2__0");
					put(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup(), "rule__AADLPROPERTYREFERENCE__Group__0");
					put(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup_1(), "rule__AADLPROPERTYREFERENCE__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getNumberAccess().getGroup_1(), "rule__Number__Group_1__0");
					put(grammarAccess.getNumberAccess().getGroup_1_1(), "rule__Number__Group_1_1__0");
					put(grammarAccess.getVerificationAccess().getContentsAssignment(), "rule__Verification__ContentsAssignment");
					put(grammarAccess.getVerificationPlanAccess().getNameAssignment_2(), "rule__VerificationPlan__NameAssignment_2");
					put(grammarAccess.getVerificationPlanAccess().getTitleAssignment_3_1(), "rule__VerificationPlan__TitleAssignment_3_1");
					put(grammarAccess.getVerificationPlanAccess().getSystemRequirementsAssignment_5(), "rule__VerificationPlan__SystemRequirementsAssignment_5");
					put(grammarAccess.getVerificationPlanAccess().getDescriptionAssignment_7_0(), "rule__VerificationPlan__DescriptionAssignment_7_0");
					put(grammarAccess.getVerificationPlanAccess().getClaimAssignment_7_1(), "rule__VerificationPlan__ClaimAssignment_7_1");
					put(grammarAccess.getVerificationPlanAccess().getRationaleAssignment_7_2(), "rule__VerificationPlan__RationaleAssignment_7_2");
					put(grammarAccess.getVerificationPlanAccess().getIssuesAssignment_7_3_1(), "rule__VerificationPlan__IssuesAssignment_7_3_1");
					put(grammarAccess.getClaimAccess().getRequirementAssignment_1(), "rule__Claim__RequirementAssignment_1");
					put(grammarAccess.getClaimAccess().getTitleAssignment_2_1(), "rule__Claim__TitleAssignment_2_1");
					put(grammarAccess.getClaimAccess().getWeightAssignment_3_1(), "rule__Claim__WeightAssignment_3_1");
					put(grammarAccess.getClaimAccess().getActivitiesAssignment_5_0_1(), "rule__Claim__ActivitiesAssignment_5_0_1");
					put(grammarAccess.getClaimAccess().getAssertAssignment_5_1_1(), "rule__Claim__AssertAssignment_5_1_1");
					put(grammarAccess.getClaimAccess().getRationaleAssignment_5_2(), "rule__Claim__RationaleAssignment_5_2");
					put(grammarAccess.getClaimAccess().getSubclaimAssignment_5_3(), "rule__Claim__SubclaimAssignment_5_3");
					put(grammarAccess.getClaimAccess().getIssuesAssignment_5_4_1(), "rule__Claim__IssuesAssignment_5_4_1");
					put(grammarAccess.getThenEvidenceExprAccess().getSuccessorAssignment_1_1(), "rule__ThenEvidenceExpr__SuccessorAssignment_1_1");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getErrorAssignment_1_1_0(), "rule__SingleElseEvidenceExpr__ErrorAssignment_1_1_0");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getFailAssignment_1_1_1_1_2(), "rule__SingleElseEvidenceExpr__FailAssignment_1_1_1_1_2");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getTimeoutAssignment_1_1_1_2_2(), "rule__SingleElseEvidenceExpr__TimeoutAssignment_1_1_1_2_2");
					put(grammarAccess.getSingleElseEvidenceExprAccess().getErrorAssignment_1_1_1_3_2(), "rule__SingleElseEvidenceExpr__ErrorAssignment_1_1_1_3_2");
					put(grammarAccess.getCompositeElseEvidenceExprAccess().getErrorAssignment_1_1(), "rule__CompositeElseEvidenceExpr__ErrorAssignment_1_1");
					put(grammarAccess.getQuantifiedEvidenceExprAccess().getElementsAssignment_3(), "rule__QuantifiedEvidenceExpr__ElementsAssignment_3");
					put(grammarAccess.getQuantifiedEvidenceExprAccess().getElementsAssignment_4_1(), "rule__QuantifiedEvidenceExpr__ElementsAssignment_4_1");
					put(grammarAccess.getVAReferenceAccess().getVerificationAssignment_1(), "rule__VAReference__VerificationAssignment_1");
					put(grammarAccess.getVAReferenceAccess().getWeightAssignment_2_1(), "rule__VAReference__WeightAssignment_2_1");
					put(grammarAccess.getVerificationActivityAccess().getNameAssignment_0(), "rule__VerificationActivity__NameAssignment_0");
					put(grammarAccess.getVerificationActivityAccess().getTitleAssignment_1_1(), "rule__VerificationActivity__TitleAssignment_1_1");
					put(grammarAccess.getVerificationActivityAccess().getTargetAssignment_2_1(), "rule__VerificationActivity__TargetAssignment_2_1");
					put(grammarAccess.getVerificationActivityAccess().getCategoryAssignment_3_1(), "rule__VerificationActivity__CategoryAssignment_3_1");
					put(grammarAccess.getVerificationActivityAccess().getResultAssignment_5_0(), "rule__VerificationActivity__ResultAssignment_5_0");
					put(grammarAccess.getVerificationActivityAccess().getResultAssignment_5_1_1(), "rule__VerificationActivity__ResultAssignment_5_1_1");
					put(grammarAccess.getVerificationActivityAccess().getMethodAssignment_6(), "rule__VerificationActivity__MethodAssignment_6");
					put(grammarAccess.getVerificationActivityAccess().getParametersAssignment_8_0(), "rule__VerificationActivity__ParametersAssignment_8_0");
					put(grammarAccess.getVerificationActivityAccess().getParametersAssignment_8_1_1(), "rule__VerificationActivity__ParametersAssignment_8_1_1");
					put(grammarAccess.getVerificationActivityAccess().getPropertyValuesAssignment_10_3_0(), "rule__VerificationActivity__PropertyValuesAssignment_10_3_0");
					put(grammarAccess.getVerificationActivityAccess().getPropertyValuesAssignment_10_3_1_1(), "rule__VerificationActivity__PropertyValuesAssignment_10_3_1_1");
					put(grammarAccess.getVerificationActivityAccess().getTimeoutAssignment_11_1(), "rule__VerificationActivity__TimeoutAssignment_11_1");
					put(grammarAccess.getVerificationConditionAccess().getNameAssignment_1(), "rule__VerificationCondition__NameAssignment_1");
					put(grammarAccess.getVerificationConditionAccess().getTitleAssignment_2_1(), "rule__VerificationCondition__TitleAssignment_2_1");
					put(grammarAccess.getVerificationConditionAccess().getDescriptionAssignment_4_0(), "rule__VerificationCondition__DescriptionAssignment_4_0");
					put(grammarAccess.getVerificationConditionAccess().getMethodAssignment_4_1_0(), "rule__VerificationCondition__MethodAssignment_4_1_0");
					put(grammarAccess.getVerificationConditionAccess().getParametersAssignment_4_1_2_0(), "rule__VerificationCondition__ParametersAssignment_4_1_2_0");
					put(grammarAccess.getVerificationConditionAccess().getParametersAssignment_4_1_2_1_1(), "rule__VerificationCondition__ParametersAssignment_4_1_2_1_1");
					put(grammarAccess.getVerificationConditionAccess().getPropertyValuesAssignment_4_1_4_3_0(), "rule__VerificationCondition__PropertyValuesAssignment_4_1_4_3_0");
					put(grammarAccess.getVerificationConditionAccess().getPropertyValuesAssignment_4_1_4_3_1_1(), "rule__VerificationCondition__PropertyValuesAssignment_4_1_4_3_1_1");
					put(grammarAccess.getVerificationConditionAccess().getTimeoutAssignment_4_1_5_1(), "rule__VerificationCondition__TimeoutAssignment_4_1_5_1");
					put(grammarAccess.getVerificationConditionAccess().getRationaleAssignment_4_2(), "rule__VerificationCondition__RationaleAssignment_4_2");
					put(grammarAccess.getVerificationMethodRegistryAccess().getNameAssignment_2(), "rule__VerificationMethodRegistry__NameAssignment_2");
					put(grammarAccess.getVerificationMethodRegistryAccess().getTitleAssignment_3_1(), "rule__VerificationMethodRegistry__TitleAssignment_3_1");
					put(grammarAccess.getVerificationMethodRegistryAccess().getDescriptionAssignment_5_0(), "rule__VerificationMethodRegistry__DescriptionAssignment_5_0");
					put(grammarAccess.getVerificationMethodRegistryAccess().getMethodsAssignment_5_1(), "rule__VerificationMethodRegistry__MethodsAssignment_5_1");
					put(grammarAccess.getFormalParameterAccess().getParameterTypeAssignment_0(), "rule__FormalParameter__ParameterTypeAssignment_0");
					put(grammarAccess.getFormalParameterAccess().getNameAssignment_1(), "rule__FormalParameter__NameAssignment_1");
					put(grammarAccess.getFormalParameterAccess().getUnitAssignment_2_1(), "rule__FormalParameter__UnitAssignment_2_1");
					put(grammarAccess.getVerificationMethodAccess().getNameAssignment_1(), "rule__VerificationMethod__NameAssignment_1");
					put(grammarAccess.getVerificationMethodAccess().getParamsAssignment_2_1_0(), "rule__VerificationMethod__ParamsAssignment_2_1_0");
					put(grammarAccess.getVerificationMethodAccess().getParamsAssignment_2_1_1_1(), "rule__VerificationMethod__ParamsAssignment_2_1_1_1");
					put(grammarAccess.getVerificationMethodAccess().getPropertiesAssignment_2_3_2_0(), "rule__VerificationMethod__PropertiesAssignment_2_3_2_0");
					put(grammarAccess.getVerificationMethodAccess().getPropertiesAssignment_2_3_2_1_1(), "rule__VerificationMethod__PropertiesAssignment_2_3_2_1_1");
					put(grammarAccess.getVerificationMethodAccess().getIsPredicateAssignment_2_4_0(), "rule__VerificationMethod__IsPredicateAssignment_2_4_0");
					put(grammarAccess.getVerificationMethodAccess().getIsResultReportAssignment_2_4_1(), "rule__VerificationMethod__IsResultReportAssignment_2_4_1");
					put(grammarAccess.getVerificationMethodAccess().getTitleAssignment_3_1(), "rule__VerificationMethod__TitleAssignment_3_1");
					put(grammarAccess.getVerificationMethodAccess().getMethodTypeAssignment_5_0(), "rule__VerificationMethod__MethodTypeAssignment_5_0");
					put(grammarAccess.getVerificationMethodAccess().getDescriptionAssignment_5_1(), "rule__VerificationMethod__DescriptionAssignment_5_1");
					put(grammarAccess.getVerificationMethodAccess().getConditionAssignment_5_2(), "rule__VerificationMethod__ConditionAssignment_5_2");
					put(grammarAccess.getVerificationMethodAccess().getCategoryAssignment_5_3_1(), "rule__VerificationMethod__CategoryAssignment_5_3_1");
					put(grammarAccess.getResoluteMethodAccess().getMethodReferenceAssignment_1(), "rule__ResoluteMethod__MethodReferenceAssignment_1");
					put(grammarAccess.getJavaMethodAccess().getMethodPathAssignment_1(), "rule__JavaMethod__MethodPathAssignment_1");
					put(grammarAccess.getManualMethodAccess().getDialogIDAssignment_2(), "rule__ManualMethod__DialogIDAssignment_2");
					put(grammarAccess.getPluginMethodAccess().getMethodIDAssignment_1(), "rule__PluginMethod__MethodIDAssignment_1");
					put(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1(), "rule__Description__DescriptionAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getTextAssignment_0(), "rule__DescriptionElement__TextAssignment_0");
					put(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_1(), "rule__DescriptionElement__ShowValueAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_2(), "rule__DescriptionElement__ThisTargetAssignment_2");
					put(grammarAccess.getDescriptionElementAccess().getImageAssignment_3(), "rule__DescriptionElement__ImageAssignment_3");
					put(grammarAccess.getRationaleAccess().getTextAssignment_1(), "rule__Rationale__TextAssignment_1");
					put(grammarAccess.getUncertaintyAccess().getVolatilityAssignment_2_0_1(), "rule__Uncertainty__VolatilityAssignment_2_0_1");
					put(grammarAccess.getUncertaintyAccess().getCostimpactAssignment_2_1_1(), "rule__Uncertainty__CostimpactAssignment_2_1_1");
					put(grammarAccess.getUncertaintyAccess().getScheduleimpactAssignment_2_2_1(), "rule__Uncertainty__ScheduleimpactAssignment_2_2_1");
					put(grammarAccess.getUncertaintyAccess().getFamiliarityAssignment_2_3_1(), "rule__Uncertainty__FamiliarityAssignment_2_3_1");
					put(grammarAccess.getUncertaintyAccess().getTimecriticalityAssignment_2_4_1(), "rule__Uncertainty__TimecriticalityAssignment_2_4_1");
					put(grammarAccess.getUncertaintyAccess().getRiskindexAssignment_2_5_1(), "rule__Uncertainty__RiskindexAssignment_2_5_1");
					put(grammarAccess.getUncertaintyAccess().getMaturityindexAssignment_2_6_1(), "rule__Uncertainty__MaturityindexAssignment_2_6_1");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_2_0_0_0(), "rule__ValDeclaration__TypeAssignment_2_0_0_0");
					put(grammarAccess.getValDeclarationAccess().getNameAssignment_2_0_0_1(), "rule__ValDeclaration__NameAssignment_2_0_0_1");
					put(grammarAccess.getValDeclarationAccess().getNameAssignment_2_1(), "rule__ValDeclaration__NameAssignment_2_1");
					put(grammarAccess.getValDeclarationAccess().getRightAssignment_4(), "rule__ValDeclaration__RightAssignment_4");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_2_0_0_0(), "rule__ComputeDeclaration__TypeAssignment_2_0_0_0");
					put(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2_0_0_1(), "rule__ComputeDeclaration__NameAssignment_2_0_0_1");
					put(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2_1(), "rule__ComputeDeclaration__NameAssignment_2_1");
					put(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2(), "rule__APropertyReference__PropertyAssignment_2");
					put(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1(), "rule__AVariableReference__VariableAssignment_1");
					put(grammarAccess.getShowValueAccess().getRefAssignment_0(), "rule__ShowValue__RefAssignment_0");
					put(grammarAccess.getShowValueAccess().getUnitAssignment_1_1(), "rule__ShowValue__UnitAssignment_1_1");
					put(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1(), "rule__ImageReference__ImgfileAssignment_1");
					put(grammarAccess.getAOrExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AOrExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAOrExpressionAccess().getRightOperandAssignment_1_1(), "rule__AOrExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAAndExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AAndExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAAndExpressionAccess().getRightOperandAssignment_1_1(), "rule__AAndExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAEqualityExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AEqualityExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAEqualityExpressionAccess().getRightOperandAssignment_1_1(), "rule__AEqualityExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getARelationalExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__ARelationalExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getARelationalExpressionAccess().getRightOperandAssignment_1_1(), "rule__ARelationalExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AOtherOperatorExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getRightOperandAssignment_1_1(), "rule__AOtherOperatorExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AAdditiveExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAAdditiveExpressionAccess().getRightOperandAssignment_1_1(), "rule__AAdditiveExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AMultiplicativeExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getRightOperandAssignment_1_1(), "rule__AMultiplicativeExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAUnaryOperationAccess().getFeatureAssignment_0_1(), "rule__AUnaryOperation__FeatureAssignment_0_1");
					put(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2(), "rule__AUnaryOperation__OperandAssignment_0_2");
					put(grammarAccess.getAIntegerTermAccess().getValueAssignment_0(), "rule__AIntegerTerm__ValueAssignment_0");
					put(grammarAccess.getAIntegerTermAccess().getUnitAssignment_1(), "rule__AIntegerTerm__UnitAssignment_1");
					put(grammarAccess.getARealTermAccess().getValueAssignment_0(), "rule__ARealTerm__ValueAssignment_0");
					put(grammarAccess.getARealTermAccess().getUnitAssignment_1(), "rule__ARealTerm__UnitAssignment_1");
					put(grammarAccess.getANumericRangeTermAccess().getMinimumAssignment_0(), "rule__ANumericRangeTerm__MinimumAssignment_0");
					put(grammarAccess.getANumericRangeTermAccess().getMaximumAssignment_2(), "rule__ANumericRangeTerm__MaximumAssignment_2");
					put(grammarAccess.getANumericRangeTermAccess().getDeltaAssignment_3_1(), "rule__ANumericRangeTerm__DeltaAssignment_3_1");
					put(grammarAccess.getASetTermAccess().getElementsAssignment_2_0(), "rule__ASetTerm__ElementsAssignment_2_0");
					put(grammarAccess.getASetTermAccess().getElementsAssignment_2_1_1(), "rule__ASetTerm__ElementsAssignment_2_1_1");
					put(grammarAccess.getAListTermAccess().getElementsAssignment_3_0(), "rule__AListTerm__ElementsAssignment_3_0");
					put(grammarAccess.getAListTermAccess().getElementsAssignment_3_1_1(), "rule__AListTerm__ElementsAssignment_3_1_1");
					put(grammarAccess.getABooleanLiteralAccess().getValueAssignment_1_0(), "rule__ABooleanLiteral__ValueAssignment_1_0");
					put(grammarAccess.getStringTermAccess().getValueAssignment(), "rule__StringTerm__ValueAssignment");
					put(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), "rule__VerificationPlan__UnorderedGroup_7");
					put(grammarAccess.getClaimAccess().getUnorderedGroup_5(), "rule__Claim__UnorderedGroup_5");
					put(grammarAccess.getVerificationConditionAccess().getUnorderedGroup_4(), "rule__VerificationCondition__UnorderedGroup_4");
					put(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_5(), "rule__VerificationMethod__UnorderedGroup_5");
					put(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), "rule__Uncertainty__UnorderedGroup_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyParser typedParser = (org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyParser) parser;
			typedParser.entryRuleVerification();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public VerifyGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(VerifyGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
