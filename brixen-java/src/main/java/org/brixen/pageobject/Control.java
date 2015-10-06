package org.brixen.pageobject;

/**
 * Defines the contract for a <b>Selenium</b> page object that models a web control that has meaningful side effects
 * whenever it is clicked and/or moused over.
 * <p>
 * {@code Control} is a marker {@code interface} that services mainly as a type declaration.
 */
public interface Control extends Loadable {

    /**
     * Determines if this {@code Control} is a web control that has meaningful behavior when clicked.
     *
     * @return  {@code true} if this {@code Control} is also a {@code ClickControl}; {@code false} otherwise
     */
    default boolean isClickControl() {
        return ClickControl.class.isAssignableFrom(this.getClass());
    }

    /**
     * Determines if this {@code Control} is a web control that has meaningful behavior when moused over.
     *
     * @return  {@code true} if this {@code Control} is also a {@code HoverControl; {@code false} otherwise
     */
    default boolean isHoverControl() {
        return HoverControl.class.isAssignableFrom(this.getClass());
    }

    /**
     * Determines if this {@code Control} is a web control that has meaningful behavior when clicked, but which must be
     * moused over before it can be clicked.
     *
     * @return  {@code true} if this {@code Control} is also a {@code HoverAndClickControl}; {@code false} otherwise
     */
    default boolean isHoverAndClickControl() {
        return HoverAndClickControl.class.isAssignableFrom(this.getClass());
    }
}
