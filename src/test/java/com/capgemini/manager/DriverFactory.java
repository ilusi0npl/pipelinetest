package com.capgemini.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private String username = "mateuszcioek4";
    private String accessKey = "ccF2iGeeyxzqx46hegmz";

    public WebDriver getLocalDriver(DriverType driverType) {
        switch (driverType) {

            case CH:
                System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
                return new ChromeDriver();

            case FF:
                System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
                return new FirefoxDriver();

            case IE:
                throw new IllegalStateException("Not implemented driver");

            case SAFARI:
                throw new IllegalStateException("Not implemented driver");

            default:
                throw new IllegalStateException("Unknown driver type!");

        }
    }

    public WebDriver getRemoteDriver(DriverType driverType) {
        switch (driverType) {

            case CH:
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "XP");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "49.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
                try {

                    return new RemoteWebDriver(new URL("http://" + username + ":" + accessKey + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), caps);
//                    return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                } catch (MalformedURLException e) {
                    throw new IllegalStateException(e);
                }

            case FF:
                DesiredCapabilities fireFoxCaps = new DesiredCapabilities();
                fireFoxCaps.setCapability("os", "OS X");
                fireFoxCaps.setCapability("os_version", "Yosemite");
                fireFoxCaps.setCapability("browser", "Firefox");
                fireFoxCaps.setCapability("browser_version", "66.0 beta");
                fireFoxCaps.setCapability("resolution", "1920x1080");
                fireFoxCaps.setCapability("browserstack.local", "false");
                fireFoxCaps.setCapability("browserstack.selenium_version", "3.9.0");
                try {
//                    return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                    return new RemoteWebDriver(new URL("http://" + username + ":" + accessKey + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), fireFoxCaps);
                } catch (MalformedURLException e) {
                    throw new IllegalStateException(e);
                }
            case IE:
                throw new IllegalStateException("Not implemented driver");

            case SAFARI:
                throw new IllegalStateException("Not implemented driver");

            default:
                throw new IllegalStateException("Unknown driver type!");

        }
    }

}
