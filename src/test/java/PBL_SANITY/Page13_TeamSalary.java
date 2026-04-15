package PBL_SANITY;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;



public class Page13_TeamSalary extends PblSanityBase
{

	
	

	@Test(invocationCount=1)
	public void business_rules() throws InterruptedException
	{

		 loginToPbl();
	        openDefaultProject();
	        openProjectPage("Teams/Teams");
	        pauseSeconds(5);
	      //click on populate pending
	    	
	    	jsClick(By.xpath("//button[text()='Populate Pending']"));
	    	pauseSeconds(5);
	    	// get the currency type
	    	String Currency_Type=driver.findElement(By.xpath("//table[@id='dvActorDetail']/tbody//td[2]")).getText();
	    	System.out.println("LineNo-193 Currency_Type is = "+Currency_Type);
	    	// get the currency count
	    	String TotalCurrency=driver.findElement(By.xpath("//table[@id='dvActorDetail']/tbody//td[3]")).getText();
	    	System.out.println("LineNo-193 Currency_Type is = "+TotalCurrency);
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
		    		
		    				// Get the location 
		    				String Location=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody//td[1]")).getText();
		    				System.out.println("LineNo-193 Location is = "+Location);
		    				// Get the AvrageSalary
		    				String AvrageSalary=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody//td[2]")).getText();
		    				System.out.println("LineNo-193 AvrageSalary is = "+AvrageSalary);
		    				// Get the TeamName
		    				String TeamName=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td")).getText();
		    				System.out.println("LineNo-193 TeamName is = "+TeamName);
		    				
		    		// click on Opration site button
		    		jsClick(By.xpath("//a[@href='/Infra/OperationSites']"));
		    		pauseSeconds(5);
		    		System.out.println("Navigate to the Opration sight page = "+driver.getCurrentUrl());
		    		
		    		
		    		
	}

	
}
