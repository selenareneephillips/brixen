using NUnit.Framework;
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
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config'
            }";

			JObject jsonObj = JObject.Parse(json);

			ILoadableConfig config = new LoadableConfig();

			string output = JsonConvert.SerializeObject(config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(jsonObj, result, "The serialized JSON of a loadable config with an undefined load " + 
				"timeout is not correct");
			Assert.IsNull(result.SelectToken("LoadTimeout"), "There should be no load timeout token in the " + 
				"serialized JSON for a loadable config with an undefined load timeout");
		}

		[Test]
		[Category("LoadableConfigDeserializationTest")]
		[Category("LoadableConfigDeserializationUndefinedFieldTest")]
		public void ShouldDeserializeLoadableWithUndefinedLoadTimeout() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config'
            }";

			ILoadableConfig result  = JsonConvert.DeserializeObject<LoadableConfig>(json, settings);

			JObject resultJObject = JObject.Parse(JsonConvert.SerializeObject(result, Formatting.Indented, settings));
			JObject inputJObject = JObject.Parse(json);

			Assert.AreEqual(inputJObject, resultJObject, "The deserialized configuration bean for JSON containing no " + 
				"load timeout token is not equal to the expected result");
			Assert.IsFalse(result.LoadTimeout.HasValue, "A loadable config deserialized from JSON that has no load " + 
				"timeout token should not have a value for load timeout");
			Assert.IsFalse(result.LoadTimeout.IsSet, "A loadable config deserialized from JSON that has no load " + 
				"timeout token should indicate that the load timeout field was never set");
		}

		[Test]
		[Category("LoadableConfigSerializationTest")]
		[Category("LoadableConfigSerializationNullFieldTest")]
		public void ShouldSerializeLoadableWithNullLoadTimeout() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': null
            }";

			JObject jsonObj = JObject.Parse(json);

			ILoadableConfig config = new LoadableConfig();
			config.LoadTimeout = null;

			string output = JsonConvert.SerializeObject(config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(jsonObj, result, "The serialized JSON of a loadable config with a null load timeout is " + 
				"not correct");
			Assert.IsFalse(result.SelectToken("LoadTimeout").HasValues, "There should be a token in the serialized " + 
				"JSON for a loadable config with a null load timeout, but it should not have a value");
		}

		[Test]
		[Category("LoadableConfigDeserializationTest")]
		[Category("LoadableConfigDeserializationNullFieldTest")]
		public void ShouldDeserializeLoadableWithNullLoadTimeout() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': null
            }";

			ILoadableConfig result  = JsonConvert.DeserializeObject<LoadableConfig>(json, settings);

			JObject resultJObject = JObject.Parse(JsonConvert.SerializeObject(result, Formatting.Indented, settings));
			JObject inputJObject = JObject.Parse(json);

			Assert.AreEqual(inputJObject, resultJObject, "The deserialized configuration bean for JSON containing an " + 
				"explicit null value for load timeout is not equal to the expected result");
			Assert.IsFalse(result.LoadTimeout.HasValue, "A loadable config deserialized from JSON that has a null " + 
				"load timeout token should not have a value for load timeout");
			Assert.IsTrue(result.LoadTimeout.IsSet, "A loadable config deserialized from JSON that has no load " + 
				"timeout token should indicate that the load timeout field was set");
		}

		[Test]
		[Category("LoadableConfigSerializationTest")]
		public void ShouldSerializeLoadableConfig() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': 50
            }";

			JObject jsonObj = JObject.Parse(json);

			ILoadableConfig config = new LoadableConfig();
			config.LoadTimeout = new Optional<int>(50);

			string output = JsonConvert.SerializeObject(config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(jsonObj, result, "The serialized JSON of a loadable config with a non-null load timeout " + 
				"is not correct");
			Assert.AreEqual(50, result.SelectToken("LoadTimeout").Value<int>(), "The serialized JSON for a loadable " + 
				"with a non-null load timeout should contain the load timeout value from the config");

			Assert.IsNull(result["AdditionalProperties"], "The serialized JSON for a loadable config with no custom " + 
				"properties should not have a token for the custom properties map");
		}

		[Test]
		[Category("LoadableConfigDeserializationTest")]
		public void ShouldDeserializeLoadableConfig() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': 50
            }";

			ILoadableConfig result  = JsonConvert.DeserializeObject<LoadableConfig>(json, settings);
			JObject resultJObject = JObject.Parse(JsonConvert.SerializeObject(result, Formatting.Indented, settings));
			JObject inputJObject = JObject.Parse(json);

			Assert.AreEqual(inputJObject, resultJObject, "The deserialized configuration bean for JSON containing a " + 
				"non-null value for load timeout is not correct");
			
			Assert.AreEqual(0, result.AdditionalProperties.Count);
		}

		[Test]
		[Category("LoadableConfigSerializationTest")]
		public void ShouldSerializeLoadableConfigWithAdditionalProperties() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': 50,
                'field1':'field1_val',
                'field2':false,
                'field3':50
            }";

			JObject jsonObj = JObject.Parse(json);	

			ILoadableConfig config = new LoadableConfig();
			config.LoadTimeout = new Optional<int>(50);
			config.AdditionalProperties.Add("field1", "field1_val");
			config.AdditionalProperties.Add("field2", false);
			config.AdditionalProperties.Add("field3", 50);

			string output = JsonConvert.SerializeObject(config, Formatting.Indented, settings);
			JObject result = JObject.Parse(output);

			Assert.AreEqual(jsonObj, result, "The serialized JSON for a loadable config with custom properties is " + 
				"not correct");
			Assert.AreEqual(50, result.SelectToken("LoadTimeout").Value<int>(), "The serialized JSON for a loadable " + 
				"config with a non-null load timeout and some custom properties should contain the load timeout " + 
				"from the config");

			string field1 = result ["field1"].Value<string>();
			bool field2 = result ["field2"].Value<bool>();
			int field3 = result ["field3"].Value<int>();

			Assert.AreEqual("field1_val", field1, "The value of the a custom property in the serialized JSON for a " + 
				"loadable config with custom properties is not correct");
			Assert.AreEqual(false, field2, "The value of the a custom property in the serialized JSON for a " + 
				"loadable config with custom properties is not correct");
			Assert.AreEqual(50, field3, "The value of the a custom property in the serialized JSON for a " + 
				"loadable config with custom properties is not correct");
		}

		[Test]
		[Category("LoadableConfigDeserializationTest")]
		public void ShouldDeserializeLoadableConfigWithAdditionalProperties() {
			string json = @"{
			    '$type': 'Org.Brixen.Config.LoadableConfig, Org.Brixen.Config',
                'LoadTimeout': 50,
                'field1':'field1_val',
                'field2':false,
                'field3':50
            }";

			ILoadableConfig result  = JsonConvert.DeserializeObject<LoadableConfig>(json, settings);
			JObject resultJObject = JObject.Parse(JsonConvert.SerializeObject(result, Formatting.Indented, settings));
			JObject inputJObject = JObject.Parse(json);

			Assert.AreEqual(inputJObject, resultJObject, "The deserialized configuration bean for JSON containing " + 
				"custom properties is not correct");

			object obj;

			result.AdditionalProperties.TryGetValue("field1", out obj);
			Assert.AreEqual(obj, "field1_val", "Custom property named 'field1' does not have String value " + 
				"'field1_val'");

			result.AdditionalProperties.TryGetValue("field2", out obj);
			Assert.AreEqual(obj, false, "Custom property named 'field2' does not have bool value 'false'");

			result.AdditionalProperties.TryGetValue("field3", out obj);
			
			Assert.AreEqual (obj, 50, "Custom property named 'field1' does not have integer value '50'");
		}
	}
}

