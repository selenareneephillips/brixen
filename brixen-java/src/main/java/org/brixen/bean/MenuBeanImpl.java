package org.brixen.bean;

import lombok.*;
import org.openqa.selenium.WebElement;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a menu.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public class MenuBeanImpl extends ContentContainerBeanImpl implements MenuBean {

    /** The list of the {@code WebElements} that encapsulate the options on the menu */
    private @Getter(onMethod=@__(@Override)) @Setter(onMethod=@__(@Override)) @NonNull List<WebElement>
            optionElements = new ArrayList<>();

    /**
     * If {@code true}, a <b>JavaScript</b> workaround must be used to click a menu option because the native
     * <b>Selenium</b> click action fails silently.
     */
    private boolean clickOptionWithJavascript = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClickOptionWithJavascript(boolean clickOptionWithJavascript) {
        this.clickOptionWithJavascript = clickOptionWithJavascript;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getClickOptionWithJavascript() {
        return clickOptionWithJavascript;
    }
}
