using System;
using OpenQA.Selenium;

namespace Org.Brixen.PageObject
{
	/// <summary>
	/// Defines the contract for the most basic <b>Selenium</b> page object.
	/// </summary>
	public interface ILoadable {

		/// <summary>
		/// Returns the <c>IWebDriver</c> for browsing this <c>Loadable</c>.
		/// </summary>
		/// <returns>The driver for browsing this <c>Loadable</c>.</returns>
		IWebDriver getDriver();

		/// <summary>
		/// Returns the load timeout in seconds for this <c>Loadable</c>.
		/// </summary>
		/// <returns>The load timeout in seconds for this <c>Loadable</c>.</returns>
		int getLoadTimeout();
	}
}