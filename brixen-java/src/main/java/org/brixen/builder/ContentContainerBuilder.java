package org.brixen.builder;

import org.brixen.bean.ContentContainerBean;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebElement;
import org.brixen.factory.LoadableFactory;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object which models a page object that wraps a
 * {@link WebElement} content container.
 *
 * <p>
 * {@code ContentContainerBuilder} is used in conjunction with {@link ContentContainerBean} and {@link LoadableFactory}
 * to construct page objects. It is designed to be extended by other builder {@code interfaces} for more complex page
 * objects in such a way that any setter function on {@code ContentContainerBuilder} or an {@code interface} that
 * {@code extends} it can be called in any order. See the Javadoc documentation for {@link LoadableBuilder} for an
 * explanation and source code examples that show how this is achieved.
 *
 * @param <LoadableT>   the type of page object that this {@code ContentContainerBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the page object that this
 *                      {@code ContentContainerBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code ContentContainerBuilder}
 */
@SuppressWarnings("UnusedDeclaration")
public interface ContentContainerBuilder<
            LoadableT extends Loadable,
            BeanT extends ContentContainerBean,
            BuilderT extends ContentContainerBuilder<LoadableT, BeanT, BuilderT>
        >
        extends LoadableBuilder<LoadableT, BeanT, BuilderT> {

    /**
     * Sets the {@code WebElement} that contains the content wrapped by the page object.
     *
     * @param contentContainer    the {@code WebElement} that contains the content wrapped by the page object
     * @return                    this {@code ContentContainerBuilder}, cast to its runtime type
     */
    BuilderT setContentContainer(WebElement contentContainer);
}
