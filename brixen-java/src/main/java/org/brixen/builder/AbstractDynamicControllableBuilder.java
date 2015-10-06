package org.brixen.builder;

import lombok.Getter;
import org.brixen.bean.DynamicControllableBean;
import org.brixen.decorator.builder.LoadableBuilderProvider;
import org.brixen.decorator.builder.PolleableBuilderDecorator;
import org.brixen.pageobject.Polleable;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page object that models a component that contains web
 * controls that have meaningful side effects with state changes that need to be polled for an expected condition when
 * they are clicked and/or moused over.
 *
 * @param <ControllableT>    the type of page object that this {@code AbstractDynamicControllableBuilder} builds
 * @param <BeanT>            the data transfer object used to construct the page object that this
 *                           {@code AbstractDynamicControllableBuilder} builds
 * @param <BuilderT>         the runtime type of this {@code AbstractDynamicControllableBuilder}
 */
public abstract class AbstractDynamicControllableBuilder<
            ControllableT extends Polleable,
            BeanT extends DynamicControllableBean,
            BuilderT extends DynamicControllableBuilder<ControllableT,BeanT,BuilderT>
        > extends AbstractControllableBuilder<ControllableT,BeanT,BuilderT>
          implements DynamicControllableBuilder<ControllableT,BeanT,BuilderT>,
                     PolleableBuilderDecorator<ControllableT,BeanT,BuilderT> {

    /**
     * The {@code LoadableBuilderProvider} for the internal {@code PolleableBuilder} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableBuilder}.
     */
    @SuppressWarnings("unchecked")
    private final @Getter LoadableBuilderProvider<ControllableT,BeanT,BuilderT> polleableBuilderProvider =
            new LoadableBuilderProvider<>((BuilderT)this);

    /**
     * Constructs an {@code AbstractDynamicControllableBuilder} with the specified {@code DynamicControllableBean} to
     * define the state of the page object.
     *
     * @param state     the {@code DynamicControllableBean} that defines the state of the page object
     */
    public AbstractDynamicControllableBuilder(BeanT state) {
        super(state);
    }
}
