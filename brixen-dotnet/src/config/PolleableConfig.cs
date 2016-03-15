using System;
using Org.Brixen.Util;

namespace Org.Brixen.Config {

	public class PolleableConfig : LoadableConfig, IPolleableConfig {

		private Optional<int> pollingTimeout;
		private Optional<int> pollingInterval;

		public Optional<int> PollingTimeout {
			get {
				return pollingTimeout;
			}

			set {
				pollingTimeout = value;
			}
		}

		public Optional<int> PollingInterval {
			get {
				return pollingInterval;
			}

			set {
				pollingInterval = value;
			}
		}

		public override string ToString() {
			return String.Format("PolleableConfig({0}, PollingTimeout: {1}, PollingInterval: {2})", 
				base.ToString(), 
				PollingTimeout != null ? PollingTimeout.ToString() : "null", 
				PollingInterval != null ? pollingInterval.ToString() : "null");
		}
	}
}

