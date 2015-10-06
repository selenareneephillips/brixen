package org.brixen.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import org.brixen.pageobject.ClickControl;

/**
 * Defines the contract for a configuration bean for a {@link ClickControl} which is deserializable from JSON by
 * <b>Jackson</b>.
 * <p>
 * {@code ClickControlConfig} supports dynamic configuration of the Javascript click work around flag for a
 * {@code ClickControl} based on environmental factors such as browser, browser version and OS.
 */
//This annotation and its data lists all the possible sub-types of ClickControlConfig. It is necessary for the
//sub-types to be specified so that Jackson can handle the polymorphic nature of configuration beans for the components
//modeled by this API. This will allow deserialization of any fields in other configuration beans which are declared to
//be a ClickControlConfig. If any new sub-types of ClickControlConfig are added, they should be listed here.
@JsonSubTypes({
        @Type(value = ClickControlConfigImpl.class),
        @Type(value = HoverAndClickControlConfigImpl.class)
})
public interface ClickControlConfig extends ClickableConfig, ControlConfig {
}
