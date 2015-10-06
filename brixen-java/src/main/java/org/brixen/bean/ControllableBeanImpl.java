package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.brixen.factory.LoadableBeanFactoryImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.brixen.factory.LoadableBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a
 * component that contains web controlBeans that have meaningful side effects whenever they are clicked and/or moused over.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class ControllableBeanImpl extends ContentContainerBeanImpl implements ControllableBean {

    /** The {@code ControlBeans} that specify the web controlBeans for the page object */
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private @Getter Map<String,ControlBean> controlBeans = new HashMap<>();

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is already a {@code ControlBean} for a control with the specified name
     */
    @Override
    public void addClickControl(String name) {
        if(controlBeans.get(name) != null) {
            throw new IllegalArgumentException("There is already a control named " + name);
        }

        controlBeans.put(name, new ClickControlBeanImpl());
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is already a {@code ControlBean} for a control with the specified name
     */
    @Override
    public void addHoverControl(String name) {
        if(controlBeans.get(name) != null) {
            throw new IllegalArgumentException("There is already a control named " + name);
        }

        controlBeans.put(name, new HoverControlBeanImpl());
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is already a {@code ControlBean} for a control with the specified name
     */
    @Override
    public void addHoverAndClickControl(String name) {
        if(controlBeans.get(name) != null) {
            throw new IllegalArgumentException("There is already a control named " + name);
        }

        controlBeans.put(name, new HoverAndClickControlBeanImpl());
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is already a {@code ControlBean} for a control with the specified name
     */
    @Override
    public void addClickControl(String name, Class<? extends ClickControlBean> beanClass) {
        if(controlBeans.get(name) != null) {
            throw new IllegalArgumentException("There is already a control named " + name);
        }

        controlBeans.put(name, getLoadableBeanFactory().create(beanClass));
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is already a {@code ControlBean} for a control with the specified name
     */
    @Override
    public void addHoverControl(String name, Class<? extends HoverControlBean> beanClass) {
        if(controlBeans.get(name) != null) {
            throw new IllegalArgumentException("There is already a control named " + name);
        }

        controlBeans.put(name, getLoadableBeanFactory().create(beanClass));
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is already a {@code ControlBean} for a control with the specified name
     */
    @Override
    public void addHoverAndClickControl(String name, Class<? extends HoverAndClickControlBean> beanClass) {
        if(controlBeans.get(name) != null) {
            throw new IllegalArgumentException("There is already a control named " + name);
        }

        controlBeans.put(name, getLoadableBeanFactory().create(beanClass));
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name
     */
    @Override
    public void setControlDriver(String name, WebDriver driver) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        bean.setDriver(driver);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name
     */
    @Override
    public void setControlContentContainer(String name, WebElement contentContainer) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        bean.setContentContainer(contentContainer);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name
     * @throws IllegalStateException if the {@code ControlBean} for the control does not specify a polleable control
     */
    @Override
    public void setControlPollingTimeout(String name, int timeout) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!PolleableBean.class.isAssignableFrom(bean.getClass())) {
            throw new IllegalStateException("The control named " + name + " is not a polleable control");
        }

        ((PolleableBean)bean).setPollingTimeout(timeout);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name
     * @throws IllegalStateException if the {@code ControlBean} for the control does not specify a polleable control
     */
    public void setControlPollingInterval(String name, int interval) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!PolleableBean.class.isAssignableFrom(bean.getClass())) {
            throw new IllegalStateException("The control named " + name + " is not a polleable control");
        }

        ((PolleableBean)bean).setPollingInterval(interval);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name
     */
    @Override
    public void setControlLoadTimeout(String name, int timeout) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        bean.setLoadTimeout(timeout);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name
     * @throws IllegalStateException if the {@code ControlBean} for the control does not specify a {@code HoverControl}
     *         or a {@code HoverAndClickControl}
     */
    @Override
    public void setControlUnhoverElement(String name, WebElement unhoverElement) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isHoverControl() && !bean.isHoverAndClickControl()) {
            throw new IllegalStateException("The control named " + name + " is not a hover control");
        }

        if(bean.isHoverControl()) {
            ((HoverControlBean) bean).setUnhoverElement(unhoverElement);
        } else {
            ((HoverAndClickControlBean) bean).setUnhoverElement(unhoverElement);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name or if
     *         the {@code ControlBean} for the control does not specify a {@code HoverControl} or a
     *         {@code HoverAndClickControl}
     */
    @Override
    public void setHoverControlWithJavascript(String name, boolean hoverWithJavascript) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isHoverControl() && !bean.isHoverAndClickControl()) {
            throw new IllegalArgumentException("The control named " + name + " is not a hover or a hover and click " +
                    "control");
        }

        if(bean.isHoverControl()) {
            ((HoverControlBean) bean).setHoverWithJavascript(hoverWithJavascript);
        } else {
            ((HoverAndClickControlBean) bean).setHoverWithJavascript(hoverWithJavascript);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name or if
     *         the {@code ControlBean} for the control does not specify a {@code HoverControl} or a
     *         {@code HoverAndClickControl}
     */
    @Override
    public void setUnhoverControlWithJavascript(String name, boolean unhoverWithJavascript) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isHoverControl() && !bean.isHoverAndClickControl()) {
            throw new IllegalArgumentException("The control named " + name + " is not a hover or a hover and click " +
                    "control");
        }

        if(bean.isHoverControl()) {
            ((HoverControlBean) bean).setUnhoverWithJavascript(unhoverWithJavascript);
        } else {
            ((HoverAndClickControlBean) bean).setUnhoverWithJavascript(unhoverWithJavascript);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name or if
     *         the {@code ControlBean} for the control does not specify a {@code ClickControl} or a
     *         {@code HoverAndClickControl}
     */
    @Override
    public void setClickControlWithJavascript(String name, boolean clickWithJavascript) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isClickControl() && !bean.isHoverAndClickControl()) {
            throw new IllegalStateException("The control named " + name + " is not a click or a hover and click " +
                    "control");
        }

        ((ClickControlBean)bean).setClickWithJavascript(clickWithJavascript);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name or if
     *         the {@code ControlBean} for the control does not specify a {@code HoverControl}
     */
    @Override
    public void setClickControlInsteadOfHover(String name, boolean clickInsteadOfHover) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isHoverControl()) {
            throw new IllegalArgumentException("The control named " + name + " is not a hover control");
        }

        ((HoverControlBean)bean).setClickInsteadOfHover(clickInsteadOfHover);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name or if
     *         the {@code ControlBean} for the control does not specify a {@code HoverControl} or a
     *         {@code HoverAndClickControl}
     */
    @Override
    public void setClickControlWithJavascriptInsteadOfHover(String name, boolean clickWithJavascriptInsteadOfHover) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isHoverControl() && !bean.isHoverAndClickControl()) {
            throw new IllegalStateException("The control named " + name + " is not a click or a hover and click " +
                    "control");
        }


        if(bean.isHoverControl()) {
            ((HoverControlBean) bean).setClickWithJavascriptInsteadOfHover(clickWithJavascriptInsteadOfHover);
        } else {
            ((HoverAndClickControlBean) bean).setClickWithJavascriptInsteadOfHover(clickWithJavascriptInsteadOfHover);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name or if
     *         the {@code ControlBean} for the control does not specify a {@code HoverControl} or a
     *         {@code HoverAndClickControl}
     */
    @Override
    public void setUnhoverControlWithClickInstead(String name, boolean unhoverWithClickInstead) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isHoverControl() && !bean.isHoverAndClickControl()) {
            throw new IllegalStateException("The control named " + name + " is not a click or a hover and click " +
                    "control");
        }


        if(bean.isHoverControl()) {
            ((HoverControlBean) bean).setUnhoverWithClickInstead(unhoverWithClickInstead);
        } else {
            ((HoverAndClickControlBean) bean).setUnhoverWithClickInstead(unhoverWithClickInstead);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if there is no {@code ControlBean} for a control with the specified name or if
     *         the {@code ControlBean} for the control does not specify a {@code HoverControl} or a
     *         {@code HoverAndClickControl}
     */
    @Override
    public void setUnhoverControlWithJavascriptClickInstead(String name, boolean unhoverWithJavascriptClickInstead) {
        ControlBean bean = controlBeans.get(name);

        if(bean == null) {
            throw new IllegalArgumentException("There is no control named " + name);
        }

        if(!bean.isHoverControl() && !bean.isHoverAndClickControl()) {
            throw new IllegalStateException("The control named " + name + " is not a click or a hover and click " +
                    "control");
        }


        if(bean.isHoverControl()) {
            ((HoverControlBean) bean).setUnhoverWithJavascriptClickInstead(unhoverWithJavascriptClickInstead);
        } else {
            ((HoverAndClickControlBean) bean).setUnhoverWithJavascriptClickInstead(unhoverWithJavascriptClickInstead);
        }
    }

    /**
     * Gets an instance of the factory which instantiates non-default {@code ControlBean} implementations.
     *
     * @return  an instance of the factory which instantiates non-default {@code ControlBean} implementations
     */
    protected LoadableBeanFactory getLoadableBeanFactory() {
        return LoadableBeanFactoryImpl.getInstance();
    }
}