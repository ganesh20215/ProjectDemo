package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountElement;

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getTextMyAccountElement(){
        return myAccountElement.getText();
    }
}
