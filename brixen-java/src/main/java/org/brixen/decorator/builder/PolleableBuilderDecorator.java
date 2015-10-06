package org.brixen.decorator.builder;

import org.brixen.bean.PolleableBean;
import org.brixen.builder.PolleableBuilder;
import org.brixen.config.PolleableConfig;
import org.brixen.pageobject.Polleable;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code PolleableBuilder}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableBuilderProvider} which wraps the {@code PolleableBuilder} implementation that meets the requirements
 * of {@code PolleableBuilder}. In this way, the {@code class} can implement the {@code PolleableBuilder interface}
 * by proxy without having to define any of the methods itself.
 *
 * @param <PolleableT>  the type of {@code Polleable} that this {@code PolleableBuilderDecorate} builds
 * @param <BeanT>       the data transfer object used to construct the {@code Polleable} that this
 *                      {@code PolleableBuilderDecorator} builds
 * @param <BuilderT>    the runtime type of this {@code PolleableBuilder} that this {@code PolleableBuilderDecorator}
 *                      wraps
 */
public interface PolleableBuilderDecorator<
            PolleableT extends Polleable,
            BeanT extends PolleableBean,
            BuilderT extends PolleableBuilder<PolleableT, BeanT, BuilderT>
        > extends PolleableBuilder<PolleableT,BeanT,BuilderT> {

    /**
     * Gets the {@code LoadableBuilderProvider} for the internal {@code PolleableBuilder} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code PolleableBuilder}.
     *
     * @return  the {@code LoadableBuilderProvider} for the internal {@code PolleableBuilder} implementation to which
     *          this {@code interface} delegates all invocations of the methods required by {@code PolleableBuilder}
     */
    LoadableBuilderProvider<PolleableT,BeanT,BuilderT> getPolleableBuilderProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setPollingTimeout(int pollingTimeout) {
        getPolleableBuilderProvider().getBuilder().getState().setPollingTimeout(pollingTimeout);
        return getPolleableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setPollingInterval(int pollingInterval) {
        getPolleableBuilderProvider().getBuilder().getState().setPollingInterval(pollingInterval);
        return getPolleableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setPollingTimeout(PolleableConfig config) {
        if(config != null) {
            if(config.getPollingTimeout() != null && config.getPollingTimeout().get() != null) {
                getPolleableBuilderProvider().getBuilder().getState()
                        .setPollingTimeout(config.getPollingTimeout().get());
            }
        }

        return getPolleableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setPollingInterval(PolleableConfig config) {
        if(config != null) {
            if(config.getPollingInterval() != null && config.getPollingInterval().get() != null) {
                getPolleableBuilderProvider().getBuilder().getState()
                        .setPollingInterval(config.getPollingInterval().get());
            }
        }

        return getPolleableBuilderProvider().getBuilder();
    }
}
