package org.brixen.builder;

import org.openqa.selenium.WebElement;
import org.brixen.bean.MenuBean;
import org.brixen.config.MenuConfig;
import org.brixen.pageobject.Clickable;
import org.brixen.pageobject.Menu;

import java.util.List;

/**
 * Serves as an {@code abstract} builder of a <b>Selenium</b> page object which models a menu.
 *
 * @param <MenuT>       the type of menu that this {@code AbstractMenuBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the menu that this {@code AbstractMenuBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractMenuBuilder}
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractMenuBuilder<
            MenuT extends Menu<? extends Clickable>,
            BeanT extends MenuBean,
            BuilderT extends MenuBuilder<MenuT,BeanT,BuilderT>
        > extends AbstractContentContainerBuilder<MenuT,BeanT,BuilderT> implements MenuBuilder<MenuT,BeanT,BuilderT> {

    /**
     * Constructs an {@code AbstractMenuBuilder} with the specified {@code MenuBean} to define the state of
     * the menu that this {@code AbstractMenuBuilder} builds.
     *
     * @param state     the {@code MenuBean} that defines the state of the menu that this {@code AbstractMenuBuilder}
     *                  builds
     */
    public AbstractMenuBuilder(BeanT state) {
        super(state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setOptionElements(List<WebElement> optionElements) {
        getState().setOptionElements(optionElements);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickOptionWithJavascript(boolean clickOptionWithJavascript) {
        getState().setClickOptionWithJavascript(clickOptionWithJavascript);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickOptionWithJavascript(MenuConfig config) {
        if(config != null) {
            if(config.getClickOptionWithJavascript() != null && config.getClickOptionWithJavascript().get() != null) {
                setClickOptionWithJavascript(config.getClickOptionWithJavascript().get());
            }
        }

        return (BuilderT)this;
    }
}
