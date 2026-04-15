package PBL_SANITY;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;



public class Page15_NVA extends PblSanityBase
{

	
	

	@Test(invocationCount=1)
	public void business_rules() throws InterruptedException
	{

		 loginToPbl();
	        openDefaultProject();
	        openProjectPage("Locations/NonProductive");
	        pauseSeconds(5);
	      //click on populate pending
	    	
	    	jsClick(By.xpath("//button[text()='Populate Pending']"));
	    	pauseSeconds(5);
	    // click on the Legend 
	    	jsClick(By.xpath("//button[text()='Legend']"));
	    	pauseSeconds(3);
	    // click to close the legend 
	    	jsClick(By.xpath("//div[@id='LegendSidenav']/a"));
	    	pauseSeconds(5);
	    // get the all activities 
	    	List<WebElement> activities=driver.findElements(By.xpath("//table[@id='tblactprodlist']/tbody//td[1]/a"));
	    	int activities_count=activities.size();
	    	System.out.println("LineNo-193 activities_count is = "+activities_count);
	    	for(int i=0;i<activities_count;i++) {
	    		String NVA=activities.get(i).getText();
	    		System.out.println("LineNo-47 NVA activities name is = "+NVA);
	    	}
	    	
	    	Select select=new Select(driver.findElement(By.xpath("(//select[@class='form-select'])[1]")));
	    	
	    	select.selectByVisibleText("Action");
	    	pauseSeconds(3);
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
		    		
		    							
		    		// click on Opration site button
		    		jsClick(By.xpath("//a[@href='/Risk/ControlIdentification']"));
		    		pauseSeconds(5);
		    		System.out.println("Navigate to the Opration sight page = "+driver.getCurrentUrl());
		    		
		    		
		    		
	}

	
}
