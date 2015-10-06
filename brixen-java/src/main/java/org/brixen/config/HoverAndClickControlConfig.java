package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import org.brixen.pageobject.HoverAndClickControl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Optional;

/**
 * Defines the contract for a configuration bean for a {@link HoverAndClickControl} which is deserializable from JSON 
 * by <b>Jackson</b>.
 * <p>
 * {@code HoverAndClickControlConfig} supports dynamic configuration of the workaround flags for hovering and 
 * unhovering the web control using Javascript where {@link Actions#moveToElement} fails to execute the hover action as 
 * well as workaround flags for using a click through {@link WebElement#click} or through Javascript to unhover the web 
 * control if the hover actions cannot be achieve either through {@link Actions#moveToElement} or the Javascript 
 * workaround.
 */
//This annotation and its data lists all the possible sub-types of HoverAndClickControlConfig. It is necessary for the
//sub-types to be specified so that Jackson can handle the polymorphic nature of configuration beans for the components
//modeled by this API. This will allow deserialization of any fields in other configuration beans which are declared to
//be a HoverAndClickControlConfig. If any new sub-types of HoverAndCLickControlConfig are added, they should be listed 
//here.
@JsonSubTypes({@Type(value = HoverAndClickControlConfigImpl.class)})
public interface HoverAndClickControlConfig extends ControlConfig, ClickControlConfig, PolleableConfig {

    /**
     * Sets the Javascript hover workaround flag as specified in the JSON configuration source for a
     * {@code HoverAndClickControl}.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouseover with Javascript rather than using
     * {{@link Actions#moveToElement} method. This is useful in circumstances where mouseover fail silently, that is
     * {@link Actions#moveToElement} runs without throwing any {@code Exceptions}, but the element is not moused over.
     *
     * @param hoverWithJavascript    the value for the flag specified in its JSON configuration source which if
     *                               {@code true}, enables the Javascript hover workaround and if {@code false},
     *                               disables it
     */
    @JsonProperty
    void setHoverWithJavascript(Optional<Boolean> hoverWithJavascript);

    /**
     * Gets the Javascript hover workaround flag specified in the JSON configuration source for a {@code HoverAndClickControl}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the flag;
     *              an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration source
     *              explicitly defined a {@code null} value for the flag, or an {@code Optional} wrapping an
     *              boolean value if the JSON configuration source specified a non-{@code null} value for the flag
     */
    @JsonProperty
    Optional<Boolean> getHoverWithJavascript();

    /**
     * Sets the Javascript hover workaround flag for the unhover element which is used to focus the mouse in a safe
     * location away from the web control as specified in the JSON configuration source for a {@code HoverAndClickControl}.
     * <p>
     * Enabling the Javascript hover workaround will invoke a mouseover with Javascript rather than using
     * {{@link Actions#moveToElement} method. This is useful in circumstances where mouseover fail silently, that is
     * {@link Actions#moveToElement} runs without throwing any {@code Exceptions}, but the element is not moused over.
     *
     * @param unhoverWithJavascript    the value for the flag specified in its JSON configuration source which if
     *                                 {@code true}, enables the Javascript hover workaround and if {@code false},
     *                                 disables it
     */
    @JsonProperty
    void setUnhoverWithJavascript(Optional<Boolean> unhoverWithJavascript);

    /**
     * Gets the Javascript hover workaround flag for the unhover element which is used to focus the mouse in a safe
     * location away from the web control as specified specified in the JSON configuration source for a
     * {@code HoverAndClickControl}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the flag;
     *              an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration source
     *              explicitly defined a {@code null} value for the flag, or an {@code Optional} wrapping an
     *              boolean value if the JSON configuration source specified a non-{@code null} value for the flag
     */
    @JsonProperty
    Optional<Boolean> getUnhoverWithJavascript();

