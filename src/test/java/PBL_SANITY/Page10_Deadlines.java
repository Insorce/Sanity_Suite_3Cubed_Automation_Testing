package PBL_SANITY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Page10_Deadlines extends PblSanityBase
{


	@Test(invocationCount=1)
	public void deadlines_9() throws InterruptedException
	{

		 loginToPbl();
	        openDefaultProject();
	        openProjectPage("Process/DeadLines");

		
		
	      //click on expand process map

			jsClick(By.xpath("//a[@title='Full screen']"));
			pauseSeconds(5);
			

			//click on process map to same position

			jsClick(By.xpath("//a[@title='Exit full screen']"));
			pauseSeconds(5);
			
			jsClick(By.xpath("//button[text()='Populate Pending']"));
			pauseSeconds(20);
		//select no deadline from dropdowns
			List<WebElement> dropdowns = driver.findElements(
				    By.xpath("//div[@id='DLActss']//div[@class='col-sm-4 px-0']/select")
				);

				int size = dropdowns.size();

				for (int i = 0; i < size; i++) {

				    // 🔁 Re-locate elements every time (IMPORTANT)
				    List<WebElement> updatedDropdowns = driver.findElements(
				        By.xpath("//div[@id='DLActss']//div[@class='col-sm-4 px-0']/select")
				    );

				    WebElement dropdown = updatedDropdowns.get(i);

				    try {
				        ((JavascriptExecutor) driver)
				            .executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

				        new WebDriverWait(driver, Duration.ofSeconds(10))
				            .until(ExpectedConditions.elementToBeClickable(dropdown));

				        new Select(dropdown).selectByVisibleText("No Deadline");

				        // ⏳ wait for Knockout update
				        Thread.sleep(500);

				    } catch (StaleElementReferenceException e) {
				        i--; // retry same index
				    }
				}
		Thread.sleep(3000);
			
			
		//pauseSeconds(5);
		//jsClick(By.xpath("//button[text()='Populate Pending']"));
		//pauseSeconds(15);

		//click on review
		pauseSeconds(5);
		jsClick(By.id("obs-tab"));
		pauseSeconds(5);
		
		//click on input/edit 

		WebElement input_edit=driver.findElement(By.xpath("//a[@id='edit-tab']"));
		Actions act= new Actions(driver);
		act.doubleClick(input_edit).perform();

		
		//click on close
		pauseSeconds(5);
		jsClick(By.xpath("(//button[@class='btn btn-secondary'])[1]"));
		pauseSeconds(5);
		
		//click on container
		pauseSeconds(5);
		jsClick(By.id("loadDialogue"));
		pauseSeconds(5);
		

		// These deadlines may increase no of FTE in teams
		pauseSeconds(5);
		jsClick(By.xpath("//button[text()='These deadlines may increase no of FTE in teams']"));
		pauseSeconds(5);
		
		

		// Verify the review toggle is selected or not in not make its selected 
		Thread.sleep(5000);
		List<WebElement> toggle_switch =	driver.findElements(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));
		int size1=toggle_switch.size();
		System.out.println("lineNo-257 toggle switch count is = "+size1);
		for(int i=0;i<size1;i++) {
			System.out.println(toggle_switch.get(i).isSelected());
			if(toggle_switch.get(i).isSelected()) {
			   System.out.println("LineNo-276 Toggle is Alredy selected");
			//toggle_switch.get(i).click();
			}else {
				JavascriptExecutor toggle = (JavascriptExecutor)driver;
				toggle.executeScript("arguments[0].click()", toggle_switch.get(i));
				System.out.println("LineNo-281 Toggle is selected now this script");
			}
		}


		//click on opeartion sites
		pauseSeconds(5);
		jsClick(By.xpath("//a[@class='btn btn-warning text-black']"));
		pauseSeconds(5);
		
        // FTE Validations 
		
		// Validate the EFFORT Widget 
		Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='104']"))).perform();
        Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='205']"));
        action.contextClick(driver.findElement(By.xpath("//a[@id='104']"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
        Thread.sleep(3000);
		
		// Validate the Peak&Utilization  
        
        action.moveToElement(driver.findElement(By.xpath("//a[@id='105']"))).perform();
        Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='205']"));
        action.contextClick(driver.findElement(By.xpath("//a[@id='105']"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
        Thread.sleep(3000);
		
        // Validate the Rework & Rejections 
        
        action.moveToElement(driver.findElement(By.xpath("//a[@id='109']"))).perform();
        Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='205']"));
        action.contextClick(driver.findElement(By.xpath("//a[@id='109']"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
        Thread.sleep(3000);
		
        
        // Validate the Critical Path 
        
        action.moveToElement(driver.findElement(By.xpath("//a[@id='203']"))).perform();
        Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='205']"));
        action.contextClick(driver.findElement(By.xpath("//a[@id='203']"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
        Thread.sleep(3000);
		
        // Validate the Peak&Utilization  
        
        action.moveToElement(driver.findElement(By.xpath("//a[@id='204']"))).perform();
        Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='205']"));
        action.contextClick(driver.findElement(By.xpath("//a[@id='204']"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
        Thread.sleep(7000);
		System.out.println("Validations completed ");
     System.out.println(driver.getTitle());
        

	}


}
