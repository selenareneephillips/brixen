package org.brixen.bean;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
 * component that contains web controls that have meaningful side effects with state changes that need to be polled for
 * an expected condition when they are clicked and/or moused over.
 */
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public interface DynamicControllableBean extends ControllableBean, PolleableBean {
}
