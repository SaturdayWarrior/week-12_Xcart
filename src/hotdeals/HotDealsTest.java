package hotdeals;

import homepage.Utilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HotDealsTest extends Utilities {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void Browser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        mouseHover("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']");

        //Mouse hover on the “sale” link and click
        mouseHoverClick("//li[@class='leaf has-sub']//li[1]//a[1]");
        //3 Verify the text “Sale”
        verifyPageNavigation("Sale", By.xpath("//h1[contains(.,'Sale')]"), "Wrong text");
        // Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverClick("//span[@class='sort-by-value']");
        WebElement dropdown1 = driver.findElement(By.xpath("//a[normalize-space()='Name A - Z']"));
        dropdown1.click();
        //Verify that the product arrange alphabetically
        close();

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        //Mouse hover on the “Hot deals” link
        mouseHover("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']");

        // Mouse hover on the “Sale”  link and click
        mouseHoverClick("//li[@class='leaf has-sub']//li[1]//a[1]");

        // Verify the text “Sale”
        verifyPageNavigation("Sale", By.xpath("//h1[contains(.,'Sale')]"), "Wrong text");

        // Mouse hover on “Sort By” and select “Price Low-High”
        mouseHoverClick("//span[@class='sort-by-value']");
        WebElement dropdown1 = driver.findElement(By.xpath("//a[contains(.,'Price Low - High')]"));
        dropdown1.click();

        // Verify that the product’s price arrange Low to High
        // verifyPageNavigation("Price Low-High", By.xpath("//a[contains(text(),'Price Low - High')]"), "product should not in Low to High ");
        close();
    }

    @Test
    public void verifySaleProductsArrangeByRates() {
        mouseHover("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']");

        //Mouse hover on the “sale” link and click
        mouseHoverClick("//li[@class='leaf has-sub']//li[1]//a[1]");
        //3 Verify the text “Sale”
        verifyPageNavigation("Sale", By.xpath("//h1[contains(.,'Sale')]"), "Wrong text");

        //Mouse hover on “Sort By” and select “Name Rates”
        selectFromDropDown(By.xpath("//a[@data-sort-by=\"translations.name\" and @data-sort-order='asc']"),"Rate");

        verifyPageNavigation("Rates", By.xpath("//span[contains(text(),'Rates')]"), "product should not in ");
        close();
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() {
        mouseHover("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']");

        //Mouse hover on the “Bestsellers” link and click
        mouseHoverClick("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']//span[contains(.,'Bestsellers')]");

        //3 Verify the text “Bestsellers”
        //verifyPageNavigation("Bestsellers", By.xpath("//h1[contains(.,'Bestsellers')]"), "Wrong text");

        // Mouse hover on “Sort By” and select “Name Z - A”
        selectFromDropDown(By.xpath("//a[contains(text(),'Name Z - A')]"),"Z - A");

        //Verify that the product arrange Z to A
        verifyPageNavigation("Name Z - A", By.xpath("//div[@id='main-wrapper']"), "product arranging wrong");
        close();
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() {
        //Mouse hover on the “Hot deals” link
        mouseHover("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']");

        //Mouse hover on the “Bestsellers” link and click
        mouseHoverClick("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']//span[contains(.,'Bestsellers')]");

        //3 Verify the text “Bestsellers”
        verifyPageNavigation("Bestsellers", By.xpath("//h1[contains(.,'Bestsellers')]"), "Wrong text");

        //Mouse hover on “Sort By” and select “Price High-Low”
        mouseHoverClick("//span[@class='sort-by-value']");
        WebElement dropdown1 = driver.findElement(By.xpath("//a[@data-sort-by=\"p.price\" and @data-sort-order=\"desc\"]"));
        dropdown1.click();
        close();
        //2.5 Verify that the product’s price arrange High to Low
        //verifyPageNavigation("Price High - Low", By.xpath("//ul[@class=\"products-grid grid-list\"]"), "");
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() {
        //Mouse hover on the “Hot deals” link
        mouseHover("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']");

        //Mouse hover on the “Bestsellers” link and click
        mouseHoverClick("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf has-sub']//span[contains(.,'Bestsellers')]");

        //3 Verify the text “Bestsellers”
        verifyPageNavigation("Bestsellers", By.xpath("//h1[contains(.,'Bestsellers')]"), "Wrong text");

        //Mouse hover on “Sort By” and select “Rates”
        mouseHoverClick("//span[@class='sort-by-value']");
        WebElement dropdown1 = driver.findElement(By.xpath("//a[@data-sort-by=\"r.rating\"]"));
        dropdown1.click();
        close();
    }

    @After
    public void close() {
        closeBrowser();
    }
}


