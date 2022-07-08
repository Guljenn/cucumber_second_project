package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.SmartBearLoginPage;
import pages.SmartBearWebOrdersPage;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropDownHandler;
import utils.Waiter;

import java.text.SimpleDateFormat;


public class SmartBearSteps {

    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    SmartBearWebOrdersPage smartBearWebOrdersPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearWebOrdersPage = new SmartBearWebOrdersPage();
    }


    @When("user enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        Assert.assertTrue(smartBearLoginPage.username.isDisplayed());
        smartBearLoginPage.username.sendKeys(userName);

    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        Assert.assertTrue(smartBearLoginPage.password.isDisplayed());
        smartBearLoginPage.password.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        Assert.assertTrue(smartBearLoginPage.loginButton.isDisplayed());
        smartBearLoginPage.loginButton.click();

    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String text) {
        Assert.assertTrue(smartBearLoginPage.invalidLoginMessage.isDisplayed());
        Assert.assertEquals(text, smartBearLoginPage.invalidLoginMessage.getText());

    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());

    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            Assert.assertTrue(smartBearWebOrdersPage.menuItems.get(i).isDisplayed());
            Assert.assertEquals(dataTable.asList().get(i), smartBearWebOrdersPage.menuItems.get(i).getText());
        }


    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String checkBox) {
        switch (checkBox) {
            case "Check All":
                smartBearWebOrdersPage.checkUncheckAllButton.get(0).click();
                Waiter.pause(2);
                break;
            case "Uncheck All":
                smartBearWebOrdersPage.checkUncheckAllButton.get(1).click();
                Waiter.pause(2);
                break;
            case "Delete Selected":
                smartBearWebOrdersPage.deleteSelectedButton.click();
                Waiter.pause(2);
                break;
            default:
//                throw new NotFoundException("Checkbox is not defined properly in the feature file!!!");
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i <= smartBearWebOrdersPage.checkBoxes.size() - 1; i++) {
            Assert.assertTrue(smartBearWebOrdersPage.checkBoxes.get(i).isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i <= smartBearWebOrdersPage.checkBoxes.size() - 1; i++) {
            Assert.assertFalse(smartBearWebOrdersPage.checkBoxes.get(i).isSelected());
        }
    }


    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        switch (menuItem) {
            case "Order":
                smartBearWebOrdersPage.menuItems.get(2).click();
                Waiter.pause(2);
                break;
            case "View all orders":
                smartBearWebOrdersPage.menuItems.get(0).click();
                Waiter.pause(2);
                break;
            default:
                throw new NotFoundException("Menu item is not defined properly in the feature file!!!");
        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String selection) {
        DropDownHandler.selectOptionByVisibleText(smartBearWebOrdersPage.familyAlbumSelection, selection);
        Waiter.pause(2);

    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        smartBearWebOrdersPage.quantityInputBox.sendKeys(String.valueOf(quantity));
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        smartBearWebOrdersPage.customerNameInputBox.sendKeys("John Doe");
        smartBearWebOrdersPage.streetInputBox.sendKeys("615 Clifton Drive");
        smartBearWebOrdersPage.cityInputBox.sendKeys("Plainfield");
        smartBearWebOrdersPage.stateInputBox.sendKeys("Illinois");
        smartBearWebOrdersPage.zipInputBox.sendKeys("60454");
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        smartBearWebOrdersPage.cardType.get(2).click();
        smartBearWebOrdersPage.cardNumber.sendKeys("2345789890871234");
        smartBearWebOrdersPage.exprDate.sendKeys("09/26");
        smartBearWebOrdersPage.processButton.click();
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String text) {
        for(int i = 1; i < smartBearWebOrdersPage.customerOrderList.size() -1; i++){
            Assert.assertTrue(smartBearWebOrdersPage.customerOrderList.get(i).isDisplayed());

        }
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        for (int i = 1; i < smartBearWebOrdersPage.customerOrderList.size() - 1; i++) {
            Assert.assertEquals(dataTable.asList().get(i), smartBearWebOrdersPage.customerOrderList.get(i).getText());
            //Assert.assertTrue(smartBearWebOrdersPage.customerOrderList.get(i).getText().contains(new SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date())));
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String table) {
        switch (table) {
            case "Delete":
                try {
                    Assert.assertFalse(smartBearWebOrdersPage.table.isDisplayed());
                } catch (NoSuchElementException e) {

                    Assert.assertTrue(true);
                }
                break;
        }
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, smartBearWebOrdersPage.message.getText());


    }
}