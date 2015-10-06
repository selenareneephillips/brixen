package org.brixen.pageobject;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.bean.ClickControlBean;
import org.openqa.selenium.WebElement;

/**
 * Serves as a basic implementation for a <b>Selenium</b> page object that models a web control that has meaningful
 * side effects whenever it is clicked.
 */
public class ClickControlImpl extends AbstractClickable<ClickControlImpl> implements ClickControl {

    /** The {@code WebElement} that contains the web control */
    private final @Getter(AccessLevel.PROTECTED) WebElement contentContainer;

    /**
     * Constructs an {@code ClickControlImpl} with the state specified by the {@code ClickControlBean}.
     *
     * @param bean  a data transfer object for constructing an {@code ClickControlImpl}
     */
    public ClickControlImpl(ClickControlBean bean) {
        super(bean);
        this.contentContainer = bean.getContentContainer();
    }
}
