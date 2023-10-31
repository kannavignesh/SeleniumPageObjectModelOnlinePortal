package pages;
import Helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
public class ShipingAndCheckOutPage extends BaseTest
{
    public ShipingAndCheckOutPage(WebDriver driver)
    {
        BaseTest.driver=driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    WebElement shippingMethod = driver.findElement(By.xpath("//div[@class='shipping-address-item selected-item']"));
    WebElement bestWayRadioButton = driver.findElement(By.xpath("//input[@name='ko_unique_2']"));
    WebElement nextButton = driver.findElement(By.xpath("//button[@class='button action continue primary']"));
    WebElement placeOrderButton = driver.findElement(By.xpath("//button[@title='Place Order']"));
    public void confirmShippingAndPlaceOrder() throws InterruptedException {
        shippingMethod.click();
        bestWayRadioButton.click();
        nextButton.click();
        Thread.sleep(5000);
        placeOrderButton.click();
        Thread.sleep(5000);
    }
}