using System;
using OpenQA.Selenium;
using Org.Brixen.PageObject;

namespace Org.Brixen.Bean {
	
	public class HoverAndClickControlBean : ClickControlBean, IHoverAndClickControlBean {
		private IWebElement unhoverElement;

		private int pollingTimeout = PolleableConstants.DefaultPollingTimeout;
		private int pollingInterval = PolleableConstants.DefaultPollingInterval;

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

		public bool ClickWithJavascriptInsteadOfHover { get; set; } = false;

		public bool UnhoverWithClickInstead { get; set; } = false;

		public bool UnhoverWithJavascriptClickInstead { get; set; } = false;

		public int PollingTimeout {
			get {
				return pollingTimeout;
			}

			set {
				if(value < 0) {
					throw new ArgumentOutOfRangeException("value", "Cannot specify a polling timeout less than 0 " + 
						"seconds");
				}

				pollingTimeout = value;
			}	
		}

		public int PollingInterval {
			get {
				return pollingInterval;
			}

			set {
				if(value < 0) {
					throw new ArgumentOutOfRangeException("value", "Cannot specify a polling interval less than 0 " + 
						"seconds");
				}

				pollingInterval = value;
			}	
		}

		public override string ToString() {
			return String.Format("HoverAndClickControlBean({0}, UnhoverElement: {1}, HoverWithJavascript: {2}, " +
				"UnhoverWithJavascript: {3}, ClickWithJavascriptInsteadOfHover: {4}, UnhoverWithClickInstead: {5}, " + 
				"UnhoverWithJavascriptClickInstead: {6}, PollingTimeout: {7}, PollingInterval: {8})", 
				base.ToString(), 
				UnhoverElement != null ? UnhoverElement.ToString() : "null",
				HoverWithJavascript.ToString(),
				UnhoverWithJavascript.ToString(),
				ClickWithJavascriptInsteadOfHover.ToString(),
				UnhoverWithClickInstead.ToString(),
				UnhoverWithJavascriptClickInstead.ToString(),
				PollingTimeout.ToString(),
				PollingInterval.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IHoverAndClickControlBean);
		}

		public bool Equals(IHoverAndClickControlBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals(b) && 
				UnhoverElement == b.UnhoverElement &&
				HoverWithJavascript == b.HoverWithJavascript &&
				UnhoverWithJavascript == b.UnhoverWithJavascript &&
				ClickWithJavascriptInsteadOfHover == b.ClickWithJavascriptInsteadOfHover &&
				UnhoverWithClickInstead == b.UnhoverWithClickInstead &&
				UnhoverWithJavascriptClickInstead == b.UnhoverWithJavascriptClickInstead && 
				PollingTimeout == b.PollingTimeout && 
				PollingInterval == b.PollingInterval;
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				int unhoverElementHashCode = 
					UnhoverElement != null ? 
					UnhoverElement.GetHashCode() : 0;

				return (base.GetHashCode() * 397) 
					^ unhoverElementHashCode
					^ HoverWithJavascript.GetHashCode() 
					^ UnhoverWithJavascript.GetHashCode() 
					^ ClickWithJavascriptInsteadOfHover.GetHashCode()
					^ UnhoverWithClickInstead.GetHashCode() 
					^ UnhoverWithJavascriptClickInstead.GetHashCode()
				    ^ PollingTimeout
				    ^ PollingInterval;
			}
		}
	}
}

