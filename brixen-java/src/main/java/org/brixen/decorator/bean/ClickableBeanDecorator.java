package org.brixen.decorator.bean;

import org.brixen.bean.ClickableBean;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code ClickableBean}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableBeanProvider} which wraps an instance of a concrete implementation of {@code ClickableBean}. In this
 * way, the {@code class} can implement the {@code ClickableBean interface} by proxy without having to define any of
 * the methods itself.
 */
public interface ClickableBeanDecorator extends ClickableBean {

    /**
     * Gets the {@code LoadableBeanProvider} for the internal {@code ClickableBean} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code ClickableBean}.
     *
     * @return  the {@code LoadableBeanProvider} for the internal {@code ClickableBean} implementation to which this
     *          {@code interface} delegates all invocations of the methods required by {@code ClickableBean}
     */
    LoadableBeanProvider<ClickableBean> getClickableBeanProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default void setClickWithJavascript(boolean clickWithJavascript) {
        getClickableBeanProvider().getBean().setClickWithJavascript(clickWithJavascript);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default boolean getClickWithJavascript() {
        return getClickableBeanProvider().getBean().getClickWithJavascript();
    }
}
