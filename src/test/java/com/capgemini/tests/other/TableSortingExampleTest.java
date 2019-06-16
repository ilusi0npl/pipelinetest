package com.capgemini.tests.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Ignore
public class TableSortingExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void sortingTableTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/tables");

        WebElement table = driver.findElement(By.id("table1"));

        List<WebElement> lastNameRow = table.findElements(By.xpath("tbody/tr/td[1]"));

        List<String> expectedSortedList = new ArrayList<String>();
        for (WebElement lastNameElement : lastNameRow) {
            String text = lastNameElement.getText();
            expectedSortedList.add(text);
        }
        expectedSortedList.sort(Comparator.naturalOrder());

        WebElement lastNameTitleColumn = driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[1]/span"));
        lastNameTitleColumn.click();

        lastNameRow = table.findElements(By.xpath("tbody/tr/td[1]"));

        List<String> actualSortedList = new ArrayList<String>();
        for (WebElement lastNameElement : lastNameRow) {
            String text = lastNameElement.getText();
            actualSortedList.add(text);
        }
        assertEquals(actualSortedList, expectedSortedList);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
