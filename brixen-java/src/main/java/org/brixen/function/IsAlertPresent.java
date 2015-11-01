package org.brixen.function;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

public class IsAlertPresent implements Predicate<WebDriver> {
    @Override
    public boolean test(final WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException nape) {
            return false;
        }
    }
}
