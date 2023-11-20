package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseURL = "https://www.saucedemo.com/"; // set base url

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expected = "Products";
        String actual = driver.findElement(By.xpath("//span[text() = 'Products']")).getText();
        Assert.assertEquals("Correct Message not Displayed",expected,actual);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int actual = products.size();
        int expected = 6;
        Assert.assertEquals("Correct Amount not Displayed",expected,actual);

    }

    @After
    public void tearDown(){closeBrowser();}


}
