package Tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Pages.HomepagePage;
import Pages.LoginPage;

public class LoginTests extends BaseTest{

    public LoginPage loginPage;
    public HomepagePage homepagePage;
    
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String invalidUserame = "test";
    String invalidCredentialsError = "Epic sadface: Username and password do not match any user in this service";
    String homePageTitle = "Products";

    

    @Test
    public void verifySuccessfulLogin() throws IOException{
        try{
        LoginPage loginPage = new LoginPage(driver);
        HomepagePage homepage = new HomepagePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homepage.verifySuccessfulLogin(homePageTitle);
       
        
        }catch(Exception e){
            File scrFile;
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter);
        FileUtils.copyFile(scrFile, new File("C:/Users/HP/Desktop/Scr" + formattedDate + ".png")); 
        }
    }

    @Test
    public void verifyUnsuccesfulLoginEmptyUsername() throws IOException{
        try{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(emptyUsername, password);
        loginPage.verifyUnsuccesfulLogin(emptyUsernameError);
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
    public void verifyUnsuccesfulLoginEmptyPassword() throws IOException{
        try{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, emptyPassword);
        loginPage.verifyUnsuccesfulLogin(emptyPasswordError);    
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
    public void verifyUnsuccesfulLoginInvalidUsername() throws IOException{
        try{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(invalidUserame, password);
        loginPage.verifyUnsuccesfulLogin(invalidCredentialsError);
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
    public void verifyLogout() throws IOException{
        try{
        LoginPage loginPage = new LoginPage(driver);
        HomepagePage homepage = new HomepagePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homepage.verifySuccessfulLogin(homePageTitle);
        homepage.clickOnMenuBTN();
        homepage.clickOnLogoutBTN();
        loginPage.verifyLogout();
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
