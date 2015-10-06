package org.brixen.decorator.bean;

import org.brixen.bean.PolleableBean;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code PolleableBean}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableBeanProvider} which wraps an instance of a concrete implementation of {@code PolleableBean}. In this
 * way, the {@code class} can implement the {@code PolleableBean interface} by proxy without having to define any of
 * the methods itself.
 */
public interface PolleableBeanDecorator extends PolleableBean {

    /**
     * Gets the {@code LoadableBeanProvider} for the internal {@code PolleableBean} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code PolleableBean}.
     *
     * @return  the {@code LoadableBeanProvider} for the internal {@code PolleableBean} implementation to which this
     *          {@code interface} delegates all invocations of the methods required by {@code PolleableBean}
     */
    LoadableBeanProvider<? extends PolleableBean> getPolleableBeanProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default void setPollingTimeout(int pollingTimeout) {
        getPolleableBeanProvider().getBean().setPollingTimeout(pollingTimeout);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default int getPollingTimeout() {
        return getPolleableBeanProvider().getBean().getPollingTimeout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setPollingInterval(int pollingInterval) {
        getPolleableBeanProvider().getBean().setPollingInterval(pollingInterval);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default int getPollingInterval() {
        return getPolleableBeanProvider().getBean().getPollingInterval();
    }
}
