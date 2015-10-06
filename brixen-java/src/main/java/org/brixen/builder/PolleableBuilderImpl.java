package org.brixen.builder;

import org.brixen.bean.PolleableBean;
import org.brixen.bean.PolleableBeanImpl;
import org.brixen.pageobject.Polleable;

/**
 * Serves as a builder of <b>Selenium</b> page objects that model a dynamic component which needs be polled on
 * intervals for an expected condition via a {@link org.openqa.selenium.support.ui.FluentWait}.
 *
 * @param <PolleableT>  the type of {@code Polleable} that this {@code PolleableBuilderImpl} builds
 */
public class PolleableBuilderImpl<PolleableT extends Polleable> extends
        AbstractPolleableBuilder<PolleableT,PolleableBean, PolleableBuilderImpl<PolleableT>> {

    /**
     * Constructs an {@code PolleableBuilderImpl} with the default implementation of {@code PolleableBean} to define
     * the state of the page object that this {@code PolleableBuilderImpl} builds.
     */
    public PolleableBuilderImpl() {
        super(new PolleableBeanImpl());
    }
}
