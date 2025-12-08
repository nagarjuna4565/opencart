package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

	public WishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//ADD TO CART
	
	public void clickAddToCart(String prod) {
		driver.findElement(By.xpath("//div[@class='table-responsive']//td[normalize-space()='"+prod+"']/following-sibling::td/button")).click();
	}
	
	//Removefrom wishlist
	
	public void clickRemovefromWishList(String prod) {
		driver.findElement(By.xpath("//div[@class='table-responsive']//td[normalize-space()='"+prod+"']/following-sibling::td/a")).click();
	}
	
	

}
