package org.brixen.decorator.pageobject;

import org.brixen.pageobject.Polleable;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code Polleable}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableProvider} which wraps the {@code Polleable} implementation that meets the requirements of
 * {@code Polleable}. In this way, the {@code class} can implement the {@code Polleable interface} by
 * proxy without having to define any of the methods itself.
 */
public interface PolleableDecorator extends Polleable {

    /**
     * Gets the {@code LoadableProvider} for the internal {@code Polleable} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code Polleable}.
     *
     * @return  the {@code LoadableProvider} for the internal {@code Polleable} implementation to which this
     *          {@code interface} delegates all invocations of the methods required by {@code Polleable}
     */
    LoadableProvider<? extends Polleable> getPolleableProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default int getPollingTimeout() {
        return getPolleableProvider().getLoadable().getPollingTimeout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default int getPollingInterval() {
        return getPolleableProvider().getLoadable().getPollingInterval();
    }
}
