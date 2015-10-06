package org.brixen.pageobject;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.bean.HoverControlBean;
import org.openqa.selenium.WebElement;

/**
 * Serves as a basic implementation for a <b>Selenium</b> page object that models a web control that has meaningful
 * side effects whenever it is moused over.
 */
public class HoverControlImpl extends AbstractHoverControl<HoverControlImpl> {

    /** The {@code WebElement} that contains the web control */
    private final @Getter(AccessLevel.PROTECTED) WebElement contentContainer;

    /**
     * The {@code WebElement} that contains the web control's defocus element which is used to move the mouse
     * focus safely away from the control to ensure that it is not hovered when desired
     */
    private final @Getter(AccessLevel.PROTECTED) WebElement unhoverElement;

    /** Flag for enabling, disabling the Javascript hover workaround */
    private final boolean hoverWithJavascript;

    /** Flag for enabling/disabling the unhover with Javascript workaround for the unhover element */
    private final boolean unhoverWithJavascript;

    /** Flag for enabling, disabling the click action workaround for the web control */
    private final boolean clickInsteadOfHover;

    /** Flag for enabling, disabling the Javascript click action workaround for the web control */
    private final boolean clickWithJavascriptInsteadOfHover;

    /** Flag for enabling, disabling the click action workaround for the unhover element */
    private final boolean unhoverWithClickInstead;

    /** Flag for enabling, disabling the Javascript click action workaround for the unhover element */
    private final boolean unhoverWithJavascriptClickInstead;

    /**
     * Constructs an {@code HoverControlImpl} with the state specified by the {@code HoverControlBean}.
     *
     * @param bean  a data transfer object for constructing an {@code HoverControlImpl}
     */
    public HoverControlImpl(HoverControlBean bean) {
        super(bean);

        this.contentContainer = bean.getContentContainer();
        this.unhoverElement = bean.getUnhoverElement();
        this.hoverWithJavascript = bean.getHoverWithJavascript();
        this.unhoverWithJavascript = bean.getUnhoverWithJavascript();
        this.clickInsteadOfHover = bean.getClickInsteadOfHover();
        this.clickWithJavascriptInsteadOfHover = bean.getClickWithJavascriptInsteadOfHover();
        this.unhoverWithClickInstead = bean.getUnhoverWithClickInstead();
        this.unhoverWithJavascriptClickInstead = bean.getUnhoverWithJavascriptClickInstead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hoverWithJavascript() {
        return hoverWithJavascript;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean unhoverWithJavascript() {
        return unhoverWithJavascript;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean clickInsteadOfHover() {
        return clickInsteadOfHover;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean clickWithJavascriptInsteadOfHover() {
        return clickWithJavascriptInsteadOfHover;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean unhoverWithClickInstead() {
        return unhoverWithClickInstead;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean unhoverWithJavascriptClickInstead() {
        return unhoverWithJavascriptClickInstead;
    }
}
