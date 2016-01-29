package org.brixen.test.bean;

import org.brixen.bean.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class ControllableBeanTest {

    @Mock WebDriver mockDriver;
    @Mock WebElement mockElementOne;
    @Mock WebElement mockElementTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with name that is null")
    public void shouldThrowExceptionForOneParamAddClickControlWithNullName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl(null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with name that is null")
    public void shouldThrowExceptionForTwoParamAddClickControlWithNullName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl(null, new ClickControlBeanImpl());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with name that is null")
    public void shouldThrowExceptionForOneParamAddHoverControlWithNullName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl(null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with name that is null")
    public void shouldThrowExceptionForTwoParamAddHoverControlWithNullName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl(null, new HoverControlBeanImpl());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with name that is null")
    public void shouldThrowExceptionForOneParamAddHoverAndClickControlWithNullName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl(null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with name that is null")
    public void shouldThrowExceptionForTwoParamAddHoverAndClickControlWithNullName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl(null, new HoverAndClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForOneParamAddClickControlWithEmptyName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForTwoParamAddClickControlWithEmptyName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("", new ClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForOneParamAddHoverControlWithEmptyName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForTwoParamAddHoverControlWithEmptyName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("", new HoverControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForOneParamAddHoverAndClickControlWithEmptyName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForTwoParamAddHoverAndClickControlWithEmptyName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("", new HoverAndClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForOneParamAddClickControlWithWhitespaceName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("  ");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForTwoParamAddClickControlWithWhitespaceName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("   ", new ClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForOneParamAddHoverControlWithWhitespaceName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("   ");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForTwoParamAddHoverControlWithWhitespaceName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("   ", new HoverControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForOneParamAddHoverAndClickControlWithWhitespaceName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("   ");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class } ,
            expectedExceptionsMessageRegExp = "Cannot add a control with a name that is empty or all whitespace")
    public void shouldThrowExceptionForTwoParamAddHoverAndClickControlWithWhitespaceName() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("   ", new HoverAndClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddClickControlWithNameMatchingExistingClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.addClickControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddClickControlWithNameMatchingExistingClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.addClickControl("name", new ClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddClickControlWithNameMatchingExistingHoverControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.addClickControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddClickControlWithNameMatchingExistingHoverControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.addClickControl("name", new ClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddClickControlWithNameMatchingExistingHoverAndClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name");
        bean.addClickControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddClickControlWithNameMatchingExistingHoverAndClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name");
        bean.addClickControl("name", new ClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddHoverControlWithNameMatchingExistingClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.addHoverControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddHoverControlWithNameMatchingExistingClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.addHoverControl("name", new HoverControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddHoverControlWithNameMatchingExistingHoverControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.addHoverControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddHoverControlWithNameMatchingExistingHoverControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.addHoverControl("name", new HoverControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddHoverControlWithNameMatchingExistingHoverAndClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name");
        bean.addHoverControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddHoverControlWithNameMatchingExistingHoverAndClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name");
        bean.addHoverControl("name", new HoverControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddHoverAndClickControlWithNameMatchingExistingClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.addHoverAndClickControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddHoverAndClickControlWithNameMatchingExistingClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.addHoverAndClickControl("name", new HoverAndClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForOneParamAddHoverAndClickControlWithNameMatchingExistingHoverControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.addHoverAndClickControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void shouldThrowExceptionForTwoParamAddHoverAndClickControlWithNameMatchingExistingHoverControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.addHoverAndClickControl("name", new HoverAndClickControlBeanImpl());
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void
    shouldThrowExceptionForOneParamAddHoverAndClickControlWithNameMatchingExistingHoverAndClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name");
        bean.addHoverAndClickControl("name");
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is already a control named name")
    public void
    shouldThrowExceptionForTwoParamAddHoverAndClickControlWithNameMatchingExistingHoverAndClickControlMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name");
        bean.addHoverAndClickControl("name", new HoverAndClickControlBeanImpl());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a null state bean")
    public void shouldThrowExceptionForTwoParamClickControlWithNullBean() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name", null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a null state bean")
    public void shouldThrowExceptionForTwoParamHoverControlWithNullBean() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name", null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot add a control with a null state bean")
    public void shouldThrowExceptionForTwoParamHoverAndClickControlWithNullBean() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name", null);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup", 
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForAddingDriverToControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setControlDriver("name", mockDriver);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForAddingContentContainerToControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setControlContentContainer("name", mockElementOne);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForAddingPollingTimeoutToControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setControlPollingTimeout("name", 50);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForAddingPollingIntervalToControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setControlPollingInterval("name", 50);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a polleable control")
    public void shouldThrowExceptionForAddingPollingTimeoutToClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setControlPollingTimeout("name", 50);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a polleable control")
    public void shouldThrowExceptionForAddingPollingIntervalToClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setControlPollingInterval("name", 50);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a polleable control")
    public void shouldThrowExceptionForAddingPollingTimeoutToHoverControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.setControlPollingTimeout("name", 50);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a polleable control")
    public void shouldThrowExceptionForAddingPollingIntervalToHoverControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.setControlPollingInterval("name", 50);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForAddingLoadTimeoutToControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setControlLoadTimeout("name", 50);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForAddingUnhoverElementToControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setControlUnhoverElement("name", mockElementOne);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover or a hover and click control")
    public void shouldThrowExceptionForAddingUnhoverElementToClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setControlUnhoverElement("name", mockElementOne);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForSettingHoverWithJavascriptForControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setHoverControlWithJavascript("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover or a hover and click control")
    public void shouldThrowExceptionForSettingHoverWithJavascriptForClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setHoverControlWithJavascript("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForSettingUnhoverWithJavascriptForControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setUnhoverControlWithJavascript("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover or a hover and click control")
    public void shouldThrowExceptionForSettingUnhoverWithJavascriptForClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setUnhoverControlWithJavascript("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForSettingClickWithJavascriptForControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setClickControlWithJavascript("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover or a hover and click control")
    public void shouldThrowExceptionForSettingClickWithJavascriptForHoverControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverControl("name");
        bean.setClickControlWithJavascript("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForSettingClickInsteadOfHoverForControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setClickControlInsteadOfHover("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover control")
    public void shouldThrowExceptionForSettingClickInsteadOfHoverForClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setClickControlInsteadOfHover("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover control")
    public void shouldThrowExceptionForSettingClickInsteadOfHoverForHoverAndClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addHoverAndClickControl("name");
        bean.setClickControlInsteadOfHover("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForSettingClickWithJavascriptInsteadOfHoverForControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setClickControlWithJavascriptInsteadOfHover("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover or a hover and click control")
    public void shouldThrowExceptionForSettingClickWithJavascriptInsteadOfHoverForClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setClickControlWithJavascriptInsteadOfHover("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForSettingUnhoverWithClickInsteadForControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setUnhoverControlWithClickInstead("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
        "ControllableBeanExpectedExceptionsTestGroup"},
        expectedExceptions = { IllegalStateException.class },
        expectedExceptionsMessageRegExp = "The control named name is not a hover or a hover and click control")
    public void shouldThrowExceptionForSettingUnhoverWithClickInsteadForClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setUnhoverControlWithClickInstead("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "There is no control named name")
    public void shouldThrowExceptionForSettingUnhoverWithJavascriptClickInsteadForControlWithNameThatHasNoMapping() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setUnhoverControlWithJavascriptClickInstead("name", true);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ControllableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalStateException.class },
            expectedExceptionsMessageRegExp = "The control named name is not a hover or a hover and click control")
    public void shouldThrowExceptionForSettingUnhoverWithJavascriptClickInsteadForClickControl() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.addClickControl("name");
        bean.setUnhoverControlWithJavascriptClickInstead("name", true);
    }

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "ControllableBeanEqualityNegativeTestGroup"})
    public void shouldNotBeEqual() {
        ControllableBean beanOne = new ControllableBeanImpl();
        ControllableBean beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different container element references should not be equal");

        beanTwo.setContentContainer(mockElementOne);

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementTwo);

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockElementTwo);
        clickControlBeanTwo.setContentContainer(mockElementTwo);
        clickControlBeanOne.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they have the same container element " +
                "reference and different click control bean instance mapped to the same name which have the same " +
                "content container reference but different Javascript click workaround values");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addClickControl("clickControlOne", clickControlBeanOne);
        beanTwo.addClickControl("clickControlTwo", clickControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same click control bean instance mapped to " +
                "different names should not be equal");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockElementTwo);
        hoverControlBeanTwo.setContentContainer(mockElementTwo);
        hoverControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverControl("hoverControl", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControl", hoverControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they have the same container element " +
                "reference and different hover control bean instance mapped to the same name which have the same " +
                "content container reference but different Javascript hover workaround values");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverControl("hoverControlOne", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControlTwo", hoverControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same hover control bean instance mapped to different names " +
                "should not be equal");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();

        hoverAndClickControlBeanOne.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanTwo.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they have the same container element " +
                "reference and different hover and click control bean instance mapped to the same name which have " +
                "the same content container reference but different Javascript hover workaround values");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverAndClickControl("hoverAndClickControlOne", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControlTwo", hoverAndClickControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same hover and click control bean instance mapped " +
                "to different names should not be equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup", 
            "ControllableBeanEqualityPositiveTestGroup"})
    public void shouldBeEqual() {
        ControllableBean beanOne = new ControllableBeanImpl();
        ControllableBean beanTwo = new ControllableBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same default JavaScript click workaround value");

        ClickControlBean mockClickControlBean = mock(ClickControlBean.class);
        beanOne.addClickControl("name", mockClickControlBean);
        beanTwo.addClickControl("name", mockClickControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same click control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockElementTwo);
        clickControlBeanTwo.setContentContainer(mockElementTwo);
        clickControlBeanOne.setClickWithJavascript(true);
        clickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and different click control bean instance mapped to the same name which have the same content " +
                "container reference and the same non-default Javascript click workaround value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element references and " +
                "different click control bean instances mapped to the same name, but which have the same content " +
                "container reference and the same non-default Javascript click workaround value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addClickControl("name", mockClickControlBean);
        beanTwo.addClickControl("name", mockClickControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element references and " +
                "same click control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverControlBean mockHoverControlBean = mock(HoverControlBean.class);
        beanOne.addHoverControl("name", mockHoverControlBean);
        beanTwo.addHoverControl("name", mockHoverControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same hover control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockElementTwo);
        hoverControlBeanTwo.setContentContainer(mockElementTwo);
        hoverControlBeanOne.setClickInsteadOfHover(true);
        hoverControlBeanTwo.setClickInsteadOfHover(true);

        beanOne.addHoverControl("name", hoverControlBeanOne);
        beanTwo.addHoverControl("name", hoverControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element " +
                "reference and different hover control bean instances mapped to the same name which have the same " +
                "content container reference and the same non-default click instead of hover workaround value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverControl("name", mockHoverControlBean);
        beanTwo.addHoverControl("name", mockHoverControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element " +
                "references and same hover control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverAndClickControlBean mockHoverAndClickControlBean = mock(HoverAndClickControlBean.class);
        beanOne.addHoverAndClickControl("name", mockHoverAndClickControlBean);
        beanTwo.addHoverAndClickControl("name", mockHoverAndClickControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same hover and click control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();

        hoverAndClickControlBeanOne.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanTwo.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanOne.setClickWithJavascript(true);
        hoverAndClickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addHoverAndClickControl("name", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("name", hoverAndClickControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and different hover and click control bean instance mapped to the same name which have the same " +
                "content container reference and the same non-default Javascript click instead of hover workaround " +
                "value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverAndClickControl("name", mockHoverAndClickControlBean);
        beanTwo.addHoverAndClickControl("name", mockHoverAndClickControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element references and " +
                "same hover and click control bean instance mapped to the same name");
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "ControllableBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        ControllableBean bean = new ControllableBeanImpl();
        bean.setContentContainer(mockElementOne);
        when(mockElementOne.toString()).thenReturn("Mock Container Element");

        assertTrue(bean.toString().contains("contentContainer=Mock Container Element"), "toString() for " +
                "ControllableBeanImpl does not include the content container field in ContentContainerBeanImpl: " +
                bean.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "ControllableBeanHashCodeCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        ControllableBean bean = new ControllableBeanImpl();
        ControllableBean beanToCompare = new ControllableBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setContentContainer(mockElementOne);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their container element fields should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.setContentContainer(mockElementOne);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have the same container " +
                "element should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "ControllableBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        ControllableBean bean = new ControllableBeanImpl();
        ControllableBean beanToCompare = new ControllableBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setContentContainer(mockElementOne);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setContentContainer(mockElementOne);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup", 
            "ControllableBeanHashCodeEqualityNegativeTestGroup"}
    )
    public void hashCodesShouldNotBeEqual() {

        ControllableBean beanOne = new ControllableBeanImpl();
        ControllableBean beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementTwo);

        assertNotEquals(beanOne.hashCode(), beanTwo.hashCode(), "Beans with different container element references " + 
                "should have different hash codes");

        beanTwo.setContentContainer(mockElementOne);

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockElementTwo);
        clickControlBeanTwo.setContentContainer(mockElementTwo);
        clickControlBeanOne.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertNotEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have difference hash codes if they " +
                "have the same container element reference and different click control bean instance mapped to the " +
                "same name which have the same content container reference but different Javascript click workaround " +
                "values");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addClickControl("clickControlOne", clickControlBeanOne);
        beanTwo.addClickControl("clickControlTwo", clickControlBeanOne);

        assertNotEquals(beanOne.hashCode(), beanTwo.hashCode(), "Beans with the same click control bean instance " +
                "mapped to different names should have different hash codes");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockElementTwo);
        hoverControlBeanTwo.setContentContainer(mockElementTwo);
        hoverControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverControl("hoverControl", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControl", hoverControlBeanTwo);

        assertNotEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have different hash codes if they " +
                "have the same container element reference and different hover control bean instance mapped to the " +
                "same name which have the same content container reference but different Javascript hover workaround " +
                "values");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverControl("hoverControlOne", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControlTwo", hoverControlBeanOne);

        assertNotEquals(beanOne.hashCode(), beanTwo.hashCode(), "Beans with the same hover control bean instance " +
                "mapped to different names should have different hash codes");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();

        hoverAndClickControlBeanOne.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanTwo.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

        assertNotEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have different hash codes if they " +
                "have the same container element reference and different hover and click control bean instance " +
                "mapped to the same name which have the same content container reference but different Javascript " +
                "hover workaround values");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverAndClickControl("hoverAndClickControlOne", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControlTwo", hoverAndClickControlBeanOne);

        assertNotEquals(beanOne.hashCode(), beanTwo.hashCode(), "Beans with the same hover and click control bean " +
                "instance mapped to different names should have different hash codes");
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup", 
            "ControllableBeanHashCodeEqualityPositiveTestGroup"}
    )
    public void hashCodesShouldBeEqual() {
        ControllableBean beanOne = new ControllableBeanImpl();
        ControllableBean beanTwo = new ControllableBeanImpl();

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two newly constructed beans should have " +
                "the same hash code before any setters are invoked");

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "the same container element reference and same default JavaScript click workaround value");

        ClickControlBean mockClickControlBean = mock(ClickControlBean.class);
        beanOne.addClickControl("name", mockClickControlBean);
        beanTwo.addClickControl("name", mockClickControlBean);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "the same container element reference and same click control bean instance mapped to " +
                "the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockElementTwo);
        clickControlBeanTwo.setContentContainer(mockElementTwo);
        clickControlBeanOne.setClickWithJavascript(true);
        clickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "the same container element reference and different click control bean instance mapped to the same " +
                "name which have the same content container reference and the same non-default Javascript click " +
                "workaround value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "null container element references and different click control bean instances mapped to the same " +
                "name, but which have the same content container reference and the same non-default Javascript click " +
                "workaround value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addClickControl("name", mockClickControlBean);
        beanTwo.addClickControl("name", mockClickControlBean);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "null container element references and same click control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverControlBean mockHoverControlBean = mock(HoverControlBean.class);
        beanOne.addHoverControl("name", mockHoverControlBean);
        beanTwo.addHoverControl("name", mockHoverControlBean);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "the same container element reference and same hover control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockElementTwo);
        hoverControlBeanTwo.setContentContainer(mockElementTwo);
        hoverControlBeanOne.setClickInsteadOfHover(true);
        hoverControlBeanTwo.setClickInsteadOfHover(true);

        beanOne.addHoverControl("name", hoverControlBeanOne);
        beanTwo.addHoverControl("name", hoverControlBeanTwo);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "the same container element reference and different hover control bean instances mapped to the same " +
                "name which have the same content container reference and the same non-default click instead of " +
                "hover workaround value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverControl("name", mockHoverControlBean);
        beanTwo.addHoverControl("name", mockHoverControlBean);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "null container element references and same hover control bean instance mapped to the same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverAndClickControlBean mockHoverAndClickControlBean = mock(HoverAndClickControlBean.class);
        beanOne.addHoverAndClickControl("name", mockHoverAndClickControlBean);
        beanTwo.addHoverAndClickControl("name", mockHoverAndClickControlBean);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "the same container element reference and same hover and click control bean instance mapped to the " +
                "same name");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();

        hoverAndClickControlBeanOne.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanTwo.setContentContainer(mockElementTwo);
        hoverAndClickControlBeanOne.setClickWithJavascript(true);
        hoverAndClickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addHoverAndClickControl("name", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("name", hoverAndClickControlBeanTwo);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "the same container element reference and different hover and click control bean instance mapped to " +
                "the same name which have the same content container reference and the same non-default Javascript " +
                "click instead of hover workaround value");

        beanOne = new ControllableBeanImpl();
        beanTwo = new ControllableBeanImpl();

        beanOne.addHoverAndClickControl("name", mockHoverAndClickControlBean);
        beanTwo.addHoverAndClickControl("name", mockHoverAndClickControlBean);

        assertEquals(beanOne.hashCode(), beanTwo.hashCode(), "Two beans should have the same hash code if they have " +
                "null container element references and same hover and click control bean instance mapped to the same " +
                "name");
    }
}
