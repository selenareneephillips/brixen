package org.brixen.test.bean;

import org.brixen.bean.MenuBean;
import org.brixen.bean.MenuBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class MenuBeanTest {
    private @Mock WebElement mockContainerElementOne;
    private @Mock WebElement mockContainerElementTwo;
    private @Mock WebElement mockOptionElementOne;
    private @Mock WebElement mockOptionElementTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "MenuBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class }
    )
    public void shouldThrowExceptionForNullContainerElement() {
        final MenuBean bean = new MenuBeanImpl();
        bean.setContentContainer(null);
    }

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup", "MenuBeanEqualityNegativeTestGroup"})
    public void shouldNotBeEqual() {
        MenuBean beanOne = new MenuBeanImpl();
        MenuBean beanTwo = new MenuBeanImpl();

        beanOne.setContentContainer(mockContainerElementOne);
        beanTwo.setContentContainer(mockContainerElementTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different container element references should not be equal");

        beanTwo.setContentContainer(mockContainerElementOne);

        List<WebElement> optionsListOne = new ArrayList<>();
        List<WebElement> optionsListTwo = new ArrayList<>();

        optionsListOne.add(mockOptionElementOne);
        optionsListTwo.add(mockOptionElementTwo);
        beanOne.setOptionElements(optionsListOne);
        beanTwo.setOptionElements(optionsListTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different lists of option elements should not be equal");

        beanTwo.setOptionElements(optionsListOne);
        beanOne.setClickOptionWithJavascript(true);

        assertNotEquals(beanOne, beanTwo, "Beans with different Javascript click workaround values should not be " +
                "equal");
    }

    @Test(groups = { "EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup", "MenuBeanEqualityPositiveTestGroup"})
    public void shouldBeEqual() {
        MenuBean beanOne = new MenuBeanImpl();
        MenuBean beanTwo = new MenuBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setContentContainer(mockContainerElementOne);
        beanTwo.setContentContainer(mockContainerElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same default JavaScript click workaround value");

        beanOne.setClickOptionWithJavascript(true);
        beanTwo.setClickOptionWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same non-default JavaScript click workaround value");

        beanOne = new MenuBeanImpl();
        beanTwo = new MenuBeanImpl();

        beanOne.setClickOptionWithJavascript(true);
        beanTwo.setClickOptionWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element references " +
                "and same non-default JavaScript click workaround value");

        beanOne.setContentContainer(mockContainerElementOne);
        beanTwo.setContentContainer(mockContainerElementOne);

        List<WebElement> optionsListOne = new ArrayList<>();
        List<WebElement> optionsListTwo = new ArrayList<>();

        beanOne.setOptionElements(optionsListOne);
        beanTwo.setOptionElements(optionsListOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element references " +
                "and the same empty option elements list reference");

        optionsListOne.add(mockOptionElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element references " +
                "and the same non-empty option elements list reference");

        optionsListTwo.add(mockOptionElementOne);
        beanTwo.setOptionElements(optionsListTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element references " +
                "and two non-empty option elements list references containing the same object");

        optionsListOne = new ArrayList<>();
        optionsListTwo = new ArrayList<>();

        beanOne.setOptionElements(optionsListOne);
        beanTwo.setOptionElements(optionsListTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element two " +
                "different empty option element list references");

        beanOne = new MenuBeanImpl();
        beanTwo = new MenuBeanImpl();

        beanOne.setOptionElements(optionsListOne);
        beanTwo.setOptionElements(optionsListTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they both have null container element " +
                "references and two different empty option element list references");

        beanTwo.setOptionElements(optionsListOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they both have null container element " +
                "references and the same empty option elements list reference");

        beanTwo.setOptionElements(optionsListTwo);
        optionsListOne.add(mockOptionElementOne);
        optionsListTwo.add(mockOptionElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they both have null container element " +
                "references and two non-empty option elements list references containing the same object");
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "MenuBeanHashCodeCallsSuperTestGroup"}, dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        final MenuBean bean = new MenuBeanImpl();
        final MenuBean beanToCompare = new MenuBeanImpl();

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

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup", "MenuBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        final MenuBean bean = new MenuBeanImpl();
        final MenuBean beanToCompare = new MenuBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setContentContainer(mockContainerElementOne);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setContentContainer(mockContainerElementOne);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "MenuBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        MenuBean bean = new MenuBeanImpl();

        when(mockContainerElementOne.toString()).thenReturn("Mock Container WebElement");
        bean.setContentContainer(mockContainerElementOne);

        assertTrue(bean.toString().contains("contentContainer=Mock Container WebElement"), "toString() for " +
                "MenuBeanImpl does not include the content container field in ContainerBeanImpl: " +
                bean.toString());
    }
}
