package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.brixen.pageobject.Loadable;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * {@link Loadable}.
 */
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class LoadableConfigImpl implements LoadableConfig {

    /**
     * The {@code Class} type for this LoadableConfigImpl. This information is necessary for <b>Jackson</b> to properly
     * handle the polymorphic nature of configuration beans.
     */
    private @Getter @Setter Class<? extends LoadableConfig> type;

    /**
     * The load timeout specified in the JSON configuration source for a {@code Loadable}. If the value is an
     * {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code Loadable} in question explicitly
     * defined a {@code null} value for the load timeout. If the specified value is {@code null} the JSON configuration
     * source for the {@code Loadable} did not define any value at all for the load timeout.
     */
    private @Getter @Setter Optional<Integer> loadTimeout;

    /**
     * Additional custom configuration properties specified in the JSON configuration source for a {@code Loadable}
     */
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @JsonAnyGetter
    @Override
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * {@inheritDoc}
     */
    @JsonAnySetter
    @Override
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
