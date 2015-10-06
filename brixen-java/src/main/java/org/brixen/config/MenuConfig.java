package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import java.util.Optional;

/**
 * Defines the contract for a configuration bean which is deserializable from JSON by <b>Jackson</b> for a page object
 * that models a menu.
 * <p>
 * {@code MenuConfig} supports dynamic configuration of the use of <b>JavaScript</b> workarounds for clicking options
 * on the menu based on environmental factors such as browser, browser version, OS and OS version. Native Selenium
 * implementations for these actions often fail silently in some environments, requiring the use of <b>JavaScript</b>
 * workarounds to perform them successfully.
 */
//This annotation and its data lists all the possible sub-types of MenuConfig. It is necessary for the sub-types to be
//specified so that Jackson can handle the polymorphic nature of configuration beans for the components modeled by this
//API. This will allow deserialization of any fields in other configuration beans which are declared to be a
//MenuConfig. If any new sub-types of MenuConfig are added, they should be listed here.
@JsonSubTypes({@Type(value = MenuConfigImpl.class)})
public interface MenuConfig extends LoadableConfig {

    /**
     * Gets the flag specified in the JSON configuration source for enabling/disabling the use of a <b>JavaScript</b>
     * workaround to click the options on the menu.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the
     *              <b>JavaScript</b> workaround flag; an {@code Optional} which is equal to {@link Optional#empty()}
     *              if the JSON configuration source explicitly defined a {@code null} value for the <b>JavaScript</b>
     *              workaround flag, or an {@code Optional} wrapping a boolean value if the JSON configuration source
     *              specified a value for the flag
     */
    @JsonProperty
    Optional<Boolean> getClickOptionWithJavascript();

    /**
     * Sets the flag specified in the JSON configuration source for enabling/disabling the use of a <b>JavaScript</b>
     * workaround to click the options on the menu.
     *
     * @param clickOptionWithJavascript   the value of the flag for enabling/disabling the use of a <b>JavaScript</b>
     *                                    workaround to click the options in the menu specified in the JSON
     *                                    configuration source for the page object
     */
    @JsonProperty
    void setClickOptionWithJavascript(Optional<Boolean> clickOptionWithJavascript);
}
