using System;
using OpenQA.Selenium;

namespace Org.Brixen.Bean {
	public class ContentContainerBean : LoadableBean, IContentContainerBean
	{
		IWebElement contentContainer;

		public ContentContainerBean() : base() { }

		public IWebElement ContentContainer {
			get {
				return contentContainer;
			}

			set {
				if(value == null) {
					throw new ArgumentNullException ("value", "Cannot invoke setter for ContentContainer property " + 
						"with a null parameter");
				}	

				contentContainer = value;
			}
		}
	}
}

