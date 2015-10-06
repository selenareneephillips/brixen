package org.brixen.pageobject;

import com.google.common.reflect.TypeToken;
import org.brixen.bean.ClickableBean;
import org.brixen.builder.ClickableBuilderImpl;
import org.brixen.factory.RuntimeClassFactory;
import org.brixen.factory.RuntimeClassFactoryImpl;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.brixen.bean.LoadableBean;
import org.brixen.builder.ClickableBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object which models a menu.
 *
 * @param <OptionT>   the type of option that this {@code AbstractMenu} contains
 * @param <MenuT>     the {@code class} which {@code extends} this {@code AbstractMenu}
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractMenu<
            OptionT extends Clickable,
            MenuT extends AbstractMenu<OptionT,MenuT>
        > extends AbstractContentContainer<MenuT> implements Menu<OptionT> {

    /**
     * Used for determining the actual type of the generic parameters at runtime. This is necessary so that it can be
     * passed to the factory method which constructs and returns the menu option object.
     */
    private final TypeToken<AbstractMenu<OptionT,MenuT>> typeToken =
            new TypeToken<AbstractMenu<OptionT,MenuT>>(getClass()) { };

    /**
     * Constructs an {@code AbstractMenu} with the state specified by the {@code LoadableBean}.
     *
     * @param bean  the data transfer object for constructing this {@code AbstractMenu}
     */
    public AbstractMenu(LoadableBean bean) {
        super(bean);
    }

    /**
     * Returns the list of options available in the menu, or an empty list if there are none.
     * <p>
     * If the menu is a drop-down menu, it will be expanded to retrieve the options if it is currently collapsed. It
     * will be collapsed after the options are retrieved.
     *
     * @return      the list of options available in the menu, or an empty list if there are none
     */
    @Override
    public List<OptionT> getOptions() {
        if (isDropDownMenu()) {
            ((Expandable) this).expand();
        }

        List<OptionT> options = buildOptions();

        if (isDropDownMenu()) {
            ((Expandable) this).collapse();
        }

        return options;
    }

    /**
     * Clicks the specified option in the menu.
     * <p>
     * If the menu is a drop-down menu and is currently collapsed, it will be expanded before this method attempts to
     * click the specified option. If clicking the option does not lead to a page load, the menu will be collapsed
     * after the option is clicked, if it is a drop-down menu.
     *
     * @param option    the option in the menu to click
     * @throws IllegalArgumentException if the specified option is not present in the menu
     */
    @Override
    public void clickOption(OptionT option) {
        if(getOptions().contains(option)) {
            if(isDropDownMenu()) {
                ((Expandable)this).expand();
            }

            option.click();

            if(isDropDownMenu()) {
                try {
                    ((Expandable) this).collapse();
                } catch(NoSuchElementException | StaleElementReferenceException e) {
                    //Do nothing. Menu could not be collapsed, possibly because clicking the option lead to another
                    //page
                }
            }
        } else {
            throw new IllegalArgumentException("There is no option on the menu corresponding to " + option.toString());
        }
    }

    /**
     * Returns the list of {@code WebElements} that encapsulate the options on the menu.
     *
     * @return      the list of {@code WebElements} that encapsulate the options on the menu
     */
    protected abstract List<WebElement> getOptionElements();

    /**
     * Determines whether the options on the menu should be clicked using the Javascript workaround.
     *
     * @return      {@code true} if the options on the menu should be clicked using the Javascript workaround;
     *              {@code false} if {@link WebElement#click} should be used to click them
     */
    protected abstract boolean clickOptionWithJavascript();

    /**
     * Builds and returns the list of options in the menu, constructed from the list of {@code WebElements} that
     * encapsulate them.
     *
     * @return      the list of options in the menu, constructed from the list of {@code WebElements} that
     *              encapsulate them
     */
    protected List<OptionT> buildOptions() {
        final List<OptionT> options = new ArrayList<>();

        for(WebElement optionElement : getOptionElements()) {
            final OptionT option = buildOption(optionElement);
            options.add(option);
        }

        return options;
    }

    /**
     * Determines if the menu is a drop-down menu.
     * <p>
     * If the menu {@code implements} {@link Expandable}, it is a drop-down menu.
     *
     * @return      {@code true} if the menu {@code implements} {@link Expandable}; {@code false} otherwise
     */
    protected boolean isDropDownMenu() {
        return Expandable.class.isAssignableFrom(this.getClass());

    }

    /**
     * Returns the builder that constructs the options in the menu.
     *
     * @return      the builder that constructs the options in the menu
     */
    protected ClickableBuilder<OptionT,? extends ClickableBean,?> getOptionBuilder() {
        return new ClickableBuilderImpl<>();
    }

    /**
     * Determines if this {@code AbstractMenu} is loaded.
     * <p>
     * If this {@code AbstractMenu} is a not a drop-down menu, this method checks if its content container
     * {@code WebElement} is displayed. If this {@code AbstractMenu} is not a drop-down menu, this method does nothing.
     *
     * @throws Error if the load checks continue to fail after the load timeout expires
     */
    @Override
    protected void isLoaded() throws Error {
        try {
            if(!isDropDownMenu()) {
                getContentContainer().isDisplayed();
            }
        } catch(NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            throw new Error(e);
        }
    }

    /**
     * Gets the factory object which can determine the runtime {@code Class} type of options on the menu.
     *
     * @return  the factory object which can determine the runtime {@code Class} type of options on the menu.
     */
    protected RuntimeClassFactory getRuntimeClassFactory() {
        return RuntimeClassFactoryImpl.getInstance();
    }

    /**
     * Constructs a menu option of the correct type for the menu from the {@code WebElement} that encapsulates it.
     *
     * @param optionElement     a {@code WebElement} that encapsulates an option on the menu
     * @return                  a menu option of the correct type, constructed from the {@code WebElement} that
     *                          encapsulates it
     */
    @SuppressWarnings("unchecked")
    private OptionT buildOption(WebElement optionElement) {
        ClickableBuilder<OptionT,? extends ClickableBean,?> builder = getOptionBuilder();

        return builder
                .setComponentClass(getOptionClass())
                .setDriver(getDriver())
                .setLoadTimeout(getLoadTimeout())
                .setContentContainer(optionElement)
                .setClickWithJavascript(clickOptionWithJavascript())
                .build();
    }

    /**
     * Gets the runtime {@code Class} type of the options on the menu.
     *
     * @return  the runtime {@code Class} type of the options on the menu.
     */
    @SuppressWarnings("unchecked")
    private Class<OptionT> getOptionClass() {
            final RuntimeClassFactory classFactory = RuntimeClassFactoryImpl.getInstance();
            return (Class<OptionT>) classFactory.create(typeToken, AbstractMenu.class, 0);
    }
}

