package org.osate.ge.internal.services;

import org.eclipse.core.resources.IResourceChangeListener;

public interface ModelChangeNotifier {
	static interface ChangeListener {
		default void modelChanged() {} // Called to notify listeners that change has occurred.
		default void afterModelChangeNotification() {} // A notification that occurs after model change notifications. Used by editor to refresh after other listeners have handled things accordingly. 
	}
	
	void addChangeListener(ChangeListener listener);
	void removeChangeListener(ChangeListener listener);
	
	// Adds/Removes resource change listeners which are called before the model change notifiers are called.
	void addResourceChangeListener(IResourceChangeListener listener);
	void removeResourceChangeListener(IResourceChangeListener listener);
	
}
