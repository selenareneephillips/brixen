using System;
using Org.Brixen.PageObject;

namespace Org.Brixen.Bean {
	
	public class PolleableBean : LoadableBean, IPolleableBean {
		private int pollingTimeout;
		private int pollingInterval;

		public PolleableBean() {
			pollingTimeout = PolleableConstants.DefaultPollingTimeout;
			pollingInterval = PolleableConstants.DefaultPollingInterval;
		}

		public int PollingTimeout {
			get {
				return pollingTimeout;
			}

			set {
				if(value < 0) {
					throw new ArgumentOutOfRangeException("Cannot specify a polling timeout less than 0 seconds");
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
					throw new ArgumentOutOfRangeException("Cannot specify a polling interval less than 0 seconds");
				}

				pollingInterval = value;
			}	
		}

		public override string ToString() {
			return String.Format("PolleableBean({0}, PollingTimeout: {1}, PollingInterval: {2})", base.ToString(), 
				PollingTimeout.ToString(),PollingInterval.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IPolleableBean);
		}

		public bool Equals(IPolleableBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals(b) && PollingTimeout == b.PollingTimeout && PollingInterval == b.PollingInterval;
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				int hashCode = base.GetHashCode();
				hashCode = (hashCode * 397) ^ PollingTimeout;
				hashCode = (hashCode * 397) ^ PollingInterval;
				return hashCode;
			}
		}
	}
}