    /**
     * Sets the workaround for clicking the web control with Javascript instead of trying to execute a mouseover on it
     * first to make it visible as specified specified in the JSON configuration source for a
     * @code HoverAndClickControl}.
     * <p>
     * Note: It is best to use this in situations where both the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is they run without throwing any {@code Exceptions}, but the
     * element is not really moused over. Usually, a Javascript click will successfully click an element that is not
     * visible, and this this will allow automation of test cases which are dependent on the side effects generated by
     * the click action, but are not related to testing that the hover action makes the web control visible. In such
     * cases, it would be prudent to manually test the hover action alone in the environment(s) where neither the
     * {@link Actions#moveToElement} nor the Javascript hover workaround trigger the mouseover event that makes the
     * control visible.
     *
     * @param clickWithJavascriptInsteadOfHover     the value for the flag specified in its JSON configuration source
     *                                              which if {@code true}, enables the Javascript hover workaround and
     *                                              if {@code false}, disables it
     */
    @JsonProperty
    void setClickWithJavascriptInsteadOfHover(Optional<Boolean> clickWithJavascriptInsteadOfHover);

    /**
     * Gets the Javascript click action workaround flag for clicking the web control with Javascript instead of trying
     * to execute a mouseover on it first to make it visible as specified specified in the JSON configuration source
     * for a @code HoverAndClickControl}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the flag;
     *              an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration source
     *              explicitly defined a {@code null} value for the flag, or an {@code Optional} wrapping an
     *              boolean value if the JSON configuration source specified a non-{@code null} value for the flag
     * @see {@link #setClickWithJavascriptInsteadOfHover(Optional)} for caveats about this workaround
     */
    @JsonProperty
    Optional<Boolean> getClickWithJavascriptInsteadOfHover();

    /**
     * Sets the {@link WebElement#click} action workaround flag for the unhover element which is used to focus the
     * mouse in a safe location away from the web control as specified in the JSON configuration source for a
     * {@code HoverAndClickControl}.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method and the
     * Javascript hover workaround fail silently, that is {@link Actions#moveToElement} and the Javascript hover
     * workaround run without throwing any {@code Exceptions}, but the element is not really moused over.
     *
     * @param unhoverWithClickInstead  the value for the flag specified in its JSON configuration source which if
     *                                 {@code true}, enables the Javascript hover workaround and if {@code false},
     *                                 disables it
     */
    @JsonProperty
    void setUnhoverWithClickInstead(Optional<Boolean> unhoverWithClickInstead);

    /**
     * Gets the {@link WebElement#click} action workaround flag for the unhover element which is used to focus the
     * mouse in a safe location away from the web control as specified in the JSON configuration source for a
     * {@code HoverAndClickControl}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the flag;
     *              an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration source
     *              explicitly defined a {@code null} value for the flag, or an {@code Optional} wrapping an
     *              boolean value if the JSON configuration source specified a non-{@code null} value for the flag
     * @see {@link #setUnhoverWithClickInstead(Optional)} for caveats about this workaround
     */
    @JsonProperty
    Optional<Boolean> getUnhoverWithClickInstead();

    /**
     * Sets the Javascript click action workaround flag for the unhover element which is used to focus the mouse in a
     * safe location away from the web control as specified in the JSON configuration source for a {@code HoverAndClickControl}.
     * <p>
     * Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects and
     * serves only to force the mouse away from the web control. This action is riskier than hovering the mouse over
     * the unhover element, so it should be used in situations where the {@link Actions#moveToElement} method, the
     * Javascript hover workaround and the {@link WebElement#click} method fail silently, that is they run without
     * throwing any {@code Exceptions}, but the element is not really moused over or clicked.
     *
     * @param unhoverWithJavascriptClickInstead  the value for the flag specified in its JSON configuration source
     *                                           which if {@code true}, enables the Javascript hover workaround and if
     *                                           {@code false}, disables it
     */
    @JsonProperty
    void setUnhoverWithJavascriptClickInstead(Optional<Boolean> unhoverWithJavascriptClickInstead);

    /**
     * Gets the Javascript click action workaround flag for the unhover element which is used to focus the mouse in a
     * safe location away from the web control as specified in the JSON configuration source for a {@code HoverAndClickControl}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the flag;
     *              an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration source
     *              explicitly defined a {@code null} value for the flag, or an {@code Optional} wrapping an
     *              boolean value if the JSON configuration source specified a non-{@code null} value for the flag
     * @see {@link #setUnhoverWithJavascriptClickInstead(Optional)} for caveats about this workaround
     */
    @JsonProperty
    Optional<Boolean> getUnhoverWithJavascriptClickInstead();
}
