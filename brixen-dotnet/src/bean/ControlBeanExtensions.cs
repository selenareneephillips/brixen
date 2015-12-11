using System.Linq;
using System;

namespace Org.Brixen.Bean {
	
	/// <summary>
	/// Extension methods to provide ability to determine runtime type of a web control implementing the 
	/// <c>IControlBean</c> <c>interface</c>.
	/// </summary>
	public static class ControlBeanExtension {

		/// <summary>
		/// Determines if this <c>IControlBean</c> specifies a web control that has meaningful behavior when clicked.
		/// </summary>
		/// <returns><c>true</c> if this <c>IControlBean</c> is also a <c>IClickControlBean</c>; <c>false</c> otherwise.
		/// </returns>
		/// <param name="controlBean">This control bean.</param>
		public static bool IsClickControl(this IControlBean controlBean) {
			return typeof(IClickControlBean).IsAssignableFrom(controlBean.GetType());	
		}

		/// <summary>
		/// Determines if this <c>IControlBean</c> specifies a web control that has meaningful behavior when moused 
		/// over.
		/// </summary>
		/// <returns><c>true</c> if this <c>IControlBean</c> is also a <c>IHoverControlBean</c>; <c>false</c> otherwise.
		/// </returns>
		/// <param name="controlBean">This control bean.</param>
		public static bool IsHoverControl(this IControlBean controlBean) {
			return typeof(IHoverControlBean).IsAssignableFrom(controlBean.GetType());	
		}
			
		/// <summary>
		/// Determines if this <c>IControlBean</c> specifies a web control that has meaningful behavior when clicked, 
		/// but which must be moused over before it can be clicked.
		/// </summary>
		/// <returns><c>true</c> if this <c>IControlBean</c> is also a <c>IHoverAndClickControlBean</c>; <c>false</c> 
		/// otherwise.</returns>
		/// <param name="controlBean">This control bean.</param>
		public static bool IsHoverAndClickControl(this IControlBean controlBean) {
			return typeof(IHoverAndClickControlBean).IsAssignableFrom(controlBean.GetType());	
		}
	}
}
	

