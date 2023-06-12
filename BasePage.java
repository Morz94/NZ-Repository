package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibilty (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void writeText (By elementBy, String text){
        waitVisibilty(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void click (By elementBy){
        waitVisibilty(elementBy);
        driver.findElement(elementBy).click();
    }

    public String readText (By elementBy){
        waitVisibilty(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertTextEquals (String expectedText, String actualText){
        org.junit.Assert.assertEquals(expectedText, actualText);

    }
    
    public int countItems (By elementBy){
        waitVisibilty(elementBy);
        return driver.findElements(elementBy).size();
    }

      
    
}
