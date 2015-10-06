package org.brixen.decorator.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.brixen.config.ClickableConfig;

import java.util.Optional;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code ClickableConfig}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableConfigProvider} which wraps an instance of a concrete implementation of {@code ClickableConfig}. In
 * this way, the {@code class} can implement the {@code ClickableConfig interface} by proxy without having to define
 * any of the methods itself.
 */
public interface ClickableConfigDecorator extends ClickableConfig {

    /**
     * Gets the {@code LoadableConfigProvider} for the internal {@code ClickableConfig} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code ClickableConfig}.
     *
     * @return  the {@code LoadableConfigProvider} for the internal {@code ClickableConfig} implementation to which
     *          this {@code interface} delegates all invocations of the methods required by {@code ClickableConfig}
     */
    @JsonIgnore
    LoadableConfigProvider<? extends ClickableConfig> getClickableConfigProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default Optional<Boolean> getClickWithJavascript() {
        return getClickableConfigProvider().getConfig().getClickWithJavascript();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setClickWithJavascript(Optional<Boolean> clickWithJavascript) {
        getClickableConfigProvider().getConfig().setClickWithJavascript(clickWithJavascript);
    }
}
