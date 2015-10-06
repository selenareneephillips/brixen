package org.brixen.pageobject;

/**
 * Defines the contract for a <b>Selenium</b> page object that models a web control that has meaningful side effects
 * whenever it is clicked and which must be moused over before it is clickable.
 */
public interface HoverAndClickControl extends HoverControl, ClickControl, Polleable {
}
