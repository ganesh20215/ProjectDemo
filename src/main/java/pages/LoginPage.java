package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="username")
    WebElement userName;

    @FindBy(id="password")
    WebElement passWord;

    @FindBy(name = "login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userNames, String Passwords){
        userName.sendKeys(userNames);
        passWord.sendKeys(Passwords);
        loginBtn.click();
    }
}
