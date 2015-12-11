using System;
using Org.Brixen.Bean;

namespace Org.Brixen.Decorator.Bean {
	
	/// <summary>
	/// <para>
	/// Serves as a <c>protected</c> access provider for an implementation of <c>ILoadableBean</c> or an 
	/// <c>interface</c> extending <c>ILoadableBean</c>.
	/// </para>
	/// <para>
	/// <c>LoadableBeanProvider</c> is a means for avoiding unnecessary access to internal data for <c>classes</c> 
	/// which implement decorator <c>interfaces</c> for state beans.
	/// </para>
	/// </summary>
	/// <typeparam name="BeanT">The state bean to which this <c>LoadableBeanProvider</c> provides <c>protected</c> 
	/// access.</typeparam>
	public class LoadableBeanProvider<BeanT> where BeanT : ILoadableBean {

		/// <summary>
		/// The state bean to which this <c>LoadableBeanProvider</c> provides <c>protected</c> access.
		/// </summary>
		private BeanT bean;

		/// <summary>
		/// Constructs a <c>LoadableBeanProvider</c> which provides <c>protected</c> access to the specified state 
		/// bean.
		/// </summary>
		/// <param name="bean">The state bean to which this <c>LoadableBeanProvider</c> provides <c>protected</c> 
		/// access.</param>
		public LoadableBeanProvider(BeanT bean) {
			if(bean == null) {
				throw new ArgumentNullException ("bean", "Cannot construct a LoadableBeanProvider with a null bean");
			}
			this.bean = bean;
		}

		/// <summary>
		/// Gets the state bean to which this <c>LoadableBeanProvider</c> provides <c>protected</c> access.
		/// </summary>
		/// <value>The bean.</value>
		protected BeanT Bean {
			get {
				return bean;
			}
		}
	}
}

