/**
 * 2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */


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
        System.out.println("Actual Product Items Found : " + actual);
        int expected = 6;
        System.out.println("Expected Product Items : " + expected);
        Assert.assertEquals("Correct Amount not Displayed",expected,actual);

    }

    @After
    public void tearDown(){closeBrowser();}


}
