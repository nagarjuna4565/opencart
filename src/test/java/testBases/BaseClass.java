package testBases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"master","regression","smoke","sanity"})
	@Parameters({"os","browser"})
	public void setup(String os,String browser) throws IOException {
		
		FileReader f = new FileReader("./src//test/resources/config.properties");
		p = new Properties();
		p.load(f);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver();break;
		default : System.out.println("Invalid browser"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"master","regression","smoke","sanity"})
	public void teardown() {
		driver.quit();
		
		
	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(6);
		}
	
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String randomAlphaNumeric() {
		return RandomStringUtils.randomAlphanumeric(5)+"@"+RandomStringUtils.randomNumeric(5);
	}
	
	 public String captureScreen(String testName) throws IOException {
	        // Create timestamp
	        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

	        // Create screenshot file name
	        String screenshotName = testName + "_" + timestamp + ".png";

	        // Folder to store screenshots
	        String folderPath = System.getProperty("user.dir") + "/screenshots/";
	        File folder = new File(folderPath);
	        if (!folder.exists()) {
	            folder.mkdir();
	        }

	        // Take screenshot using WebDriver
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);

	        // Final destination of screenshot
	        String destination = folderPath + screenshotName;
	        File finalDestination = new File(destination);

	        // Copy screenshot to final destination
	        FileUtils.copyFile(source, finalDestination);

	        return destination;
	        
	        //String to int
	        
	        
	 }
	 
	
		 public int convertStringToInt(String s) {
			    if (s == null || s.isEmpty()) {
			        throw new IllegalArgumentException("Price string is null or empty");
			    }

			    // Remove $ sign, commas, and spaces
			    s = s.replace("$", "").replace(",", "").trim();

			    // Remove decimal part if present
			    s = s.split("\\.")[0];

			    // Convert to int
			    return Integer.parseInt(s);
			}
     

}
