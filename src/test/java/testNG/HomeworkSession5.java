package testNG;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkSession5 {

//	Scenario: Add new account on Techfios Site 
//	​
//	Beginner:
//	1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
//	2. Enter username: techfiosdemo@gmail.com
//	3. Enter password: abc123
//	4. Click login button
//	5. Click on Bank & Cash
//	6. Click on New Account
//	7. Fill in the Add New Account Form (Randomize Account Title and Balance)
//	8. Click submit,
//
//	​Intermediate:
//	9. Validate the presence of "Account Created Successfully" message
//
//	Advance: 
//	10. Scroll Down,
//	11. Validate new account showed up in the bottom of the table
//	12. ​Delete that account
//	13. Validate account deleted from the bottom of the table
//	

	public class TestNgLogin extends BasePage {
		WebDriver driver;

		@BeforeMethod
		public void startBrowser() {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://techfios.com/billing/?ng=login/");

		}

		@Test(priority = 1)
		public void validUsersShouldBeAbleToLogIN() throws InterruptedException {
			driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			driver.findElement(By.id("password")).sendKeys("abc123");
			driver.findElement(By.name("login")).click();
			By DASHBOARD_PAGE = By.xpath("//h2[contains(text(),'Dashboard')]");
			waitForElement(driver, 20, DASHBOARD_PAGE);
			// 5
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a//span[contains(text(), 'Bank & Cash')]")).click();
			// 6
			driver.findElement(By.xpath("//a[contains(text(), 'New Account')]")).click();
			// 7
			Thread.sleep(3000);
			By ACCOUNT_TITLE_FIELD_LOCATOR = By.id("account");
			By DESCRIPTION_INPUT_FIELD_LOCATOR = By.id("description");
			By INITIAL_BALANCE_INPUT_FIELD_LOCATOR = By.id("balance");
			By ACCOUNT_NUMBER_INPUT_FIELD_LOCATOR = By.id("account_number");
			By CONTACT_PERSON_INPUT_FIELD_LOCATOR = By.id("contact_person");
			By CONTACT_PHONE_INPUT_FIELD_LOCATOR = By.id("contact_phone");
			By INTERNET_BANKING_URL_FIELD_LOCATOR = By.id("ib_url");
			By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@class = 'btn btn-primary' ]");
			// By ACCOUNT_SUCCESSFULLY_LOCATOR = By.xpath("//div[@class='alert alert-success
			// fade in']");
			// waitForElement(driver, 30 , ACCOUNT_SUCCESSFULLY_LOCATOR);

			Random rnd = new Random();
			rnd.nextInt(999);
			String accountTitle = "Neet" + rnd.nextInt(999);
			String accoountNumber = "896734" + rnd.nextInt(999);
			String contactphone = "123456789" + rnd.nextInt(999);
			String internetbankingurl = "987654" + rnd.nextInt(999);

			// Filling the Form
			driver.findElement(ACCOUNT_TITLE_FIELD_LOCATOR).sendKeys("Neet" + rnd.nextInt(999));
			driver.findElement(DESCRIPTION_INPUT_FIELD_LOCATOR).sendKeys("Game Money");
			driver.findElement(INITIAL_BALANCE_INPUT_FIELD_LOCATOR).sendKeys("99,000");
			driver.findElement(ACCOUNT_NUMBER_INPUT_FIELD_LOCATOR).sendKeys("896734" + rnd.nextInt(999));
			driver.findElement(CONTACT_PERSON_INPUT_FIELD_LOCATOR).sendKeys("Neetu Singh");
			driver.findElement(CONTACT_PHONE_INPUT_FIELD_LOCATOR).sendKeys("123456789" + rnd.nextInt(999));
			driver.findElement(INTERNET_BANKING_URL_FIELD_LOCATOR).sendKeys("987654" + rnd.nextInt(999));
			driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
		}

		
		

	}
}
