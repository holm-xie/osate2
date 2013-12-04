package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.services.ShapeService;

public class SetConnectionBidirectionalityFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final ShapeService shapeService;
	private final BusinessObjectResolutionService bor;
	private final boolean bidirectionalValue;
	
	@Inject
	public SetConnectionBidirectionalityFeature(final AadlModificationService aadlModService, final ShapeService shapeService, final BusinessObjectResolutionService bor, 
			final IFeatureProvider fp, final @Named("Value") Boolean value) {
		super(fp);
		this.aadlModService = aadlModService;
		this.shapeService = shapeService;
		this.bor = bor;
		this.bidirectionalValue = value;
	}

	@Override
    public String getName() {
		return bidirectionalValue ? "Change to Bidirectional" : "Change to Unidirectional";
    }
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Connection)) {
			return false;
		}
		
		final Connection connection = (Connection)pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		final ComponentImplementation ci = getComponentImplementation(connection);
		
		return bo instanceof org.osate.aadl2.Connection && 
				((org.osate.aadl2.Connection)bo).isBidirectional() != bidirectionalValue && 
				((org.osate.aadl2.Connection)bo).getRefined() == null && 
				ci != null && 
				((org.osate.aadl2.Connection)bo).getContainingClassifier() == ci;
	}
    
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Connection connection) {
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return null;
		}
		
		return shapeService.getClosestBusinessObjectOfType((Shape)startContainer, ComponentImplementation.class);
	}
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
    
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(pe);
		aadlModService.modify(aadlConnection, new AbstractModifier<org.osate.aadl2.Connection, Object>() {
			@Override
			public Object modify(final Resource resource, final org.osate.aadl2.Connection aadlConnection) {
				aadlConnection.setBidirectional(bidirectionalValue);
				return null;
			}			
		});
	}
}
