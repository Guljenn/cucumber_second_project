package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SmartBearLoginPage {

    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[type='text']")
    public WebElement username;

    @FindBy(css = "input[type='password']")
    public WebElement password;

    @FindBy(css = "input[value='Login']")
    public WebElement loginButton;

    @FindBy(css = "span[class='error']")
    public WebElement invalidLoginMessage;


}
