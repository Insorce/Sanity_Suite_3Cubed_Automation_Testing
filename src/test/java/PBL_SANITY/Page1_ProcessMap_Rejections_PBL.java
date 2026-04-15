package PBL_SANITY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Page1_ProcessMap_Rejections_PBL extends PblSanityBase {

    @Test
    public void processMapRejectionsPage() throws InterruptedException {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/ProcessMapRejections");

      //click on populating button for predicting 
      		Thread.sleep(1000);
      		JavascriptExecutor populating = (JavascriptExecutor)driver;
             populating.executeScript("arguments[0].click()",driver.findElement(By.xpath("//button[text()='Populate Pending']")));
              
              Thread.sleep(Duration.ofSeconds(30).toMillis());
              
              // Click on the review button for observations
              
              JavascriptExecutor observation = (JavascriptExecutor)driver;
              observation.executeScript("arguments[0].click()",driver.findElement(By.xpath("//a[@href='#Observations']")));
      		//driver.findElement(By.xpath("//a[@href='#Observations']")).click();
      		
      		Thread.sleep(Duration.ofSeconds(10).toMillis());
      		//(//input[@type='checkbox'])[5]
      	// Verify the review toggle is selected or not in not make its selected 
      		
      	List<WebElement> toggle_switch =	driver.findElements(By.xpath("//div[@id='Observations']//div[@class='float-end mt-2']//input"));
      	int size=toggle_switch.size();
      	for(int i=0;i<size;i++) {
      		System.out.println(toggle_switch.get(i).isSelected());
      		if(toggle_switch.get(i).isSelected()) {
      		   System.out.println("Toggle is Alredy selected");
      		//toggle_switch.get(i).click();
      		}else {
      			JavascriptExecutor toggle = (JavascriptExecutor)driver;
      			toggle.executeScript("arguments[0].click()", toggle_switch.get(i));
      			System.out.println("Toggle is selected now this script");
      		}
      	}
      	
      	
      		Thread.sleep(Duration.ofSeconds(20).toMillis());
      	
      		
      	
      		// Rework loops verification 
      		
      		// Click on the rework loops button
      		JavascriptExecutor rework = (JavascriptExecutor)driver;
      		
      		rework.executeScript("window.scrollBy(0,300)");
      		Thread.sleep(3000);

      		rework.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//div[@class='float-left row mt-3']/div[1])[1]")));
      		
      		Thread.sleep(3000);
      		WebElement reworkcount=driver.findElement(By.xpath("(//div[@class='float-left row mt-3']/div[1])[1]"));
      		
      		String reworknumber= reworkcount.getText();

      		System.out.println("LineNo-134 Rework loop count = "+reworknumber);
      		Thread.sleep(4000);
      		
      		//move to the rework frame and get the list of rework loops
      		 WebElement iframe1= driver.findElement(By.xpath("//iframe[@id='IframeAdditionalInfo']"));
      		  driver.switchTo().frame(iframe1);
      	
      	    List<WebElement> reworkloops=  driver.findElements(By.xpath("//table[@class='table table-bordered dataTable']/tbody/tr/td[2]"));
      	int size1= reworkloops.size();
      	System.out.println("LineNo-141 Rework loop count in rework pag = "+size1);
      	
      	
      	StringBuilder  sb= new StringBuilder(String.valueOf(size1));
      	sb.equals(reworknumber);
      	
      	
      	for(int j=0; j<size1; j++) {
      		String list=reworkloops.get(j).getText();
      		System.out.println("Line No-150 Rework loops name = "+list);
      	}
      	
      	// Click on the view and hide button 
      	  Thread.sleep(9000);

      	List<WebElement> viewbutton=driver.findElements(By.xpath("//table[@class='table table-bordered dataTable']/tbody/tr/td[3]"));
      	int size3=viewbutton.size();
      	for(int t=0; t<size3;t++ ){
      		JavascriptExecutor view = (JavascriptExecutor)driver;
      		view.executeScript("arguments[0].click()", viewbutton.get(t));
      		Thread.sleep(2000);
      		
      	}
      	
      	
      	Thread.sleep(6000);
      	//Click on the done button for closing the rework loops pop up
      	
      	//driver.findElement(By.xpath("((//div[@class='modal-header'])[3]/button)[1]")).click();
      	driver.switchTo().defaultContent();
      	JavascriptExecutor done = (JavascriptExecutor)driver;
      	done.executeScript("arguments[0].click()",driver.findElement(By.xpath("((//div[@class='modal-header'])[3]/button)[1]")) );

      	
      	// Validating the Paths 
      	Thread.sleep(Duration.ofSeconds(15).toMillis());
      	JavascriptExecutor paths = (JavascriptExecutor)driver;
      	WebElement pathcount=driver.findElement(By.xpath("((//div[@class='accordion-body'])[3]/div/div/div)[1]"));
      	String pathlist= pathcount.getText();
      	System.out.println("LineNo-181 Total paths count is = "+ pathlist);
      	
      	paths.executeScript("arguments[0].click()",driver.findElement(By.xpath("((//div[@class='accordion-body'])[3]/div/div/div)[1]")) );
              
      	// Move to the paths frame and get the list of paths with start and end activities
      	 WebElement iframe2= driver.findElement(By.xpath("//iframe[@id='IframeAdditionalInfo']"));
      	  driver.switchTo().frame(iframe2);
      // Get the Path start activities list
         List<WebElement> pathsstartactivities=  driver.findElements(By.xpath("//table[@class='table table-bordered dataTable']/tbody/tr/td[2]"));
      int size2= pathsstartactivities.size();
      System.out.println("LineNo-191 Path Start activites count = "+size2);

      // Get the Path end activities list
      List<WebElement> pathsendactivities=  driver.findElements(By.xpath("//table[@class='table table-bordered dataTable']/tbody/tr/td[3]"));
      int size5= pathsendactivities.size();
      System.out.println("LineNo-196 Paths End activities count = "+size5);



      // Click on the view and hide button 
      Thread.sleep(9000);

      List<WebElement> viewbutton2=driver.findElements(By.xpath("//table[@class='table table-bordered dataTable']/tbody/tr/td[4]"));
      int size7=viewbutton2.size();
      StringBuilder  sb1= new StringBuilder(String.valueOf(size7));
      System.out.println("LineNo-205 = "+equals(pathlist));

      for(int t=0; t<size7;t++ ){
      	JavascriptExecutor view = (JavascriptExecutor)driver;
      	view.executeScript("arguments[0].click()", viewbutton2.get(t));
      	Thread.sleep(2000);
      	
      }



      Thread.sleep(5000);


      	
      //Thread.sleep(3000);
      //driver.findElement(By.xpath("((//div[@class='modal-header'])[3]/button)[1]")).click();

      // Click on the done button for closing the paths pop up
      driver.switchTo().defaultContent();
      JavascriptExecutor done1 = (JavascriptExecutor)driver;
      done1.executeScript("arguments[0].click()",driver.findElement(By.xpath("((//div[@class='modal-header'])[3]/button)[1]")) );
      	
      		//driver.findElement(By.xpath("((//div[@class='accordion-body'])[3]/div/div/div)[1]"));
      	
      	
      //Validating the Rejection Paths 

      	Thread.sleep(Duration.ofSeconds(15).toMillis());
      	
      	WebElement Rejectionpathcount=driver.findElement(By.xpath("(//div[@class='col-sm-2'])[4]/div/span"));
      	String rejections= Rejectionpathcount.getText();
      	System.out.println("LineNo-249 Total Rejection paths count is = "+ rejections);
      	 JavascriptExecutor Rejectionpath = (JavascriptExecutor)driver;
      	 Rejectionpath.executeScript("arguments[0].click()",driver.findElement(By.xpath("(//div[@class='col-sm-2'])[4]/div/span")) );
           
      	// Move to the paths frame and get the list of paths with start and end activities
      	 WebElement iframe3= driver.findElement(By.xpath("//iframe[@id='IframeAdditionalInfo']"));
      	  driver.switchTo().frame(iframe3);

      	
      	// Click on the view and hide button 
      	  Thread.sleep(9000);
      	  List<WebElement> view=driver.findElements(By.xpath("//table[@class='table table-bordered dataTable']/tbody/tr/td[4]"));
      	  int Rejection_Count=view.size();
      	   System.out.println("LineNo-262 Rejection paths count in rejection paths page = "+Rejection_Count);
      	 
      	   JavascriptExecutor Rejectionpaths = (JavascriptExecutor)driver;
      	   Rejectionpaths.executeScript("arguments[0].click()",driver.findElement(By.xpath("(//table[@class='table table-bordered dataTable']/tbody/tr/td[4])[1]")) );
      	   Rejectionpaths.executeScript("arguments[0].click()",driver.findElement(By.xpath("(//table[@class='table table-bordered dataTable']/tbody/tr/td[4])[2]")) );

      	

      		Thread.sleep(6000);
      		//Click on the done button for closing the Rejection paths pop up
      		
      		//driver.findElement(By.xpath("((//div[@class='modal-header'])[3]/button)[1]")).click();
      		driver.switchTo().defaultContent();
      		JavascriptExecutor done2 = (JavascriptExecutor)driver;
      		done2.executeScript("arguments[0].click()",driver.findElement(By.xpath("((//div[@class='modal-header'])[3]/button)[1]")) );

      	
      	
    
    
    
    }

   
        
        
        
        
    }

