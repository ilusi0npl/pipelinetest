package com.capgemini.page.objects;

import com.capgemini.manager.DriverManager;
import com.capgemini.waits.WaitUntil;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.capgemini.utils.Constants.ENV_URL;

public class HomePage extends BasePage<HomePage> {

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(name = "submit_search")
    private WebElement submitSearch;

    @Override
    public HomePage load() {
        DriverManager.getDriver().get(ENV_URL);
        return this;
    }

    @Step("Typed into search field {text}")
    public HomePage typeIntoSearch(String text) {
        WaitUntil.elementIsVisible(searchField);
        searchField.clear();
        searchField.sendKeys(text);
        logger.info("Typed into search field {}", text);
        return this;
    }

    @Step("Click on search icon")
    public SearchResultsPage clickOnSearchIcon() {
        submitSearch.click();
        logger.info("Clicked on Search Icon");
        return new SearchResultsPage();
    }

}
