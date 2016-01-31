using System;
using Newtonsoft.Json;
using System.Collections.Generic;
using Org.Brixen.Util;
using System.Linq;

namespace Org.Brixen.Util {

	public class OptionalJsonConverter : JsonConverter {

		public interface ITypedConverter {

			object Deserialize(object value);
			object ExtractValue(object value);
		}
			
		public class TypedConverter<T> : ITypedConverter where T : struct {

			public object Deserialize(object value) {
				if(value == null) {
					return (Optional<T>)null;
				} 

				try {
					var settedValue = (T)Convert.ChangeType(value, typeof(T));
					return (Optional<T>) settedValue;
				} catch(Exception) {
					return (Optional<T>)null;
				}
			}
				
			public object ExtractValue(object value) {
				return (T?) ((Optional<T>) value);
			}
		}

		private static readonly Dictionary<Type, ITypedConverter> Converters = new Dictionary<Type, ITypedConverter>();

		public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer) {
			var converter = GetConverter(value.GetType());

			serializer.Serialize(writer, converter.ExtractValue(value));
		}
			
		public override object ReadJson(JsonReader reader, Type objectType, object existingValue, 
				JsonSerializer serializer) {
			var converter = GetConverter(objectType);

			return converter.Deserialize(reader.Value);
		}

		private ITypedConverter GetConverter(Type objectType) {
			if (!Converters.ContainsKey(objectType)) {
				var valueType = ResolveOptionalTypeParameter(objectType);
				Converters[objectType] = Activator.CreateInstance(typeof(TypedConverter<>)
					.MakeGenericType(valueType)) as ITypedConverter;
			}

			return Converters[objectType];
		}

		public static Type ResolveOptionalTypeParameter(Type settableType) {
			var toCheck = settableType;
			while (toCheck != null && toCheck != typeof(object)) {
				var cur = toCheck.IsGenericType ? toCheck.GetGenericTypeDefinition() : toCheck;
				if (typeof(Optional<>) == cur) {
					return toCheck.GetGenericArguments().Single();
				}
				toCheck = toCheck.BaseType;
			}

			return null;
		}
			
		public override bool CanConvert(Type objectType) {
			return Converters.ContainsKey(objectType) || ResolveOptionalTypeParameter(objectType) != null;
		}
	}
}

