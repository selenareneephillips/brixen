package org.brixen.builder;

import org.brixen.bean.ContentContainerBean;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebElement;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page objects that model components that wrap a
 * {@link WebElement} content container.
 *
 * @param <LoadableT>   the type of page object that this {@code AbstractContentContainerBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the page object that this
 *                      {@code AbstractContentContainerBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractContentContainerBuilder}
 */
public abstract class AbstractContentContainerBuilder<
            LoadableT extends Loadable,
            BeanT extends ContentContainerBean,
            BuilderT extends ContentContainerBuilder<LoadableT,BeanT,BuilderT>
        >
        extends AbstractLoadableBuilder<LoadableT,BeanT,BuilderT>
        implements ContentContainerBuilder<LoadableT,BeanT,BuilderT> {

    /**
     * Constructs an {@code AbstractContentContainerBuilder} with the specified {@code ContentContainerBean} to define the
     * state of the page object that this {@code AbstractContentContainerBuilder} builds.
     *
     * @param state     the {@code ContentContainerBean} that defines the state of the page object that this
     *                  {@code AbstractContentContainerBuilder} builds
     */
    public AbstractContentContainerBuilder(BeanT state) {
        super(state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setContentContainer(WebElement contentContainer) {
        getState().setContentContainer(contentContainer);
        return (BuilderT)this;
    }
}
