package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register_btn;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement btnlogin;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement btnlogout;
	
	@FindBy(xpath="//a[@id='wishlist-total']//i[@class='fa fa-heart']")
	WebElement btnWishList;
	
	
	public void clickMyaccount() {
		MyAccount.click();
		 try { Thread.sleep(500); } catch (Exception e) {}
	}
	
	public void Registration() {
		Register_btn.click();
	}
	
	public void Login() {
		btnlogin.click();
	}
	
	public void Logoutfromheader() {
		btnlogout.click();
	}
	
	//Featured Products
	
	public void clickProductCompare(String prod) {
		driver.findElement(By.xpath("//div[@class='row']//a[normalize-space()='"+prod+"']/ancestor::div[@class='product-thumb transition']//button[3]")).click();
	}
	public void addToCart(String prod) {
		driver.findElement(By.xpath("//div[@class='row']//a[normalize-space()='"+prod+"']/ancestor::div[@class='product-thumb transition']//button[1]")).click();
	}
	
	//ClickWishList
	
	public void clickWishList() {
		btnWishList.click();
	}


}
