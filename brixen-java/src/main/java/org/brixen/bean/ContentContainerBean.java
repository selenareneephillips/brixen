package org.brixen.bean;

import org.openqa.selenium.WebElement;

/**
 * Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
 * component which wraps a {@link WebElement} content container.
 */
public interface ContentContainerBean extends LoadableBean {
    /**
     * Sets the {@code WebElement} that contains the content wrapped by the page object.
     *
     * @param contentContainer    the {@code WebElement} that contains the content wrapped by the page object
     */
    void setContentContainer(WebElement contentContainer);

    /**
     * Returns the {@code WebElement} that contains the content wrapped by the page object.
     *
     * @return  the {@code WebElement} that contains the content wrapped by the page object
     */
    WebElement getContentContainer();
}
