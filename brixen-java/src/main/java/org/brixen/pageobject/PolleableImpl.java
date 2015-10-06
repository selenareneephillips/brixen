package org.brixen.pageobject;

import org.brixen.bean.PolleableBean;

/**
 * Serves as a basic implementation for a <b>Selenium</b> page object which models a dynamic component which needs to
 * be polled on intervals for an expected condition via a {@link org.openqa.selenium.support.ui.FluentWait}.
 */
public class PolleableImpl extends AbstractPolleable<PolleableImpl> {

    /**
     * Constructs an {@code PolleableImpl} with the state specified by the {@code PolleableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code PolleableImpl}
     */
    public PolleableImpl(PolleableBean bean) {
        super(bean);
    }

    /**
     * There are no {@code WebElement} controls, so there is nothing to check for whether this {@code PolleableImpl}
     * is loaded. The containing {@code Class} will have its own logic for determining whether it is loaded or not.
     */
    @Override
    protected void isLoaded() throws Error {
        //Do nothing;
    }
}


