using System;
using OpenQA.Selenium;

namespace Org.Brixen.Bean {

	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
	/// component which wraps a <c>IWebElement</c> content container.
	/// </summary>
	public interface IContentContainerBean : ILoadableBean {
		
		/// <summary>
		/// Gets or sets the <c>IWebElement</c> that contains the content wrapped by the page object.
		/// </summary>
		/// <value>The <c>IWebElement</c> that contains the content wrapped by the page object.</value>
		IWebElement ContentContainer {
			get;
			set;
	    }
	}
}

