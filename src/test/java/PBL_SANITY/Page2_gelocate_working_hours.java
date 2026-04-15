package PBL_SANITY;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Page2_gelocate_working_hours extends PblSanityBase {

    @Test
    public void gelocateWorkingHours() throws InterruptedException {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/GeolocateWorkingHours");

        pauseSeconds(3);
        jsClick(By.id("btnMapSectionAccordion"));
        System.out.println("View map opened successfully");
        
        jsClick(By.id("btnMapSectionAccordion"));
        pauseSeconds(3);
        
        List<WebElement> rows1 = driver.findElements(
        	    By.xpath("//table[@id='dvTeamLocations']/tbody/tr")
        	);

        	for (WebElement row : rows1) {

        	    WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));

        	    if (!checkbox.isSelected()) {

        	        WebElement label = row.findElement(By.xpath(".//label"));

        	        ((JavascriptExecutor) driver)
        	            .executeScript("arguments[0].click();", label);

        	        System.out.println("Switched ON via label");
        	    } else {
        	        System.out.println("Already ON → no action");
        	    }
        	}
		
		

		Thread.sleep(4000);
        /*
        List<WebElement> scopeToggles = driver.findElements(
                By.xpath("//div[@id='EditMap']/descendant::label[@class='toggle-switchy']"));
        System.out.println("Team count = " + scopeToggles.size());
        for (WebElement scopeToggle : scopeToggles) {
            clickElement(scopeToggle);
            pauseSeconds(2);
        }
		//click on in scope and out scope
		List<WebElement>scope=driver.findElements(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr"));
        System.out.println("lineNo97- Teams count was "+scope.size());
		
        */
        

		List<WebElement>rows=driver.findElements(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr"));

      Actions act=new Actions(driver);

		for (int i2 = 1; i2 <=rows.size(); i2++) 
		{


			//enter the location
			WebElement location=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorCity')]"));

			if(location.isEnabled())
			{

				location.clear();
				location.sendKeys("Hyderabad");
				Thread.sleep(3000);
				location.sendKeys(Keys.ARROW_DOWN);
				location.sendKeys(Keys.ENTER);
				System.out.println("LineNo-130 location Entered successfully");
			}
			else
			{
				System.out.println("LineNo-134 location  is not been enbaled");
			}




			//start time

			WebElement start_time=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorStartTime')]"));
			if(start_time.isEnabled())
			{

				start_time.sendKeys(Keys.CONTROL.chord("a"));
				start_time.sendKeys(Keys.BACK_SPACE);
				start_time.sendKeys("10:00");
				Thread.sleep(3000);
				start_time.sendKeys(Keys.ENTER);
				System.out.println("LineNo-151 start time is entered successfully");
			}
			else
			{
				System.out.println("LineNo-155 start time is not been enabled");
			}



			//end time
			WebElement end_time=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorWorkingHours')]"));
			if(end_time.isEnabled())
			{
				end_time.sendKeys(Keys.CONTROL.chord("a"));
				end_time.sendKeys(Keys.BACK_SPACE);
				end_time.sendKeys("06:00");
				Thread.sleep(3000);
				System.out.println("LineNo-168 end time is entered successfully");
				//end_time.sendKeys(Keys.ENTER);
			}
			else
			{
				System.out.println("LineNo173-end time is not bene enabled");
			}


			//prodcutive hours
			WebElement productive_hours=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorProductiveHours')]"));
			if(productive_hours.isEnabled())
			{
				productive_hours.sendKeys(Keys.CONTROL.chord("a"));
				productive_hours.sendKeys(Keys.BACK_SPACE);
				productive_hours.sendKeys("10:00");
				Thread.sleep(3000);
				System.out.println("LineNo-185 productive hours is entered successfully");
				//productive_hours.sendKeys(Keys.ENTER);
			}
			else
			{
				System.out.println("LieNo-190 productive hours is not enabled");
			}


			//end time
			WebElement end_time1=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorEndTime')]"));
			if(end_time1.isDisplayed())
			{
				end_time1.sendKeys(Keys.CONTROL.chord("a"));
				end_time1.sendKeys(Keys.BACK_SPACE);
				end_time1.sendKeys("9:00");
				Thread.sleep(3000);
				//end_time1.sendKeys(Keys.ENTER);

			}
			else
			{
				System.out.println("end time is not enabled");
			}

		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		
		
		
		//clickk on review
		Thread.sleep(3000);
		WebElement observations_insorce=driver.findElement(By.xpath("//a[@id='obs-tab']"));
		JavascriptExecutor team_1 = (JavascriptExecutor)driver;
		team_1.executeScript("arguments[0].click();", observations_insorce);
		System.out.println("lineNo-217 Enter the Review page,observations tab is working good");

		//click on the hyper links in observations
		Thread.sleep(5000);
		WebElement hyper_link=driver.findElement(By.xpath("(//a[text()='Click to View Popup and interaction model'])[1]"));
		JavascriptExecutor link_click = (JavascriptExecutor)driver;
		link_click.executeScript("arguments[0].click();", hyper_link);
       
		
						
		//click on the close
		Thread.sleep(5000);
		WebElement close_popup=	driver.findElement(By.xpath("(//button[@class='btn-close'])[1]"));
		JavascriptExecutor click_popup = (JavascriptExecutor)driver;
		click_popup.executeScript("arguments[0].click();", close_popup);
		System.out.println("lineNo-252 close button in popup is working good");
		
		// Verify the review toggle is selected or not in not make its selected 
		Thread.sleep(5000);
		List<WebElement> toggle_switch1 =	driver.findElements(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));
		int size2=toggle_switch1.size();
		System.out.println("lineNo-257 toggle switch count is = "+size2);
		for(int i=0;i<size2;i++) {
			System.out.println(toggle_switch1.get(i).isSelected());
			if(toggle_switch1.get(i).isSelected()) {
			   System.out.println("LineNo-276 Toggle is Alredy selected");
			//toggle_switch.get(i).click();
			}else {
				JavascriptExecutor toggle = (JavascriptExecutor)driver;
				toggle.executeScript("arguments[0].click()", toggle_switch1.get(i));
				System.out.println("LineNo-281 Toggle is selected now this script");
			}
		}
		
		
			Thread.sleep(Duration.ofSeconds(5).toMillis());
		
		//click on the system and applications
       
		WebElement system_applications=	driver.findElement(By.xpath("//div[@id='Observations']/div/a"));
		JavascriptExecutor system_app_click = (JavascriptExecutor)driver;
		system_app_click.executeScript("arguments[0].click();", system_applications);
      		 System.out.println("lineNo-293 "+driver.getTitle());
		

        
        
        

        /*
        List<WebElement> scopeToggles = driver.findElements(
                By.xpath("//div[@id='EditMap']/descendant::label[@class='toggle-switchy']"));
        System.out.println("Team count = " + scopeToggles.size());
        for (WebElement scopeToggle : scopeToggles) {
            clickElement(scopeToggle);
            pauseSeconds(2);
        }

        int rowCount = driver.findElements(
                By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr")).size();

        for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
            fillWorkingHourRow(rowIndex);
        }

        pauseSeconds(3);
        jsClick(By.id("obs-tab"));
        System.out.println("Review tab opened successfully");

        pauseSeconds(5);
        jsClick(By.xpath("(//a[text()='Click to View Popup and interaction model'])[1]"));
        pauseSeconds(5);
        jsClick(By.xpath("(//button[@class='btn-close'])[1]"));
        System.out.println("Popup opened and closed successfully");

        selectAllObservationToggles(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));
        pauseSeconds(5);

        jsClick(By.xpath("//div[@id='Observations']/div/a"));
        System.out.println(driver.getTitle());
    }

    private void fillWorkingHourRow(int rowIndex) {
        fillIfEnabled(By.xpath(
                "//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr[" + rowIndex
                        + "]//following-sibling::input[starts-with(@id,'actorCity')]"),
                "Hyderabad", true);

        fillIfEnabled(By.xpath(
                "//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr[" + rowIndex
                        + "]//following-sibling::input[starts-with(@id,'actorStartTime')]"),
                "10:00", false);

        fillIfEnabled(By.xpath(
                "//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr[" + rowIndex
                        + "]//following-sibling::input[starts-with(@id,'actorWorkingHours')]"),
                "06:00", false);

        fillIfEnabled(By.xpath(
                "//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr[" + rowIndex
                        + "]//following-sibling::input[starts-with(@id,'actorProductiveHours')]"),
                "10:00", false);

        fillIfEnabled(By.xpath(
                "//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr[" + rowIndex
                        + "]//following-sibling::input[starts-with(@id,'actorEndTime')]"),
                "9:00", false);
    }

    private void fillIfEnabled(By locator, String value, boolean autocomplete) {
        WebElement field = waitUntilVisible(locator);
        if (!field.isEnabled()) {
            return;
        }

        if (autocomplete) {
            chooseAutocompleteValue(locator, value);
            return;
        }

        clearAndType(locator, value);
        pauseSeconds(2);*/
    }
}
