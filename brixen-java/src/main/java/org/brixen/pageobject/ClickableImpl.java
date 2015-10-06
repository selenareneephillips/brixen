package org.brixen.pageobject;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.bean.ClickableBean;
import org.openqa.selenium.WebElement;

/**
 * Serves as a basic implementation for a <b>Selenium</b> page object that models a component which has meaningful
 * behavior when clicked: an HTML link, a control that triggers actions like deletion and submission or which opens,
 * closes, expands, or collapses a page object like a menu, dialog or a data entry form.
 */
public class ClickableImpl extends AbstractClickable<ClickableImpl> {

    /** The clickable {@code WebElement} for the {@code ClickableImpl} */
    private final @Getter(AccessLevel.PROTECTED) WebElement contentContainer;

    /** Flag for enabling, disabling the Javascript click workaround */
    private final boolean clickWithJavascript;

    /**
     * Constructs an {@code ClickableImpl} with the state specified by the {@code ClickableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code ClickableImpl}
     */
    public ClickableImpl(ClickableBean bean) {
        super(bean);

        this.contentContainer = bean.getContentContainer();
        this.clickWithJavascript = bean.getClickWithJavascript();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean clickWithJavascript() {
        return clickWithJavascript;
    }
}
