package org.brixen.decorator.builder;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.pageobject.Loadable;
import org.brixen.bean.LoadableBean;
import org.brixen.builder.LoadableBuilder;

/**
 * Serves as a {@code protected} access provider for an implementation of {@code LoadableBuilder} or an
 * {@code interface} extending {@code LoadableBuilder}.
 * <p>
 * {@code LoadableBuilderProvider} is a means for avoiding unnecessary access to internal data for {@code classes}
 * which implement decorator {@code interfaces} for component builders.
 *
 * @param <LoadableT>   the type of component the builder builds
 * @param <BeanT>       the data transfer object used to construct the component that the builder builds
 * @param <BuilderT>    the builder to which this {@code LoadableBuilderProvider} provides {@code protected} access
 */
@SuppressWarnings("UnusedDeclaration")
public class LoadableBuilderProvider<
            LoadableT extends Loadable,
            BeanT extends LoadableBean,
            BuilderT extends LoadableBuilder<LoadableT, BeanT, BuilderT>
        > {

    /**
     * The builder to which this {@code LoadableBuilderProvider} provides {@code protected} access
     */
    private final @Getter(AccessLevel.PROTECTED) BuilderT builder;

    /**
     * Constructs a {@code LoadableBuilderProvider} which provides {@code protected} access to the specified builder.
     *
     * @param builder  the builder to which this {@code LoadableBuilderProvider} provides {@code protected} access
     */
    public LoadableBuilderProvider(BuilderT builder) {
        this.builder = builder;
    }
}
