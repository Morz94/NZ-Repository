package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    public CheckoutInfoPage(WebDriver driver){
        super(driver);
    }

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueBTN = By.id("continue");

    public CheckoutInfoPage continueToCheckout(){
        writeText(firstNameField, "1");
        writeText(lastNameField, "1");
        writeText(postalCodeField, "1");
        click(continueBTN);
        return this;
        
    }
    
}
