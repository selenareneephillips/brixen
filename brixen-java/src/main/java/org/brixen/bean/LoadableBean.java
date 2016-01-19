package org.brixen.bean;

import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnegative;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a data transfer object used to construct a basic <b>Selenium</b> page object.
 */
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public interface LoadableBean {

    /**
     * Sets the {@code WebDriver} to use for browsing the page object.
     *
     * @param driver    the driver for browsing the page object
     */
    @SuppressWarnings("NullableProblems")
    void setDriver(WebDriver driver);

    /**
     * Returns the {@code WebDriver} to use for browsing the page object.
     *
     * @return      the driver to use for browsing the page object
     */
    @Nullable WebDriver getDriver();

    /**
     * Sets the load timeout in seconds for the page object.
     *
     * @param timeout  the load timeout in seconds for the page object
     */
    void setLoadTimeout(@Nonnegative int timeout);

    /**
     * Returns the load timeout in seconds for the page object.
     *
     * @return      the load timeout in seconds for the page object
     */
    @Nonnegative int getLoadTimeout();
}
