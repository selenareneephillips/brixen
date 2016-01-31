using System;
using Newtonsoft.Json;

namespace Org.Brixen.Util {

	[JsonConverter(typeof(OptionalJsonConverter))]
	public struct Optional<T> where T : struct {

		public static Optional<T> Undefined { 
			get { 
				return default(Optional<T>); 
			} 
		}

		private T optional;
		private bool isSet;
		private bool hasValue;

		public Optional(T? value) {
			isSet = true;
			hasValue = value.HasValue;
			optional = hasValue ? value.Value : default(T);
		}
			
		public bool IsSet {
			get { 
				return isSet; 
			}
		}
			
		public bool HasValue {
			get { 
				return isSet && hasValue; 
			}
		}
			
		public T Value {
			get {
				if (isSet && hasValue)
					return optional;

				throw new InvalidOperationException("The value is null or undefined.");
			}

			set {
				isSet = true;
				hasValue = true;
				optional = value;
			}
		}
			
		public static implicit operator Optional<T>(T? value) {
			var s = new Optional<T>
			{
				isSet = true,
				hasValue = value.HasValue
			};

			if (value.HasValue) s.optional = value.Value;

			return s;
		}
			
		public static implicit operator Optional<T>(T value) {
			return new Optional<T> {
				isSet = true,
				hasValue = true,
				optional = value
			};
		}
			
		public static implicit operator T?(Optional<T> value) {
			return (value.HasValue) ? (T?)value.optional : null;
		}
			
		public static implicit operator T(Optional<T> value) {
			if (value.HasValue)
				return value.optional;

			throw new InvalidOperationException("Cannot convert null or undefined values.");
		}
			
		public T GetValueOrDefault() {
			return optional;
		}
			
		public T GetValueOrDefault(T defaultValue) {
			if (!HasValue)
				return defaultValue;

			return optional;
		}
			
		public override bool Equals(object other) {
			if (!HasValue)
				return other == null;
			if (other == null)
				return false;
			return optional.Equals(other);
		}
			
		public static bool operator ==(Optional<T> t1, Optional<T> t2) {
			// undefined equals undefined
			if (!t1.isSet && !t2.IsSet) return true;

			// undefined != everything else
			if (t1.isSet ^ t2.isSet) return false;

			// null equals null
			if (!t1.hasValue && !t2.hasValue) return true;

			// null != everything else
			if (t1.hasValue ^ t2.hasValue) return false;

			// if both are values, compare them
			return t1.optional.Equals(t2.optional);
		}
			
		public static bool operator !=(Optional<T> t1, Optional<T> t2) {
			return !(t1 == t2);
		}
			
		public override int GetHashCode() {
			if (!isSet) return -1;
			if (!hasValue) return 0;
			return optional.GetHashCode();
		}
			
		public override string ToString() {
			return isSet ?
				(hasValue ? optional.ToString() : "null") :
				"undefined";
		}
	}
}

