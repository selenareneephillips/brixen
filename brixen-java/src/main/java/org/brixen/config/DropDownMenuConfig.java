package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Defines the contract for a configuration bean which is deserializable from JSON by <b>Jackson</b> for a page object
 * that models a drop down menu.
 */
//This annotation and its data lists all the possible sub-types of  DropDownMenuConfig. It is necessary for the
//sub-types to be specified so that Jackson can handle the polymorphic nature of configuration beans for the components
//modeled by this API. This will allow deserialization of any fields in other configuration beans which are declared to
//be a DropDownMenuConfig. If any new sub-types of DropDownMenuConfig are added, they should be listed here.
@JsonSubTypes({@Type(value = DropDownMenuConfig.class)})
public interface DropDownMenuConfig extends MenuConfig, DynamicControllableConfig {
}
