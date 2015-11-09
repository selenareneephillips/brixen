package org.brixen.example.priceline;

import lombok.extern.slf4j.XSlf4j;
import org.brixen.bean.LoadableBean;
import org.brixen.builder.DropDownMenuBuilderImpl;
import org.brixen.config.DropDownMenuConfig;
import org.brixen.function.ClickWithJavascript;
import org.brixen.function.IsJQueryComplete;
import org.brixen.function.WaitForJQueryToComplete;
import org.brixen.function.WaitForUrlToChange;
import org.brixen.pageobject.AbstractLoadable;
import org.brixen.pageobject.BasicMenuOption;
import org.brixen.pageobject.DropDownBasicMenu;
import org.brixen.pageobject.ExpandableImpl;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.testng.Assert.assertTrue;

@XSlf4j
@SuppressWarnings("UnusedDeclaration")
public class PricelinePage extends AbstractLoadable<PricelinePage> {

    @FindBy(how = How.CLASS_NAME, using = "search__form-container")
    private WebElement formContainer;

    @FindBy(how = How.ID, using = "tab-hotels")
    private WebElement hotelsTabSelector;

    @FindBy(how = How.CLASS_NAME, using = "search__form-container--hotels")
    private WebElement hotelsTab;

    @FindBy(how = How.ID, using = "tab-flights")
    private WebElement flightsTabSelector;

    @FindBy(how = How.CLASS_NAME, using = "search__form-container--flights")
    private WebElement flightsTab;

    @FindBy(how = How.ID, using = "tab-cars")
    private WebElement carsTabSelector;

    @FindBy(how = How.CLASS_NAME, using = "search__form-container--rc")
    private WebElement carsTab;

    @FindBy(how = How.ID, using = "tab-vacations")
    private WebElement vacationPackagesTabSelector;

    @FindBy(how = How.CLASS_NAME, using = "search__form-container--vp")
    private WebElement vacationPackagesTab;

    @FindBy(how = How.ID, using = "tab-cruises")
    private WebElement cruisesTabSelector;

    @FindBy(how = How.CLASS_NAME, using = "search__form-container--cruise")
    private WebElement cruisesTab;

    @FindBy(how = How.ID, using = "tab-more")
    private WebElement moreTabSelector;

    @FindBy(how = How.CLASS_NAME, using = "search__form-container--more")
    private WebElement moreTab;

    @FindBy(how = How.CSS, using = "li[class^='search__tabs-item is-active']")
    private WebElement activeTab;

    @FindBy(how = How.CSS, using = "li[class^='has-dropdown global-header__nav-secondary__item--sign-in'] a")
    private WebElement signInMenuAccessor;

    @FindBy(how = How.CSS, using = "i[class^=icon-logo-priceline")
    private WebElement logo;

    @FindBys({
            @FindBy(how = How.CSS, using = "li[class*='sign-in global-header']"),
            @FindBy(how = How.CLASS_NAME, using = "global-header__dropdown__list")
    })
    private WebElement signInMenuContentContainer;

    private DropDownBasicMenu signInMenu;


    @FindBys({
            @FindBy(how = How.CSS, using = "li[class*='sign-in global-header']"),
            @FindBy(how = How.CLASS_NAME, using = "global-header__dropdown__list"),
            @FindBy(how = How.CSS, using = "li a")
    })
    private List<WebElement> signInMenuOptions;

    public PricelinePage(LoadableBean bean) {
        super(bean);
    }

    public PriceLinePageTab getActiveTab() {
        String name = activeTab.getText();

        for(PriceLinePageTab tab : PriceLinePageTab.values()) {
            if(tab.getAlias().equals(name)) {
                return tab;
            }
        }

        return null;
    }

    public void selectHotelsTab() {
       selectTab(PriceLinePageTab.HOTELS);
    }

    public void selectFlightsTab() {
        selectTab(PriceLinePageTab.FLIGHTS);
    }

    public void selectCarsTab() {
        selectTab(PriceLinePageTab.CARS);
        new WaitForJQueryToComplete().accept(getDriver(),20,1);
    }

    public void selectCruisesTab() {
        selectTab(PriceLinePageTab.CRUISES);
    }

    public void selectVacationPackagesTab() {
        selectTab(PriceLinePageTab.VACATION_PACKAGES);
    }

    public void selectMoreTab() {
        selectTab(PriceLinePageTab.MORE);
    }

