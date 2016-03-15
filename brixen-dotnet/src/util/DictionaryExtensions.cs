using System;
using System.Collections.Generic;
using System.Collections;
using System.Text;

namespace Org.Brixen.Util {

	public static class DictionaryExtensions {
		
		public static string DeepToString<K,V>(this IDictionary<K,V> dictionary) {
			StringBuilder sb = new StringBuilder();

			sb.Append("Dictionary(");
			foreach(var x in dictionary) {
				sb.Append("[");
				sb.Append(x.Key);
				sb.Append(", ");
				sb.Append(x.Value);
				sb.Append("],");
			}

			string str = sb.ToString(0, sb.Length - 1);
			return str + ")";
		}
	}
}

