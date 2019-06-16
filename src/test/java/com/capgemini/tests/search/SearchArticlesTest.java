package com.capgemini.tests.search;

import com.capgemini.page.objects.HomePage;
import com.capgemini.tests.TestBase;
import org.testng.annotations.Test;

public class SearchArticlesTest extends TestBase {

    @Test
    public void asCustomerSearchForArticle() {
        String expectedArticle = "Dress";
        new HomePage()
                .load()
                .typeIntoSearch(expectedArticle)
                .clickOnSearchIcon()
                .assertThatArticleNameIs(expectedArticle);
}


}
