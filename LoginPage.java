package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    private String baseURL = "https://www.saucedemo.com/";
    private By usernameBy = By.id("user-name");
    private By passwordBy = By.id("password");
    private By loginBTN = By.id("login-button");
    private By errorContainer = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public LoginPage login (String username, String password){
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginBTN);
        return this;
    }
    
    public LoginPage verifyUnsuccesfulLogin (String expectedText){
        String actualText = readText(errorContainer);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public LoginPage verifyLogout (){
        waitVisibilty(usernameBy);
        waitVisibilty(passwordBy);
        waitVisibilty(loginBTN);
        return this;
    }


}
