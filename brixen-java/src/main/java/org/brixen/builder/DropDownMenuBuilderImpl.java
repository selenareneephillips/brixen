package org.brixen.builder;

import org.brixen.bean.DropDownMenuBeanImpl;
import org.brixen.pageobject.Clickable;
import org.brixen.pageobject.Expandable;
import org.brixen.bean.DropDownMenuBean;
import org.brixen.pageobject.Menu;

/**
 * Serves as a builder of a <b>Selenium</b> page object which models a drop down menu.
 *
 * @param <MenuT>       the type of drop down menu that this {@code DropDownMenuBuilderImpl} builds
 */
@SuppressWarnings("UnusedDeclaration")
public class DropDownMenuBuilderImpl<MenuT extends Menu<? extends Clickable> & Expandable> extends
        AbstractDropDownMenuBuilder<MenuT, DropDownMenuBean, DropDownMenuBuilderImpl<MenuT>> {

    /**
     * Constructs an {@code DropDownMenuBuilderImpl} with the default implementation of {@code DropDownMenuBean} to
     * define the state of the drop down menu that this {@code AbstractDropDownMenuBuilderImpl} builds.
     */
    public DropDownMenuBuilderImpl() {
        super(new DropDownMenuBeanImpl());
    }
}
