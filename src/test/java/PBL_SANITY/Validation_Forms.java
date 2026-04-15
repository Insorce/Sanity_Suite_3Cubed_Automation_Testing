package PBL_SANITY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Validation_Forms extends PblSanityBase {

    @Test
    public void validateSystemAndApplicationCrud() throws InterruptedException {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/Forms");

        pauseSeconds(3);
        
      //------- Adding system and application to DOE----------------//
    	
		
    		jsClick(By.xpath("//button[text()='Manage Form(s)']"));
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='dvNewForm']")).sendKeys("Test1");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//i[@class='fas fa-plus input-group-text']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("(//div[@class='modal-body']//a[@href='javascript:void(0)'])[1]")).click();
    		Thread.sleep(2000);
    		try {
    		jsClick(By.xpath("//section[@id='alertify']//nav/button[2]"));
    		}
			catch(Exception e) {
				System.out.println("Alertify popup is not displayed");
			}
    		driver.findElement(By.xpath("//input[@id='ActivitySearchText']")).sendKeys("s");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//a[text()='Search']")).click();
    		Thread.sleep(2000);
    		jsClick(By.xpath("(//div[@id='SearchResults']/div[2]/table/tbody[2]//td[1])[1]/input"));
			 //
    		System.out.println("check box selection is done");
    		WebElement activity=	driver.findElement(By.xpath("(//div[@id='SearchResults']/div[2]/table/tbody[2]//td[3])[1]/a"));
    		String activityname=activity.getText();
    		System.out.println(activityname);
    		    		Thread.sleep(2000);
    		jsClick(By.xpath("//button[text()='Add/Associate']"));
    		driver.navigate().refresh();
    		pauseSeconds(3);
    		
    		
    		
    		
    		//------- Replacing the system and application to DOE----------------//
    		
    		
    		Thread.sleep(3000);
    		jsClick(By.xpath("//button[text()='Manage Form(s)']"));
    		
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//a[@id='RpleForms-tab']")).click();
    		Thread.sleep(2000);
    		
    		Select sc= new Select(driver.findElement(By.xpath("(//select[@id='search-form'])[1]")));
    		sc.selectByVisibleText("test1");
    		Thread.sleep(2000);
    		
    		jsClick(By.xpath("(//div[@class='ms-trigger-ico'])[2]"));
    		Thread.sleep(2000);
    		jsClick(By.xpath("//div[@class='ms-res-ctn dropdown-menu']/div[3]"));
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='ActivitySearchText']")).sendKeys("s");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//a[text()='Search']")).click();
    		Thread.sleep(2000);
    		jsClick(By.xpath("(//div[@id='SearchResults']/div[2]/table/tbody[2]//td[1])[1]/input"));
    		System.out.println("Activity is selected for replacement");
    		Thread.sleep(2000);
    		jsClick(By.xpath("//i[@class='fas fa-arrows-rotate']"));
       		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
    		Thread.sleep(3000);
    	
    		driver.navigate().refresh();
    		Thread.sleep(2000);
    		
    		
    		//-------Delete  the system and application to DOE----------------//	
    		jsClick(By.xpath("//button[text()='Manage Form(s)']"));
    		Thread.sleep(2000);
    		jsClick(By.xpath("//a[text()='Delete from Activity(s)']"));
    		Thread.sleep(2000);
    		List<WebElement> option=driver.findElements(By.xpath("//div[@id='CommonDivSearch']/div[1]/div[2]/span[2]/select/option"));
    		int size2=option.size();
    		option.get(size2-3).click();
    		
    		
    		Thread.sleep(2000);
    	   
    		driver.findElement(By.xpath("//input[@id='ActivitySearchText']")).sendKeys("s");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//a[text()='Search']")).click();
    		Thread.sleep(2000);
    		jsClick(By.xpath("(//div[@id='SearchResults']/div[2]/table/tbody[2]//td[1])[1]/input"));
    		System.out.println("Attibute selection for deletion");
    		Thread.sleep(2000);
    		jsClick(By.xpath("//i[@class='fas fa-trash-can']"));
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
    		driver.navigate().refresh();
    		Thread.sleep(2000);
    		jsClick(By.xpath("//button[text()='Populate Pending']"));
    		Thread.sleep(2000);
    		
    		 
    		 
        
        
        
        
        
        
        
        
        
        
        
     
    }
}
