using System;
using System.Collections.Generic;
using Org.Brixen.Util;

namespace Org.Brixen.Config {
	public class LoadableConfig : ILoadableConfig {
		private Optional<int> loadTimeout;
		private Dictionary<string, Object> additionalProperties = new Dictionary<string, Object>();

		public Optional<int> LoadTimeout {
			get {
				return loadTimeout;
			}

			set {
				loadTimeout = value;
			}
		}
			
		public Dictionary<string, Object> AdditionalProperties {
			get {
				return additionalProperties;
			}

			set {
				additionalProperties = value;
			}
		}
	}
}

