package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SmartBearWebOrdersPage {

    public SmartBearWebOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li")
    public List<WebElement> menuItems;

    @FindBy(css = "p[class='CheckUncheck']>a")
    public List<WebElement> checkUncheckAllButton;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkBoxes;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement familyAlbumSelection;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInputBox;

    @FindBy(css = "table[class='RadioList'] input")
    public List<WebElement> cardType;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement exprDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(css = "table[class='SampleTable']>tbody>tr:nth-child(2) td")
    public List<WebElement> customerOrderList;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelectedButton;

    @FindBy(id = "ctl00_MainContent_orderGrid")
    public WebElement table;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement message;



}