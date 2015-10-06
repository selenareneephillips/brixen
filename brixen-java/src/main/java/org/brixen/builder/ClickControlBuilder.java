package org.brixen.builder;

import org.brixen.bean.ClickControlBean;
import org.brixen.factory.LoadableFactory;
import org.brixen.pageobject.ClickControl;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object that models a web control that has meaningful
 * side effects whenever it is clicked.
 *
 * <p>
 * {@code ClickControlBuilder} is used in conjunction with {@link ClickControlBean} and {@link LoadableFactory} to
 * construct page objects. It is designed to be extended by other builder {@code interfaces} for more complex page
 * objects in such a way that any setter function on {@code ClickControlBuilder} or an {@code interface} that
 * {@code extends} it can be called in any order. See the Javadoc documentation for {@link LoadableBuilder} for an
 * explanation and source code examples that show how this is achieved.
 *
 * @param <ControlT>   the type of {@code ClickControl} that this {@code ClickControlBuilder} builds
 * @param <BeanT>      the data transfer object used to construct the {@code ClickControl} that this
 *                     {@code ClickControlBuilder} builds
 * @param <BuilderT>   the runtime type of this {@code ClickControlBuilder}
 */
public interface ClickControlBuilder<
            ControlT extends ClickControl,
            BeanT extends ClickControlBean,
            BuilderT extends ClickControlBuilder<ControlT,BeanT,BuilderT>
        > extends ControlBuilder<ControlT,BeanT,BuilderT>,
                  ClickableBuilder<ControlT,BeanT,BuilderT> {
}
