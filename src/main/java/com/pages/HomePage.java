package com.pages;

import com.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    private final By menu = By.id("react-burger-menu-btn");

    private final By sideBarLink = By.id("inventory_sidebar_link");

    public  void clickOnSideBarLink(){

      driver.findElement(menu).click();
      WebElement sideBarLinkEle = driver.findElement(sideBarLink);
      Utility.explicitWait(sideBarLinkEle,5);
        sideBarLinkEle.click();


    }
}
