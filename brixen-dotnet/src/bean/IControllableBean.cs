using System;
using OpenQA.Selenium;
using System.Collections.Generic;

namespace Org.Brixen.Bean {

	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
	/// component that contains web controls that have meaningful side effects whenever they are clicked and/or moused 
	/// over.
	/// </summary>
	public interface IControllableBean {

		/// <summary>
		/// Adds an <c>IClickControlBean</c> to specify an <c>IClickControl</c> to add to the page object.
		/// <para>
		/// This method will use the default implementation of <c>IClickControlBean</c>: <c>ClickControlBean</c>.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the <c>IClickControl</c> to add to the page object.</param>
		void AddClickControl(string name);

		/// <summary>
		/// Adds an <c>IHoverControlBean</c> to specify an <c>IHoverControl</c> to add to the page object.
		/// <para>
		/// This method will use the default implementation of <c>IHoverControlBean</c>: <c>HoverControlBean</c>.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the <c>IHoverControl</c> to add to the page object.</param>
		void AddHoverControl(string name);

		/// <summary>
		/// Adds an <c>IHoverAndClickControlBean</c> to specify an <c>IHoverAndClickControl</c> to add to the page 
		/// object.
		/// <para>
		/// This method will use the default implementation of <c>IHoverAndClickControlBean</c>: 
		/// <c>HoverAndClickControlBean</c>.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the <c>IHoverAndClickControl</c> to add to the page object.</param>
		void AddHoverAndClickControl(string name);

		/// <summary>
		/// Adds an <c>IClickControlBean</c> of the specified implementation to specify an <c>IClickControl</c> to add 
		/// to the page object.
		/// </summary>
		/// <param name="name">The name of the <c>IClickControl</c> to add to the page object.</param>
		/// <param name="bean">The <c>IClickControlBean</c> to specify the <c>IClickControl</c></param>
		/// <typeparam name="BeanT">The implementation of <c>IClickControlBean</c> to use for specifying the 
		/// <c>IClickControl</c>.</typeparam>
		void AddClickControl<BeanT>(string name,  BeanT bean) where BeanT : IClickControlBean;

		/// <summary>
		/// Adds an <c>IHoverControlBean</c> of the specified implementation to specify an <c>IHoverControl</c> to add 
		/// to the page object.
		/// </summary>
		/// <param name="name">The name of the <c>IHoverControl</c> to add to the page object.</param>
		/// <param name="bean">The <c>IHoverControlBean</c> to specify the <c>IHoverControl</c></param>
		/// <typeparam name="BeanT">The implementation of <c>IHoverControlBean</c> to use for specifying the 
		/// <c>IHoverControl</c>.</typeparam>
		void AddHoverControl<BeanT>(string name, BeanT bean) where BeanT : IHoverControlBean;

		/// <summary>
		/// Adds an <c>IHoverAndClickControlBean</c> of the specified implementation to specify an 
		/// <c>IHoverAndClickControl</c> to add to the page object.
		/// </summary>
		/// <param name="name">The name of the <c>IHoverAndCLickControl</c> to add to the page object.</param>
		/// <param name="bean">The <c>IHoverAndClickControlBean</c> to specify the <c>IHoverAndClickControl</c></param>
		/// <typeparam name="BeanT">The implementation of <c>IHoverAndClickControlBean</c> to use for specifying the 
		/// <c>IHoverAndClickControl</c>.</typeparam>
		void AddHoverAndClickControl<BeanT>(string name, BeanT bean) where BeanT : IHoverAndClickControlBean;

		/// <summary>
		/// Sets the driver to use for browsing the specified web control.
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="driver">The driver to use for browsing the page object.</param>
		void SetControlDriver(string name, IWebDriver driver);

		/// <summary>
		/// Sets the load timeout in seconds for specified web control.
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="timeout">The load timeout in seconds for the web control.</param>
		void SetControlLoadTimeout(string name, int timeout);

		/// <summary>
		/// Sets the <c>IWebElement</c> that contains the specified web control.
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="contentContainer">The <c>IWebElement</c> that contains the specified web control.</param>
		void SetControlContentContainer(string name, IWebElement contentContainer);

