package org.brixen.decorator.pageobject;

import org.brixen.pageobject.Expandable;

/**
 * Defines the contract for a decorator that defines {@code default} implementations of the methods required by
 * {@code Expandable}.
 * <p>
 * Any {@code class} implementing this {@code interface} needs to only define a getter method for a
 * {@code LoadableProvider} which wraps the {@code Expandable} implementation that meets the requirements of
 * {@code Expandable}. In this way, the {@code class} can implement the {@code Expandable interface} by
 * proxy without having to define any of the methods itself.
 */
public interface ExpandableDecorator extends Expandable {

    /**
     * Gets the {@code LoadableProvider} for the internal {@code Expandable} implementation to which this
     * {@code interface} delegates all invocations of the methods required by {@code Expandable}.
     *
     * @return  the {@code LoadableProvider} for the internal {@code Expandable} implementation to which this
     *          {@code interface} delegates all invocations of the methods required by {@code Expandable}
     */
    LoadableProvider<? extends Expandable> getExpandableProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    default void expand() {
        getExpandableProvider().getLoadable().expand();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void collapse() {
        getExpandableProvider().getLoadable().collapse();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default boolean isExpanded() {
        return getExpandableProvider().getLoadable().isExpanded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default boolean isCollapsed() {
        return getExpandableProvider().getLoadable().isCollapsed();
    }
}
