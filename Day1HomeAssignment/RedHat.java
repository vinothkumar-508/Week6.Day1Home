package Week6.Day1HomeAssignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RedHat {
	private RemoteWebDriver driver;
	@AfterMethod
	public void postCondition() {
			driver.quit();	
	}
	
	@Test(dataProvider = "fetchData")
	public void runRedHat(String uName, String pWord, String conpWord, String fName, String lName, String Email, String PNo, String JTitle, String Add, String PCode, String City) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://sso.redhat.com/");
		driver.findElement(By.xpath("//button[@id='rh-registration-link']")).click();
		WebElement form = driver.findElement(By.id("registration-form"));
		Assert.assertTrue(form.isDisplayed(), "Registration form is displayed.");
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.id("confirmPassword")).sendKeys(conpWord);
		driver.findElement(By.id("firstName")).sendKeys(fName);
		driver.findElement(By.id("lastName")).sendKeys(lName);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("user.attributes.phoneNumber")).sendKeys(PNo);
		driver.findElement(By.id("user.attributes.jobTitle")).sendKeys(JTitle);
		driver.findElement(By.xpath("//input[@id='personal']")).click();
		driver.findElement(By.xpath("//select[@id='user.attributes.country']")).click();
		driver.findElement(By.xpath("//option[text()='India']")).click();
		driver.findElement(By.id("user.attributes.addressLine1")).sendKeys(Add);
		driver.findElement(By.id("user.attributes.addressPostalCode")).sendKeys(PCode);
		driver.findElement(By.id("user.attributes.addressCityText")).sendKeys(City);
		driver.findElement(By.id("user.attributes.addressState")).click();
		driver.findElement(By.xpath("(//option[@value='TN'])[2]")).click();
	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException{
		return IntegrationWithTC2.excelData();
		
	}
}
