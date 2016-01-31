using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

namespace Org.Brixen.Util {

	public class OptionalJsonContractResolver : DefaultContractResolver {
		public new static readonly OptionalJsonContractResolver Instance = new OptionalJsonContractResolver();

		private static readonly MethodInfo ShouldSerializeOptionalBuilderMethodInfo = 
			typeof(OptionalJsonContractResolver).GetMethod("ShouldSerializeOptionalBuilder", BindingFlags.Static | 
				BindingFlags.Public);

		protected override JsonProperty CreateProperty(MemberInfo member, MemberSerialization memberSerialization) {
			var property = base.CreateProperty(member, memberSerialization);

			var settableTypeParameter = OptionalJsonConverter.ResolveOptionalTypeParameter(property
				.PropertyType);

			if(settableTypeParameter != null) {
				property.ShouldSerialize = MakePredicateForOptionalType(settableTypeParameter, property);
			}

			return property;
		}
			
		public Predicate<object> MakePredicateForOptionalType(Type baseType, JsonProperty property) {
			var typedMethod = ShouldSerializeOptionalBuilderMethodInfo.MakeGenericMethod(baseType);

			return (Predicate<object>)typedMethod.Invoke(null, new object[] { property });
		}
			
		public static Predicate<object> ShouldSerializeOptionalBuilder<T>(JsonProperty property) where T : struct {
			return o => {
				var v = property.ValueProvider.GetValue(o);
				return ((Optional<T>) v).IsSet;
			};
		}
	}
}

