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
package org.osate.ge.gef;

import org.osate.ge.fx.DataPortNode;
import org.osate.ge.fx.NodeApplication;
import org.osate.ge.fx.RectangleNode;
import org.osate.ge.gef.nodes.ContainerShape;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;

// TODO: Rename?
public class ContainerShapeTest {
	private ContainerShapeTest() {
	}

	public static void main(final String[] args) {
		NodeApplication.run(() -> {
			//
			// Create Top Level Node
			//
			final ContainerShape top = new ContainerShape();
			top.getGraphics().setAll(new RectangleNode(true));

			//
			// Create Labels
			//
			final Label label1 = new Label("Top Node");
			final Label label2 = new Label("Longer single-line label. This should be truncated if there isn't space.");
			final Label label3 = new Label(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
			label3.setWrapText(true);
			top.getLabels().setAll(label1, label2, label3);

			//
			// Create Free Children
			//
			// TODO: Reenable
//			final ContainerShape freeChild1 = new ContainerShape();
//			freeChild1.getGraphics().setAll(new BusNode());
//			freeChild1.getLabels().setAll(new Label("Child Node #1"));
//			ContainerShape.setPrefPosition(freeChild1, new Point2D(50, 200));
//			top.getFreeChildren().add(freeChild1);
//
//			// TODO: Set position. Set an explicit preferred size
//			final ContainerShape freeChild2 = new ContainerShape();
//			freeChild2.setHorizontalLabelPosition(LabelPosition.CENTER);
//			freeChild2.setVerticalLabelPosition(LabelPosition.BEGINNING);
//			freeChild2.getGraphics().setAll(new BusNode());
//			freeChild2.getLabels().setAll(new Label("Child Node #2"));
//			top.getFreeChildren().add(freeChild2);
//			ContainerShape.setPrefPosition(freeChild2, new Point2D(100, 350));
//
//			// TODO: Suggest a size
//			freeChild2.setConfiguredWidth(300);
//			freeChild2.setConfiguredHeight(100);

			// TODO; Change node types to distinguish them
			// TODO: Create docked children(features)
			final Node leftChild1 = createDataPortNode(0);

			ContainerShape.setPrefPosition(leftChild1, new Point2D(0, 100));
			top.getLeftChildren().add(leftChild1);
			ContainerShape.setPrefPosition(leftChild1, new Point2D(0, 200));
			top.getLeftChildren().add(createDataPortNode(0));
			top.getLeftChildren().add(createDataPortNode(0));
			top.getRightChildren().add(createDataPortNode(180));
			top.getRightChildren().add(createDataPortNode(180));
			top.getTopChildren().add(createDataPortNode(90));
			top.getTopChildren().add(createDataPortNode(90));
			top.getBottomChildren().add(createDataPortNode(-90));
			top.getBottomChildren().add(createDataPortNode(-90));

			// TODO: Top
			// TODO: Bottom
			// TODO; Preferred position for docked children

//			final FeatureNode leftChild1 = new FeatureNode();
//			leftChild1.getGraphics().setAll(new DataPortNode());
//			leftChild1.getLabels().setAll(new Label("i1"));
//			top.getLeftChildren().add(leftChild1);

			// TODO: Experiment with longer nodes as well

			// TODO; Create nested docked children(feature groups)
			// TODO: Add connections to docked and undocked.

			return top;
		});
	}

	// TODO; Rename. Decide where pref width and height should be determined. Returns a wrapper that exposes the
	// post rotation(if any) sizing.
	private static Node createDataPortNode(final double rotation) {
		final DataPortNode n = new DataPortNode();
		n.setPrefWidth(20);
		n.setPrefHeight(16);
		n.setRotate(rotation);

		final Group g = new Group();
		g.getChildren().add(n);
		return g;
	}
}
