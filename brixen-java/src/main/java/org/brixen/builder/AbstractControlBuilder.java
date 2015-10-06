package org.brixen.builder;

import org.brixen.pageobject.Control;
import org.brixen.bean.ControlBean;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page objects that model web controls that have meaningful
 * side effects whenever they are clicked and/or moused over.
 *
 * @param <ControlT>    the type of web control that this {@code AbstractControlBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the web control that this
 *                      {@code AbstractControlBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractControlBuilder}
 */
public abstract class AbstractControlBuilder<
            ControlT extends Control,
            BeanT extends ControlBean,
            BuilderT extends ControlBuilder<ControlT,BeanT,BuilderT>
        > extends AbstractContentContainerBuilder<ControlT,BeanT,BuilderT>
          implements ControlBuilder<ControlT,BeanT,BuilderT> {

    /**
     * Constructs an {@code AbstractControlBuilder} with the specified {@code ControlBean} to define the state of
     * the page object.
     *
     * @param state     the {@code ControlBean} that defines the state of the page object
     */
    AbstractControlBuilder(BeanT state) {
        super(state);
    }
}

