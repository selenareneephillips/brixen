using System;
using System.Collections.Generic;
using OpenQA.Selenium;
using System.Linq;

namespace Org.Brixen.Bean {

	public class ControllableBean : ContentContainerBean, IControllableBean {

		private  Dictionary<string,IControlBean> controlBeans = new Dictionary<string,IControlBean>();

		public void AddClickControl(string name) {
			if(name == null) {
				throw new ArgumentNullException("name", "Cannot add a control with name that is null");
			}

			if(string.IsNullOrEmpty(name) || string.IsNullOrWhiteSpace(name)) {
				throw new ArgumentException("name", "Cannot add a control with a name that is empty or all whitespace");
			}

			if(controlBeans.ContainsKey(name)) {
				throw new ArgumentException("There is already a control named " + name);
			}

			controlBeans.Add(name, new ClickControlBean());
		}
			
		public void AddHoverControl(string name) {
			if(name == null) {
				throw new ArgumentNullException("name", "Cannot add a control with name that is null");
			}

			if(string.IsNullOrEmpty(name) || string.IsNullOrWhiteSpace(name)) {
				throw new ArgumentException("name", "Cannot add a control with a name that is empty or all whitespace");
			}

			if(controlBeans.ContainsKey(name)) {
				throw new ArgumentException("There is already a control named " + name);
			}

			controlBeans.Add(name, new HoverControlBean());
		}
			
		public void AddHoverAndClickControl(string name) {
			if(name == null) {
				throw new ArgumentNullException("name", "Cannot add a control with name that is null");
			}

			if(string.IsNullOrEmpty(name) || string.IsNullOrWhiteSpace(name)) {
				throw new ArgumentException("name", "Cannot add a control with a name that is empty or all whitespace");
			}

			if(controlBeans.ContainsKey(name)) {
				throw new ArgumentException("There is already a control named " + name);
			}

			controlBeans.Add(name, new HoverAndClickControlBean());
		}
			
		public void AddClickControl<BeanT>(string name,  BeanT bean) where BeanT : IClickControlBean {
			if(name == null) {
				throw new ArgumentNullException("name", "Cannot add a control with name that is null");
			}

			if(string.IsNullOrEmpty(name) || string.IsNullOrWhiteSpace(name)) {
				throw new ArgumentException("name", "Cannot add a control with a name that is empty or all whitespace");
			}

			if(bean == null) {
				throw new ArgumentNullException ("bean", "Cannot add a control with a null state bean");
			}

			if(controlBeans.ContainsKey(name)) {
				throw new ArgumentException("There is already a control named " + name);
			}

			controlBeans.Add(name, bean);
		}
			
		public void AddHoverControl<BeanT>(string name, BeanT bean) where BeanT : IHoverControlBean {
			if(name == null) {
				throw new ArgumentNullException("name", "Cannot add a control with name that is null");
			}

			if(string.IsNullOrEmpty(name) || string.IsNullOrWhiteSpace(name)) {
				throw new ArgumentException("name", "Cannot add a control with a name that is empty or all whitespace");
			}

			if(bean == null) {
				throw new ArgumentNullException ("bean", "Cannot add a control with a null state bean");
			}

			if(controlBeans.ContainsKey(name)) {
				throw new ArgumentException("There is already a control named " + name);
			}
				
			controlBeans.Add(name, bean);
		}
			
		public void AddHoverAndClickControl<BeanT>(string name, BeanT bean) where BeanT : IHoverAndClickControlBean {
			if(name == null) {
				throw new ArgumentNullException("name", "Cannot add a control with name that is null");
			}

			if(string.IsNullOrEmpty(name) || string.IsNullOrWhiteSpace(name)) {
				throw new ArgumentException("name", "Cannot add a control with a name that is empty or all whitespace");
			}

			if(bean == null) {
				throw new ArgumentNullException ("bean", "Cannot add a control with a null state bean");
			}

			if(controlBeans.ContainsKey(name)) {
				throw new ArgumentException("There is already a control named " + name);
			}

			controlBeans.Add(name, bean);
		}
			
		public void SetControlDriver(string name, IWebDriver driver) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			bean.Driver = driver;
		}
			
