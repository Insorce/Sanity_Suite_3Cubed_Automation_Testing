package PBL_SANITY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Page12_business_rules extends PblSanityBase
{

	
	

	@Test(invocationCount=1)
	public void business_rules() throws InterruptedException
	{

		 loginToPbl();
	        openDefaultProject();
	        openProjectPage("Process/BusinessRules");
	        pauseSeconds(5);
	      //click on populate pending
	    	
	    	jsClick(By.xpath("//button[text()='Populate Pending']"));
	    	pauseSeconds(5);
	    	// click on the expand button 
	    	jsClick(By.xpath("(//ul[@id='activityTree']/li/i)[1]"));
	    	pauseSeconds(5);
	    	// click on the collapse button
	    	jsClick(By.xpath("(//ul[@id='activityTree']/li/i)[1]"));
	    	pauseSeconds(5);
	    	// click on the expand button 
	    		jsClick(By.xpath("(//ul[@id='activityTree']/li/i)[1]"));
	    		pauseSeconds(5);
	    	
	    		 List<WebElement> list=driver.findElements(By.xpath("(//ul[@id='activityTree']/li)[1]/ul[1]//select"));
	    			int sz=list.size();
	    			for(int i=0; i<sz;i++) {
	    				list.get(i);
	    				Select sc= new Select(driver.findElement(By.xpath("(//select[@class='form-select'])[1]")));
	    			     sc.selectByVisibleText("Human Judgement");
	    				Thread.sleep(3000);
	    			}	
	    		// click on propagate button
	    			
	    			jsClick(By.xpath("(//div[@class='col-sm-1']/div/a[1]/i)[1]"));
		    		pauseSeconds(5);
		    		// click on Delete  button
	    			
	    			jsClick(By.xpath("(//div[@class='col-sm-1']/div/a[2]/i)[1]"));
		    		pauseSeconds(5);
		    		// select the check box of activity 
		    		jsClick(By.xpath("(//ul[@id='activityTree']/li/input)[1]"));
		    		pauseSeconds(5);
		    		// click on Add button 
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[1]"));
		    		pauseSeconds(5);
		    		// Select the business rule
		    		jsClick(By.xpath("(//div[@id='dvBRPanelBRList']//input)[1]"));
		    		pauseSeconds(5);
		    		// click on save button
		    		jsClick(By.xpath("//div[@id='dvBRPanel']/div[4]/div/button[1]"));
		    		pauseSeconds(5);
		    		
		    		// select the check box of activity 
		    		jsClick(By.xpath("(//ul[@id='activityTree']/li/input)[1]"));
		    		pauseSeconds(5);
		    		
		    		// click on the Replace button
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[2]"));
		    		pauseSeconds(5);
		    		// Select the replaced  business rule
		    		
		    		jsClick(By.xpath("(//div[@id='dvSelectedActsBRPanel']/div[2]/table/tbody//td[2]/button)[1]"));
		    		pauseSeconds(5);
		    		// Select the business rule
		    		jsClick(By.xpath("(//div[@id='dvBRPanelBRList']//input)[1]"));
		    		pauseSeconds(5);
		    		// click on the replace button 
		    		jsClick(By.xpath("(//div[@id='dvBRPanel']/div[4]/div/button)[2]"));
		    		pauseSeconds(5);
		    		// clock on ok button at popup 
		    		jsClick(By.xpath("(//section[@id='alertify']/div/article/nav/button)[2]"));
		    		pauseSeconds(5);
		    		
		    		// select the check box of activity 
		    		jsClick(By.xpath("(//ul[@id='activityTree']/li/input)[1]"));
		    		pauseSeconds(5);
		    		
		    		// click on the copy button
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[3]"));
		    		pauseSeconds(5);
		    		
		    		// select the check box of activity 
		    		jsClick(By.xpath("(//ul[@id='activityTree']/li/input)[2]"));
		    		pauseSeconds(5);
		    		// click on the past button
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[4]"));
		    		pauseSeconds(5);
		    		//click on the UNDO button
		    		
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[5]"));
		    		pauseSeconds(5);
		    		
		    		// click on reverse button 
		    		jsClick(By.xpath("(//div[@id='UndoBRChangeDialogue']/div/div/div[2]/table//td[4]/a[1])[1]"));
		    		pauseSeconds(5);
		    		// click ok on popup 
		    		jsClick(By.xpath("(//section[@id='alertify']/div/article/nav/button)[2]"));
		    		pauseSeconds(5);
		    		
		    		// for the activity 1 select the business rule and click on the delete button
		    		
		    		// select the check box of activity 
		    		jsClick(By.xpath("(//ul[@id='activityTree']/li/input)[1]"));
		    		pauseSeconds(5);
		    		
		    		// click on the copy button
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[3]"));
		    		pauseSeconds(5);
		    		
		    		// select the check box of activity 
		    		jsClick(By.xpath("(//ul[@id='activityTree']/li/input)[2]"));
		    		pauseSeconds(5);
		    		// click on the past button
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[4]"));
		    		pauseSeconds(5);
		    		//click on the UNDO button
		    		
		    		jsClick(By.xpath("(//div[@class='card-header']/div/a/i)[5]"));
		    		pauseSeconds(5);
		    		
		    		// click on Delete  button 
		    		jsClick(By.xpath("(//div[@id='UndoBRChangeDialogue']/div/div/div[2]/table//td[4]/a[2])[1]"));
		    		pauseSeconds(5);
		    		
		    		// click on manage business rule 
		    		jsClick(By.xpath("//button[text()='Manage Business Rules']"));
		    		pauseSeconds(5);
		    		//Enter the text in search box
		    	
		    		type(By.xpath("//input[@id='dvNewBR']"), "Test");
		    		pauseSeconds(5);
		    		// click on add button
		    		jsClick(By.xpath("//div[@id='dvAddRemovePopUp']/div/i"));
		    		pauseSeconds(2);
		    		try {
		    		jsClick(By.xpath("//div[text()='×']"));
		    		}catch(Exception e) {
		    			System.out.println("No pop up is there to close");
		    		}
		    		
		    		pauseSeconds(5);
		          // click on the close button 
		    		
		    		jsClick(By.xpath("(//div[@id='SemanticCheckDialogue']//button)[1]"));
		    		pauseSeconds(5);
		    	// Delete activity button 
		    		jsClick(By.xpath("//a[@id='DelAct-tab']"));
		    		pauseSeconds(3);
		    	// Replace activity button
		    		jsClick(By.xpath("//a[@id='RpleForms-tab']"));
		    		pauseSeconds(3);
		        // Refresh button
		    		driver.navigate().refresh();
		    		pauseSeconds(5);
		    	
		    	// click on review button 
		    		jsClick(By.xpath("//a[@id='obs-tab']"));
		    		pauseSeconds(5);
		    		
		    		 // click on the review toggle button
		    		// Verify the review toggle is selected or not in not make its selected 
		    				Thread.sleep(5000);
		    				List<WebElement> toggle_switch =	driver.findElements(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));
		    				int size=toggle_switch.size();
		    				System.out.println("lineNo-257 toggle switch count is = "+size);
		    				for(int i=0;i<size;i++) {
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
		    				
		    		String Digital_Mode_Fact_Computation=driver.findElement(By.xpath("(//div[@class='accordion-body']/div[2])[1]/div[1]")).getText();
		    		System.out.println("LineNo-198 Digital_Mode_Fact_Computation is = "+Digital_Mode_Fact_Computation);
		    		
		    		String Digital_Mode_Human_Judgement =driver.findElement(By.xpath("(//div[@class='accordion-body']/div[2])[1]/div[2]")).getText();
		    		System.out.println("LineNo-201 Digital_Mode_Human_Judgement is = "+Digital_Mode_Human_Judgement);
		    		
		    		String Non_Digital_Mode_Fact_Computation =driver.findElement(By.xpath("(//div[@class='accordion-body']/div[3])[1]/div[1]")).getText();
		    		System.out.println("LineNo-204 Digital_Mode_Human_Judgement is = "+Non_Digital_Mode_Fact_Computation);
		    		
		    		String Non_Digital_Mode_Human_Judgement =driver.findElement(By.xpath("(//div[@class='accordion-body']/div[3])[1]/div[2]")).getText();
		    		System.out.println("LineNo-207 Digital_Mode_Human_Judgement is = "+Non_Digital_Mode_Human_Judgement);
		    		
		    		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		    		scroll.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//button[text()='No Business Rules'])[1]")));
		    		pauseSeconds(2);
		    		jsClick(By.xpath("(//button[text()='No Business Rules'])[1]"));
		    		pauseSeconds(5);
		    		jsClick(By.xpath("(//div[@id='noBusinessRuleModal']/div/div/div/button)[1]"));
		    		
		    		// click on Teamsalary button
		    		jsClick(By.xpath("//a[@href='/Teams/Teams']"));
		    		pauseSeconds(5);
		    		System.out.println("Navigate to the TeamSalary page = "+driver.getCurrentUrl());
		    		
		    		
		    		
	}

	
}
