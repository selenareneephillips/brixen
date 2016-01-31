using NUnit.Framework;
using System;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Org.Brixen.Util;
using Org.Brixen.Config;

namespace Org.Brixen.Tests.Config {
	
	[TestFixture]
	[Category("LoadableConfigTestGroup")]
	public class LoadableConfigTest {

		private JsonSerializerSettings settings = new JsonSerializerSettings();
		private OptionalJsonContractResolver contractResolver = new OptionalJsonContractResolver();

		public LoadableConfigTest() {
			settings.ContractResolver = contractResolver;
			settings.TypeNameHandling = TypeNameHandling.Objects;
		}	

		[Test]
		[Category("LoadableConfigSerializationTest")]
		[Category("LoadableConfigSerializationUndefinedFieldTest")]
		public void ShouldSerializeLoadableWithUndefinedLoadTimeout() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
			    'AdditionalProperties': {
				    '$type': 'System.Collections.Generic.Dictionary`2[[System.String, mscorlib],[System.Object, 
                        mscorlib]], mscorlib'
			    }
            }";

			JObject jsonObj = JObject.Parse(json);

			ILoadableConfig config = new LoadableConfig();

			string output = JsonConvert.SerializeObject(config, Formatting.Indented, settings);
			JObject result = JObject.Parse (output);

			Assert.AreEqual(result, jsonObj);
			Assert.IsNull(result.SelectToken("LoadTimeout"));
		}

		[Test]
		[Category("LoadableConfigSerializationTest")]
		[Category("LoadableConfigSerializationNullFieldTest")]
		public void ShouldSerializeLoadableWithNullLoadTimeout() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': null,
			    'AdditionalProperties': {
				    '$type': 'System.Collections.Generic.Dictionary`2[[System.String, mscorlib],[System.Object, 
                        mscorlib]], mscorlib'
			    }
            }";

			JObject jsonObj = JObject.Parse(json);

			ILoadableConfig config = new LoadableConfig();
			config.LoadTimeout = null;

			string output = JsonConvert.SerializeObject (config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(result, jsonObj);
			Assert.IsFalse(result.SelectToken("LoadTimeout").HasValues);
		}

		[Test]
		[Category("LoadableConfigSerializationTest")]
		public void ShouldSerializeLoadableConfig() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': 50,
			    'AdditionalProperties': {
				    '$type': 'System.Collections.Generic.Dictionary`2[[System.String, mscorlib],[System.Object, 
                        mscorlib]], mscorlib'
			    }
            }";

			JObject jsonObj = JObject.Parse(json);

			ILoadableConfig config = new LoadableConfig();
			config.LoadTimeout = new Nullable<int>(50);

			String output = JsonConvert.SerializeObject (config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(result, jsonObj);
			Assert.AreEqual(result.SelectToken("LoadTimeout").Value<int>(), 50);
		}

//		[Test ()]
//		public void TestCase() {
//			string json = @"{ 
//			     '$type': 'Newtonsoft.Json.Samples.Hotel, Newtonsoft.Json.Tests',
//			     LoadTimeout : 40 
//            }";
//
//		}
	}
}

