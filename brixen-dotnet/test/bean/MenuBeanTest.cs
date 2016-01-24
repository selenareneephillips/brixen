using System;
using NUnit.Framework;
using OpenQA.Selenium;
using Moq;
using System.Collections.Generic;

namespace Org.Brixen.Bean.Tests {

	[TestFixture]
	[Category("MenuBeanTestGroup")]
	public class MenuBeanTest {
		
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("MenuBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot invoke setter for " + 
			"OptionElements property with a null parameter", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForNullOptionElements() {
			IMenuBean bean = new MenuBean();
			bean.OptionElements = null;
		}

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("MenuBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebElement> mockElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockElementTwo = new Mock<IWebElement>();

			IMenuBean beanOne = new MenuBean();
			IMenuBean beanTwo = new MenuBean();

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
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("MenuBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IMenuBean beanOne = new MenuBean();
			IMenuBean beanTwo = new MenuBean();

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

			beanOne = new MenuBean();
			beanTwo = new MenuBean();

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

			beanOne = new MenuBean();
			beanTwo = new MenuBean();

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
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("MenuBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			IMenuBean bean = new MenuBean();
			bean.ContentContainer = mockElement.Object;

			Assert.AreEqual("MenuBean(ContentContainerBean(LoadableBean(Driver: null, LoadTimeout: 30), " + 
				"ContentContainer: " + mockElement.Object.ToString() + "), ClickOptionWithJavascript: False, " + 
				"OptionElements: System.Collections.Generic.List`1[OpenQA.Selenium.IWebElement])", bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("MenuBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IMenuBean bean = new MenuBean();
			IMenuBean beanToCompare = new MenuBean();

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
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("MenuBeanHashCodeEqualityNegativeTestGroup")]
		public void HashCodesShouldNotBeEqual() {
			Mock<IWebElement> mockElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockElementTwo = new Mock<IWebElement>();

			IMenuBean beanOne = new MenuBean();
			IMenuBean beanTwo = new MenuBean();

			beanOne.ContentContainer = mockElementOne.Object;
			beanTwo.ContentContainer = mockElementTwo.Object;

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Beans with different container element " + 
				"references should have different hash codes");

			beanTwo.ContentContainer = mockElementOne.Object;

			IList<IWebElement> optionsListOne = new List<IWebElement>();
			IList<IWebElement> optionsListTwo = new List<IWebElement>();
			Mock<IWebElement> mockOptionElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockOptionElementTwo = new Mock<IWebElement>();

			optionsListOne.Add(mockOptionElementOne.Object);
			optionsListTwo.Add(mockOptionElementTwo.Object);
			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Beans with different lists of option " + 
				"elements should have different hash codes");

			beanTwo.OptionElements = optionsListOne;
			beanOne.ClickOptionWithJavascript = true;

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Beans with different Javascript click " + 
				"workaround values should have different hash codes");
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("MenuBeanHashCodeEqualityPositiveTestGroup")]
		public void HashCodesShouldBeEqual() {
			IMenuBean beanOne = new MenuBean();
			IMenuBean beanTwo = new MenuBean();

			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			beanOne.ContentContainer = mockElement.Object;
			beanTwo.ContentContainer = mockElement.Object;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they have the same container element reference and same default JavaScript click " + 
				"workaround value");

			beanOne.ClickOptionWithJavascript = true;
			beanTwo.ClickOptionWithJavascript = true;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they have the same container element reference and same non-default JavaScript click " + 
				"workaround value");

			beanOne = new MenuBean();
			beanTwo = new MenuBean();

			beanOne.ClickOptionWithJavascript = true;
			beanTwo.ClickOptionWithJavascript = true;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they have null container element references and same non-default JavaScript click " + 
				"workaround value");

			beanOne.ContentContainer = mockElement.Object;
			beanTwo.ContentContainer = mockElement.Object;

			List<IWebElement> optionsListOne = new List<IWebElement>();
			List<IWebElement> optionsListTwo = new List<IWebElement>();
			Mock<IWebElement> mockOptionElement = new Mock<IWebElement>();

			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListOne;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they have the same contrainer element references and the same empty option elements list " + 
				"reference");

			optionsListOne.Add(mockOptionElement.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they have the same contrainer element references and the same non-empty option elements " + 
				"list reference");

			optionsListTwo.Add(mockOptionElement.Object);
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they have the same contrainer element references and two non-empty option elements list " +
				"references containing the same object");

			optionsListOne = new List<IWebElement>();
			optionsListTwo = new List<IWebElement>();

			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they have the same container element and two different empty option element list references");

			beanOne = new MenuBean();
			beanTwo = new MenuBean();

			beanOne.OptionElements = optionsListOne;
			beanTwo.OptionElements = optionsListTwo;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they both have null container element references and two different empty option element " + 
				"list references");

			beanTwo.OptionElements = optionsListOne;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they both have null container element references and the same empty option elements list " + 
				"reference");

			beanTwo.OptionElements = optionsListTwo;
			optionsListOne.Add(mockOptionElement.Object);
			optionsListTwo.Add(mockOptionElement.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "The hash codes for two beans should be " + 
				"equal if they both have null container element references and two non-empty option elements list " + 
				"references containing the same object");
		}	
	}
}

