package org.example.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SetupDriver {

    public WebDriver getWebDriver(String driverType) {
        switch (driverType) {
            case "Chrome":
                return new ChromeDriver();
            case "Firefox":
                return new FirefoxDriver();
            default:
                return new InternetExplorerDriver();

        }
    }
}
