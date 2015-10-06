package org.brixen.decorator.bean;

import org.brixen.bean.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code ControllableBean}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableBeanProvider} which wraps an instance of a concrete implementation of {@code ControllableBean}. In
 * this way, the {@code class} can implement the {@code ControllableBean interface} by proxy without having to define
 * any of the methods itself.
 */
public interface ControllableBeanDecorator extends ControllableBean {

    /**
     * Gets the {@code LoadableBeanProvider} for the internal {@code ControllableBean} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code ControllableBean}.
     *
     * @return  the {@code LoadableBeanProvider} for the internal {@code ControllableBean} implementation to which this
     *          {@code interface} delegates all invocations of the methods required by {@code ControllableBean}
     */
    LoadableBeanProvider<? extends ControllableBean> getControllableBeanProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default void addClickControl(String name) {
        getControllableBeanProvider().getBean().addClickControl(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void addHoverControl(String name) {
        getControllableBeanProvider().getBean().addHoverControl(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void addHoverAndClickControl(String name) {
        getControllableBeanProvider().getBean().addHoverControl(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void addClickControl(String name, Class<? extends ClickControlBean> beanClass) {
        getControllableBeanProvider().getBean().addClickControl(name, beanClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void addHoverControl(String name, Class<? extends HoverControlBean> beanClass) {
        getControllableBeanProvider().getBean().addHoverControl(name, beanClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void addHoverAndClickControl(String name, Class<? extends HoverAndClickControlBean> beanClass) {
        getControllableBeanProvider().getBean().addHoverAndClickControl(name, beanClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setControlDriver(String name, WebDriver driver) {
        getControllableBeanProvider().getBean().setControlDriver(name, driver);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setControlLoadTimeout(String name, int timeout) {
        getControllableBeanProvider().getBean().setControlLoadTimeout(name, timeout);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setControlContentContainer(String name, WebElement contentContainer) {
        getControllableBeanProvider().getBean().setControlContentContainer(name, contentContainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setControlPollingTimeout(String name, int timeout) {
        getControllableBeanProvider().getBean().setControlPollingTimeout(name, timeout);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setControlPollingInterval(String name, int interval) {
        getControllableBeanProvider().getBean().setControlPollingInterval(name, interval);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setControlUnhoverElement(String name, WebElement unhoverElement) {
        getControllableBeanProvider().getBean().setControlUnhoverElement(name, unhoverElement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setUnhoverControlWithJavascript(String name, boolean unhoverWithJavascript) {
        getControllableBeanProvider().getBean().setUnhoverControlWithJavascript(name, unhoverWithJavascript);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setHoverControlWithJavascript(String name, boolean hoverWithJavascript) {
        getControllableBeanProvider().getBean().setHoverControlWithJavascript(name, hoverWithJavascript);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setClickControlWithJavascript(String name, boolean clickWithJavascript) {
        getControllableBeanProvider().getBean().setClickControlWithJavascript(name, clickWithJavascript);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setClickControlInsteadOfHover(String name, boolean clickInsteadOfHover) {
        getControllableBeanProvider().getBean().setClickControlInsteadOfHover(name, clickInsteadOfHover);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setClickControlWithJavascriptInsteadOfHover(String name, boolean clickWithJavascriptInsteadOfHover) {
        getControllableBeanProvider().getBean().setClickControlWithJavascriptInsteadOfHover(name,
                clickWithJavascriptInsteadOfHover);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setUnhoverControlWithClickInstead(String name, boolean unhoverWithClickInstead) {
        getControllableBeanProvider().getBean().setUnhoverControlWithClickInstead(name, unhoverWithClickInstead);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void setUnhoverControlWithJavascriptClickInstead(String name, boolean unhoverWithJavascriptClickInstead) {
        getControllableBeanProvider().getBean().setUnhoverControlWithJavascriptClickInstead(name,
                unhoverWithJavascriptClickInstead);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default Map<String,ControlBean> getControlBeans() {
        return getControllableBeanProvider().getBean().getControlBeans();
    }
}
