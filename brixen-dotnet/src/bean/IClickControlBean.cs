using System;

namespace Org.Brixen.Bean {
	
	/// <summary>
	/// Defines the contract for a data transfer object used to construct a <b>Selenium</b> page object that models a
	/// web control that has meaningful side effects whenever it is clicked.
	/// </summary>
	public interface IClickControlBean : IControlBean, IClickableBean {
	}
}

