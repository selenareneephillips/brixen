using System;

namespace Org.Brixen.Bean {

	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
	/// component that contains web controls that have meaningful side effects with state changes that need to be 
	/// polled for an expected condition when they are clicked and/or moused over.
	/// </summary>
	public interface IDynamicControllableBean : IControllableBean, IPolleableBean {
	}
}

