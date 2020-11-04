/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.gef.nodes;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * {@link ContainerShape} is a {@link Node} which contains children which are grouped into distinct categories.
 * The {@link Category} determines how the child is treated during layout.
 *
 * This node is intended to be a general used node that is used to present most undocked diagram elements.
 * A child node is considered docked if has a left, right, top, or bottom category assigned.
 *
 * The minimum size of the shape is such that all children must be sized to at least their minimum size.
 * Additionally, the minimum size includes the preferred size and preferred position of free and docked children.
 *
 * The preferred position of free and docked children can be set using {@link #setPrefPosition(Node, Point2D)}.
 * Free shapes will be positioned at the preferred position. Docked children may be positioned at a different
 * location based to avoid overlapping with existing children. For docked children, only the X or Y value is used
 * depending on the side to which the shape is docked.
 *
 * The preferred size is dependent on the configured size. If the shape has a configured size, then the preferred
 * size is the max of the configured size and the minimum size. If the shape does not have a configured size,
 * it is calculated based on the preferred position and sizes of children.
 **/
public class ContainerShape extends Parent {
	/**
	 * Key for the property for category of nodes.
	 */
	private static final Object CATEGORY_KEY = new Object();

	/**
	 * Key for the property for the preferred position of the node.
	 */
	private static final Object PREF_POSITION_KEY = new Object();

	/**
	 * Indicates that a value has not been specified. Used to indicate the lack of a configured width or height.
	 */
	public static double NOT_SPECIFIED = -1;

	/**
	 * Vertical padding on each side of the label region..
	 */
	private final double verticalLabelPadding = 3;

	/**
	 * Horizontal padding on each side of label region.
	 */
	private final double horizontalLabelPadding = 10;

	/**
	* Minimum value returned by {@link ContainerShape#computePrefWidth(double)}.
	* Chosen based on visual experiments. Typically, computed values will not be used. The graphical editor
	* will set a preferred size based on an incremental layout ELK.
	*/
	private final double MIN_COMPUTED_PREF_WIDTH = 140;

	/**
	 * Minimum value returned by {@link ContainerShape#computePrefHeight(double)}.
	 * Chosen based on visual experiments. Typically, computed values will not be used. The graphical editor
	 * will set a preferred size based on an incremental layout ELK.
	 */
	private final double MIN_COMPUTED_PREF_HEIGHT = 80;

	/**
	 * {@link Category} s a classification of a child which determines how it will be layed out. The category
	 * of a child is determined by the child list to which it is added. A child may be moved to another category
	 * by calling {@link ContainerShape#setCategory(Node, Category)}.
	 */
	public static enum Category {
		/**
		 * Graphics are positioned and sized to match the size of the region.
		 */
		GRAPHIC,

		/**
		 * Docked to the left side.
		 */
		LEFT,

		/**
		 * Docked to the right side
		 */
		RIGHT,

		/**
		 * Docked to the top side
		 */
		TOP,

		/**
		 * Docked to the bottom side
		 */
		BOTTOM,

		/**
		 * Labels are positioned based on the parent node's label configuration.
		 */
		LABEL,

		/**
		 * A child that may be freely positioned.
		 */
		FREE,
	}

	/**
	 * Support positions for label children.
	 */
	public enum LabelPosition {
		/**
		 * Left/Top
		 */
		BEGINNING,
		/**
		 * Horizontal/Vertical Middle
		 */
		CENTER,
		/**
		 * Right/Bottom
		 */
		END
	}

	private final ObservableList<Node> graphics = FXCollections.observableArrayList();
	private final ObservableList<Node> labels = FXCollections.observableArrayList();
	private final ObservableList<Node> leftChildren = FXCollections.observableArrayList();
	private final ObservableList<Node> rightChildren = FXCollections.observableArrayList();
	private final ObservableList<Node> topChildren = FXCollections.observableArrayList();
	private final ObservableList<Node> bottomChildren = FXCollections.observableArrayList();
	private final ObservableList<Node> freeChildren = FXCollections.observableArrayList();
	private LabelPosition horizontalLabelPosition = LabelPosition.CENTER;
	private LabelPosition verticalLabelPosition = LabelPosition.BEGINNING;

	/**
	 * The width of the shape. Set by container during layout by calling {@link #resize(double, double)
	 */
	private double width = 0;

	/**
	 * The height of the shape. Set by container during layout by calling {@link #resize(double, double)
	 */
	private double height = 0;

	/**
	 * The preferred width of the shape as specified by the the application.
	 * Used as the preferred width as long as it is greater than the minimum width.
	 */
	private double configuredWidth = NOT_SPECIFIED;

	/**
	 * The preferred height of the shape as specified by the the application.
	 * Used as the preferred height as long as it is greater than the minimum height.
	 */
	private double configuredHeight = NOT_SPECIFIED;

	/**
	 * Create a new {@link ContainerShape}.
	 */
	public ContainerShape() {
		// Add listeners to each exposed child list. These listeners are responsible for updating the node's
		// category and adding / removing children from the node's children list at the appropriate location.
		// Graphics have special handling to ensure that they are before other children.
		graphics.addListener(new GraphicListChangeListener());
		labels.addListener(new CategoryListChangeListener(Category.LABEL));
		leftChildren.addListener(new CategoryListChangeListener(Category.LEFT));
		rightChildren.addListener(new CategoryListChangeListener(Category.RIGHT));
		topChildren.addListener(new CategoryListChangeListener(Category.TOP));
		bottomChildren.addListener(new CategoryListChangeListener(Category.BOTTOM));
		freeChildren.addListener(new CategoryListChangeListener(Category.FREE));
	}

	public ObservableList<Node> getGraphics() {
		return graphics;
	}

	public ObservableList<Node> getLabels() {
		return labels;
	}

	public ObservableList<Node> getLeftChildren() {
		return leftChildren;
	}

	public ObservableList<Node> getRightChildren() {
		return rightChildren;
	}

	public ObservableList<Node> getTopChildren() {
		return topChildren;
	}

	public ObservableList<Node> getBottomChildren() {
		return bottomChildren;
	}

	public ObservableList<Node> getFreeChildren() {
		return freeChildren;
	}

	@Override
	public final boolean isResizable() {
		return true;
	}

	@Override
	public final void resize(double newWidth, double newHeight) {
		final boolean changed = width != newWidth || height != newHeight;
		if (changed) {
			width = newWidth;
			height = newHeight;

			// Trigger a layout
			setNeedsLayout(true);
			requestParentLayout();
		}
	}

	@Override
	protected void layoutChildren() {
		// Size and position graphics
		for (final Node graphic : graphics) {
			if (graphic.isManaged()) {
				graphic.resizeRelocate(0, 0, width, height);
			}
		}

		//
		// Size and position labels
		//
		double labelY = 0;
		switch (verticalLabelPosition) {
		case BEGINNING:
			labelY = verticalLabelPadding;
			break;
		case CENTER:
			labelY = Math.max(verticalLabelPadding, (height - prefLabelHeight(width)) / 2.0 + verticalLabelPadding);
			break;
		case END:
			labelY = Math.max(verticalLabelPadding, height - prefLabelHeight(width) + verticalLabelPadding);
			break;
		}

		// Position and size labels
		for (final Node child : labels) {
			if (child.isManaged()) {
				double childX = 0;
				final double childWidth = Math.min(width - 2.0 * horizontalLabelPadding, child.prefWidth(-1));
				switch (horizontalLabelPosition) {
				case BEGINNING:
					childX = horizontalLabelPadding;
					break;
				case CENTER:
					childX = (width - childWidth) / 2.0;
					break;
				case END:
					childX = width - childWidth - horizontalLabelPadding;
					break;
				}

				final double remainingHeight = Math.max(0, height - labelY);
				final double childHeight = Math.min(remainingHeight, child.prefHeight(childWidth));
				child.resizeRelocate(childX, labelY, childWidth, childHeight);
				labelY += childHeight;
			}
		}

		// Position and size free children
		for (final Node child : freeChildren) {
			if (child.isManaged()) {
				final Point2D position = getPreferredPositionOrDefault(child);
				child.resizeRelocate(position.getX(), position.getY(), child.prefWidth(-1), child.prefHeight(-1));
			}
		}
	};


	/**
	 * Returns the preferred position for the child. If the child does not have a preferred position, a default
	 * value of zero is returned.
	 * @param child is the child node to return the preferred position for.
	 * @return the preferred position.
	 */
	private Point2D getPreferredPositionOrDefault(final Node child) {
		final Point2D prefPosition = getPrefPosition(child);
		return prefPosition == null ? Point2D.ZERO : prefPosition;
	}

	/**
	 * Sets how labels are positioned horizontally.
	 * @param value the new horizontal label position
	 */
	public void setHorizontalLabelPosition(final LabelPosition value) {
		if (this.horizontalLabelPosition != value) {
			this.horizontalLabelPosition = value;
			setNeedsLayout(true);
		}
	}

	/**
	 * Sets how labels are positioned vertically.
	 * @param value the new vertical label position
	 */
	public void setVerticalLabelPosition(final LabelPosition value) {
		if (this.verticalLabelPosition != value) {
			this.verticalLabelPosition = value;
			setNeedsLayout(true);
		}
	}

	@Override
	protected double computePrefWidth(final double height) {
		return computePrefWidth(height, configuredWidth);
	}

	/**
	 * Computes the preferred width of the node. If a configured width is specified, then that value will be
	 * returned as long as it is not less than the minimum width. If the configured width is {@link #NOT_SPECIFIED}
	 * then it will be computed based on the category and preferred position and sizes of children.
	 *
	 * When calculating the preferred width during layout, this function is called
	 * with the configured which that has been specified by {@link #setConfiguredWidth(double)}
	 * @param height the height of the node.  See {@link #computePrefWidth(double)}
	 * @param configuredWidth is the configured width to use for computation.
	 * @return the preferred width.
	 */
	public double computePrefWidth(final double height, final double configuredWidth) {
		if (configuredWidth == NOT_SPECIFIED) {
			double result = Math.max(MIN_COMPUTED_PREF_WIDTH, configuredWidth);

			// Include the preferred with of the labels
			for (final Node label : labels) {
				if (label.isManaged()) {
					result = Math.max(result, label.prefWidth(-1));
				}
			}

			// Include the minimum width needed to include free children
			result = Math.max(result, computeMinWidthForFreeChildren());

			return result;
		} else {
			// Use the configured width as long as it is larger than the minimum width
			return Math.max(configuredWidth, minWidth(height));
		}
	}

	@Override
	protected double computePrefHeight(final double width) {
		return computePrefHeight(width, configuredHeight);
	}

	/**
	 * Computes the preferred height of the node. If a configured height is specified, then that value will be
	 * returned as long as it is not less than the minimum height. If the configured height is {@link #NOT_SPECIFIED}
	 * then it will be computed based on the category and preferred position and sizes of children.
	 *
	 * When calculating the preferred height during layout, this function is called
	 * with the configured which that has been specified by {@link #setConfiguredHeight(double)}
	 * @param height the height of the node.  See {@link #computePrefHeight(double)}
	 * @param configuredHeight is the configured height to use for computation.
	 * @return the preferred height.
	 */
	public double computePrefHeight(final double width, final double configuredHeight) {
		if (configuredHeight == NOT_SPECIFIED) {
			// Include the space needed for labels
			double result = Math.max(MIN_COMPUTED_PREF_HEIGHT, prefLabelHeight(width));

			// Include the minimum height needed to include free children
			result = Math.max(result, computeMinHeightForFreeChildren());

			return result;
		} else {
			return Math.max(configuredHeight, minHeight(width));
		}
	}

	@Override
	protected double computeMinWidth(final double height) {
		double result = 0;

		// Take into consideration minimum width of graphics
		for (final Node graphic : graphics) {
			if (graphic.isManaged()) {
				result = Math.max(result, graphic.minWidth(-1));
			}
		}

		// Take into consideration the minimum width of labels
		for (final Node label : labels) {
			if (label.isManaged()) {
				result = Math.max(result, label.minWidth(-1) - (2 * horizontalLabelPadding));
			}
		}

		// Include minimum width for free children
		result = Math.max(result, computeMinWidthForFreeChildren());

		return result;
	}

	@Override
	protected double computeMinHeight(final double width) {
		double result = 0;
		// Take into consideration min height of graphics
		for (final Node graphic : graphics) {
			if (graphic.isManaged()) {
				result = Math.max(result, graphic.minHeight(width));
			}
		}

		// Take into account the minimum space needed to have the minimum space for all labels. Please note that
		// the current layout algorithm will assign the first label the most space and then additional labels may
		// not have sufficient space available.
		double minLabelHeight = 0;
		for (final Node label : labels) {
			if (label.isManaged()) {
				minLabelHeight += label.minHeight(width);
			}
		}

		if (minLabelHeight > 0) {
			minLabelHeight += 2.0 * verticalLabelPadding;
		}

		result = Math.max(result, minLabelHeight);

		// Include minimum height for free children
		result = Math.max(result, computeMinHeightForFreeChildren());

		return result;
	}

	/**
	 * Returns the width needed by free children. This will match the X coordinate of the right most bound of all
	 * free children.
	 * @return the width needed by free children based on the positions and sizes of all free children.
	 */
	private final double computeMinWidthForFreeChildren() {
		double result = 0;
		for (final Node child : freeChildren) {
			if (child.isManaged()) {
				final Point2D childPosition = getPreferredPositionOrDefault(child);
				final double childWidth = child.prefWidth(-1);
				final double end = childPosition.getX() + childWidth;
				result = Math.max(result, end);
			}
		}
		return result;
	}

	/**
	 * Returns the height needed by free children. This will match the Y coordinate of the bottom most bound of all
	 * free children.
	 * @return the height needed by free children based on the positions and sizes of all free children.
	 */
	private final double computeMinHeightForFreeChildren() {
		double result = 0;
		for (final Node child : freeChildren) {
			if (child.isManaged()) {
				final Point2D childPosition = getPreferredPositionOrDefault(child);
				final double childHeight = child.prefHeight(-1);
				final double end = childPosition.getY() + childHeight;
				result = Math.max(result, end);
			}
		}
		return result;
	}

	@Override
	public final double maxWidth(double height) {
		return Double.MAX_VALUE;
	}

	@Override
	public final double maxHeight(double height) {
		return Double.MAX_VALUE;
	}

	/**
	 * Returns the height needed for labels.
	 * @param width the of the label block including padding. May be -1.
	 * @return the sum of the preferred height of all labels and padding.
	 */
	private double prefLabelHeight(double width) {
		final double labelWidth = width > 0 ? -1 : Math.max(width - 2 * horizontalLabelPadding, 0);
		double totalLabelHeight = 0;
		for (final Node label : labels) {
			if (label.isManaged()) {
				totalLabelHeight += label.prefHeight(labelWidth);
			}
		}

		if (totalLabelHeight > 0) {
			totalLabelHeight += 2.0 * verticalLabelPadding;
		}

		return totalLabelHeight;
	}

	/**
	 * Returns the list containing children with the specified category.
	 * @param category the category for which to return the list.
	 * @return is the modifiable list.
	 */
	private ObservableList<Node> childrenByCategory(final Category category) {
		switch (category) {
		case GRAPHIC:
			return graphics;
		case LABEL:
			return labels;
		case LEFT:
			return leftChildren;
		case RIGHT:
			return rightChildren;
		case TOP:
			return topChildren;
		case BOTTOM:
			return bottomChildren;
		case FREE:
			return freeChildren;
		default:
			throw new IllegalArgumentException("Invalid category: " + category);
		}
	}

	public void setConfiguredWidth(final double value) {
		this.configuredWidth = value;
	}

	public void setConfiguredHeight(final double value) {
		this.configuredHeight = value;
	}

	/**
	 * Returns the category for the node. The category determines how the child will be layed out. It is set based
	 * on the child list the node is added to. If the node is not a child of an {@link ContainerShape} the category
	 * will be null.
	 * @param node the node for which to retrieve the category.
	 * @return the node's category.
	 */
	private static Category getCategory(final Node node) {
		return (Category) node.getProperties().get(CATEGORY_KEY);
	}

	/**
	 * Sets the category of node which is a child of {@link ContainerShape}. The category is set when adding a node to
	 * the child so calling this function on a node which isn't a child of an {@link ContainerShape} is a no-op.
	 * @param node the node to set the category for
	 * @param value the new category
	 */
	public static void setCategory(final Node node, final Category value) {
		if (node.getParent() instanceof ContainerShape) {
			final ContainerShape parent = (ContainerShape) node.getParent();
			final Category oldValue = getCategory(node);
			if (value != oldValue) {
				if (oldValue != null) {
					parent.childrenByCategory(oldValue).remove(node);
				}

				if (value != null) {
					parent.childrenByCategory(value).add(node);
				}
			}
		}
	}

	/**
	 * Returns the preferred position of a node. If one has not been set, this will return null.
	 * @param node the node for which to retrieve the preferred position
	 * @return the node's preferred position.
	 */
	private static Point2D getPrefPosition(final Node node) {
		return (Point2D) node.getProperties().get(PREF_POSITION_KEY);
	}

	/**
	 * Sets the preferred position of a node. The preferred position is the position where the node should be placed.
	 * The layout algorithm will use it determine the actual position of the node.
	 * Only used for docked and free children.
	 * @param node the node for which to set the preferred position
	 * @param value the new preferred position
	 */
	public static void setPrefPosition(final Node node, final Point2D value) {
		final Point2D oldValue = getPrefPosition(node);
		if (!Objects.equals(value, oldValue)) {
			if (value == null) {
				node.getProperties().remove(PREF_POSITION_KEY, value);
			} else {
				node.getProperties().put(PREF_POSITION_KEY, value);
			}

			// Request that the parent reposition this child
			if (node.getParent() != null) {
				node.getParent().requestLayout();
			}
		}
	}

	/**
	 * Update the children list to contain the contents of the list for which changes are being listened.
	 * Updates the node's category. Nodes are added to the end of the children list.
	 * The ordering in the children list may not match the ordering the list for which changes are being listened.
	 */
	private class CategoryListChangeListener implements ListChangeListener<Node> {
		private Category category;

		/**
		 * Creates a new instance
		 * @param category is the category to assign to added nodes.
		 */
		CategoryListChangeListener(final Category category) {
			this.category = category;
		}

		@Override
		public void onChanged(Change<? extends Node> c) {
			while (c.next()) {
				for (final Node node : c.getRemoved()) {
					node.getProperties().remove(CATEGORY_KEY);
					getChildren().remove(node);
				}

				if (c.wasAdded()) {
					for (final Node node : c.getAddedSubList()) {
						node.getProperties().put(CATEGORY_KEY, category);
						getChildren().add(node);
					}
				}
			}
		}
	}

	/**
	 * Listener which ensures graphics appear at the start of the children list and are in the same order as they
	 * appear in the graphics list. Ensures graphic category is set when nodes are added to the graphics list.
	 */
	private class GraphicListChangeListener implements ListChangeListener<Node> {
		@Override
		public void onChanged(Change<? extends Node> c) {
			while (c.next()) {
				// Rearrange children to match the order in the graphics list.
				if (c.wasPermutated()) {
					// This process isn't efficient but it is simple. Will need to revisit if graphics are
					// sorted regularly.
					// Replace each changed element with new dummy groups. This is needed to avoid exceptions
					// caused by nodes appearing in multiple places in the list.
					for (int i = c.getFrom(); i < c.getTo(); ++i) {
						final int newIndex = c.getPermutation(i);
						if (i != newIndex) {
							getChildren().set(newIndex, new Group());
						}
					}

					// Replace the groups with the appropriate elements.
					for (int i = c.getFrom(); i < c.getTo(); ++i) {
						final int newIndex = c.getPermutation(i);
						if (i != newIndex) {
							getChildren().set(newIndex, c.getList().get(newIndex));
						}
					}
				}

				// Handle removals
				for (final Node node : c.getRemoved()) {
					node.getProperties().remove(CATEGORY_KEY);
					getChildren().remove(node);
				}

				// Handle additions
				if (c.wasAdded()) {
					// Add the nodes at the location in which they are located in the graphics node.
					for (int i = c.getFrom(); i < c.getTo(); i++) {
						final Node node = c.getList().get(i);
						node.getProperties().put(CATEGORY_KEY, Category.GRAPHIC);
						getChildren().add(i, node);
					}
				}
			}
		}
	}
}