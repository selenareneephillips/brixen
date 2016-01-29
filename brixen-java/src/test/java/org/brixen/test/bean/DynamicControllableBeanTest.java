package org.brixen.test.bean;

import org.brixen.bean.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class DynamicControllableBeanTest {

    @Mock WebDriver mockDriver;
    @Mock WebElement mockElementOne;
    @Mock WebElement mockElementTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup", 
            "DynamicControllableBeanEqualityNegativeTestGroup"})
    public void shouldNotBeEqual() {

        DynamicControllableBean beanOne = new DynamicControllableBeanImpl();
        DynamicControllableBean beanTwo = new DynamicControllableBeanImpl();

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockElementOne);
        clickControlBeanTwo.setContentContainer(mockElementOne);
        clickControlBeanOne.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they different click control bean " +
                "instance mapped to the same name which have the same content container reference but different " +
                "Javascript click workaround values");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        beanOne.addClickControl("clickControlOne", clickControlBeanOne);
        beanTwo.addClickControl("clickControlTwo", clickControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same click control bean instance mapped to different names " +
                "should not be equal");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockElementOne);
        hoverControlBeanTwo.setContentContainer(mockElementOne);
        hoverControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverControl("hoverControl", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControl", hoverControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they have different hover control bean " +
                "instance mapped to the same name which have the same content container reference but different " +
                "Javascript hover workaround values");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        beanOne.addHoverControl("hoverControlOne", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControlTwo", hoverControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same hover control bean instance mapped to different names " +
                "should not be equal");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();

        hoverAndClickControlBeanOne.setContentContainer(mockElementOne);
        hoverAndClickControlBeanTwo.setContentContainer(mockElementOne);
        hoverAndClickControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they have different hover and " +
                "click control bean instance mapped to the same name which have the same content container reference " +
                "but different Javascript hover workaround values");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        beanOne.addHoverAndClickControl("hoverAndClickControlOne", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControlTwo", hoverAndClickControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same hover and click control bean instance mapped " +
                "to different names should not be equal");

        beanTwo.setPollingTimeout(40);

        assertNotEquals(beanOne, beanTwo, "Beans with different polling timeouts should not be equal");

        beanTwo.setPollingTimeout(30);
        beanTwo.setPollingInterval(5);

        assertNotEquals(beanOne, beanTwo, "Beans with different polling intervals should not be equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "DynamicControllableBeanEqualityPositiveTestGroup"})
    public void shouldBeEqual() {
        DynamicControllableBean beanOne = new DynamicControllableBeanImpl();
        DynamicControllableBean beanTwo = new DynamicControllableBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        ClickControlBean mockClickControlBean = mock(ClickControlBean.class);
        beanOne.addClickControl("name", mockClickControlBean);
        beanTwo.addClickControl("name", mockClickControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same click control bean instance " +
                "mapped to the same name");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockElementOne);
        clickControlBeanTwo.setContentContainer(mockElementOne);
        clickControlBeanOne.setClickWithJavascript(true);
        clickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have different click control bean instance " +
                "mapped to the same name which have the same content container reference and the same non-default " +
                "Javascript click workaround value");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockElementOne);
        hoverControlBeanTwo.setContentContainer(mockElementOne);
        hoverControlBeanOne.setClickInsteadOfHover(true);
        hoverControlBeanTwo.setClickInsteadOfHover(true);

        beanOne.addHoverControl("name", hoverControlBeanOne);
        beanTwo.addHoverControl("name", hoverControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have different hover control bean " +
                "instances mapped to the same name which have the same content container reference and the same " +
                "non-default click instead of hover workaround value");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();
        hoverAndClickControlBeanOne.setContentContainer(mockElementOne);
        hoverAndClickControlBeanTwo.setContentContainer(mockElementOne);
        hoverAndClickControlBeanOne.setClickWithJavascript(true);
        hoverAndClickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addHoverAndClickControl("name", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("name", hoverAndClickControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have different hover and click control " +
                "bean instance mapped to the same name which have the same content container reference and the same " +
                "non-default Javascript click instead of hover workaround value");

        beanOne = new DynamicControllableBeanImpl();
        beanTwo = new DynamicControllableBeanImpl();

        beanOne.setPollingTimeout(40);
        beanTwo.setPollingTimeout(40);
        beanOne.setPollingInterval(5);
        beanTwo.setPollingInterval(5);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container the same non-default " +
                "JavaScript hover workaround values and the same non-default polling timeout and polling interval");
    }

    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "DynamicControllableBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        DynamicControllableBean bean = new DynamicControllableBeanImpl();

        ClickControlBean mockClickControlBean = mock(ClickControlBean.class);
        HoverControlBean mockHoverControlBean = mock(HoverControlBean.class);
        HoverAndClickControlBean mockHoverAndClickControlBean = mock(HoverAndClickControlBean.class);

        bean.addClickControl("click", mockClickControlBean);
        bean.addHoverControl("hover", mockHoverControlBean);
        bean.addHoverAndClickControl("hoverAndClick", mockHoverAndClickControlBean);

        when(mockClickControlBean.toString()).thenReturn("Mock Click Control Bean");
        when(mockHoverControlBean.toString()).thenReturn("Mock Hover Control Bean");
        when(mockHoverAndClickControlBean.toString()).thenReturn("Mock Hover And Click Control Bean");

        assertTrue(bean.toString().contains("controlBeans={hover=Mock Hover Control Bean, click=Mock Click Control " +
                "Bean, hoverAndClick=Mock Hover And Click Control Bean}"), "toString() for " +
                "DynamicControllableBeanImpl does not include the control beans field in ControllableBeanImpl: " +
                bean.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "DynamicControllableBeanHashCodeCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        DynamicControllableBean bean = new DynamicControllableBeanImpl();
        DynamicControllableBean beanToCompare = new DynamicControllableBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.addClickControl("click", new ClickControlBeanImpl());
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different " +
                "collections of control beans should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.addClickControl("click", new ClickControlBeanImpl());
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which control bean collections " +
                "that are equal to each other should be equal, but are not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.addHoverControl("hover", new HoverControlBeanImpl());
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different " +
                "collections of control beans should not be equal, but are: " + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.addHoverControl("hover", new HoverControlBeanImpl());
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which control bean collections " +
                "that are equal to each other should be equal, but are not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.addHoverAndClickControl("hoverAndClick", new HoverAndClickControlBeanImpl());
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different " +
                "collections of control beans should not be equal, but are: "  + bean.toString() + ", " +
                beanToCompare.toString());

        beanToCompare.addHoverAndClickControl("hoverAndClick", new HoverAndClickControlBeanImpl());
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which control bean collections " +
                "that are equal to each other should be equal, but are not: " + bean.toString() + ", " +
                beanToCompare.toString());

    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "DynamicControllableBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        DynamicControllableBean bean = new DynamicControllableBeanImpl();
        DynamicControllableBean beanToCompare = new DynamicControllableBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.addClickControl("click", new ClickControlBeanImpl());
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.addClickControl("click", new ClickControlBeanImpl());
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.addHoverControl("hover", new HoverControlBeanImpl());
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.addHoverControl("hover", new HoverControlBeanImpl());
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.addHoverAndClickControl("hoverAndClick", new HoverAndClickControlBeanImpl());
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.addHoverAndClickControl("hoverAndClick", new HoverAndClickControlBeanImpl());
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }
}
