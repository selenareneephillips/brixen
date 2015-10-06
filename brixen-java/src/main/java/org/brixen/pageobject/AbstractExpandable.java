package org.brixen.pageobject;

import org.brixen.bean.PolleableBean;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object which models a dynamic component
 * which can be expanded and collapsed.
 *
 * @param <ExpandableT>   the {@code class} which {@code extends} this {@code AbstractExpandable}
 */
public abstract class AbstractExpandable<ExpandableT extends AbstractExpandable<ExpandableT>> extends
        AbstractToggleableVisibility<ExpandableT> implements Expandable {

    /**
     * Constructs an {@code AbstractExpandable} with the state specified by the {@code PolleableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code AbstractExpandable}
     */
    public AbstractExpandable(PolleableBean bean) {
        super(bean);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExpanded() {
        return isToggledVisible(getExpandableControlName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollapsed() {
        return !isExpanded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void expand() {
        toggleVisible(getExpandableControlName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void collapse() {
        toggleInvisible(getExpandableControlName());
    }

    /**
     * Gets the name of the control that expands and collapses this {@code AbstractExpandable}.
     *
     * @return  the name of the control that expands and collapses this {@code AbstractExpandable}
     */
    protected abstract String getExpandableControlName();
}
