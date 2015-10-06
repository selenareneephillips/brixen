package org.brixen.bean;

import org.openqa.selenium.WebDriver;

/**
 * Defines the contract for a data transfer object used to construct a basic <b>Selenium</b> page object.
 */
public interface LoadableBean {

    /**
     * Sets the {@code WebDriver} to use for browsing the page object.
     *
     * @param driver    the driver for browsing the page object
     */
    void setDriver(WebDriver driver);

    /**
     * Returns the {@code WebDriver} to use for browsing the page object.
     *
     * @return      the {@code WebDriver} to use for browsing the page object
     */
    WebDriver getDriver();

    /**
     * Sets the load timeout in seconds for the page object.
     *
     * @param timeout  the load timeout in seconds for the page object
     */
    void setLoadTimeout(int timeout);

    /**
     * Returns the load timeout in seconds for the page object.
     *
     * @return      the load timeout in seconds for the page object
     */
    int getLoadTimeout();
}
