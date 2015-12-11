using System;
using OpenQA.Selenium;

namespace Org.Brixen.Bean {
	
	public class HoverControlBean : ContentContainerBean, IHoverControlBean {
		private IWebElement unhoverElement;

		public IWebElement UnhoverElement {
			get {
				return unhoverElement;
			}

			set {
				if(value == null) {
					throw new ArgumentNullException("value", "Cannot invoke setter for UnhoverElement property with " + 
						"a null parameter");
				}	

				unhoverElement = value;
			}
		}

		public bool HoverWithJavascript { get; set; } = false;

		public bool UnhoverWithJavascript { get; set; } = false;

		public bool ClickInsteadOfHover { get; set; } = false;
			
		public bool ClickWithJavascriptInsteadOfHover { get; set; } = false;

		public bool UnhoverWithClickInstead { get; set; } = false;

		public bool UnhoverWithJavascriptClickInstead { get; set; } = false;

		public override string ToString() {
			return String.Format("HoverControlBean({0}, UnhoverElement: {1}, HoverWithJavascript: {2}, " +
				"UnhoverWithJavascript: {3}, ClickInsteadOfHover: {4}, ClickWithJavascriptInsteadOfHover: {5}, " + 
				"UnhoverWithClickInstead: {6}, UnhoverWithJavascriptClickInstead: {7})", 
				base.ToString(), 
				UnhoverElement != null ? UnhoverElement.ToString() : "null",
				HoverWithJavascript.ToString(),
				UnhoverWithJavascript.ToString(),
				ClickInsteadOfHover.ToString(),
				ClickWithJavascriptInsteadOfHover.ToString(),
				UnhoverWithClickInstead.ToString(),
				UnhoverWithJavascriptClickInstead.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IHoverControlBean);
		}

		public bool Equals(IHoverControlBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals(b) && 
				UnhoverElement == b.UnhoverElement &&
				HoverWithJavascript == b.HoverWithJavascript &&
				UnhoverWithJavascript == b.UnhoverWithJavascript &&
				ClickInsteadOfHover == b.ClickInsteadOfHover &&
				ClickWithJavascriptInsteadOfHover == b.ClickWithJavascriptInsteadOfHover &&
				UnhoverWithClickInstead == b.UnhoverWithClickInstead &&
				UnhoverWithJavascriptClickInstead == b.UnhoverWithJavascriptClickInstead;
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				int hashCode = base.GetHashCode();

				int unhoverElementHashCode = 
					UnhoverElement != null ? 
					UnhoverElement.GetHashCode() : 0;

				hashCode = (hashCode * 397) 
					^ unhoverElementHashCode
					^ HoverWithJavascript.GetHashCode() 
					^ UnhoverWithJavascript.GetHashCode() 
					^ ClickInsteadOfHover.GetHashCode()
					^ ClickWithJavascriptInsteadOfHover.GetHashCode()
					^ UnhoverWithClickInstead.GetHashCode() 
					^ UnhoverWithJavascriptClickInstead.GetHashCode();
				return hashCode;
			}
		}
	}
}

