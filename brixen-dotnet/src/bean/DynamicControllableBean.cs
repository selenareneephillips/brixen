using System;
using Org.Brixen.PageObject;

namespace Org.Brixen.Bean{
	public class DynamicControllableBean : ControllableBean, IDynamicControllableBean {
		private IPolleableBean polleableBean = new PolleableBean();

		public int PollingTimeout {
			get {
				return polleableBean.PollingTimeout;
			}

			set {
				polleableBean.PollingTimeout = value;
			}	
		}

		public int PollingInterval {
			get {
				return polleableBean.PollingInterval;
			}

			set {
				polleableBean.PollingInterval = value;
			}	
		}

		public override string ToString() {
			return String.Format("DynamicControllableBean({0}, PollingTimeout: {1}, PollingInterval: {2})", 
				base.ToString(), 
				PollingTimeout.ToString(),
				PollingInterval.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IDynamicControllableBean);
		}

		public bool Equals(IDynamicControllableBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals(b) && 
				PollingTimeout == b.PollingTimeout && 
				PollingInterval == b.PollingInterval;
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				return (base.GetHashCode() * 397) 
					^ polleableBean.GetHashCode();
			}
		}
	}
}

