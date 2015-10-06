package org.brixen.builder;

import org.brixen.bean.PolleableBean;
import org.brixen.config.PolleableConfig;
import org.brixen.pageobject.Polleable;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page objects which model dynamic components which need to
 * be polled on intervals for an expected condition via a {@link org.openqa.selenium.support.ui.FluentWait}.
 *
 * @param <PolleableT>  the type of {@code Polleable} that this {@code AbstractPolleableBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the {@code Polleable} that this
 *                      {@code AbstractPolleableBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractPolleableBuilder}
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractPolleableBuilder<
            PolleableT extends Polleable,
            BeanT extends PolleableBean,
            BuilderT extends PolleableBuilder<PolleableT, BeanT, BuilderT>
        >
        extends AbstractLoadableBuilder<PolleableT, BeanT, BuilderT>
        implements PolleableBuilder<PolleableT, BeanT, BuilderT> {

    /**
     * Constructs an {@code AbstractPolleableBuilder} with the specified {@code PolleableBean} to define the state of
     * the page object that this {@code AbstractPolleableBuilder} builds.
     *
     * @param state     the {@code PolleableBean} that defines the state of the page object that this
     *                  {@code AbstractPolleableBuilder} builds
     * @throws NullPointerException if the specified bean is {@code null}
     */
    public AbstractPolleableBuilder(BeanT state) {
        super(state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setPollingTimeout(int pollingTimeout) {
        getState().setPollingTimeout(pollingTimeout);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setPollingInterval(int pollingInterval) {
        getState().setPollingInterval(pollingInterval);
        return (BuilderT)this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setPollingTimeout(PolleableConfig config) {
        if(config != null) {
            if(config.getPollingTimeout() != null && config.getPollingTimeout().get() != null) {
                setPollingTimeout(config.getPollingTimeout().get());
            }
        }

        return (BuilderT)this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setPollingInterval(PolleableConfig config) {
        if(config != null) {
            if(config.getPollingInterval() != null && config.getPollingInterval().get() != null) {
                setPollingInterval(config.getPollingInterval().get());
            }
        }

        return (BuilderT)this;
    }
}
