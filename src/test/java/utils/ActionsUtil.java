package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {

    public static void rightClick(WebElement element){
        new Actions(Driver.getDriver()).contextClick(element).perform();
    }

    public static void moveToElement(WebElement element){
        new Actions(Driver.getDriver()).moveToElement(element).perform();
    }
}