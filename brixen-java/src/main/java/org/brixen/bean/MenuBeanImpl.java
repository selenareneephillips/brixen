package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a menu.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class MenuBeanImpl extends ContentContainerBeanImpl implements MenuBean {

    /** The list of the {@code WebElements} that encapsulate the options on the menu */
    private @Getter @Setter List<WebElement> optionElements = new ArrayList<>();

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
