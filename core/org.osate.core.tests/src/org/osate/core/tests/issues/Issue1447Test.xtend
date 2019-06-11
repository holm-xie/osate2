package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.IntegerLiteral
import java.text.MessageFormat

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1447Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1447/"
	
	val static TEST_PS = "TestPS.aadl"
	
	val static SUBCOMPONENTS1 = "subcomponents1.aadl"
	val static SUBCOMPONENTS2 = "subcomponents2.aadl"
	val static SUBCOMPONENTS3 = "subcomponents3.aadl"
	val static SUBCOMPONENTS4 = "subcomponents4.aadl"
	val static SUBCOMPONENTS5 = "subcomponents5.aadl"
	val static SUBCOMPONENTS6 = "subcomponents6.aadl"

	val static FEATURES = "features";
	val static FEATURE_GROUP = "fg";
	val static EXTENSION = ".aadl"
	
	val static FEATURE_ERROR_TEMPLATE = "Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features{0}::{1}\" tries to replace it."
	val static FEATURE_GROUP_ERROR_TEMPLATE = "Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"fg{0}::{1}\" tries to replace it."

	val static A_I = "A.i"

	val static INSTANCE_NAME = "A_i_Instance"

	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testSubcomponents1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS1, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(0, messages.size)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(400L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testSubcomponents2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS2, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents2::C.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents2::B.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents2::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		/* Ideally the value should be -200L, but because the declarative model is actually erroneous (by containing
		 * associations that try to replace constant associations) the behavior cannot be trusted.  In this case,
		 * the instantiation process still picks up the contained association in C_i because it is in the same
		 * classifier that declares subcomponent s3.
		 */
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	// basically the same as test2
	@Test
	def void testSubcomponents3() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS3, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents3::C.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents3::B.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents3::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		/* Ideally the value should be -200L, but because the declarative model is actually erroneous (by containing
		 * associations that try to replace constant associations) the behavior cannot be trusted.  In this case,
		 * the instantiation process still picks up the contained association in C_i because it is in the same
		 * classifier that declares subcomponent s3.
		 */
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	// basically the same as test2
	@Test
	def void testSubcomponents4() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS4, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents4::C.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents4::B.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents4::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		/* Ideally the value should be -200L, but because the declarative model is actually erroneous (by containing
		 * associations that try to replace constant associations) the behavior cannot be trusted.  In this case,
		 * the instantiation process still picks up the contained association in C_i because it is in the same
		 * classifier that declares subcomponent s3.
		 */
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testSubcomponents5() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS5, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(2, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents5::B.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents5::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testSubcomponents6() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS6, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents6::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(300L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures1() {
		testFeatures(1, 90L);
	}
	
	@Test
	def void testFeatures2() {
		testFeatures(2, 0L, "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatures3() {
		testFeatures(3, 10L, "D2.i", "C.i", "B.i", "A.i")
	}	
	
	@Test
	def void testFeatures4() {
		testFeatures(4, 20L, "D2.i", "C.i", "B.i", "A.i")
	}	
	
	@Test
	def void testFeatures5() {
		testFeatures(5, 30L, "D2.i", "C.i", "B.i", "A.i")
	}	
	
	@Test
	def void testFeatures6() {
		testFeatures(6, 40L, "D2.i", "C.i", "B.i", "A.i")

	}
	
	@Test
	def void testFeatures7() {
		testFeatures(7, 50L, "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatures8() {
		testFeatures(8, 60L, "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatures9() {
		testFeatures(9, 70L, "B.i", "A.i")
	}
	
	@Test
	def void testFeatures10() {
		testFeatures(10, 80L, "A.i")
	}
	
	@Test
	def void testFeatures11() {
		testFeatures(11, 90L)
	}
	
	@Test
	def void testFeatureGroups1() {
		testFeatureGroups(1, 90L)
	}
	
	@Test
	def void testFeatureGroups2() {
		testFeatureGroups(2, 0L,  "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups3() {
		testFeatureGroups(3, 10L,  "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups4() {
		testFeatureGroups(4, 20L,  "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups5() {
		testFeatureGroups(5, 30L,  "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups6() {
		testFeatureGroups(6, 32L,  "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups7() {
		testFeatureGroups(7, 35L,  "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups8() {
		testFeatureGroups(8, 90L)
	}
	
	@Test
	def void testFeatureGroups9() {
		testFeatureGroups(9, 45L, "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups10() {
		testFeatureGroups(10, 50L, "D", "D2", "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups11() {
		testFeatureGroups(11, 55L, "D2.i", "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups12() {
		testFeatureGroups(12, 60L, "C.i", "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups13() {
		testFeatureGroups(13, 70L, "B.i", "A.i")
	}
	
	@Test
	def void testFeatureGroups14() {
		testFeatureGroups(14, 80L, "A.i")
	}
	
	@Test
	def void testFeatureGroups15() {
		testFeatureGroups(15, 90L)
	}

	private def void testFeatures(int idx, long propValue, String... errors) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES + idx + EXTENSION, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(errors.size, messages.size)
		for (var i = 0; i < errors.size; i++) {
			val err = errors.get(i)
			messages.get(i) => [
				assertEquals(f1, where)
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				assertEquals(MessageFormat.format(FEATURE_ERROR_TEMPLATE, idx, err), message)
			]
		}

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(propValue, (value as IntegerLiteral).value)
	}	

	private def void testFeatureGroups(int idx, long propValue, String... errors) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURE_GROUP + idx + EXTENSION, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val fg1 = s3.featureInstances.get(0)
		assertEquals("fg1", fg1.name)
		val f1 = fg1.featureInstances.get(0)
		assertEquals("f1", f1.name)
		
		assertEquals(errors.size, messages.size)
		for (var i = 0; i < errors.size; i++) {
			val err = errors.get(i)
			messages.get(i) => [
				assertEquals(f1, where)
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				assertEquals(MessageFormat.format(FEATURE_GROUP_ERROR_TEMPLATE, idx, err), message)
			]
		}

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(propValue, (value as IntegerLiteral).value)
	}	
}

