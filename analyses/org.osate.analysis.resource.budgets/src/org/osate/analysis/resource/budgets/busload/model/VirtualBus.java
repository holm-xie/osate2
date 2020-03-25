package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ComponentInstance;

public final class VirtualBus extends AbstractBus {
	public VirtualBus(final ComponentInstance busInstance) {
		super(busInstance);
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitVirtualBusPrefix(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitVirtualBusPostfix(this);
	}
}
