using System;
using NUnit.Framework;
using OpenQA.Selenium;
using Moq;
using System.Collections.Generic;
using Org.Brixen.Bean;

namespace Org.Brixen.Tests.Bean {

	[TestFixture]
	[Category("MenuBeanTestGroup")]
	public class DropDownMenuTest {
		
		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("DropDownBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebElement> mockElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockElementTwo = new Mock<IWebElement>();

			IDropDownMenuBean beanOne = new DropDownMenuBean();
			IDropDownMenuBean beanTwo = new DropDownMenuBean();

			beanOne.ContentContainer = mockElementOne.Object;
			beanTwo.ContentContainer = mockElementTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different container element references should not be " + 
				"equal");

			beanTwo.ContentContainer = mockElementOne.Object;

			IList<IWebElement> optionsListOne = new List<IWebElement>();
			IList<IWebElement> optionsListTwo = new List<IWebElement>();
			Mock<IWebElement> mockOptionElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockOptionElementTwo = new Mock<IWebElement>();

			optionsListOne.Add(mockOptionElementOne.Object);
			optionsListTwo.Add(mockOptionElementTwo.Object);
			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different lists of option elements should not be equal");

			beanTwo.OptionElements = optionsListOne;
			beanOne.ClickOptionWithJavascript = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different Javascript click workaround values should not " + 
				"be equal");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();
			
			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();

