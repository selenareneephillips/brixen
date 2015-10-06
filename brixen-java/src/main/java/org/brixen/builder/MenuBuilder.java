package org.brixen.builder;

import org.brixen.bean.MenuBean;
import org.brixen.pageobject.Clickable;
import org.openqa.selenium.WebElement;
import org.brixen.config.MenuConfig;
import org.brixen.pageobject.Menu;
import org.brixen.factory.LoadableFactory;

import java.util.List;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object which models a menu.
 *
 * <p>
 * {@code MenuBuilder} is used in conjunction with {@link MenuBean} and {@link LoadableFactory} to construct page
 * objects. It is designed to be extended by other builder {@code interfaces} for more complex page objects in such a
 * way that any setter function on {@code MenuBuilder} or an {@code interface} that {@code extends} it can be called in
 * any order. See the Javadoc documentation for {@link LoadableBuilder} for an explanation and source code examples
 * that show how this is achieved.
 *
 * @param <MenuT>       the type of menu that this {@code MenuBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the menu that this {@code MenuBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code MenuBuilder}
 */
public interface MenuBuilder<
            MenuT extends Menu<? extends Clickable>,
            BeanT extends MenuBean,
            BuilderT extends MenuBuilder<MenuT,BeanT,BuilderT>
        > extends ContentContainerBuilder<MenuT,BeanT,BuilderT> {

    /**
     * Sets the list of {@code WebElement} that encapsulate the options on the menu.
     *
     * @param optionElements    the list of {@code WebElements} that encapsulates the list of options on the menu
     * @return                  this {@code MenuBuilder}, cast to its runtime type
     */
    BuilderT setOptionElements(List<WebElement> optionElements);

    /**
     * Enables or disables the <b>JavaScript</b> workaround for clicking the options on the menu.
     *
     * @param clickOptionWithJavascript    if {@code true}, enables the Javascript click workaround; {@code false} to
     *                                     disable it
     * @return                             this {@code ClickableBuilder}, cast to its runtime type
     */
    BuilderT setClickOptionWithJavascript(boolean clickOptionWithJavascript);

    /**
     * Enables or disables the <b>JavaScript</b> workaround for clicking the options on the menu with the setting from the
     * specified configuration.
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for
     *                  the menu
     * @return          this {@code ClickableBuilder}, cast to its runtime type
     */
    BuilderT setClickOptionWithJavascript(MenuConfig config);
}

