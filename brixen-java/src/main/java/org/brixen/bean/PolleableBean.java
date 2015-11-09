package org.brixen.bean;

public interface PolleableBean extends LoadableBean {

    /**
     * Sets the polling timeout in seconds for a {@code FluentWait} to poll the page object to determine if an expected
     * condition has been satisfied.
     *
     * @param pollingTimeout   the polling timeout in seconds for a {@code FluentWait} to poll the page object to
     *                         determine if an expected condition has been satisfied
     */
    void setPollingTimeout(int pollingTimeout);

    /**
     * Returns the polling timeout in seconds for a {@code FluentWait} to poll the page object to determine if an
     * expected condition has been satisfied.
     *
     * @return      the polling timeout in seconds for a {@code FluentWait} to poll the page object to determine if an
     *              expected condition has been satisfied
     */
    int getPollingTimeout();

    /**
     * Sets the polling interval in seconds for a {@code FluentWait} to poll the page object to determine if an
     * expected condition has been satisfied.
     *
     * @param pollingInterval      the polling interval in seconds for a {@code FluentWait} to poll the page object to
     *                             determine if an expected condition has been satisfied
     */
    void setPollingInterval(int pollingInterval);

    /**
     * Returns the polling interval in seconds for a {@code FluentWait} to poll the page object to determine if an
     * expected condition has been satisfied.
     *
     * @return      the polling interval in seconds for a {@code FluentWait} to poll the page object to determine if an
     *              expected condition has been satisfied
     */
    int getPollingInterval();
}
