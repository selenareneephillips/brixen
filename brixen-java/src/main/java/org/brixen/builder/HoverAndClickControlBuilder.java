package org.brixen.builder;

import org.brixen.bean.HoverAndClickControlBean;
import org.brixen.config.HoverAndClickControlConfig;
import org.brixen.factory.LoadableFactory;
import org.brixen.pageobject.HoverAndClickControl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Defines the contract for a builder of a <b>Selenium</b> page object that models a web control that has meaningful
 * side effects whenever it is clicked and which must be moused over before it is clickable.
 *
 * <p>
 * {@code HoverAndClickControlBuilder} is used in conjunction with {@link HoverAndClickControlBean} and
 * {@link LoadableFactory} to construct page objects. It is designed to be extended by other builder {@code interfaces}
 * for more complex page objects in such a way that any setter function on {@code HoverAndClickControlBuilder} or an
 * {@code interface} that {@code extends} it can be called in any order. See the Javadoc documentation for
 * {@link LoadableBuilder} for an explanation and source code examples that show how this is achieved.
 *
 * @param <ControlT>   the type of {@code HoverAndClickControl} that this {@code HoverAndClickControlBuilder} builds
 * @param <BeanT>      the data transfer object used to construct the {@code HoverAndClickControl} that this
 *                     {@code HoverAndClickControlBuilder} builds
 * @param <BuilderT>   the runtime type of this {@code HoverAndClickControlBuilder}
 */
