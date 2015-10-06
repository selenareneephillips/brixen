package org.brixen.builder;

import org.brixen.bean.LoadableBeanImpl;
import org.brixen.pageobject.Loadable;
import org.brixen.bean.LoadableBean;

/**
 * Serves as a builder of basic <b>Selenium</b> page objects.
 *
 * @param <LoadableT>   the type of page object that this {@code LoadableBuilderImpl} builds
 */
public class LoadableBuilderImpl<LoadableT extends Loadable>
        extends AbstractLoadableBuilder<LoadableT, LoadableBean, LoadableBuilderImpl<LoadableT>> {

    /**
     * Constructs an {@code LoadableBuilderImpl} with the default {@code LoadableBean} implementation to define the
     * state of the {@code Loadable} that this {@code LoadableBuilderImpl} builds.
     */
    public LoadableBuilderImpl() {
        super(new LoadableBeanImpl());
    }
}
