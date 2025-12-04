package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMyAccountheading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']")
	WebElement lnknewsletter;
	
	public boolean myaccountText() {
		
		try {
			return txtMyAccountheading.isDisplayed();	
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	public void susunsusnewsletter() {
		lnknewsletter.click();
	}
	
	
	

}
