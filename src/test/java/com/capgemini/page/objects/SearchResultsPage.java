package com.capgemini.page.objects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class SearchResultsPage extends BasePage<SearchResultsPage> {

    @FindBy(css = "div[class='product-container'] a[class='product-name']")
    private WebElement articleNameLabel;

    @Override
    public SearchResultsPage load() {
        throw new IllegalStateException("Cannot navigate to page. It can be only accessed by flow");
    }

    @Step("Assert that article name was displayed {expectedArticleName}")
    public SearchResultsPage assertThatArticleNameIs(String expectedArticleName) {
        String actualArticleName = articleNameLabel.getText();
        assertEquals(actualArticleName, expectedArticleName, "Article name should be " + expectedArticleName);
        logger.info("Asserted that article {} was displayed", expectedArticleName);
        return this;
    }


}
