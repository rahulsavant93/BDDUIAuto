package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By userName = By.id("user-name");
    private final By passWord = By.id("password");
    private final By loginButton = By.id("login-button");

    public String getTitle(){
        return driver.getTitle();
    }

    public void enterUserName(String userName1){
        driver.findElement(userName).sendKeys(userName1);

    }
    public void enterPassword(String pwd){

        driver.findElement(passWord).sendKeys(pwd);

    }

    public void clickLoginButton(){

        driver.findElement(loginButton).click();
    }




}
