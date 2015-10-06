package org.brixen.pageobject;

import lombok.Getter;
import lombok.extern.slf4j.XSlf4j;
import org.brixen.bean.HoverAndClickControlBean;
import org.brixen.bean.PolleableBean;
import org.brixen.decorator.pageobject.LoadableProvider;
import org.brixen.decorator.pageobject.PolleableDecorator;
import org.brixen.function.ClickWithJavascript;
import org.brixen.function.HoverWithJavascript;
import org.brixen.function.WaitForElementNotVisible;
import org.brixen.function.WaitForElementVisible;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object that models a web control that has
 * meaningful side effects whenever it is clicked and which must be moused over before it is clickable.
 *
 * @param <ControlT>  the {@code class} which {@code extends} this {@code AAbstractHoverAndClickControl}
 */
@XSlf4j
public abstract class AbstractHoverAndClickControl<ControlT extends AbstractHoverAndClickControl<ControlT>> extends
        AbstractClickable<ControlT> implements HoverAndClickControl, PolleableDecorator {

    /**
     * Provider for internal {@code Polleable} that encapsulates the polleable behavior for this
     * {@code AbstractHoverAndClickControl}.
     */
    private final @Getter LoadableProvider<Polleable> polleableProvider;

    /**
     * Constructs an {@code AbstractHoverAndClickControl} with the state specified by the {@code PolleableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code AbstractHoverAndClickControl}
     */
    public AbstractHoverAndClickControl(PolleableBean bean) {
        super(bean);
        polleableProvider = new LoadableProvider<>(new PolleableImpl(bean));
    }

    /**
     * Clicks this {@code AbstractHoverAndClickControl}.
     * <p>
     * If the workaround for clicking the web control with Javascript instead of trying to execute a mouseover on it
     * first to make it visible is enabled, the control will simply be clicked with Javascript, regardless of the
     * settings for the other workaround flags. If not, the control will be moused over first. Then, if the Javascript
     * click workaround is not enabled, the click is performed with {@link WebElement#click}. Otherwise, Javascript is
     * used to perform the click, as long as the mouseover successfully results in the control becoming visible.
     *
     * @throws TimeoutException if the control is moused over first and fails to become visible before the end of its
     * polling timeout period
     *
     * @see HoverAndClickControlBean#setClickWithJavascriptInsteadOfHover(boolean)
     */
    public void click() {
        if(clickWithJavascriptInsteadOfHover()) {
            log.debug("Clicking with Javascript instead of hovering to make the control visible first");
            new ClickWithJavascript().accept(getDriver(), getContentContainer());
        } else {
            hover();

            if(clickWithJavascript()) {
                log.debug("Control is visible. Clicking with Javascript");
                new ClickWithJavascript().accept(getDriver(), getContentContainer());
            } else {
                log.debug("Control is visible. Clicking with native Selenium method");
                getContentContainer().click();
            }
        }
    }

    /**
     * Mouses over this {@code AbstractHoverAndClickControl} to render it visible.
     * <p>
     * If the workaround for clicking the web control with Javascript instead of trying to execute a mouseover on it
     * first to make it visible is enabled, this method will do nothing, regardless of the setting for the hover with
     * Javascript workaround flags. Otherwise, if the Javascript hover workaround flag is enabled, the control will be
     * moused over with Javascript and if it is not, the control will be moused over with {@link Actions#moveToElement}.
     *
     * @throws TimeoutException if the control is hovered and fails to become visible before the end of its polling
     * timeout period
     *
     * @see HoverAndClickControlBean#setClickWithJavascriptInsteadOfHover(boolean)
     */
    public void hover() {
        if(!clickWithJavascriptInsteadOfHover()) {
            if (hoverWithJavascript()) {
                log.debug("Hovering control with Javascript");
                new HoverWithJavascript().accept(getDriver(), getContentContainer());
            } else {
                log.debug("Hovering with the native Selenium method");
                Actions action = new Actions(getDriver());
                action.moveToElement(getContentContainer()).perform();
            }

            new WaitForElementVisible().accept(getContentContainer(), getPollingTimeout(), getPollingInterval());
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
     * @throws TimeoutException if the control does not become invisible before the end of its polling timeout period
     * after the defocus element has been moused over or clicked
     *
     * @see HoverAndClickControlBean#setUnhoverElement
     * @see HoverAndClickControlBean#setUnhoverWithClickInstead(boolean)
     * @see HoverAndClickControlBean#setUnhoverWithJavascriptClickInstead(boolean)
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
            log.debug("Hovering defocus element with the native Selenium method");
            Actions action = new Actions(getDriver());
            action.moveToElement(getUnhoverElement()).perform();
        }

        new WaitForElementNotVisible().accept(getContentContainer(), getPollingTimeout(), getPollingInterval());
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
     * Determines whether the workaround for clicking the web control with Javascript instead of trying to execute a
     * mouseover on it first to make it visible is enabled.
     *
     * @return  {@code true} if the Javascript click action workaround is enabled; {@code false} otherwise
     * @see HoverAndClickControlBean#setClickWithJavascriptInsteadOfHover(boolean) for caveats about this workaround
     */
    protected boolean clickWithJavascriptInsteadOfHover() {
        return false;
    }

    /**
     * Determines whether the {@link WebElement#click} action workaround for the unhover element which is used to
     * focus the mouse in a safe location away from the web control is enabled.
     *
     * @return  {@code true} if the click action workaround is enabled; {@code false} otherwise
     * @see HoverAndClickControlBean#setUnhoverWithClickInstead(boolean) for caveats about this workaround
     */
    protected boolean unhoverWithClickInstead() {
        return false;
    }

    /**
     * Determines whether the Javascript click action workaround for the unhover element which is used to focus the
     * mouse in a safe location away from the web control is enabled.
     *
     * @return  {@code true} if the Javascript click action workaround is enabled; {@code false} otherwise
     * @see HoverAndClickControlBean#setUnhoverWithJavascriptClickInstead(boolean) for caveats about this workaround
     */
    protected boolean unhoverWithJavascriptClickInstead() {
        return false;
    }

    /**
     * Determines if this {@code AbstractHoverAndClickControl} is loaded by checking whether the content container is
     * {@code null} or throws a {@code NoSuchElementException} or a {@code StaleElementReferenceException} when
     * {@link WebElement#isDisplayed} is invoked on it.
     *
     * @throws Error if the load checks continue to fail after the load timeout expires
     */
    @Override
    protected void isLoaded() throws Error {
        try {
            getContentContainer().isDisplayed();
        } catch(NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            throw new Error("The control is not loaded", e);
        }
    }
}
