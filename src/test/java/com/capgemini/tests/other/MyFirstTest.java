package com.capgemini.tests.other;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://google.pl");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.name("btnI"));
        javascriptExecutor.executeScript("arguments[0].click();", element);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
