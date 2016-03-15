using System;
using System.Collections.Generic;
using System.Collections;
using Org.Brixen.Util;
using Newtonsoft.Json;
using KellermanSoftware.CompareNetObjects;

namespace Org.Brixen.Config {
	public class LoadableConfig : ILoadableConfig {
		private Optional<int> loadTimeout;
		private IDictionary<string, Object> additionalProperties = new Dictionary<string, Object>();

		public Optional<int> LoadTimeout {
			get {
				return loadTimeout;
			}

			set {
				loadTimeout = value;
			}
		}
			
		[JsonExtensionData]
		public IDictionary<string, dynamic> AdditionalProperties {
			get {
				return additionalProperties;
			}

			set {
				if(value == null) {
					throw new ArgumentNullException("value", "Cannot invoke setter for AdditionalProperties property " + 
						"with a null parameter");
				}	

				additionalProperties = value;
			}
		}
			
		public override string ToString() {

			return String.Format("LoadableConfig(LoadTimeout: {0}, AdditionalProperties: {1})", 
				(LoadTimeout != null ? LoadTimeout.ToString() : "null"), AdditionalProperties.DeepToString());
		}
	}
}

