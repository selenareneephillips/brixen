package org.brixen.bean;

import lombok.*;
import org.openqa.selenium.WebElement;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a web control that has
 * meaningful side effects whenever it is moused over.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class HoverControlBeanImpl extends ContentContainerBeanImpl implements HoverControlBean {

    /** The element to send the focus to when unhovering the web control */
    private @Getter(onMethod=@__(@Override)) @Setter(onMethod=@__(@Override)) @NonNull WebElement unhoverElement;

    /** Flag for enabling, disabling the Javascript hover workaround for the web control*/
    private @Setter(onMethod=@__(@Override)) boolean hoverWithJavascript = false;

    /** Flag for enabling/disabling the unhover with Javascript workaround for the unhover element */
    private @Setter(onMethod=@__(@Override)) boolean unhoverWithJavascript = false;

    /** Flag for enabling, disabling the click action workaround for the web control */
    private @Setter(onMethod=@__(@Override)) boolean clickInsteadOfHover = false;

    /** Flag for enabling, disabling the Javascript click action workaround for the web control */
    private @Setter(onMethod=@__(@Override)) boolean clickWithJavascriptInsteadOfHover = false;

    /** Flag for enabling, disabling the click action workaround for the unhover element */
    private @Setter(onMethod=@__(@Override)) boolean unhoverWithClickInstead = false;

    /** Flag for enabling, disabling the Javascript click action workaround for the unhover element */
    private @Setter(onMethod=@__(@Override)) boolean unhoverWithJavascriptClickInstead = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getHoverWithJavascript() {
        return hoverWithJavascript;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getUnhoverWithJavascript() {
        return unhoverWithJavascript;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getClickInsteadOfHover() {
        return clickInsteadOfHover;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getClickWithJavascriptInsteadOfHover() {
        return clickWithJavascriptInsteadOfHover;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getUnhoverWithClickInstead() {
        return unhoverWithClickInstead;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getUnhoverWithJavascriptClickInstead() {
        return unhoverWithJavascriptClickInstead;
    }
}
