using System;
using System.Collections.Generic;
using OpenQA.Selenium;
using System.Linq;

namespace Org.Brixen.Bean {
	
	public class MenuBean : ContentContainerBean, IMenuBean {
		private IList<IWebElement> optionElements = new List<IWebElement>();

		public bool ClickOptionWithJavascript { get; set; } = false;
		public IList<IWebElement> OptionElements { 	
			
			get {
				return optionElements;
			}

			set {
				if(value == null) {
					throw new ArgumentNullException("value", "Cannot invoke setter for OptionElements property " + 
						"with a null parameter");
				}	

				optionElements = value;
			}
		}

		public override string ToString() {
			return String.Format("MenuBean({0}, ClickOptionWithJavascript: {1}, OptionElements: {2})", base.ToString(), 
				ClickOptionWithJavascript.ToString(), OptionElements.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IMenuBean);
		}

		public bool Equals(IMenuBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals (b) &&
				ClickOptionWithJavascript == b.ClickOptionWithJavascript &&
				(OptionElements == b.OptionElements || 
					(OptionElements.All(b.OptionElements.Contains) && OptionElements.Count == b.OptionElements.Count));

		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				int optionElementsHashCode = 
					OptionElements.Count != 0 ? 
					getHashCodeForOptionElements() : 0;
				
				return (base.GetHashCode() * 397) 
					^ ClickOptionWithJavascript.GetHashCode()
					^ optionElementsHashCode;
			}
		}
			
		private int getHashCodeForOptionElements() {
			int hashCode = (13 * 397);

			foreach (IWebElement option in OptionElements) {
				hashCode = hashCode ^ option.GetHashCode();
			}	

			return hashCode;
		}	
	}
}

