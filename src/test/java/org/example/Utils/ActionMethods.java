package org.example.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionMethods {


    public void hoverOverElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void clickElement(WebDriver driver, WebElement element) {
            element.click();
    }

    public void jsClickElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void selectFromDropDown(WebElement element,String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}



