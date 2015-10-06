package org.brixen.pageobject;

import org.openqa.selenium.WebDriver;

/**
 * Defines the contract for the most basic <b>Selenium</b> page object.
 */
public interface Loadable {

    int DEFAULT_LOAD_TIMEOUT = 30;

    /**
     * Returns the {@code WebDriver} for browsing this {@code Loadable}.
     *
     * @return      the driver for browsing this {@code Loadable}
     */
    WebDriver getDriver();

    /**
     * Returns the load timeout in seconds for this {@code Loadable}.
     *
     * @return      the load timeout in seconds for this {@code Loadable}
     */
    int getLoadTimeout();
}
