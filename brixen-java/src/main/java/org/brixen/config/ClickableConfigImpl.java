package org.brixen.config;

import org.brixen.pageobject.Clickable;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * {@link Clickable}.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class ClickableConfigImpl extends LoadableConfigImpl implements ClickableConfig {

    /**
     * The Javascript click workaround specified in the JSON configuration source for a {@code Clickable}. If the value
     * is an {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code Clickable} in question explicitly
     * defined a {@code null} value for the flag. If the specified value is {@code null} the JSON configuration
     * source did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> clickWithJavascript;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Boolean> getClickWithJavascript() {
        return clickWithJavascript;
    }
}