		public void SetControlContentContainer(string name, IWebElement contentContainer) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			bean.ContentContainer = contentContainer;
		}
			
		public void SetControlPollingTimeout(string name, int timeout) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}
				
			typeof(IPolleableBean).IsAssignableFrom (bean.GetType ());

			if(!typeof(IPolleableBean).IsAssignableFrom(bean.GetType())) {
				throw new InvalidOperationException("The control named " + name + " is not a polleable control");
			}

			((IPolleableBean)bean).PollingTimeout = timeout;
		}
			
		public void SetControlPollingInterval(string name, int interval) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}
		
			if(!typeof(IPolleableBean).IsAssignableFrom(bean.GetType())) {
				throw new InvalidOperationException("The control named " + name + " is not a polleable control");
			}

			((IPolleableBean)bean).PollingInterval = interval;
		}
			
		public void SetControlLoadTimeout(string name, int timeout) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			bean.LoadTimeout = timeout;
		}
			
		public void SetControlUnhoverElement(string name, IWebElement unhoverElement) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsHoverControl() && !bean.IsHoverAndClickControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a hover control");
			}

			if(bean.IsHoverControl()) {
				((IHoverControlBean) bean).UnhoverElement = unhoverElement;
			} else {
				((IHoverAndClickControlBean) bean).UnhoverElement = unhoverElement;
			}
		}
			
		public void SetHoverControlWithJavascript(string name, bool hoverWithJavascript) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsHoverControl() && !bean.IsHoverAndClickControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a hover or a hover and " + 
					"click control");
			}

			if(bean.IsHoverControl()) {
				((IHoverControlBean) bean).HoverWithJavascript = hoverWithJavascript;
			} else {
				((IHoverAndClickControlBean) bean).HoverWithJavascript = hoverWithJavascript;
			}
		}
			
		public void SetUnhoverControlWithJavascript(string name, bool unhoverWithJavascript) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsHoverControl() && !bean.IsHoverAndClickControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a hover or a hover and " + 
					"click control");
			}

			if(bean.IsHoverControl()) {
				((IHoverControlBean) bean).UnhoverWithJavascript = unhoverWithJavascript;
			} else {
				((IHoverAndClickControlBean) bean).UnhoverWithJavascript = unhoverWithJavascript;
			}
		}
			
		public void SetClickControlWithJavascript(string name, bool clickWithJavascript) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsClickControl() && !bean.IsHoverAndClickControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a click or a hover and " + 
					"click control");
			}

			((IClickControlBean)bean).ClickWithJavascript = clickWithJavascript;
		}
			
		public void SetClickControlInsteadOfHover(string name, bool clickInsteadOfHover) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsHoverControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a hover control");
			}

			((IHoverControlBean)bean).ClickInsteadOfHover = clickInsteadOfHover;
		}
			
		public void SetClickControlWithJavascriptInsteadOfHover(string name, bool clickWithJavascriptInsteadOfHover) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsHoverControl() && !bean.IsHoverAndClickControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a click or a hover and " + 
					"click control");
			}

			if(bean.IsHoverControl()) {
				((IHoverControlBean) bean).ClickWithJavascriptInsteadOfHover = clickWithJavascriptInsteadOfHover;
			} else {
				((IHoverAndClickControlBean) bean).ClickWithJavascriptInsteadOfHover = 
					clickWithJavascriptInsteadOfHover;
			}
		}
			
		public void SetUnhoverControlWithClickInstead(string name, bool unhoverWithClickInstead) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsHoverControl() && !bean.IsHoverAndClickControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a click or a hover and " + 
					"click control");
			}

			if(bean.IsHoverControl()) {
				((IHoverControlBean) bean).UnhoverWithClickInstead = unhoverWithClickInstead;
			} else {
				((IHoverAndClickControlBean) bean).UnhoverWithClickInstead = unhoverWithClickInstead;
			}
		}
			
		public void SetUnhoverControlWithJavascriptClickInstead(string name, bool unhoverWithJavascriptClickInstead) {
			IControlBean bean;

			if(!controlBeans.TryGetValue(name, out bean)) {
				throw new ArgumentException("There is no control named " + name);
			}

			if(!bean.IsHoverControl() && !bean.IsHoverAndClickControl()) {
				throw new InvalidOperationException("The control named " + name + " is not a click or a hover and " + 
					"click control");
			}
				
			if(bean.IsHoverControl()) {
				((IHoverControlBean) bean).UnhoverWithJavascriptClickInstead = unhoverWithJavascriptClickInstead;
			} else {
				((IHoverAndClickControlBean) bean).UnhoverWithJavascriptClickInstead = 
					unhoverWithJavascriptClickInstead;
			}
		}

		public Dictionary<String,IControlBean> ControlBeans { 
			get {
				return controlBeans;
			}
		}

		public override string ToString() {
			return String.Format("ControllableBean({0}, Control Beans: {1})", 
				base.ToString(), 
				ControlBeans.ToString());
		}

		public override bool Equals(System.Object obj) {
			if (ReferenceEquals(null, obj)) return false;
			if (ReferenceEquals(this, obj)) return true;
			if (obj.GetType() != GetType()) return false;
			return Equals(obj as IControllableBean);
		}

		public bool Equals(IControllableBean b) {
			if (ReferenceEquals(null, b)) return false;
			return base.Equals(b) &&
				(ControlBeans == b.ControlBeans || 
					(ControlBeans.Count == b.ControlBeans.Count && !ControlBeans.Except(b.ControlBeans).Any()));
		}

		public override int GetHashCode() {
			unchecked { // Overflow is fine, just wrap
				return (base.GetHashCode() * 397) 
					^ (ControlBeans.Count != 0 ? getHashCodeForControlBeans() : 0);
			}
		}

		private int getHashCodeForControlBeans() {
			int hashCode = (13 * 397);

			foreach (string key in ControlBeans.Keys) {
				IControlBean bean;
				ControlBeans.TryGetValue(key, out bean);

				hashCode = hashCode ^ key.GetHashCode() ^ bean.GetHashCode();
			}	

			return hashCode;
		}	
	}
}

