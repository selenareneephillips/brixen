package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.brixen.decorator.bean.LoadableBeanProvider;
import org.brixen.decorator.bean.ClickableBeanDecorator;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a web control that has
 * meaningful side effects whenever it is clicked.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public class ClickControlBeanImpl extends ContentContainerBeanImpl implements ClickControlBean, ClickableBeanDecorator {

    /**
     * The {@code LoadableBeanProvider} for the internal {@code ClickableBean} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code ClickableBean}.
     */
    private final @Getter LoadableBeanProvider<ClickableBean> clickableBeanProvider =
            new LoadableBeanProvider<>(new ClickableBeanImpl());
}
