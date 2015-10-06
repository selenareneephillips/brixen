package org.brixen.builder;

import org.brixen.bean.*;
import org.brixen.config.ControllableConfig;
import org.brixen.factory.LoadableFactory;
import org.brixen.pageobject.HoverAndClickControl;
import org.brixen.pageobject.HoverControl;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object that models a component that contains web
 * controls that have meaningful side effects whenever they are clicked and/or moused over.
 * <p>
 * {@code ControllableBuilder} is used in conjunction with {@link ControllableBean} and {@link LoadableFactory} to
 * construct page objects. It is designed to be extended by other builder {@code interfaces} for more complex page
 * objects in such a way that any setter function on {@code ControllableBuilder} or an {@code interface} that
 * {@code extends} it can be called in any order. See the Javadoc documentation for {@link LoadableBuilder} for an
 * explanation and source code examples that show how this is achieved.
 *
 * @param <ControllableT>   the type of page object that this {@code ControllableBuilder} builds
 * @param <BeanT>           the data transfer object used to construct the page object that this
 *                          {@code ControllableBuilder} builds
 * @param <BuilderT>        the runtime type of this {@code ControllableBuilder}
 */
public interface ControllableBuilder<
            ControllableT extends Loadable,
            BeanT extends ControllableBean,
            BuilderT extends ControllableBuilder<ControllableT, BeanT, BuilderT>
        > extends ContentContainerBuilder<ControllableT, BeanT,BuilderT> {

    /**
     * Adds a {@code ClickControlBean} to specify a {@code ClickControl} to add to the page object.
     * <p>
     * This method will use the default implementation of {@code ClickControlBean}, {@code ClickControlBeanImpl}.
     *
     * @param name  the name of the {@code ClickControl} to add to the page object
     * @return      this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT addClickControl(String name);

    /**
     * Adds a {@code HoverControlBean} to specify a {@code HoverControl} to add to the page object.
     * <p>
     * This method will use the default implementation of {@code HoverControlBean}, {@code HoverControlBeanImpl}.
     *
     * @param name  the name of the {@code HoverControl} to add to the page object
     * @return      this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT addHoverControl(String name); //uses default bean implementation

    /**
     * Adds a {@code HoverAndClickControlBean} to specify a {@code HoverAndCLickControl} to add to the page object.
     * <p>
     * This method will use the default implementation of {@code HoverAndClickControlBean},
     * {@code HoverAndClickControlBeanImpl}.
     *
     * @param name  the name of the {@code HoverAndClickControl} to add to the page object
     * @return      this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT addHoverAndClickControl(String name); //uses default bean implementation

    /**
     * Adds a {@code ClickControlBean} of the specified implementation to specify a {@code ClickControl} to add to the
     * page object.
     * <p>
     * The specified implementation of {@code ClickControlBean} must define a no-arg constructor.
     *
     * @param name          the name of the {@code ClickControl} to add to the page object
     * @param beanClass     the {@code class} type of the {@code ClickControlBean} to specify the {@code ClickControl}
     * @return              this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT addClickControl(String name, Class<? extends ClickControlBean> beanClass);

    /**
     * Adds a {@code HoverControlBean} of the specified implementation to specify a {@code HoverControl} to add to the
     * page object.
     * <p>
     * The specified implementation of {@code HoverControlBean} must define a no-arg constructor.
     *
     * @param name          the name of the {@code HoverControl} to add to the page object
     * @param beanClass     the {@code class} type of the {@code HoverControlBean} to specify the {@code HoverControl}
     * @return              this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT addHoverControl(String name, Class<? extends HoverControlBean> beanClass);

    /**
     * Adds a {@code HoverAndClickControlBean} of the specified implementation to specify a {@code HoverControl} to
     * add to the page object.
     * <p>
     * The specified implementation of {@code HoverAndClickControlBean} must define a no-arg constructor.
     *
     * @param name          the name of the {@code HoverAndClickControl} to add to the page object
     * @param beanClass     the {@code class} type of the {@code HoverAndClickControlBean} to specify the
     *                      {@code HoverAndClickControl}
     * @return              this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT addHoverAndClickControl(String name, Class<? extends HoverAndClickControlBean> beanClass);

    /**
     * Sets the driver to use for browsing the specified web control.
     *
     * @param name      the name of the web control
     * @param driver    the {@code WebDriver} to use for browsing the page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlDriver(String name, WebDriver driver);

    /**
     * Sets the load timeout in seconds for specified web control.
     *
     * @param name          the name of the web control
     * @param timeout       the load timeout in seconds for the web control
     * @return              this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlLoadTimeout(String name, int timeout);

    /**
     * Sets the load timeout in seconds for specified web control, based on the configuration for the specified control
     * in the specified {@code ControllableConfig}.
     *
     * @param name          the name of the web control
     * @param config        the configuration bean that encapsulates the settings in the JSON configuration source for
     *                      the page object
     * @return              this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlLoadTimeout(String name, ControllableConfig config);

    /**
     * Sets the {@code WebElement} that contains the specified web control.
     *
     * @param name                the name of the web control
     * @param contentContainer    the {@code WebElement} that contains the specified web control
     * @return                    this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlContentContainer(String name, WebElement contentContainer);

    /**
     * Sets the polling timeout in seconds for the specified web control for polling the web control to determine if an
     * expected condition has been satisfied.
     *
     * @param name        the name of the web control
     * @param timeout     the timeout in seconds for polling the web control to determine if an expected condition has
     *                    been satisfied
     * @return            this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlPollingTimeout(String name, int timeout);

    /**
     * Sets the polling timeout in seconds for the specified web control for polling the web control to determine if an
     * expected condition has been satisfied.
     *
     * @param name        the name of the web control
     * @param config      the configuration bean that encapsulates the settings in the JSON configuration source for
     *                    the page object
     * @return            this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlPollingTimeout(String name, ControllableConfig config);

    /**
     * Sets the polling internal in seconds for the specified web control for polling the web control to determine if
     * an expected condition has been satisfied.
     *
     * @param name        the name of the web control
     * @param interval    the interval in seconds for polling the web control to determine if an expected condition has
     *                    been satisfied
     * @return            this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlPollingInterval(String name, int interval);

    /**
     * Sets the polling internal in seconds for the specified web control for polling the web control to determine if
     * an expected condition has been satisfied.
     *
     * @param name        the name of the web control
     * @param config      the configuration bean that encapsulates the settings in the JSON configuration source for
     *                    the page object
     * @return            this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlPollingInterval(String name, ControllableConfig config);

    /**
     * Sets the element to send the focus to when unhovering the specified web control.
     * <p>
     * The unhover {@code WebElement} should be carefully chosen to ensure that any content that is rendered visible
     * by mousing over the specified web control is rendered invisible and that the mouseover action on the unhover
     * {@code WebElement} does not trigger visibility for any other content panes that you wish to remain hidden.
     *
     * @param name                the name of the web control
     * @param unhoverElement      the {@code WebElement} to hover over in order to unhover the specified control by
     *                            ensuring that mouse focus is completely removed from it
     * @return                    this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setControlUnhoverElement(String name, WebElement unhoverElement);

    /**
     * Enables or disables the Javascript click workaround for the specified web control.
     * <p>
     * Enabling the Javascript click workaround will invoke a 'click' on the web control with Javascript
     * rather than using {@link WebElement#click} method. This is useful in circumstances where clicks fail silently,
     * that is {@link WebElement#click} runs without throwing any {@code Exceptions}, but the element is not really
     * clicked.
     *
     * @param name                   the name of the web control
     * @param clickWithJavascript    if {@code true}, enables the Javascript click workaround; {@code false} to disable
     *                               it
     * @return                       this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setClickControlWithJavascript(String name, boolean clickWithJavascript);

    /**
     * Enables or disables the Javascript click workaround for the specified web control, based on the configuration
     * for the specified control in the specified {@code ControllableConfig}.
     * <p>
     * Enabling the Javascript click workaround will invoke a 'click' on the web control with Javascript
     * rather than using {@link WebElement#click} method. This is useful in circumstances where clicks fail silently,
     * that is {@link WebElement#click} runs without throwing any {@code Exceptions}, but the element is not really
     * clicked.
     *
     * @param name      the name of the web control
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setClickControlWithJavascript(String name, ControllableConfig config);

    /**
     * Enables or disables the Javascript hover workaround for the specified web control.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouseover action on the web control with Javascript
     * rather than using {@link Actions#moveToElement} method. This is useful in circumstances where the mouseover
     * function fails silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions},
     * but the element is not really moused over.
     *
     * @param name                   the name of the web control
     * @param hoverWithJavascript    if {@code true}, enables the Javascript hover workaround workaround; {@code false}
     *                               to disable it
     * @return                       this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setHoverControlWithJavascript(String name, boolean hoverWithJavascript);

    /**
     * Enables or disables the Javascript hover workaround for the specified web control, based on the configuration
     * for the specified control in the specified {@code ControllableConfig}.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouseover action on the web control with Javascript
     * rather than using {@link Actions#moveToElement} method. This is useful in circumstances where the mouseover
     * function fails silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions},
     * but the element is not really moused over.
     *
     * @param name      the name of the web control
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setHoverControlWithJavascript(String name, ControllableConfig config);

    /**
     * Enables or disables the Javascript hover workaround for the unhover element for the specified web control.
     * <p>
     * The unhover element is used to focus the mouse in a safe location away from the web control. Enabling the
     * Javascript hover workaround will invoke a mouse over action on the unhover element with Javascript rather than
     * using {@link Actions#moveToElement} method. This is useful in circumstances where the mouse over function fails
     * silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions}, but the
     * element is not really moused over.
     *
     * @param name                     the name of the web control
     * @param unhoverWithJavascript    if {@code true}, enables the Javascript hover workaround; {@code false} to
     *                                 disable it
     * @return                         this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverControlWithJavascript(String name, boolean unhoverWithJavascript);

    /**
     * Enables or disables the Javascript hover workaround for the unhover element for the specified web control, based
     * on the configuration for the specified control in the specified {@code ControllableConfig}.
     * <p>
     * The unhover element is used to focus the mouse in a safe location away from the web control. Enabling the
     * Javascript hover workaround will invoke a mouse over action on the unhover element with Javascript rather than
     * using {@link Actions#moveToElement} method. This is useful in circumstances where the mouse over function fails
     * silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions}, but the
     * element is not really moused over.
     *
     * @param name      the name of the web control
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverControlWithJavascript(String name, ControllableConfig config);

    /**
     * Enables or disables the {@link WebElement#click} action workaround for forcing the mouse to focus on the
     * specified web control.
     * <p>
     * Note: It is best to use this in situations where both the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is {@link Actions#moveToElement} and the Javascript hover
     * workaround run without throwing any {@code Exceptions}, but the element is not really moused over. This will
     * allow automation of test cases which are dependent on the side effects generated by the hover action, but are
     * not related to testing that the hover action alone triggers the desired side effects. In such cases, it would be
     * prudent to manually test the hover action alone in the environment(s) where neither the
     * {@link Actions#moveToElement} nor the Javascript hover workaround trigger the mouseover event and the expected
     * side effect(s).
     *
     * @param name                   the name of the web control
     * @param clickInsteadOfHover    if {@code true}, enables the {@link WebElement#click} action workaround;
     *                               {@code false} to disable it
     * @return                       this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setClickControlInsteadOfHover(String name, boolean clickInsteadOfHover);

    /**
     * Enables or disables the {@link WebElement#click} action workaround for forcing the mouse to focus on the
     * specified web control, based on the configuration for the specified control in the specified
     * {@code ControllableConfig}.
     * <p>
     * Note: It is best to use this in situations where both the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is {@link Actions#moveToElement} and the Javascript hover
     * workaround run without throwing any {@code Exceptions}, but the element is not really moused over. This will
     * allow automation of test cases which are dependent on the side effects generated by the hover action, but are
     * not related to testing that the hover action alone triggers the desired side effects. In such cases, it would be
     * prudent to manually test the hover action alone in the environment(s) where neither the
     * {@link Actions#moveToElement} nor the Javascript hover workaround trigger the mouseover event and the expected
     * side effect(s).
     *
     * @param name      the name of the web control
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setClickControlInsteadOfHover(String name, ControllableConfig config);

    /**
     * Enables or disables the Javascript click action workaround for the specified web control.
     *
     * In the case of a visible control, a {@code HoverControl}, enabling this flag will use a Javascript click to
     * force the mouse to focus on the control, thus triggering the same side effects that occur when using a true
     * hover action. In the case of a control which is not visible unless it is hovered, a {@code HoverAndClickControl}
     * enabling this flag make it possible to click the control without having to hover over it to make it visible
     * first.
     * <p>
     * Note: It is best to use this in situations where the {@link Actions#moveToElement} method, the Javascript hover
     * workaround and the {@link WebElement#click} method all fail silently, that is they all run without throwing any
     * {@code Exceptions}, but the element is not really moused over or clicked.
     * <p>
     * For a {@link HoverControl}, this will allow automation of test cases which are dependent on the side effects
     * generated by the hover action, but are not related to testing that the hover action alone triggers the desired
     * side effects. In such cases, it would be prudent to manually test the hover action alone in the environment(s)
     * where neither the {@link Actions#moveToElement} nor the Javascript hover workaround trigger the mouseover event
     * and the expected side effect(s).
     * <p>
     * For a {@link HoverAndClickControl}, this will help in situations where a hover cannot be executed to make the
     * control visible because usually, a Javascript click will successfully click an element that is not visible, and
     * this this will allow automation of test cases which are dependent on the side effects generated by the click
     * action, but are not related to testing that the hover action makes the web control visible. In such cases, it
     * would be prudent to manually test the hover action alone in the environment(s) where neither the
     * {@link Actions#moveToElement} nor the Javascript hover workaround trigger the mouseover event that makes the
     * control visible.
     *
     * @param name                                  the name of the web control
     * @param clickWithJavascriptInsteadOfHover     if {@code true}, enables the Javascript click action workaround;
     *                                              {@code false} to disable it
     * @return                                      this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setClickControlWithJavascriptInsteadOfHover(String name, boolean clickWithJavascriptInsteadOfHover);

    /**
     * Enables or disables the Javascript click action workaround for the specified web control, based on the
     * configuration for the specified control in the specified {@code ControllableConfig}.
     *
     * In the case of a visible control, a {@code HoverControl}, enabling this flag will use a Javascript click to
     * force the mouse to focus on the control, thus triggering the same side effects that occur when using a true
     * hover action. In the case of a control which is not visible unless it is hovered, a {@code HoverAndClickControl}
     * enabling this flag make it possible to click the control without having to hover over it to make it visible
     * first.
     * <p>
     * Note: It is best to use this in situations where the {@link Actions#moveToElement} method, the Javascript hover
     * workaround and the {@link WebElement#click} method all fail silently, that is they all run without throwing any
     * {@code Exceptions}, but the element is not really moused over or clicked.
     * <p>
     * For a {@link HoverControl}, this will allow automation of test cases which are dependent on the side effects
     * generated by the hover action, but are not related to testing that the hover action alone triggers the desired
     * side effects. In such cases, it would be prudent to manually test the hover action alone in the environment(s)
     * where neither the {@link Actions#moveToElement} nor the Javascript hover workaround trigger the mouseover event
     * and the expected side effect(s).
     * <p>
     * For a {@link HoverAndClickControl}, this will help in situations where a hover cannot be executed to make the
     * control visible because usually, a Javascript click will successfully click an element that is not visible, and
     * this this will allow automation of test cases which are dependent on the side effects generated by the click
     * action, but are not related to testing that the hover action makes the web control visible. In such cases, it
     * would be prudent to manually test the hover action alone in the environment(s) where neither the
     * {@link Actions#moveToElement} nor the Javascript hover workaround trigger the mouseover event that makes the
     * control visible.
     *
     * @param name      the name of the web control
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setClickControlWithJavascriptInsteadOfHover(String name, ControllableConfig config);

    /**
     * Enables or disables the {@link WebElement#click} action workaround for the unhover element which is used to
     * focus the mouse in a safe location away from the specified web control.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is {@link Actions#moveToElement} and the Javascript hover
     * workaround run without throwing any {@code Exceptions}, but the element is not really moused over.
     *
     * @param name                     the name of the web control
     * @param unhoverWithClickInstead  if {@code true}, enables the {@link WebElement#click} action workaround for the
     *                                 unhover element; {@code false} to disable it
     * @return                         this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverControlWithClickInstead(String name, boolean unhoverWithClickInstead);

    /**
     * Enables or disables the {@link WebElement#click} action workaround for the unhover element which is used to
     * focus the mouse in a safe location away from the specified web control, based on the configuration for the
     * specified control in the specified {@code ControllableConfig}.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is {@link Actions#moveToElement} and the Javascript hover
     * workaround run without throwing any {@code Exceptions}, but the element is not really moused over.
     *
     * @param name      the name of the web control
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverControlWithClickInstead(String name, ControllableConfig config);

    /**
     * Enables or disables the Javascript click action workaround for the unhover element which is used to focus the
     * mouse in a safe location away from the specified web control.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method, the
     * Javascript hover workaround and the {@link WebElement#click} method fail silently, that is they run without
     * throwing any {@code Exceptions}, but the element is not really moused over or clicked.
     *
     * @param name                               the name of the web control
     * @param unhoverWithJavascriptClickInstead  if {@code true}, enables the Javascript click action workaround for
     *                                           the unhover element; {@code false} to disable it
     * @return                                   this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverControlWithJavascriptClickInstead(String name, boolean unhoverWithJavascriptClickInstead);

    /**
     * Enables or disables the Javascript click action workaround for the unhover element which is used to focus the
     * mouse in a safe location away from the specified web control, based on the configuration for the specified
     * control in the specified {@code ControllableConfig}.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method, the
     * Javascript hover workaround and the {@link WebElement#click} method fail silently, that is they run without
     * throwing any {@code Exceptions}, but the element is not really moused over or clicked.
     *
     * @param name      the name of the web control
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  page object
     * @return          this {@code ControllableBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverControlWithJavascriptClickInstead(String name, ControllableConfig config);
}