			clickControlBeanOne.ContentContainer = mockElementOne.Object;
			clickControlBeanTwo.ContentContainer = mockElementOne.Object;
			clickControlBeanOne.ClickWithJavascript = true;

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they different click control bean " + 
				"instance mapped to the same name which have the same content container reference but different " + 
				"Javascript click workaround values");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			beanOne.AddClickControl("clickControlOne", clickControlBeanOne);
			beanTwo.AddClickControl("clickControlTwo", clickControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same click control bean instance mapped to " + 
				"different names should not be equal");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			IHoverControlBean hoverControlBeanOne = new HoverControlBean();
			IHoverControlBean hoverControlBeanTwo = new HoverControlBean();

			hoverControlBeanOne.ContentContainer = mockElementOne.Object;
			hoverControlBeanTwo.ContentContainer = mockElementOne.Object;
			hoverControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverControl("hoverControl", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControl", hoverControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they have different hover control " + 
				"bean instance mapped to the same name which have the same content container reference but different " + 
				"Javascript hover workaround values");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			beanOne.AddHoverControl("hoverControlOne", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControlTwo", hoverControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same hover control bean instance mapped to " + 
				"different names should not be equal");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			IHoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBean();

			hoverAndClickControlBeanOne.ContentContainer = mockElementOne.Object;
			hoverAndClickControlBeanTwo.ContentContainer = mockElementOne.Object;
			hoverAndClickControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they have different hover and " + 
				"click control bean instance mapped to the same name which have the same content container reference " + 
				"but different Javascript hover workaround values");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			beanOne.AddHoverAndClickControl("hoverAndClickControlOne", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("hoverAndClickControlTwo", hoverAndClickControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same hover and click control bean instance mapped " + 
				"to different names should not be equal");

			beanTwo.PollingTimeout = 40;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different polling timeouts should not be equal");

			beanTwo.PollingTimeout = 30;
			beanTwo.PollingInterval = 5;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different polling intervals should not be equal");
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("DropDownMenuBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IDropDownMenuBean beanOne = new DropDownMenuBean();
			IDropDownMenuBean beanTwo = new DropDownMenuBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			beanOne.ContentContainer = mockElement.Object;
			beanTwo.ContentContainer = mockElement.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same default JavaScript click workaround value");

			beanOne.ClickOptionWithJavascript = true;
			beanTwo.ClickOptionWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same non-default JavaScript click workaround value");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			beanOne.ClickOptionWithJavascript = true;
			beanTwo.ClickOptionWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container element " + 
				"references and same non-default JavaScript click workaround value");

			beanOne.ContentContainer = mockElement.Object;
			beanTwo.ContentContainer = mockElement.Object;

			List<IWebElement> optionsListOne = new List<IWebElement>();
			List<IWebElement> optionsListTwo = new List<IWebElement>();
			Mock<IWebElement> mockOptionElement = new Mock<IWebElement>();

			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListOne;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " +
				"references and the same empty option elements list reference");

			optionsListOne.Add(mockOptionElement.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " +
				"references and the same non-empty option elements list reference");

			optionsListTwo.Add(mockOptionElement.Object);
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " +
				"references and two non-empty option elements list references containing the same object");

			optionsListOne = new List<IWebElement>();
			optionsListTwo = new List<IWebElement>();

			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"two different empty option element list references");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they both have null container element " + 
				"references and two different empty option element list references");

			beanTwo.OptionElements = optionsListOne;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they both have null container element " +
				"references and the same empty option elements list reference");

			beanTwo.OptionElements = optionsListTwo;
			optionsListOne.Add(mockOptionElement.Object);
			optionsListTwo.Add(mockOptionElement.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they both have null container element " +
				"references and two non-empty option elements list references containing the same object");
			
			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IClickControlBean> mockClickControlBean = new Mock<IClickControlBean>();
			beanOne.AddClickControl("name", mockClickControlBean.Object);
			beanTwo.AddClickControl("name", mockClickControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same click control bean " + 
				"instance mapped to the same name");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();

			Mock<IWebElement> mockContainerElement = new Mock<IWebElement>();

			clickControlBeanOne.ContentContainer = mockContainerElement.Object;
			clickControlBeanTwo.ContentContainer = mockContainerElement.Object;
			clickControlBeanOne.ClickWithJavascript = true;
			clickControlBeanTwo.ClickWithJavascript = true;

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have different click control bean " + 
				"instance mapped to the same name which have the same content container reference and the same " + 
				"non-default Javascript click workaround value");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			IHoverControlBean hoverControlBeanOne = new HoverControlBean();
			IHoverControlBean hoverControlBeanTwo = new HoverControlBean ();

			hoverControlBeanOne.ContentContainer = mockContainerElement.Object;
			hoverControlBeanTwo.ContentContainer = mockContainerElement.Object;
			hoverControlBeanOne.ClickInsteadOfHover = true;
			hoverControlBeanTwo.ClickInsteadOfHover = true;

			beanOne.AddHoverControl("name", hoverControlBeanOne);
			beanTwo.AddHoverControl("name", hoverControlBeanTwo);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have different hover control bean " + 
				"instances mapped to the same name which have the same content container reference and the same " + 
				"non-default click instead of hover workaround value");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			IHoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBean();

			hoverAndClickControlBeanOne.ContentContainer = mockContainerElement.Object;
			hoverAndClickControlBeanTwo.ContentContainer = mockContainerElement.Object;
			hoverAndClickControlBeanOne.ClickWithJavascript = true;
			hoverAndClickControlBeanTwo.ClickWithJavascript = true;

			beanOne.AddHoverAndClickControl("name", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("name", hoverAndClickControlBeanTwo);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have different hover and click " + 
				"control bean instance mapped to the same name which have the same content container reference and " + 
				"the same non-default Javascript click instead of hover workaround value");

			beanOne = new DropDownMenuBean();
			beanTwo = new DropDownMenuBean();

			beanOne.PollingTimeout = 40;
			beanTwo.PollingTimeout = 40;
			beanOne.PollingInterval = 5;
			beanTwo.PollingInterval = 5;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container the same " + 
				"non-default JavaScript hover workaround values and the same non-default polling timeout and polling " + 
				"interval");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("DropDownMenuBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			IDropDownMenuBean bean = new DropDownMenuBean();

			Assert.AreEqual("DropDownMenuBean(DynamicControllableBean(ControllableBean(ContentContainerBean(" + 
				"LoadableBean(Driver: null, LoadTimeout: 30), ContentContainer: null), Control Beans: " + 
				"System.Collections.Generic.Dictionary`2[System.String,Org.Brixen.Bean.IControlBean]), " + 
				"PollingTimeout: 30, PollingInterval: 1), ClickOptionWithJavascript: False, OptionElements: " + 
				"System.Collections.Generic.List`1[OpenQA.Selenium.IWebElement])", bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("DropDownMenuBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IDropDownMenuBean bean = new DropDownMenuBean();
			IDropDownMenuBean beanToCompare = new DropDownMenuBean();

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have not had " + 
				"setters called should be equal, but are not: " + bean.ToString() + ", " + beanToCompare.ToString());

			Mock<IWebElement> mockElement = new Mock<IWebElement>();
			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();
			clickControlBeanOne.ContentContainer = mockElement.Object;
			clickControlBeanTwo.ContentContainer = mockElement.Object;

			bean.AddClickControl("name", clickControlBeanOne);

			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"different control bean collections should not be equal, but are: " + 
				bean.ToString() + ", " + beanToCompare.ToString());

			beanToCompare.AddClickControl("name", clickControlBeanTwo);

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have control " + 
				"collections with beans that are equal to each other should be equal, but are not: " + 
				bean.ToString() + ", " + beanToCompare.ToString());

			beanToCompare.PollingTimeout = 40;

			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"control collections with beans that are equal to each other, but different polling timeouts should " + 
			 	"not be equal, but are: " + bean.ToString() + ", " + beanToCompare.ToString());

			bean.PollingTimeout = 40;

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have control " + 
				"collections with beans that are equal to each other and the same polling timeout should be equal, " + 
				"but are not: " + bean.ToString() + ", " + beanToCompare.ToString());

			beanToCompare.PollingInterval = 5;

			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"control collections with beans that are equal to each other, but different polling intervals should " + 
				"not be equal, but are: " + bean.ToString() + ", " + beanToCompare.ToString());

			bean.PollingInterval = 5;

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have control " + 
				"collections with beans that are equal to each other and the same polling interval should be equal, " + 
				"but are not: " + bean.ToString() + ", " + beanToCompare.ToString());
		}
	}
}

