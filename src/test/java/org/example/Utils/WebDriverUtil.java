package org.example.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverUtil {

    public void wait(WebDriver driver,long waitTime){
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    public void waitTillElementVisible(WebDriver driver, WebElement element){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
