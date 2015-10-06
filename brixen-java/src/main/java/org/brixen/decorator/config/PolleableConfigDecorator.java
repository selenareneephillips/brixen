package org.brixen.decorator.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.brixen.config.PolleableConfig;

import java.util.Optional;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code PolleableConfig}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableConfigProvider} which wraps an instance of a concrete implementation of {@code PolleableConfig}. 
 * In this way, the {@code class} can implement the {@code ControllableConfig interface} by proxy without having to 
 * define any of the methods itself.
 */
public interface PolleableConfigDecorator extends PolleableConfig {

    /**
     * Gets the {@code LoadableConfigProvider} for the internal {@code PolleableConfig} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code PolleableConfig}.
     *
     * @return  the {@code LoadableConfigProvider} for the internal {@code PolleableConfig} implementation to which 
     *          this {@code interface} delegates all invocations of the methods required by {@code PolleableConfig}
     */
    @JsonIgnore
    LoadableConfigProvider<? extends PolleableConfig> getPolleableConfigProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default Optional<Integer> getPollingTimeout() {
        return getPolleableConfigProvider().getConfig().getPollingTimeout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setPollingTimeout(Optional<Integer> pollingTimeout) {
        getPolleableConfigProvider().getConfig().setPollingTimeout(pollingTimeout);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default Optional<Integer> getPollingInterval() {
        return getPolleableConfigProvider().getConfig().getPollingInterval();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setPollingInterval(Optional<Integer> pollingInterval) {
        getPolleableConfigProvider().getConfig().setPollingInterval(pollingInterval);
    }
}
