package org.brixen.builder;

import org.brixen.factory.LoadableFactory;
import org.brixen.pageobject.Control;
import org.brixen.bean.ControlBean;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object that models a web control that has meaningful
 * side effects whenever it is clicked and/or moused over.
 * <p>
 * {@code ControlBuilder} is used in conjunction with {@link ControlBean} and {@link LoadableFactory} to construct page
 * objects. It is designed to be extended by other builder {@code interfaces} for more complex page objects in such a
 * way that any setter function on {@code ControlBuilder} or an {@code interface} that {@code extends} it can be called
 * in any order. See the Javadoc documentation for {@link LoadableBuilder} for an explanation and source code examples
 * that show how this is achieved.
 * <p>
 * {@code ControlBuilder} is a marker {@code interface} that services mainly as a type declaration.
 *
 * @param <ControlT>   the type of {@code Control} that this {@code ControlBuilder} builds
 * @param <BeanT>      the data transfer object used to construct the {@code Control} that this {@code ControlBuilder}
 *                     builds
 * @param <BuilderT>   the runtime type of this {@code ControlBuilder}
 */
public interface ControlBuilder<
            ControlT extends Control,
            BeanT extends ControlBean,
            BuilderT extends ControlBuilder<ControlT,BeanT,BuilderT>
        > extends ContentContainerBuilder<ControlT,BeanT,BuilderT> {
}
