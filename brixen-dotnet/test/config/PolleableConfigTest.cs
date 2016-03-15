using System;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using NUnit.Framework;
using Org.Brixen.Util;
using Org.Brixen.Config;

namespace Org.Brixen.Tests.Config {
	
	public class PolleableConfigTest {
		private JsonSerializerSettings settings = new JsonSerializerSettings();
		private OptionalJsonContractResolver contractResolver = new OptionalJsonContractResolver();

		public PolleableConfigTest() {
			settings.ContractResolver = contractResolver;
			settings.TypeNameHandling = TypeNameHandling.Objects;
		}

		[Test]
		[Category("ToStringCallsBaseTestGroup")]
		[Category("ConfigToStringCallsBaseTestGroup")]
		[Category("PolleableConfigToStringCallsBaseTestGroup")]
		public void ShouldCallBaseForToString() {

			IPolleableConfig config = new PolleableConfig();
			config.LoadTimeout = new Optional<int>(20);
			config.PollingTimeout = new Optional<int>(30);
			config.PollingInterval = new Optional<int>(5);
			config.AdditionalProperties.Add("field1", "field1_val");
			config.AdditionalProperties.Add("field2", true);
			config.AdditionalProperties.Add("field3", 50);

			Assert.AreEqual("PolleableConfig(LoadableConfig(LoadTimeout: " + config.LoadTimeout.ToString() + 
				", AdditionalProperties: Dictionary([field1, field1_val],[field2, True],[field3, 50])), " + 
				"PollingTimeout: " + config.PollingTimeout.ToString() + ", PollingInterval: " + 
				config.PollingInterval.ToString() + ")", config.ToString());
		}

		[Test]
		[Category("PolleableConfigSerializationTest")]
		[Category("PolleableConfigSerializationUndefinedFieldTest")]
		public void ShouldSerializePolleableWithUndefinedPollingTimeout() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.PolleableConfig, Org.Brixen.Config',
				'LoadTimeout': 70,
                'PollingInterval': 5
            }";

			JObject jsonObj = JObject.Parse(json);

			IPolleableConfig config = new PolleableConfig();
			config.LoadTimeout = new Optional<int>(70);
			config.PollingInterval = new Optional<int>(5);

			string output = JsonConvert.SerializeObject(config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(jsonObj, result, "The serialized JSON of a polleable config with an undefined polling " + 
				"timeout is not correct");
			Assert.IsNull(result.SelectToken("PollingTimeout"), "There should be no polling timeout token in the " + 
				"serialized JSON for a polleable config with an undefined polling timeout");
		}

		[Test]
		[Category("PolleableConfigDeserializationTest")]
		[Category("PolleableConfigDeserializationUndefinedFieldTest")]
		public void ShouldDeserializePolleableWithUndefinedLoadTimeout() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.PolleableConfig, Org.Brixen.Config',
				'LoadTimeout': 70,
                'PollingInterval': 5
            }";

			IPolleableConfig result  = JsonConvert.DeserializeObject<PolleableConfig>(json, settings);
			JObject resultJObject = JObject.Parse(JsonConvert.SerializeObject(result, Formatting.Indented, settings));
			JObject inputJObject = JObject.Parse(json);

			Assert.AreEqual(inputJObject, resultJObject, "The deserialized configuration bean for JSON containing no " + 
				"polling timeout token is not equal to the expected result");
			Assert.IsFalse(result.PollingTimeout.HasValue, "A polleable config deserialized from JSON that has no " + 
				"polling timeout token should not have a value for polling timeout");
			Assert.IsFalse(result.PollingTimeout.IsSet, "A polleable config deserialized from JSON that has no " + 
				"polling timeout token should indicate that the polling timeout field was never set");
		}

		[Test]
		[Category("PolleableConfigSerializationTest")]
		[Category("PolleableConfigSerializationUndefinedFieldTest")]
		public void ShouldSerializePolleableWithUndefinedPollingInterval() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.PolleableConfig, Org.Brixen.Config',
				'LoadTimeout': 70,
                'PollingTimeout': 120
            }";

			JObject jsonObj = JObject.Parse(json);

			IPolleableConfig config = new PolleableConfig();
			config.LoadTimeout = new Optional<int>(70);
			config.PollingTimeout = new Optional<int>(120);

			string output = JsonConvert.SerializeObject(config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(jsonObj, result, "The serialized JSON of a polleable config with an undefined polling " + 
				"interval is not correct");
			Assert.IsNull(result.SelectToken("PollingInterval"), "There should be no polling interval token in the " + 
				"serialized JSON for a polleable config with an undefined polling interval");
		}

		[Test]
		[Category("PolleableConfigDeserializationTest")]
		[Category("PolleableConfigDeserializationUndefinedFieldTest")]
		public void ShouldDeserializePolleableWithUndefinedLoadInterval() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.PolleableConfig, Org.Brixen.Config',
				'LoadTimeout': 70,
                'PollingTimeout': 120
            }";

			IPolleableConfig result  = JsonConvert.DeserializeObject<PolleableConfig>(json, settings);
			JObject resultJObject = JObject.Parse(JsonConvert.SerializeObject(result, Formatting.Indented, settings));
			JObject inputJObject = JObject.Parse(json);

			Assert.AreEqual(inputJObject, resultJObject, "The deserialized configuration bean for JSON containing no " + 
				"polling interval token is not equal to the expected result");
			Assert.IsFalse(result.PollingInterval.HasValue, "A polleable config deserialized from JSON that has no " + 
				"polling interval token should not have a value for polling interval");
			Assert.IsFalse(result.PollingInterval.IsSet, "A polleable config deserialized from JSON that has no " + 
				"polling interval token should indicate that the polling interval field was never set");
		}
	}
}

