using System;
using OpenQA.Selenium;

namespace Org.Brixen.Bean {
	public class ContentContainerBean : LoadableBean, IContentContainerBean
	{
		IWebElement contentContainer;

		public IWebElement ContentContainer {
			get {
				return contentContainer;
			}

			set {
				if(value == null) {
					throw new ArgumentNullException("value", "Cannot invoke setter for ContentContainer property " + 
						"with a null parameter");
				}	

				contentContainer = value;
			}
		}

		public override string ToString() {
			return String.Format("ContentContainerBean({0}, ContentContainer: {1})", base.ToString(), 
				ContentContainer != null ? ContentContainer.ToString() : "null");
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IContentContainerBean);
		}

		public bool Equals(IContentContainerBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals(b) && ContentContainer == b.ContentContainer;
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				int hashCode = base.GetHashCode();

				int contentContainerHashCode = 
					ContentContainer != null ? 
					ContentContainer.GetHashCode() : 0;
				
				hashCode = (hashCode * 397) ^ contentContainerHashCode;
				return hashCode;
			}
		}
	}
}

