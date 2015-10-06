package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a {@code Clickable}
 * component.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class ClickableBeanImpl extends ContentContainerBeanImpl implements ClickableBean {

    /** Flag for enabling, disabling the Javascript click workaround */
    private @Setter boolean clickWithJavascript = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getClickWithJavascript() {
        return clickWithJavascript;
    }

}
