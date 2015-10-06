package org.brixen.builder;

import lombok.Getter;
import org.brixen.decorator.builder.ControllableBuilderDecorator;
import org.brixen.decorator.builder.LoadableBuilderProvider;
import org.brixen.decorator.builder.PolleableBuilderDecorator;
import org.brixen.pageobject.Clickable;
import org.brixen.pageobject.Expandable;
import org.brixen.bean.DropDownMenuBean;
import org.brixen.pageobject.Menu;

/**
 * Serves as an {@code abstract} builder of a <b>Selenium</b> page object which models a drop down menu.
 *
 * @param <MenuT>       the type of drop down menu that this {@code AbstractDropDownMenuBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the drop down menu that this
 *                      {@code AbstractDropDownMenuBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code AbstractDropDownMenuBuilder}
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractDropDownMenuBuilder<
            MenuT extends Menu<? extends Clickable> & Expandable,
            BeanT extends DropDownMenuBean,
            BuilderT extends DropDownMenuBuilder<MenuT,BeanT,BuilderT>
        > extends AbstractMenuBuilder<MenuT,BeanT,BuilderT>
          implements DropDownMenuBuilder<MenuT,BeanT,BuilderT>,
                     ControllableBuilderDecorator<MenuT,BeanT,BuilderT>,
                     PolleableBuilderDecorator<MenuT,BeanT,BuilderT> {

    /**
     * The {@code LoadableBuilderProvider} for the internal {@code PolleableBuilder} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableBuilder}.
     */
    @SuppressWarnings("unchecked")
    private final @Getter
    LoadableBuilderProvider<MenuT,BeanT,BuilderT> polleableBuilderProvider =
            new LoadableBuilderProvider<>((BuilderT)this);

    /**
     * The {@code LoadableBuilderProvider} for the internal {@code ControllableBuilder} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code ControllableBuilder}.
     */
    @SuppressWarnings("unchecked")
    private final @Getter LoadableBuilderProvider<MenuT,BeanT,BuilderT> controllableBuilderProvider =
            new LoadableBuilderProvider<>((BuilderT)this);

    /**
     * Constructs an {@code AbstractDropDownMenuBuilder} with the specified {@code DropDownMenuBean} to define
     * the state of the drop down menu that this {@code AbstractDropDownMenuBuilder} builds.
     *
     * @param state     the {@code DropDownMenuBean} that defines the state of the pageobject that this
     *                  {@code AbstractDropDownMenuBuilder} builds
     */
    @SuppressWarnings("unchecked")
    public AbstractDropDownMenuBuilder(BeanT state) {
        super(state);
    }
}
