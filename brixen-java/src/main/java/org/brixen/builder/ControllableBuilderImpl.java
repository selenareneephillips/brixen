package org.brixen.builder;

import org.brixen.bean.ControllableBean;
import org.brixen.bean.ControllableBeanImpl;
import org.brixen.pageobject.Loadable;

/**
 * Serves as a builder of <b>Selenium</b> page objects that model components that contain web controls that have
 * meaningful side effects whenever they are clicked and/or moused over.
 *
 * @param <ControllableT>    the type of page object that this {@code ControllableBuilder} builds
 */
public class ControllableBuilderImpl<ControllableT extends Loadable> extends
        AbstractControllableBuilder<ControllableT,ControllableBean,ControllableBuilderImpl<ControllableT>> {

    /**
     * Constructs a {@code ControllableBuilderImpl} with the default implementation of {@code ControllableBean} to
     * define the state of the page object that this {@code ControllableBuilderImpl} builds.
     */
    public ControllableBuilderImpl() {
        super(new ControllableBeanImpl());
    }
}
