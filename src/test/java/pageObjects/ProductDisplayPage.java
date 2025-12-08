package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage{

	public ProductDisplayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//PRODUCT NAME
	@FindBy(xpath="//div[@id='product-product']//h1")
	WebElement txtProductName;
	
	//ADD TO CART
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddtoCart;
	
	//QUANTITY
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement txtQuantity;
	
	public boolean validateProductName(String prod) {
		String prodname = txtProductName.getText();
		return prodname.equals(prod) ;
	}
	
	public void setQuantity(String quantity) {
		txtQuantity.clear();
		txtQuantity.sendKeys(quantity);
	}
	
	public void addToCart() {
		btnAddtoCart.click();
	}

}
