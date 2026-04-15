package PBL_SANITY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Page8_gelocate_team_size extends PblSanityBase
{
	
	
	
	
    @Test
	public  void gelocate_team_size_as_is() throws InterruptedException
	{

    	loginToPbl();
        openDefaultProject();		
        openProjectPage("Process/GeolocateTeamSize");

		
		//click on view map
		WebElement view_map=	driver.findElement(By.xpath("//button[@id='btnWorldMapAccordion']"));
		JavascriptExecutor click_viewmap = (JavascriptExecutor)driver;
		click_viewmap.executeScript("arguments[0].click();", view_map);
		Thread.sleep(3000);
		
		
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='TmSizetbl']/tbody[2]/tr/td[5]"));
		int size1=list.size();
		
		for(int i=1;i<=size1;i++) {
			WebElement e1 = driver.findElement(By.xpath("//table[@id='TmSizetbl']/tbody[2]/tr["+i+"]/td[5]"));
			String minimumFTE = e1.getText().trim();

			// Convert to number + add 1
			int value = Integer.parseInt(minimumFTE);
			int newValue = value + 1;

			// Enter into input field
			WebElement input = driver.findElement(By.xpath("//table[@id='TmSizetbl']/tbody[2]/tr["+i+"]/td[6]//input"));
			input.clear();
			input.sendKeys(String.valueOf(newValue));
			
			Thread.sleep(3000);
		}
		
		//click on Review button
		WebElement observations_teamsize=driver.findElement(By.id("obs-tab"));
		JavascriptExecutor observations_team = (JavascriptExecutor)driver;
		observations_team.executeScript("arguments[0].click();", observations_teamsize);
		pauseSeconds(3);

        selectAllObservationToggles(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));
        pauseSeconds(5);

		/*
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
		*/
		
		
		
		
		//click on release and wait types
		Thread.sleep(20000);
		WebElement hello_1=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		JavascriptExecutor click_cont = (JavascriptExecutor)driver;
		click_cont.executeScript("arguments[0].click();", hello_1);


	}



}
