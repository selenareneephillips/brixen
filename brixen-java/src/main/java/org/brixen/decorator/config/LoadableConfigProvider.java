package org.brixen.decorator.config;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.config.LoadableConfig;

/**
 * Serves as a {@code protected} access provider for an implementation of {@code LoadableConfig} or an
 * {@code interface} extending {@code LoadableConfig}.
 * <p>
 * {@code LoadableConfigProvider} is a means for avoiding unnecessary access to internal data for {@code classes} which
 * implement decorator {@code interfaces} for configuration beans.
 *
 * @param <ConfigT>   the configuration bean to which this {@code LoadableConfigProvider} provides {@code protected}
 *                    access
 */
@SuppressWarnings("UnusedDeclaration")
public class LoadableConfigProvider<ConfigT extends LoadableConfig> {

    /**
     * The configuration bean to which this {@code LoadableConfigProvider} provides {@code protected} access
     */
    private @Getter(AccessLevel.PROTECTED) ConfigT config;

    /**
     * Constructs a {@code LoadableConfigProvider} which provides {@code protected} access to the specified
     * configuration bean.
     *
     * @param bean  the configuration bean to which this {@code LoadableBeanProvider} provides {@code protected} access
     */
    public LoadableConfigProvider(ConfigT bean) {
        this.config = bean;
    }
}
