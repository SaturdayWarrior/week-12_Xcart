package homepage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilities extends BaseClass {
    public void clickOnElement(By by) {
        WebElement loginLink = BaseClass.driver.findElement(by);
        loginLink.click();
    }

    public String getTextFromElement(By by) {
        return BaseClass.driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        BaseClass.driver.findElement(by).sendKeys(text);
    }

    public void selectMenu(String menu) {
        BaseClass.driver.findElement(By.linkText(menu)).click();
    }

    public String verifyPageNavigation(String eM, By by, String msg) {
        String aM = BaseClass.driver.findElement(by).getText();
        Assert.assertEquals(msg, aM, eM);
        return msg;
    }
    public void sortProductsCompareList(String sortBy) {
        List<WebElement> products = driver.findElements(By.linkText(sortBy));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sort by failed", names, sortedNames);
    }
    public void selectFromDropDown(By by, String value) {
        WebElement dropDownObject = driver.findElement(by);
        dropDownObject.click();
        Select selectObject = new Select(dropDownObject);
        selectObject.selectByValue(value);
    }


    public void mouseHover(String mouseH) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(mouseH))).build().perform();
    }

    public void mouseHoverClick(String mouseH1) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(mouseH1))).click().build().perform();

    }
}