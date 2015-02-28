/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.XPredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XPredicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.XPredicateImpl#getXpression <em>Xpression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XPredicateImpl extends ReqPredicateImpl implements XPredicate
{
  /**
   * The cached value of the '{@link #getXpression() <em>Xpression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXpression()
   * @generated
   * @ordered
   */
  protected XExpression xpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XPredicateImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReqSpecPackage.Literals.XPREDICATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getXpression()
  {
    return xpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetXpression(XExpression newXpression, NotificationChain msgs)
  {
    XExpression oldXpression = xpression;
    xpression = newXpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.XPREDICATE__XPRESSION, oldXpression, newXpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXpression(XExpression newXpression)
  {
    if (newXpression != xpression)
    {
      NotificationChain msgs = null;
      if (xpression != null)
        msgs = ((InternalEObject)xpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.XPREDICATE__XPRESSION, null, msgs);
      if (newXpression != null)
        msgs = ((InternalEObject)newXpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.XPREDICATE__XPRESSION, null, msgs);
      msgs = basicSetXpression(newXpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.XPREDICATE__XPRESSION, newXpression, newXpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReqSpecPackage.XPREDICATE__XPRESSION:
        return basicSetXpression(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReqSpecPackage.XPREDICATE__XPRESSION:
        return getXpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReqSpecPackage.XPREDICATE__XPRESSION:
        setXpression((XExpression)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReqSpecPackage.XPREDICATE__XPRESSION:
        setXpression((XExpression)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReqSpecPackage.XPREDICATE__XPRESSION:
        return xpression != null;
    }
    return super.eIsSet(featureID);
  }

} //XPredicateImpl