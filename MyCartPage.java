package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCartPage extends BasePage {

    public MyCartPage (WebDriver driver){
        super(driver);
    }

    private By cartListNumber = By.cssSelector("div.cart_contents_container div.cart_list div.cart_item");
    private By checkoutBTN = By.id("checkout");
    private By continueShoppingBTN = By.id("continue-shopping");

    
    public MyCartPage numberOfProductsFinalVerification(int expectedNumber){

        int cartProductCount = driver.findElements(cartListNumber).size();
        if(cartProductCount==expectedNumber){
            System.out.println("The number of products in cart is " + cartProductCount);
            click(checkoutBTN);
            return this;
        }
        else {
            System.out.println("Error: Unexpected number of products in cart");
            click(continueShoppingBTN);
            return this;
        }

    }
}
