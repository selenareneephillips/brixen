package org.brixen.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.WebElement;

/**
 * Specifies all the data necessary to construct a <b>Selenium</b> page object that models a component which wraps a
 * {@link org.openqa.selenium.WebElement} content container.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class ContentContainerBeanImpl extends LoadableBeanImpl implements ContentContainerBean {

    /** The {@code WebElement} that contains the content wrapped by the page object */
    private @Getter @Setter WebElement contentContainer;
}
