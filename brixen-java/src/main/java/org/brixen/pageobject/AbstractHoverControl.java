package org.brixen.pageobject;

import lombok.extern.slf4j.XSlf4j;
import org.brixen.bean.HoverControlBean;
import org.brixen.function.ClickWithJavascript;
import org.brixen.function.HoverWithJavascript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.brixen.bean.LoadableBean;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object that models a web control that has
 * meaningful side effects whenever it is moused over.
 *
 * @param <ControlT>  the {@code class} which {@code extends} this {@code AAbstractHoverControl}
 */
@XSlf4j
public abstract class AbstractHoverControl<ControlT extends AbstractHoverControl<ControlT>> extends
        AbstractContentContainer<ControlT> implements HoverControl {

    /**
     * Constructs an {@code AbstractHoverControl} with the state specified by the {@code LoadableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code AbstractHoverControl}
     */
    public AbstractHoverControl(LoadableBean bean) {
        super(bean);
    }

    /**
     * Mouses over this {@code AbstractHoverControl}.
     * <p>
     * If either of the workarounds for clicking the web control with Javascript instead of mousing over it is enabled,
     * the control will be clicked, regardless of the setting of the hover with Javascript workaround flag. Otherwise,
     * if the Javascript hover workaround flag is enabled, the control will be moused over with Javascript and if it is
     * not, the control will be moused over with {@link Actions#moveToElement}.
     *
     * @see HoverControlBean#getClickInsteadOfHover()
     * @see HoverControlBean#setClickWithJavascriptInsteadOfHover(boolean)
     */
    public void hover() {
        if(clickInsteadOfHover()) {
            log.debug("Clicking instead of hovering");
            getContentContainer().click();
        } else if(clickWithJavascriptInsteadOfHover()) {
            log.debug("Clicking with Javascript instead of hovering");
            new ClickWithJavascript().accept(getDriver(), getContentContainer());
        } else if(hoverWithJavascript()) {
            log.debug("Hovering control with Javascript");
            new HoverWithJavascript().accept(getDriver(), getContentContainer());
        } else {
            Actions action = new Actions(getDriver());
            action.moveToElement(getContentContainer()).perform();
        }
    }

    /**
     * Sends the mouse focus away from the control so that the control is no longer moused over.
     * <p>
     * If either of the workarounds for clicking the defocus element instead of mousing over it is enabled, the defocus
     * element will be clicked to force the mouse focus away from the control, regardless of the value of the defocus
     * element's Javascript hover workaround flag. Otherwise, if the Javascript hover flag is enabled, the defocus
     * element will be hovered to move the mouse focus safely away from the control, and if it is not,
     * {@link Actions#moveToElement} will be used.
     *
     * @see HoverControlBean#setUnhoverElement
     * @see HoverControlBean#setUnhoverWithClickInstead(boolean)
     * @see HoverControlBean#setUnhoverWithJavascriptClickInstead(boolean)
     */
    public void unhover() {
        if(unhoverWithClickInstead()) {
            log.debug("Clicking defocus element instead of hovering");
            getUnhoverElement().click();
        } else if(unhoverWithJavascriptClickInstead()) {
            log.debug("Clicking defocus element with Javascript instead of hovering");
            new ClickWithJavascript().accept(getDriver(), getUnhoverElement());
        } else if(unhoverWithJavascript()) {
            log.debug("Hovering defocus element with Javascript");
            new HoverWithJavascript().accept(getDriver(), getUnhoverElement());
        } else {
            Actions action = new Actions(getDriver());
            action.moveToElement(getUnhoverElement()).perform();
        }
    }


    /**
     * Gets the element to send the focus to when unhovering the web control.
     *
     * @return  the element to send the focus to when unhovering the web control
     */
    protected abstract WebElement getUnhoverElement();

    /**
     * Determines whether the Javascript hover workaround is enabled for the unhover element which is used to focus
     * the mouse in a safe location away from the web control.
     * <p>
     * If enabled, Javascript will be used to execute a mouse over on the unhover element. If not, the
     * {@link Actions#moveToElement} method will be used.
     *
     * @return      {@code true} if the Javascript hover workaround is enabled; {@code false} otherwise
     */
    protected boolean hoverWithJavascript() {
        return false;
    }

    /**
     * Determines whether the Javascript hover workaround for the web control is enabled.
     * <p>
     * If enabled, Javascript will be used to execute a mouse over on the web control. If not, the
     * {@link WebElement#click} method will be used.
     *
     * @return      {@code true} if the Javascript hover workaround is enabled; {@code false} otherwise
     */
    protected boolean unhoverWithJavascript() {
        return false;
    }

    /**
     * Determines whether the {@link WebElement#click} action workaround for forcing the mouse to focus on the web
     * control is enabled.
     *
     * @return  {@code true} if the click action workaround is enabled; {@code false} otherwise
     * @see HoverControlBean#setClickInsteadOfHover(boolean) for caveats about this workaround.
     */
    protected boolean clickInsteadOfHover() {
        return false;
    }

    /**
     * Determines whether the Javascript click action workaround for forcing the mouse to focus on the web control is
     * enabled.
     *
     * @return  {@code true} if the Javascript click action workaround is enabled; {@code false} otherwise
     *
     * @see HoverControlBean#setClickWithJavascriptInsteadOfHover(boolean) for caveats about this workaround
     */
    protected boolean clickWithJavascriptInsteadOfHover() {
        return false;
    }

    /**
     * Determines whether the {@link WebElement#click} action workaround for the unhover element which is used to
     * focus the mouse in a safe location away from the web control is enabled.
     *
     * @return  {@code true} if the click action workaround is enabled; {@code false} otherwise
     * @see HoverControlBean#setUnhoverWithClickInstead(boolean) for caveats about this workaround
     */
    protected boolean unhoverWithClickInstead() {
        return false;
    }

    /**
     * Determines whether the Javascript click action workaround for the unhover element which is used to focus the
     * mouse in a safe location away from the web control is enabled.
     *
     * @return  {@code true} if the Javascript click action workaround is enabled; {@code false} otherwise
     * @see HoverControlBean#setUnhoverWithJavascriptClickInstead(boolean) for caveats about this workaround
     */
    protected boolean unhoverWithJavascriptClickInstead() {
        return false;
    }
}