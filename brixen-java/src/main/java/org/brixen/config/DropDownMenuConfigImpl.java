package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.brixen.decorator.config.ControllableConfigDecorator;
import org.brixen.decorator.config.LoadableConfigProvider;
import org.brixen.decorator.config.PolleableConfigDecorator;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * page object that models a drop down menu.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class DropDownMenuConfigImpl extends MenuConfigImpl implements DropDownMenuConfig, DynamicControllableConfig,
        ControllableConfigDecorator, PolleableConfigDecorator {

    /**
     * The {@code LoadableConfigProvider} for the internal {@code ControllableConfig} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code ControllableConfig}.
     */
    private final @Getter LoadableConfigProvider<? extends ControllableConfig> controllableConfigProvider =
            new LoadableConfigProvider<>(new ControllableConfigImpl());

    /**
     * The {@code LoadableConfigProvider} for the internal {@code PolleableConfig} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableConfig}.
     */
    private final @Getter LoadableConfigProvider<? extends PolleableConfig> polleableConfigProvider =
            new LoadableConfigProvider<>((new PolleableConfigImpl()));
}
