package org.osate.ge.tests;

import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.diagram.runtime.BuiltinContentsFilter;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.DiagramElementInformationProvider;

public class TestBusinessObjectModel implements DiagramElementInformationProvider, TreeUpdater {
	public TestBusinessObject model;
		
	long nextNodeId;
	
	@Override
	public BusinessObjectNode expandTree(DiagramConfiguration configuration, BusinessObjectNode tree, long nextNodeId) {
		final BusinessObjectNode newTree = new BusinessObjectNode(null, nextNodeId, null, null, false, BuiltinContentsFilter.ALLOW_FUNDAMENTAL, Completeness.UNKNOWN);
		this.nextNodeId = nextNodeId;
		createNodes(newTree, model.children);
		return newTree;
	}
	
	private void createNodes(final BusinessObjectNode parent, final TestBusinessObject[] bos) {
		for(final TestBusinessObject bo : bos) {
			final BusinessObjectNode newNode = new BusinessObjectNode(parent, ++nextNodeId, bo.getRelativeReference(), bo, false, BuiltinContentsFilter.ALLOW_ALL, Completeness.UNKNOWN);
			createNodes(newNode, bo.children);
		}
	}

	// DiagramElementInfoProvider
	@Override
	public String getName(final DiagramElement element) {
		return "ELEMENT: " + element.getRelativeReference().toString();
	}
	
	@Override
	public AgeGraphicalConfiguration getGraphicalConfiguration(final DiagramElement element) {
		return (AgeGraphicalConfiguration)GraphicalConfigurationBuilder.create().
			graphic(getGraphic(element)).
			defaultDockingPosition(getDefaultDockingPosition(element)).
			source(getConnectionStart(element)).
			destination(getConnectionEnd(element)).
			build();
	}
	
	private Graphic getGraphic(final DiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		if(testBo.isConnection) {
			return ConnectionBuilder.create().build();
		} else {
			return RectangleBuilder.create().build();
		}
	}
	
	private DockingPosition getDefaultDockingPosition(final DiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		return testBo.defaultDockingPosition;
	}
	
	private DiagramElement getConnectionStart(final DiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.connectionStartReference == null ? null : e.getContainer().getByRelativeReference(bo.connectionStartReference);
	}

	private DiagramElement getConnectionEnd(final DiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.connectionEndReference == null ? null : e.getContainer().getByRelativeReference(bo.connectionEndReference);
	}

	@Override
	public Object getApplicableBusinessObjectHandler(final Object bo) {
		return new Object(); // Return a dummy object
	}
}
