package com.capgemini.tests.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Ignore
public class SelectTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void selectTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
        WebElement selectDropDown = driver.findElement(By.id("dropdown"));

        Select select = new Select(selectDropDown);
        String firstSelectedOption = select.getFirstSelectedOption().getText();

        assertEquals(firstSelectedOption, "Please select an option");

        select.selectByValue("1");

        firstSelectedOption = select.getFirstSelectedOption().getText();

        assertEquals(firstSelectedOption, "Option 1");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