		/// <summary>
		/// Sets the timeout in seconds for polling the specified web control to determine if an expected condition has 
		/// been satisfied.
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="timeout">The timeout in seconds for polling the web control to determine if an expected 
		/// condition has been satisfied.</param>
		void SetControlPollingTimeout(string name, int timeout);

		/// <summary>
		/// Sets the polling interval in seconds for polling the specified web control to determine if an expected 
		/// condition has been satisfied.
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="interval">The interval in seconds for polling the web control to determine if an expected 
		/// condition has been satisfied.</param>
		void SetControlPollingInterval(string name, int interval);

		/// <summary>
		/// Sets the element to send the focus to when unhovering the specified web control.
		/// <para>
		/// The unhover <c>IWebElement</c> should be carefully chosen to ensure that any content that is rendered 
		/// visible by mousing over the specified web control is rendered invisible and that the mouseover action on 
		/// the unhover <c>IWebElement</c> does not trigger visibility for any other content panes that you wish to 
		/// remain hidden.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="unhoverElement">The <c>IWebElement</c> to hover over in order to unhover the specified control 
		/// by ensuring that mouse focus is completely removed from it.</param>
		void SetControlUnhoverElement(string name, IWebElement unhoverElement);

		/// <summary>
		/// Enables or disables the Javascript hover workaround for the specified web control.
		/// <para>
		/// Enabling the Javascript hover workaround will invoke a mouseover action on the web control with Javascript
		/// rather than using <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> method. This is 
		/// useful in circumstances where the mouseover function fails silently, that is the 
		/// <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> runs without throwing any 
		/// <c>Exceptions</c>, but the element is not really moused over.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="hoverWithJavascript">If <c>true</c>, enables the Javascript hover workaround workaround; if 
		/// <c>false</c>, disables it.</param>
		void SetHoverControlWithJavascript(string name, bool hoverWithJavascript);

		/// <summary>
		/// Enables or disables the Javascript hover workaround for the unhover element for the specified web control.
		/// <para>
		/// The unhover element is used to focus the mouse in a safe location away from the web control. Enabling the
		/// Javascript hover workaround will invoke a mouse over action on the unhover element with Javascript rather 
		/// than using <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> method. This is useful 
		/// in circumstances where the mouse over function fails silently, that is the 
		/// <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> runs without throwing any 
		/// <c>Exceptions</c>, but the element is not really moused over.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="unhoverWithJavascript">If <c>true</c>, enables the Javascript hover workaround workaround for 
		/// the unhover element; if <c>false</c>, disables it.</param>
		void SetUnhoverControlWithJavascript(string name, bool unhoverWithJavascript);

		/// <summary>
		/// Enables or disables the Javascript click workaround for the specified web control.
		/// <para>
		/// Enabling the Javascript click workaround will invoke a 'click' on the web control with Javascript
		/// rather than using <see cref="OpenQA.Selenium.IWebElement.Click()"/>  method. This is useful in 
		/// circumstances where clicks fail silently, that is <see cref="OpenQA.Selenium.IWebElement.Click()"/> runs 
		/// without throwing any <c>Exceptions</c>, but the element is not really clicked.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="clickWithJavascript">If <c>true</c>, enables the Javascript click workaround workaround; if 
		/// <c>false</c>, disables it.</param>
		void SetClickControlWithJavascript(string name, bool clickWithJavascript);

		/// <summary>
		/// Enables or disables the <see cref="OpenQA.Selenium.IWebElement.Click()"/> action workaround for forcing the 
		/// mouse to focus on the specified web control.
		/// <para>
		/// Note: It is best to use this in situations where both the 
		/// <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> method and the Javascript hover 
		/// workaround fail silently, that is <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> 
		/// and the Javascript hover workaround run without throwing any <c>Exceptions</c>, but the element is not 
		/// really moused over. This will allow automation of test cases which are dependent on the side effects 
		/// generated by the hover action, but are not related to testing that the hover action alone triggers the 
		/// desired side effects. In such cases, it would be prudent to manually test the hover action alone in the 
		/// environment(s) where neither the <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> 
		/// nor the Javascript hover workaround trigger the mouseover event and the expected side effect(s).
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="clickInsteadOfHover">If <c>true</c>, enables the 
		/// <see cref="OpenQA.Selenium.IWebElement.Click()"/> action workaround workaround workaround; if <c>false</c>, 
		/// disables it.</param>
		void SetClickControlInsteadOfHover(string name, bool clickInsteadOfHover);

