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

@Test(groups = {"LoadableBeanTestGroup"})
public class PolleableBeanTest {

    private @Mock WebDriver mockDriverOne;
    private @Mock WebDriver mockDriverTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "PolleableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot specify a polling timeout less than 0 seconds"
    )
    public void shouldThrowExceptionForNegativePollingTimeout() {
        final PolleableBean bean = new PolleableBeanImpl();
        bean.setPollingTimeout(-1);
    }

    @Test(groups = {"ExpectedExceptionsTestGroup", "PolleableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot specify a polling interval less than 0 seconds"
    )
    public void shouldThrowExceptionForNegativePollingInterval() {
        final PolleableBean bean = new PolleableBeanImpl();
        bean.setPollingInterval(-1);
    }

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "PolleableBeanEqualityNegativeTestGroup"}
    )
    public void shouldNotBeEqual() {
        PolleableBean beanOne = new PolleableBeanImpl();
        PolleableBean beanTwo = new PolleableBeanImpl();

        beanOne.setDriver(mockDriverOne);
        beanTwo.setDriver(mockDriverTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different driver references should not be equal");

        beanOne = new PolleableBeanImpl();
        beanTwo = new PolleableBeanImpl();
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
            "PolleableBeanEqualityPositiveTestGroup"}
    )
    public void shouldBeEqual() {
        PolleableBean beanOne = new PolleableBeanImpl();
        PolleableBean beanTwo = new PolleableBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setDriver(mockDriverOne);
        beanTwo.setDriver(mockDriverOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference and the " +
                "default load timeout");

        beanOne.setPollingTimeout(40);
        beanTwo.setPollingTimeout(40);
        beanOne.setPollingInterval(5);
        beanTwo.setPollingInterval(5);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference and the " +
                "same non-default polling timeout and polling interval");

        beanOne = new PolleableBeanImpl();
        beanTwo = new PolleableBeanImpl();

        beanOne.setPollingTimeout(40);
        beanTwo.setPollingTimeout(40);
        beanOne.setPollingInterval(5);
        beanTwo.setPollingInterval(5);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null web driver reference and the " +
                "same non-default polling timeout and polling interval");
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "PolleableBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        final PolleableBean bean = new PolleableBeanImpl();

        when(mockDriverOne.toString()).thenReturn("Mock WebDriver");
        bean.setDriver(mockDriverOne);
        bean.setLoadTimeout(100);

        assertTrue(bean.toString().contains("driver=Mock WebDriver"), "toString() for PolleableBeanImpl does " +
                "not include the driver field in LoadableBeanImpl: " + bean.toString());
        assertTrue(bean.toString().contains("loadTimeout=100"), "toString() for PolleableBeanImpl does " +
                "not include the loadTimeoutInSeconds field in LoadableBeanImpl: " + bean.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "PolleableBeanHashCodeCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final PolleableBean bean = new PolleableBeanImpl();
        final PolleableBean beanToCompare = new PolleableBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setDriver(mockDriverOne);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their driver fields should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.setDriver(mockDriverOne);
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
            "PolleableBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final PolleableBean bean = new PolleableBeanImpl();
        final PolleableBean beanToCompare = new PolleableBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setDriver(mockDriverOne);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setDriver(mockDriverOne);
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
