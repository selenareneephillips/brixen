using System;
using OpenQA.Selenium;
using System.Collections.Generic;
using System.Linq;

namespace Org.Brixen.Bean {

	/// <summary>
	/// Specifies all the data necessary to construct a <b>Selenium</b> page object that models a drop-down menu.
	/// </summary>
	public class DropDownMenuBean : DynamicControllableBean, IMenuBean, IDropDownMenuBean {
		private IMenuBean menuBean = new MenuBean();

		public bool ClickOptionWithJavascript { 
			get { 
				return menuBean.ClickOptionWithJavascript; 
			}

			set { 
				menuBean.ClickOptionWithJavascript = value; 
			} 
		}


		public IList<IWebElement> OptionElements { 	

			get {
				return menuBean.OptionElements;
			}

			set {
				menuBean.OptionElements = value;
			}
		}

		public override string ToString() {
			return String.Format("DropDownMenuBean({0}, ClickOptionWithJavascript: {1}, OptionElements: {2})", 
				base.ToString(), ClickOptionWithJavascript.ToString(), OptionElements.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IDropDownMenuBean);
		}

		public bool Equals(IDropDownMenuBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals (b) &&
				ClickOptionWithJavascript == b.ClickOptionWithJavascript &&
				(OptionElements == b.OptionElements || 
					(OptionElements.All(b.OptionElements.Contains) && OptionElements.Count == b.OptionElements.Count));

		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				return (base.GetHashCode () * 397)
					^ ClickOptionWithJavascript.GetHashCode ()
					^ menuBean.GetHashCode();
			}
		}
	}
}

