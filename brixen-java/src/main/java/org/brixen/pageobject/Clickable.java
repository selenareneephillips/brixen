package org.brixen.pageobject;

/**
 * Defines the contract for <b>Selenium</b> page objects that model components which have meaningful behavior when
 * clicked: HTML links, controls that trigger actions like deletion and submission or which open, close, expand, or
 * collapse page objects like menus, dialogs and data entry forms.
 */
public interface Clickable extends Loadable {

    /**
     * Performs a click action on this {@code Clickable} and implements the relevant behavior for the page object
     * which this {@code Clickable} models.
     */
    void click();
}