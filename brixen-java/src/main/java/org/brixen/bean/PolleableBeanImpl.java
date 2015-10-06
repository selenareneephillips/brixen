package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static org.brixen.pageobject.Polleable.DEFAULT_POLLING_TIMEOUT;
import static org.brixen.pageobject.Polleable.DEFAULT_POLLING_INTERVAL;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object which models a dynamic page object which
 * needs to be polled on intervals for an expected condition via a mechanism such as
 * {@link org.openqa.selenium.support.ui.FluentWait}.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class PolleableBeanImpl extends LoadableBeanImpl implements PolleableBean {

    /**
     * The polling timeout in seconds to poll the page object to determine if an expected condition has been satisfied
     */
    private @Getter @Setter int pollingTimeout = DEFAULT_POLLING_TIMEOUT;

    /**
     * The polling interval to poll the page object to determine if an expected condition has been satisfied
     */
    private @Getter @Setter int pollingInterval = DEFAULT_POLLING_INTERVAL;
}
