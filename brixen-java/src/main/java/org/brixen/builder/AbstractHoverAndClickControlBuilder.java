package org.brixen.builder;

import lombok.Getter;
import org.brixen.bean.HoverAndClickControlBean;
import org.brixen.config.HoverAndClickControlConfig;
import org.brixen.decorator.builder.ClickableBuilderDecorator;
import org.brixen.decorator.builder.LoadableBuilderProvider;
import org.brixen.pageobject.HoverAndClickControl;
import org.openqa.selenium.WebElement;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page objects that model components that contain web
 * controls that have meaningful side effects whenever they are clicked and which must be moused over before they are 
 * clickable.
 *
 * @param <ControlT>    the type of web control that this {@code AbstractHoverAndClickControlBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the web control that this
 *                      {@code AbstractHoverAndClickControlBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractHoverAndClickControlBuilder}
 */
public abstract class AbstractHoverAndClickControlBuilder<
            ControlT extends HoverAndClickControl,
            BeanT extends HoverAndClickControlBean,
            BuilderT extends HoverAndClickControlBuilder<ControlT,BeanT,BuilderT>>
        extends AbstractControlBuilder<ControlT,BeanT,BuilderT>
        implements HoverAndClickControlBuilder<ControlT,BeanT,BuilderT>,
                   ClickableBuilderDecorator<ControlT,BeanT,BuilderT> {

    /**
     * The {@code LoadableBuilderProvider} for the internal {@code ClickableBuilder} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code ClickableBuilder}.
     */
    @SuppressWarnings("unchecked")
    private final @Getter LoadableBuilderProvider<ControlT,BeanT,BuilderT> clickableBuilderProvider =
            new LoadableBuilderProvider<>((BuilderT)this);

    /**
     * Constructs an {@code AbstractHoverAndClickControlBuilder} with the specified {@code HoverAndClickControlBean} to 
     * define the state of the web control.
     *
     * @param state     the {@code HoverAndClickControlBean} that defines the state of the web control
     */
    public AbstractHoverAndClickControlBuilder(BeanT state) {
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
    public BuilderT setHoverWithJavascript(HoverAndClickControlConfig config) {
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
    public BuilderT setUnhoverWithJavascript(HoverAndClickControlConfig config) {
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
    public BuilderT setClickWithJavascriptInsteadOfHover(boolean clickWithJavascriptInsteadOfHover) {
        getState().setClickWithJavascriptInsteadOfHover(clickWithJavascriptInsteadOfHover);
        return (BuilderT)this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickWithJavascriptInsteadOfHover(HoverAndClickControlConfig config) {
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
    public BuilderT setUnhoverWithClickInstead(HoverAndClickControlConfig config) {
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
    public BuilderT setUnhoverWithJavascriptClickInstead(HoverAndClickControlConfig config) {
        if(config != null) {
            if(config.getUnhoverWithJavascriptClickInstead() != null &&
                    config.getUnhoverWithJavascriptClickInstead().get() != null) {
                setUnhoverWithJavascriptClickInstead(config.getUnhoverWithJavascriptClickInstead().get());
            }
        }

        return (BuilderT)this;
    }
}
