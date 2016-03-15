using System;
using Org.Brixen.Util;

namespace Org.Brixen.Config {
	
	public interface IPolleableConfig : ILoadableConfig {

		/// <summary>
		/// Gets or sets the polling timeout specified in the JSON configuration source for an <c>IPolleable</c>.
		/// </summary>
		/// <value>The polling timeout for an <c>IPolleable</c> specified in its JSON configuration source. If this 
		/// value is missing from the JSON source, both its <c>HasValue</c> and <c>IsSet</c> properties are 
		/// <c>false</c>. If this value is present in the JSON source with an explicit <c>null</c> value, its 
		/// <c>HasValue</c> property is <c>false</c>, but its <c>IsSet</c> property is <c>true</c>.</value>
		Optional<int> PollingTimeout {
			get;
			set;
		}

		/// <summary>
		/// Gets or sets the polling interval specified in the JSON configuration source for an <c>IPolleable</c>.
		/// </summary>
		/// <value>The polling interval for an <c>IPolleable</c> specified in its JSON configuration source. If this 
		/// value is missing from the JSON source, both its <c>HasValue</c> and <c>IsSet</c> properties are 
		/// <c>false</c>. If this value is present in the JSON source with an explicit <c>null</c> value, its 
		/// <c>HasValue</c> property is <c>false</c>, but its <c>IsSet</c> property is <c>true</c>.</value>
		Optional<int> PollingInterval {
			get;
			set;
		}
	}
}

