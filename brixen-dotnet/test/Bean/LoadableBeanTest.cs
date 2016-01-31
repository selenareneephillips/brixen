using System;
using NUnit.Framework;
using Moq;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using Org.Brixen.Bean;

namespace Org.Brixen.Tests.Bean {

	[TestFixture]
	[Category("LoadableBeanTestGroup")]
	public class LoadableBeanTest {
		
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("LoadableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentOutOfRangeException", ExpectedMessage="Cannot specify a load timeout " + 
			"less than 0 seconds", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForNegativeLoadTimeout() {
			ILoadableBean bean = new LoadableBean();
			bean.LoadTimeout = -1;
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("LoadableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage="Cannot invoke setter for Driver " + 
			"property with a null parameter", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForNullDriver() {
			ILoadableBean bean = new LoadableBean();
			bean.Driver = null;
		}

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("LoadableBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebDriver> mockDriverOne = new Mock<IWebDriver>();
			Mock<IWebDriver> mockDriverTwo = new Mock<IWebDriver>();

			ILoadableBean beanOne = new LoadableBean();
			ILoadableBean beanTwo = new LoadableBean();

			beanOne.Driver = mockDriverOne.Object;
			beanTwo.Driver = mockDriverTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different driver references should not be equal");

			beanOne = new LoadableBean();
			beanTwo = new LoadableBean();

			beanOne.LoadTimeout = 40;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different load timeouts should not be equal");
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("LoadableBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			ILoadableBean beanOne = new LoadableBean();
			ILoadableBean beanTwo = new LoadableBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");
			
			Mock<IWebDriver> mockDriver = new Mock<IWebDriver>();

			beanOne.Driver = mockDriver.Object;
			beanTwo.Driver = mockDriver.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference " +
				"and the default load timeout");

			beanOne.LoadTimeout = 40;
			beanTwo.LoadTimeout = 40;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference " +
				"and the same non-default load timeout");

			beanOne = new LoadableBean();
			beanTwo = new LoadableBean();

			beanOne.LoadTimeout = 40;
			beanTwo.LoadTimeout = 40;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null web driver reference " +
				"and the same non-default load timeout");
		}
	}
}

