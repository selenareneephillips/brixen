package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import java.util.Optional;

/**
 * Defines the contract for a configuration bean for a {@code Polleable} which is deserializable from JSON by
 * <b>Jackson</b>.
 * <p>
 * {@code PolleableConfig} supports dynamic configuration of the polling timeout and polling interval for a
 * {@code Polleable} based on environmental factors such as browser, browser version, OS and OS version.
 */
//This annotation and its data lists all the possible sub-types of PolleableConfig. It is necessary for the sub-types
//to be specified so that Jackson can handle the polymorphic nature of configuration beans for the components modeled
//by this API. This will allow deserialization of any fields in other configuration beans which are declared to be a
//PolleableConfig. If any new sub-types of PolleableConfig are added, they should be listed here.
@JsonSubTypes({
        @Type(value = DropDownMenuConfigImpl.class),
        @Type(value = DynamicControllableConfigImpl.class)
})
public interface PolleableConfig extends LoadableConfig {

    /**
     * Gets the polling timeout specified in the JSON configuration source for a {@code Polleable}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the polling
     *              timeout; an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration
     *              source explicitly defined a {@code null} value for the polling timeout, or an {@code Optional}
     *              wrapping an integer value if the JSON configuration source specified a polling timeout value
     */
    @JsonProperty
    Optional<Integer> getPollingTimeout();

    /**
     * Sets the polling timeout specified in the JSON configuration source for a {@code Polleable}.
     *
     * @param pollingTimeout   the polling timeout for a {@code Polleable} specified in its JSON configuration source
     */
    @JsonProperty
    void setPollingTimeout(Optional<Integer> pollingTimeout);

    /**
     * Gets the polling interval specified in the JSON configuration source for a {@code Polleable}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the polling
     *              interval; an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration
     *              source explicitly defined a {@code null} value for the polling interval, or an {@code Optional}
     *              wrapping an integer value if the JSON configuration source specified a polling interval value
     */
    @JsonProperty
    Optional<Integer> getPollingInterval();

    /**
     * Sets the polling interval specified in the JSON configuration source for a {@code Polleable}.
     *
     * @param pollingInterval   the polling interval for a {@code Polleable} specified in its JSON configuration source
     */
    @JsonProperty
    void setPollingInterval(Optional<Integer> pollingInterval);
}