public interface HoverAndClickControlBuilder<
            ControlT extends HoverAndClickControl,
            BeanT extends HoverAndClickControlBean,
            BuilderT extends HoverAndClickControlBuilder<ControlT,BeanT,BuilderT>
        > extends ControlBuilder<ControlT,BeanT,BuilderT>, ClickControlBuilder<ControlT,BeanT,BuilderT> {

    /**
     * Sets the element to send the focus to when unhovering the web control.
     * <p>
     * The unhover element should be carefully chosen to ensure that any content that is rendered visible by mousing
     * over the web control is rendered invisible and that the mouseover action on the unhover element does not trigger
     * visibility for any other content panes that you wish to remain hidden or trigger any other undesired side
     * effects.
     *
     * @param unhoverElement    the {@code WebElement} to mouse over in order to unhover the web control by
     *                          ensuring that mouse is focused in a safe location away from it
     * @return                  this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverElement(WebElement unhoverElement);

    /**
     * Enables or disables the Javascript hover workaround for the web control.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouse over action on the web control with Javascript
     * rather than using {@link Actions#moveToElement} method. This is useful in circumstances where the mouse over
     * function fails silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions},
     * but the element is not really moused over.
     *
     * @param hoverWithJavascript    if {@code true}, enables the Javascript hover workaround; {@code false} to disable
     *                               it
     * @return                       this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setHoverWithJavascript(boolean hoverWithJavascript);

    /**
     * Enables or disables the Javascript hover workaround for the web control with the setting from the specified
     * configuration.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouse over action on the web control with Javascript
     * rather than using {@link Actions#moveToElement} method. This is useful in circumstances where the mouse over
     * function fails silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions},
     * but the element is not really moused over.
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for
     *                  the web control
     * @return          this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setHoverWithJavascript(HoverAndClickControlConfig config);

    /**
     * Enables or disables the Javascript hover workaround for the unhover element which is used to focus the mouse in
     * a safe location away from the web control.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouse over action on the unhover element with Javascript
     * rather than using {@link Actions#moveToElement} method. This is useful in circumstances where the mouse over
     * function fails silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions},
     * but the element is not really moused over.
     *
     * @param unhoverWithJavascript    if {@code true}, enables the Javascript hover workaround; {@code false} to
     *                                 disable it
     * @return                         this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverWithJavascript(boolean unhoverWithJavascript);

    /**
     * Enables or disables the Javascript hover workaround for the unhover element which is used to focus the mouse in
     * a safe location away from the web control with the setting from the specified configuration.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouse over action on the unhover element with Javascript
     * rather than using {@link Actions#moveToElement} method. This is useful in circumstances where the mouse over
     * function fails silently, that is the {@link Actions#moveToElement} runs without throwing any {@code Exceptions},
     * but the element is not really moused over.
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for
     *                  the web control
     * @return          this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverWithJavascript(HoverAndClickControlConfig config);

    /**
     * Enables or disables the Javascript click action workaround for forcing the mouse to focus on the web control.
     * <p>
     * Note: It is best to use this in situations where the {@link Actions#moveToElement} method, the Javascript hover
     * workaround and the {@link WebElement#click} method all fail silently, that is they all run without throwing any
     * {@code Exceptions}, but the element is not really moused over or clicked. This will allow automation of test
     * cases which are dependent on the side effects generated by the hover action, but are not related to testing that
     * the hover action alone triggers the desired side effects. In such cases, it would be prudent to manually test
     * the hover action alone in the environment(s) where neither the {@link Actions#moveToElement} nor the Javascript
     * hover workaround trigger the mouseover event and the expected side effect(s).
     *
     * @param clickWithJavascriptInsteadOfHover     if {@code true}, enables the Javascript click action workaround;
     *                                              {@code false} to disable it
     * @return                                      this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setClickWithJavascriptInsteadOfHover(boolean clickWithJavascriptInsteadOfHover);

    /**
     * Enables or disables the Javascript click action workaround for forcing the mouse to focus on the web control
     * with the setting from the specified configuration.
     * <p>
     * Note: It is best to use this in situations where the {@link Actions#moveToElement} method, the Javascript hover
     * workaround and the {@link WebElement#click} method all fail silently, that is they all run without throwing any
     * {@code Exceptions}, but the element is not really moused over or clicked. This will allow automation of test
     * cases which are dependent on the side effects generated by the hover action, but are not related to testing that
     * the hover action alone triggers the desired side effects. In such cases, it would be prudent to manually test
     * the hover action alone in the environment(s) where neither the {@link Actions#moveToElement} nor the Javascript
     * hover workaround trigger the mouseover event and the expected side effect(s).
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for
     *                  the web control
     * @return          this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setClickWithJavascriptInsteadOfHover(HoverAndClickControlConfig config);

    /**
     * Enables or disables the {@link WebElement#click} action workaround for the unhover element which is used to
     * focus the mouse in a safe location away from the web control.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is {@link Actions#moveToElement} and the Javascript hover
     * workaround run without throwing any {@code Exceptions}, but the element is not really moused over.
     *
     * @param unhoverWithClickInstead  if {@code true}, enables the {@link WebElement#click} action workaround for the
     *                                 unhover element; {@code false} to disable it
     * @return                         this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverWithClickInstead(boolean unhoverWithClickInstead);

    /**
     * Enables or disables the {@link WebElement#click} action workaround for the unhover element which is used to
     * focus the mouse in a safe location away from the web control with the setting from the specified configuration.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is {@link Actions#moveToElement} and the Javascript hover
     * workaround run without throwing any {@code Exceptions}, but the element is not really moused over.
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for
     *                  the web control
     * @return          this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverWithClickInstead(HoverAndClickControlConfig config);

    /**
     * Enables or disables the Javascript click action workaround for the unhover element which is used to focus the
     * mouse in a safe location away from the web control.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method, the
     * Javascript hover workaround and the {@link WebElement#click} method fail silently, that is they run without
     * throwing any {@code Exceptions}, but the element is not really moused over or clicked.
     *
     * @param unhoverWithJavascriptClickInstead  if {@code true}, enables the Javascript click action workaround for
     *                                           the unhover element; {@code false} to disable it
     * @return                                   this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverWithJavascriptClickInstead(boolean unhoverWithJavascriptClickInstead);

    /**
     * Enables or disables the Javascript click action workaround for the unhover element which is used to focus the
     * mouse in a safe location away from the web control.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method, the
     * Javascript hover workaround and the {@link WebElement#click} method fail silently, that is they run without
     * throwing any {@code Exceptions}, but the element is not really moused over or clicked.
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for
     *                  the web control
     * @return          this {@code HoverControlBuilder}, cast to its runtime type
     */
    BuilderT setUnhoverWithJavascriptClickInstead(HoverAndClickControlConfig config);
}
