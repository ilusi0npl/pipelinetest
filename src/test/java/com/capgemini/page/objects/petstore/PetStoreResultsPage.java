package com.capgemini.page.objects.petstore;

import com.capgemini.page.objects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;

public class PetStoreResultsPage extends BasePage<PetStoreResultsPage> {

    @FindBy(xpath = "//*[@id='Catalog']//tbody//td[3]")
    private List<WebElement> listOfProductNamesLabels;

    @Override
    public PetStoreResultsPage load() {
        throw new IllegalStateException("Cannot navigate to page. It can be only accessed by flow");
    }

    @Step("Assert that pet list was displayed")
    public PetStoreResultsPage assertThatPetListIsDisplayed(List<String> expectedPetNames) {

        List<String> actualPetNames = new ArrayList<>();

        for (WebElement petNameLabel : listOfProductNamesLabels) {
            actualPetNames.add(petNameLabel.getText());
        }

        assertEquals("List of Pets was not as expected", expectedPetNames, actualPetNames);

        actualPetNames = listOfProductNamesLabels
                .stream()
                .map(petNameLabel -> petNameLabel.getText())
                .collect(Collectors.toList());

        assertEquals("List of Pets was not as expected", expectedPetNames, actualPetNames);
        return this;
    }

}
