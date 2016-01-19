package org.brixen.bean;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
 * web control that has meaningful side effects whenever it is clicked.
 */
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public interface ClickControlBean extends ControlBean, ClickableBean {
}
