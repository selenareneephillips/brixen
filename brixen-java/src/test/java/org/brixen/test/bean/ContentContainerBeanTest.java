package org.brixen.test.bean;

import org.brixen.bean.ContentContainerBean;
import org.brixen.bean.ContentContainerBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class ContentContainerBeanTest {
    private @Mock WebDriver mockDriverOne;
    private @Mock WebDriver mockDriverTwo;

    private @Mock WebElement mockElementOne;
    private @Mock WebElement mockElementTwo;

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

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "ContentContainerBeanEqualityNegativeTestGroup"}
    )
    public void shouldNotBeEqual() {
        ContentContainerBean beanOne = new ContentContainerBeanImpl();
        ContentContainerBean  beanTwo = new ContentContainerBeanImpl();

        beanOne.setDriver(mockDriverOne);
        beanTwo.setDriver(mockDriverTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different driver references should not be equal");

        beanOne = new ContentContainerBeanImpl();
        beanTwo = new ContentContainerBeanImpl();
        beanOne.setLoadTimeout(40);

        assertNotEquals(beanOne, beanTwo, "Beans with different load timeouts should not be equal");

        beanOne.setLoadTimeout(30);
        beanOne.setContentContainer(mockElementOne);

        assertNotEquals(beanOne, beanTwo, "Beans with different content container element values should not be equal");

        beanTwo.setContentContainer(mockElementTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different content container element values should not be equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "ContentContainerBeanEqualityPositiveTestGroup"}
    )
    public void shouldBeEqual() {
        ContentContainerBean beanOne = new ContentContainerBeanImpl();
        ContentContainerBean beanTwo = new ContentContainerBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setDriver(mockDriverOne);
        beanTwo.setDriver(mockDriverOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference and the " +
                "default load timeout");

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same web driver and content " +
                "container references");

        beanOne = new ContentContainerBeanImpl();
        beanTwo = new ContentContainerBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null web driver references and the " +
                "same content container reference");
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "ContentContainerBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        final ContentContainerBean bean = new ContentContainerBeanImpl();

        when(mockDriverOne.toString()).thenReturn("Mock WebDriver");
        bean.setDriver(mockDriverOne);
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
            "ContentContainerBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final ContentContainerBean bean = new ContentContainerBeanImpl();
        final ContentContainerBean beanToCompare = new ContentContainerBeanImpl();

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
