package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepagePage extends BasePage {

    public HomepagePage (WebDriver driver){
        super(driver);
    }

    private By inventoryListNumber = By.xpath("//div[@class='inventory_item']");
    private By homepageTitle = By.className("title");
    private By shoppingCartBadge = By.className("shopping_cart_badge");
    private By addToCartBTN1 = By.id("add-to-cart-sauce-labs-backpack");
    private By removeFromCartBTN1 = By.id("remove-sauce-labs-backpack");
    private By addToCartBTN2 = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeFromCartBTN2 = By.id("remove-sauce-labs-bike-light");
    private By menuBTN = By.id("react-burger-menu-btn");
    private By logoutBTN = By.id("logout_sidebar_link");



    public HomepagePage verifySuccessfulLogin (String expectedtext){
        String actualText = readText(homepageTitle);
        assertTextEquals(expectedtext, actualText);
        return this;
    }

    public HomepagePage clickOnMenuBTN (){
        click(menuBTN);
        return this;
    }

    public HomepagePage clickOnLogoutBTN (){
        click(logoutBTN);
        return this;
    }

    public HomepagePage numberofProducts (){
        int productCount = driver.findElements(inventoryListNumber).size();
        if (productCount==6){
            System.out.println("The number of products is: " + productCount);
            return this;
        }
        else{
            System.out.println("Unexpected number of products");
            return this;
        }
               
    }

    public HomepagePage addAndVerifyProduct1 (){
        click(addToCartBTN1);
        waitVisibilty(removeFromCartBTN1);
        return this;
    }

    public HomepagePage addAndVerifyProduct2 (){
        click(addToCartBTN2);
        waitVisibilty(removeFromCartBTN2);
        return this;
    }

    public HomepagePage goToCart (){
        click(shoppingCartBadge);
        return this;
    }


}
