package org.brixen.builder;

import org.brixen.bean.HoverAndClickControlBean;
import org.brixen.bean.HoverAndClickControlBeanImpl;
import org.brixen.pageobject.HoverAndClickControl;

/**
 * Serves as a builder of <b>Selenium</b> page objects that model components that contain web controls that have
 * meaningful side effects whenever they are clicked and which must be moused over before they are clickable.
 *
 * @param <ControlT>    the type of web control that this {@code HoverAndClickControlBuilderImpl} builds
 */
public class HoverAndClickControlBuilderImpl<ControlT extends HoverAndClickControl> extends
        AbstractHoverAndClickControlBuilder<
                ControlT,
                HoverAndClickControlBean,
                HoverAndClickControlBuilderImpl<ControlT>
        >  {
    /**
     * Constructs a {@code HoverAndClickControlBuilderImpl} with the default implementation of
     * {@code HoverAndClickControlBean} to define the state of the page object that this
     * {@code HoverAndClickControlBuilderImpl} builds.
     */
    public HoverAndClickControlBuilderImpl() {
        super(new HoverAndClickControlBeanImpl());
    }
}
