package org.brixen.bean;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a menu.
 */
public interface MenuBean extends ContentContainerBean {
    /**
     * Sets the list of {@code WebElements} that encapsulate the options on the menu.
     *
     * @param optionElements    the list of {@code WebElements} that encapsulate the options on the menu
     */
    void setOptionElements(List<WebElement> optionElements);

    /**
     * Returns the list of {@code WebElements} that encapsulate the options on the menu.
     *
     * @return      the list of {@code WebElements} that encapsulate the options on the menu.
     */
    List<WebElement> getOptionElements();

    /**
     * Enables or disables the Javascript click workaround for the options in the menu.
     * <p>
     * If enabled, Javascript will be used to execute a click on the on the menu options. If not, the
     * {@link WebElement#click} method will be used.
     *
     * @param clickOptionWithJavascript     if {@code true}, enables the Javascript click workaround; {@code false} if
     *                                      the menu options are to be clicked using {@link WebElement#click}
     */
    void setClickOptionWithJavascript(boolean clickOptionWithJavascript);

    /**
     * Determines whether the Javascript click workaround is enabled.
     * <p>
     * If enabled, Javascript will be used to execute a click on the menu options. If not, the @link WebElement#click}
     * method will be used.
     *
     * @return      {@code true} if the Javascript click workaround is enabled; {@code false} otherwise
     */
    boolean getClickOptionWithJavascript();
}
