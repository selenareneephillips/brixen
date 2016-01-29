package org.brixen.test.bean;

import org.brixen.bean.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"LoadableBeanTestGroup"})
public class DropDownMenuBeanTest {

    @Mock WebElement mockContainerElementOne;
    @Mock WebElement mockContainerElementTwo;
    @Mock WebElement mockOptionElementOne;
    @Mock WebElement mockOptionElementTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(groups = {"EqualityNegativeTestGroup","BeanEqualityNegativeTestGroup",
            "DropDownBeanEqualityNegativeTestGroup"}
    )
    public void shouldNotBeEqual() {
        DropDownMenuBean beanOne = new DropDownMenuBeanImpl();
        DropDownMenuBean beanTwo = new DropDownMenuBeanImpl();

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

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockContainerElementOne);
        clickControlBeanTwo.setContentContainer(mockContainerElementOne);
        clickControlBeanOne.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they different click control bean " +
                "instance mapped to the same name which have the same content container reference but different " +
                "Javascript click workaround values");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        beanOne.addClickControl("clickControlOne", clickControlBeanOne);
        beanTwo.addClickControl("clickControlTwo", clickControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same click control bean instance mapped to different names " + 
                "should not be equal");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockContainerElementOne);
        hoverControlBeanTwo.setContentContainer(mockContainerElementOne);
        hoverControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverControl("hoverControl", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControl", hoverControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they have different hover control " +
                "bean instance mapped to the same name which have the same content container reference but different " +
                "Javascript hover workaround values");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        beanOne.addHoverControl("hoverControlOne", hoverControlBeanOne);
        beanTwo.addHoverControl("hoverControlTwo", hoverControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same hover control bean instance mapped to different names " + 
                "should not be equal");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();

        hoverAndClickControlBeanOne.setContentContainer(mockContainerElementOne);
        hoverAndClickControlBeanTwo.setContentContainer(mockContainerElementOne);
        hoverAndClickControlBeanOne.setHoverWithJavascript(true);

        beanOne.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

        assertNotEquals(beanOne, beanTwo, "Two beans should not be equal if they have different hover and click " +
                "control bean instance mapped to the same name which have the same content container reference but " +
                "different Javascript hover workaround values");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        beanOne.addHoverAndClickControl("hoverAndClickControlOne", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("hoverAndClickControlTwo", hoverAndClickControlBeanOne);

        assertNotEquals(beanOne, beanTwo, "Beans with the same hover and click control bean instance mapped to " +
                "different names should not be equal");

        beanTwo.setPollingTimeout(40);

        assertNotEquals(beanOne, beanTwo, "Beans with different polling timeouts should not be equal");

        beanTwo.setPollingTimeout(30);
        beanTwo.setPollingInterval(5);

        assertNotEquals(beanOne, beanTwo, "Beans with different polling intervals should not be equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "DropDownMenuBeanEqualityPositiveTestGroup"})
    public void shouldBeEqual() {
        DropDownMenuBean beanOne = new DropDownMenuBeanImpl();
        DropDownMenuBean beanTwo = new DropDownMenuBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setContentContainer(mockContainerElementOne);
        beanTwo.setContentContainer(mockContainerElementOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same default JavaScript click workaround value");

        beanOne.setClickOptionWithJavascript(true);
        beanTwo.setClickOptionWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same container element reference " +
                "and same non-default JavaScript click workaround value");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        beanOne.setClickOptionWithJavascript(true);
        beanTwo.setClickOptionWithJavascript(true);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container element references and " +
                "same non-default JavaScript click workaround value");

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

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

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

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        ClickControlBean mockClickControlBean = mock(ClickControlBean.class);
        beanOne.addClickControl("name", mockClickControlBean);
        beanTwo.addClickControl("name", mockClickControlBean);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same click control bean " +
                "instance mapped to the same name");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        ClickControlBean clickControlBeanOne = new ClickControlBeanImpl();
        ClickControlBean clickControlBeanTwo = new ClickControlBeanImpl();

        clickControlBeanOne.setContentContainer(mockContainerElementOne);
        clickControlBeanTwo.setContentContainer(mockContainerElementOne);
        clickControlBeanOne.setClickWithJavascript(true);
        clickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addClickControl("name", clickControlBeanOne);
        beanTwo.addClickControl("name", clickControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have different click control bean instance " +
                "mapped to the same name which have the same content container reference and the same non-default " +
                "Javascript click workaround value");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        HoverControlBean hoverControlBeanOne = new HoverControlBeanImpl();
        HoverControlBean hoverControlBeanTwo = new HoverControlBeanImpl();

        hoverControlBeanOne.setContentContainer(mockContainerElementOne);
        hoverControlBeanTwo.setContentContainer(mockContainerElementOne);
        hoverControlBeanOne.setClickInsteadOfHover(true);
        hoverControlBeanTwo.setClickInsteadOfHover(true);

        beanOne.addHoverControl("name", hoverControlBeanOne);
        beanTwo.addHoverControl("name", hoverControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have different hover control bean " +
                "instances mapped to the same name which have the same content container reference and the same " +
                "non-default click instead of hover workaround value");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        HoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBeanImpl();
        HoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBeanImpl();

        hoverAndClickControlBeanOne.setContentContainer(mockContainerElementOne);
        hoverAndClickControlBeanTwo.setContentContainer(mockContainerElementOne);
        hoverAndClickControlBeanOne.setClickWithJavascript(true);
        hoverAndClickControlBeanTwo.setClickWithJavascript(true);

        beanOne.addHoverAndClickControl("name", hoverAndClickControlBeanOne);
        beanTwo.addHoverAndClickControl("name", hoverAndClickControlBeanTwo);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have different hover and click control " +
                "bean instance mapped to the same name which have the same content container reference and the same " +
                "non-default Javascript click instead of hover workaround value");

        beanOne = new DropDownMenuBeanImpl();
        beanTwo = new DropDownMenuBeanImpl();

        beanOne.setPollingTimeout(40);
        beanTwo.setPollingTimeout(40);
        beanOne.setPollingInterval(5);
        beanTwo.setPollingInterval(5);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null container the same non-default " +
                "JavaScript hover workaround values and the same non-default polling timeout and polling interval");
    }
    @Test(groups = {"ToStringCallsSuperTestGroup", "BeanToStringCallsSuperTestGroup",
            "DropDownMenuBeanToStringCallsSuperTestGroup"}
    )
    public void shouldCallSuperForToString() {
        DropDownMenuBean bean = new DropDownMenuBeanImpl();
        bean.setClickOptionWithJavascript(true);
        assertTrue(bean.toString().contains("clickOptionWithJavascript=true"), bean.toString());

        List<WebElement> optionList = new ArrayList<>();
        optionList.add(mockOptionElementOne);
        when(mockOptionElementOne.toString()).thenReturn("Mock Option Element");
        bean.setOptionElements(optionList);

        assertTrue(bean.toString().contains("optionElements=[Mock Option Element]"), bean.toString());
    }

    @Test(groups = {"HashCodeCallsSuperTestGroup", "BeanHashCodeCallsSuperTestGroup",
            "DropDownMenuBeanHashCodeCallsSuperTestGroup"}, dependsOnMethods = {"shouldCallSuperForToString"}
    )
    public void shouldCallSuperForHashCode() {
        DropDownMenuBean bean = new DropDownMenuBeanImpl();
        DropDownMenuBean beanToCompare = new DropDownMenuBeanImpl();

        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for beans which have not had setters " +
                "called should be equal, but are not: " + bean.toString() + ", " + beanToCompare.toString());

        bean.setClickOptionWithJavascript(true);
        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for beans which have different values " +
                "for their menu option Javascript click work around fields should not be equal, but are: " +
                bean.toString() + ", " + beanToCompare.toString());

        beanToCompare.setClickOptionWithJavascript(true);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for beans which have the same menu " +
                "option Javascript click work around should be equal, but are not: " + bean.toString() + ", " +
                beanToCompare.toString());

        List<WebElement> optionList = new ArrayList<>();
        optionList.add(mockOptionElementOne);
        bean.setOptionElements(optionList);

        assertNotEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have different control" +
                "bean collections should not be equal, but are: " + bean.toString() + ", " + beanToCompare.toString());

        beanToCompare.setOptionElements(optionList);
        assertEquals(bean.hashCode(), beanToCompare.hashCode(), "Hash codes for bean which have control bean " +
                "collections which are equal to each other should be equal, but are not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }

    @Test(groups = {"EqualsCallsSuperTestGroup", "BeanEqualsCallsSuperTestGroup",
            "DropDownMenuBeanEqualsCallsSuperTestGroup"},
            dependsOnMethods = {"shouldCallSuperForToString", "shouldCallSuperForHashCode"}
    )
    public void shouldCallSuperForEquals() {
        DropDownMenuBean bean = new DropDownMenuBeanImpl();
        DropDownMenuBean beanToCompare = new DropDownMenuBeanImpl();

        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        bean.setClickOptionWithJavascript(true);
        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setClickOptionWithJavascript(true);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());

        List<WebElement> optionList = new ArrayList<>();
        optionList.add(mockOptionElementOne);
        bean.setOptionElements(optionList);

        assertNotEquals(bean, beanToCompare, "Equals method should return false, but did not: " + bean.toString() +
                ", " + beanToCompare.toString());

        beanToCompare.setOptionElements(optionList);
        assertEquals(bean, beanToCompare, "Equals method should return true, but did not: " + bean.toString() + ", " +
                beanToCompare.toString());
    }
}
