package org.brixen.bean;

import lombok.*;
import org.brixen.decorator.bean.ClickableBeanDecorator;
import org.brixen.decorator.bean.LoadableBeanProvider;
import org.brixen.decorator.bean.PolleableBeanDecorator;
import org.openqa.selenium.WebElement;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a web control that has
 * meaningful side effects whenever it is clicked and which must be moused over before it is clickable.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public class HoverAndClickControlBeanImpl extends ClickControlBeanImpl implements HoverAndClickControlBean,
        ClickableBeanDecorator, PolleableBeanDecorator {

    /**
     * The {@code LoadableBeanProvider} for the internal {@code PolleableBean} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableBean}.
     */
    private final @Getter(onMethod=@__(@Override)) LoadableBeanProvider<PolleableBean> polleableBeanProvider =
            new LoadableBeanProvider<>(new PolleableBeanImpl());

    /** The element to send the focus to when unhovering the web control */
    private @Getter(onMethod=@__(@Override)) @Setter(onMethod=@__(@Override)) @NonNull WebElement unhoverElement;

    /** Flag for enabling, disabling the Javascript hover workaround for the web control*/
    private @Setter(onMethod=@__(@Override)) boolean hoverWithJavascript = false;

    /** Flag for enabling/disabling the unhover with Javascript workaround for the unhover element */
    private @Setter(onMethod=@__(@Override)) boolean unhoverWithJavascript = false;

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
     *
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
