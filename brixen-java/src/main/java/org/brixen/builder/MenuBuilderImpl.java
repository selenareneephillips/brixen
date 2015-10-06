package org.brixen.builder;

import org.brixen.bean.MenuBean;
import org.brixen.bean.MenuBeanImpl;
import org.brixen.pageobject.Clickable;
import org.brixen.pageobject.Menu;

/**
 * Serves as a builder of a <b>Selenium</b> page object which models a menu.
 *
 * @param <MenuT>       the type of menu that this {@code MenuBuilderImpl} builds
 */
public class MenuBuilderImpl<MenuT extends Menu<? extends Clickable>>
        extends AbstractMenuBuilder<MenuT,MenuBean,MenuBuilderImpl<MenuT>> {

    /**
     * Constructs an {@code MenuBuilderImpl} with the default implementation of {@code MenuBean} to define the state of
     * the menu that this {@code MenuBuilderImpl} builds.
     */
    public MenuBuilderImpl() {
        super(new MenuBeanImpl());
    }
}
