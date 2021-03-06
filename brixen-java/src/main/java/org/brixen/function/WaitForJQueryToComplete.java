package org.brixen.function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class WaitForJQueryToComplete implements TriConsumer<WebDriver,Integer,Integer> {

    public void accept(final WebDriver driver, final Integer pollingTimeoutInSeconds, final Integer
            pollingIntervalInSeconds) {
        new FluentWait<>(driver)
                .withTimeout(pollingTimeoutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(pollingIntervalInSeconds, TimeUnit.SECONDS)
                .until((WebDriver driver1) -> {
            return new IsJQueryComplete().test(driver1);
        });
    }
}
