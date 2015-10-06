package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.brixen.pageobject.Polleable;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * {@link Polleable}.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class PolleableConfigImpl extends LoadableConfigImpl implements PolleableConfig {

    /**
     * The polling timeout specified in the JSON configuration source for a {@code Polleable}. If the value is an
     * {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code Polleable} in question explicitly
     * defined a {@code null} value for the polling timeout. If the specified value is {@code null} the JSON
     * configuration source for the {@code Loadable} did not define any value at all for the polling timeout.
     */
    private @Getter @Setter Optional<Integer> pollingTimeout;

    /**
     * The polling interval specified in the JSON configuration source for a {@code Polleable}. If the value is an
     * {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code Polleable} in question explicitly
     * defined a {@code null} value for the polling interval. If the specified value is {@code null} the JSON
     * configuration source for the {@code Loadable} did not define any value at all for the polling interval.
     */
    private @Getter @Setter Optional<Integer> pollingInterval;
}
