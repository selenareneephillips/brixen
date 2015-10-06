package org.brixen.example;

import lombok.extern.slf4j.XSlf4j;
import org.brixen.config.ConfigService;
import org.brixen.config.ConfigServiceImpl;
import org.brixen.example.priceline.PriceLinePageTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.brixen.builder.LoadableBuilderImpl;
import org.brixen.example.priceline.PricelinePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;

@XSlf4j
@Test
public class PricelineExampleTest {
    private WebDriver driver;

    @Test
    public void testPricelineExamplePage() {
        ConfigService service = ConfigServiceImpl.getInstance();

        LoadableBuilderImpl<PricelinePage> builder = new LoadableBuilderImpl<>();

        driver = new FirefoxDriver();
        driver.get("http://www.priceline.com");
        driver.manage().window().maximize();

        PricelinePage plp = builder
                .setComponentClass(PricelinePage.class)
                .setDriver(driver)
                .setLoadTimeout(service.getConfig(PricelinePage.class.getCanonicalName(), driver))
                .build().get();

        assertEquals(plp.getActiveTab(), PriceLinePageTab.HOTELS);

        plp.selectCarsTab();
        assertEquals(plp.getActiveTab(), PriceLinePageTab.CARS);

        plp.signIn();
    }

    @AfterTest
    private void closeDriver() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
