using System;
using NUnit.Framework;
using OpenQA.Selenium;
using Moq;

namespace Org.Brixen.Bean.Tests {
	
	[TestFixture]
	[Category("DynamicControllableBeanTestGroup")]
	public class DynamicControllableBeanTest {

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("DynamicControllableBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			IDynamicControllableBean beanOne = new DynamicControllableBean();
			IDynamicControllableBean beanTwo = new DynamicControllableBean();

			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();

			clickControlBeanOne.ContentContainer = mockElement.Object;
			clickControlBeanTwo.ContentContainer = mockElement.Object;
			clickControlBeanOne.ClickWithJavascript = true;

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they different click control bean " + 
				"instance mapped to the same name which have the same content container reference but different " + 
				"Javascript click workaround values");

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

			beanOne.AddClickControl("clickControlOne", clickControlBeanOne);
			beanTwo.AddClickControl("clickControlTwo", clickControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same click control bean instance mapped to " + 
				"different names should not be equal");

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

			IHoverControlBean hoverControlBeanOne = new HoverControlBean();
			IHoverControlBean hoverControlBeanTwo = new HoverControlBean();

			hoverControlBeanOne.ContentContainer = mockElement.Object;
			hoverControlBeanTwo.ContentContainer = mockElement.Object;
			hoverControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverControl("hoverControl", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControl", hoverControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they have different hover control " + 
				"bean instance mapped to the same name which have the same content container reference but different " + 
				"Javascript hover workaround values");

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

			beanOne.AddHoverControl("hoverControlOne", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControlTwo", hoverControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same hover control bean instance mapped to " + 
				"different names should not be equal");

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

			IHoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBean();

			hoverAndClickControlBeanOne.ContentContainer = mockElement.Object;
			hoverAndClickControlBeanTwo.ContentContainer = mockElement.Object;
			hoverAndClickControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they have different hover and " + 
				"click control bean instance mapped to the same name which have the same content container reference " + 
				"but different Javascript hover workaround values");

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

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
		[Category("DynamicControllableBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IDynamicControllableBean beanOne = new DynamicControllableBean();
			IDynamicControllableBean beanTwo = new DynamicControllableBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IClickControlBean> mockClickControlBean = new Mock<IClickControlBean>();
			beanOne.AddClickControl("name", mockClickControlBean.Object);
			beanTwo.AddClickControl("name", mockClickControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same click control bean " + 
				"instance mapped to the same name");

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

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

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

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

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

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

			beanOne = new DynamicControllableBean();
			beanTwo = new DynamicControllableBean();

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
		[Category("DynamicControllableBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			IDynamicControllableBean bean = new DynamicControllableBean();

			Assert.AreEqual("DynamicControllableBean(ControllableBean(ContentContainerBean(LoadableBean(Driver: " + 
				"null, LoadTimeout: 30), ContentContainer: null), Control Beans: " + 
				"System.Collections.Generic.Dictionary`2[System.String,Org.Brixen.Bean.IControlBean]), " + 
				"PollingTimeout: 30, PollingInterval: 1)", 
				bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("DynamicControllableBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IDynamicControllableBean bean = new DynamicControllableBean();
			IDynamicControllableBean beanToCompare = new DynamicControllableBean();

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have not had " + 
				"setters called should be equal, but are not: " + bean.ToString() + ", " + beanToCompare.ToString());

			Mock<IWebElement> mockElement = new Mock<IWebElement>();
			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();
			clickControlBeanOne.ContentContainer = mockElement.Object;
			clickControlBeanTwo.ContentContainer = mockElement.Object;

			bean.AddClickControl("name", clickControlBeanOne);

			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"control bean collections should not be equal, but are: " + 
				bean.ToString() + ", " + beanToCompare.ToString());

			beanToCompare.AddClickControl("name", clickControlBeanTwo);

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have control " + 
				"collections with beans that are equal to each other should be equal, but are not: " + 
				bean.ToString() + ", " + beanToCompare.ToString());
		}
	}
}

