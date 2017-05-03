package org.osate.ge.internal.diagram.boTree;

import org.osate.ge.internal.diagram.DiagramConfiguration;

public interface TreeExpander {
	/**
	 * Creates a new business object tree expanded based on the current state and the diagram configuration.
	 * The tree expander is requed to fill in any required fields on the business object nodes.
	 * @param configuration
	 * @param tree
	 * @return
	 */
	BusinessObjectNode expandTree(final DiagramConfiguration configuration, BusinessObjectNode tree);
}
