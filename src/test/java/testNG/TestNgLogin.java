package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgLogin extends BasePage {
	WebDriver driver;

	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=login/");

	}

	@Test(priority = 2)
	public void validUsersShouldBeAbleToLogIN() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		By DASHBOARD_PAGE = By.xpath("//h2[contains(text(),'Dashboard')]");
		waitForElement(driver, 20, DASHBOARD_PAGE);

	}

	@Test(priority = 1)
	public void invalidUsersShouldNotBeAbleToLogIN() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc");
		driver.findElement(By.name("login")).click();

	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

}
