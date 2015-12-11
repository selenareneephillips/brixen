using System;
using NUnit.Framework;
using OpenQA.Selenium;
using Moq;

namespace Org.Brixen.Bean.Tests {
	
	[TestFixture]
	[Category("ClickableBeanTestGroup")]
	public class ClickableBeanTest {
		
		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("ClickableBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebElement> mockElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockElementTwo = new Mock<IWebElement>();

			IClickableBean beanOne = new ClickableBean();
			IClickableBean beanTwo = new ClickableBean();

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
		[Category("ClickableBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IClickableBean beanOne = new ClickableBean();
			IClickableBean beanTwo = new ClickableBean();

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

			beanOne = new ClickableBean();
			beanTwo = new ClickableBean();

			beanOne.ClickWithJavascript = true;
			beanTwo.ClickWithJavascript = true;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container element " + 
				"references and same non-default JavaScript click workaround value");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("ClickableBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			IClickableBean bean = new ClickableBean();
			bean.ContentContainer = mockElement.Object;

			Assert.AreEqual("ClickableBean(ContentContainerBean(LoadableBean(Driver: null, LoadTimeout: 30), " + 
				"ContentContainer: " + mockElement.Object.ToString() + "), ClickWithJavascript: False)", 
				bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("ClickableBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IClickableBean bean = new ClickableBean();
			IClickableBean beanToCompare = new ClickableBean();

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
	}
}

