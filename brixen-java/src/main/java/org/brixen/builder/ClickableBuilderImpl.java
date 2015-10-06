package org.brixen.builder;

import org.brixen.bean.ClickableBean;
import org.brixen.pageobject.Clickable;
import org.brixen.bean.ClickableBeanImpl;

/**
 * Serves as a builder of <b>Selenium</b> page objects that model {@code Clickable} components.
 *
 * @param <ClickableT>   the type of {@code Clickable} page object that this {@code ClickableBuilder} builds
 */
public class ClickableBuilderImpl<ClickableT extends Clickable> extends
        AbstractClickableBuilder<ClickableT,ClickableBean,ClickableBuilderImpl<ClickableT>> {

    /**
     * Constructs a {@code ClickableBuilderImpl} with the default implementation of {@code ClickableBean} to
     * define the state of the {@code Clickable} component that this {@code ClickableBuilderImpl} builds.
     */
    public ClickableBuilderImpl() {
        super(new ClickableBeanImpl());
    }
}
