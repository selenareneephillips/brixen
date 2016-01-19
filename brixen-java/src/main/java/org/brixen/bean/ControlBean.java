package org.brixen.bean;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
 * web control that has meaningful side effects whenever it is clicked and/or moused over.
 * <p>
 * {@code ControlBean} is a marker {@code interface} that services mainly as a type declaration.
 */
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public interface ControlBean extends ContentContainerBean {

    /**
     * Determines if this {@code ControlBean} specifies a web control that has meaningful behavior when clicked.
     *
     * @return  {@code true} if this {@code ControlBean} is also a {@code ClickControlBean}; {@code false} otherwise
     */
    default boolean isClickControl() {
        return ClickControlBean.class.isAssignableFrom(this.getClass());
    }

    /**
     * Determines if this {@code ControlBean} specifies a web control that has meaningful behavior when moused over.
     *
     * @return  {@code true} if this {@code ControlBean} is also a {@code HoverControlBean}; {@code false} otherwise
     */
    default boolean isHoverControl() {
        return HoverControlBean.class.isAssignableFrom(this.getClass());
    }

    /**
     * Determines if this {@code ControlBean} specifies a web control that has meaningful behavior when clicked, but
     * which must be moused over before it can be clicked.
     *
     * @return  {@code true} if this {@code ControlBean} is also a {@code HoverAndClickControlBean}; {@code false}
     *          otherwise
     */
    default boolean isHoverAndClickControl() {
        return HoverAndClickControlBean.class.isAssignableFrom(this.getClass());
    }
}
