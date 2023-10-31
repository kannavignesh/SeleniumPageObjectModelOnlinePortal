package pages;

import Helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage extends BaseTest {
    public ProductPage(WebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    WebElement menSelection = driver.findElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));
       //menSelection.click();
    WebElement filterTopSelection = driver.findElement(By.xpath("//a[contains(text(),'Tops')]"));
       /*filterTopSelection.click();
       Thread.sleep(3000);*/
    WebElement selectProductCassiusSparringTank = driver.findElement(By.xpath("//img[@alt='Cassius Sparring Tank']"));
       //selectProductCassiusSparringTank.click();
    WebElement sizeSelectionXl = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-170']"));
      // sizeSelectionXl.click();
    WebElement colorBlue = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']"));
       //colorBlue.click();
    WebElement quantityInputBox = driver.findElement(By.id("qty"));
      /* quantityInputBox.clear();
       quantityInputBox.sendKeys("2");*/
    WebElement productTittle = driver.findElement(By.xpath("//span[@class='base']"));
    String expectedProductTittle = productTittle.getText();
    WebElement productPrice = driver.findElement(By.xpath("//span[@class='price'][normalize-space()='$18.00']"));
    String expectedProductPrice = productPrice.getText();
    WebElement addtoCartButton = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
      /* addtoCartButton.click();
       Thread.sleep(3000);
*/
      WebElement shoppingCartOptionInSucessMessage = driver.findElement(By.xpath("//a[normalize-space()='shopping cart']"));
    WebElement proceedToCheckout = driver.findElement(By.xpath("//span[normalize-space()='Proceed to Checkout']"));

    public void addProductToCartAndCheckOut() throws InterruptedException {
        menSelection.click();
        filterTopSelection.click();
        Thread.sleep(3000);
        selectProductCassiusSparringTank.click();
        sizeSelectionXl.click();
        colorBlue.click();
        quantityInputBox.clear();
        quantityInputBox.sendKeys("2");
        addtoCartButton.click();
        Thread.sleep(3000);
        shoppingCartOptionInSucessMessage.click();
        Thread.sleep(5000);
        proceedToCheckout.click();
        Thread.sleep(3000);
    }
}
