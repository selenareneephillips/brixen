package org.brixen.test.bean;

import org.brixen.bean.PolleableBean;
import org.brixen.bean.PolleableBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"PolleableBeanTestGroup"})
public class PolleableBeanTest {

    private @Mock WebDriver mockDriver;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(groups = {
            "ExpectedExceptionsTestGroup",
            "PolleableBeanExpectedExceptionsTestGroup"
    },
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot specify a polling timeout less than 0 seconds"
    )
    public void shouldThrowExceptionForCallingSetterWithNegativePollingTimeout() {
        final PolleableBean bean = new PolleableBeanImpl();
        bean.setPollingTimeout(-1);
    }

    @Test(groups = {
            "ExpectedExceptionsTestGroup",
            "PolleableBeanExpectedExceptionsTestGroup"
    },
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot specify a polling interval less than 0 seconds"
    )
    public void shouldThrowExceptionForCallingSetterWithNegativePollingInterval() {
        final PolleableBean bean = new PolleableBeanImpl();
        bean.setPollingInterval(-1);
    }

    //This method depends on ElementWrapperBeanImpl shouldCallSuperForToString
    @Test(groups = {
            "ToStringCallsSuperTestGroup",
            "BeanToStringCallsSuperTestGroup",
            "PolleableBeanToStringCallsSuperTestGroup"
    }
    )
    public void shouldCallSuperForToString() {
        final PolleableBean bean = new PolleableBeanImpl();

        when(mockDriver.toString()).thenReturn("Mock WebDriver");
        bean.setDriver(mockDriver);
        bean.setLoadTimeout(100);

        assertTrue(bean.toString().contains("driver=Mock WebDriver"), "toString() for PolleableBeanImpl does " +
                "not include the driver field in LoadableBeanImpl: " + bean.toString());
        assertTrue(bean.toString().contains("loadTimeout=100"), "toString() for PolleableBeanImpl does " +
                "not include the loadTimeoutInSeconds field in LoadableBeanImpl: " + bean.toString());
    }

    //This method depends on ElementWrapperBeanHasCodeCallsSuper
    @Test(groups = {
            "HashCodeCallsSuperTestGroup",
            "BeanHashCodeCallsSuperTestGroup",
            "PolleableBeanHashCodeCallsSuperTestGroup"
    },
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final PolleableBean bean = new PolleableBeanImpl();
        final PolleableBean beanToCompare = new PolleableBeanImpl();

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

    //This method depends on ElementWrapperEqualsCallsSuperTestGroup
    @Test(groups = {
            "EqualsCallsSuperTestGroup",
            "BeanEqualsCallsSuperTestGroup",
            "PolleableBeanEqualsCallsSuperTestGroup"
    },
            dependsOnMethods = {
                    "shouldCallSuperForToString",
                    "shouldCallSuperForHashCode"
            }
    )
    public void shouldCallSuperForEquals() {
        final PolleableBean bean = new PolleableBeanImpl();
        final PolleableBean beanToCompare = new PolleableBeanImpl();

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
