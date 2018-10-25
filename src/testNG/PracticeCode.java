package testNG;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class PracticeCode {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajinkya.bhobad\\Desktop\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	driver.get("http://toolsqa.com/automation-practice-form/");
    	/*WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"continents\"]"));
    	Select select = new Select(dropDown);
    	List<WebElement> dropDownOptions = select.getOptions();
    	for(WebElement allOptions:dropDownOptions)
    	{
    		System.out.println(allOptions.getText());
    	}
    	
    	select.selectByVisibleText("Africa");
    	
    	List<WebElement> getAllOptions = select.getAllSelectedOptions();
    	for (WebElement getAllOption : getAllOptions) {
    		System.out.println(getAllOption.getText());
    		}*/
    	
    	WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[29]"));
    	Select select = new Select(dropDown);
    	List<WebElement> dropDownOptions = select.getOptions();
    	for(WebElement allOptions:dropDownOptions)
    	{
    		System.out.println(allOptions.getText());
    	}
    	
    	 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
    			    .withTimeout(30, TimeUnit.SECONDS)
    			    .pollingEvery(1, TimeUnit.SECONDS)
    			    .ignoring(NoSuchElementException.class);

     WebElement content = fluentWait.until(new Function<WebDriver, WebElement>() 
     {
    			   public WebElement apply(WebDriver driver) {
    			    return driver.findElement(By.xpath("//h4[text()='Hello World!']"));
    			   }
    			  });

    			  System.out.println(content.getText());
    			 }
    	
	}

