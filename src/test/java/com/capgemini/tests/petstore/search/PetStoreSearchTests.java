package com.capgemini.tests.petstore.search;

import com.capgemini.page.objects.petstore.PetStoreSearchPageFragment;
import com.capgemini.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PetStoreSearchTests extends TestBase {

    @Test(dataProvider = "petsToSearch")
    public void asNonRegisteredUserSearchForArticleInPetStoreTest(String petToSearch, List<String> expectedPetList) {
        new PetStoreSearchPageFragment()
                .load()
                .typeIntoSearchField(petToSearch)
                .clickOnSearchButton()
                .assertThatPetListIsDisplayed(expectedPetList);
    }

    @DataProvider
    public Object[][] petsToSearch() {
        Object[][] testDataArray = {
                {"Fish", Arrays.asList("Goldfish", "Angelfish")},
                {"Retriever", Arrays.asList("Golden Retriever", "Labrador Retriever")}
        };
        return testDataArray;
    }

}
