package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utilities {
    String baseURL = "https://mobile.x-cart.com/";

    @Before
    public void setBrowser() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Shipping')]")).click();
        //selectMenu("Shipping");
        verifyPageNavigation("Shipping", By.xpath("//h1[@id='page-title']"), "Unsuccessful navigation to Shipping page");
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        // driver.findElement(By.xpath("//div[@id='header-area']//span[contains(text(),'New!')]")).click();
        selectMenu("New!");
        verifyPageNavigation("New arrivals", By.xpath("//h1[@id='page-title']"), "Failed navigation to New! page");
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        selectMenu("Coming soon");
        verifyPageNavigation("Coming soon", By.xpath("//h1[@id='page-title']"), "Failed navigation to Coming soon page");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        selectMenu("Contact us");
        verifyPageNavigation("Contact us", By.xpath("//h1[@id='page-title']"), "Failed navigation to Contact us page");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
