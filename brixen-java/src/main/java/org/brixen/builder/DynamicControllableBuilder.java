package org.brixen.builder;

import org.brixen.bean.DynamicControllableBean;
import org.brixen.factory.LoadableFactory;
import org.brixen.pageobject.Polleable;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object that models a component that contains web
 * controls that have meaningful side effects with state changes that need to be polled for an expected condition when
 * they are clicked and/or moused over.
 * <p>
 *
 * {@code DynamicControllableBuilder} is used in conjunction with {@link DynamicControllableBean} and
 * {@link LoadableFactory} to construct page objects. It is designed to be extended by other builder {@code interfaces}
 * for more complex page objects in such a way that any setter function on {@code DynamicControllableBuilder} or an
 * {@code interface} that {@code extends} it can be called in any order. See the Javadoc documentation for
 * {@link LoadableBuilder} for an explanation and source code examples that show how this is achieved.
 *
 * @param <ControllableT>   the type of page object that this {@code DynamicControllableBuilder} builds
 * @param <BeanT>           the data transfer object used to construct the page object that this
 *                          {@code DynamicControllableBuilder} builds
 * @param <BuilderT>        the runtime type of this {@code DynamicControllableBuilder}
 */
public interface DynamicControllableBuilder<
            ControllableT extends Polleable,
            BeanT extends DynamicControllableBean,
            BuilderT extends DynamicControllableBuilder<ControllableT,BeanT,BuilderT>
        > extends ControllableBuilder<ControllableT,BeanT,BuilderT>,
                  PolleableBuilder<ControllableT,BeanT,BuilderT> {
}
