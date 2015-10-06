package org.brixen.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

public class IsJQueryComplete implements Predicate<WebDriver> {

    @Override
    public boolean test(final WebDriver driver) {
        final JavascriptExecutor executor = (JavascriptExecutor)driver;
        return (Boolean)executor.executeScript("return jQuery.active == 0;");
    }
}
