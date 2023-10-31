import Helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShipingAndCheckOutPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class SeleniumTest extends BaseTest {
    @Test
    public void loginValidUserTest() throws IOException, InterruptedException
    {
        Thread.sleep(5000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInValidUserCredentials();
        WebElement confirmationMessageWebElement = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, rick vickey!']"));
        String actualConfirmationMessage = confirmationMessageWebElement.getText();
        String expectedConfirmationMessage = "Welcome, rick vickey!";
        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage);
    }
    @Test
    public void  loginInvalidUserCredentialTest() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage (driver);
        loginPage.signInInvalidUserCredentials();
        WebElement errorWebElement = driver.findElement(By.xpath("//div[@class='message-error error message']"));
        String actualErrorMessage = errorWebElement.getText();
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        Thread.sleep(5000);
    }
    @Test
    public void placeAnOrderTest() throws InterruptedException
    {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.signInValidUserCredentials();
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCartAndCheckOut();
        ShipingAndCheckOutPage shipingAndCheckOutPage = new ShipingAndCheckOutPage(driver);
       WebElement orderConfirmationMessage = driver.findElement(By.xpath("//span[@class='base']"));
       String actualOrderCompletionMessage = orderConfirmationMessage.getText();
       String expectedOrderCompletionMessage = "Thank you for your purchase!";
       Assert.assertEquals(actualOrderCompletionMessage,expectedOrderCompletionMessage);
    }
}