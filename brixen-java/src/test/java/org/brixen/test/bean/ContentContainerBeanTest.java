package org.brixen.test.bean;

import org.brixen.bean.ContentContainerBean;
import org.brixen.bean.ContentContainerBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class ContentContainerBeanTest {
    private @Mock WebDriver mockDriver;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "ContentContainerBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class }
    )
    public void shouldThrowExceptionForNullContainerElement() {
        final ContentContainerBean bean = new ContentContainerBeanImpl();
        bean.setContentContainer(null);
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "ContentContainerBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        final ContentContainerBean bean = new ContentContainerBeanImpl();

        when(mockDriver.toString()).thenReturn("Mock WebDriver");
        bean.setDriver(mockDriver);
        bean.setLoadTimeout(100);

        assertTrue(bean.toString().contains("driver=Mock WebDriver"), "toString() for ContentContainerBeanImpl does " +
                "not include the driver field in LoadableBeanImpl: " + bean.toString());
        assertTrue(bean.toString().contains("loadTimeout=100"), "toString() for ContentContainerBeanImpl does " +
                "not include the loadTimeoutInSeconds field in LoadableBeanImpl: " + bean.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "ContentContainerBeanHashCodeCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final ContentContainerBean bean = new ContentContainerBeanImpl();
        final ContentContainerBean beanToCompare = new ContentContainerBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setDriver(mockDriver);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their driver fields should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.setDriver(mockDriver);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have the same driver " +
                "should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        beanToCompare.setLoadTimeout(200);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their load timeout fields should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setLoadTimeout(200);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have the same driver and " +
                "load timeout should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());
    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "ContentContainerBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final ContentContainerBean bean = new ContentContainerBeanImpl();
        final ContentContainerBean beanToCompare = new ContentContainerBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setDriver(mockDriver);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setDriver(mockDriver);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setLoadTimeout(100);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setLoadTimeout(100);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }
}
