package test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EmailClickDemo {

	@Test
	public void clickEmail() {

		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath + "\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.google.com");
		GmailPageObjects gp=PageFactory.initElements(driver, GmailPageObjects.class);
		gp.enterEmail("testproj042@gmail.com");
		gp.enterPassword("Assessment");
		gp.clickEmail("Test2-");
        gp.validateRecipient("testproj042@gmail.com");
        gp.validateEmailBody("Imagine how it would be to learn something and ski");
    	gp.ValidatePresenceOfHyperlink();
		
	}

	

	
}
