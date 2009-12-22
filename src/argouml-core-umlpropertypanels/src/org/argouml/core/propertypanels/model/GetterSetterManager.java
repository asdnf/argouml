/* $Id$
 *******************************************************************************
 * Copyright (c) 2009 Contributors - see below
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bob Tarling - Post GSOC improvements
 *******************************************************************************
 */

package org.argouml.core.propertypanels.model;

import java.util.HashMap;
import java.util.Map;

import org.argouml.model.Model;

public abstract class GetterSetterManager {
    
    /**
     * The list of boolean property getter/setters
     */
    protected final Map<String, BaseGetterSetter> getterSetterByPropertyName =
        new HashMap<String, BaseGetterSetter>();
    
    /**
     * Set a UML property by property name
     * @param handle the element to which a property must be set
     * @param value the new property value
     * @param propertyName the property name
     */
    public abstract void set(Object handle, Object value, String propertyName);
    
    /**
     * Get a UML property by property name
     * @param handle the element from which a property must be return
     * @param value the new property value
     * @param propertyName the property name
     * @return the UML element or property
     */
    public abstract Object get(Object handle, String propertyName);

    public abstract String[] getOptions(String propertyName);
    
    public boolean contains(String propertyName) {
        return getterSetterByPropertyName.containsKey(propertyName);
    }
    
    public static GetterSetterManager getGetterSetter() {
        return new GetterSetterManagerImpl();
    }
    
    protected abstract class BaseGetterSetter {
        
        abstract Object get(Object modelElement);
        abstract void set(Object modelElement, Object value);
    }
    
    protected abstract class RadioGetterSetter extends BaseGetterSetter {
        
        private String[] options;

        protected void setOptions(final String[] options) {
            this.options = options;
        }

        protected String[] getOptions() {
            return options;
        }
    }
}