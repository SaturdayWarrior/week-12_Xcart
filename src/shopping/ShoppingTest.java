package shopping;

import homepage.Utilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShoppingTest extends Utilities {

        String baseURL = "https://mobile.x-cart.com/";

        @Before
        public void setBrowser() {
            openBrowser(baseURL);
        }

        @Test
        public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
            mouseHover("//div[@id='header-area']//span[contains(text(),'Hot deals')]");
            Thread.sleep(3000);
            mouseHoverClick("//div[@id='header-area']//span[contains(text(),'Sale')]");
            Thread.sleep(3000);
            verifyPageNavigation("Sale", By.xpath("//h1[@id='page-title' and contains(text(),'Sale')]"), "Failed navigation to sale");
            mouseHover("//span[@class='sort-by-value']");
            Thread.sleep(3000);
            clickOnElement(By.xpath("//a[contains(text(),'Name A - Z')]"));
            Thread.sleep(3000);
            clickOnElement(By.xpath("//a[contains(text(),'Avengers: Fabrikations Plush [Related Products]')]"));
            Actions act = new Actions(driver);
            Thread.sleep(3000);
            act.doubleClick(driver.findElement(By.xpath("//input[@id='amount16']"))).perform();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='amount16']")).sendKeys("2");
            clickOnElement(By.xpath("//button[contains(@type,'submit')]//span[contains(text(),'Add to cart')]"));
            verifyPageNavigation("Product has been added to your cart", By.xpath("//div[@id='status-messages']//ul"), "Product not added to cart");
            clickOnElement(By.xpath("//div[@class='minicart-items-number']"));
            Thread.sleep(5000);
            clickOnElement(By.xpath("//a[@class='regular-button cart']"));
            Thread.sleep(5000);

            verifyPageNavigation("$29.98", By.xpath("//div[@id='shopping-cart']//span[@class='cart-subtotal']//span[@class='surcharge']"), "Subtotal is not $29");
            verifyPageNavigation("$36.00", By.xpath("//div[@id='cart-right']//li[@class='total']//span[@class='surcharge']"), "Total is not 36");
            clickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));
            verifyPageNavigation("Log in to your account", By.xpath("//h3[contains(text(),'Log in to your account')]"), "Go to checkout button click fail");

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String email = "johnpeter" + timeStamp + "@test.com";
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
            Thread.sleep(3000);

            clickOnElement(By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]"));
            Thread.sleep(3000);

            verifyPageNavigation("Secure Checkout", By.xpath("//h1[contains(.,'Secure Checkout')]"), "Cesure checkout page navigation failed");
            sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "kim");
            sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "jon");
            sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "18 highroad");
            driver.findElement(By.xpath("//input[@id='shippingaddress-city']")).clear();
            sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), "London");
            selectFromDropDown(By.xpath("//select[@id='shippingaddress-country-code']"), "GB");
            sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "London");
            driver.findElement(By.xpath("//input[@id='shippingaddress-zipcode']")).clear();
            sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "SW169bl");
            clickOnElement(By.xpath("//input[@id='create_profile']"));
            Thread.sleep(4000);
            sendTextToElement(By.xpath("//input[@id='password']"), "Jbvdh@4673");
            Thread.sleep(4000);

            mouseHover("//input[@id='method128']");
            clickOnElement(By.xpath("//input[@id='method128']"));
            clickOnElement(By.xpath("//input[@id='pmethod6']"));

            verifyPageNavigation("$37.03", By.xpath("//div[@class='total clearfix']//span[@class='surcharge']"), "Total is not $37.03");
            Thread.sleep(3000);
            clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
            Thread.sleep(3000);
            verifyPageNavigation("Thank you for your order", By.xpath("//h1[@id='page-title']"), "Failed to place the order");
        }

        @Test
        public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
            mouseHover("//div[@id='header-area']//span[contains(text(),'Hot deals')]");
            Thread.sleep(3000);

            mouseHoverClick("//div[@id='header-area']//span[contains(text(),'Bestsellers')]");
            Thread.sleep(3000);

            verifyPageNavigation("Bestsellers", By.xpath("//h1[@id='page-title' and contains(text(),'Bestsellers')]"), "Failed navigation to sale");
            mouseHover("//span[@class='sort-by-value']");
            mouseHoverClick("//a[contains(.,'Name A - Z')]");
            sortProductsCompareList("Name A - Z");
            mouseHover("//a[contains(@class,'product-thumbnail next-previous-assigned')]//img[contains(@alt,'Vinyl Idolz: Ghostbusters')]");
            clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-13')]"));
            verifyPageNavigation("Product has been added to your cart", By.xpath("//div[@id='status-messages']//ul"), "Product not added to cart");
            Thread.sleep(3000);

            clickOnElement(By.xpath("//div[@title='Your cart']"));
            clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
            verifyPageNavigation("Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"), "SHopping cart does not have any item");
            clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
            Thread.sleep(3000);

            Alert alertObj = driver.switchTo().alert();
            String alertMsg = driver.switchTo().alert().getText();
            alertObj.accept();

            verifyPageNavigation("Item(s) deleted from your cart", By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"), "Failed to remove item from the cart");
            Thread.sleep(3000);
            verifyPageNavigation("Your cart is empty", By.xpath("//h1[@id='page-title']"), "Cart is not empty");
        }


        @After
        public void tearDown() {
            closeBrowser();
        }
}
