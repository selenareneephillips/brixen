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

public class HoverControlBeanTest {
    private @Mock WebElement mockContainerElement;
    private @Mock WebElement mockUnhoverElement;

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

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "HoverControlBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        final HoverControlBean bean = new HoverControlBeanImpl();

        when(mockContainerElement.toString()).thenReturn("Mock Container WebElement");
        bean.setContentContainer(mockContainerElement);

        assertTrue(bean.toString().contains("contentContainer=Mock Container WebElement"), "toString() for " +
                "HoverControlBeanImpl does not include the content container field in ContainerBeanImpl: " +
                bean.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "HoverControlBeanHashCodeCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        final HoverControlBean beanToCompare = new HoverControlBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setContentContainer(mockContainerElement);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their content container fields should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.setContentContainer(mockContainerElement);
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

        bean.setContentContainer(mockContainerElement);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setContentContainer(mockContainerElement);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }

    @Test(groups = "HoverControlBeanEqualsCallsSuperTestGroup")
    public void shouldReturnTrueForIsHoverControl() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        Assert.assertTrue(bean.isHoverControl());
    }

    @Test(groups = "HoverControlBeanEqualsCallsSuperTestGroup")
    public void shouldReturnFalseForIsClickControl() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        Assert.assertFalse(bean.isClickControl());
    }

    @Test(groups = "HoverControlBeanEqualsCallsSuperTestGroup")
    public void shouldReturnFalseForIsHoverAndClickControl() {
        final HoverControlBean bean = new HoverControlBeanImpl();
        Assert.assertFalse(bean.isHoverAndClickControl());
    }
}
