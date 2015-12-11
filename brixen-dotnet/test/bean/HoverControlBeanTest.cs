using System;
using NUnit.Framework;
using OpenQA.Selenium;
using Moq;

namespace Org.Brixen.Bean.Tests {

	[TestFixture]
	[Category("HoverControlBeanTestGroup")]
	public class HoverControlBeanTest {

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("HoverControlBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot invoke setter for " + 
			"UnhoverElement property with a null parameter", MatchType=MessageMatch.Regex)]
		public void shouldThrowExceptionForNullUnhoverElement() {
			IHoverControlBean bean = new HoverControlBean();
			bean.UnhoverElement = null;
		}

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("HoverControlBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			IHoverControlBean beanOne = new HoverControlBean();
			IHoverControlBean beanTwo = new HoverControlBean();

			Mock<IWebElement> mockContainerElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockContainerElementTwo = new Mock<IWebElement>();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different container element references should not be " + 
				"equal");

			Mock<IWebElement> mockUnhoverElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockUnhoverElementTwo = new Mock<IWebElement>();

			beanTwo.ContentContainer = mockContainerElementOne.Object;
			beanOne.UnhoverElement= mockUnhoverElementOne.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different unhover element references should not be equal");

			beanTwo.UnhoverElement = mockUnhoverElementTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different unhover element references should not be equal");

			beanTwo.UnhoverElement = mockUnhoverElementOne.Object;
			beanOne.HoverWithJavascript = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different JavaScript hover workaround values should not " + 
				"be equal");

			beanTwo.HoverWithJavascript = true;
			beanOne.UnhoverWithJavascript = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different JavaScript unhover workaround values should " + 
				"not be equal");

			beanTwo.UnhoverWithJavascript = true;
			beanOne.ClickInsteadOfHover = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different click action hover workaround values should " + 
				"not be equal");

			beanTwo.ClickInsteadOfHover = true;
			beanOne.ClickWithJavascriptInsteadOfHover = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different JavaScript click action hover workaround " + 
				"values should not be equal");

			beanTwo.ClickWithJavascriptInsteadOfHover = true;
			beanOne.UnhoverWithClickInstead = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different click action unhover workaround values should " + 
				"not be equal");

			beanTwo.UnhoverWithClickInstead = true;
			beanOne.UnhoverWithJavascriptClickInstead = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different JavaScript click action unhover workaround " + 
				"values should not be equal");
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("HoverControlBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IHoverControlBean beanOne = new HoverControlBean();
			IHoverControlBean beanTwo = new HoverControlBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IWebElement> mockContainerElement = new Mock<IWebElement>();

			beanOne.ContentContainer = mockContainerElement.Object;
			beanTwo.ContentContainer = mockContainerElement.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same default JavaScript click workaround value");
			
			Mock<IWebElement> mockUnhoverElement = new Mock<IWebElement>();

			beanOne.UnhoverElement = mockUnhoverElement.Object;
			beanTwo.UnhoverElement = mockUnhoverElement.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " +
				"element references and same default workaround values");

			beanOne.HoverWithJavascript = true;
			beanTwo.HoverWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and same non-default JavaScript hover workaround value");

			beanOne.HoverWithJavascript = false;
			beanTwo.HoverWithJavascript = false;
			beanOne.UnhoverWithJavascript = true;
			beanTwo.UnhoverWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and same non-default JavaScript unhover workaround value");

			beanOne.UnhoverWithJavascript = false;
			beanTwo.UnhoverWithJavascript = false;
			beanOne.ClickInsteadOfHover = true;
			beanTwo.ClickInsteadOfHover = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and same non-default click action hover workaround value");

			beanOne.ClickInsteadOfHover = false;
			beanTwo.ClickInsteadOfHover = false;
			beanOne.ClickWithJavascriptInsteadOfHover = true;
			beanTwo.ClickWithJavascriptInsteadOfHover = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and same non-default JavaScript click action hover workaround value");

			beanOne.ClickWithJavascriptInsteadOfHover = false;
			beanTwo.ClickWithJavascriptInsteadOfHover = false;
			beanOne.UnhoverWithJavascript = true;
			beanTwo.UnhoverWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and same non-default click action unhover workaround value");

			beanOne.UnhoverWithJavascript = false;
			beanTwo.UnhoverWithJavascript = false;
			beanOne.UnhoverWithClickInstead = true;
			beanTwo.UnhoverWithClickInstead = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and same non-default click action unhover workaround value");

			beanOne.UnhoverWithClickInstead = false;
			beanTwo.UnhoverWithClickInstead = false;
			beanOne.UnhoverWithJavascriptClickInstead = true;
			beanTwo.UnhoverWithJavascriptClickInstead = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and same non-default JavaScript click action unhover workaround value");
			
			beanOne = new HoverControlBean();
			beanTwo = new HoverControlBean();

			beanOne.HoverWithJavascript = true;
			beanTwo.HoverWithJavascript = true;
			beanOne.UnhoverWithJavascript = true;
			beanTwo.UnhoverWithJavascript = true;
			beanOne.ClickInsteadOfHover = true;
			beanTwo.ClickInsteadOfHover = true;
			beanOne.ClickWithJavascriptInsteadOfHover = true;
			beanTwo.ClickWithJavascriptInsteadOfHover = true;
			beanOne.UnhoverWithClickInstead = true;
			beanTwo.UnhoverWithClickInstead = true;
			beanOne.UnhoverWithJavascriptClickInstead = true;
			beanTwo.UnhoverWithJavascriptClickInstead = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container and unhover " + 
				"element references and same non-default JavaScript hover workaround values");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("HoverControlBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			IHoverControlBean bean = new HoverControlBean();
			bean.ContentContainer = mockElement.Object;

			Assert.AreEqual("HoverControlBean(ContentContainerBean(LoadableBean(Driver: null, LoadTimeout: 30), " + 
				"ContentContainer: " + mockElement.Object.ToString() + "), UnhoverElement: null, " + 
				"HoverWithJavascript: False, UnhoverWithJavascript: False, ClickInsteadOfHover: False, " + 
				"ClickWithJavascriptInsteadOfHover: False, UnhoverWithClickInstead: False, " + 
				"UnhoverWithJavascriptClickInstead: False)", bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("HoverControlBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IHoverControlBean bean = new HoverControlBean();
			IHoverControlBean beanToCompare = new HoverControlBean();

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have not had " + 
				"setters called should be equal, but are not: " + bean.ToString() + ", " + beanToCompare.ToString());

			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			bean.ContentContainer = mockElement.Object;
			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"different values for their container element fields should not be equal, but are: " + 
				bean.ToString() + ", " + beanToCompare.ToString());

			beanToCompare.ContentContainer = mockElement.Object;
			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have the " + 
				"same container element should be equal, but are not: " + bean.ToString() + ", " + 
				beanToCompare.ToString());
		}

		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnTrueForIsHoverControl() {
			IHoverControlBean bean = new HoverControlBean();
			Assert.IsTrue(bean.IsHoverControl());
		}	

		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnFalseForIsClickControl() {
			IHoverControlBean bean = new HoverControlBean();
			Assert.IsFalse(bean.IsClickControl());
		}

		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnFalseForIsHoverAndClickControl() {
			IHoverControlBean bean = new HoverControlBean();
			Assert.IsFalse(bean.IsHoverAndClickControl());
		}
	}
}

