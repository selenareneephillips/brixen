package org.brixen.builder;

import lombok.Getter;
import org.brixen.config.LoadableConfig;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebDriver;
import org.brixen.bean.LoadableBean;
import org.brixen.factory.LoadableFactory;
import org.brixen.factory.LoadableFactoryImpl;

/**
 * Serves as an {@code abstract} builder of basic <b>Selenium</b> page objects.
 *
 * @param <LoadableT>   the type of page object that this {@code AbstractLoadableBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the page object that this
 *                      {@code AbstractLoadableBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractLoadableBuilder}
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractLoadableBuilder<
            LoadableT extends Loadable,
            BeanT extends LoadableBean,
            BuilderT extends LoadableBuilder<LoadableT, BeanT, BuilderT>
        >
        implements LoadableBuilder<LoadableT, BeanT, BuilderT> {

    /**
     * The data transfer object that specifies the necessary information to construct an instance of the page object
     * that this {@code AbstractLoadableBuilder} builds
     */
    private final @Getter BeanT state;

    /** The {@code Class} that of the page object that this {@code AbstractLoadableBuilder} builds */
    private @Getter Class<LoadableT> componentClass;

    /**
     * Constructs an {@code AbstractLoadableBuilder} with the specified {@code LoadableBean} to define the state of
     * the page object that this {@code AbstractLoadableBuilder} builds.
     *
     * @param state     the {@code LoadableBean} that defines the state of the page object that this
     *                  {@code AbstractLoadableBuilder} builds
     */
    @SuppressWarnings("unchecked")
    public AbstractLoadableBuilder(BeanT state) {
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setComponentClass(Class<LoadableT> componentClass) {
        this.componentClass = componentClass;
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setDriver(WebDriver driver) {
        getState().setDriver(driver);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setLoadTimeout(int loadTimeout) {
        getState().setLoadTimeout(loadTimeout);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setLoadTimeout(LoadableConfig config) {
        if(config != null) {
            if(config.getLoadTimeout() != null && config.getLoadTimeout().get() != null) {
                setLoadTimeout(config.getLoadTimeout().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoadableT build() {
        return getLoadableFactory().create(getState(), componentClass);
    }

    /**
     * Gets an instance of the factory which constructs the page object that this {@code AbstractLoadableBuilder}
     * builds.
     *
     * @return  an instance of the factory which constructs the page object that this {@code AbstractLoadableBuilder}
     *          builds
     */
    protected LoadableFactory getLoadableFactory() {
        return LoadableFactoryImpl.getInstance();
    }
}
