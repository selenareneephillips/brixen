using System;
using System.Collections.Generic;
using Org.Brixen.Util;
using Newtonsoft.Json;

namespace Org.Brixen.Config {

	/// <summary>
	/// Defines the contract for a configuration bean for an <c>ILoadable</c> which is deserializable from JSON. 
	/// <c>ILoadableConfig</c> supports dynamic configuration of the load timeout for a <c>Loadable</c> 
	/// based on environmental factors such as browser, browser version, OS and OS version. Additionally,
	/// <c>LoadableConfig</c> supports the deserialization of any custom properties specified in the JSON configuration 
	/// source.
	/// </summary>
	public interface ILoadableConfig {

		/// <summary>
		/// Gets or sets the load timeout specified in the JSON configuration source for an <c>ILoadable</c>.
		/// </summary>
		/// <value>The load timeout for an <c>ILoadable</c> specified in its JSON configuration source. If this value 
		/// is missing from the JSON source, both its <c>HasValue</c> and <c>IsSet</c> properties are <c>false</c>. If 
		/// this value is present in the JSON source with an explicit <c>null</c> value, its <c>HasValue</c> property 
		/// is <c>false</c>, but its <c>IsSet</c> property is <c>true</c>.</value>
		Optional<int> LoadTimeout {
			get;
			set;
		}
			
		/// <summary>
		/// Gets or sets additional custom configuration properties for an <c>ILoadable</c> that were found in its JSON 
		/// configuration source.
		/// </summary>
		/// <value>A mapping of names to values for custom configuration properties that were found in the JSON
		/// configuration source.</value>
		[JsonExtensionData]
		IDictionary<string, dynamic> AdditionalProperties {
			get;
			set;
		}	
	}
}