		/// <summary>
		/// Enables or disables the Javascript click action workaround for the specified web control.
		/// <para>
		/// Note: It is best to use this in situations where the 
		/// <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> method, the Javascript hover
		/// workaround and the <see cref="OpenQA.Selenium.IWebElement.Click()"/> method all fail silently, that is they 
		/// all run without throwing any <c>Exceptions</c>, but the element is not really moused over or clicked.
		/// </para>
		/// For an <see cref="IHoverControl"/>, this will allow automation of test cases which are dependent on the 
		/// side effects generated by the hover action, but are not related to testing that the hover action alone 
		/// triggers the desired side effects. In such cases, it would be prudent to manually test the hover action 
		/// alone in the environment(s) where neither the 
		/// <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> nor the Javascript hover 
		/// workaround trigger the mouseover event and the expected side effect(s).
		/// <para>
		/// For an <see cref="IHoverAndClickControl"/>, this will help in situations where a hover cannot be executed 
		/// to make the control visible because usually, a Javascript click will successfully click an element that is 
		/// not visible, and this will allow automation of test cases which are dependent on the side effects generated 
		/// by the click action, but are not related to testing that the hover action makes the web control visible. In 
		/// such cases, it would be prudent to manually test the hover action alone in the environment(s) where neither 
		/// the <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> nor the Javascript hover 
		/// workaround trigger the mouseover event that makes the control visible.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="clickWithJavascriptInsteadOfHover">If <c>true</c>, enables the Javascript click action 
		/// workaround; if <c>false</c>, disables it.</param>
		void SetClickControlWithJavascriptInsteadOfHover(string name, bool clickWithJavascriptInsteadOfHover);

		/// <summary>
		/// Enables or disables the <see cref="OpenQA.Selenium.IWebElement.Click()"/> action workaround for the unhover 
		/// element which is used to focus the mouse in a safe location away from the specified web control.
		/// <para>
		/// Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects 
		/// and serves only to force the mouse away from the web control. This action is riskier than hovering the 
		/// mouse over the unhover element, so it should be used in situations where the 
		/// <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> method and the Javascript hover 
		/// workaround fail silently, that is <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> 
		/// and the Javascript hover workaround run without throwing any <c>Exceptions</c>, but the element is not 
		/// really moused over.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="unhoverWithClickInstead">If <c>true</c>, enables the 
		/// <see cref="OpenQA.Selenium.IWebElement.Click()"/> action workaround for the unhover element; if 
		/// <c>false</c>, disables it.</param>
		void SetUnhoverControlWithClickInstead(string name, bool unhoverWithClickInstead);

		/// <summary>
		/// Enables or disables the Javascript click action workaround for the unhover element which is used to focus 
		/// the mouse in a safe location away from the specified web control.
		/// <para>
		/// Care should be taken to ensure that clicking on the unhover element does not trigger undesired side effects 
		/// and serves only to force the mouse away from the web control. This action is riskier than hovering the 
		/// mouse over the unhover element, so it should be used in situations where the 
		/// <cref="OpenQA.Selenium.Interactions.Actions.MoveToElement(IWebElement)"/> method, the Javascript hover 
		/// workaround and the <see cref="OpenQA.Selenium.IWebElement.Click()"/> method fail silently, that is they run 
		/// without throwing any <c>Exceptions</c>, but the element is not really moused over or clicked.
		/// </para>
		/// </summary>
		/// <param name="name">The name of the web control.</param>
		/// <param name="unhoverWithJavascriptClickInstead">If <c>true</c>, enables the Javascript click action 
		/// workaround for the unhover element; if <c>false</c>, disables it.</param>
		void SetUnhoverControlWithJavascriptClickInstead(string name, bool unhoverWithJavascriptClickInstead);

		/// <summary>
		/// Returns the collection of <c>IControlBeans</c> that specify the web controls for the page object as a 
		/// <c>Dictionary</c> where the names of the web controls are the keys.
		/// </summary>
		/// <returns>The collection of <c>IControlBeans</c> that specify the web controls for the page object as a 
		/// <c>Dictionary</c> where the names of the web controls are the keys.</returns>
		Dictionary<String,IControlBean> getControlBeans();
	}
}

