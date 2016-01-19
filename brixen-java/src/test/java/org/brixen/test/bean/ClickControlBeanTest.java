package org.brixen.test.bean;

import org.brixen.bean.ClickControlBean;
import org.brixen.bean.ClickControlBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class ClickControlBeanTest {

    private @Mock WebElement mockElementOne;
    private @Mock WebElement mockElementTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "ClickControlBeanEqualityNegativeTestGroup"})
    public void shouldNotBeEqual() {
        ClickControlBean beanOne = new ClickControlBeanImpl();
        ClickControlBean beanTwo = new ClickControlBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different container element references should not be equal");

        beanTwo.setContentContainer(mockElementOne);
        beanOne.setClickWithJavascript(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different JavaScript click workaround values should not be " +
                "equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "ClickControlBeanEqualityPositiveTestGroup"}
    )
    public void shouldBeEqual() {
        ClickControlBean beanOne = new ClickControlBeanImpl();
        ClickControlBean beanTwo = new ClickControlBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same default JavaScript click workaround value");

        beanOne.setClickWithJavascript(true);
        beanTwo.setClickWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same non-default JavaScript click workaround value");

        beanOne = new ClickControlBeanImpl();
        beanTwo = new ClickControlBeanImpl();

        beanOne.setClickWithJavascript(true);
        beanTwo.setClickWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element references and " +
                "same non-default JavaScript click workaround value");
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "ClickControlBeanHashCodeCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final ClickControlBean bean = new ClickControlBeanImpl();
        final ClickControlBean beanToCompare = new ClickControlBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setContentContainer(mockElementOne);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different values " +
                "for their content container fields should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.setContentContainer(mockElementOne);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have the same content " +
                "container should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());
    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "ClickControlBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final ClickControlBean bean = new ClickControlBeanImpl();
        final ClickControlBean beanToCompare = new ClickControlBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setContentContainer(mockElementOne);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setContentContainer(mockElementOne);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "ClickControlBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        ClickControlBean bean = new ClickControlBeanImpl();

        when(mockElementOne.toString()).thenReturn("Mock Container WebElement");
        bean.setContentContainer(mockElementOne);

        assertTrue(bean.toString().contains("contentContainer=Mock Container WebElement"), "toString() for " +
                "ClickControlBeanImpl does not include the content container field in ContainerBeanImpl: " +
                bean.toString());
    }

    @Test
    public void shouldReturnFalseForIsHoverControl() {
        ClickControlBean bean = new ClickControlBeanImpl();
        assertFalse(bean.isHoverControl());
    }

    @Test
    public void shouldReturnTrueForIsClickControl() {
        ClickControlBean bean = new ClickControlBeanImpl();
        assertTrue(bean.isClickControl());
    }

    @Test
    public void shouldReturnFalseForIsHoverAndClickControl() {
        ClickControlBean bean = new ClickControlBeanImpl();
        assertFalse(bean.isHoverAndClickControl());
    }
}
