package org.brixen.builder;

import org.brixen.bean.DynamicControllableBean;
import org.brixen.bean.DynamicControllableBeanImpl;
import org.brixen.pageobject.Polleable;

/**
 * Serves as a builder of <b>Selenium</b> page object that models a component that contains web controls that have
 * meaningful side effects with state changes that need to be polled for an expected condition when they are clicked
 * and/or moused over.
 *
 * @param <ControllableT>    the type of page object that this {@code DynamicControllableBuilder} builds
 */
public class DynamicControllableBuilderImpl<ControllableT extends Polleable> extends
        AbstractDynamicControllableBuilder<
                ControllableT,
                DynamicControllableBean,
                DynamicControllableBuilderImpl<ControllableT>
            > {

    /**
     * Constructs a {@code DynamicControllableBuilderImpl} with the default implementation of
     * {@code DynamicControllableBean} to define the state of the page object that this
     * {@code DynamicControllableBuilderImpl} builds.
     */
    public DynamicControllableBuilderImpl() {
        super(new DynamicControllableBeanImpl());
    }
}
