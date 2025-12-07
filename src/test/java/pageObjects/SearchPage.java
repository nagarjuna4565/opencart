package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	

	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearchBox;

	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearchicon;
	
	@FindBy(xpath="//div[@class='product-thumb']")
	List<WebElement> listproducts;
	
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//a")
	List<WebElement> listOfProdNames;
	
	//div[@class='caption']//a[contains(text(),'MacBook')]/ancestor::div[@class='product-thumb']//h4/following-sibling::p[1]
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
		WebElement txtNoProductMatchError;
	
	@FindBy(xpath="//i[@class='fa fa-th-list']")
	WebElement btnListView;
	
	@FindBy(xpath="//i[@class='fa fa-th']")
	WebElement btnGridView;
	
	@FindBy(xpath="//input[@id='input-search']")
	WebElement txtProductDescriptionSearch;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement chkbxSearchInProdDescription;
	
	@FindBy(xpath="")
	WebElement drdAllCategories;
	
	@FindBy(xpath="//select[@name='category_id']")
	WebElement chkxSearchInSubCategory;
	
	@FindBy(css="#compare-total")
	WebElement lnkProductCompare;
	
	@FindBy(xpath="//select[@id='input-limit']")
	WebElement drdFilterShow;
	
	@FindBy(xpath="//select[@id='input-sort']")
	WebElement drdFilterSortBy;
	
	@FindBy(xpath="//input[@id='button-search']")
	WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txtElementAddedtoProdComp;
	
	@FindBy(xpath="//a[normalize-space()='product comparison']")
	WebElement lnkProdComparefromSuccessMessage;
	
	@FindBy(xpath="//button[normalize-space()='×']")
	WebElement btnCloseProductCompareSuccess;
	
	
	public void enterProductinSearchbox(String prod) {
		txtSearchBox.sendKeys(prod);
	}
	
	public void clickSearch() {
		btnSearchicon.click();
	}
	
	public List<String> getproductnames() {
		List<String> al = new ArrayList<String>();
		for(WebElement w:listOfProdNames) {
			al.add(w.getText());
		}
		return al;
	}
	
	
	
	public void AddToCart(String Prodname) {
		WebElement addtocart = driver.findElement(By.xpath("//div[@class='caption']//a[normalize-space()='"+Prodname+"']/ancestor::div[@class='product-thumb']//button[1]"));
	    addtocart.click();	
	}
	
	public void AddWishList(String Prodname) {
		WebElement addtowish = driver.findElement(By.xpath("//div[@class='caption']//a[normalize-space()='"+Prodname+"']/ancestor::div[@class='product-thumb']//button[2]"));
		addtowish.click();	
	}
	
//	public void AddToCompare(String Prodname) {
//		WebElement addtocompare = driver.findElement(By.xpath("//a[normalize-space()='"+Prodname+"']/ancestor::div[contains(@class,'product-thumb')]//button[@data-original-title='Compare this Product' or @title='Compare this Product']"));
//		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(addtocompare)).click();	
//	}
	
	public void AddToCompare(String Prodname) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    WebElement addtocompare = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//a[normalize-space()='" + Prodname + 
	        "']/ancestor::div[contains(@class,'product-thumb')]//button[@data-original-title='Compare this Product' or @title='Compare this Product']"))
	    );

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", addtocompare);
	}
	
	public String getProductDescription(String Prodname) {
		WebElement description = driver.findElement(By.xpath("//div[@class='caption']//a[normalize-space()='"+Prodname+"']/ancestor::div[@class='product-thumb']//h4/following-sibling::p[1]"));
		return description.getText();
	}
	
	public String getProductPrice(String prodname) {
		WebElement price = driver.findElement(By.xpath("//div[@class='caption']//a[normalize-space()='"+prodname+"']/ancestor::div[@class='product-thumb']//h4/following-sibling::p[@class='price']"));
		return price.getText().split("Ex")[0].trim();
	}
	public String getProductTaxAmount(String prodname) {
		WebElement tax = driver.findElement(By.xpath("//div[@class='caption']//a[normalize-space()='"+prodname+"']/ancestor::div[@class='product-thumb']//h4/following-sibling::p[@class='price']/span"));
		return tax.getText().split(":")[1].trim();
	}
	
	public boolean ValidateNoProdMessage(String txt) {
		return (txtNoProductMatchError.getText()).equals(txt);
	}
	
	public void selectListView() {
		if(btnListView.isSelected()) {
			return;
		}
		else {
			btnListView.click();
		}
	}
	
	public void selectGridView() {
		if(btnGridView.isSelected()) {
			return;
		}
		else {
			btnGridView.click();
		}
	}
	
	public void selectCategory(String value) {
		Select select = new Select(chkxSearchInSubCategory);
		select.selectByValue(value);
		
	}
	
	public void enterProductDescriptiontext(String txt) {
		txtProductDescriptionSearch.sendKeys(txt);
	}
	
	public void selectSearchInProductDescription() {
		if(chkbxSearchInProdDescription.isSelected()) {
			return;
		}
		else {
		chkbxSearchInProdDescription.click();
		}
	}
	
	public void selectSearchInProductSubCategory() {
		if(chkxSearchInSubCategory.isEnabled()) {
			if(chkxSearchInSubCategory.isSelected()) {
				return;
			}
			else {
				chkxSearchInSubCategory.click();
			}
		}
		else {
			return;
		}
	}
	
	public void clickProductCompare() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.visibilityOf(lnkProductCompare));

	    js.executeScript("arguments[0].click();", lnkProductCompare);
	}
	
	public void selectShowFilter(String txt) {
		Select select = new Select(drdFilterShow);
		select.selectByVisibleText(txt);
	}
	
	public void selectSortByFilter(String txt) {
		Select select = new Select(drdFilterSortBy);
		select.selectByVisibleText(txt);
	}
	
	public void clickSearchByDescription() {
		btnSearch.click();
	}
	
	public boolean validateProductaddedToComparetext(String txt) {
	
		return (txtElementAddedtoProdComp.getText()).contains(txt);
	}
	
	public void clickProdCompareFromSuccessLink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.visibilityOf(lnkProdComparefromSuccessMessage));

	    js.executeScript("arguments[0].click();", lnkProdComparefromSuccessMessage);
	}
	
	public void closeSuccesMessageComp() {
		btnCloseProductCompareSuccess.click();
	}
	

}
