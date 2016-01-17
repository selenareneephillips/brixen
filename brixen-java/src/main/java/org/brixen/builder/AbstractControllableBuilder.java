package org.brixen.builder;

import org.brixen.bean.ClickControlBean;
import org.brixen.bean.ControllableBean;
import org.brixen.bean.HoverAndClickControlBean;
import org.brixen.bean.HoverControlBean;
import org.brixen.config.*;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page objects that model components that contain web
 * controls that have meaningful side effects whenever they are clicked and/or moused over.
 *
 * @param <ControllableT>    the type of page object that this {@code AbstractControllableBuilder} builds
 * @param <BeanT>            the data transfer object used to construct the page object that this
 *                           {@code AbstractControllableBuilder} builds
 * @param <BuilderT>         the runtime type of this {@code AbstractControllableBuilder}
 */
public abstract class AbstractControllableBuilder<
            ControllableT extends Loadable,
            BeanT extends ControllableBean,
            BuilderT extends ControllableBuilder<ControllableT, BeanT, BuilderT>
        > extends AbstractContentContainerBuilder<ControllableT, BeanT,BuilderT>
          implements ControllableBuilder<ControllableT,BeanT,BuilderT> {

    /**
     * Constructs an {@code AbstractControllableBuilder} with the specified {@code ControllableBean} to define the
     * state of the page object.
     *
     * @param state     the {@code ControllableBean} that defines the state of the page object
     */
    public AbstractControllableBuilder(BeanT state) {
        super(state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT addClickControl(String name) {
        getState().addClickControl(name);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT addHoverControl(String name) {
        getState().addHoverControl(name);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT addHoverAndClickControl(String name) {
        getState().addHoverAndClickControl(name);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ControlBeanT extends ClickControlBean> BuilderT addClickControl(String name, ControlBeanT bean) {
        getState().addClickControl(name, bean);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ControlBeanT extends HoverControlBean> BuilderT addHoverControl(String name, ControlBeanT bean) {
        getState().addHoverControl(name, bean);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ControlBeanT extends HoverAndClickControlBean> BuilderT addHoverAndClickControl(String name, ControlBeanT
            bean) {
        getState().addHoverAndClickControl(name, bean);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlDriver(String name, WebDriver driver) {
        getState().setControlDriver(name, driver);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlLoadTimeout(String name, int timeout) {
        getState().setControlLoadTimeout(name, timeout);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlLoadTimeout(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {
            ControlConfig controlConfig = config.getControlConfigs().get().get(name);

            if(controlConfig.getLoadTimeout() != null && controlConfig.getLoadTimeout().get() != null) {
                setControlLoadTimeout(name, controlConfig.getLoadTimeout().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlContentContainer(String name, WebElement contentContainer) {
        getState().setControlContentContainer(name, contentContainer);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlPollingTimeout(String name, int timeout) {
        getState().setControlPollingTimeout(name, timeout);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * not a configuration for a polleable control
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlPollingTimeout(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {
            if(PolleableConfig.class.isAssignableFrom(config.getControlConfigs().get().get(name).getClass())) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a polleable control");
            }

            PolleableConfig controlConfig = (PolleableConfig)config.getControlConfigs().get().get(name);
            if(controlConfig.getPollingTimeout() != null && controlConfig.getPollingTimeout().get() != null) {
                setControlPollingTimeout(name, controlConfig.getPollingTimeout().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlPollingInterval(String name, int interval) {
        getState().setControlPollingInterval(name, interval);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * not a configuration for a polleable control
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlPollingInterval(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {
            if(PolleableConfig.class.isAssignableFrom(config.getControlConfigs().get().get(name).getClass())) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a polleable control");
            }

            PolleableConfig controlConfig = (PolleableConfig)config.getControlConfigs().get().get(name);
            if(controlConfig.getPollingInterval() != null && controlConfig.getPollingInterval().get() != null) {
                setControlPollingInterval(name, controlConfig.getPollingInterval().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setControlUnhoverElement(String name, WebElement unhoverElement) {
        getState().setControlUnhoverElement(name, unhoverElement);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setHoverControlWithJavascript(String name, boolean hoverWithJavascript) {
        getState().setHoverControlWithJavascript(name, hoverWithJavascript);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setHoverControlWithJavascript(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {

            if(!config.getControlConfigs().get().get(name).isHoverControlConfig() &&
                    !config.getControlConfigs().get().get(name).isHoverAndClickControlConfig()) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a hover control or a hover and click control");
            }

            if(config.getControlConfigs().get().get(name).isHoverControlConfig()) {
                HoverControlConfig controlConfig = (HoverControlConfig) config.getControlConfigs().get().get(name);
                if (controlConfig.getHoverWithJavascript() != null &&
                        controlConfig.getHoverWithJavascript().get() != null) {
                    setHoverControlWithJavascript(name, controlConfig.getHoverWithJavascript().get());
                }
            } else {
                HoverAndClickControlConfig controlConfig =
                        (HoverAndClickControlConfig)config.getControlConfigs().get().get(name);
                if (controlConfig.getHoverWithJavascript() != null &&
                        controlConfig.getHoverWithJavascript().get() != null) {
                    setHoverControlWithJavascript(name, controlConfig.getHoverWithJavascript().get());
                }
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickControlWithJavascript(String name, boolean clickWithJavascript) {
        getState().setClickControlWithJavascript(name, clickWithJavascript);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode ClickControlConfig}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickControlWithJavascript(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {
            if(!config.getControlConfigs().get().get(name).isClickControlConfig()) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a click control");
            }

            ClickControlConfig controlConfig = (ClickControlConfig)config.getControlConfigs().get().get(name);
            if(controlConfig.getClickWithJavascript() != null && controlConfig.getClickWithJavascript().get() != null) {
                setClickControlWithJavascript(name, controlConfig.getClickWithJavascript().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverControlWithJavascript(String name, boolean unhoverWithJavascript) {
        getState().setUnhoverControlWithJavascript(name, unhoverWithJavascript);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverControlWithJavascript(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {

            if(!config.getControlConfigs().get().get(name).isHoverControlConfig() &&
                    !config.getControlConfigs().get().get(name).isHoverAndClickControlConfig()) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a hover control or a hover and click control");
            }

            if(config.getControlConfigs().get().get(name).isHoverControlConfig()) {
                HoverControlConfig controlConfig = (HoverControlConfig) config.getControlConfigs().get().get(name);
                if (controlConfig.getUnhoverWithJavascript() != null &&
                        controlConfig.getUnhoverWithJavascript().get() != null) {
                    setUnhoverControlWithJavascript(name, controlConfig.getUnhoverWithJavascript().get());
                }
            } else {
                HoverAndClickControlConfig controlConfig =
                        (HoverAndClickControlConfig)config.getControlConfigs().get().get(name);
                if (controlConfig.getUnhoverWithJavascript() != null &&
                        controlConfig.getUnhoverWithJavascript().get() != null) {
                    setUnhoverControlWithJavascript(name, controlConfig.getUnhoverWithJavascript().get());
                }
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickControlInsteadOfHover(String name, boolean clickInsteadOfHover) {
        getState().setClickControlInsteadOfHover(name, clickInsteadOfHover);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickControlInsteadOfHover(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {

            if(!config.getControlConfigs().get().get(name).isHoverControlConfig()) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a hover control");
            }

            if(config.getControlConfigs().get().get(name).isHoverControlConfig()) {
                HoverControlConfig controlConfig = (HoverControlConfig) config.getControlConfigs().get().get(name);
                if (controlConfig.getClickInsteadOfHover() != null &&
                        controlConfig.getClickInsteadOfHover().get() != null) {
                    setClickControlInsteadOfHover(name, controlConfig.getClickInsteadOfHover().get());
                }
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickControlWithJavascriptInsteadOfHover(String name, boolean
            clickWithJavascriptInsteadOfHover) {
        getState().setClickControlWithJavascriptInsteadOfHover(name, clickWithJavascriptInsteadOfHover);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickControlWithJavascriptInsteadOfHover(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {

            if(!config.getControlConfigs().get().get(name).isHoverControlConfig() &&
                    !config.getControlConfigs().get().get(name).isHoverAndClickControlConfig()) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a hover control or a hover and click control");
            }

            if(config.getControlConfigs().get().get(name).isHoverControlConfig()) {
                HoverControlConfig controlConfig = (HoverControlConfig) config.getControlConfigs().get().get(name);
                if (controlConfig.getClickWithJavascriptInsteadOfHover() != null &&
                        controlConfig.getClickWithJavascriptInsteadOfHover().get() != null) {
                    setClickControlWithJavascriptInsteadOfHover(name,
                            controlConfig.getClickWithJavascriptInsteadOfHover().get());
                }
            } else {
                HoverAndClickControlConfig controlConfig =
                        (HoverAndClickControlConfig)config.getControlConfigs().get().get(name);
                if (controlConfig.getClickWithJavascriptInsteadOfHover() != null &&
                        controlConfig.getClickWithJavascriptInsteadOfHover().get() != null) {
                    setClickControlWithJavascriptInsteadOfHover(name,
                            controlConfig.getClickWithJavascriptInsteadOfHover().get());
                }
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverControlWithClickInstead(String name, boolean unhoverWithClickInstead) {
        getState().setUnhoverControlWithClickInstead(name, unhoverWithClickInstead);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverControlWithClickInstead(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {

            if(!config.getControlConfigs().get().get(name).isHoverControlConfig() &&
                    !config.getControlConfigs().get().get(name).isHoverAndClickControlConfig()) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a hover control or a hover and click control");
            }

            if(config.getControlConfigs().get().get(name).isHoverControlConfig()) {
                HoverControlConfig controlConfig = (HoverControlConfig) config.getControlConfigs().get().get(name);
                if (controlConfig.getUnhoverWithClickInstead() != null &&
                        controlConfig.getUnhoverWithClickInstead().get() != null) {
                    setUnhoverControlWithClickInstead(name, controlConfig.getUnhoverWithClickInstead().get());
                }
            } else {
                HoverAndClickControlConfig controlConfig =
                        (HoverAndClickControlConfig)config.getControlConfigs().get().get(name);
                if (controlConfig.getUnhoverWithClickInstead() != null &&
                        controlConfig.getUnhoverWithClickInstead().get() != null) {
                    setUnhoverControlWithClickInstead(name, controlConfig.getUnhoverWithClickInstead().get());
                }
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverControlWithJavascriptClickInstead(String name, boolean
            unhoverWithJavascriptClickInstead) {
        getState().setUnhoverControlWithJavascriptClickInstead(name, unhoverWithJavascriptClickInstead);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverControlWithJavascriptClickInstead(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {

            if(!config.getControlConfigs().get().get(name).isHoverControlConfig() &&
                    !config.getControlConfigs().get().get(name).isHoverAndClickControlConfig()) {
                throw new IllegalArgumentException("The configuration associated with the control named " + name +
                        " is not a configuration for a hover control or a hover and click control");
            }

            if(config.getControlConfigs().get().get(name).isHoverControlConfig()) {
                HoverControlConfig controlConfig = (HoverControlConfig) config.getControlConfigs().get().get(name);
                if (controlConfig.getUnhoverWithJavascriptClickInstead() != null &&
                        controlConfig.getUnhoverWithJavascriptClickInstead().get() != null) {
                    setUnhoverControlWithJavascriptClickInstead(name,
                            controlConfig.getUnhoverWithJavascriptClickInstead().get());
                }
            } else {
                HoverAndClickControlConfig controlConfig =
                        (HoverAndClickControlConfig)config.getControlConfigs().get().get(name);
                if (controlConfig.getUnhoverWithJavascriptClickInstead() != null &&
                        controlConfig.getUnhoverWithJavascriptClickInstead().get() != null) {
                    setUnhoverControlWithJavascriptClickInstead(name,
                            controlConfig.getUnhoverWithJavascriptClickInstead().get());
                }
            }
        }

        return (BuilderT)this;
    }
}
