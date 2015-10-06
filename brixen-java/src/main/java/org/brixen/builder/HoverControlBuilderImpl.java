package org.brixen.builder;

import org.brixen.bean.HoverControlBean;
import org.brixen.bean.HoverControlBeanImpl;
import org.brixen.pageobject.HoverControl;

/**
 * Serves as a builder of <b>Selenium</b> page objects that model components that contain web controls that have
 * meaningful side effects whenever they are moused over.
 *
 * @param <ControlT>    the type of web control that this {@code HoverControlBuilderImpl} builds
 */
public class HoverControlBuilderImpl<ControlT extends HoverControl> extends
        AbstractHoverControlBuilder<ControlT,HoverControlBean,HoverControlBuilderImpl<ControlT>> {

    /**
     * Constructs a {@code HoverControlBuilderImpl} with the default implementation of {@code HoverControlBean} to
     * define the state of the page object that this {@code HoverControlBuilderImpl} builds.
     */
    public HoverControlBuilderImpl() {
        super(new HoverControlBeanImpl());
    }
}
