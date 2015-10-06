package org.brixen.pageobject;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.bean.DropDownMenuBean;
import org.brixen.decorator.pageobject.ExpandableDecorator;
import org.brixen.decorator.pageobject.LoadableProvider;
import org.brixen.decorator.pageobject.PolleableDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Serves as an implementation for a <b>Selenium</b> page object which models a drop-down menu which contains
 * {@link BasicMenuOption}{@code s} as options.
 */
public class DropDownBasicMenu extends AbstractMenu<BasicMenuOption,DropDownBasicMenu> implements ExpandableDecorator,
        PolleableDecorator {

    /** The name of the control that expands and collapses this {@code DropDownBasicMenu} */
    public static final String DROP_DOWN_MENU_ACCESSOR_NAME = ExpandableImpl.EXPANDABLE_CONTROL_NAME;

    /**
     * The provider for the {@code Expandable} that implements the drop-down behavior for this
     * {@code DropDownBasicMenu}
     */
    private final @Getter LoadableProvider<Expandable> expandableProvider;

    /**
     * Provider for internal {@code Polleable} that encapsulates the polleable behavior for this
     * {@code DropDownBasicMenu}.
     */
    private final @Getter LoadableProvider<Polleable> polleableProvider;

    /** The {@code WebElements} that encapsulate the options on the menu **/
    private @Getter(value = AccessLevel.PROTECTED) List<WebElement> optionElements;

    /** The {@code WebElement} that wraps the options on the menu **/
    private @Getter(value = AccessLevel.PROTECTED) WebElement contentContainer;

    /** Flag for enabling, disabling the Javascript click workaround for the menu options */
    private boolean clickOptionWithJavascript;

    /**
     * Constructs a {@code DropDownBasicMenu} with the state specified by the {@code DropDownBasicMenu}.
     *
     * @param bean  the data transfer object for constructing this {@code DropDownBasicMenu}
     */
    public DropDownBasicMenu(final DropDownMenuBean bean) {
        super(bean);

        Expandable expandable = new ExpandableImpl(bean);

        this.expandableProvider = new LoadableProvider<>(expandable);
        this.polleableProvider = new LoadableProvider<>(expandable);

        this.optionElements = bean.getOptionElements();
        this.contentContainer = bean.getContentContainer();
        this.clickOptionWithJavascript = bean.getClickOptionWithJavascript();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean clickOptionWithJavascript() {
        return clickOptionWithJavascript;
    }

    /**
     * Determines if this {@code DropDownMenuImpl} is loaded by checking whether its content container is present or
     * not.
     *
     * @throws Error if the load checks continue to fail after the load timeout expires
     */
    @Override protected void isLoaded() throws Error {
        try {
            getContentContainer().isDisplayed();
        } catch(NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            throw new Error("The WebElement content container threw a NoSuchElementException, so the menu is not " +
                    "loaded", e);
        }
    }
}
