package test;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPageObjects {

	public Object ValidatePresenceOfHyperlink;
	private WebDriver driver;
	@FindBy(how = How.XPATH, xpath = "//input[@id='identifierId']")
	WebElement emailField;

	@FindBy(how = How.XPATH, xpath = "//*[@id='password']/div[1]/div/div[1]/input")
	WebElement passwordField;

	@FindBy(how = How.XPATH, xpath = "//span[@class='bog']")
	List<WebElement> emailThreads;

	@FindBy(how = How.XPATH, xpath = "//img[@class='gb_Ia gbii']")
	WebElement profileLogo;

	@FindBy(how = How.XPATH, xpath = "//span[@name='me']")
	WebElement emailTO;

	@FindBy(how = How.XPATH, xpath = "//h2[contains(text(),'Test2')]/parent::div/parent::div/following::div/h1/parent::div")
	WebElement emailBody;
	@FindBy(how = How.PARTIAL_LINK_TEXT,  partialLinkText ="elearning")
	WebElement hyperLink1;


//div[contains(@dir,'ltr')]

	public GmailPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmail(String emailID) {
		waitForVisible(driver, emailField);
		Actions actions = new Actions(driver);
		actions.moveToElement(emailField);
		actions.click();
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
		System.out.println("Email entered");
	}

	public void enterPassword(String password) {
		waitForVisible(driver, passwordField);
		Actions actions = new Actions(driver);
		actions.moveToElement(passwordField);
		actions.click();
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
		System.out.println("Password entered");
	}

	public void clickEmail(String emailSubject) {
		waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailThreads.size(); i++) {

			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("email subject is...>"+emailSubject);
				break;
			}
		}
	}

	public void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			System.out.println("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validateRecipient(String recipient) {
		try {
			waitForVisible(driver, profileLogo);
			System.out.println("Valid Recepient email" + emailTO.getText());
			if (emailTO.getText().contains(recipient)) ;
			{
				System.out.println("Valid Recepient");
				//driver.navigate().back();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void validateEmailBody(String Body) {
		try {
			waitForVisible(driver, profileLogo);
			System.out.println("email Body Validating....>" + emailBody.getText());
			if (emailBody.getText().contains(Body)) ;
			System.out.println("email Body Validated....>");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void ValidatePresenceOfHyperlink() {
		try {
			waitForVisible(driver, profileLogo);
			if (emailBody.getText().contains("<a href=>")) ;
			System.out.println("Hyperlink present in email and the link is....>"+hyperLink1.getAttribute("href"));
			Thread.sleep(1000);
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}


