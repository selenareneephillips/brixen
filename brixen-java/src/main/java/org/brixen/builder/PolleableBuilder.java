package org.brixen.builder;

import org.brixen.bean.PolleableBean;
import org.brixen.config.PolleableConfig;
import org.brixen.pageobject.Polleable;
import org.brixen.factory.LoadableFactory;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object which models a dynamic pageobject which needs to
 * be polled on intervals for an expected condition via a {@link org.openqa.selenium.support.ui.FluentWait}.
 *
 * <p>
 * {@code PolleableBuilder} is used in conjunction with {@link PolleableBean} and {@link LoadableFactory} to
 * construct page objects. It is designed to be extended by other builder {@code interfaces} for more complex page
 * objects in such a way that any setter function on {@code PolleableBuilder} or an {@code interface} that
 * {@code extends} it can be called in any order. See the Javadoc documentation for {@link LoadableBuilder} for an
 * explanation and source code examples that show how this is achieved.
 *
 * @param <PolleableT>  the type of {@code Polleable} that this {@code PolleableBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the {@code Polleable} that this
 *                      {@code PolleableBuilder} builds
 * @param <BuilderT>    the runtime type of this {@code PolleableBuilder}
 */
@ParametersAreNonnullByDefault
public interface PolleableBuilder<
            PolleableT extends Polleable,
            BeanT extends PolleableBean,
            BuilderT extends PolleableBuilder<PolleableT, BeanT, BuilderT>
        >
        extends LoadableBuilder<PolleableT, BeanT, BuilderT> {

    /**
     * Sets the polling timeout in seconds for a {@code FluentWait} to poll the page object to determine if an expected
     * condition has been satisfied.
     *
     * @param pollingTimeout   the polling timeout in seconds for a {@code FluentWait} to poll the page object to
     *                         determine if an expected condition has been satisfied
     * @return                 this {@code PolleableBuilder}, cast to its runtime type
     */
    BuilderT setPollingTimeout(int pollingTimeout);

    /**
     * Sets the polling interval in seconds for a {@code FluentWait} to poll the page object to determine if an
     * expected condition has been satisfied.
     *
     * @param pollingInterval  the polling interval in seconds for a {@code FluentWait} to poll the page object to
     *                         determine if an expected condition has been satisfied
     * @return                 this {@code PolleableBuilder}, cast to its runtime type
     */
    BuilderT setPollingInterval(int pollingInterval);

    BuilderT setPollingTimeout(PolleableConfig config);
    BuilderT setPollingInterval(PolleableConfig config);
}
