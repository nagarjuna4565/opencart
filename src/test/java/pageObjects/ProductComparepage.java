package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparepage extends BasePage {

	public ProductComparepage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="div[id='content'] h1")
	WebElement txtProductComparisonheader;
	
	@FindBy(xpath="//table[@class='table table-bordered']//td[normalize-space()='Product']/following-sibling::td")
	List<WebElement> txtProducts;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txtCompProdAddedToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txtComparisonProdRemoved;
	
	public boolean validateProductComparisonheader(String txt) {
		return (txtProductComparisonheader.getText()).equals(txt);
	}
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txtProdRemovedText;
	
	public List<String> getProductsList() {
		List<String> al = new ArrayList<String>();
		for(WebElement p:txtProducts) {
			al.add(p.getText());
		}
		return al;
		
	}
	
	public void removeRemoveProductFromComp(String prod) {
		
		driver.findElement(By.xpath(
			    "(//td//a[normalize-space()='Remove'])[count(//table[@class='table table-bordered']//td[a[normalize-space()='"+prod+"']]/preceding-sibling::td)]"
			)).click();}

	public boolean validateCompProdRemoved(String txt) {
		return (txtProdRemovedText.getText()).contains(txt);
	}
	
	//GET PRICE
	public String getProductPrice(String Prod) {
	    String xpath = "(//td[normalize-space()='Price']/following-sibling::td)[count(//table[@class='table table-bordered']//td[a[normalize-space()='" + Prod + "']]/preceding-sibling::td)]";

	    String s = driver.findElement(By.xpath(xpath)).getText();
	    
	    return s;
	}
	
	//ADDTOCART
	public void addProducttoCartFromComp(String prod) {
		driver.findElement(By.xpath(
			    "(//td//input[@value='Add to Cart'])[count(//table[@class='table table-bordered']//td[a[normalize-space()='"+prod+"']]/preceding-sibling::td)]"
			)).click();

	
	}
	
	//ADDTOCARTSUCCESSTEXT
	
	public boolean validateAddToCartSuccess(String txt) {
		String s=txtCompProdAddedToCart.getText();
		return s.equals(txt);
	}
	
	
	

}
