/*
* generated by Xtext
*/
package org.osate.xtext.aadl2.properties.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

public class PropertiesParser extends AbstractContentAssistParser {
	
	@Inject
	private PropertiesGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.xtext.aadl2.properties.ui.contentassist.antlr.internal.InternalPropertiesParser createParser() {
		org.osate.xtext.aadl2.properties.ui.contentassist.antlr.internal.InternalPropertiesParser result = new org.osate.xtext.aadl2.properties.ui.contentassist.antlr.internal.InternalPropertiesParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getPropertySetAccess().getAlternatives_5(), "rule__PropertySet__Alternatives_5");
					put(grammarAccess.getUnnamedPropertyTypeAccess().getAlternatives(), "rule__UnnamedPropertyType__Alternatives");
					put(grammarAccess.getRecordFieldAccess().getAlternatives_2(), "rule__RecordField__Alternatives_2");
					put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_3(), "rule__PropertyDefinition__Alternatives_3");
					put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_8(), "rule__PropertyDefinition__Alternatives_8");
					put(grammarAccess.getPropertyConstantAccess().getAlternatives_3(), "rule__PropertyConstant__Alternatives_3");
					put(grammarAccess.getPropertyAssociationAccess().getAlternatives_1(), "rule__PropertyAssociation__Alternatives_1");
					put(grammarAccess.getPropertyAssociationAccess().getAlternatives_3(), "rule__PropertyAssociation__Alternatives_3");
					put(grammarAccess.getPropertyExpressionAccess().getAlternatives(), "rule__PropertyExpression__Alternatives");
					put(grammarAccess.getBooleanAtomAccess().getAlternatives(), "rule__BooleanAtom__Alternatives");
					put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
					put(grammarAccess.getContainmentPathElementAccess().getAlternatives(), "rule__ContainmentPathElement__Alternatives");
					put(grammarAccess.getSignedIntAccess().getAlternatives_0(), "rule__SignedInt__Alternatives_0");
					put(grammarAccess.getSignedRealAccess().getAlternatives_0(), "rule__SignedReal__Alternatives_0");
					put(grammarAccess.getOperationKindAccess().getAlternatives(), "rule__OperationKind__Alternatives");
					put(grammarAccess.getPropertySetAccess().getGroup(), "rule__PropertySet__Group__0");
					put(grammarAccess.getPropertySetAccess().getGroup_4(), "rule__PropertySet__Group_4__0");
					put(grammarAccess.getPropertySetAccess().getGroup_4_2(), "rule__PropertySet__Group_4_2__0");
					put(grammarAccess.getPropertyTypeAccess().getGroup(), "rule__PropertyType__Group__0");
					put(grammarAccess.getBooleanTypeAccess().getGroup(), "rule__BooleanType__Group__0");
					put(grammarAccess.getStringTypeAccess().getGroup(), "rule__StringType__Group__0");
					put(grammarAccess.getEnumerationTypeAccess().getGroup(), "rule__EnumerationType__Group__0");
					put(grammarAccess.getEnumerationTypeAccess().getGroup_3(), "rule__EnumerationType__Group_3__0");
					put(grammarAccess.getUnitsTypeAccess().getGroup(), "rule__UnitsType__Group__0");
					put(grammarAccess.getUnitsTypeAccess().getGroup_3(), "rule__UnitsType__Group_3__0");
					put(grammarAccess.getUnitLiteralConversionAccess().getGroup(), "rule__UnitLiteralConversion__Group__0");
					put(grammarAccess.getIntegerTypeAccess().getGroup(), "rule__IntegerType__Group__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup(), "rule__ClassifierType__Group__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup_2(), "rule__ClassifierType__Group_2__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup_2_1(), "rule__ClassifierType__Group_2_1__0");
					put(grammarAccess.getQCReferenceAccess().getGroup(), "rule__QCReference__Group__0");
					put(grammarAccess.getQCReferenceAccess().getGroup_0(), "rule__QCReference__Group_0__0");
					put(grammarAccess.getReferenceTypeAccess().getGroup(), "rule__ReferenceType__Group__0");
					put(grammarAccess.getReferenceTypeAccess().getGroup_1(), "rule__ReferenceType__Group_1__0");
					put(grammarAccess.getReferenceTypeAccess().getGroup_1_1(), "rule__ReferenceType__Group_1_1__0");
					put(grammarAccess.getRecordTypeAccess().getGroup(), "rule__RecordType__Group__0");
					put(grammarAccess.getRecordFieldAccess().getGroup(), "rule__RecordField__Group__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup(), "rule__PropertyDefinition__Group__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup_4(), "rule__PropertyDefinition__Group_4__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup_8_0(), "rule__PropertyDefinition__Group_8_0__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup_8_0_1(), "rule__PropertyDefinition__Group_8_0_1__0");
					put(grammarAccess.getPropertyConstantAccess().getGroup(), "rule__PropertyConstant__Group__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup(), "rule__PropertyAssociation__Group__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup_3_1(), "rule__PropertyAssociation__Group_3_1__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup_3_1_2(), "rule__PropertyAssociation__Group_3_1_2__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup_3_1_3(), "rule__PropertyAssociation__Group_3_1_3__0");
					put(grammarAccess.getModalPropertyValueAccess().getGroup(), "rule__ModalPropertyValue__Group__0");
					put(grammarAccess.getModalPropertyValueAccess().getGroup_5(), "rule__ModalPropertyValue__Group_5__0");
					put(grammarAccess.getOrTermAccess().getGroup(), "rule__OrTerm__Group__0");
					put(grammarAccess.getOrTermAccess().getGroup_1(), "rule__OrTerm__Group_1__0");
					put(grammarAccess.getAndTermAccess().getGroup(), "rule__AndTerm__Group__0");
					put(grammarAccess.getAndTermAccess().getGroup_1(), "rule__AndTerm__Group_1__0");
					put(grammarAccess.getNotTermAccess().getGroup(), "rule__NotTerm__Group__0");
					put(grammarAccess.getBooleanAtomAccess().getGroup_3(), "rule__BooleanAtom__Group_3__0");
					put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
					put(grammarAccess.getReferenceTermAccess().getGroup(), "rule__ReferenceTerm__Group__0");
					put(grammarAccess.getReferenceTermAccess().getGroup_3(), "rule__ReferenceTerm__Group_3__0");
					put(grammarAccess.getRecordTermAccess().getGroup(), "rule__RecordTerm__Group__0");
					put(grammarAccess.getComputedTermAccess().getGroup(), "rule__ComputedTerm__Group__0");
					put(grammarAccess.getComponentClassifierTermAccess().getGroup(), "rule__ComponentClassifierTerm__Group__0");
					put(grammarAccess.getListTermAccess().getGroup(), "rule__ListTerm__Group__0");
					put(grammarAccess.getListTermAccess().getGroup_2(), "rule__ListTerm__Group_2__0");
					put(grammarAccess.getBasicPropertyAssociationAccess().getGroup(), "rule__BasicPropertyAssociation__Group__0");
					put(grammarAccess.getContainmentPathElementAccess().getGroup_1(), "rule__ContainmentPathElement__Group_1__0");
					put(grammarAccess.getANNEXREFAccess().getGroup(), "rule__ANNEXREF__Group__0");
					put(grammarAccess.getIntegerTermAccess().getGroup(), "rule__IntegerTerm__Group__0");
					put(grammarAccess.getSignedIntAccess().getGroup(), "rule__SignedInt__Group__0");
					put(grammarAccess.getRealTermAccess().getGroup(), "rule__RealTerm__Group__0");
					put(grammarAccess.getSignedRealAccess().getGroup(), "rule__SignedReal__Group__0");
					put(grammarAccess.getREALAccess().getGroup(), "rule__REAL__Group__0");
					put(grammarAccess.getQNAMEAccess().getGroup(), "rule__QNAME__Group__0");
					put(grammarAccess.getPNAMEAccess().getGroup(), "rule__PNAME__Group__0");
					put(grammarAccess.getPNAMEAccess().getGroup_1(), "rule__PNAME__Group_1__0");
					put(grammarAccess.getQPREFAccess().getGroup(), "rule__QPREF__Group__0");
					put(grammarAccess.getQPREFAccess().getGroup_1(), "rule__QPREF__Group_1__0");
					put(grammarAccess.getQCREFAccess().getGroup(), "rule__QCREF__Group__0");
					put(grammarAccess.getQCREFAccess().getGroup_0(), "rule__QCREF__Group_0__0");
					put(grammarAccess.getQCREFAccess().getGroup_2(), "rule__QCREF__Group_2__0");
					put(grammarAccess.getPropertySetAccess().getNameAssignment_2(), "rule__PropertySet__NameAssignment_2");
					put(grammarAccess.getPropertySetAccess().getImportedPropertySetAssignment_4_1(), "rule__PropertySet__ImportedPropertySetAssignment_4_1");
					put(grammarAccess.getPropertySetAccess().getImportedPropertySetAssignment_4_2_1(), "rule__PropertySet__ImportedPropertySetAssignment_4_2_1");
					put(grammarAccess.getPropertySetAccess().getOwnedPropertyTypeAssignment_5_0(), "rule__PropertySet__OwnedPropertyTypeAssignment_5_0");
					put(grammarAccess.getPropertySetAccess().getOwnedPropertyAssignment_5_1(), "rule__PropertySet__OwnedPropertyAssignment_5_1");
					put(grammarAccess.getPropertySetAccess().getOwnedPropertyConstantAssignment_5_2(), "rule__PropertySet__OwnedPropertyConstantAssignment_5_2");
					put(grammarAccess.getPropertyTypeAccess().getNameAssignment_0(), "rule__PropertyType__NameAssignment_0");
					put(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralAssignment_2(), "rule__EnumerationType__OwnedLiteralAssignment_2");
					put(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralAssignment_3_1(), "rule__EnumerationType__OwnedLiteralAssignment_3_1");
					put(grammarAccess.getEnumerationLiteralAccess().getNameAssignment(), "rule__EnumerationLiteral__NameAssignment");
					put(grammarAccess.getUnitsTypeAccess().getOwnedLiteralAssignment_2(), "rule__UnitsType__OwnedLiteralAssignment_2");
					put(grammarAccess.getUnitsTypeAccess().getOwnedLiteralAssignment_3_1(), "rule__UnitsType__OwnedLiteralAssignment_3_1");
					put(grammarAccess.getUnitLiteralAccess().getNameAssignment(), "rule__UnitLiteral__NameAssignment");
					put(grammarAccess.getUnitLiteralConversionAccess().getNameAssignment_0(), "rule__UnitLiteralConversion__NameAssignment_0");
					put(grammarAccess.getUnitLiteralConversionAccess().getBaseUnitAssignment_2(), "rule__UnitLiteralConversion__BaseUnitAssignment_2");
					put(grammarAccess.getClassifierTypeAccess().getClassifierReferenceAssignment_2_0(), "rule__ClassifierType__ClassifierReferenceAssignment_2_0");
					put(grammarAccess.getClassifierTypeAccess().getClassifierReferenceAssignment_2_1_1(), "rule__ClassifierType__ClassifierReferenceAssignment_2_1_1");
					put(grammarAccess.getQCReferenceAccess().getAnnexNameAssignment_0_3(), "rule__QCReference__AnnexNameAssignment_0_3");
					put(grammarAccess.getQCReferenceAccess().getMetaclassNameAssignment_1(), "rule__QCReference__MetaclassNameAssignment_1");
					put(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceAssignment_1_0(), "rule__ReferenceType__NamedElementReferenceAssignment_1_0");
					put(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceAssignment_1_1_1(), "rule__ReferenceType__NamedElementReferenceAssignment_1_1_1");
					put(grammarAccess.getRecordTypeAccess().getOwnedFieldAssignment_2(), "rule__RecordType__OwnedFieldAssignment_2");
					put(grammarAccess.getRecordFieldAccess().getNameAssignment_0(), "rule__RecordField__NameAssignment_0");
					put(grammarAccess.getRecordFieldAccess().getTypeAssignment_2_0(), "rule__RecordField__TypeAssignment_2_0");
					put(grammarAccess.getRecordFieldAccess().getOwnedTypeAssignment_2_1(), "rule__RecordField__OwnedTypeAssignment_2_1");
					put(grammarAccess.getPropertyDefinitionAccess().getNameAssignment_0(), "rule__PropertyDefinition__NameAssignment_0");
					put(grammarAccess.getPropertyDefinitionAccess().getInheritAssignment_2(), "rule__PropertyDefinition__InheritAssignment_2");
					put(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_3_0(), "rule__PropertyDefinition__TypeAssignment_3_0");
					put(grammarAccess.getPropertyDefinitionAccess().getOwnedTypeAssignment_3_1(), "rule__PropertyDefinition__OwnedTypeAssignment_3_1");
					put(grammarAccess.getPropertyDefinitionAccess().getDefaultValueAssignment_4_1(), "rule__PropertyDefinition__DefaultValueAssignment_4_1");
					put(grammarAccess.getPropertyDefinitionAccess().getAppliesToAssignment_8_0_0(), "rule__PropertyDefinition__AppliesToAssignment_8_0_0");
					put(grammarAccess.getPropertyDefinitionAccess().getAppliesToAssignment_8_0_1_1(), "rule__PropertyDefinition__AppliesToAssignment_8_0_1_1");
					put(grammarAccess.getPropertyDefinitionAccess().getAppliesToAssignment_8_1(), "rule__PropertyDefinition__AppliesToAssignment_8_1");
					put(grammarAccess.getAllReferenceAccess().getMetaclassNameAssignment(), "rule__AllReference__MetaclassNameAssignment");
					put(grammarAccess.getClassifierValueAccess().getClassifierAssignment(), "rule__ClassifierValue__ClassifierAssignment");
					put(grammarAccess.getPropertyConstantAccess().getNameAssignment_0(), "rule__PropertyConstant__NameAssignment_0");
					put(grammarAccess.getPropertyConstantAccess().getTypeAssignment_3_0(), "rule__PropertyConstant__TypeAssignment_3_0");
					put(grammarAccess.getPropertyConstantAccess().getOwnedTypeAssignment_3_1(), "rule__PropertyConstant__OwnedTypeAssignment_3_1");
					put(grammarAccess.getPropertyAssociationAccess().getPropertyAssignment_0(), "rule__PropertyAssociation__PropertyAssignment_0");
					put(grammarAccess.getPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__PropertyAssociation__AppendAssignment_1_1");
					put(grammarAccess.getPropertyAssociationAccess().getConstantAssignment_2(), "rule__PropertyAssociation__ConstantAssignment_2");
					put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__PropertyAssociation__OwnedValueAssignment_3_0");
					put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__PropertyAssociation__OwnedValueAssignment_3_1_1");
					put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_1_2_1(), "rule__PropertyAssociation__OwnedValueAssignment_3_1_2_1");
					put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_1_3_1(), "rule__PropertyAssociation__OwnedValueAssignment_3_1_3_1");
					put(grammarAccess.getModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__ModalPropertyValue__OwnedValueAssignment_0");
					put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_4(), "rule__ModalPropertyValue__InModeAssignment_4");
					put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_5_1(), "rule__ModalPropertyValue__InModeAssignment_5_1");
					put(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment(), "rule__PropertyValue__OwnedValueAssignment");
					put(grammarAccess.getOrTermAccess().getOpAssignment_1_1(), "rule__OrTerm__OpAssignment_1_1");
					put(grammarAccess.getOrTermAccess().getOwnedPropertyExpressionAssignment_1_2(), "rule__OrTerm__OwnedPropertyExpressionAssignment_1_2");
					put(grammarAccess.getAndTermAccess().getOpAssignment_1_1(), "rule__AndTerm__OpAssignment_1_1");
					put(grammarAccess.getAndTermAccess().getOwnedPropertyExpressionAssignment_1_2(), "rule__AndTerm__OwnedPropertyExpressionAssignment_1_2");
					put(grammarAccess.getNotTermAccess().getOpAssignment_0(), "rule__NotTerm__OpAssignment_0");
					put(grammarAccess.getNotTermAccess().getOwnedPropertyExpressionAssignment_1(), "rule__NotTerm__OwnedPropertyExpressionAssignment_1");
					put(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0(), "rule__BooleanLiteral__ValueAssignment_1_0");
					put(grammarAccess.getConstantValueAccess().getConstantAssignment(), "rule__ConstantValue__ConstantAssignment");
					put(grammarAccess.getReferenceTermAccess().getContainmentPathElementAssignment_2(), "rule__ReferenceTerm__ContainmentPathElementAssignment_2");
					put(grammarAccess.getReferenceTermAccess().getContainmentPathElementAssignment_3_1(), "rule__ReferenceTerm__ContainmentPathElementAssignment_3_1");
					put(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1(), "rule__RecordTerm__OwnedFieldValueAssignment_1");
					put(grammarAccess.getComputedTermAccess().getFunctionAssignment_2(), "rule__ComputedTerm__FunctionAssignment_2");
					put(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2(), "rule__ComponentClassifierTerm__ClassifierAssignment_2");
					put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_1(), "rule__ListTerm__OwnedListElementAssignment_1");
					put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1(), "rule__ListTerm__OwnedListElementAssignment_2_1");
					put(grammarAccess.getBasicPropertyAssociationAccess().getPropertyAssignment_0(), "rule__BasicPropertyAssociation__PropertyAssignment_0");
					put(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__BasicPropertyAssociation__OwnedValueAssignment_2");
					put(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0(), "rule__ContainmentPathElement__NamedElementAssignment_0");
					put(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_1_1(), "rule__ContainmentPathElement__NamedElementAssignment_1_1");
					put(grammarAccess.getStringTermAccess().getValueAssignment(), "rule__StringTerm__ValueAssignment");
					put(grammarAccess.getIntegerTermAccess().getValueAssignment_0(), "rule__IntegerTerm__ValueAssignment_0");
					put(grammarAccess.getIntegerTermAccess().getUnitAssignment_1(), "rule__IntegerTerm__UnitAssignment_1");
					put(grammarAccess.getRealTermAccess().getValueAssignment_0(), "rule__RealTerm__ValueAssignment_0");
					put(grammarAccess.getRealTermAccess().getUnitAssignment_1(), "rule__RealTerm__UnitAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.xtext.aadl2.properties.ui.contentassist.antlr.internal.InternalPropertiesParser typedParser = (org.osate.xtext.aadl2.properties.ui.contentassist.antlr.internal.InternalPropertiesParser) parser;
			typedParser.entryRulePropertySet();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public PropertiesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(PropertiesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
