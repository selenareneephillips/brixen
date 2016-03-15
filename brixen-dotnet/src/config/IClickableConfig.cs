using System;
using Org.Brixen.Util;

namespace Org.Brixen.Config {

	/// <summary>
	/// Defines the contract for a configuration bean for a <see cref="Org.Brixen.PageObject.Clickable">Clickable></see> 
	/// which is deserializable from JSON by <b>Jackson</b>.
	/// <p>
	/// <c>ClickableConfig</c> supports dynamic configuration of the Javascript click work around flag for a
	/// <c>ClickableConfig</c> based on environmental factors such as browser, browser version and OS.                                                                              
	/// </summary>
	public interface IClickableConfig : ILoadableConfig {

		/// <summary>
		/// Gets or sets the Javascript click workaround flag specified in the JSON configuration source for an 
		/// <c>IClickable</c>.
		/// </summary>
		/// <value>The Javascript click workaround flag for an <c>IClickable</c> specified in its JSON configuration 
		/// source. If this value  is missing from the JSON source, both its <c>HasValue</c> and <c>IsSet</c> 
		/// properties are <c>false</c>. If this value is present in the JSON source with an explicit <c>null</c> 
		/// value, its <c>HasValue</c> property is <c>false</c>, but its <c>IsSet</c> property is <c>true</c>.</value>
		Optional<bool> ClickWithJavascript {
			get;
			set;
		}
	}
}

