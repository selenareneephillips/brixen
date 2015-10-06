package org.brixen.pageobject;

/**
 * Defines the contract for a <b>Selenium</b> page object that models a expandable/collapsible pageobject, such as a
 * drop down menu.
 */
public interface Expandable extends Polleable {

    /** Expands the content section for the page object and makes the elements wrapped by it visible. */
    void expand();

    /** Collapses the content section for the page object and renders the elements wrapped by it invisible. */
    void collapse();

    /**
     * Determines whether the page object is expanded or not.
     *
     * @return      {@code true} if the page object is expanded; {@code false} otherwise
     */
    boolean isExpanded();

    /**
     * Determines whether the page object is collapsed or not.
     *
     * @return      {@code true} if the page object is collapsed; {@code false} otherwise
     */
    boolean isCollapsed();
}
