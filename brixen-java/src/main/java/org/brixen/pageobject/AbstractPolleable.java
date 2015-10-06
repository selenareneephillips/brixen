package org.brixen.pageobject;

import lombok.Getter;
import org.brixen.bean.PolleableBean;

/**
 * Serves as an {@code abstract} implementation for a <b>Selenium</b> page object which models a dynamic component
 * which needs to be polled on intervals for an expected condition via a
 * {@link org.openqa.selenium.support.ui.FluentWait}.
 *
 * @param <PolleableT>   the {@code class} which {@code extends} this {@code AbstractPolleable}
 */
public abstract class AbstractPolleable<PolleableT extends AbstractPolleable<PolleableT>> extends
        AbstractLoadable<PolleableT> implements Polleable {

    /**
     * The polling timeout in seconds for a {@code FluentWait} to poll this {@code AbstractPolleable} to determine if
     * an expected condition has been satisfied
     */
    private final @Getter int pollingTimeout;

    /**
     * The polling interval in seconds for a {@code FluentWait} to poll this {@code AbstractPolleable} to determine if
     * an expected condition has been satisfied
     */
    private final @Getter int pollingInterval;

    /**
     * Constructs an {@code AbstractPolleable} with the state specified by the {@code PolleableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code AbstractPolleable}
     */
    public AbstractPolleable(final PolleableBean bean) {
        super(bean);

        this.pollingTimeout = bean.getPollingTimeout();
        this.pollingInterval = bean.getPollingInterval();
    }
}
