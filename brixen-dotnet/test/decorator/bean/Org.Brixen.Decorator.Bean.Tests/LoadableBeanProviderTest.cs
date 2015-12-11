using NUnit.Framework;
using System;
using Org.Brixen.Bean;
using Org.Brixen.Decorator.Bean;

namespace Org.Brixen.Decorator.Bean.Tests {
	
	[TestFixture]
	[Category("LoadableBeanProviderTestGroup")]
	public class LoadableBeanProviderTest {
		
		[Test]
		[Category("ExpectedExceptionsTestGroup")]
		[Category("ProviderExpectedExceptionsTestGroup")]
		[Category("LoadableBeanProviderExpectedExceptionsTestGroup")]
		[ExpectedException("System.ArgumentNullException", ExpectedMessage = "Cannot construct a " + 
			"LoadableBeanProvider with a null bean", MatchType=MessageMatch.Regex)]
		public void shouldThrowExceptionForNullBeanElement() {
			new LoadableBeanProvider<ILoadableBean>(null);
		}
	}	
}

