package org.brixen.bean;

import lombok.*;
import lombok.extern.slf4j.XSlf4j;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnegative;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Specifies all the data necessary to construct a basic <b>Selenium</b> page object.
 */
@XSlf4j
@ToString(includeFieldNames = true)
@EqualsAndHashCode
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public class LoadableBeanImpl implements LoadableBean {

    /** The {@code WebDriver} to use for browsing the page object */
    private @Getter(onMethod=@__(@Override)) @Setter(onMethod=@__(@Override)) @NonNull WebDriver driver;

    /** The load timeout in seconds for the page object */
    private @Getter(onMethod=@__({@Nonnegative, @Override})) @Nonnegative  int loadTimeout =
            Loadable.DEFAULT_LOAD_TIMEOUT;

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException if the specified load timeout is negative
     */
    @Override
    public final void setLoadTimeout(@Nonnegative int timeout) {
        if(timeout < 0) {
            throw log.throwing(new IllegalArgumentException("Cannot specify a load timeout less than 0 seconds"));
        }
        loadTimeout = timeout;
    }
}
