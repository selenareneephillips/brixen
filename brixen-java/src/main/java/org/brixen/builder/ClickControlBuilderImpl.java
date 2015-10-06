package org.brixen.builder;

import org.brixen.bean.ClickControlBeanImpl;
import org.brixen.pageobject.ClickControl;
import org.brixen.bean.ClickControlBean;

/**
 * Serves as a builder of <b>Selenium</b> page object that models a web control that has meaningful side effects
 * whenever it is clicked.
 *
 * @param <ControlT>     the type of {@code ClickControl} this {@code ClickControlBuilder} builds
 */
public class ClickControlBuilderImpl<ControlT extends ClickControl> extends
        AbstractClickControlBuilder<ControlT,ClickControlBean,ClickControlBuilderImpl<ControlT>> {

    /**
     * Constructs a {@code ClickControlBuilderImpl} with the default implementation of {@code ClickControlBean} to
     * define the state of the {@code ClickControl} that this {@code ClickControlBuilderImpl} builds.
     */
    public ClickControlBuilderImpl() {
        super(new ClickControlBeanImpl());
    }
}
