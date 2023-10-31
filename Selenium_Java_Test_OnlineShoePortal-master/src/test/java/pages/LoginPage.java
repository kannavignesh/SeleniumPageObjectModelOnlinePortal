package pages;
import Helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.time.Duration;

public class LoginPage extends BaseTest
{
   public LoginPage(WebDriver driver)
    {
        BaseTest.driver = driver;
        //driver.manage().timeouts().implicitlyWait(Duration.);
    }
    //private readonly WebElement signInOptionHeader;
      WebElement
           signInOptionHeader = driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));
    WebElement emailTextBox = driver.findElement(By.id("email"));
    WebElement passwordTextBox = driver.findElement(By.id("pass"));
    WebElement signInButton = driver.findElement(By.xpath("(//button[@id='send2'])[1]"));
        public void signInValidUserCredentials() throws InterruptedException {
            Thread.sleep(5000);
            signInOptionHeader.click();
            Thread.sleep(2000);
            emailTextBox.click();
            emailTextBox.sendKeys("kannavigneshece@gmail.com");
            passwordTextBox.click();
            passwordTextBox.sendKeys("Catchme_098");
            signInButton.click();
            Thread.sleep(5000);
        }
        public void signInInvalidUserCredentials() throws InterruptedException {
            signInOptionHeader.click();
            Thread.sleep(2000);
            emailTextBox.click();
            emailTextBox.sendKeys("dericjames@gmail.com");
            passwordTextBox.click();
            passwordTextBox.sendKeys("Catchme");
            signInButton.click();
        }
}