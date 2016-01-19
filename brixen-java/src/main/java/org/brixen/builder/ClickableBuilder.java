package org.brixen.builder;

import org.brixen.bean.ClickableBean;
import org.brixen.config.ClickableConfig;
import org.brixen.pageobject.Clickable;
import org.brixen.factory.LoadableFactory;
import org.openqa.selenium.WebElement;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object which models a {@code Clickable} page object.
 *
 * <p>
 * {@code ClickableBuilder} is used in conjunction with {@link ClickableBean} and {@link LoadableFactory} to construct
 * page objects. It is designed to be extended by other builder {@code interfaces} for more complex page objects in
 * such a way that any setter function on {@code ClickableBuilder} or an {@code interface} that {@code extends} it can
 * be called in any order. See the Javadoc documentation for {@link LoadableBuilder} for an explanation and source code
 * examples that show how this is achieved.
 *
 * @param <ClickableT>   the type of {@code Clickable} page object that this {@code ClickableBuilder} builds
 * @param <BeanT>        the data transfer object used to construct the {@code Clickable} page object that this
 *                       {@code ClickableBuilder} builds
 * @param <BuilderT>     the runtime type of this {@code ClickableBuilder}
 */
@ParametersAreNonnullByDefault
public interface ClickableBuilder<
            ClickableT extends Clickable,
            BeanT extends ClickableBean,
            BuilderT extends ClickableBuilder<ClickableT,BeanT,BuilderT>
        > extends ContentContainerBuilder<ClickableT,BeanT,BuilderT> {

    /**
     * Enables or disables the Javascript click workaround.
     * <p>
     * Enabling the Javascript click workaround will invoke a 'click' on the wrapped {@code WebElement} with Javascript
     * rather than using {@link WebElement#click} method. This is useful in circumstances where clicks fail silently,
     * that is {@link WebElement#click} runs without throwing any {@code Exceptions}, but the element is not really
     * clicked.
     *
     * @param clickWithJavascript    if {@code true}, enables the Javascript click workaround; {@code false} to disable
     *                               it
     * @return                       this {@code ClickableBuilder}, cast to its runtime type
     */
    BuilderT setClickWithJavascript(boolean clickWithJavascript);

    /**
     * Enables or disabled the Javascript click workaround, based on the configuration value for this flag in the
     * specified {@code ClickableConfig}.
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  {@code Clickable} page object
     * @return          this {@code ClickableBuilder}, cast to its runtime type
     */
    BuilderT setClickWithJavascript(ClickableConfig config);
}
