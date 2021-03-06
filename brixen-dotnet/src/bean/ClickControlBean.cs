﻿using System;

namespace Org.Brixen.Bean {
	
	public class ClickControlBean : ContentContainerBean, IClickControlBean {
		public bool ClickWithJavascript { get; set; } = false;

		public override string ToString() {
			return String.Format("ClickControlBean({0}, ClickWithJavascript: {1})", base.ToString(), 
				ClickWithJavascript.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IClickControlBean);
		}

		public bool Equals(IClickControlBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals(b) && ClickWithJavascript == b.ClickWithJavascript;
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				return (base.GetHashCode() * 397) ^ ClickWithJavascript.GetHashCode();
			}
		}
	}
}

