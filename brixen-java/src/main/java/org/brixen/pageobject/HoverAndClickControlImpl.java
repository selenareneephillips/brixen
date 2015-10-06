package org.brixen.pageobject;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.brixen.bean.HoverAndClickControlBean;

/**
 * Serves as a basic implementation for a <b>Selenium</b> page object that models a web control that has meaningful
 * side effects whenever it is clicked and which must be moused over before it is clickable.
 */
public class HoverAndClickControlImpl extends AbstractHoverAndClickControl<HoverAndClickControlImpl> {

    /** The {@code WebElement} that contains the web control */
    private final @Getter(AccessLevel.PROTECTED) WebElement contentContainer;

    /**
     * The {@code WebElement} that contains the web control's defocus element which is used to move the mouse
     * focus safely away from the control to ensure that it is not hovered when desired
     */
    private final @Getter(AccessLevel.PROTECTED) WebElement unhoverElement;

    /** Flag for enabling, disabling the Javascript click workaround */
    private final boolean clickWithJavascript;

    /** Flag for enabling, disabling the Javascript hover workaround */
    private final boolean hoverWithJavascript;

    /** Flag for enabling/disabling the unhover with Javascript workaround for the unhover element */
    private final boolean unhoverWithJavascript;

    /** Flag for enabling, disabling the Javascript click action workaround for the web control */
    private final boolean clickWithJavascriptInsteadOfHover;

    /** Flag for enabling, disabling the click action workaround for the unhover element */
    private final boolean unhoverWithClickInstead;

    /** Flag for enabling, disabling the Javascript click action workaround for the unhover element */
    private final boolean unhoverWithJavascriptClickInstead;

    /**
     * Constructs an {@code HoverAndClickControlImpl} with the state specified by the {@code HoverAndClickControlBean}.
     *
     * @param bean  a data transfer object for constructing an {@code HoverAndClickControlImpl}
     */
    public HoverAndClickControlImpl(HoverAndClickControlBean bean) {
        super(bean);

        this.contentContainer = bean.getContentContainer();
        this.unhoverElement = bean.getUnhoverElement();
        this.clickWithJavascript = bean.getClickWithJavascript();
        this.hoverWithJavascript = bean.getHoverWithJavascript();
        this.unhoverWithJavascript = bean.getUnhoverWithJavascript();
        this.clickWithJavascriptInsteadOfHover = bean.getClickWithJavascriptInsteadOfHover();
        this.unhoverWithClickInstead = bean.getUnhoverWithClickInstead();
        this.unhoverWithJavascriptClickInstead = bean.getUnhoverWithJavascriptClickInstead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean clickWithJavascript() {
        return clickWithJavascript;
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
