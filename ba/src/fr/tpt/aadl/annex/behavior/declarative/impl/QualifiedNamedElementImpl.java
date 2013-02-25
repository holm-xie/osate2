/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative.impl ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.Mode ;
import org.osate.aadl2.ModeTransition ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.impl.DataClassifierImpl ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.Value ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant ;
import fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorElement ;
import fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage ;
import fr.tpt.aadl.annex.behavior.declarative.Identifier ;
import fr.tpt.aadl.annex.behavior.declarative.QualifiedNamedElement ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.impl.QualifiedNamedElementImpl#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.impl.QualifiedNamedElementImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.impl.QualifiedNamedElementImpl#getBaNamespace <em>Ba Namespace</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.impl.QualifiedNamedElementImpl#getBaName <em>Ba Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedNamedElementImpl extends DataClassifierImpl implements
                                                                 QualifiedNamedElement
{
  /**
   * The cached value of the '{@link #getOsateRef() <em>Osate Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOsateRef()
   * @generated
   * @ordered
   */
  protected Element osateRef ;

  /**
   * The cached value of the '{@link #getBaRef() <em>Ba Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaRef()
   * @generated
   * @ordered
   */
  protected BehaviorElement baRef ;

  /**
   * The cached value of the '{@link #getBaNamespace() <em>Ba Namespace</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaNamespace()
   * @generated
   * @ordered
   */
  protected Identifier baNamespace ;

  /**
   * The cached value of the '{@link #getBaName() <em>Ba Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaName()
   * @generated
   * @ordered
   */
  protected Identifier baName ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedNamedElementImpl()
  {
    super() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DeclarativePackage.Literals.QUALIFIED_NAMED_ELEMENT ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getOsateRef()
  {
    if(osateRef != null && ((EObject) osateRef).eIsProxy())
    {
      InternalEObject oldOsateRef = (InternalEObject) osateRef ;
      osateRef = (Element) eResolveProxy(oldOsateRef) ;
      if(osateRef != oldOsateRef)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF,
                oldOsateRef, osateRef)) ;
      }
    }
    return osateRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element basicGetOsateRef()
  {
    return osateRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOsateRef(Element newOsateRef)
  {
    Element oldOsateRef = osateRef ;
    osateRef = newOsateRef ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
            DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF, oldOsateRef,
            osateRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorElement getBaRef()
  {
    if(baRef != null && ((EObject) baRef).eIsProxy())
    {
      InternalEObject oldBaRef = (InternalEObject) baRef ;
      baRef = (BehaviorElement) eResolveProxy(oldBaRef) ;
      if(baRef != oldBaRef)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF, oldBaRef,
                baRef)) ;
      }
    }
    return baRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorElement basicGetBaRef()
  {
    return baRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaRef(BehaviorElement newBaRef)
  {
    BehaviorElement oldBaRef = baRef ;
    baRef = newBaRef ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
            DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF, oldBaRef, baRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier getBaNamespace()
  {
    return baNamespace ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaNamespace(Identifier newBaNamespace,
                                               NotificationChain msgs)
  {
    Identifier oldBaNamespace = baNamespace ;
    baNamespace = newBaNamespace ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification =
            new ENotificationImpl(this, Notification.SET,
                  DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
                  oldBaNamespace, newBaNamespace) ;
      if(msgs == null)
        msgs = notification ;
      else
        msgs.add(notification) ;
    }
    return msgs ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaNamespace(Identifier newBaNamespace)
  {
    if(newBaNamespace != baNamespace)
    {
      NotificationChain msgs = null ;
      if(baNamespace != null)
        msgs =
              ((InternalEObject) baNamespace)
                    .eInverseRemove(this,
                                    EOPPOSITE_FEATURE_BASE -
                                          DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
                                    null, msgs) ;
      if(newBaNamespace != null)
        msgs =
              ((InternalEObject) newBaNamespace)
                    .eInverseAdd(this,
                                 EOPPOSITE_FEATURE_BASE -
                                       DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
                                 null, msgs) ;
      msgs = basicSetBaNamespace(newBaNamespace, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
            DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
            newBaNamespace, newBaNamespace)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier getBaName()
  {
    return baName ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaName(Identifier newBaName,
                                          NotificationChain msgs)
  {
    Identifier oldBaName = baName ;
    baName = newBaName ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification =
            new ENotificationImpl(this, Notification.SET,
                  DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME,
                  oldBaName, newBaName) ;
      if(msgs == null)
        msgs = notification ;
      else
        msgs.add(notification) ;
    }
    return msgs ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaName(Identifier newBaName)
  {
    if(newBaName != baName)
    {
      NotificationChain msgs = null ;
      if(baName != null)
        msgs =
              ((InternalEObject) baName)
                    .eInverseRemove(this,
                                    EOPPOSITE_FEATURE_BASE -
                                          DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME,
                                    null, msgs) ;
      if(newBaName != null)
        msgs =
              ((InternalEObject) newBaName)
                    .eInverseAdd(this,
                                 EOPPOSITE_FEATURE_BASE -
                                       DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME,
                                 null, msgs) ;
      msgs = basicSetBaName(newBaName, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
            DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME, newBaName,
            newBaName)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd,
                                          int featureID,
                                          NotificationChain msgs)
  {
    switch ( featureID )
    {
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        return basicSetBaNamespace(null, msgs) ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        return basicSetBaName(null, msgs) ;
    }
    return super.eInverseRemove(otherEnd, featureID, msgs) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID,
                     boolean resolve,
                     boolean coreType)
  {
    switch ( featureID )
    {
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        if(resolve)
          return getOsateRef() ;
        return basicGetOsateRef() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        if(resolve)
          return getBaRef() ;
        return basicGetBaRef() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        return getBaNamespace() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        return getBaName() ;
    }
    return super.eGet(featureID, resolve, coreType) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID,
                   Object newValue)
  {
    switch ( featureID )
    {
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        setOsateRef((Element) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        setBaRef((BehaviorElement) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        setBaNamespace((Identifier) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        setBaName((Identifier) newValue) ;
        return ;
    }
    super.eSet(featureID, newValue) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch ( featureID )
    {
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        setOsateRef((Element) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        setBaRef((BehaviorElement) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        setBaNamespace((Identifier) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        setBaName((Identifier) null) ;
        return ;
    }
    super.eUnset(featureID) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch ( featureID )
    {
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        return osateRef != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        return baRef != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        return baNamespace != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        return baName != null ;
    }
    return super.eIsSet(featureID) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID,
                                      Class<?> baseClass)
  {
    if(baseClass == BehaviorElement.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DeclarativeBehaviorElement.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF ;
        default :
          return -1 ;
      }
    }
    if(baseClass == Value.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ValueConstant.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValue.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValueConstant.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID,
                                         Class<?> baseClass)
  {
    if(baseClass == BehaviorElement.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DeclarativeBehaviorElement.class)
    {
      switch ( baseFeatureID )
      {
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF ;
        default :
          return -1 ;
      }
    }
    if(baseClass == Value.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ValueConstant.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValue.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValueConstant.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass) ;
  }

  @Override
  public ComponentCategory getCategory()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<Mode> getAllModes()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<ModeTransition> getAllModeTransitions()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<Prototype> getAllPrototypes()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public Classifier getExtended()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<Feature> getAllFeatures()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public boolean isDescendentOf(Classifier c)
  {
    // TODO Auto-generated method stub
    return false ;
  }

  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }
} //QualifiedNamedElementImpl
