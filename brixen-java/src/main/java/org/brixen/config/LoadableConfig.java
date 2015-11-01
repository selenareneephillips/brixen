package org.brixen.config;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import java.util.Map;
import java.util.Optional;

/**
 * Defines the contract for a configuration bean for a {@code Loadable} which is deserializable from JSON by
 * <b>Jackson</b>.
 * <p>
 * {@code LoadableConfig} supports dynamic configuration of the load timeout for a {@code Loadable} based on
 * environmental factors such as browser, browser version, OS and OS version. Additionally, {@code LoadableConfig}
 * supports the deserialization of any custom properties specified in the JSON configuration source.
 */
//This annotation and its data specify how Jackson is to identify the actual type of the configuration bean it needs to
//populate when it is deserializing configuration data for a Loadable, or one of its sub-types. Configuration beans are
//polymorphic, which is to say that configuration beans for page objects that are more specialized than a Loadable
//extend LoadableConfigImpl. In order for Jackson to property deserialize these more specialized configuration beans,
//there needs to be some data attached to the configuration source to identify the type of configuration it represents.
//This annotation indicates that the class name of the bean will be present in the configuration source and that it
//will be included in the resulting POJO as a property named 'type' which is visible and accessible on the POJO.
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
//This annotation and its data lists all the possible sub-types of LoadableConfig. It is necessary for the sub-types to
//be specified so that Jackson can handle the polymorphic nature of configuration beans for the components modeled by
// this API. When a new configuration bean sub-type is added to the API, it needs to be listed here.
@JsonSubTypes({
        @Type(value = ClickableConfigImpl.class),
        @Type(value = ClickControlConfigImpl.class),
        @Type(value = ControllableConfigImpl.class),
        @Type(value = DropDownMenuConfigImpl.class),
        @Type(value = DynamicControllableConfigImpl.class),
        @Type(value = HoverAndClickControlConfigImpl.class),
        @Type(value = HoverControlConfigImpl.class),
        @Type(value = LoadableConfigImpl.class),
        @Type(value = MenuConfigImpl.class),
        @Type(value = PolleableConfigImpl.class)
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface LoadableConfig {

    /**
     * Sets the {@code Class} type for this configuration bean. This is necessary for <b>Jackson</b> to properly handle
     * sub-types of this configuration bean.
     *
     * @param type  the {@code Class} type for this configuration bean
     */
    @JsonProperty(required = true)
    void setType(Class<? extends LoadableConfig> type);

    /**
     * Gets the {@code Class} type for this configuration bean. This is necessary for <b>Jackson</b> to properly handle
     * sub-types of this configuration bean.
     *
     * @return the {@code Class} type for this configuration bean
     */
    @JsonProperty(required = true)
    Class<? extends LoadableConfig> getType();

    /**
     * Sets the load timeout specified in the JSON configuration source for a {@code Loadable}.
     *
     * @param loadTimeout   the load timeout for a {@code Loadable} specified in its JSON configuration source
     */
    @JsonProperty
    void setLoadTimeout(Optional<Integer> loadTimeout);

    /**
     * Gets the load timeout specified in the JSON configuration source for a {@code Loadable}.
     *
     * @return      {@code null} if there was no value defined in the JSON configuration source for the load timeout;
     *              an {@code Optional} which is equal to {@link Optional#empty()} if the JSON configuration source
     *              explicitly defined a {@code null} value for the load timeout, or an {@code Optional} wrapping an
     *              integer value if the JSON configuration source specified a load timeout value
     */
    @JsonProperty
    Optional<Integer> getLoadTimeout();

    /**
     * Sets an additional custom configuration property for a {@code Loadable} that was found in its JSON configuration
     * source.
     *
     * @param name      the name of the custom configuration property in the JSON configuration source
     * @param value     the value of the custom configuration property in the JSON configuration source
     */
    @JsonAnySetter
    void setAdditionalProperty(String name, Object value);

    /**
     * Gets additional custom configuration properties for a {@code Loadable} that are found in its JSON configuration
     * source.
     *
     * @return additional custom configuration properties for a {@code Loadable} that are found in its JSON
     *         configuration source
     */
    @JsonAnyGetter
    Map<String, Object> getAdditionalProperties();
}
