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
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.instance.impl.AnnexInstanceImpl;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Annex Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getComposites <em>Composites</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2AnnexInstanceImpl extends AnnexInstanceImpl implements EMV2AnnexInstance {
	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<StateTransitionInstance> transitions;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<EventInstance> events;

	/**
	 * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachineInstance stateMachine;

	/**
	 * The cached value of the '{@link #getBehaviors() <em>Behaviors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviors()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorInstance> behaviors;

	/**
	 * The cached value of the '{@link #getComposites() <em>Composites</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposites()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeStateInstance> composites;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstrainedInstanceObject> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMV2AnnexInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.EMV2_ANNEX_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StateTransitionInstance> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<StateTransitionInstance>(StateTransitionInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventInstance> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<EventInstance>(EventInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachineInstance getStateMachine() {
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateMachine(StateMachineInstance newStateMachine, NotificationChain msgs) {
		StateMachineInstance oldStateMachine = stateMachine;
		stateMachine = newStateMachine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, oldStateMachine, newStateMachine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStateMachine(StateMachineInstance newStateMachine) {
		if (newStateMachine != stateMachine) {
			NotificationChain msgs = null;
			if (stateMachine != null)
				msgs = ((InternalEObject)stateMachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, null, msgs);
			if (newStateMachine != null)
				msgs = ((InternalEObject)newStateMachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, null, msgs);
			msgs = basicSetStateMachine(newStateMachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, newStateMachine, newStateMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BehaviorInstance> getBehaviors() {
		if (behaviors == null) {
			behaviors = new EObjectContainmentEList<BehaviorInstance>(BehaviorInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__BEHAVIORS);
		}
		return behaviors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CompositeStateInstance> getComposites() {
		if (composites == null) {
			composites = new EObjectContainmentEList<CompositeStateInstance>(CompositeStateInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES);
		}
		return composites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConstrainedInstanceObject> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<ConstrainedInstanceObject>(ConstrainedInstanceObject.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				return basicSetStateMachine(null, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__BEHAVIORS:
				return ((InternalEList<?>)getBehaviors()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				return ((InternalEList<?>)getComposites()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				return getTransitions();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				return getEvents();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				return getStateMachine();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__BEHAVIORS:
				return getBehaviors();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				return getComposites();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ACTIONS:
				return getActions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends StateTransitionInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends EventInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				setStateMachine((StateMachineInstance)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__BEHAVIORS:
				getBehaviors().clear();
				getBehaviors().addAll((Collection<? extends BehaviorInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				getComposites().clear();
				getComposites().addAll((Collection<? extends CompositeStateInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ConstrainedInstanceObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				getTransitions().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				getEvents().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				setStateMachine((StateMachineInstance)null);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__BEHAVIORS:
				getBehaviors().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				getComposites().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ACTIONS:
				getActions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				return events != null && !events.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				return stateMachine != null;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__BEHAVIORS:
				return behaviors != null && !behaviors.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				return composites != null && !composites.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EMV2AnnexInstanceImpl
