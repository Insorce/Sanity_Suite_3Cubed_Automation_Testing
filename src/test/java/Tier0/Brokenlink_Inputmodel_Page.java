package Tier0;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Brokenlink_Inputmodel_Page extends Baseclass {
	@Test
	public void PageBreaks_Inputmodel_Page() throws Exception {
		//WebDriver driver= new ChromeDriver();
				//driver.get("https://prod.3-cubed.com/");
				String A="https://prod.3-cubed.com/";	


				String WelcomePage="https://prod.3-cubed.com/Projects/Welcome";

				driver.get(A);
				//Maximize window
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				//enter username
				driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("mahesh");
				//enter password
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
				driver.findElement(By.xpath("//button[@name='Logon']")).click();
				String AA=driver.getCurrentUrl();
				if(AA.equals(WelcomePage)) {
					System.out.println("Login Success");
				}

				if (AA.equals("https://prod.3-cubed.com/Account/LogOn"))
				{
					driver.findElement(By.xpath("//button[text()='Log Out']")).click();
					driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("mahesh");
					//enter password
					driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
					driver.findElement(By.xpath("//button[@name='Logon']")).click();
					
				}
		        // log out code is completed here
				
				
				
				//click on the view projects
				WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
				JavascriptExecutor insorce = (JavascriptExecutor) driver;
				insorce.executeScript("arguments[0].click();", rk);


				//click on project
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Projects/Welcome?Pid=5519']")));
				JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
				insorce1.executeScript("arguments[0].click();", insorce678);

				
				//click on input button
				Thread.sleep(7000);
				WebElement input_button=driver.findElement(By.xpath("//a[@title='Input Model']"));
				JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
				click_input_button.executeScript("arguments[0].click();", input_button);
				
				
				String title = driver.getTitle();
			       System.out.println("Current page -> "+ title);
				
			       // find the links based on the tag name 
		    		int brokenlinks=0;
		    		List<WebElement> listoflinks=driver.findElements(By.tagName("a"));
		    		// get the size
		    		int links= listoflinks.size();
		    		System.out.println("Total links found =  "+links);
		    		// read the all links and get the text on attribute 
		    		for(int i=0;i<links;i++) {
		    			String hreflinks=listoflinks.get(i).getAttribute("href");
		    			// find out that href links are empty or null
		    			
		    			if (hreflinks == null || hreflinks.trim().isEmpty()) {
		    			    System.out.println("link is empty");
		    			    continue;
		    			}
		    			// 2. ignore javascript, mailto, tel, #
		    			if (hreflinks.startsWith("javascript")
		    			        || hreflinks.startsWith("mailto")
		    			        || hreflinks.startsWith("tel")
		    			        || hreflinks.equals("#")) {
		    			    System.out.println(hreflinks + " ===> Skipped (not a valid URL)");
		    			    continue;
		    			}
		    			
		    			
		    			
		    			
		    			try {
		    			    URL urllinks = new URL(hreflinks);
		    			    HttpURLConnection httplinks = (HttpURLConnection) urllinks.openConnection();
		    			    httplinks.setConnectTimeout(5000);
		    			    httplinks.connect();
		    			    int respCode = httplinks.getResponseCode();
		    			    if (respCode>=400) {
		    			        System.out.println(hreflinks +" "+ respCode + " ===> Broken link");
		    			        brokenlinks++;
		    			    } else {
		    			        System.out.println(hreflinks +" "+ respCode +" ===> Not a broken link");
		    			    }
		    			} catch (Exception e) {
		    			    System.out.println(hreflinks + " ===> Exception occurred, treated as broken");
		    			    brokenlinks++;
		    			}
		    			
		    	
		
	}
		
	
}
}