package org.brixen.config;

import org.brixen.pageobject.Clickable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import org.openqa.selenium.WebElement;

import java.util.Optional;

/**
 * Defines the contract for a configuration bean for a {@link Clickable} which is deserializable from JSON by
 * <b>Jackson</b>.
 * <p>
 * {@code ClickableConfig} supports dynamic configuration of the Javascript click work around flag for a
 * {@code Clickable} based on environmental factors such as browser, browser version and OS.
 */
//This annotation and its data lists all the possible sub-types of ClickableConfig. It is necessary for the sub-types to
//be specified so that Jackson can handle the polymorphic nature of configuration beans for the components modeled by
//this API. This will allow deserialization of any fields in other configuration beans which are declared to be a
//ClickableConfig. If any new sub-types of ClickableConfig are added, they should be listed here.
@JsonSubTypes({
        @Type(value = ClickableConfigImpl.class),
        @Type(value = ClickControlConfigImpl.class),
        @Type(value = HoverAndClickControlConfigImpl.class)
})
public interface ClickableConfig extends LoadableConfig {

    /**
     * Sets the Javascript click workaround flag as specified in the JSON configuration source for a {@code Clickable}.
     * <p>
     * Enabling the Javascript click workaround will invoke a 'click' with Javascript rather than using
     * {@link WebElement#click} method. This is useful in circumstances where clicks fail silently, that is
     * {@link WebElement#click} runs without throwing any {@code Exceptions}, but the element is not really clicked.
     *
     * @param clickWithJavascript    the value for the flag specified in its JSON configuration source which if
     *                               {@code true}, enables the Javascript click workaround and if {@code false},
     *                               disables it
     */
     @JsonProperty
    void setClickWithJavascript(Optional<Boolean> clickWithJavascript);

    /**
     * Gets the Javascript click workaround flag specified in the JSON configuration source for a {@code Clickable}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the flag;
     *              an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration source
     *              explicitly defined a {@code null} value for the flag, or an {@code Optional} wrapping an
     *              boolean value if the JSON configuration source specified a non-{@code null} value for the flag
     */
    @JsonProperty
    Optional<Boolean> getClickWithJavascript();

}
