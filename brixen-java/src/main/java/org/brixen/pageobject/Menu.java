package org.brixen.pageobject;

import java.util.List;

/**
 * Defines the contract for a <b>Selenium</b> page object that models a menu.
 *
 * @param <OptionT>   the type of option that this {@code Menu} contains
 */
public interface Menu<OptionT extends Clickable> extends Loadable {

    /**
     * Returns the list of options available in the menu, or an empty list if there are none.
     *
     * @return      the list of options available in the menu, or an empty list if there are none
     */
    List<OptionT> getOptions();

    /**
     * Clicks the specified option in the menu.
     *
     * @param option    the option in the menu to click
     */
    void clickOption(OptionT option);
}
