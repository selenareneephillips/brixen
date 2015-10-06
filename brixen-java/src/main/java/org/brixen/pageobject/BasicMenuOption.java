package org.brixen.pageobject;

import com.google.common.base.Objects;
import lombok.AccessLevel;
import lombok.Getter;

import lombok.extern.slf4j.XSlf4j;
import org.brixen.bean.ClickableBean;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 * Serves as a basic implementation for a <b>Selenium</b> page object that models a basic menu option.
 */
@XSlf4j
public class BasicMenuOption extends AbstractClickable<BasicMenuOption> implements Clickable {

    /** Content container which contains all the menu options */
    private final @Getter(value = AccessLevel.PROTECTED) WebElement contentContainer;

    /** Flag for enabling, disabling the Javascript click workaround */
    private final boolean clickWithJavascript;

    /** Visible text label for the menu option */
    private final @Getter String label;

    /**
     * Constructs a {@code BasicMenuOption} with the state specified by the {@code ElementWrapperBean}.
     *
     * @param bean  the data transfer object for constructing this {@code BasicMenuOption}
     */
    public BasicMenuOption(final ClickableBean bean) {
        super(bean);

        this.contentContainer = bean.getContentContainer();
        this.clickWithJavascript= bean.getClickWithJavascript();
        this.label = bean.getContentContainer().getText();
    }

    /**
     * Determines if the specified object is equal to this {@code BasicMenuOption}.
     * <p>
     * The specified object is equal to this {@code BasicMenuOption} if their option {@code WebElements} are the same
     * object reference and their {@code WebDrivers} and load timeouts are equal.
     *
     * @param o     the object to compare to this {@code BasicMenuOption} to determine equality
     * @return      {@code true} if the specified object is equal to {@code BasicMenuOption}; {@code false} otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final BasicMenuOption that = (BasicMenuOption) o;

        return Objects.equal(this.getContentContainer(), that.getContentContainer()) &&
                Objects.equal(this.getDriver(), that.getDriver()) &&
                Objects.equal(this.getLoadTimeout(), that.getLoadTimeout());
    }

    /**
     * Generates a hash code for this {@code BasicMenuOption}.
     *
     * @return      a hash code for this {@code BasicMenuOption}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getContentContainer(), getDriver(), getLoadTimeout());
    }

    /**
     * Determines whether the Javascript click workaround is enabled.
     * <p>
     * If enabled, Javascript will be used to execute a click on the menu option. If not, the {@link WebElement#click}
     * method will be used.
     *
     * @return      {@code true} if the Javascript click workaround is enabled; {@code false} otherwise
     */
    protected boolean clickWithJavascript() {
        return clickWithJavascript;
    }

    /**
     * Determines if this {@code BasicMenuOption} is loaded by checking whether the {@code WebElement} that represents
     * it is displayed.
     *
     * @throws Error if the load checks continue to fail after the load timeout expires
     */
    @Override
    protected void isLoaded() throws Error {
        try {
            contentContainer.isDisplayed();
        } catch(NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            throw new Error("The menu option is not visible, so it is not loaded", e);
        }
    }
}
