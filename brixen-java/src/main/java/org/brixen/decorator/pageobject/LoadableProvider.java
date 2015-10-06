package org.brixen.decorator.pageobject;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.pageobject.Loadable;

/**
 * Serves as a {@code protected} access provider for an implementation of {@code Loadable} or an {@code interface}
 * extending {@code Loadable}.
 * <p>
 * {@code LoadableProvider} is a means for avoiding unnecessary access to internal data for {@code classes} which
 * implement decorator {@code interfaces} for {@code Loadable} page objects.
 *
 * @param <LoadableT>   the page object to which this {@code LoadableProvider} provides {@code protected} access
 */
public class LoadableProvider<LoadableT extends Loadable> {

    /** The page object to which this {@code LoadableBeanProvider} provides {@code protected} access */
    private @Getter(AccessLevel.PROTECTED) LoadableT loadable;

    /**
     * Constructs a {@code LoadableProvider} which provides {@code protected} access to the specified page object.
     *
     * @param loadable  the page object to which this {@code LoadableProvider} provides {@code protected} access
     */
    public LoadableProvider(LoadableT loadable) {
        this.loadable = loadable;
    }
}
