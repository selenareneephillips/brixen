using System;
using NUnit.Framework;
using OpenQA.Selenium;
using System.Collections.Generic;
using Moq;

namespace Org.Brixen.Bean.Tests
{
	[TestFixture]
	[Category("ControllableBeanTestGroup")]
	public class ControllableBeanTest {

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with name that is "+ 
			"null", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddClickControlWithNullName() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl(null);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with name that is "+ 
			"null", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddClickControlWithNullName() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl(null, new ClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with name that is "+ 
			"null", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverControlWithNullName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl(null);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with name that is "+ 
			"null", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverControlWithNullName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl(null, new HoverControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with name that is "+ 
			"null", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverAndClickControlWithNullName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl(null);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with name that is "+ 
			"null", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverAndClickControlWithNullName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl(null, new HoverAndClickControlBean());
		}
			
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddClickControlWithEmptyName() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddClickControlWithEmptyName() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("", new ClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverControlWithEmptyName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverControlWithEmptyName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("", new HoverControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverAndClickControlWithEmptyName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverAndClickControlWithEmptyName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("", new HoverAndClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddClickControlWithWhitespaceName() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("  ");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddClickControlWithWhitespaceName() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("   ", new ClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverControlWithWhitespaceName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("   ");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverControlWithWhitespaceName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("   ", new HoverControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverAndClickControlWithWhitespaceName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("   ");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "Cannot add a control with a name that is " + 
			"empty or all whitespace", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverAndClickControlWithWhitespaceName() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("   ", new HoverAndClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddClickControlWithNameMatchingExistingClickControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.AddClickControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddClickControlWithNameMatchingExistingClickControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.AddClickControl("name", new ClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddClickControlWithNameMatchingExistingHoverControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name");
			bean.AddClickControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddClickControlWithNameMatchingExistingHoverControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name");
			bean.AddClickControl("name", new ClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddClickControlWithNameMatchingExistingHoverAndClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name");
			bean.AddClickControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddClickControlWithNameMatchingExistingHoverAndClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name");
			bean.AddClickControl("name", new ClickControlBean());
		}
			
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverControlWithNameMatchingExistingClickControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.AddHoverControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverControlWithNameMatchingExistingClickControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.AddHoverControl("name", new HoverControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverControlWithNameMatchingExistingHoverControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name");
			bean.AddHoverControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverControlWithNameMatchingExistingHoverControlMapping() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name");
			bean.AddHoverControl("name", new HoverControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverControlWithNameMatchingExistingHoverAndClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name");
			bean.AddHoverControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverControlWithNameMatchingExistingHoverAndClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name");
			bean.AddHoverControl("name", new HoverControlBean());
		}
			
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverAndClickControlWithNameMatchingExistingClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.AddHoverAndClickControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverAndClickControlWithNameMatchingExistingClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.AddHoverAndClickControl("name", new HoverAndClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForOneParamAddHoverAndClickControlWithNameMatchingExistingHoverControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name");
			bean.AddHoverAndClickControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamAddHoverAndClickControlWithNameMatchingExistingHoverControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name");
			bean.AddHoverAndClickControl("name", new HoverAndClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void 
		ShouldThrowExceptionForOneParamAddHoverAndClickControlWithNameMatchingExistingHoverAndClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name");
			bean.AddHoverAndClickControl("name");
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is already a control named name", 
			MatchType=MessageMatch.Regex)]
		public void 
		ShouldThrowExceptionForTwoParamAddHoverAndClickControlWithNameMatchingExistingHoverAndClickControlMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name");
			bean.AddHoverAndClickControl("name", new HoverAndClickControlBean());
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with a null state " + 
			"bean", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamClickControlWithNullBean() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name", (IClickControlBean)null);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with a null state " + 
			"bean", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamHoverControlWithNullBean() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name", (IHoverControlBean)null);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot add a control with a null state " + 
			"bean", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForTwoParamHoverAndClickControlWithNullBean() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name", (IHoverAndClickControlBean)null);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingDriverToControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			Mock<IWebDriver> driver = new Mock<IWebDriver>();
			bean.SetControlDriver("name", driver.Object);
		}	

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingContentContainerToControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			Mock<IWebElement> contentContainer = new Mock<IWebElement>();
			bean.SetControlContentContainer("name", contentContainer.Object);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingPollingTimeoutToControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetControlPollingTimeout("name", 50);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingPollingIntervalToControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetControlPollingInterval("name", 50);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"polleable control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingPollingTimeoutToClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl ("name");
			bean.SetControlPollingTimeout("name", 50);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"polleable control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingPollingIntervalToClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl ("name");
			bean.SetControlPollingInterval("name", 50);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"polleable control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingPollingTimeoutToHoverControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl ("name");
			bean.SetControlPollingTimeout("name", 50);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"polleable control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingPollingIntervalToHoverControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl ("name");
			bean.SetControlPollingInterval("name", 50);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingLoadTimeoutToControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetControlLoadTimeout("name", 50);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingUnhoverElementToControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			Mock<IWebElement> unhoverElement = new Mock<IWebElement>();
			bean.SetControlUnhoverElement("name", unhoverElement.Object);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover or a hover and click control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForAddingUnhoverElementToClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			Mock<IWebElement> unhoverElement = new Mock<IWebElement>();
			bean.SetControlUnhoverElement("name", unhoverElement.Object);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingHoverWithJavascriptForControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetHoverControlWithJavascript("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover or a hover and click control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingHoverWithJavascriptForClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.SetHoverControlWithJavascript("name", true);
		}
			
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingUnhoverWithJavascriptForControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetUnhoverControlWithJavascript("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover or a hover and click control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingUnhoverWithJavascriptForClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.SetUnhoverControlWithJavascript("name", true);
		}
			
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingClickWithJavascriptForControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetClickControlWithJavascript("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"click or a hover and click control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingClickWithJavascriptForHoverControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverControl("name");
			bean.SetClickControlWithJavascript("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingClickInsteadOfHoverForControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetClickControlInsteadOfHover("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingClickInsteadOfHoverForClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.SetClickControlInsteadOfHover("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingClickInsteadOfHoverForHoverAndClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddHoverAndClickControl("name");
			bean.SetClickControlInsteadOfHover("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingClickWithJavascriptInsteadOfHoverForControlWithNameThatHasNoMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.SetClickControlWithJavascriptInsteadOfHover("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover or a hover and click control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingClickWithJavascriptInsteadOfHoverForClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.SetClickControlWithJavascriptInsteadOfHover("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingUnhoverWithClickInsteadForControlWithNameThatHasNoMapping() {
			IControllableBean bean = new ControllableBean();
			bean.SetUnhoverControlWithClickInstead("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover or a hover and click control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingUnhoverWithClickInsteadForClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.SetUnhoverControlWithClickInstead("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentException", ExpectedMessage = "There is no control named name", 
			MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingUnhoverWithJavascriptClickInsteadForControlWithNameThatHasNoMapping() 
		{
			IControllableBean bean = new ControllableBean();
			bean.SetUnhoverControlWithJavascriptClickInstead("name", true);
		}

		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("BeanExpectedExceptionsTestGroup")]
		[Category("ControllableBeanExpectedExceptionsTestGroup")]
		[ExpectedException("System.InvalidOperationException", ExpectedMessage = "The control named name is not a " + 
			"hover or a hover and click control", MatchType=MessageMatch.Regex)]
		public void ShouldThrowExceptionForSettingUnhoverWithJavascriptClickInsteadForClickControl() {
			IControllableBean bean = new ControllableBean();
			bean.AddClickControl("name");
			bean.SetUnhoverControlWithJavascriptClickInstead("name", true);
		}

		[Test]
		[Category("EqualityNegativeTestGroup")]
		[Category("BeanEqualityNegativeTestGroup")]
		[Category("ControllableBeanEqualityNegativeTestGroup")]
		public void ShouldNotBeEqual() {
			Mock<IWebElement> mockElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockElementTwo = new Mock<IWebElement>();

			IControllableBean beanOne = new ControllableBean();
			IControllableBean beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockElementOne.Object;
			beanTwo.ContentContainer = mockElementTwo.Object;

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with different container element references should not be " + 
				"equal");

			beanTwo.ContentContainer = mockElementOne.Object;

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockElementOne.Object;
			beanTwo.ContentContainer = mockElementOne.Object;

			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();

			clickControlBeanOne.ContentContainer = mockElementTwo.Object;
			clickControlBeanTwo.ContentContainer = mockElementTwo.Object;
			clickControlBeanOne.ClickWithJavascript = true;

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they have the same container " + 
				"element reference and different click control bean instance mapped to the same name which have the " + 
				"same content container reference but different Javascript click workaround values");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddClickControl("clickControlOne", clickControlBeanOne);
			beanTwo.AddClickControl("clickControlTwo", clickControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same click control bean instance mapped to " + 
				"different names should not be equal");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			IHoverControlBean hoverControlBeanOne = new HoverControlBean();
			IHoverControlBean hoverControlBeanTwo = new HoverControlBean();

			hoverControlBeanOne.ContentContainer = mockElementTwo.Object;
			hoverControlBeanTwo.ContentContainer = mockElementTwo.Object;
			hoverControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverControl("hoverControl", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControl", hoverControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they have the same container " + 
				"element reference and different hover control bean instance mapped to the same name which have the " + 
				"same content container reference but different Javascript hover workaround values");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverControl("hoverControlOne", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControlTwo", hoverControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same hover control bean instance mapped to " + 
				"different names should not be equal");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			IHoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBean();

			hoverAndClickControlBeanOne.ContentContainer = mockElementTwo.Object;
			hoverAndClickControlBeanTwo.ContentContainer = mockElementTwo.Object;
			hoverAndClickControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

			Assert.AreNotEqual(beanOne, beanTwo, "Two beans should not be equal if they have the same container " + 
				"element reference and different hover and click control bean instance mapped to the same name which " + 
				"have the same content container reference but different Javascript hover workaround values");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverAndClickControl("hoverAndClickControlOne", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("hoverAndClickControlTwo", hoverAndClickControlBeanOne);

			Assert.AreNotEqual(beanOne, beanTwo, "Beans with the same hover and click control bean instance mapped " + 
				"to different names should not be equal");
		}

		[Test]
		[Category("EqualityPositiveTestGroup")]
		[Category("BeanEqualityPositiveTestGroup")]
		[Category("ControllableBeanEqualityPositiveTestGroup")]
		public void ShouldBeEqual() {
			IControllableBean beanOne = new ControllableBean();
			IControllableBean beanTwo = new ControllableBean();

			Assert.AreEqual(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are " + 
				"invoked");

			Mock<IWebElement> mockContainerElementOne = new Mock<IWebElement>();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same default JavaScript click workaround value");

			Mock<IClickControlBean> mockClickControlBean = new Mock<IClickControlBean>();
			beanOne.AddClickControl("name", mockClickControlBean.Object);
			beanTwo.AddClickControl("name", mockClickControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same click control bean instance mapped to the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();

			Mock<IWebElement> mockContainerElementTwo = new Mock<IWebElement>();

			clickControlBeanOne.ContentContainer = mockContainerElementTwo.Object;
			clickControlBeanTwo.ContentContainer = mockContainerElementTwo.Object;
			clickControlBeanOne.ClickWithJavascript = true;
			clickControlBeanTwo.ClickWithJavascript = true;

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and different click control bean instance mapped to the same name which have the same " + 
				"content container reference and the same non-default Javascript click workaround value");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container element " + 
				"references and different click control bean instances mapped to the same name, but which have " + 
				"the same content container reference and the same non-default Javascript click workaround value");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddClickControl("name", mockClickControlBean.Object);
			beanTwo.AddClickControl("name", mockClickControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container element " + 
				"references and same click control bean instance mapped to the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			Mock<IHoverControlBean> mockHoverControlBean = new Mock<IHoverControlBean>();
			beanOne.AddHoverControl("name", mockHoverControlBean.Object);
			beanTwo.AddHoverControl("name", mockHoverControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same hover control bean instance mapped to the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			IHoverControlBean hoverControlBeanOne = new HoverControlBean();
			IHoverControlBean hoverControlBeanTwo = new HoverControlBean ();

			hoverControlBeanOne.ContentContainer = mockContainerElementTwo.Object;
			hoverControlBeanTwo.ContentContainer = mockContainerElementTwo.Object;
			hoverControlBeanOne.ClickInsteadOfHover = true;
			hoverControlBeanTwo.ClickInsteadOfHover = true;

			beanOne.AddHoverControl("name", hoverControlBeanOne);
			beanTwo.AddHoverControl("name", hoverControlBeanTwo);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and different hover control bean instances mapped to the same name which have the same " + 
				"content container reference and the same non-default click instead of hover workaround value");
			
			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverControl("name", mockHoverControlBean.Object);
			beanTwo.AddHoverControl("name", mockHoverControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container element " + 
				"references and same hover control bean instance mapped to the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			Mock<IHoverAndClickControlBean> mockHoverAndClickControlBean = new Mock<IHoverAndClickControlBean>();
			beanOne.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);
			beanTwo.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and same hover and click control bean instance mapped to the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			IHoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBean();

			hoverAndClickControlBeanOne.ContentContainer = mockContainerElementTwo.Object;
			hoverAndClickControlBeanTwo.ContentContainer = mockContainerElementTwo.Object;
			hoverAndClickControlBeanOne.ClickWithJavascript = true;
			hoverAndClickControlBeanTwo.ClickWithJavascript = true;

			beanOne.AddHoverAndClickControl("name", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("name", hoverAndClickControlBeanTwo);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have the same container element " + 
				"reference and different hover and click control bean instance mapped to the same name which have " + 
				"the same content container reference and the same non-default Javascript click instead of hover " + 
				"workaround value");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);
			beanTwo.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);

			Assert.AreEqual(beanOne, beanTwo, "Two beans should be equal if they have null container element " + 
				"references and same hover and click control bean instance mapped to the same name");
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("BeanToStringCallsBaseTestGroup")]
		[Category("ControllableBeanToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {
			Mock<IWebElement> mockElement = new Mock<IWebElement>();

			IControllableBean bean = new ControllableBean();
			bean.ContentContainer = mockElement.Object;

			Assert.AreEqual("ControllableBean(ContentContainerBean(LoadableBean(Driver: null, LoadTimeout: 30), " + 
				"ContentContainer: " + mockElement.Object.ToString() + "), Control Beans: " + 
				"System.Collections.Generic.Dictionary`2[System.String,Org.Brixen.Bean.IControlBean])", 
				bean.ToString());
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("ControllableBeanHashCodeCallsSuperTestGroup")]
		public void ShouldCallBaseForHashCode() {
			IControllableBean bean = new ControllableBean();
			IControllableBean beanToCompare = new ControllableBean();

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
		[Category("ControllableBeanHashCodeEqualityNegativeTestGroup")]
		public void HashCodesShouldNotBeEqual() {
			Mock<IWebElement> mockElementOne = new Mock<IWebElement>();
			Mock<IWebElement> mockElementTwo = new Mock<IWebElement>();

			IControllableBean beanOne = new ControllableBean();
			IControllableBean beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockElementOne.Object;
			beanTwo.ContentContainer = mockElementTwo.Object;

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Beans with different container element " + 
				"references should have different hash codes");

			beanTwo.ContentContainer = mockElementOne.Object;

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockElementOne.Object;
			beanTwo.ContentContainer = mockElementOne.Object;

			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();

			clickControlBeanOne.ContentContainer = mockElementTwo.Object;
			clickControlBeanTwo.ContentContainer = mockElementTwo.Object;
			clickControlBeanOne.ClickWithJavascript = true;

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have difference hash " + 
				"codes if they have the same container element reference and different click control bean instance " + 
				"mapped to the same name which have the same content container reference but different Javascript " + 
				"click workaround values");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddClickControl("clickControlOne", clickControlBeanOne);
			beanTwo.AddClickControl("clickControlTwo", clickControlBeanOne);

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Beans with the same click control " + 
				"bean instance mapped to different names should have different hash codes");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			IHoverControlBean hoverControlBeanOne = new HoverControlBean();
			IHoverControlBean hoverControlBeanTwo = new HoverControlBean();

			hoverControlBeanOne.ContentContainer = mockElementTwo.Object;
			hoverControlBeanTwo.ContentContainer = mockElementTwo.Object;
			hoverControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverControl("hoverControl", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControl", hoverControlBeanTwo);

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have different hash " + 
				"codes  if they have the same container element reference and different hover control bean instance " + 
				"mapped to the same name which have the same content container reference but different Javascript " + 
				"hover workaround values");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverControl("hoverControlOne", hoverControlBeanOne);
			beanTwo.AddHoverControl("hoverControlTwo", hoverControlBeanOne);

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Beans with the same hover control bean " + 
				"instance mapped to different names should have different hash codes");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			IHoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBean();

			hoverAndClickControlBeanOne.ContentContainer = mockElementTwo.Object;
			hoverAndClickControlBeanTwo.ContentContainer = mockElementTwo.Object;
			hoverAndClickControlBeanOne.HoverWithJavascript = true;

			beanOne.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("hoverAndClickControl", hoverAndClickControlBeanTwo);

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have different hash " + 
				"codes if they have the same container element reference and different hover and click control bean " + 
				"instance mapped to the same name which have the same content container reference but different " + 
				"Javascript hover workaround values");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverAndClickControl("hoverAndClickControlOne", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("hoverAndClickControlTwo", hoverAndClickControlBeanOne);

			Assert.AreNotEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Beans with the same hover and click " + 
				"control bean instance mapped to different names should have different hash codes");
		}

		[Test]
		[Category("HashCodeCallsSuperTestGroup")]
		[Category("BeanHashCodeCallsSuperTestGroup")]
		[Category("ControllableBeanHashCodeEqualityPositiveTestGroup")]
		public void HashCodesShouldBeEqual() {
			IControllableBean beanOne = new ControllableBean();
			IControllableBean beanTwo = new ControllableBean();

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two newly constructed beans should have " + 
				"the same hash code before any setters are invoked");

			Mock<IWebElement> mockContainerElementOne = new Mock<IWebElement>();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have the same container element reference and same default JavaScript click workaround value");

			Mock<IClickControlBean> mockClickControlBean = new Mock<IClickControlBean>();
			beanOne.AddClickControl("name", mockClickControlBean.Object);
			beanTwo.AddClickControl("name", mockClickControlBean.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have the same container element reference and same click control bean instance mapped to " + 
				"the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			IClickControlBean clickControlBeanOne = new ClickControlBean();
			IClickControlBean clickControlBeanTwo = new ClickControlBean();

			Mock<IWebElement> mockContainerElementTwo = new Mock<IWebElement>();

			clickControlBeanOne.ContentContainer = mockContainerElementTwo.Object;
			clickControlBeanTwo.ContentContainer = mockContainerElementTwo.Object;
			clickControlBeanOne.ClickWithJavascript = true;
			clickControlBeanTwo.ClickWithJavascript = true;

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have the same container element reference and different click control bean instance mapped " + 
				"to the same name which have the same content container reference and the same non-default "+ 
				"Javascript click workaround value");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddClickControl("name", clickControlBeanOne);
			beanTwo.AddClickControl("name", clickControlBeanTwo);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have null container element references and different click control bean instances mapped to " + 
				"the same name, but which have the same content container reference and the same non-default " + 
				"Javascript click workaround value");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddClickControl("name", mockClickControlBean.Object);
			beanTwo.AddClickControl("name", mockClickControlBean.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have null container element references and same click control bean instance mapped to the " + 
				"same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			Mock<IHoverControlBean> mockHoverControlBean = new Mock<IHoverControlBean>();
			beanOne.AddHoverControl("name", mockHoverControlBean.Object);
			beanTwo.AddHoverControl("name", mockHoverControlBean.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have the same container element reference and same hover control bean instance mapped to " + 
				"the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			IHoverControlBean hoverControlBeanOne = new HoverControlBean();
			IHoverControlBean hoverControlBeanTwo = new HoverControlBean ();

			hoverControlBeanOne.ContentContainer = mockContainerElementTwo.Object;
			hoverControlBeanTwo.ContentContainer = mockContainerElementTwo.Object;
			hoverControlBeanOne.ClickInsteadOfHover = true;
			hoverControlBeanTwo.ClickInsteadOfHover = true;

			beanOne.AddHoverControl("name", hoverControlBeanOne);
			beanTwo.AddHoverControl("name", hoverControlBeanTwo);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have the same container element reference and different hover control bean instances mapped " + 
				"to the same name which have the same content container reference and the same non-default click " + 
				"instead of hover workaround value");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverControl("name", mockHoverControlBean.Object);
			beanTwo.AddHoverControl("name", mockHoverControlBean.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have null container element references and same hover control bean instance mapped to the " + 
				"same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			Mock<IHoverAndClickControlBean> mockHoverAndClickControlBean = new Mock<IHoverAndClickControlBean>();
			beanOne.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);
			beanTwo.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have the same container element reference and same hover and click control bean instance " + 
				"mapped to the same name");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.ContentContainer = mockContainerElementOne.Object;
			beanTwo.ContentContainer = mockContainerElementOne.Object;

			IHoverAndClickControlBean hoverAndClickControlBeanOne = new HoverAndClickControlBean();
			IHoverAndClickControlBean hoverAndClickControlBeanTwo = new HoverAndClickControlBean();

			hoverAndClickControlBeanOne.ContentContainer = mockContainerElementTwo.Object;
			hoverAndClickControlBeanTwo.ContentContainer = mockContainerElementTwo.Object;
			hoverAndClickControlBeanOne.ClickWithJavascript = true;
			hoverAndClickControlBeanTwo.ClickWithJavascript = true;

			beanOne.AddHoverAndClickControl("name", hoverAndClickControlBeanOne);
			beanTwo.AddHoverAndClickControl("name", hoverAndClickControlBeanTwo);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have the same container element reference and different hover and click control bean " + 
				"instance mapped to the same name which have the same content container reference and the same " + 
				"non-default Javascript click instead of hover workaround value");

			beanOne = new ControllableBean();
			beanTwo = new ControllableBean();

			beanOne.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);
			beanTwo.AddHoverAndClickControl("name", mockHoverAndClickControlBean.Object);

			Assert.AreEqual(beanOne.GetHashCode(), beanTwo.GetHashCode(), "Two beans should have the same hash code " + 
				"if they have null container element references and same hover and click control bean instance " + 
				"mapped to the same name");
		}	
	}
}

