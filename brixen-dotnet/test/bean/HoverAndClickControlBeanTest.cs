using System;
using NUnit.Framework;
using OpenQA.Selenium;
using Moq;

namespace Org.Brixen.Bean.Tests
{
	[TestFixture]
	[Category("HoverAndClickControlBeanTestGroup")]
	public class HoverAndClickControlBeanTest {
		
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("HoverAndClickControlBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot invoke setter for " + 
			"UnhoverElement property with a null parameter", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForNullUnhoverElement() {
			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			bean.UnhoverElement = null;
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("HoverAndClickControlBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentOutOfRangeException", ExpectedMessage="Cannot specify a polling timeout " + 
			"less than 0 seconds", MatchType=MessageMatch.Regex )]
		public void ShouldThrowExceptionForNegativePollingTimeout() {
			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			bean.PollingTimeout = -1;
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("HoverAndClickControlBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentOutOfRangeException", ExpectedMessage="Cannot specify a polling interval " + 
			"less than 0 seconds", MatchType=MessageMatch.Regex )]
		public void ShouldThrowExceptionForNegativePollingInterval() {
			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			bean.PollingInterval = -1;
		}

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("HoverAndClickControlBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			IHoverAndClickControlBean beanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean beanTwo = new HoverAndClickControlBean();
		
			Mock<IWebElement> mockUnhoverElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockUnhoverElementTwo = new Mock<IWebElement>();

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

			beanTwo.UnhoverWithJavascriptClickInstead = true;
			beanOne.LoadTimeout = 40;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different load timeouts should not be equal");

			beanOne.LoadTimeout = 30;
			beanTwo.PollingTimeout = 40;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different polling timeouts should not be equal");

			beanTwo.PollingTimeout = 30;
			beanTwo.PollingInterval = 5;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different polling intervals should not be equal");
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("HoverAndClickControlBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IHoverAndClickControlBean beanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean beanTwo = new HoverAndClickControlBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

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

			beanOne.UnhoverWithJavascriptClickInstead = false;
			beanTwo.UnhoverWithJavascriptClickInstead = false;
			beanOne.PollingTimeout = 40;
			beanTwo.PollingTimeout = 40;
			beanOne.PollingInterval = 5;
			beanTwo.PollingInterval = 5;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container and unhover " + 
				"element references and and the same non-default polling timeout and polling interval");
			
			beanOne = new HoverAndClickControlBean();
			beanTwo = new HoverAndClickControlBean();

			beanOne.HoverWithJavascript = true;
			beanTwo.HoverWithJavascript = true;
			beanOne.UnhoverWithJavascript = true;
			beanTwo.UnhoverWithJavascript = true;
			beanOne.ClickWithJavascriptInsteadOfHover = true;
			beanTwo.ClickWithJavascriptInsteadOfHover = true;
			beanOne.UnhoverWithClickInstead = true;
			beanTwo.UnhoverWithClickInstead = true;
			beanOne.UnhoverWithJavascriptClickInstead = true;
			beanTwo.UnhoverWithJavascriptClickInstead = true;
			beanOne.PollingTimeout = 40;
			beanTwo.PollingTimeout = 40;
			beanOne.PollingInterval = 5;
			beanTwo.PollingInterval = 5;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container and unhover " + 
				"element references, the same non-default JavaScript hover workaround values and the same " + 
				"non-default polling timeout and polling interval");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("HoverAndClickControlBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			bean.ContentContainer = mockElement.Object;

			Assert.AreEqual("HoverAndClickControlBean(ClickControlBean(ContentContainerBean(LoadableBean(Driver: " + 
				"null, LoadTimeout: 30), ContentContainer: " + mockElement.Object.ToString() + "), " + 
				"ClickWithJavascript: False), UnhoverElement: null, HoverWithJavascript: False, " + 
				"UnhoverWithJavascript: False, ClickWithJavascriptInsteadOfHover: False, UnhoverWithClickInstead: " + 
				"False, UnhoverWithJavascriptClickInstead: False, PollingTimeout: 30, PollingInterval: 1)", 
				bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("HoverAndClickControlBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			IHoverAndClickControlBean beanToCompare = new HoverAndClickControlBean();

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have not had " + 
				"setters called should be equal, but are not: " + bean.ToString() + ", " + beanToCompare.ToString());

			bean.ClickWithJavascript = true;
			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"different values for their Javascript click workaround fields should not be equal, but are: " + 
				bean.ToString() + ", " + beanToCompare.ToString());

			beanToCompare.ClickWithJavascript = true;
			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have the " + 
				"same Javascript click workaround value should be equal, but are not: " + bean.ToString() + ", " + 
				beanToCompare.ToString());
		}
			
		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnFalseForIsHoverControl() {
			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			Assert.IsFalse(bean.IsHoverControl());
		}	

		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnTrueForIsClickControl() {
			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			Assert.IsTrue(bean.IsClickControl());
		}

		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnTrueForIsHoverAndClickControl() {
			IHoverAndClickControlBean bean = new HoverAndClickControlBean();
			Assert.IsTrue(bean.IsHoverAndClickControl());
		}
	}
}

