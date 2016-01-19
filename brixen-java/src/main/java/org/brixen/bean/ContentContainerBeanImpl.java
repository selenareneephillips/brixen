package org.brixen.bean;

import lombok.*;
import org.openqa.selenium.WebElement;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a component which wraps a
 * {@link org.openqa.selenium.WebElement} content container.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("UnusedDeclaration")
@ParametersAreNonnullByDefault
public class ContentContainerBeanImpl extends LoadableBeanImpl implements ContentContainerBean {

    /** The {@code WebElement} that contains the content wrapped by the page object */
    private @Getter(onMethod=@__(@Override)) @Setter(onMethod=@__(@Override)) @NonNull WebElement contentContainer;
}