    public List<BasicMenuOption> getSignInMenuOptions() {
        if(signInMenu == null) {
            buildSignInMenu();
        }

        return signInMenu.getOptions();
    }

    public void signIn() {
        selectSignInMenuOption("Sign in");
    }

    public void register() {
        selectSignInMenuOption("Register");
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            assertTrue(new IsJQueryComplete().test(getDriver()));
            assertTrue(formContainer.isDisplayed());
        } catch(NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            throw new Error(e);
        }
    }

    private void selectSignInMenuOption(String option) {
        if(signInMenu == null) {
            buildSignInMenu();
        }

        String originalUrl = getDriver().getCurrentUrl();

        signInMenu.getOptions().stream().filter(menuOption -> menuOption.getLabel().equals(option))
                .forEach(signInMenu::clickOption);

        new WaitForUrlToChange().accept(getDriver(), originalUrl, 30, 1);
    }

    private void selectTab(PriceLinePageTab tab) {
        switch(tab) {
            case HOTELS:
                selectTab(hotelsTabSelector, "clickHotelsTabWithJavascript");
                break;
            case FLIGHTS:
                selectTab(flightsTabSelector, "clickFlightsTabWithJavascript");
            case CARS:
                selectTab(carsTabSelector, "clickCarsTabWithJavascript");
                break;
            case VACATION_PACKAGES:
                selectTab(vacationPackagesTabSelector, "clickVacationPackagesTabWithJavascript");
                break;
            case CRUISES:
                selectTab(cruisesTabSelector, "clickCruisesTabWithJavascript");
                break;
            case MORE:
                selectTab(moreTabSelector, "clickMoreTabWithJavascript");
                break;
        }
    }

    private void selectTab(WebElement tabSelector, final String clickWithJavascriptPropertyName) {
        log.entry(tabSelector, clickWithJavascriptPropertyName);

        Boolean clickWithJavaScript = getCustomConfigProperty(getClass().getCanonicalName(),
                clickWithJavascriptPropertyName, Boolean.class);

        if(clickWithJavaScript != null && clickWithJavaScript) {
            log.debug("Clicking tab with Javascript");
            new ClickWithJavascript().accept(getDriver(),tabSelector);
        } else {
            log.debug("Clicking tab with native Selenium click action");
            tabSelector.click();
        }
    }

    private void buildSignInMenu() {
        DropDownMenuConfig config = getConfig("SignInMenuConfig");
        DropDownMenuBuilderImpl<DropDownBasicMenu> menuBuilder = new DropDownMenuBuilderImpl<>();

        signInMenu = menuBuilder
                .setComponentClass(DropDownBasicMenu.class)
                .setContentContainer(signInMenuContentContainer)
                .setDriver(getDriver())
                .setLoadTimeout(config)
                .setPollingTimeout(config)
                .setPollingInterval(config)
                .setContentContainer(signInMenuContentContainer)
                .setOptionElements(signInMenuOptions)
                .setClickOptionWithJavascript(config)
                .addHoverControl(ExpandableImpl.EXPANDABLE_CONTROL_NAME)
                .setControlDriver(ExpandableImpl.EXPANDABLE_CONTROL_NAME, getDriver())
                .setControlLoadTimeout(ExpandableImpl.EXPANDABLE_CONTROL_NAME, config)
                .setControlContentContainer(ExpandableImpl.EXPANDABLE_CONTROL_NAME, signInMenuAccessor)
                .setControlUnhoverElement(ExpandableImpl.EXPANDABLE_CONTROL_NAME, logo)
                .setHoverControlWithJavascript(ExpandableImpl.EXPANDABLE_CONTROL_NAME, config)
                .setUnhoverControlWithJavascript(ExpandableImpl.EXPANDABLE_CONTROL_NAME, config)
                .setClickControlInsteadOfHover(ExpandableImpl.EXPANDABLE_CONTROL_NAME, config)
                .setClickControlWithJavascriptInsteadOfHover(ExpandableImpl.EXPANDABLE_CONTROL_NAME, config)
                .setUnhoverControlWithClickInstead(ExpandableImpl.EXPANDABLE_CONTROL_NAME, config)
                .setUnhoverControlWithJavascriptClickInstead(ExpandableImpl.EXPANDABLE_CONTROL_NAME, config)
                .build();
    }
}
