package org.brixen.decorator.builder;

import org.brixen.bean.ClickableBean;
import org.brixen.config.ClickableConfig;
import org.brixen.pageobject.Clickable;
import org.brixen.builder.ClickableBuilder;
/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code ClickableBuilder}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableBuilderProvider} which wraps the {@code ClickableBuilder} implementation that meets the requirements
 * of {@code ClickableBuilder}. In this way, the {@code class} can implement the {@code ClickableBuilder interface}
 * by proxy without having to define any of the methods itself.
 *
 * @param <ClickableT>   the type of {@code Clickable} page object that this {@code ClickableBuilderDecorator} builds
 * @param <BeanT>        the data transfer object used to construct the {@code Clickable} page object that this
 *                       {@code ClickableBuilderDecorator} builds
 * @param <BuilderT>     the runtime type of the {@code ClickableBuilder} that this {@code ClickableBuilderDecorator}
 *                        wraps
 */
public interface ClickableBuilderDecorator<
            ClickableT extends Clickable,
            BeanT extends ClickableBean,
            BuilderT extends ClickableBuilder<ClickableT,BeanT,BuilderT>
        > extends ClickableBuilder<ClickableT,BeanT,BuilderT> {

    /**
     * Gets the {@code LoadableBuilderProvider} for the internal {@code ClickableBuilder} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code ClickableBuilder}.
     *
     * @return  the {@code LoadableBuilderProvider} for the internal {@code ClickableBuilder} implementation to which
     *          this {@code interface} delegates all invocations of the methods required by {@code ClickableBuilder}
     */
    LoadableBuilderProvider<ClickableT,BeanT,BuilderT> getClickableBuilderProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setClickWithJavascript(boolean clickWithJavascript) {
        getClickableBuilderProvider().getBuilder().getState().setClickWithJavascript(clickWithJavascript);
        return getClickableBuilderProvider().getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default BuilderT setClickWithJavascript(ClickableConfig config) {
        if(config != null) {
            if(config.getClickWithJavascript() != null && config.getClickWithJavascript().get() != null) {
                getClickableBuilderProvider().getBuilder().getState()
                        .setClickWithJavascript(config.getClickWithJavascript().get());
            }
        }

        return getClickableBuilderProvider().getBuilder();
    }
}
