package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import org.brixen.pageobject.HoverControl;
import org.openqa.selenium.WebElement;

import java.util.Optional;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * {@link HoverControl}.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class HoverControlConfigImpl extends LoadableConfigImpl implements HoverControlConfig {

    /**
     * The Javascript hover workaround flag specified in the JSON configuration source for a {@code HoverControl}. If
     * the value is an {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code HoverControl} in question explicitly
     * defined a {@code null} value for the flag. If the specified value is {@code null} the JSON configuration source
     * did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> hoverWithJavascript;

    /**
     * The Javascript hover workaround flag for the unhover element which is used to focus the mouse in a safe location
     * away from the web control specified in the JSON configuration source for a {@code HoverControl}. If the value is
     * an {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code HoverControl} in question explicitly
     * defined a {@code null} value for the flag. If the specified value is {@code null} the JSON configuration source
     * did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> unhoverWithJavascript;

    /**
     * The {@link WebElement#click} action workaround flag for forcing the mouse to focus on the web control as
     * specified in the JSON configuration source for a {@code HoverControl}. If the value is an {@code Optional} that
     * equal to {@link Optional#empty()} and which returns {@code false} for {@link Optional#isPresent()}, the JSON
     * configuration source for the {@code HoverControl} in question explicitly defined a {@code null} value for the
     * flag. If the specified value is {@code null} the JSON configuration source did not define any value at all for
     * the flag.
     */
    private @Setter Optional<Boolean> clickInsteadOfHover;

    /**
     * The Javascript click action workaround flag for forcing the mouse to focus on the web control as specified in
     * the JSON configuration source for a {@code HoverControl}. If the value is an {@code Optional} that equal to
     * {@link Optional#empty()} and which returns {@code false} for {@link Optional#isPresent()}, the JSON
     * configuration source for the {@code HoverControl} in question explicitly defined a {@code null} value for the
     * flag. If the specified value is {@code null} the JSON configuration source did not define any value at all for
     * the flag.
     */
    private @Setter Optional<Boolean> clickWithJavascriptInsteadOfHover;

    /**
     * The {@link WebElement#click} action workaround flag for the unhover element which is used to focus the mouse in
     * a safe location away from the web control as specified in the JSON configuration source for a
     * {@code HoverControl}. If the value is an {@code Optional} that equal to {@link Optional#empty()} and which
     * returns {@code false} for {@link Optional#isPresent()}, the JSON configuration source for the
     * {@code HoverControl} in question explicitly defined a {@code null} value for the flag. If the specified value is
     * {@code null} the JSON configuration source did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> unhoverWithClickInstead;

    /**
     * The Javascript click action workaround flag for the unhover element which is used to focus the mouse in a safe
     * location away from the web control as specified in the JSON configuration source for a {@code HoverControl}. If
     * the value is an {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code HoverControl} in question explicitly
     * defined a {@code null} value for the flag. If the specified value is {@code null} the JSON configuration source
     * did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> unhoverWithJavascriptClickInstead;

    /**
     *{@code inheritDoc}
     */
    @Override
    public Optional<Boolean> getHoverWithJavascript() {
        return hoverWithJavascript;
    }

    /**
     *{@code inheritDoc}
     */
    @Override
    public Optional<Boolean> getUnhoverWithJavascript() {
        return unhoverWithJavascript;
    }

    /**
     *{@code inheritDoc}
     */
    @Override
    public Optional<Boolean> getClickInsteadOfHover() {
        return clickInsteadOfHover;
    }

    /**
     *{@code inheritDoc}
     */
    @Override
    public Optional<Boolean> getClickWithJavascriptInsteadOfHover() {
        return clickWithJavascriptInsteadOfHover;
    }

    /**
     *{@code inheritDoc}
     */
    @Override
    public Optional<Boolean> getUnhoverWithClickInstead() {
        return unhoverWithClickInstead;
    }

    /**
     *{@code inheritDoc}
     */
    @Override
    public Optional<Boolean> getUnhoverWithJavascriptClickInstead() {
        return unhoverWithJavascriptClickInstead;
    }
}
