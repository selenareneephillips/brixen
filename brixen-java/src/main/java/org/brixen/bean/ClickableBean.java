package org.brixen.bean;

import org.openqa.selenium.WebElement;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
 * {@code Clickable} page object.
 */
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public interface ClickableBean extends ContentContainerBean {
    /**
     * Enables or disables the Javascript click workaround.
     * <p>
     * Enabling the Javascript click workaround will invoke a 'click' on the wrapped {@code WebElement} with Javascript
     * rather than using {@link WebElement#click} method. This is useful in circumstances where clicks fail silently,
     * that is {@link WebElement#click} runs without throwing any {@code Exceptions}, but the element is not really
     * clicked.
     *
     * @param clickWithJavascript    if {@code true}, enables the Javascript click workaround; {@code false} to disable
     *                               it
     */
    void setClickWithJavascript(boolean clickWithJavascript);

    /**
     * Determines whether the Javascript click workaround is enabled.
     * <p>
     * If enabled, Javascript will be used to execute a click on the wrapped {@code WebElement}. If not, the
     * {@link WebElement#click} method will be used.
     *
     * @return      {@code true} if the Javascript click workaround is enabled; {@code false} otherwise
     */
    boolean getClickWithJavascript();
}
