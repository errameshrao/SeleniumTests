package org.example.tests;

import org.example.Utils.SetupDriver;
import org.example.Utils.WebDriverUtil;
import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserTests {

    WebDriver driver;

    private SetupDriver setupDriver;

    @Parameters("URL")
    @BeforeClass
    public void setUp(String URL) {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("Browser started");
    }

    @Test
    public void Test1() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        WebDriverUtil webDriverUtil = new WebDriverUtil();
        Assert.assertEquals(homePage.getLogoName(), "Drive Ancillary Revenue While Delivering A 5-Star Guest Experience");
        homePage.clickAcceptCookies();
        homePage.clickCompanyMenu();
        homePage.clickContactUs();

        contactUsPage.submitContactUsForm("David","Lehman","david.lehman@yahoo.com","8002683750",
                "book4time","Senior Sales Manager","Single Location Day Spa",
                "United States","Social Media","I am looking for CRM demo");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
