package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    private By subtotalLabel = By.className("summary_subtotal_label");
    private By taxLabel = By.className("summary_tax_label");
    private By totalPriceLabel = By.cssSelector("div.summary_info_label.summary_total_label");
    private By finishBTN = By.id("finish");
    private By completedPurchace = By.className("complete-header");


    public CheckoutOverviewPage getPriceAndCheck(){

           String totalPrice = readText(totalPriceLabel);
           String tax = readText(taxLabel);
           String subtotal = readText(subtotalLabel);

           String totalPriceSTR = totalPrice.substring(8);
           String subTotalSTR = subtotal.substring(13);
           String taxSTR = tax.substring(6);

           Double subTotalDBL = Double.parseDouble(subTotalSTR);
           Double taxDBL = Double.parseDouble(taxSTR);

           Double expectedTotalPriceDBL = Double.sum(taxDBL, subTotalDBL);
           String expectedTotalPriceSTR = Double.toString(expectedTotalPriceDBL);
           

           if (expectedTotalPriceSTR.equals(totalPriceSTR)) {
            
            System.out.println("Prices match");
            click(finishBTN);
            
           }
           else{
            System.out.println("Prices do not match");
           }           
    
           return this;

    }

    public CheckoutOverviewPage verifyPurchace(String expectedMessage) {

        String actualMessage = readText(completedPurchace);
        if (expectedMessage.equals(actualMessage)){
        System.out.println("Your purchase is successful, congratulations!");
        }
        else{
            System.out.println("Error: Something went wrong");
        }
        return this;
    }

}
