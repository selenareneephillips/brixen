package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import org.brixen.pageobject.Control;

/**
 * Defines the contract for a configuration bean for a {@link Control} which is deserializable from JSON by
 * <b>Jackson</b>.
 * <p>
 * {@code ControlConfig} is a marker {@code interface} that services mainly as a type declaration.
 */
//This annotation and its data lists all the possible sub-types of ControlConfig. It is necessary for the sub-types to
//be specified so that Jackson can handle the polymorphic nature of configuration beans for the components modeled by
//this API. This will allow deserialization of any fields in other configuration beans which are declared to be a
//ControlConfig. If any new sub-types of ControlConfig are added, they should be listed here.
@JsonSubTypes({
        @Type(value = ClickControlConfigImpl.class),
        @Type(value = HoverControlConfigImpl.class),
        @Type(value = HoverAndClickControlConfigImpl.class)
})
public interface ControlConfig extends LoadableConfig {

    /**
     * Determines if this {@code ControlConfig} is a {@link ClickControlConfig}.
     *
     * @return  {@code true} if this {@code ControlConfig}'s runtime type is {@code ClickControlConfig} or some
     *          sub-type of it; {@code false} otherwise
     */
    default boolean isClickControlConfig() {
        return ClickControlConfig.class.isAssignableFrom(this.getClass());
    }

    /**
     * Determines if this {@code ControlConfig} is a {@link HoverControlConfig}.
     *
     * @return  {@code true} if this {@code ControlConfig}'s runtime type is {@code HoverControlConfig} or some
     *          sub-type of it; {@code false} otherwise
     */
    default boolean isHoverControlConfig() {
        return HoverControlConfig.class.isAssignableFrom(this.getClass());
    }

    /**
     * Determines if this {@code ControlConfig} is a {@link HoverAndClickControlConfig}.
     *
     * @return  {@code true} if this {@code ControlConfig}'s runtime type is {@code HoverAndClickControlConfig} or some
     *          sub-type of it; {@code false} otherwise
     */
    default boolean isHoverAndClickControlConfig() {
        return HoverAndClickControlConfig.class.isAssignableFrom(this.getClass());
    }
}
