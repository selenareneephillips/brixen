package org.brixen.pageobject;

/**
 * Defines the contract for a <b>Selenium</b> page object that models a web control that has meaningful side effects
 * whenever it is moused over.
 */
public interface HoverControl extends Control {

    /**
     * Hovers over the control.
     */
    void hover();

    /**
     * Sends the mouse focus away from the control so that the control is no longer moused over.
     */
    void unhover();
}
