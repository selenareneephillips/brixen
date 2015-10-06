package org.brixen.builder;

import org.brixen.bean.ContentContainerBean;
import org.brixen.bean.ContentContainerBeanImpl;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebElement;

/**
 * Serves as a builder of <b>Selenium</b> page objects that model components that wrap a {@link WebElement} content
 * container.
 *
 * @param <LoadableT>   the type of page object that this {@code AbstractContentContainerBuilder} builds
 */
public class ContentContainerBuilderImpl<LoadableT extends Loadable> extends
        AbstractContentContainerBuilder<LoadableT,ContentContainerBean,ContentContainerBuilderImpl<LoadableT>> {

    /**
     * Constructs a {@code ContentContainerBuilderImpl} with the default implementation of {@code ContentContainerBean}
     * to define the state of the page object that this {@code ContentContainerBuilderImpl} builds.
     */
    public ContentContainerBuilderImpl() {
        super(new ContentContainerBeanImpl());
    }
}
