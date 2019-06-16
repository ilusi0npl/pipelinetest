package com.capgemini.waits;

import com.capgemini.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    public static WebElement elementIsVisible(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 10);
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
