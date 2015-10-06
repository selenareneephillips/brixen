package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.brixen.decorator.config.LoadableConfigProvider;
import org.brixen.decorator.config.PolleableConfigDecorator;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * page object that models a component that contains web controls that have meaningful side effects with state changes
 * that need to be polled for an expected condition when they are clicked and/or moused over.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class DynamicControllableConfigImpl extends ControllableConfigImpl implements PolleableConfigDecorator {

    /**
     * The {@code LoadableConfigProvider} for the internal {@code PolleableConfig} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableConfig}.
     */
    private @Getter LoadableConfigProvider<? extends PolleableConfig> polleableConfigProvider =
            new LoadableConfigProvider<>(new PolleableConfigImpl());
}
