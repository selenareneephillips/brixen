package org.brixen.bean;

import lombok.*;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a {@code Clickable}
 * component.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public class ClickableBeanImpl extends ContentContainerBeanImpl implements ClickableBean {

    /** Flag for enabling, disabling the Javascript click workaround */
    private @Setter(onMethod=@__(@Override)) @NonNull boolean clickWithJavascript = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getClickWithJavascript() {
        return clickWithJavascript;
    }

}
