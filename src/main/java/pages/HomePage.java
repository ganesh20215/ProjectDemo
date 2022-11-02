package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    @FindBy(xpath = "//a[@class='user-controls__ul__li__a']")
    WebElement signIn;

    @FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    WebElement advertiesWindow;

    @FindBy(xpath = "//a[@title='Close']")
    WebElement advertiseSecondClose;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void signInClick() throws InterruptedException {
        signIn.click();
    }

    public void closeAdvertiesWindow(){
        advertiesWindow.click();
    }

    public void closeAdvertiesSecondWindow(){
        advertiseSecondClose.click();
    }
}
