package org.brixen.pageobject;

import org.brixen.bean.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object that models a component that contains
 * web controls that have meaningful side effects whenever they are clicked and/or moused over.
 *
 * @param <ControllableT>   the {@code class} which {@code extends} this {@code AbstractControllable}
 */
public abstract class AbstractControllable<ControllableT extends AbstractControllable<ControllableT>> extends
        AbstractContentContainer<ControllableT> {

    /** The web controls for this {@code AbstractControllable} */
    private Map<String,Control> controls = new HashMap<>();

    /**
     * Constructs an {@code AbstractControllable} with the state specified by the {@code LoadableBean}.
     *
     * @param bean  a data transfer object for constructing a page object
     */
    public AbstractControllable(LoadableBean bean) {
        super(bean);
    }

    /**
     * Gets the specified web control.
     *
     * @param name          the name of the web control
     * @param <ControlT>    the type of the web control
     * @return              the web control with the specified name
     * @throws IllegalArgumentException if there is no control with the specified name or if it is not a supported
     * control type
     */
    @SuppressWarnings("unchecked")
    protected <ControlT extends Control> ControlT getControl(String name) {
        if(controls.get(name) == null) {
            if(getControlBeans().get(name) == null) {
                throw new IllegalArgumentException("There is no control named " + name);
            }

            buildControl(name, getControlBeans().get(name));
        }

        return (ControlT)controls.get(name);
    }

    /**
     * Gets the state beans for the web controls for this {@code AbstractControllable}.
     *
     * @return      the state beans for the web controls for this {@code AbstractControllable}
     */
    protected abstract Map<String,ControlBean> getControlBeans();

    /**
     * Controls the specified web control with its state bean.
     *
     * @param name          the name of the web control
     * @param controlBean   the state bean to use in constructing the web control
     */
    private void buildControl(String name, ControlBean controlBean) {
        if(controlBean.isHoverAndClickControl()) {
            controls.put(name, new HoverAndClickControlImpl((HoverAndClickControlBean)controlBean));
        } else if(controlBean.isClickControl()) {
            controls.put(name, new ClickControlImpl((ClickControlBean)controlBean));
        } else if(controlBean.isHoverControl()) {
            controls.put(name, new HoverControlImpl((HoverControlBean)controlBean));
        } else {
            throw new IllegalArgumentException("The control named " + name + " is not clickable or hoverable, so it " +
                    "is not supported");
        }
    }
}
