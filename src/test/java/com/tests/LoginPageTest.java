package com.tests;

import com.pages.LoginPage;
import com.utils.ConfigReader;
import com.utils.Utility;
import com.webdrivermanager.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(CustomListner.class)

public class LoginPageTest {

    private LoginPage loginPage;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        // String browserName = ConfigReader.initProperties().getProperty("browser");
        DriverFactory.initDriver(browser);
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @Test(priority = 1)
    public void verifyTitle() {
        Thread thread = new Thread();
        System.out.println(thread.getId());
        String title = loginPage.getTitle();
        Assert.assertEquals(title, ConfigReader.initProperties().getProperty("loginPageExpectedTitle"));
        Utility.takeScreenShot();
    }


    @Test(priority = 2)
    @Parameters({"user", "pwd"})
    public void loginToHomePage(String user, String pwd) {

        //  loginPage.enterUserName(ConfigReader.initProperties().getProperty("user"));    //using properties file
        loginPage.enterUserName(user);     //using TestNG parameters from testNGfile

        //loginPage.enterPassword(ConfigReader.initProperties().getProperty("pwd"));    //using properties file
        loginPage.enterPassword(pwd);

        loginPage.clickLoginButton();

    }

    @AfterClass
    public void quit() {
        DriverFactory.tearDown();
    }
}
