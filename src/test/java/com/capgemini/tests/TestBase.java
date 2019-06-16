package com.capgemini.tests;

import com.capgemini.manager.DriverManager;
import com.capgemini.manager.DriverType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    @Parameters({"browser", "isRemoteRun"})
    @BeforeMethod
    public void beforeTest(@Optional("CH") DriverType driverType,@Optional("false") String isRemoteRun) {
        DriverManager.setDriver(driverType, isRemoteRun);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterTest() {
        //Tu mozemy zrobic screenshot
        DriverManager.tearDown();
    }

}
