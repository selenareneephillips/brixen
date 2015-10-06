package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebDriver;

/**
 * Specifies all the data necessary to construct a basic <b>Selenium</b> page object.
 */
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class LoadableBeanImpl implements LoadableBean {

    /** The {@code WebDriver} to use for browsing the page object */
    private @Getter @Setter WebDriver driver;

    /** The load timeout in seconds for the page object */
    private @Getter @Setter int loadTimeout = Loadable.DEFAULT_LOAD_TIMEOUT;
}
