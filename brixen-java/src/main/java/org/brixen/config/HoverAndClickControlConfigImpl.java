package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.brixen.decorator.config.LoadableConfigProvider;
import org.brixen.decorator.config.PolleableConfigDecorator;
import org.brixen.pageobject.HoverAndClickControl;
import org.openqa.selenium.WebElement;

import java.util.Optional;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * {@link HoverAndClickControl}.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class HoverAndClickControlConfigImpl extends ClickableConfigImpl implements HoverAndClickControlConfig,
        PolleableConfigDecorator {

    /**
     * The {@code LoadableConfigProvider} for the internal {@code PolleableConfig} implementation to which this
     * {@code class} delegates all invocations of the methods specified in {@code PolleableConfig}.
     */
    private final @Getter LoadableConfigProvider<? extends PolleableConfig> polleableConfigProvider =
            new LoadableConfigProvider<>((new PolleableConfigImpl()));

    /**
     * The Javascript hover workaround flag specified in the JSON configuration source for a 
     * {@code HoverAndClickControl}. If the value is an {@code Optional} that equal to {@link Optional#empty()} and 
     * which returns {@code false} for {@link Optional#isPresent()}, the JSON configuration source for the 
     * {@code HoverAndClickControl} in question explicitly defined a {@code null} value for the flag. If the specified 
     * value is {@code null} the JSON configuration source did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> hoverWithJavascript;

    /**
     * The Javascript hover workaround flag for the unhover element which is used to focus the mouse in a safe location
     * away from the web control specified in the JSON configuration source for a {@code HoverAndClickControl}. If the 
     * value is an {@code Optional} that equal to {@link Optional#empty()} and which returns {@code false} for
     * {@link Optional#isPresent()}, the JSON configuration source for the {@code HoverAndClickControl} in question 
     * explicitly defined a {@code null} value for the flag. If the specified value is {@code null} the JSON 
     * configuration source did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> unhoverWithJavascript;

    /**
     * The Javascript click action workaround flag for clicking the web control with Javascript instead of trying to
     * execute a mouseover on it first to make it visible as specified in the JSON configuration source for a
     * {@code HoverAndClickControl}. If the value is an {@code Optional} that equal to {@link Optional#empty()} and
     * which returns {@code false} for {@link Optional#isPresent()}, the JSON configuration source for the
     * {@code HoverAndClickControl} in question explicitly defined a {@code null} value for the flag. If the specified
     * value is {@code null} the JSON configuration source did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> clickWithJavascriptInsteadOfHover;

    /**
     * The {@link WebElement#click} action workaround flag for the unhover element which is used to focus the mouse in
     * a safe location away from the web control as specified in the JSON configuration source for a
     * {@code HoverAndClickControl}. If the value is an {@code Optional} that equal to {@link Optional#empty()} and
     * which returns {@code false} for {@link Optional#isPresent()}, the JSON configuration source for the
     * {@code HoverAndClickControl} in question explicitly defined a {@code null} value for the flag. If the specified
     * value is {@code null} the JSON configuration source did not define any value at all for the flag.
     */
    private @Setter Optional<Boolean> unhoverWithClickInstead;

    /**
     * The Javascript click action workaround flag for the unhover element which is used to focus the mouse in a safe
     * location away from the web control as specified in the JSON configuration source for a
     * {@code HoverAndClickControl}. If the value is an {@code Optional} that equal to {@link Optional#empty()} and
     * which returns {@code false} for {@link Optional#isPresent()}, the JSON configuration source for the
     * {@code HoverAndClickControl} in question explicitly defined a {@code null} value for the flag. If the specified
     * value is {@code null} the JSON configuration source did not define any value at all for the flag.
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
