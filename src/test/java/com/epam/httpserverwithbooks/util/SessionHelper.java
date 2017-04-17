package com.epam.httpserverwithbooks.util;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class SessionHelper {
    public static DesiredCapabilities getBrowserCaps(String browser) {
        DesiredCapabilities capabilities = null;

        final String CHROMEDRIVER_WIN_PATH = "src/browserdrivers/chromedriver.exe";
        final String GECKODRIVER_WIN_PATH = "src/browserdrivers/geckodriver.exe";

        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_WIN_PATH);
        ChromeOptions chrOpt = new ChromeOptions();
        chrOpt.addArguments("test-type");
        chrOpt.addArguments("disable-plugins");
        chrOpt.addArguments("disable-extensions");
        chrOpt.addArguments("start-maximized");
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chrOpt);
        /*
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_WIN_PATH);
                ChromeOptions chrOpt = new ChromeOptions();
                chrOpt.addArguments("test-type");
                chrOpt.addArguments("disable-plugins");
                chrOpt.addArguments("disable-extensions");
                chrOpt.addArguments("start-maximized");
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chrOpt);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", GECKODRIVER_WIN_PATH);
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                capabilities.setBrowserName("firefox");
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable("driver", Level.SEVERE);
                logPrefs.enable("server", Level.SEVERE);
                logPrefs.enable("browser", Level.SEVERE);
                capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                break;
            default:
                System.out.println("Browser is not supported");
        }*/
        return capabilities;
    }

    public static String selectBrowser() {
        String browserName;
        String browserFromProperty = "chrome";
        String browserFromCommandLine = System.getProperty("browser");
        if (browserFromProperty == null && browserFromCommandLine == null) {
            browserName = "firefox";
        } else if (browserFromProperty == null) {
            browserName = browserFromCommandLine;
        } else if (browserFromCommandLine == null) {
            browserName = browserFromProperty;
        } else {
            browserName = browserFromCommandLine;
        }
        return browserName;
    }

}
