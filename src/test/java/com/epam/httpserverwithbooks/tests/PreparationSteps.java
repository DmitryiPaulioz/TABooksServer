/*package com.epam.httpserverwithbooks.tests;

import com.epam.httpserverwithbooks.driver.DriverSingleton;
import com.epam.httpserverwithbooks.util.SessionHelper;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;

public class PreparationSteps {

    protected static final String START_PAGE_URL = "localhost";
    protected static DesiredCapabilities capabilities;
    protected WebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        String browserName = SessionHelper.selectBrowser();
        if ((capabilities = SessionHelper.getBrowserCaps(browserName.toLowerCase())) == null) {
            throw new NoSuchSessionException("Required parameters can't be set");
        }
    }

    @BeforeMethod
    public void initWebDriver() throws InterruptedException {
        driver = DriverSingleton.getDriver(capabilities);
        System.out.println("Switch-over to PreparationSteps after running webdriver");
        driver.navigate().to(START_PAGE_URL);
        System.out.println("Passed to start URL ");
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
*/