package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsLetterSubscriptionaPage extends BasePage {

	public NewsLetterSubscriptionaPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@value='1']")
	WebElement btnSubYes;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement btnSubNo;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	
	public boolean IsSubYesSelected() {
		return btnSubYes.isSelected();
	}
	
	public boolean IsSubNoSelected() {
		return btnSubNo.isSelected();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	
	
	
}
