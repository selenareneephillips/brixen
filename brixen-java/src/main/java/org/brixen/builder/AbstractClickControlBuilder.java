package org.brixen.builder;

import lombok.Getter;
import org.brixen.decorator.builder.ClickableBuilderDecorator;
import org.brixen.decorator.builder.LoadableBuilderProvider;
import org.brixen.pageobject.ClickControl;
import org.brixen.bean.ClickControlBean;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page object that models a web control that has meaningful 
 * side effects whenever it is clicked.
 *
 * @param <ControlT>     the type of {@code ClickControl} this {@code AbstractClickControlBuilder} builds
 * @param <BeanT>        the data transfer object used to construct the {@code ClickControl} that this 
 *                       {@code AbstractClickControlBuilder} builds
 * @param <BuilderT>     the runtime type of this {@code AbstractClickControlBuilder}
 */
public abstract class AbstractClickControlBuilder<
            ControlT extends ClickControl,
            BeanT extends ClickControlBean,
            BuilderT extends ClickControlBuilder<ControlT,BeanT,BuilderT>
        > extends AbstractControlBuilder<ControlT,BeanT,BuilderT>
          implements ClickControlBuilder<ControlT,BeanT,BuilderT>,
                     ClickableBuilderDecorator<ControlT,BeanT,BuilderT> {

    /**
     * The {@code LoadableBuilderProvider} for the internal {@code ClickableBuilder} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code ClickableBuilder}.
     */
    @SuppressWarnings("unchecked")
    private final @Getter LoadableBuilderProvider<ControlT,BeanT,BuilderT> clickableBuilderProvider =
            new LoadableBuilderProvider<>((BuilderT)this);

    /**
     * Constructs an {@code AbstractClickControlBuilder} with the specified {@code ClickControl} to define the state of
     * the {@code ClickControl}.
     *
     * @param state     the {@code ClickControlBean} that defines the state of the {@code ClickControl}
     */
    public AbstractClickControlBuilder(BeanT state) {
        super(state);
    }
}
