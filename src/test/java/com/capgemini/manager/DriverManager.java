package com.capgemini.manager;

import com.capgemini.listener.DriverEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setDriver(DriverType driverType, String isRemoteRun) {
        DriverFactory driverFactory = new DriverFactory();

        WebDriver driver;
        if (Boolean.valueOf(isRemoteRun)){
            driver = driverFactory.getRemoteDriver(driverType);
        } else{
            driver = driverFactory.getLocalDriver(driverType);
        }

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        DriverEventListener driverEventListener = new DriverEventListener();
        webDriverThreadLocal.set(eventFiringWebDriver.register(driverEventListener));
    }

    public static WebDriver getDriver() {
        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("Driver was null! Please call setDriver() before getDriver()");
        }
        return webDriverThreadLocal.get();
    }

    public static void tearDown() {
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }

}
