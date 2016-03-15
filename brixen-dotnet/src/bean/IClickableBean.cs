using System;

namespace Org.Brixen.Bean {

	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
	/// <c>Clickable</c> page object.
	/// </summary>
	public interface IClickableBean : IContentContainerBean {
		
		/// <summary>
		/// Sets or gets the Javascript click workaround flag.
		/// <p>
		/// When the Javascript click workaround is enabled, a 'click' on the wrapped <c>WebElement</c> will be 
		/// performed with Javascript rather than the <see cref="OpenQA.Selenium.IWebElement.Click()">
		/// IWebElement.Click()</see> method. This is useful in circumstances where clicks fail silently, that is 
		/// <see cref="OpenQA.Selenium.IWebElement.Click()">IWebElement.Click()</see> runs without throwing any 
		/// <c>Exceptions</c>, but the element is not really clicked.
		/// </summary>
		/// <param name="clickWithJavascript">If <c>true</c>, the Javascript click workaround is enabled; <c>false</c> 
		/// otherwise.</param>
		bool ClickWithJavascript {
			get;
			set;
		}
	}
}

