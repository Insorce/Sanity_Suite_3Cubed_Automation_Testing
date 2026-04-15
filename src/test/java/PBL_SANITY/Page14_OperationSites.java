package PBL_SANITY;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;



public class Page14_OperationSites extends PblSanityBase
{

	
	

	@Test(invocationCount=1)
	public void business_rules() throws InterruptedException
	{

		 loginToPbl();
	        openDefaultProject();
	        openProjectPage("Infra/OperationSites");
	        pauseSeconds(5);
	      
	        // Get the opration site loaction 
	       String  OperationSite=driver.findElement(By.xpath("//span[@class='h5']")).getText();
	        
	        System.out.println("LineNo-35 OperationSite is = "+OperationSite);
	        //click on Hamgurger menu
	        	    	jsClick(By.xpath("//button[@class='btn btn-default']"));
	        	    	pauseSeconds(5);
	        //Click on the + button 
	        	    	jsClick(By.xpath("//div[@id='locationTeamModal']/div/div/div/h3/a"));
	        	    	pauseSeconds(5);
	        // click on the cancle button 
	        	    	jsClick(By.xpath("//div[@id='locationTeamModal']/div/div/div[3]/button[2]"));
	        	    	pauseSeconds(5);
	        	    	
	       // Select teh check box 
	        	    	WebElement checkbox = driver.findElement(
	        	    		    By.xpath("//div[@id='OperationSite']/table/tbody//td[3]/div/label/input")
	        	    		);

	        	    		if (!checkbox.isSelected()) {
	        	    		    checkbox.click();
	        	    		}
	        
	        	    		pauseSeconds(5);	
	        // click on the edit seat cost 
	        	    		jsClick(By.xpath("//a[@name='btnEditCost']"));
	        	    		  pauseSeconds(5);	
	        	    		  
	        	    		  Actions ac= new Actions(driver);
	        	    		 ac.click(driver.findElement(By.xpath("(//div[@id='OperationSite']/table/tbody//td[3]//input)[1]"))).perform();
	        	    		  pauseSeconds(2);
	        	    		 ac.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
	        	    		  ac.sendKeys("100").perform();
	        	    		  ac.sendKeys(Keys.TAB).perform();
	        	    		  pauseSeconds(2);
	        	    		     		
	        	//select the component dropdown 
	        	    		try {
	        	    		  jsClick(By.xpath("//div[@id='OperationSite']/table/tbody//td[3]/div/label/input"));
	        	    		  
	        	    		
	        	    		  pauseSeconds(2);
	        	    		// click on the edit button 
	        	    		  jsClick(By.xpath("//a[@name='btnCostWizard']"));
	        	    		  pauseSeconds(5);
	        	
	        	   
	        	   // select the checkbox of the component at need row one  
	        	    		  jsClick(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[2])[1]/input"));
	        	    		  pauseSeconds(2); 
	        	    		//Select the Fixed cost Radi button 
	        	    		  jsClick(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[4])[1]/input[1]"));
	        	    		  pauseSeconds(2);
	        	    		  
	        	    		  
	        	    		  
	        	    // Add investment per Annum 
	        	    		 type(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[5])[1]/div/input"), "2");  
	        	    		  pauseSeconds(2);
	        	    // Add Depreciation(In Years)
	        	    	type(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[8]/input)[1]"), "2");  
	        	    		  pauseSeconds(2);
	        	    // Add AMC 
	        	    		  type(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[9]/input)[1]"), "2");  
	        	    		  pauseSeconds(2);
	        	    		  
	        	    		  // select the checkbox of the component at need row two  
	        	    		  jsClick(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[2])[2]/input"));
	        	    		  pauseSeconds(2); 
		    		//Select the FTE Radi button 
	        	    		  jsClick(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[4])[2]/input[2]"));
	        	    		  pauseSeconds(2);
	        	    		  
	        	    		  // Add Price
		        	    		 type(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[6])[2]/input"), "3");  
		        	    		  pauseSeconds(2);
		        	 		  // Add Quantity 
		        	    		  type(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[7])[2]/input"), "3");  
		        	    		  pauseSeconds(2);
	        	    		  
		        	    		  // Add Depreciation(In Years)
		  	        	    	type(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[8]/input)[2]"), "4");  
		  	        	    		  pauseSeconds(2);
		  	        	    // Add AMC 
		  	        	    		  type(By.xpath("(//div[@id='InfraTabCategory0']/table/tbody//td[9]/input)[2]"), "4");  
		  	        	    		  pauseSeconds(2);
		  	        	   // Add the new omponent 
		  	        	    		  
		  	        	    		  type(By.xpath("//input[@id='AddNonStandardEquipment']"), "TestComponent");
		  	        	    		  pauseSeconds(2);
		  	        	    // Click on the add button 
		  	        	    	 
		  	        	          	  jsClick(By.xpath("//a[@id='AddNewEquipment']"));
		  	        	    		  pauseSeconds(5);
		  	        	    		  
		  	        	    		  driver.navigate().refresh();
		  	        	    		  pauseSeconds(5);
		  	        	    // click on the save and continue button 
		  	        	    		  jsClick(By.xpath("//button[@id='savecontinue']"));
		  	        	    		  pauseSeconds(5);	  
		  	        	    		  
		  	        	    		// Select teh check box 
		  		        	    	WebElement checkbox1 = driver.findElement(
		  		        	    		    By.xpath("//div[@id='OperationSite']/table/tbody//td[3]/div/label/input")
		  		        	    		);

		  		        	    		if (!checkbox1.isSelected()) {
		  		        	    		    checkbox1.click();
		  		        	    		}
		  		        	    		
	        	    		}catch(Exception e) {
	        	    		 System.out.println("Component dropdown is not found or not clickable "+e.getMessage());
	        	    			
	        	    		}
		  	        	    // click on the review button 
		  		        	    		pauseSeconds(5);
		  		        	    		jsClick(By.xpath("//a[text()='Review']"));
		  		        	    		pauseSeconds(5);
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
		  			 
		  			    				String Infra_Cost_by_Location= driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody)[2]//td[3]/h5/span")).getText();
		  			    			System.out.println("LineNo-193 Infra_Cost_by_Location is = "+Infra_Cost_by_Location);	
		  			    			pauseSeconds(5);
		  			    			jsClick(By.xpath("//a[@href='/Locations/NonProductive']"));
	        	    		  
	}

	
}
