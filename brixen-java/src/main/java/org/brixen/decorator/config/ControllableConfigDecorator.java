package org.brixen.decorator.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.brixen.config.ControlConfig;
import org.brixen.config.ControllableConfig;

import java.util.Map;
import java.util.Optional;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code ControllableConfig}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableConfigProvider} which wraps an instance of a concrete implementation of {@code ControllableConfig}.
 * In this way, the {@code class} can implement the {@code ControllableConfig interface} by proxy without having to
 * define any of the methods itself.
 */
public interface ControllableConfigDecorator extends ControllableConfig {

    /**
     * Gets the {@code LoadableConfigProvider} for the internal {@code ControllableConfig} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code ControllableConfig}.
     *
     * @return  the {@code LoadableConfigProvider} for the internal {@code ControllableConfig} implementation to which 
     *          this {@code interface} delegates all invocations of the methods required by {@code ControllableConfig}
     */
    @JsonIgnore
    LoadableConfigProvider<? extends ControllableConfig> getControllableConfigProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default void setControlConfigs(Optional<Map<String,ControlConfig>> controlConfigs) {
        getControllableConfigProvider().getConfig().setControlConfigs(controlConfigs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default Optional<Map<String,ControlConfig>> getControlConfigs() {
        return getControllableConfigProvider().getConfig().getControlConfigs();
    }
}
