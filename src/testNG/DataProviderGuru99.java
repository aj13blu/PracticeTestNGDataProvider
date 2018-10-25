package testNG;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderGuru99 
{
	public static WebDriver driver;
	@BeforeTest
	public void setup()
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajinkya.bhobad\\Desktop\\jars\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	  driver.get("https://google.com");	
	}
	
	@Test(dataProvider="Authentication",dataProviderClass=DataProviders.class,groups="A")
	public void TestMethodA(String author,String searchKey) throws InterruptedException
	{
		 WebElement searchText = driver.findElement(By.name("q"));
		 searchText.sendKeys(searchKey);
	     System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	     Thread.sleep(3000);
	     String testValue = searchText.getAttribute("value");
	     System.out.println(testValue +"::::"+searchKey);
	     searchText.clear();
	     Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	}
	
	@Test(dataProvider="Authentication",groups="B")
	public void TestMethodB(String author,String searchKey) throws InterruptedException
	{
		 WebElement searchText = driver.findElement(By.name("q"));
		 searchText.sendKeys(searchKey);
	     System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	     Thread.sleep(3000);
	     String testValue = searchText.getAttribute("value");
	     System.out.println(testValue +"::::"+searchKey);
	     searchText.clear();
	     Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	}
	
	@DataProvider(name="dataProvider")
	public static Object[][] getdromdataprovider(Method A)      // Parameter method example
	{
		if(A.getName().equalsIgnoreCase("TestMethodA"))
		{
		return new Object[][]
				{
					{ "Guru99", "India" },
					{ "Krishna", "UK" },
					{ "Bhupesh", "USA" }
				};
		}	
		else {
			return new Object[][] {
                { "Canada" },
                { "Russia" },
                { "Japan" }
            };}    
		}
	
	@DataProvider(name="dataProvider")
	public static Object[][] getdromdataprovider(ITestContext C)   // Parameter ITestContext example
	{
		Object[][] groupArray=null;
		for(String group:C.getIncludedGroups())
		{
			if(group.equalsIgnoreCase("A"))
			{
				groupArray = new Object[][]
				{
					{ "Guru99", "India" },
					{ "Krishna", "UK" },
					{ "Bhupesh", "USA" }
				};
				break;
		}	
		else if(group.equalsIgnoreCase("B")) {
				groupArray = new Object[][] {
                { "Canada" },
                { "Russia" },
                { "Japan" }
            };
          	}
			break;
		}
		return groupArray;
	}
		
	@AfterTest
	public void method2()
	{
		driver.quit();
	}
}
