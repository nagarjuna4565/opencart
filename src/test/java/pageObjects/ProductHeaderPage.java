package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductHeaderPage extends BasePage {

	public ProductHeaderPage(WebDriver driver) {
		super(driver);
		
	}
	Actions a = new Actions(driver);
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	WebElement lnkDesktops;
	
	@FindBy(xpath="//a[normalize-space()='PC (0)']")
	WebElement lnkPC;
	
	@FindBy(xpath="//a[normalize-space()='Mac (1)']")
	WebElement lnkMac;
	
	@FindBy(xpath="//a[normalize-space()='Show AllDesktops']")
	WebElement lnkShowAllDesktops;
	
	
	public void moveToDesktops() {
		a.moveToElement(lnkDesktops).perform();
	}
	public void clickShowAllDesktops() {
		lnkShowAllDesktops.click();
	}

}
