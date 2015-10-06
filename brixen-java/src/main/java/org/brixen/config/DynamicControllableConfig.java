package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Defines the contract for a configuration bean, which is deserializable from JSON by <b>Jackson</b>, for a page
 * object that models a component that contains web controls that have meaningful side effects with state changes that
 * need to be polled for an expected condition when they are clicked and/or moused over.
 * <p>
 * {@code DynamicControllableConfig} supports dynamic configuration of the controls which the component contains as
 * well as the polling timeout and polling interval for checking if the expected condition that results from
 * interaction with the control has been satisfied.
 */
//This annotation and its data lists all the possible sub-types of DynamicControllableConfig. It is necessary for the
//sub-types to be specified so that Jackson can handle the polymorphic nature of configuration beans for the components
//modeled by this API. This will allow deserialization of any fields in other configuration beans which are declared to
//be a DynamicControllableConfig. If any new sub-types of DynamicControllableConfig are added, they should be listed
//here.
@JsonSubTypes({
        @Type(value = DynamicControllableConfigImpl.class),
        @Type(value = DropDownMenuConfigImpl.class)
})
public interface DynamicControllableConfig extends ControllableConfig, PolleableConfig {
}
