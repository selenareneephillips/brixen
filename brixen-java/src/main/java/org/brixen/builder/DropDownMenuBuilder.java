package org.brixen.builder;

import org.brixen.bean.DropDownMenuBean;
import org.brixen.factory.LoadableFactory;
import org.brixen.pageobject.Expandable;
import org.brixen.pageobject.Menu;
import org.brixen.pageobject.Clickable;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object which models a drop down menu.
 *
 * <p>
 * {@code DropDownMenuBuilder} is used in conjunction with {@link DropDownMenuBean} and {@link LoadableFactory} to
 * construct page objects. It is designed to be extended by other builder {@code interfaces} for more complex page
 * objects in such a way that any setter function on {@code MenuBuilder} or an {@code interface} that {@code extends}
 * it can be called in any order. See the Javadoc documentation for {@link LoadableBuilder} for an explanation and
 * source code examples that show how this is achieved.
 *
 * @param <MenuT>       the type of drop down menu that this {@code DropDownMenuBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the drop down menu that this
 *                      {@code DropDownMenuBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code DropDownMenuBuilder}
 *
 */
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public interface DropDownMenuBuilder<
            MenuT extends Menu<? extends Clickable> & Expandable,
            BeanT extends DropDownMenuBean,
            BuilderT extends DropDownMenuBuilder<MenuT,BeanT,BuilderT>
        > extends MenuBuilder<MenuT,BeanT,BuilderT>, DynamicControllableBuilder<MenuT,BeanT,BuilderT> {
}
