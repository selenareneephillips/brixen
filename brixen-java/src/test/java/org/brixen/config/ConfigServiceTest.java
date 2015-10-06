package org.brixen.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Test
public class ConfigServiceTest {

    @Test
    public void testConfigService() {

        ConfigServiceImpl service = ConfigServiceImpl.getInstance();
        //Platform p = PowerMockito.mock(Platform.class);

        RemoteWebDriver mockDriver = mock(RemoteWebDriver.class);
        Capabilities mockCapabilities = mock(Capabilities.class);

        when(mockDriver.getCapabilities()).thenReturn(mockCapabilities);
        when(mockCapabilities.getBrowserName()).thenReturn("genericbrowser");
        when(mockCapabilities.getVersion()).thenReturn("38.3.0");
        when(mockCapabilities.getPlatform()).thenReturn(Platform.MAC);

        ControllableConfig controllableConfigOne = service.getConfig("SampleControllableConfigOne", mockDriver);

        System.out.println(controllableConfigOne.getControlConfigs().get());

        ControlConfig controlConfigOne = controllableConfigOne.getControlConfigs().get().get("ControlNameOne");
        ControlConfig controlConfigTwo = controllableConfigOne.getControlConfigs().get().get("ControlNameTwo");

        Assert.assertTrue(((HoverAndClickControlConfig)controlConfigOne).getClickWithJavascript().get());
        Assert.assertFalse(((HoverAndClickControlConfig)controlConfigOne).getHoverWithJavascript().get());

        Assert.assertFalse(((HoverAndClickControlConfig)controlConfigTwo).getClickWithJavascript().get());
        Assert.assertTrue(((HoverAndClickControlConfig)controlConfigTwo).getHoverWithJavascript().get());

        ControllableConfig controllableConfigTwo = service.getConfig("SampleControllableConfigTwo", mockDriver);

        controlConfigOne = controllableConfigTwo.getControlConfigs().get().get("ControlNameOne");
        controlConfigTwo = controllableConfigTwo.getControlConfigs().get().get("ControlNameTwo");

        Assert.assertTrue(((HoverAndClickControlConfig)controlConfigOne).getClickWithJavascript().get());
        Assert.assertTrue(((HoverAndClickControlConfig)controlConfigOne).getHoverWithJavascript().get());

        Assert.assertFalse(((HoverAndClickControlConfig)controlConfigTwo).getClickWithJavascript().get());
        Assert.assertFalse(((HoverAndClickControlConfig)controlConfigTwo).getHoverWithJavascript().get());

    }

}
