package org.brixen.pageobject;

import lombok.extern.slf4j.XSlf4j;
import org.brixen.bean.LoadableBean;
import org.brixen.function.ClickWithJavascript;
import org.openqa.selenium.WebElement;

/**
 * Serves as an {@code abstract} implementation for page objects that model components which have meaningful behavior
 * when clicked: HTML links, controls that trigger actions like deletion and submission or which open, close, expand,
 * or collapse page objects like menus, dialogs and data entry forms.
 *
 * @param <ClickableT>  the {@code class} which {@code extends} this {@code AbstractClickable}
 */
@XSlf4j
public abstract class AbstractClickable<ClickableT extends AbstractClickable<ClickableT>> extends
        AbstractContentContainer<ClickableT> implements Clickable {

    /**
     * Constructs an {@code AbstractClickable} with the state specified by the {@code LoadableBean}.
     *
     * @param bean  a data transfer object for constructing a page object
     */
    public AbstractClickable(LoadableBean bean) {
        super(bean);
    }

    /**
     * Clicks this {@code AbstractClickable}.
     * <p>
     * If the Javascript click workaround is not enabled, the click is performed with {@link WebElement#click}. If the
     * Javascript click workaround is enabled, Javascript is used to perform the click.
     */
    public void click() {
        if(clickWithJavascript()) {
            log.debug("Clicking with Javascript");
            new ClickWithJavascript().accept(getDriver(), getContentContainer());
        } else {
            log.debug("Clicking with native Selenium method");
            getContentContainer().click();
        }
    }

    /**
     * Determines whether the Javascript click workaround is enabled.
     * <p>
     * If enabled, Javascript will be used to execute a click on this {@code AbstractClickable}. If not, the
     * {@link WebElement#click} method will be used.
     *
     * @return      {@code true} if the Javascript click workaround is enabled; {@code false} otherwise
     */
    protected boolean clickWithJavascript() {
        return false;
    }
}
