using System;
using NUnit.Framework;
using Org.Brixen.Bean;
using OpenQA.Selenium;
using Moq;

namespace Org.Brixen.Bean.Tests {

	[TestFixture]
	[Category("ContentcContainerBeanTestGroup")]
	public class ContentContainerBeanTest {

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ContentContainerBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot invoke setter for " + 
			"ContentContainer property with a null parameter", MatchType=MessageMatch.Regex)]
		public void shouldThrowExceptionForNullContainerElement() {
			IContentContainerBean bean = new ContentContainerBean();
			bean.ContentContainer = null;
		}

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("ContentContainerBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebDriver> mockDriverOne = new Mock<IWebDriver>();
			Mock<IWebDriver> mockDriverTwo = new Mock<IWebDriver>();

			IContentContainerBean beanOne = new ContentContainerBean();
			IContentContainerBean  beanTwo = new ContentContainerBean();

			beanOne.Driver = mockDriverOne.Object;
			beanTwo.Driver = mockDriverTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different driver references should not be equal");

			beanOne = new ContentContainerBean();
			beanTwo = new ContentContainerBean();
			beanOne.LoadTimeout = 40;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different load timeouts should not be equal");

			Mock<IWebElement> mockContainerElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockContainerElementTwo = new Mock<IWebElement>();

			beanOne.LoadTimeout = 30;
			beanOne.ContentContainer = mockContainerElementOne.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different content container element values should not " + 
				"be equal");

			beanTwo.ContentContainer = mockContainerElementTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different content container element values should not " + 
				"be equal");
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("ContentContainerBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IContentContainerBean beanOne = new ContentContainerBean();
			IContentContainerBean beanTwo = new ContentContainerBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IWebDriver> mockDriver = new Mock<IWebDriver>();

			beanOne.Driver = mockDriver.Object;
			beanTwo.Driver = mockDriver.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference " +
				"and the default load timeout");

			Mock<IWebElement> mockContainerElement = new Mock<IWebElement>();

			beanOne.ContentContainer = mockContainerElement.Object;
			beanTwo.ContentContainer = mockContainerElement.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same web driver and " + 
				"content container references");

			beanOne = new ContentContainerBean();
			beanTwo = new ContentContainerBean();

			beanOne.ContentContainer = mockContainerElement.Object;
			beanTwo.ContentContainer = mockContainerElement.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null web driver references " +
				"and the same content container reference");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("ContentContainerBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebDriver> mockDriver = new Mock<IWebDriver>();
			Mock<IWebElement> mockContainerElement = new Mock<IWebElement>();

			IContentContainerBean bean = new ContentContainerBean();
			bean.Driver = mockDriver.Object;
			bean.ContentContainer = mockContainerElement.Object;

			Assert.AreEqual(bean.ToString(), "ContentContainerBean(LoadableBean(Driver: " + 
				mockDriver.Object.ToString() + ", LoadTimeout: 30), " + "ContentContainer: " + 
				mockContainerElement.Object.ToString() + ")");
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("ContentContainerBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IContentContainerBean bean = new ContentContainerBean();
			IContentContainerBean beanToCompare = new ContentContainerBean();

			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have not had " + 
				"setters called should be equal, but are not: " + bean.ToString() + ", " + beanToCompare.ToString());

			Mock<IWebDriver> mockDriver = new Mock<IWebDriver>();

			bean.Driver = mockDriver.Object;
			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"different values for their driver fields should not be equal, but are: " + bean.ToString() + ", " +
				beanToCompare.ToString());

			beanToCompare.Driver = mockDriver.Object;
			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have the " + 
				"same driver should be equal, but are not: " + bean.ToString() + ", " + beanToCompare.ToString());

			beanToCompare.LoadTimeout = 200;
			Assert.AreNotEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have " + 
				"different values for their load timeout fields should not be equal, but are: " + bean.ToString() + 
				", " + beanToCompare.ToString());

			bean.LoadTimeout = 200;
			Assert.AreEqual(bean.GetHashCode(), beanToCompare.GetHashCode(), "Hash codes for bean which have the " + 
				"same driver and load timeout should be equal, but are not: " + bean.ToString() + ", " + 
				beanToCompare.ToString());
		}
	}
}

