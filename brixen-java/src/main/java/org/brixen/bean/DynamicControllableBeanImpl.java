package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.brixen.decorator.bean.PolleableBeanDecorator;
import org.brixen.decorator.bean.LoadableBeanProvider;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a component that contains
 * web controls that have meaningful side effects with state changes that need to be polled for an expected condition
 * when they are clicked and/or moused over.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public class DynamicControllableBeanImpl extends ControllableBeanImpl implements DynamicControllableBean,
        PolleableBeanDecorator {

    /**
     * The {@code LoadableBeanProvider} for the internal {@code PolleableBean} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableBean}.
     */
    private final @Getter LoadableBeanProvider<PolleableBean> polleableBeanProvider =
            new LoadableBeanProvider<>(new PolleableBeanImpl());
}
