package org.brixen.pageobject;

import lombok.extern.slf4j.XSlf4j;
import org.brixen.bean.PolleableBean;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.brixen.function.WaitForElementVisible;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object which models a dynamic component
 * which can be rendered visible and invisible.
 *
 * @param <ToggleableT>   the {@code class} which {@code extends} this {@code AbstractToggleableVisibility}
 */
@XSlf4j
public abstract class AbstractToggleableVisibility<ToggleableT extends AbstractToggleableVisibility<ToggleableT>>
        extends AbstractDynamicControllable<ToggleableT> {

    /**
     * Constructs an {@code AbstractToggleableVisibility} with the state specified by the {@code PolleableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code AbstractToggleableVisibility}
     */
    public AbstractToggleableVisibility(PolleableBean bean) {
        super(bean);
    }

    /**
     * Toggles the page object visible, if it is not visible already using the specified control.
     * <p>
     * if the control is a hover and click control, the control will be hovered and then clicked. If the control is a
     * hover control, it will be hovered. If it is a click control, it will be clicked.
     *
     * @param toggleControlName     the name of the control which toggles the visibility of the page object
     * @throws IllegalArgumentException if the specified control is not a hover control, hover and click control or a
     * click control
     * @throws TimeoutException if the page object fails to become visible before the end of its polling timeout period
     */
    protected void toggleVisible(String toggleControlName) {
        if(isToggledInvisible(toggleControlName)) {
            Control control = getControl(toggleControlName);

            if(control.isHoverAndClickControl()) {
                ((HoverAndClickControl)control).click();
            } else if(control.isClickControl()) {
                ((ClickControl)control).click();
            } else if(control.isHoverControl()) {
                ((HoverControl)control).hover();
            } else {
                throw new IllegalArgumentException("The control is not a hover control, hover and click control or a " +
                        "click control, so it is not supported");
            }
        }

        new WaitForElementVisible().accept(getContentContainer(), getPollingTimeout(), getPollingInterval());
    }

    /**
     * Toggles the page object invisible, if it is not invisible already using the specified control.
     * <p>
     * if the control is a hover and click control, the control will be hovered and then clicked. If the control is a
     * hover control, it will be hovered. If it is a click control, it will be clicked.
     *
     * @param toggleControlName     the name of the control which toggles the visibility of the page object
     * @throws IllegalArgumentException if the specified control is not a hover control, hover and click control or a
     * click control
     * @throws TimeoutException if the page object fails to become invisible before the end of its polling timeout
     * period
     */
    protected void toggleInvisible(String toggleControlName) {
        if(!isToggledVisible(toggleControlName)) {
            Control control = getControl(toggleControlName);

            if(control.isHoverAndClickControl()) {
                ((HoverAndClickControl)control).click();
            } else if(control.isClickControl()) {
                ((ClickControl)control).click();
            } else {
                ((HoverControl)control).unhover();
            }
        }

        new WaitForElementVisible().accept(getContentContainer(), getPollingTimeout(), getPollingInterval());
    }

    /**
     * Determines if the page object is toggled visible by checking whether its content container is visible or not.
     * <p>
     * Note: Test case for a page object with a hover and click control which has a sticky visibility state after it is
     * toggled and which is visible when its control is hovered is not yet covered. See this
     * <a href="http://technicolordreamcode.com/2015/10/03/even-more-reasons-why-you-dont-have-good-automation-w-update-on-generic-uxd-legos-source-code-packages/">post</a> on my blog for more information.
     *
     * @param toggleControlName     the name of the control which toggles the visibility of the page object
     * @return                      {@code true} if the page object is in currently toggled visible; {@code false}
     *                              otherwise
     */
    protected boolean isToggledVisible(String toggleControlName) {
        try {
            Control control = getControl(toggleControlName);

              //Design some way to handle combination of hover and click control with component that has a sticky
              //expanded state where control is not hoverable at all by any means.
//            if(control.isHoverAndClickControl()) {
//                ((HoverAndClickControl)control).hover();
//
//                try {
//                    new WaitForElementVisible().accept(getContentContainer(), getPollingTimeout(),
//                            getPollingInterval());
//                } catch(TimeoutException e) {
//                    return false;
//                }
//            }

            return getContentContainer().isDisplayed();
        } catch(NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    /**
     * Determines if the page object is toggled visible by checking whether its content container is invisible or not.
     * <p>
     * Note: Test case for a page object with a hover and click control which has a sticky visibility state after it is
     * toggled and which is visible when its control is hovered is not yet covered. See this
     * <a href="http://technicolordreamcode.com/2015/10/03/even-more-reasons-why-you-dont-have-good-automation-w-update-on-generic-uxd-legos-source-code-packages/">post</a> on my blog for more information.
     *
     * @param toggleControlName     the name of the control which toggles the visibility of the page object
     * @return                      {@code true} if the page object is in currently toggled visible; {@code false}
     *                              otherwise
     */
    protected boolean isToggledInvisible(String toggleControlName) {
        return !isToggledVisible(toggleControlName);
    }
}
