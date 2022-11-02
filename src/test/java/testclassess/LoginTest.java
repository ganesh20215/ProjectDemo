package testclassess;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    LoginTest() {
        super();
    }

    @BeforeMethod
    public void beforeMethod() {
        initialization();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(description = "Verify login with valid username & password")
    public void verifyLogin() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.closeAdvertiesWindow();
        homePage.closeAdvertiesSecondWindow();
        homePage.signInClick();
        loginPage.loginUser(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertEquals(myAccountPage.getTextMyAccountElement(), "MY ACCOUNT", "Text should be MY ACCOUNT");
		System.out.println("Hiii");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
