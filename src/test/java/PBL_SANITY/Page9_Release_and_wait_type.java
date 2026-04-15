package PBL_SANITY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class Page9_Release_and_wait_type extends PblSanityBase
{

	
	@Test(invocationCount=1)
	public  void wait_types() throws InterruptedException
	{

		loginToPbl();
        openDefaultProject();		
        openProjectPage("Process/WaitTypes");
		
        pauseSeconds(5);
		
		
		jsClick(By.xpath("//button[text()='Populate Pending']"));
		pauseSeconds(20);
		
		
         //click on the all the activity links
		
		List<WebElement> all_activity=driver.findElements(By.xpath("//h6//a"));
		
		
		for(int s=1;s<=all_activity.size(); s++)
		{
			
		WebElement click_activity=	driver.findElement(By.xpath("((//h6//a)["+s+"])"));
		JavascriptExecutor activity_click = (JavascriptExecutor)driver;
		activity_click.executeScript("arguments[0].click();", click_activity);
			
			
		}
		
		
		List<WebElement> list_activities = driver.findElements(By.xpath("//div[@id='WTActs']/descendant::input[@type='text']"));
		Actions action = new Actions(driver);

		for (WebElement element : list_activities) {

		    try {

		        // Check if the element is displayed & enabled
		        if (element.isDisplayed() && element.isEnabled()) {

		            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		            wait1.until(ExpectedConditions.elementToBeClickable(element));

		            // Click the element
		            action.moveToElement(element).click().perform();

		            // Clear old value
		            element.sendKeys(Keys.CONTROL, "a");
		            element.sendKeys(Keys.BACK_SPACE);

		            // Enter new value
		            pauseSeconds(2);
		            element.sendKeys("00.05:00:02");

		            // Press ENTER
		            action.sendKeys(Keys.ENTER).perform();
		        }
		        else {
		            System.out.println("Element is NOT visible or NOT enabled, skipping...");
		        }

		    } catch (Exception e) {
		        System.out.println("Skipping one element due to error: " + e.getMessage());
		    }
		}
		
		Thread.sleep(3000);


		//click on release and wait types
		
		jsClick(By.xpath("//a[@id='review-tab']"));
		pauseSeconds(5);
		
		
		//click on dead lines
		
		
		jsClick(By.xpath("//a[@class='btn btn-warning text-black']"));
		pauseSeconds(5);
		System.out.println(driver.getTitle());
		
		
		//click on expand process map

		jsClick(By.xpath("//a[@title='Full screen']"));
		pauseSeconds(5);
		

		//click on process map to same position

		jsClick(By.xpath("//a[@title='Exit full screen']"));
		pauseSeconds(5);

	}

	
	
}
