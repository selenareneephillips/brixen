package org.brixen.pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.brixen.bean.LoadableBean;

import static org.testng.Assert.assertTrue;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object which models a component that wraps a
 * {@link WebElement} content container.
 *
 * @param <ContentPaneT>   the {@code class} which {@code extends} this {@code AbstractContentContainer}
 */
public abstract class AbstractContentContainer<ContentPaneT extends AbstractContentContainer<ContentPaneT>> extends
        AbstractLoadable<ContentPaneT> {

    /**
     * Constructs an {@code AbstractContentContainer} with the state specified by the {@code LoadableBean}.
     *
     * @param bean  the data transfer object for constructing this {@code AbstractContentContainer}
     */
    public AbstractContentContainer(LoadableBean bean) {
        super(bean);
    }

    /**
     * Returns the {@code WebElement} that is the container element for the content wrapped by this
     * {@code AbstractContentContainer}.
     *
     * @return      the {@code WebElement} that is the container element for the content wrapped by this
     *              {@code AbstractContentContainer}
     */
    protected abstract WebElement getContentContainer();

    /**
     * Determines if this {@code AbstractContentContainer} is loaded by checking whether its content container
     * {@code WebElement} is displayed.
     *
     * @throws Error if the load checks continue to fail after the load timeout expires
     */
    @Override
    protected void isLoaded() throws Error {
        try {
            assertTrue(getContentContainer().isDisplayed());
        } catch(NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            throw new Error("The content container is not visible, so the content container page object is not loaded",
                    e);
        }
    }
}
