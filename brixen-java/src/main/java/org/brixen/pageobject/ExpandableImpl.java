package org.brixen.pageobject;

import lombok.AccessLevel;
import lombok.Getter;
import org.brixen.bean.ControlBean;
import org.openqa.selenium.WebElement;
import org.brixen.bean.DynamicControllableBean;

import java.util.Map;

/**
 * Serves as a basic implementation for a <b>Selenium</b> page object which models a dynamic component which can be be
 * expanded and collapsed.
 */
public class ExpandableImpl extends AbstractExpandable<ExpandableImpl> {

    /** The name of the control that expands and collapses this {@code ExpandableImpl} */
    public static final String EXPANDABLE_CONTROL_NAME = "EXPAND";
    private @Getter(AccessLevel.PROTECTED) final Map<String, ControlBean> controlBeans;

    /**
     * The content container for the content which is hidden from view or rendered visible when this
     * {@code ExpandableImpl} is expanded or collapsed.
     */
    private final @Getter(AccessLevel.PROTECTED) WebElement contentContainer;

    /**
     * Constructs an {@code ExpandableImpl} with the state specified by the {@code DynamicControllableBean}.
     *
     * @param bean  a data transfer object for constructing an {@code ExpandableImpl}
     */
    public ExpandableImpl(final DynamicControllableBean bean) {
        super(bean);

        this.contentContainer = bean.getContentContainer();
        this.controlBeans = bean.getControlBeans();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getExpandableControlName() {
        return EXPANDABLE_CONTROL_NAME;
    }

}
