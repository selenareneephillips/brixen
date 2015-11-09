using System;
using OpenQA.Selenium;

namespace Org.Brixen.Bean {
	
	/// <summary>
	/// Defines the contract for a data transfer object used to construct a basic <b>Selenium</b> page object.
	/// </summary>
	public interface ILoadableBean {
		
		/// <summary>
		/// Gets or sets the <c>IWebDriver</c> to use for browsing the page object.
		/// </summary>
		/// <value>The driver for browsing the page object.</value>
		IWebDriver Driver {
			get;
			set;
		}

		/// <summary>
		/// Gets or sets the load timeout in seconds for the page object.
		/// </summary>
		/// <value>The load timeout in seconds for the page object.</value>
		int LoadTimeout {
			get;
			set;
		}	
	}
}

