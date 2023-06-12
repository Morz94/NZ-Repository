package Tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Pages.CheckoutInfoPage;
import Pages.CheckoutOverviewPage;
import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.MyCartPage;

public class ShoppingTests extends BaseTest {

    public LoginPage loginPage;
    public HomepagePage homePage;
    public MyCartPage myCart;
    public CheckoutInfoPage checkoutInfo;
    public CheckoutOverviewPage checkoutOverview;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String checkoutMessage = "Thank you for your order!";
        
@Test
public void numberOfItems() throws IOException{
    try{
    LoginPage loginPage = new LoginPage(driver);
    HomepagePage homePage = new HomepagePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.numberofProducts();    
    }
    catch(Exception e){
        File scrFile;
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter);
        FileUtils.copyFile(scrFile, new File("C:/Users/HP/Desktop/Scr" + formattedDate + ".png"));    
    }
}

@Test
public void verifyAddToCart() throws IOException{
    try{
    LoginPage loginPage = new LoginPage(driver);
    HomepagePage homePage = new HomepagePage(driver);
    MyCartPage myCart = new MyCartPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.addAndVerifyProduct1();
    homePage.addAndVerifyProduct2();
    homePage.goToCart();
    myCart.numberOfProductsFinalVerification(2); 
    }
    catch(Exception e){
        File scrFile;
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter);
        FileUtils.copyFile(scrFile, new File("C:/Users/HP/Desktop/Scr" + formattedDate + ".png"));
    }
}

@Test
public void verifyPriceOfItemsPlusTax() throws IOException{
    try{
    LoginPage loginPage = new LoginPage(driver);
    HomepagePage homePage = new HomepagePage(driver);
    MyCartPage myCart = new MyCartPage(driver);
    CheckoutInfoPage checkoutInfo = new CheckoutInfoPage(driver);
    CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.addAndVerifyProduct1();
    homePage.addAndVerifyProduct2();
    homePage.goToCart();
    myCart.numberOfProductsFinalVerification(2);
    checkoutInfo.continueToCheckout();
    checkoutOverview.getPriceAndCheck();
    }
    catch(Exception e){
        File scrFile;
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter);
        FileUtils.copyFile(scrFile, new File("C:/Users/HP/Desktop/Scr" + formattedDate + ".png"));
    }
}

@Test
public void checkoutMessageVerification() throws IOException{
    try{
    LoginPage loginPage = new LoginPage(driver);
    HomepagePage homePage = new HomepagePage(driver);
    MyCartPage myCart = new MyCartPage(driver);
    CheckoutInfoPage checkoutInfo = new CheckoutInfoPage(driver);
    CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.addAndVerifyProduct1();
    homePage.addAndVerifyProduct2();
    homePage.goToCart();
    myCart.numberOfProductsFinalVerification(2);
    checkoutInfo.continueToCheckout();
    checkoutOverview.getPriceAndCheck();
    checkoutOverview.verifyPurchace(checkoutMessage);    
    }
    catch(Exception e){
         File scrFile;
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter);
        FileUtils.copyFile(scrFile, new File("C:/Users/HP/Desktop/Scr" + formattedDate + ".png"));
    }

}
    
}
