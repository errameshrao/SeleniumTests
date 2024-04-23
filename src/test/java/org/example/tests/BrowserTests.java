package org.example.tests;

import org.example.Utils.SetupDriver;
import org.example.Utils.WebDriverUtil;
import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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

    @Test(dataProvider = "signupData")
    public void Test1(String firstName, String lastName, String email, String phoneNumber,
                      String companyName, String jobTitle, String propertyType, String country,
                      String whereDidYouHearAboutUs, String message) {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        WebDriverUtil webDriverUtil = new WebDriverUtil();
        Assert.assertEquals(homePage.getLogoName(), "Drive Ancillary Revenue While Delivering A 5-Star Guest Experience");
        homePage.clickAcceptCookies();
        homePage.clickCompanyMenu();
        homePage.clickContactUs();

        contactUsPage.submitContactUsForm(firstName, lastName, email, phoneNumber, companyName, jobTitle, propertyType, country, whereDidYouHearAboutUs, message);
    }

    @DataProvider(name = "signupData")
    public Object[][] signupData() {
        return new Object[][]{
                {"David", "Lehman", "david.lehman@yahoo.com", "8002683750",
                        "book4time", "Senior Sales Manager", "Single Location Day Spa",
                        "United States", "Social Media", "I am looking for CRM demo"}
        };
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
