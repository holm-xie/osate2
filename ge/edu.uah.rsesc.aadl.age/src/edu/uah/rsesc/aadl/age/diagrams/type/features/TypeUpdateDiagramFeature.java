package edu.uah.rsesc.aadl.age.diagrams.type.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICustomUndoableFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;
import edu.uah.rsesc.aadl.age.util.Log;

public class TypeUpdateDiagramFeature extends AbstractUpdateFeature implements ICustomUndoableFeature {

	public TypeUpdateDiagramFeature(final IFeatureProvider fp) {
		super(fp);
	}

	private Classifier getClassifier(final IUpdateContext context) {
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getPictogramElement()));
		if(bo instanceof ComponentType || bo instanceof FeatureGroupType) {
			return (Classifier)bo;
		}
		
		return null;
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return getClassifier(context) != null;
	}

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createTrueReason("");
	}

	@Override
	public boolean update(final IUpdateContext context) {
		Log.info("called with context: " + context);
		final Classifier classifier = getClassifier(context);
	//	System.out.println(classifier);

		final Diagram diagram = getDiagram();	
		// TODO: Easier to put the features on the sides?
		// How to snap?		
		
		// Remove all styles. Styles will be recreated as needed when the graphics algorithms are rebuilt.
		diagram.getStyles().clear();	
				
		// Remove shapes that are invalid
		UpdateHelper.removeInvalidShapes(diagram, getFeatureProvider());

		// Add/Update the shape for the classifier
		{
			final AddContext addContext = new AddContext();
			addContext.setNewObject(new AadlElementWrapper(classifier));
			addContext.setTargetContainer(diagram);
			addContext.setX(50);
			addContext.setY(20);
			addContext.setWidth(500);
			addContext.setHeight(500);
			final IAddFeature feature = this.getFeatureProvider().getAddFeature(addContext);
			if(feature != null && feature.canAdd(addContext)) {
				feature.execute(addContext);
			}
			// TODO: Handle update instead of always adding
		}

		return false;
	}

	@Override
	public void undo(final IContext context) {
	}

	@Override
	public boolean canRedo(final IContext context) {
		return false;
	}

	@Override
	public void redo(final IContext context) {	
	}
}
