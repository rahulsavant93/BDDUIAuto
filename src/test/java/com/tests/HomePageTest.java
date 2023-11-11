package com.tests;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ConfigReader;
import com.utils.Utility;
import com.webdrivermanager.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest {

    private HomePage homepage;


    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        // String browserName = ConfigReader.initProperties().getProperty("browser");
        DriverFactory.initDriver(browser);
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterUserName(ConfigReader.initProperties().getProperty("user"));
        loginPage.enterPassword(ConfigReader.initProperties().getProperty("pwd"));
        loginPage.clickLoginButton();
        Utility.implicitWait();
        homepage = new HomePage(DriverFactory.getDriver());
    }

    @Test
    public void checkAllItems() {

        homepage.clickOnSideBarLink();
        Thread thread = new Thread();
        System.out.println(thread.getId());
    }

    @AfterClass
    public void quit() {
        DriverFactory.tearDown();
    }

}
