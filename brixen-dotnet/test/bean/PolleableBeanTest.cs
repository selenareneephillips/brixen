using System;
using NUnit.Framework;
using Moq;
using OpenQA.Selenium;

namespace Org.Brixen.Bean.Tests
{
	[TestFixture]
	[Category("PolleableBeanTestGroup")]
	public class PolleableBeanTest {
		
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("PolleableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentOutOfRangeException", ExpectedMessage="Cannot specify a polling timeout " + 
			"less than 0 seconds", MatchType=MessageMatch.Regex )]
		public void ShouldThrowExceptionForNegativePollingTimeout() {
			IPolleableBean bean = new PolleableBean();
			bean.PollingTimeout = -1;
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("PolleableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentOutOfRangeException", ExpectedMessage="Cannot specify a polling interval " + 
			"less than 0 seconds", MatchType=MessageMatch.Regex )]
		public void ShouldThrowExceptionForNegativePollingInterval() {
			IPolleableBean bean = new PolleableBean();
			bean.PollingInterval = -1;
		}

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("PolleableBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebDriver> mockDriverOne = new Mock<IWebDriver>();
			Mock<IWebDriver> mockDriverTwo = new Mock<IWebDriver>();

			IPolleableBean beanOne = new PolleableBean();
			IPolleableBean beanTwo = new PolleableBean();

			beanOne.Driver = mockDriverOne.Object;
			beanTwo.Driver = mockDriverTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different driver references should not be equal");

			beanOne = new PolleableBean();
			beanTwo = new PolleableBean();
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
		[Category("PolleableBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IPolleableBean beanOne = new PolleableBean();
			IPolleableBean beanTwo = new PolleableBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IWebDriver> mockDriver = new Mock<IWebDriver>();

			beanOne.Driver = mockDriver.Object;
			beanTwo.Driver = mockDriver.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference " +
				"and the default load timeout");

			beanOne.PollingTimeout = 40;
			beanTwo.PollingTimeout = 40;
			beanOne.PollingInterval = 5;
			beanTwo.PollingInterval = 5;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference " +
				"and the same non-default polling timeout and polling interval");

			beanOne = new PolleableBean();
			beanTwo = new PolleableBean();

			beanOne.PollingTimeout = 40;
			beanTwo.PollingTimeout = 40;
			beanOne.PollingInterval = 5;
			beanTwo.PollingInterval = 5;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null web driver reference " +
				"and the same non-default polling timeout and polling interval");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("PolleableBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebDriver> mockDriver = new Mock<IWebDriver>();

			IPolleableBean bean = new PolleableBean();
			bean.Driver = mockDriver.Object;

			Assert.AreEqual("PolleableBean(LoadableBean(Driver: " + mockDriver.Object.ToString() + 
				", LoadTimeout: 30), " + "PollingTimeout: 30, PollingInterval: 1)", bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("PolleableBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IPolleableBean bean = new PolleableBean();
			IPolleableBean beanToCompare = new PolleableBean();

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

