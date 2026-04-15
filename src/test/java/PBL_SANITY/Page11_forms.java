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

public class Page11_forms extends PblSanityBase
{

	
	@Test(invocationCount=1)
	public void forms() throws InterruptedException
	{

		 loginToPbl();
	        openDefaultProject();
	        openProjectPage("Process/forms");
	
	Thread.sleep(3000);
	JavascriptExecutor click = (JavascriptExecutor)driver;
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
		Select sc= new Select(driver.findElement(By.xpath("(//select[@class='form-select is-cursor-pointer'])[1]")));
	     sc.selectByVisibleText("Digital Form");
		Thread.sleep(3000);
	}
		Thread.sleep(3000);
		click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='col-sm-1']/div/a[1]/i)[1]")));
      Thread.sleep(3000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='col-sm-1']/div/a[2]/i)[1]")));
      Thread.sleep(3000);
      // select check box 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//ul[@id='activityTree']/li/input)[1]")));
      Thread.sleep(3000);
      //click + button
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='card-header']/div/a/i)[1]")));
      Thread.sleep(3000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@id='dvFormPanel']/div[2]/div/div/input)[1]")));
      Thread.sleep(3000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='dvFormPanel']/div[3]/div/button[1]")));
      Thread.sleep(3000);
      // Select drop down
      List<WebElement> list1=driver.findElements(By.xpath("(//ul[@id='activityTree']/li)[1]/ul[1]//select"));
  	int sz1=list.size();
  	for(int i=0; i<sz1;i++) {
  		list1.get(i);
  		Select sc= new Select(driver.findElement(By.xpath("(//select[@class='form-select is-cursor-pointer'])[1]")));
  	     sc.selectByVisibleText("Digital Form");
  		Thread.sleep(3000);
  	}
      
      // select check box 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//ul[@id='activityTree']/li/input)[1]")));
      Thread.sleep(3000);
      
      
      
      // replace button 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='card-header']/div/a/i)[2]")));
      Thread.sleep(3000);
       click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='dvSelectedActsFormPanel']/div[2]/table//td[2]/button")));
      Thread.sleep(3000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@id='dvFormPanel']/div[2]/div/div/input)[1]")));
      Thread.sleep(3000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@id='dvFormPanel']/div[3]/div/button)[2]")));
      Thread.sleep(3000);
      // accept the popup alert
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//section[@id='alertify']/div/article/nav/button)[2]")));
     // select the form
      Thread.sleep(3000);
  // select drop down
      List<WebElement> list3=driver.findElements(By.xpath("(//ul[@id='activityTree']/li)[1]/ul[1]//select"));
  	int sz2=list.size();
  	for(int i=0; i<sz2;i++) {
  		list3.get(i);
  		Select sc= new Select(driver.findElement(By.xpath("(//select[@class='form-select is-cursor-pointer'])[1]")));
  	     sc.selectByVisibleText("Digital Form");
  		Thread.sleep(3000);
  	}
      
      // // select check box 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//ul[@id='activityTree']/li/input)[1]")));
      Thread.sleep(3000);
      // copy 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='card-header']/div/a/i)[3]")));
      Thread.sleep(3000);
      
      // // select check box 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//ul[@id='activityTree']/li/input)[2]")));
      Thread.sleep(3000);
      // past 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='card-header']/div/a/i)[4]")));
      Thread.sleep(3000);
      // Undo 
      
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='card-header']/div/a/i)[5]")));
      
      Thread.sleep(2000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@id='UndoFormChangeDialogue']/div/div/div[2]/table//td[4]/a[1])[1]")));
      Thread.sleep(3000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//section[@id='alertify']/div/article/nav/button[1]")));
      Thread.sleep(3000);
      // in Undo delete the changes 
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@id='UndoFormChangeDialogue']/div/div/div[2]/table//td[4]/a[2])[1]")));
      Thread.sleep(3000);
      click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='UndoFormChangeDialogue']/div/div/div[3]/button")));
	  Thread.sleep(3000);
	  
	  // click on the manage form button
	 click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Manage Form(s)']")));
	  Thread.sleep(3000);
	 // send the text 
	  driver.findElement(By.xpath("//input[@id='dvNewForm']")).sendKeys("Test1");
	  Thread.sleep(3000);
	  //click on the add'+' button
	  click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='dvAddRemovePopUp']/div/i")));
	  Thread.sleep(3000);
	  // click on the close button
	  click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='SemanticCheckDialogue']/div/div/div[1]/button")));
	  Thread.sleep(3000);
	  //click on the delete button
	  click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='DelAct-tab']")));
	  Thread.sleep(3000);
	  // click on the replace button
	  click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='RpleForms-tab']")));
	  Thread.sleep(3000);
	  // click on reload 
	  driver.navigate().refresh();
	  Thread.sleep(3000);
	  //click on the populate pending button
	  click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Populate Pending']")));
	  Thread.sleep(7000);
	  // click on the review button
	  click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='obs-tab']")));
	  Thread.sleep(3000);
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
			// scroll down the page
			JavascriptExecutor scroll = (JavascriptExecutor)driver;
			scroll.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//button[text()='Following Forms appear in > 90% of activities'])[1]")));
			 Thread.sleep(2000);
			
			
			
			
			// click on the forms activities 
			
			List<WebElement> list_activities = driver.findElements(By.xpath("(//div[@id='FormGrtnintyAccor']/div/ul)[1]/li/a"));
			int size1=list_activities.size();
			for(int i=0;i<size1;i++) {
				JavascriptExecutor toggle1 = (JavascriptExecutor)driver;
				toggle1.executeScript("arguments[0].click()", list_activities.get(i));
				
				Thread.sleep(3000);
							
			}
	  
	  // click on the view  button
			
			Thread.sleep(3000);
			click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//button[text()='View'])[1]")));
			Thread.sleep(3000);
	// print the all forms 
			List<WebElement> all_forms=driver.findElements(By.xpath("//table[@class='table table-hover table-condensed table-bordered']/tbody/tr/td[1]"));
			int size2=all_forms.size();
			System.out.println("lineNo-333 total forms count is = "+size2);
			for(int i=0;i<size2;i++) {
				String s=all_forms.get(i).getText();
				System.out.println(s);
			}
			Thread.sleep(3000);
		// close the popupwindow 	
			click.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@class='d-flex']/button)[2]")));
			Thread.sleep(3000);
			//print the digital mode 
			String digitalmode=driver.findElement(By.xpath("//div[@id='FormAutomation']/div[2]/div/div[1]/h4/a")).getText();
			System.out.println("lineNo-256 Digital mode is = "+digitalmode);
			// print the non digital mode
			String nondigitalmode=driver.findElement(By.xpath("//div[@id='FormAutomation']/div[2]/div/div[2]/h4/a")).getText();
			System.out.println("lineNo-256 Non digital mode is = "+nondigitalmode);
			Thread.sleep(3000);
			// click on the business rule button
			click.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='Observations']/div/button/i")));
			Thread.sleep(3000);
			System.out.println("lineNo-361 business rule button is clicked successfully = "+ driver.getTitle());
	  
	  
	}

}

	
	

