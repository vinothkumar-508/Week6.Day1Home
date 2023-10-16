package Week6.Day1HomeAssignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class W3School {
	private RemoteWebDriver driver;
	@AfterMethod
	public void postCondition() {
		if (driver != null) {
			driver.quit();	
		}
	}
	
	@Test(dataProvider = "fetchData")
	public void runW3School(String FName, String Email, String Adr, String City, String State, String ZipCode, String CVV, String Creditcardnumber, String ExpMonth, String ExpYear, String NameonCard) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_checkout_form");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.id("fname")).sendKeys(FName);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("adr")).sendKeys(Adr);
		driver.findElement(By.id("city")).sendKeys(City);
		driver.findElement(By.id("state")).sendKeys(State);
		driver.findElement(By.id("zip")).sendKeys(ZipCode);
		driver.findElement(By.id("cvv")).sendKeys(CVV);
		driver.findElement(By.id("ccnum")).sendKeys(Creditcardnumber);
		driver.findElement(By.id("expmonth")).sendKeys(ExpMonth);
		driver.findElement(By.id("expyear")).sendKeys(ExpYear);
		driver.findElement(By.id("cname")).sendKeys(NameonCard);

	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException{
		return IntegrationWithTC3.excelData();
	}

}
