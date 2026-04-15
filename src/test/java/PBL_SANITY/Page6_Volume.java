package PBL_SANITY;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Page6_Volume extends PblSanityBase {

    @Test
    public void volumePage() throws InterruptedException {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/Volume");

      //  jsClick(By.xpath("//a[@title=\"Full screen\"]"));
        clickPopulatePending();
        pauseSeconds(5);
        jsClick(By.xpath("//a[text()='Review']"));
        pauseSeconds(2);

        selectAllObservationToggles(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        pauseSeconds(5);

       
     // Get the rework data
		JavascriptExecutor rework = (JavascriptExecutor)driver;
		
		rework.executeScript("window.scrollBy(0,300)");
					
		Thread.sleep(3000);
		WebElement reworkcount=driver.findElement(By.xpath("//span[@data-bind='text:$root.ReworkPercentage']"));
	//	driver.findElement(By.xpath("//div[@id='perRW']/div[2]/div[1]/span")).getA)
		String reworknumber= reworkcount.getText();
		System.out.println("LineNo-167 reworkcount = "+reworknumber);
		Thread.sleep(4000);
		
		//get the FTR data
		//driver.findElement(By.xpath("//span[@data-bind='text:$root.firstTimeRight']")).getText();
		//System.out.println("LineNo-171 FTR count = "+driver.findElement(By.xpath("//span[@data-bind='text:$root.firstTimeRight']")).getText());
 WebElement FTR=driver.findElement(By.xpath("//span[@data-bind='text:$root.firstTimeRight']"));
		
		String FTRnumber= FTR.getText();
		System.out.println("LineNo-175 FTR count = "+FTRnumber);
		
		//get the Rejection data
		
         WebElement Rejection=driver.findElement(By.xpath("//div[@id='perRJ']/div[2]/div[1]/span"));
				
				String Rejectionnumber= Rejection.getText();
				System.out.println("LineNo-182 Rejection count = "+Rejectionnumber);
		
				
				// get the In volume 
				String InVolume=driver.findElement(By.xpath("//div[@id='SinkSrcVolume']/table[1]/tbody//td[2]")).getText();
		        		System.out.println("In Volume is = "+InVolume);
		        		
				// get the out volume
		        String OutVolume=driver.findElement(By.xpath("//div[@id='SinkSrcVolume']/table[1]/tbody//td[3]")).getText();
		System.out.println("Out Volume is = "+OutVolume);
		        if(InVolume.equals(OutVolume)) {
					System.out.println("In volume and out volume are same");
		        }
				else {System.out.println("In volume and out volume are not same");}
		        
		        Thread.sleep(3000);
		        JavascriptExecutor sink = (JavascriptExecutor)driver;
		        sink.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//button[text()='Sink and Source Paths'])[1]")));
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("(//div[@id='dvShowVolObsinPopup']/div/div/div/button)[1]")).click();
		         
				Thread.sleep(2000);
				
		        sink.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='/Validation/FTR']")));

				// FTR Validation 
		        Thread.sleep(2000);
		        Actions action = new Actions(driver);
		        action.moveToElement(driver.findElement(By.xpath("//a[@id='205']"))).perform();
		        Thread.sleep(2000);
				//driver.findElement(By.xpath("//a[@id='205']"));
		        action.contextClick(driver.findElement(By.xpath("//a[@id='205']"))).perform();
		        Thread.sleep(2000);
		        action.moveToElement(driver.findElement(By.xpath("//a[@id='Rvd']"))).click().perform();
		        Thread.sleep(4000);
		        driver.findElement(By.xpath("//a[@href='/Process/AHT']")).click();
		        Thread.sleep(3000);
        System.out.println("AHT page is opened successfully");
    }
}
