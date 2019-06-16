package com.capgemini.utils;

import com.capgemini.manager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotMaker {

    public static void makeScreenShot(String fileName) {
        TakesScreenshot screenShotMaker = (TakesScreenshot) DriverManager.getDriver();
        File screenShot = screenShotMaker.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot, new File("screenshots" + File.separator + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
