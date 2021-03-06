package org.brixen.test.bean;

import org.brixen.bean.ClickableBean;
import org.brixen.bean.ClickableBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class ClickableBeanTest {
    private @Mock WebElement mockElementOne;
    private @Mock WebElement mockElementTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "ClickableBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        final ClickableBean bean = new ClickableBeanImpl();

        when(mockElementOne.toString()).thenReturn("Mock Container WebElement");
        bean.setContentContainer(mockElementOne);

        assertTrue(bean.toString().contains("contentContainer=Mock Container WebElement"), "toString() for " +
                "ClickableBeanImpl does not include the content container field in ContainerBeanImpl: " +
                bean.toString());
    }

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "ClickableBeanEqualityNegativeTestGroup"}
    )
    public void shouldNotBeEqual() {
        ClickableBean beanOne = new ClickableBeanImpl();
        ClickableBean beanTwo = new ClickableBeanImpl();

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different container element references should not be equal");

        beanTwo.setContentContainer(mockElementOne);
        beanOne.setClickWithJavascript(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different JavaScript click workaround values should not be " +
                "equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "ClickableBeanEqualityPositiveTestGroup"}
    )
    public void shouldBeEqual() {
        ClickableBean beanOne = new ClickableBeanImpl();
        ClickableBean beanTwo = new ClickableBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setContentContainer(mockElementOne);
        beanTwo.setContentContainer(mockElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same default JavaScript click workaround value");

        beanOne.setClickWithJavascript(true);
        beanTwo.setClickWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same non-default JavaScript click workaround value");

        beanOne = new ClickableBeanImpl();
        beanTwo = new ClickableBeanImpl();

        beanOne.setClickWithJavascript(true);
        beanTwo.setClickWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element references and " +
                "same non-default JavaScript click workaround value");
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "ClickableBeanHashCodeCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final ClickableBean bean = new ClickableBeanImpl();
        final ClickableBean beanToCompare = new ClickableBeanImpl();

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
            "ClickableBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final ClickableBean bean = new ClickableBeanImpl();
        final ClickableBean beanToCompare = new ClickableBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setContentContainer(mockElementOne);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setContentContainer(mockElementOne);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }
}
