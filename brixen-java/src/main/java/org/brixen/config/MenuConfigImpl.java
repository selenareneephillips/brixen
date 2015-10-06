package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * page object that models a menu.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class MenuConfigImpl extends LoadableConfigImpl implements MenuConfig {

    /**
     * The flag specified in the JSON configuration source for enabling/disabling the use of a <b>JavaScript</b>
     * workaround to click the options on the menu. If the value is an {@code Optional} that equal to
     * {@link Optional#empty()} and which returns {@code false} for {@link Optional#isPresent()}, the JSON
     * configuration source for the page object in question explicitly defined a {@code null} value for the flag. If
     * the specified value is {@code null} the JSON configuration source did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> clickOptionWithJavascript;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Boolean> getClickOptionWithJavascript() {
        return clickOptionWithJavascript;
    }
}
