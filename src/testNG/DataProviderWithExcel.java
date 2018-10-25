package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {
	
	public WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajinkya.bhobad\\Desktop\\jars\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	  driver.get("https://google.com");
	}
	
	@DataProvider(name="DataProviderName")
	public static Object[][] dataProviderImplementation()
	{
		return new Object[][] {
			{"First","Second"},
			{"third","fourth"}
		};
	}
	
	@Test(dataProvider="DataProviderName")
	public void test(String Name1,String Name2) throws InterruptedException
	{
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Name1);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Name2);
	System.out.println("Execution");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
