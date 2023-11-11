package com.webdrivermanager;

import com.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory{

    private DriverFactory() {
    }

    private final static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
    private static boolean runTestsRemotely = true;

    public static void setDriver(WebDriver driver) {
        tldriver.set(driver);
    }


    public static void initDriver(String browser) {
        if (tldriver.get() == null) {

            if (runTestsRemotely) {

                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    try {
                        setDriver(new RemoteWebDriver(new URL("http://localhost:4444"), options));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                } else if (browser.equalsIgnoreCase("firefox")) {
                    FirefoxOptions options = new FirefoxOptions();
                    try {
                        setDriver(new RemoteWebDriver(new URL("http://localhost:4444"), options));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else if (browser.equalsIgnoreCase("edge")) {
                    EdgeOptions options = new EdgeOptions();
                    try {
                        setDriver(new RemoteWebDriver(new URL("http://localhost:4444"), options));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
                tldriver.get().get(ConfigReader.initProperties().getProperty("url"));
            } else {
                //ConfigReader.initProperties().getProperty("browser").equalsIgnoreCase("chrome")
                if (browser.equalsIgnoreCase("chrome")) {
                    setDriver(new ChromeDriver());
                                   } else if (browser.equalsIgnoreCase("firefox")) {
                    setDriver(new FirefoxDriver());
                } else if (browser.equalsIgnoreCase("edge")) {
                    setDriver(new EdgeDriver());
                }
                tldriver.get().manage().deleteAllCookies();
                tldriver.get().manage().window().maximize();
                tldriver.get().get(ConfigReader.initProperties().getProperty("url"));

            }
        }
    }

    public static WebDriver getDriver() {
        return tldriver.get();
    }

    public static void tearDown() {
        WebDriver driver = tldriver.get();
        if (driver != null) {
            driver.quit();
            tldriver.remove();
        }
    }
}
