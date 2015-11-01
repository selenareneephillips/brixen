package org.brixen.config;

import org.openqa.selenium.WebDriver;

public interface ConfigService {
    <ConfigT extends LoadableConfig> ConfigT getConfig(String configId, WebDriver driver);
}
