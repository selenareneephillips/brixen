package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import java.util.Map;
import java.util.Optional;

/**
 * Defines the contract for a configuration bean, which is deserializable from JSON by <b>Jackson</b>, for a page
 * object that models a component containing web controls that have meaningful side effects whenever they are clicked
 * and/or moused over.
 * <p>
 * {@code ControllableConfig} supports dynamic configuration of the controls which the component contains.
 */
//This annotation and its data lists all the possible sub-types of ControllableConfig. It is necessary for the
//sub-types to be specified so that Jackson can handle the polymorphic nature of configuration beans for the components
//modeled by this API. This will allow deserialization of any fields in other configuration beans which are declared to
//be a ControllableConfig. If any new sub-types of ControllableConfig are added, they should be listed here.
@JsonSubTypes({
        @Type(value = ControllableConfigImpl.class),
        @Type(value = DynamicControllableConfigImpl.class),
        @Type(value = DropDownMenuConfigImpl.class)
})
public interface ControllableConfig extends LoadableConfig {

    /**
     * Sets the configuration beans encapsulating the configuration settings for the component's controls which were
     * specified in the component's JSON configuration source.
     *
     * @param controlConfigs    the configuration beans encapsulating the configuration settings for the component's
     *                          controls which were specified in the component's JSON configuration source
     */
    @JsonProperty
    void setControlConfigs(Optional<Map<String,ControlConfig>> controlConfigs);

    /**
     * Gets the configuration beans encapsulating the configuration settings for the component's controls which were
     * specified in the component's JSON configuration source.
     *
     * @return      {@code null} if there were no settings defined in the JSON configuration source for components
     *              controls; an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration
     *              source explicitly defined a {@code null} value for control configurations, or an {@code Optional}
     *              wrapping a mapping of control configurations to the controls' names
     */
    @JsonProperty
    Optional<Map<String,ControlConfig>> getControlConfigs();

    /**
     * Gets the {@code ControlConfig} encapsulating the configuration settings for the web control with the specified
     * name.
     *
     * @param name      the name of the control
     * @return          the {@code ControlConfig} encapsulating the configuration settings for the web control with the
     *                  specified name, or {@code null} if there is no configuration specified
     */
    @JsonIgnore
    default ControlConfig getControlConfig(String name) {
        Optional<Map<String, ControlConfig>> configs = getControlConfigs();

        if(configs != null && configs.get() != null) {
            return configs.get().get(name);
        }

        return null;
    }
}
