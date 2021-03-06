package org.brixen.test.bean;

import org.brixen.bean.HoverControlBean;
import org.brixen.bean.HoverControlBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class HoverControlBeanTest {
    private @Mock WebElement mockContainerElementOne;
    private @Mock WebElement mockContainerElementTwo;
    private @Mock WebElement mockUnhoverElementOne;
    private @Mock WebElement mockUnhoverElementTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "HoverControlBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class }
    )
    public void shouldThrowExceptionForNullUnhoverElement() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        bean.setUnhoverElement(null);
    }

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "HoverControlBeanEqualityNegativeTestGroup"})
    public void shouldNotBeEqual() {
        HoverControlBean beanOne = new HoverControlBeanImpl();
        HoverControlBean beanTwo = new HoverControlBeanImpl();

        beanOne.setContentContainer(mockContainerElementOne);
        beanTwo.setContentContainer(mockContainerElementTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different container element references should not be equal");

        beanTwo.setContentContainer(mockContainerElementOne);
        beanOne.setUnhoverElement(mockUnhoverElementOne);

        assertNotEquals(beanOne, beanTwo, "Beans with different unhover element references should not be equal");

        beanTwo.setUnhoverElement(mockUnhoverElementTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different unhover element references should not be equal");

        beanTwo.setUnhoverElement(mockUnhoverElementOne);
        beanOne.setHoverWithJavascript(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different JavaScript hover workaround values should not be " +
                "equal");

        beanTwo.setHoverWithJavascript(true);
        beanOne.setUnhoverWithJavascript(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different JavaScript unhover workaround values should not be " +
                "equal");

        beanTwo.setUnhoverWithJavascript(true);
        beanOne.setClickInsteadOfHover(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different click action hover workaround values should not be " +
                "equal");

        beanTwo.setClickInsteadOfHover(true);
        beanOne.setClickWithJavascriptInsteadOfHover(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different JavaScript click action hover workaround values " +
                "should not be equal");

        beanTwo.setClickWithJavascriptInsteadOfHover(true);
        beanOne.setUnhoverWithClickInstead(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different click action unhover workaround values should not be " +
                "equal");

        beanTwo.setUnhoverWithClickInstead(true);
        beanOne.setUnhoverWithJavascriptClickInstead(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different JavaScript click action unhover workaround values " +
                "should not be equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "HoverControlBeanEqualityPositiveTestGroup"}
    )
    public void shouldBeEqual() {
        HoverControlBean beanOne = new HoverControlBeanImpl();
        HoverControlBean beanTwo = new HoverControlBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setContentContainer(mockContainerElementOne);
        beanTwo.setContentContainer(mockContainerElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same default JavaScript click workaround value");

        beanOne.setUnhoverElement(mockUnhoverElementOne);
        beanTwo.setUnhoverElement(mockUnhoverElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same default workaround values");

        beanOne.setHoverWithJavascript(true);
        beanTwo.setHoverWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same non-default JavaScript hover workaround value");

        beanOne.setHoverWithJavascript(false);
        beanTwo.setHoverWithJavascript(false);
        beanOne.setUnhoverWithJavascript(true);
        beanTwo.setUnhoverWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same non-default JavaScript unhover workaround value");

        beanOne.setUnhoverWithJavascript(false);
        beanTwo.setUnhoverWithJavascript(false);
        beanOne.setClickInsteadOfHover(true);
        beanTwo.setClickInsteadOfHover(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same non-default click action hover workaround value");

        beanOne.setClickInsteadOfHover(false);
        beanTwo.setClickInsteadOfHover(false);
        beanOne.setClickWithJavascriptInsteadOfHover(true);
        beanTwo.setClickWithJavascriptInsteadOfHover(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same non-default JavaScript click action hover workaround value");

        beanOne.setClickWithJavascriptInsteadOfHover(false);
        beanTwo.setClickWithJavascriptInsteadOfHover(false);
        beanOne.setUnhoverWithJavascript(true);
        beanTwo.setUnhoverWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same non-default click action unhover workaround value");

        beanOne.setUnhoverWithJavascript(false);
        beanTwo.setUnhoverWithJavascript(false);
        beanOne.setUnhoverWithClickInstead(true);
        beanTwo.setUnhoverWithClickInstead(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same non-default click action unhover workaround value");

        beanOne.setUnhoverWithClickInstead(false);
        beanTwo.setUnhoverWithClickInstead(false);
        beanOne.setUnhoverWithJavascriptClickInstead(true);
        beanTwo.setUnhoverWithJavascriptClickInstead(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and same non-default JavaScript click action unhover workaround value");

        beanOne = new HoverControlBeanImpl();
        beanTwo = new HoverControlBeanImpl();

        beanOne.setHoverWithJavascript(true);
        beanTwo.setHoverWithJavascript(true);
        beanOne.setUnhoverWithJavascript(true);
        beanTwo.setUnhoverWithJavascript(true);
        beanOne.setClickInsteadOfHover(true);
        beanTwo.setClickInsteadOfHover(true);
        beanOne.setClickWithJavascriptInsteadOfHover(true);
        beanTwo.setClickWithJavascriptInsteadOfHover(true);
        beanOne.setUnhoverWithClickInstead(true);
        beanTwo.setUnhoverWithClickInstead(true);
        beanOne.setUnhoverWithJavascriptClickInstead(true);
        beanTwo.setUnhoverWithJavascriptClickInstead(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container and unhover " +
                 "element references and same non-default JavaScript hover workaround values");
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "HoverControlBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        final HoverControlBean bean = new HoverControlBeanImpl();

        when(mockContainerElementOne.toString()).thenReturn("Mock Container WebElement");
        bean.setContentContainer(mockContainerElementOne);

        assertTrue(bean.toString().contains("contentContainer=Mock Container WebElement"), "toString() for " +
                "HoverControlBeanImpl does not include the content container field in ContainerBeanImpl: " +
                bean.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "HoverControlBeanHashCodeCallsSuperTestGroup"}, dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        final HoverControlBean beanToCompare = new HoverControlBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setContentContainer(mockContainerElementOne);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their content container fields should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.setContentContainer(mockContainerElementOne);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have the same content " +
                "container should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());
    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "HoverControlBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        final HoverControlBean beanToCompare = new HoverControlBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setContentContainer(mockContainerElementOne);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setContentContainer(mockContainerElementOne);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }

    @Test
    public void shouldReturnTrueForIsHoverControl() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        Assert.assertTrue(bean.isHoverControl());
    }

    @Test
    public void shouldReturnFalseForIsClickControl() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        Assert.assertFalse(bean.isClickControl());
    }

    @Test
    public void shouldReturnFalseForIsHoverAndClickControl() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        Assert.assertFalse(bean.isHoverAndClickControl());
    }
}
