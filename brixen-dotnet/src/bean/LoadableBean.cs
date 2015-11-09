using System;
using OpenQA.Selenium;
using Org.Brixen.PageObject;

namespace Org.Brixen.Bean {
	
	public class LoadableBean : ILoadableBean {
		private IWebDriver driver;
		private int loadTimeout;

		public LoadableBean() {
			loadTimeout = LoadableConstants.DefaultLoadTimeout;
		}

		public IWebDriver Driver {
			get {
				return driver;
			}

			set {
				if(value == null) {
					throw new ArgumentNullException ("value", "Cannot invoke setter for Driver property with a null " +
					"parameter");
				}	

				driver = value;
			}
		}

		public int LoadTimeout {
			get { 
				return loadTimeout;
			}

			set {
				if (value < 0) {
					throw new ArgumentOutOfRangeException ("value", "Cannot specify a load timeout less than 0 " + 
						"seconds");
				}

				loadTimeout = value;
			}	
		} 

		public override string ToString() {
			return String.Format("LoadableBean(Driver: {0}, LoadTimeout: {1})", Driver != null ? Driver.ToString() : null, 
				LoadTimeout.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as ILoadableBean);
		}

		public bool Equals(ILoadableBean b) {
			if (ReferenceEquals(null, b)) return false;
			return LoadTimeout == b.LoadTimeout && ReferenceEquals(Driver, b.Driver);
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				int hashCode = 13;
				hashCode = (hashCode * 397) ^ LoadTimeout;

				int driverHashCode = 
					Driver != null ? 
					Driver.GetHashCode() : 0;
				
				hashCode = (hashCode * 397) ^ driverHashCode ;
				return hashCode;
			}
		}
	}
}
