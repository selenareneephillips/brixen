using System;

namespace Org.Brixen.Bean {
	
	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object which models a
	/// dynamic page object which needs to be polled on intervals for an expected condition.
	/// </summary>
	public interface IPolleableBean : ILoadableBean {
		
		/// <summary>
		/// Gets or sets the polling timeout in seconds to poll the page object to determine if an expected condition 
		/// has been satisfied.
		/// </summary>
		/// <value>The polling timeout in seconds to poll the page object to determine if an expected condition has 
		/// been satisfied.</value>
		int PollingTimeout {
			get;
			set;
		}

		/// <summary>
		/// Gets or sets the polling interval in seconds to poll the page object to determine if an expected condition 
		/// has been satisfied.
		/// </summary>
		/// <value>The polling interval in seconds to poll the page object to determine if an  expected condition has 
		/// been satisfied.</value>
		int PollingInterval {
			get;
			set;
		}		
	}
}

