/*
* generated by Xtext
*/
package org.osate.alisa.workbench.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class AlisaGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class AlisaWorkAreaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AlisaWorkArea");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAlisaKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cCasesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cCasesAlternatives_2_0 = (Alternatives)cCasesAssignment_2.eContents().get(0);
		private final RuleCall cCasesAssurancePlanParserRuleCall_2_0_0 = (RuleCall)cCasesAlternatives_2_0.eContents().get(0);
		private final RuleCall cCasesAssuranceTaskParserRuleCall_2_0_1 = (RuleCall)cCasesAlternatives_2_0.eContents().get(1);
		
		//AlisaWorkArea:
		//	"alisa" name=ID cases+=(AssurancePlan | AssuranceTask)*;
		public ParserRule getRule() { return rule; }

		//"alisa" name=ID cases+=(AssurancePlan | AssuranceTask)*
		public Group getGroup() { return cGroup; }

		//"alisa"
		public Keyword getAlisaKeyword_0() { return cAlisaKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//cases+=(AssurancePlan | AssuranceTask)*
		public Assignment getCasesAssignment_2() { return cCasesAssignment_2; }

		//AssurancePlan | AssuranceTask
		public Alternatives getCasesAlternatives_2_0() { return cCasesAlternatives_2_0; }

		//AssurancePlan
		public RuleCall getCasesAssurancePlanParserRuleCall_2_0_0() { return cCasesAssurancePlanParserRuleCall_2_0_0; }

		//AssuranceTask
		public RuleCall getCasesAssuranceTaskParserRuleCall_2_0_1() { return cCasesAssuranceTaskParserRuleCall_2_0_1; }
	}

	public class AssurancePlanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AssurancePlan");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAssuranceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cPlanKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Keyword cForKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cSystemAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cSystemComponentImplementationCrossReference_5_0 = (CrossReference)cSystemAssignment_5.eContents().get(0);
		private final RuleCall cSystemComponentImplementationAadlClassifierReferenceParserRuleCall_5_0_1 = (RuleCall)cSystemComponentImplementationCrossReference_5_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final UnorderedGroup cUnorderedGroup_7 = (UnorderedGroup)cGroup.eContents().get(7);
		private final Group cGroup_7_0 = (Group)cUnorderedGroup_7.eContents().get(0);
		private final Keyword cDescriptionKeyword_7_0_0 = (Keyword)cGroup_7_0.eContents().get(0);
		private final Assignment cDescriptionAssignment_7_0_1 = (Assignment)cGroup_7_0.eContents().get(1);
		private final RuleCall cDescriptionDescriptionParserRuleCall_7_0_1_0 = (RuleCall)cDescriptionAssignment_7_0_1.eContents().get(0);
		private final Group cGroup_7_1 = (Group)cUnorderedGroup_7.eContents().get(1);
		private final Keyword cAssertKeyword_7_1_0 = (Keyword)cGroup_7_1.eContents().get(0);
		private final Assignment cPlansAssignment_7_1_1 = (Assignment)cGroup_7_1.eContents().get(1);
		private final CrossReference cPlansVerificationPlanCrossReference_7_1_1_0 = (CrossReference)cPlansAssignment_7_1_1.eContents().get(0);
		private final RuleCall cPlansVerificationPlanQualifiedNameParserRuleCall_7_1_1_0_1 = (RuleCall)cPlansVerificationPlanCrossReference_7_1_1_0.eContents().get(1);
		private final Group cGroup_7_2 = (Group)cUnorderedGroup_7.eContents().get(2);
		private final Keyword cAssumeKeyword_7_2_0 = (Keyword)cGroup_7_2.eContents().get(0);
		private final Keyword cVerifiedKeyword_7_2_1 = (Keyword)cGroup_7_2.eContents().get(1);
		private final Assignment cVerifiedAssumptionAssignment_7_2_2 = (Assignment)cGroup_7_2.eContents().get(2);
		private final CrossReference cVerifiedAssumptionComponentClassifierCrossReference_7_2_2_0 = (CrossReference)cVerifiedAssumptionAssignment_7_2_2.eContents().get(0);
		private final RuleCall cVerifiedAssumptionComponentClassifierAadlClassifierReferenceParserRuleCall_7_2_2_0_1 = (RuleCall)cVerifiedAssumptionComponentClassifierCrossReference_7_2_2_0.eContents().get(1);
		private final Group cGroup_7_3 = (Group)cUnorderedGroup_7.eContents().get(3);
		private final Keyword cFilterKeyword_7_3_0 = (Keyword)cGroup_7_3.eContents().get(0);
		private final Assignment cSelectionFilterAssignment_7_3_1 = (Assignment)cGroup_7_3.eContents().get(1);
		private final CrossReference cSelectionFilterSelectionCategoryCrossReference_7_3_1_0 = (CrossReference)cSelectionFilterAssignment_7_3_1.eContents().get(0);
		private final RuleCall cSelectionFilterSelectionCategoryIDTerminalRuleCall_7_3_1_0_1 = (RuleCall)cSelectionFilterSelectionCategoryCrossReference_7_3_1_0.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//AssurancePlan:
		//	"assurance" "plan" name=ID (":" title=STRING)? "for" system=[aadl2::ComponentImplementation|AadlClassifierReference]
		//	"[" (("description" description=Description)? & "assert" plans+=[Verify::VerificationPlan|QualifiedName]+ & ("assume"
		//	"verified" verifiedAssumption+=[aadl2::ComponentClassifier|AadlClassifierReference]+)? & ("filter"
		//	selectionFilter+=[categories::SelectionCategory]+)?) "]";
		public ParserRule getRule() { return rule; }

		//"assurance" "plan" name=ID (":" title=STRING)? "for" system=[aadl2::ComponentImplementation|AadlClassifierReference] "["
		//(("description" description=Description)? & "assert" plans+=[Verify::VerificationPlan|QualifiedName]+ & ("assume"
		//"verified" verifiedAssumption+=[aadl2::ComponentClassifier|AadlClassifierReference]+)? & ("filter"
		//selectionFilter+=[categories::SelectionCategory]+)?) "]"
		public Group getGroup() { return cGroup; }

		//"assurance"
		public Keyword getAssuranceKeyword_0() { return cAssuranceKeyword_0; }

		//"plan"
		public Keyword getPlanKeyword_1() { return cPlanKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//(":" title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//":"
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//"for"
		public Keyword getForKeyword_4() { return cForKeyword_4; }

		//system=[aadl2::ComponentImplementation|AadlClassifierReference]
		public Assignment getSystemAssignment_5() { return cSystemAssignment_5; }

		//[aadl2::ComponentImplementation|AadlClassifierReference]
		public CrossReference getSystemComponentImplementationCrossReference_5_0() { return cSystemComponentImplementationCrossReference_5_0; }

		//AadlClassifierReference
		public RuleCall getSystemComponentImplementationAadlClassifierReferenceParserRuleCall_5_0_1() { return cSystemComponentImplementationAadlClassifierReferenceParserRuleCall_5_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_6() { return cLeftSquareBracketKeyword_6; }

		//("description" description=Description)? & "assert" plans+=[Verify::VerificationPlan|QualifiedName]+ & ("assume"
		//"verified" verifiedAssumption+=[aadl2::ComponentClassifier|AadlClassifierReference]+)? & ("filter"
		//selectionFilter+=[categories::SelectionCategory]+)?
		public UnorderedGroup getUnorderedGroup_7() { return cUnorderedGroup_7; }

		//("description" description=Description)?
		public Group getGroup_7_0() { return cGroup_7_0; }

		//"description"
		public Keyword getDescriptionKeyword_7_0_0() { return cDescriptionKeyword_7_0_0; }

		//description=Description
		public Assignment getDescriptionAssignment_7_0_1() { return cDescriptionAssignment_7_0_1; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_7_0_1_0() { return cDescriptionDescriptionParserRuleCall_7_0_1_0; }

		//"assert" plans+=[Verify::VerificationPlan|QualifiedName]+
		public Group getGroup_7_1() { return cGroup_7_1; }

		//"assert"
		public Keyword getAssertKeyword_7_1_0() { return cAssertKeyword_7_1_0; }

		//plans+=[Verify::VerificationPlan|QualifiedName]+
		public Assignment getPlansAssignment_7_1_1() { return cPlansAssignment_7_1_1; }

		//[Verify::VerificationPlan|QualifiedName]
		public CrossReference getPlansVerificationPlanCrossReference_7_1_1_0() { return cPlansVerificationPlanCrossReference_7_1_1_0; }

		//QualifiedName
		public RuleCall getPlansVerificationPlanQualifiedNameParserRuleCall_7_1_1_0_1() { return cPlansVerificationPlanQualifiedNameParserRuleCall_7_1_1_0_1; }

		//("assume" "verified" verifiedAssumption+=[aadl2::ComponentClassifier|AadlClassifierReference]+)?
		public Group getGroup_7_2() { return cGroup_7_2; }

		//"assume"
		public Keyword getAssumeKeyword_7_2_0() { return cAssumeKeyword_7_2_0; }

		//"verified"
		public Keyword getVerifiedKeyword_7_2_1() { return cVerifiedKeyword_7_2_1; }

		//verifiedAssumption+=[aadl2::ComponentClassifier|AadlClassifierReference]+
		public Assignment getVerifiedAssumptionAssignment_7_2_2() { return cVerifiedAssumptionAssignment_7_2_2; }

		//[aadl2::ComponentClassifier|AadlClassifierReference]
		public CrossReference getVerifiedAssumptionComponentClassifierCrossReference_7_2_2_0() { return cVerifiedAssumptionComponentClassifierCrossReference_7_2_2_0; }

		//AadlClassifierReference
		public RuleCall getVerifiedAssumptionComponentClassifierAadlClassifierReferenceParserRuleCall_7_2_2_0_1() { return cVerifiedAssumptionComponentClassifierAadlClassifierReferenceParserRuleCall_7_2_2_0_1; }

		//("filter" selectionFilter+=[categories::SelectionCategory]+)?
		public Group getGroup_7_3() { return cGroup_7_3; }

		//"filter"
		public Keyword getFilterKeyword_7_3_0() { return cFilterKeyword_7_3_0; }

		//selectionFilter+=[categories::SelectionCategory]+
		public Assignment getSelectionFilterAssignment_7_3_1() { return cSelectionFilterAssignment_7_3_1; }

		//[categories::SelectionCategory]
		public CrossReference getSelectionFilterSelectionCategoryCrossReference_7_3_1_0() { return cSelectionFilterSelectionCategoryCrossReference_7_3_1_0; }

		//ID
		public RuleCall getSelectionFilterSelectionCategoryIDTerminalRuleCall_7_3_1_0_1() { return cSelectionFilterSelectionCategoryIDTerminalRuleCall_7_3_1_0_1; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class AssuranceTaskElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AssuranceTask");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAssuranceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cTaskKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Action cAssuranceTaskAction_2 = (Action)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cTitleAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cTitleAssignment_4_1.eContents().get(0);
		private final Keyword cOfKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cAssurancePlanAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cAssurancePlanAssurancePlanCrossReference_6_0 = (CrossReference)cAssurancePlanAssignment_6.eContents().get(0);
		private final RuleCall cAssurancePlanAssurancePlanIDTerminalRuleCall_6_0_1 = (RuleCall)cAssurancePlanAssurancePlanCrossReference_6_0.eContents().get(1);
		
		//AssuranceTask returns AssurancePlan:
		//	"assurance" "task" {AssuranceTask} name=ID (":" title=STRING)? "of" assurancePlan=[AssurancePlan];
		public ParserRule getRule() { return rule; }

		//"assurance" "task" {AssuranceTask} name=ID (":" title=STRING)? "of" assurancePlan=[AssurancePlan]
		public Group getGroup() { return cGroup; }

		//"assurance"
		public Keyword getAssuranceKeyword_0() { return cAssuranceKeyword_0; }

		//"task"
		public Keyword getTaskKeyword_1() { return cTaskKeyword_1; }

		//{AssuranceTask}
		public Action getAssuranceTaskAction_2() { return cAssuranceTaskAction_2; }

		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }

		//(":" title=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//":"
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//title=STRING
		public Assignment getTitleAssignment_4_1() { return cTitleAssignment_4_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_4_1_0() { return cTitleSTRINGTerminalRuleCall_4_1_0; }

		//"of"
		public Keyword getOfKeyword_5() { return cOfKeyword_5; }

		//assurancePlan=[AssurancePlan]
		public Assignment getAssurancePlanAssignment_6() { return cAssurancePlanAssignment_6; }

		//[AssurancePlan]
		public CrossReference getAssurancePlanAssurancePlanCrossReference_6_0() { return cAssurancePlanAssurancePlanCrossReference_6_0; }

		//ID
		public RuleCall getAssurancePlanAssurancePlanIDTerminalRuleCall_6_0_1() { return cAssurancePlanAssurancePlanIDTerminalRuleCall_6_0_1; }
	}

	public class DescriptionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Description");
		private final Assignment cDescriptionAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cDescriptionDescriptionElementParserRuleCall_0 = (RuleCall)cDescriptionAssignment.eContents().get(0);
		
		//Description:
		//	description+=DescriptionElement+;
		public ParserRule getRule() { return rule; }

		//description+=DescriptionElement+
		public Assignment getDescriptionAssignment() { return cDescriptionAssignment; }

		//DescriptionElement
		public RuleCall getDescriptionDescriptionElementParserRuleCall_0() { return cDescriptionDescriptionElementParserRuleCall_0; }
	}

	public class DescriptionElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DescriptionElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cTextAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cTextSTRINGTerminalRuleCall_0_0 = (RuleCall)cTextAssignment_0.eContents().get(0);
		private final Assignment cThisTargetAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cThisTargetThisKeyword_1_0 = (Keyword)cThisTargetAssignment_1.eContents().get(0);
		
		//DescriptionElement:
		//	text=STRING | thisTarget?="this";
		public ParserRule getRule() { return rule; }

		//text=STRING | thisTarget?="this"
		public Alternatives getAlternatives() { return cAlternatives; }

		//text=STRING
		public Assignment getTextAssignment_0() { return cTextAssignment_0; }

		//STRING
		public RuleCall getTextSTRINGTerminalRuleCall_0_0() { return cTextSTRINGTerminalRuleCall_0_0; }

		//thisTarget?="this"
		public Assignment getThisTargetAssignment_1() { return cThisTargetAssignment_1; }

		//"this"
		public Keyword getThisTargetThisKeyword_1_0() { return cThisTargetThisKeyword_1_0; }
	}

	public class AadlClassifierReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AadlClassifierReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cColonColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFullStopKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		
		//// Qualified classifier reference
		//AadlClassifierReference:
		//	ID "::" ID ("." ID)?;
		public ParserRule getRule() { return rule; }

		//ID "::" ID ("." ID)?
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//"::"
		public Keyword getColonColonKeyword_1() { return cColonColonKeyword_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_2() { return cIDTerminalRuleCall_2; }

		//("." ID)?
		public Group getGroup_3() { return cGroup_3; }

		//"."
		public Keyword getFullStopKeyword_3_0() { return cFullStopKeyword_3_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_3_1() { return cIDTerminalRuleCall_3_1; }
	}

	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//	ID ("." ID)?;
		public ParserRule getRule() { return rule; }

		//ID ("." ID)?
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("." ID)?
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}

	public class URIIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "URIID");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//URIID:
		//	STRING;
		public ParserRule getRule() { return rule; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}
	
	
	private final AlisaWorkAreaElements pAlisaWorkArea;
	private final AssurancePlanElements pAssurancePlan;
	private final AssuranceTaskElements pAssuranceTask;
	private final DescriptionElements pDescription;
	private final DescriptionElementElements pDescriptionElement;
	private final AadlClassifierReferenceElements pAadlClassifierReference;
	private final QualifiedNameElements pQualifiedName;
	private final URIIDElements pURIID;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public AlisaGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pAlisaWorkArea = new AlisaWorkAreaElements();
		this.pAssurancePlan = new AssurancePlanElements();
		this.pAssuranceTask = new AssuranceTaskElements();
		this.pDescription = new DescriptionElements();
		this.pDescriptionElement = new DescriptionElementElements();
		this.pAadlClassifierReference = new AadlClassifierReferenceElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.pURIID = new URIIDElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.alisa.workbench.Alisa".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//AlisaWorkArea:
	//	"alisa" name=ID cases+=(AssurancePlan | AssuranceTask)*;
	public AlisaWorkAreaElements getAlisaWorkAreaAccess() {
		return pAlisaWorkArea;
	}
	
	public ParserRule getAlisaWorkAreaRule() {
		return getAlisaWorkAreaAccess().getRule();
	}

	//AssurancePlan:
	//	"assurance" "plan" name=ID (":" title=STRING)? "for" system=[aadl2::ComponentImplementation|AadlClassifierReference]
	//	"[" (("description" description=Description)? & "assert" plans+=[Verify::VerificationPlan|QualifiedName]+ & ("assume"
	//	"verified" verifiedAssumption+=[aadl2::ComponentClassifier|AadlClassifierReference]+)? & ("filter"
	//	selectionFilter+=[categories::SelectionCategory]+)?) "]";
	public AssurancePlanElements getAssurancePlanAccess() {
		return pAssurancePlan;
	}
	
	public ParserRule getAssurancePlanRule() {
		return getAssurancePlanAccess().getRule();
	}

	//AssuranceTask returns AssurancePlan:
	//	"assurance" "task" {AssuranceTask} name=ID (":" title=STRING)? "of" assurancePlan=[AssurancePlan];
	public AssuranceTaskElements getAssuranceTaskAccess() {
		return pAssuranceTask;
	}
	
	public ParserRule getAssuranceTaskRule() {
		return getAssuranceTaskAccess().getRule();
	}

	//Description:
	//	description+=DescriptionElement+;
	public DescriptionElements getDescriptionAccess() {
		return pDescription;
	}
	
	public ParserRule getDescriptionRule() {
		return getDescriptionAccess().getRule();
	}

	//DescriptionElement:
	//	text=STRING | thisTarget?="this";
	public DescriptionElementElements getDescriptionElementAccess() {
		return pDescriptionElement;
	}
	
	public ParserRule getDescriptionElementRule() {
		return getDescriptionElementAccess().getRule();
	}

	//// Qualified classifier reference
	//AadlClassifierReference:
	//	ID "::" ID ("." ID)?;
	public AadlClassifierReferenceElements getAadlClassifierReferenceAccess() {
		return pAadlClassifierReference;
	}
	
	public ParserRule getAadlClassifierReferenceRule() {
		return getAadlClassifierReferenceAccess().getRule();
	}

	//QualifiedName:
	//	ID ("." ID)?;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//URIID:
	//	STRING;
	public URIIDElements getURIIDAccess() {
		return pURIID;
	}
	
	public ParserRule getURIIDRule() {
		return getURIIDAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}