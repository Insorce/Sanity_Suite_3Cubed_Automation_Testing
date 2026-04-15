package PBL_SANITY;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;



public class Page16_Controls extends PblSanityBase
{

	
	

	@Test(invocationCount=1)
	public void business_rules() throws InterruptedException
	{

		 loginToPbl();
	        openDefaultProject();
	        openProjectPage("Risk/ControlIdentification");
	        pauseSeconds(5);
	     
	    // click on the Legend 
	    	jsClick(By.xpath("//button[text()='Legend']"));
	    	pauseSeconds(3);
	    // click to close the legend 
	    	jsClick(By.xpath("//div[@id='LegendSidenav']/a"));
	    	pauseSeconds(5);
	    	
	    	// click on Add control button
	    	jsClick(By.xpath("//button[@id='PopNewObjective']"));
	    	pauseSeconds(5);
	    	
	    	//Enter the object name
	    	driver.findElement(By.xpath("//input[@list='dlSuggestedObjectiveNames']")).sendKeys("test1");
	    	pauseSeconds(2);
	    	// select the object 
	    	jsClick(By.xpath("//div[@id='Objective0']/div/div/div[1]/div[3]/div/div/input"));
	    	pauseSeconds(2);
	    	// Select the another object 
	    	jsClick(By.xpath("//div[@id='Objective0']/div/div/div[2]/div[3]/div/div[1]/input"));
	    	pauseSeconds(3);
	    	
	    	// Click on add control object button 
	    	Actions ac=new Actions(driver);
	    	ac.moveToElement(driver.findElement(By.xpath("(//div[@class='modal-content'])[2]/div[3]/button[1]"))).click().perform();
	    	
	    	pauseSeconds(3);
	    	// select the popup OK 
	    	
	    	
	    	try {
	    	//jsClick(By.xpath("//section[@id='alertify']/div/article/nav/button"));
	    	
	    	jsClick(By.xpath("//section[@id='alertify']//nav/button"));
	    	pauseSeconds(2);
	    	// select the object 
	    	jsClick(By.xpath("//div[@id='Objective0']/div/div/div[1]/div[3]/div/div/input"));
	    	pauseSeconds(2);
	    	
	    	ac.moveToElement(driver.findElement(By.xpath("(//div[@class='modal-content'])[2]/div[3]/button[1]"))).click().perform();

	    	
	    	
	    	}catch(Exception e) {
	    		System.out.println("No popup found");
	    	}
	    	
	    	// close the popup 
	    	pauseSeconds(2);
	    	jsClick(By.xpath("(//div[@id='objectiveCtrlModel']//button[1])[1]"));
	    	pauseSeconds(2);
	    	
	    	// click on the control name to navigate the control details page
	    	jsClick(By.xpath("//button[text()='test1']"));
	    	pauseSeconds(3);
	    	
	    	// cklick on the add risk activity button
	    	jsClick(By.xpath("//button[@title='Add/Remove Risk Activities']/i"));
	    	pauseSeconds(3);
	    	
	    	
	    	pauseSeconds(2);
	    	try {
		    	jsClick(By.xpath("//section[@id='alertify']/div/article/nav/button[2]"));
		    	pauseSeconds(3);
		    	}catch(Exception e) {
		    		System.out.println("No popup found");
		    	}
	    	// click on the proceesd button in the risk activity popup
	    	jsClick(By.xpath("//div[@id='objActivityModal']/div/div/div[3]/button[2]"));
	    	pauseSeconds(2);
	    	try {
		    	jsClick(By.xpath("//section[@id='alertify']/div/article/nav/button"));
		    	pauseSeconds(3);
		    	}catch(Exception e) {
		    		System.out.println("No popup found");
		    	}
	    	// click cancel button
	    	
	    	jsClick(By.xpath("//div[@id='objActivityModal']/div/div/div[3]/button[1]"));
	    	pauseSeconds(2);
	    	// expand the control details page
	    	jsClick(By.xpath("//button[text()='test1']"));
	    	pauseSeconds(2);
	    	
	    	// delete the control
	    	jsClick(By.xpath("//button[text()='test1']//parent::h5//following-sibling::div//child::button[2]"));
	    	pauseSeconds(2);
	    	// ok th epopup 
	    	jsClick(By.xpath("//section[@id='alertify']/div/article/nav/button[2]"));
	    	pauseSeconds(3);
	    	
	    	// refresh the page
	    	driver.navigate().refresh();
	    	pauseSeconds(5);
	    	jsClick(By.xpath("//a[@id='review-tab']"));
	    	pauseSeconds(3);
	    	// click on control validations 
	    	jsClick(By.xpath("//a[@href='/Validation/Controls']"));
	    	pauseSeconds(5);
	    	// control validations in Tree 
	    	
	    	
	    	// Lever-1 Automation in cost 
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='108']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	// Lever-2 Compatency in cost 
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='106']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	// Lever-3 Control effort in cost 
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='110']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	// Lever-4 NVA in cost 
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='111']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	
	    	// Lever-5 Component cost in cost 
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='107']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	
	    	// Lever-6 Adequacy in Control
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='302']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	// Lever-7 Effectiveness in Control
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='303']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	
	    	// Lever-8 control effort in Control
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='304']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	
	    	// Lever-9 control Rework in Control
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='305']"))).contextClick().perform();
	    	ac.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
	    	pauseSeconds(3);
	    	
	    	// clicko on the decision tree
	    	jsClick(By.xpath("(//a[@href='/Projects/DecisionTree'])[2]"));
	    	pauseSeconds(3);
	    	
	    	//click on the modelinsght link in the decision tree page
	    	jsClick(By.xpath("//a[@href='/Validation/Controls?screen=modalval']"));
	    	pauseSeconds(4);
	    	// click on diagnose button in the model insight page
	    	jsClick(By.xpath("//a[text()='Diagnostic Summary']"));
	    	pauseSeconds(3);
	    	
	    	//click on reload button 
			
			Wait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(600))     // Total wait time
	                .pollingEvery(Duration.ofSeconds(30))     // Interval
	                .ignoring(ElementNotInteractableException.class);

	        WebElement Reload = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='dvButtonSec']/div/a[1]")));
	        		//until(driver1 -> 
	               // driver1.findElement(By.xpath("//button[text()='Next']")));
	        
	        Reload.click();
	        pauseSeconds(200);
	       /* // print option 
	        
	        Wait<WebDriver> wait2 = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(600))     // Total wait time
	                .pollingEvery(Duration.ofSeconds(30))     // Interval
	                .ignoring(ElementNotInteractableException.class);

	        WebElement print = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='dvButtonSec']/div/a[2]")));
	        		//until(driver1 -> 
	               // driver1.findElement(By.xpath("//button[text()='Next']")));
	        
	        print.click();
	        pauseSeconds(3);
	        
	        driver.navigate().back();
	        pauseSeconds(3);
	        
	        
	        // click on the feed back button 
	        
	        Wait<WebDriver> wait1 = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(300))     // Total wait time
	                .pollingEvery(Duration.ofSeconds(30))     // Interval
	                .ignoring(ElementNotInteractableException.class);

	        WebElement Feedback = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='dvButtonSec']/div/a[1]")));
	        		//until(driver1 -> 
	               // driver1.findElement(By.xpath("//button[text()='Next']")));
	        
	        Feedback.click();
	        
	        */
	        
			
	    	
	    	
	    			
	}

	
}
