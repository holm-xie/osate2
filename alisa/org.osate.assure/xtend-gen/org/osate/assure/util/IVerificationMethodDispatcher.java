package org.osate.assure.util;

import com.google.inject.ImplementedBy;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.util.DefaultVerificationMethodDispatcher;
import org.osate.verify.verify.VerificationMethod;

@ImplementedBy(DefaultVerificationMethodDispatcher.class)
@SuppressWarnings("all")
public interface IVerificationMethodDispatcher {
  public abstract Object dispatchVerificationMethod(final VerificationMethod vm, final VerificationResult vr);
  
  public abstract void runVerificationMethod(final VerificationResult verificationActivityResult);
}