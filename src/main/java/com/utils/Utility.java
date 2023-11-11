package com.utils;


import com.webdrivermanager.DriverFactory;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

public class Utility {


    public static void explicitWait(WebElement element, int sec){

        Wait<WebDriver> wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(sec));
        wait.until(d -> element.isDisplayed());
    }

    public static void fluentWait(int timeout,int polling){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class);
    }

    public static void implicitWait(){
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void takeScreenShot(){
              File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String timestamp = dateFormat.format(new Date());
        try {
            FileHandler.copy(scrFile,new File(System.getProperty("user.dir") + "/screenshots/screenshot"+timestamp +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
