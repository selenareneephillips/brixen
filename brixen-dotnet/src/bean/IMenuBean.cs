using System;
using System.Collections.Generic;
using OpenQA.Selenium;

namespace Org.Brixen.Bean {
	
	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a 
	/// menu.
	/// </summary>
	public interface IMenuBean : IContentContainerBean {

		/// <summary>
		/// Gets or sets the list of <c>IWebElements</c> that encapsulate the options on the menu.
		/// </summary>
		/// <value>The list of <c>IWebElements</c> that encapsulate the options on the menu.</value>
		IList<IWebElement> OptionElements {
			get;
			set;
		}

		/// <summary>
		/// Gets or sets the Javascript click workaround for the options in the menu.
		/// <para>
		/// If enabled, Javascript will be used to execute a click on the on the menu options. If not, the
		/// <see cref="OpenQA.Selenium.IWebElement.Click()"/> method will be used.
		/// </para>
		/// </summary>
		/// <value>If <c>true</c>, the Javascript click workaround is enabled; <c>false</c> otherwise.</value>
		bool ClickOptionWithJavascript {
			get;
			set;
		}	
	}
}

