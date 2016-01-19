package org.brixen.test.bean;

import org.brixen.bean.HoverAndClickControlBean;
import org.brixen.bean.HoverAndClickControlBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@Test(groups = {"LoadableBeanTestGroup"})
public class HoverAndClickControlBeanTest {
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
            "HoverAndClickControlBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class }
    )
    public void shouldThrowExceptionForNullUnhoverElement() {
        final HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        bean.setUnhoverElement(null);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "HoverAndClickControlBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot specify a polling timeout less than 0 seconds"
    )
    public void shouldThrowExceptionForNegativePollingTimeout() {
        HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        bean.setPollingTimeout(-1);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "HoverAndClickControlBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot specify a polling interval less than 0 seconds")
    public void shouldThrowExceptionForNegativePollingInterval() {
        HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        bean.setPollingInterval(-1);
    }

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "HoverAndClickControlBeanEqualityNegativeTestGroup"})
    public void shouldNotBeEqual() {
        HoverAndClickControlBean beanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean beanTwo = new HoverAndClickControlBeanImpl();

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

        beanTwo.setUnhoverWithJavascriptClickInstead(true);
        beanOne.setLoadTimeout(40);

        assertNotEquals(beanOne, beanTwo, "Beans with different load timeouts should not be equal");

        beanOne.setLoadTimeout(30);
        beanTwo.setPollingTimeout(40);

        assertNotEquals(beanOne, beanTwo, "Beans with different polling timeouts should not be equal");

        beanTwo.setPollingTimeout(30);
        beanTwo.setPollingInterval(5);

        assertNotEquals(beanOne, beanTwo, "Beans with different polling intervals should not be equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "HoverAndClickControlBeanEqualityPositiveTestGroup"})
    public void shouldBeEqual() {
        HoverAndClickControlBean beanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean beanTwo = new HoverAndClickControlBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

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

        beanOne.setUnhoverWithJavascriptClickInstead(false);
        beanTwo.setUnhoverWithJavascriptClickInstead(false);
        beanOne.setPollingTimeout(40);
        beanTwo.setPollingTimeout(40);
        beanOne.setPollingInterval(5);
        beanTwo.setPollingInterval(5);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
                "element references and and the same non-default polling timeout and polling interval");

        beanOne = new HoverAndClickControlBeanImpl();
        beanTwo = new HoverAndClickControlBeanImpl();

        beanOne.setHoverWithJavascript(true);
        beanTwo.setHoverWithJavascript(true);
        beanOne.setUnhoverWithJavascript(true);
        beanTwo.setUnhoverWithJavascript(true);
        beanOne.setClickWithJavascriptInsteadOfHover(true);
        beanTwo.setClickWithJavascriptInsteadOfHover(true);
        beanOne.setUnhoverWithClickInstead(true);
        beanTwo.setUnhoverWithClickInstead(true);
        beanOne.setUnhoverWithJavascriptClickInstead(true);
        beanTwo.setUnhoverWithJavascriptClickInstead(true);
        beanOne.setPollingTimeout(40);
        beanTwo.setPollingTimeout(40);
        beanOne.setPollingInterval(5);
        beanTwo.setPollingInterval(5);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container and unhover element " +
                "references, the same non-default JavaScript hover workaround values and the same non-default " +
                "polling timeout and polling interval");
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "HoverAndClickControlBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();

        when(mockContainerElementOne.toString()).thenReturn("Mock Container WebElement");
        bean.setContentContainer(mockContainerElementOne);

        assertTrue(bean.toString().contains("contentContainer=Mock Container WebElement"), "toString() for " +
                "HoverControlAndClickBeanImpl does not include the content container field in ContainerBeanImpl: " +
                bean.toString());
    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "HoverAndClickControlBeanEqualsCallsSuperTestGroup"}, dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean beanToCompare = new HoverAndClickControlBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setClickWithJavascript(true);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their Javascript click workaround fields should not be equal, but are: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setClickWithJavascript(true);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have the same Javascript " +
                "click workaround value should be equal, but are not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "HoverAndClickControlBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        final HoverAndClickControlBean beanToCompare = new HoverAndClickControlBeanImpl();

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
    public void shouldReturnFalseForIsHoverControl() {
        HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        assertFalse(bean.isHoverControl());
    }

    @Test
    public void shouldReturnTrueForIsClickControl() {
        HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        assertTrue(bean.isClickControl());
    }

    @Test
    public void shouldReturnTrueForIsHoverAndClickControl() {
        HoverAndClickControlBean bean = new HoverAndClickControlBeanImpl();
        assertTrue(bean.isHoverAndClickControl());
    }
}
