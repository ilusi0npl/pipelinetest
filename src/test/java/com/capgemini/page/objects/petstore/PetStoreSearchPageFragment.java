package com.capgemini.page.objects.petstore;

import com.capgemini.manager.DriverManager;
import com.capgemini.page.objects.BasePage;
import com.capgemini.waits.WaitUntil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetStoreSearchPageFragment extends BasePage<PetStoreSearchPageFragment> {

    @FindBy(css = "#Search [type='text']")
    private WebElement searchTextField;

    @FindBy(name = "searchProducts")
    private WebElement searchButton;

    @Override
    public PetStoreSearchPageFragment load() {
        DriverManager.getDriver().navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
        return this;
    }

    @Step("Typed into search field {articleToSearch}")
    public PetStoreSearchPageFragment typeIntoSearchField(String articleToSearch) {
        WaitUntil.elementIsVisible(searchTextField);
        searchTextField.clear();
        searchTextField.sendKeys(articleToSearch);
        logger.info("Typed into search field {}", articleToSearch);
        return this;
    }

    @Step("Click on Search Button")
    public PetStoreResultsPage clickOnSearchButton() {
        searchButton.click();
        logger.info("Clicked on Search button");
        return new PetStoreResultsPage();
    }

}