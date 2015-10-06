package org.brixen.pageobject;

/**
 * Defines the contract for a <b>Selenium</b> page object that models a dynamic pageobject which needs to be polled on
 * intervals for an expected condition via a {@link org.openqa.selenium.support.ui.FluentWait}.
 *
 * <p>
 * Page objects such as dialogs and expandable/collapsible components are examples of dynamic components which need to
 * polled on intervals to determine if they present and loaded before they can be interacted with, or that they are no
 * longer present and visible if they have been dismissed/collapsed. {@code Polleable} provides a means to configure
 * the polling timeout and the polling interval for checking a dynamic pageobject to determine if an expected condition
 * has been satisfied at the specified interval for the specified timeout period.
 */
public interface Polleable extends Loadable {

    int DEFAULT_POLLING_TIMEOUT = 30;
    int DEFAULT_POLLING_INTERVAL = 1;

    /**
     * Returns the polling timeout in seconds to poll this {@code Polleable} to determine if an expected specified
     * condition has been satisfied.
     *
     * @return      the polling timeout in seconds to poll this {@code Polleable} to determine if an expected condition
     *              has been satisfied
     */
    int getPollingTimeout();

    /**
     * Returns the polling interval in seconds to poll this {@code Polleable} to determine if an expected condition has
     * been satisfied.
     *
     * @return      the polling interval in seconds to poll this {@code Polleable} to determine if an expected
     *              condition has been satisfied
     */
    int getPollingInterval();
}
