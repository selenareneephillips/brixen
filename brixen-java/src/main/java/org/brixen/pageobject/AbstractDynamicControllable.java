package org.brixen.pageobject;

import lombok.Getter;
import org.brixen.decorator.pageobject.LoadableProvider;
import org.brixen.bean.PolleableBean;
import org.brixen.decorator.pageobject.PolleableDecorator;

/**
 * Serves as an {@code abstract} implementation for <b>Selenium</b> page object that models a component that contains
 * web controls that have meaningful side effects with state changes that need to be polled for an expected condition
 * when they are clicked and/or moused over.
 *
 * @param <ControllableT>   the {@code class} which {@code extends} this {@code AbstractControllable}
 */
public abstract class AbstractDynamicControllable<ControllableT extends AbstractDynamicControllable<ControllableT>> extends
        AbstractControllable<ControllableT> implements PolleableDecorator {

    /**
     * Provider for internal {@code Polleable} that encapsulates the polleable behavior for this
     * {@code AbstractDynamicControllable}.
     */
    private final @Getter LoadableProvider<Polleable> polleableProvider;

    /**
     * Constructs an {@code AbstractDynamicControllable} with the state specified by the {@code LoadableBean}.
     *
     * @param bean  a data transfer object for constructing a page object
     */
    public AbstractDynamicControllable(PolleableBean bean) {
        super(bean);

        polleableProvider = new LoadableProvider<>(new PolleableImpl(bean));
    }
}
