package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.util.Optional;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * page object that models a component containing web controls that have meaningful side effects whenever they are
 * clicked and/or moused over.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class ControllableConfigImpl extends LoadableConfigImpl implements ControllableConfig {

    /**
     * The configuration beans encapsulating the configuration settings for the component's controls which were
     * specified in the component's JSON configuration source. If the value is an {@code Optional} that equal to
     * {@link Optional#empty()} and which returns {@code false} for {@link Optional#isPresent()}, the JSON
     * configuration source for the component in question explicitly defined a {@code null} value for its collection of
     * control configurations. If the specified value is {@code null} the JSON configuration source did not define any
     * value at all for it.
     */
    private @Getter @Setter Optional<Map<String,ControlConfig>> controlConfigs;
}
