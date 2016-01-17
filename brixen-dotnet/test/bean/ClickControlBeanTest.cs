using System;
using NUnit.Framework;
using OpenQA.Selenium;
using Moq;

namespace Org.Brixen.Bean.Tests
{
	[TestFixture]
	[Category("ClickControlBeanTestGroup")]
	public class ClickControlBeanTest {
		
		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("ClickControlBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebElement> mockElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockElementTwo = new Mock<IWebElement>();

			IClickControlBean beanOne = new ClickControlBean();
			IClickControlBean beanTwo = new ClickControlBean();

			beanOne.ContentContainer = mockElementOne.Object;
			beanTwo.ContentContainer = mockElementTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different container element references should not be " + 
				"equal");

			beanTwo.ContentContainer = mockElementOne.Object;
			beanOne.ClickWithJavascript = true;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different JavaScript click workaround values should not " + 
				"be equal");
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("ClickControlBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IClickControlBean beanOne = new ClickControlBean();
			IClickControlBean beanTwo = new ClickControlBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			beanOne.ContentContainer = mockElement.Object;
			beanTwo.ContentContainer = mockElement.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same default JavaScript click workaround value");

			beanOne.ClickWithJavascript = true;
			beanTwo.ClickWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same non-default JavaScript click workaround value");

			beanOne = new ClickControlBean();
			beanTwo = new ClickControlBean();

			beanOne.ClickWithJavascript = true;
			beanTwo.ClickWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container element " + 
				"references and same non-default JavaScript click workaround value");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("ClickControlBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			IClickControlBean bean = new ClickControlBean();
			bean.ContentContainer = mockElement.Object;

			Assert.AreEqual("ClickControlBean(ContentContainerBean(LoadableBean(Driver: null, LoadTimeout: 30), " + 
				"ContentContainer: " + mockElement.Object.ToString() + "), ClickWithJavascript: False)", 
				bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("ClickControlBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IClickControlBean bean = new ClickControlBean();
			IClickControlBean beanToCompare = new ClickControlBean();

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
		public void ShouldReturnFalseForIsHoverControl() {
			IClickControlBean bean = new ClickControlBean();
			Assert.IsFalse(bean.IsHoverControl());
		}	

		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnTrueForIsClickControl() {
			IClickControlBean bean = new ClickControlBean();
			Assert.IsTrue(bean.IsClickControl());
		}

		[Test]
		[Category("ControlBeanExtensionMethodsTestGroup")]
		public void ShouldReturnFalseForIsHoverAndClickControl() {
			IClickControlBean bean = new ClickControlBean();
			Assert.IsFalse(bean.IsHoverAndClickControl());
		}
	}
}

