package org.example.pages;

import org.example.Utils.ActionMethods;
import org.example.Utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends ActionMethods {
    private WebDriver driver;

    @FindBy(xpath="//h2[contains(text(),'Drive')]")
    private WebElement logoName;

    @FindBy(xpath = "//a[text()='Company']")
    private WebElement companyMenu;
    @FindBy(xpath ="//a[@href=\"https://book4time.com/contact/\"]")
    private WebElement contactUs;
    @FindBy(xpath = "//a[@class='rcc-accept-btn']")
    private WebElement acceptCookies;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90),this);
    }

    public String getLogoName() {
        return logoName.getText();
    }

    public void clickCompanyMenu() {
        hoverOverElement(driver, companyMenu);
    }

    public void clickContactUs() {
        WebDriverUtil webDriverUtil = new WebDriverUtil();
        webDriverUtil.waitTillElementVisible(driver, contactUs);
        clickElement(driver, contactUs);
    }

    public void clickAcceptCookies() {
        clickElement(driver,acceptCookies);
    }
}
