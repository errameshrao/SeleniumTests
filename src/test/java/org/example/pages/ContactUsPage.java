package org.example.pages;

import org.example.Utils.ActionMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ContactUsPage extends ActionMethods {
    private WebDriver driver;

    @FindBy(xpath = "//iframe[@title='Form 0']")
    private WebElement iframe;
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyName;
    @FindBy(xpath = "//input[@name='jobtitle']")
    private WebElement jobTitle;
    @FindBy(xpath = "//select[@name='property_type']")
    private WebElement propertyType;
    @FindBy(xpath = "//select[@name='country_']")
    private WebElement country;
    @FindBy(xpath = "//select[@name='leadsource']")
    private WebElement whereDidYouHearAboutUs;
    @FindBy(xpath = "//textarea[@name='customer_notes__c']")
    private WebElement message;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void submitContactUsForm(String firstName, String lastName, String email, String phoneNumber,
                                    String companyName, String jobTitle, String propertyType, String country,

                                    String whereDidYouHearAboutUs, String message) {
        driver.switchTo().frame(iframe);
        scrollIntoView(driver,this.firstName);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.phoneNumber.sendKeys(phoneNumber);
        this.companyName.sendKeys(companyName);
        this.jobTitle.sendKeys(jobTitle);
        selectFromDropDown(this.propertyType,propertyType);
        selectFromDropDown(this.country,country);
        selectFromDropDown(this.whereDidYouHearAboutUs,whereDidYouHearAboutUs);
        this.message.sendKeys(message);
    }
}
