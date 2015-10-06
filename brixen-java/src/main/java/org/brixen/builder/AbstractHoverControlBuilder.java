package org.brixen.builder;

import org.brixen.config.HoverControlConfig;
import org.openqa.selenium.WebElement;
import org.brixen.bean.HoverControlBean;
import org.brixen.pageobject.HoverControl;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page objects that model components that contain web
 * controls that have meaningful side effects whenever they are moused over.
 *
 * @param <ControlT>    the type of web control that this {@code AbstractHoverControlBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the web control that this
 *                      {@code AbstractHoverControlBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractHoverControlBuilder}
 */
public abstract class AbstractHoverControlBuilder<
            ControlT extends HoverControl,
            BeanT extends HoverControlBean,
            BuilderT extends HoverControlBuilder<ControlT,BeanT,BuilderT>
        > extends AbstractControlBuilder<ControlT,BeanT,BuilderT>
          implements HoverControlBuilder<ControlT,BeanT,BuilderT> {

    /**
     * Constructs an {@code AbstractHoverControlBuilder} with the specified {@code HoverControlBean} to define the
     * state of the web control.
     *
     * @param state     the {@code HoverControlBean} that defines the state of the web control
     */
    public AbstractHoverControlBuilder(BeanT state) {
        super(state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverElement(WebElement unhoverElement) {
        getState().setUnhoverElement(unhoverElement);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setHoverWithJavascript(boolean hoverWithJavascript) {
        getState().setHoverWithJavascript(hoverWithJavascript);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setHoverWithJavascript(HoverControlConfig config) {
        if(config != null) {
            if(config.getHoverWithJavascript() != null && config.getHoverWithJavascript().get() != null) {
                setHoverWithJavascript(config.getHoverWithJavascript().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverWithJavascript(boolean unhoverWithJavascript) {
        getState().setUnhoverWithJavascript(unhoverWithJavascript);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverWithJavascript(HoverControlConfig config) {
        if(config != null) {
            if(config.getUnhoverWithJavascript() != null && config.getUnhoverWithJavascript().get() != null) {
                setUnhoverWithJavascript(config.getUnhoverWithJavascript().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickInsteadOfHover(boolean clickInsteadOfHover) {
        getState().setClickInsteadOfHover(clickInsteadOfHover);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickInsteadOfHover(HoverControlConfig config) {
        if(config != null) {
            if(config.getClickInsteadOfHover() != null && config.getClickInsteadOfHover().get() != null) {
                setClickInsteadOfHover(config.getClickInsteadOfHover().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickWithJavascriptInsteadOfHover(boolean clickWithJavascriptInsteadOfHover) {
        getState().setClickWithJavascriptInsteadOfHover(clickWithJavascriptInsteadOfHover);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickWithJavascriptInsteadOfHover(HoverControlConfig config) {
        if(config != null) {
            if(config.getClickWithJavascriptInsteadOfHover() != null &&
                    config.getClickWithJavascriptInsteadOfHover().get() != null) {
                setClickWithJavascriptInsteadOfHover(config.getClickWithJavascriptInsteadOfHover().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverWithClickInstead(boolean unhoverWithClickInstead) {
        getState().setUnhoverWithClickInstead(unhoverWithClickInstead);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverWithClickInstead(HoverControlConfig config) {
        if(config != null) {
            if(config.getUnhoverWithClickInstead() != null && config.getUnhoverWithClickInstead().get() != null) {
                setUnhoverWithClickInstead(config.getUnhoverWithClickInstead().get());
            }
        }

        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverWithJavascriptClickInstead(boolean unhoverWithJavascriptClickInstead) {
        getState().setUnhoverWithJavascriptClickInstead(unhoverWithJavascriptClickInstead);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setUnhoverWithJavascriptClickInstead(HoverControlConfig config) {
        if(config != null) {
            if(config.getUnhoverWithJavascriptClickInstead() != null &&
                    config.getUnhoverWithJavascriptClickInstead().get() != null) {
                setUnhoverWithJavascriptClickInstead(config.getUnhoverWithJavascriptClickInstead().get());
            }
        }

        return (BuilderT)this;
    }
}
