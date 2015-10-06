package org.brixen.bean;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.brixen.decorator.bean.ControllableBeanDecorator;
import org.brixen.decorator.bean.PolleableBeanDecorator;
import org.brixen.decorator.bean.LoadableBeanProvider;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a drop-down menu.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class DropDownMenuBeanImpl extends MenuBeanImpl implements DropDownMenuBean, PolleableBeanDecorator,
        ControllableBeanDecorator {

    /**
     * The {@code LoadableBeanProvider} for the internal {@code PolleableBean} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableBean}.
     */
    private final @Getter LoadableBeanProvider<PolleableBean> polleableBeanProvider =
            new LoadableBeanProvider<>(new PolleableBeanImpl());

    /**
     * The {@code LoadableBeanProvider} for the internal {@code ControllableBean} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code ControllableBean}.
     */
    private final @Getter LoadableBeanProvider<ControllableBean> controllableBeanProvider =
            new LoadableBeanProvider<>(new ControllableBeanImpl());
}
