package org.brixen.decorator.builder;

import org.brixen.bean.ClickControlBean;
import org.brixen.bean.ControllableBean;
import org.brixen.bean.HoverAndClickControlBean;
import org.brixen.bean.HoverControlBean;
import org.brixen.builder.ControllableBuilder;
import org.brixen.config.*;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code ControllableBuilder}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableBuilderProvider} which wraps the {@code ControllableBuilder} implementation that meets the
 * requirements of {@code ControllableBuilder}. In this way, the {@code class} can implement the
 * {@code ControllableBuilder interface} by proxy without having to define any of the methods itself.
 *
 * @param <ControllableT>   the type of page object that this {@code ControllableBuilderDecorator} builds
 * @param <BeanT>           the data transfer object used to construct the page object that this
 *                          {@code ControllableBuilderDecorator} builds
 * @param <BuilderT>        the runtime type of this {@code ControllableBuilder} that this
 *                          {@code ControllableBuilderDecorator} wraps
 */
public interface ControllableBuilderDecorator<
            ControllableT extends Loadable,
            BeanT extends ControllableBean,
            BuilderT extends ControllableBuilder<ControllableT, BeanT, BuilderT>
        > extends ControllableBuilder<ControllableT,BeanT,BuilderT> {

    /**
     * Gets the {@code LoadableBuilderProvider} for the internal {@code ControllableBuilder} implementation to which
     * this {@code interface} delegates all invocations of the methods required by {@code ControllableBuilder}.
     *
     * @return  the {@code LoadableBuilderProvider} for the internal {@code ControllableBuilder} implementation to
     *          which this {@code interface} delegates all invocations of the methods required by
     *          {@code ControllableBuilder}
     */
    LoadableBuilderProvider<ControllableT,BeanT,BuilderT> getControllableBuilderProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT addClickControl(String name) {
        getControllableBuilderProvider().getBuilder().getState().addClickControl(name);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT addHoverControl(String name) {
        getControllableBuilderProvider().getBuilder().getState().addHoverControl(name);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT addHoverAndClickControl(String name) {
        getControllableBuilderProvider().getBuilder().getState().addHoverAndClickControl(name);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT addClickControl(String name, Class<? extends ClickControlBean> beanClass) {
        getControllableBuilderProvider().getBuilder().getState().addClickControl(name, beanClass);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT addHoverControl(String name, Class<? extends HoverControlBean> beanClass) {
        getControllableBuilderProvider().getBuilder().getState().addHoverControl(name);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT addHoverAndClickControl(String name, Class<? extends HoverAndClickControlBean> beanClass) {
        getControllableBuilderProvider().getBuilder().getState().addHoverAndClickControl(name, beanClass);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setControlDriver(String name, WebDriver driver) {
        getControllableBuilderProvider().getBuilder().getState().setControlDriver(name, driver);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setControlLoadTimeout(String name, int timeout) {
        getControllableBuilderProvider().getBuilder().getState().setControlLoadTimeout(name, timeout);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setControlLoadTimeout(String name, ControllableConfig config) {
        if(config != null && config.getControlConfigs() != null && config.getControlConfigs().get() != null) {
            ControlConfig controlConfig = config.getControlConfigs().get().get(name);

            if(controlConfig.getLoadTimeout() != null && controlConfig.getLoadTimeout().get() != null) {
                setControlLoadTimeout(name, controlConfig.getLoadTimeout().get());
            }
        }

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setControlContentContainer(String name, WebElement contentContainer) {
        getControllableBuilderProvider().getBuilder().getState().setControlContentContainer(name, contentContainer);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    default BuilderT setControlPollingTimeout(String name, int timeout) {
        getControllableBuilderProvider().getBuilder().getState().setControlPollingTimeout(name, timeout);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * not a configuration for a polleable control
     */
    @SuppressWarnings("unchecked")
    @Override
    default BuilderT setControlPollingTimeout(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    default BuilderT setControlPollingInterval(String name, int interval) {
        getControllableBuilderProvider().getBuilder().getState().setControlPollingInterval(name, interval);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * not a configuration for a polleable control
     */
    @SuppressWarnings("unchecked")
    @Override
    default BuilderT setControlPollingInterval(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setControlUnhoverElement(String name, WebElement unHoverElement) {
        getControllableBuilderProvider().getBuilder().getState().setControlUnhoverElement(name, unHoverElement);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setHoverControlWithJavascript(String name, boolean hoverWithJavascript) {
        getControllableBuilderProvider().getBuilder().getState().setHoverControlWithJavascript(name, hoverWithJavascript);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @Override
    default BuilderT setHoverControlWithJavascript(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setClickControlWithJavascript(String name, boolean clickWithJavascript) {
        getControllableBuilderProvider().getBuilder().getState().setClickControlWithJavascript(name, clickWithJavascript);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode ClickControlConfig}
     */
    @Override
    default BuilderT setClickControlWithJavascript(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setUnhoverControlWithJavascript(String name, boolean unhoverWithJavascript) {
        getControllableBuilderProvider().getBuilder().getState().setUnhoverControlWithJavascript(name,
                unhoverWithJavascript);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @Override
    default BuilderT setUnhoverControlWithJavascript(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setClickControlInsteadOfHover(String name, boolean clickInsteadOfHover) {
        getControllableBuilderProvider().getBuilder().getState().setClickControlInsteadOfHover(name,
                clickInsteadOfHover);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig}
     */
    @Override
    default BuilderT setClickControlInsteadOfHover(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setClickControlWithJavascriptInsteadOfHover(String name, boolean
            clickWithJavascriptInsteadOfHover) {
        getControllableBuilderProvider().getBuilder().getState().setClickControlWithJavascriptInsteadOfHover(name,
                clickWithJavascriptInsteadOfHover);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @Override
    default BuilderT setClickControlWithJavascriptInsteadOfHover(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setUnhoverControlWithClickInstead(String name, boolean unhoverWithClickInstead) {
        getControllableBuilderProvider().getBuilder().getState().setUnhoverControlWithClickInstead(name,
                unhoverWithClickInstead);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @Override
    default BuilderT setUnhoverControlWithClickInstead(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setUnhoverControlWithJavascriptClickInstead(String name, boolean
            unhoverWithJavascriptClickInstead) {
        getState().setUnhoverControlWithJavascriptClickInstead(name, unhoverWithJavascriptClickInstead);
        return getControllableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the configuration associated with the specified control is not a
     * {@ode HoverControlConfig} or a {@code HoverAndClickControlConfig}
     */
    @Override
    default BuilderT setUnhoverControlWithJavascriptClickInstead(String name, ControllableConfig config) {
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

        return getControllableBuilderProvider().getBuilder();
    }
}
