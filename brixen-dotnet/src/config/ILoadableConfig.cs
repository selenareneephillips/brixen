using System;
using System.Collections.Generic;
using Org.Brixen.Util;

namespace Org.Brixen.Config {

	public interface ILoadableConfig {

		Optional<int> LoadTimeout {
			get;
			set;
		}
			
		Dictionary<String,Object> AdditionalProperties {
			get;
		}
	}
}

