namespace Org.Brixen.Bean
{

	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
	/// <c>Clickable</c> page object.
	/// </summary>
	public interface IClickableBean : IContentContainerBean {
		
		/// <summary>
		/// Sets or gets the Javascript click workaround flag.
		/// <p>
		/// When the Javascript click workaround is enabled, a 'click' on the wrapped <c>WebElement</c> will be 
		/// performed with Javascript rather than the <see cref="OpenQA.Selenium.IWebElement.Click()"/> method. This is 
		/// useful in circumstances where clicks fail silently, that is 
		/// <see cref="OpenQA.Selenium.IWebElement.Click()"/> runs without throwing any <c>Exceptions</c>, but the 
		/// element is not really clicked.
		/// </summary>
		/// <value>If <c>true</c>, the Javascript click workaround is enabled; <c>false</c> otherwise.</value>
		bool ClickWithJavascript {
			get;
			set;
		}
	}
}

