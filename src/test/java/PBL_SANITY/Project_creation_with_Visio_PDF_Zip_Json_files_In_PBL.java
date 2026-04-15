package PBL_SANITY;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;



public class Project_creation_with_Visio_PDF_Zip_Json_files_In_PBL extends PblSanityBase 
{

	@Test
	public void insorce() throws InterruptedException, AWTException
	{
		String uuid=UUID.randomUUID().toString();
		
		  loginToPbl();
		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);
      
		//create project
		driver.findElement(By.cssSelector("div.float-end.my-1")).click();
		//enter project name
		driver.findElement(By.xpath("//input[@name='Project Name']")).sendKeys("ZIP_FILE_UPLOAD_AUTOMATION TESTING" +uuid);
		//enter project description
		driver.findElement(By.xpath("//textarea[@id='projectDescription']")).sendKeys("INSORCE " +uuid);
		//Selecting the  project timezone
		Select object1=new Select(driver.findElement(By.name("Project TimeZone")));
		object1.selectByValue("Dateline Standard Time");
		//Selecting project Currency
		Select object2=new Select(driver.findElement(By.name("Project Currency")));
		object2.selectByValue("ARS");


		//enter the industry
		WebElement Insorce=	driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Insorce);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']")).sendKeys("Banking");
		Actions krishna=new Actions(driver);
		krishna.sendKeys(Keys.ARROW_DOWN).build().perform();
		krishna.sendKeys(Keys.ARROW_DOWN).build().perform();
		krishna.sendKeys(Keys.ENTER).build().perform();



		//click on create a project
		WebElement we=	driver.findElement(By.xpath("//button[text()='Create Project']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", we);

		//click on get started
		Thread.sleep(3000);
		driver.findElement(By.id("getStarted")).click();

		
		//------- Upload the Zip file -------------//
		
		
		//click on the zip file
		driver.findElement(By.xpath("//img[@src='/Images/import.svg']")).click();

		//click on the choose file
		WebElement insorce9=driver.findElement(By.xpath("//input[@id='BulkUploadFile']"));
		JavascriptExecutor object = (JavascriptExecutor) driver;
		object.executeScript("arguments[0].click();", insorce9);
         
		
		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys(System.getProperty("user.dir")+"/InputProcessmaps/5381-Conformed_settiled_1760PID_4784_V11 (2).zip");
		
	
	      
	       // crate the robot class 
	        Robot rb= new Robot();
	        
	        rb.delay(5000);
	        // Identify the file path and select the file path 
	       // StringSelection ss= new StringSelection("D:\\\\INPUT\\\\4315-AUTOMATION__MORTGAGE__PROJECT88.zip");
	       // StringSelection ss= new StringSelection(System.getProperty("user.dir")+"/InputProcessmaps/5381-Conformed_settiled_1760PID_4784_V11 (2).zip");

	        // copy the selected file path into clip board
	       // Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	        
	        // past the copied file path at File name text box 
	        
	        rb.keyPress(KeyEvent.VK_CONTROL);
	        rb.keyPress(KeyEvent.VK_V);
	        rb.keyRelease(KeyEvent.VK_V);
	        rb.keyRelease(KeyEvent.VK_CONTROL);
	        
	        // click on enter button 
	        
	        rb.keyPress(KeyEvent.VK_CANCEL);
	        rb.keyRelease(KeyEvent.VK_CANCEL);
	        
	 


		//click on the upload
		WebElement upload=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
		JavascriptExecutor upload_click = (JavascriptExecutor) driver;
		upload_click.executeScript("arguments[0].click();", upload);
		
		//click on next
		Thread.sleep(2000);
		WebElement click_next= driver.findElement(By.xpath("//button[text()='Next']"));
		JavascriptExecutor next_click = (JavascriptExecutor) driver;
		next_click.executeScript("arguments[0].click();", click_next); 
		
		Thread.sleep(9000);
		System.out.println("===============================================================================================");
     System.out.print("===");
		System.out.println("Zip file uploaded successfully");
       System.out.println(driver.getCurrentUrl());
       System.out.println(driver.getTitle());
       Thread.sleep(9000);
       System.out.println("===============================================================================================");
       System.out.print("===");
       //------- Upload the VISIO file -------------//

		driver.navigate().to("https://pbl.3-cubed.com/Process/CreateProject");
		//create project
				//driver.findElement(By.cssSelector("div.float-end.my-1")).click();
				//enter project name
				driver.findElement(By.xpath("//input[@name='Project Name']")).sendKeys("VISIO UPLOAD_AUTOMATION TESTING " +uuid);
				//enter project description
				driver.findElement(By.xpath("//textarea[@id='projectDescription']")).sendKeys("INSORCE " +uuid);
				//Selecting the  project timezone
				Select object3=new Select(driver.findElement(By.name("Project TimeZone")));
				object3.selectByValue("Dateline Standard Time");
				//Selecting project Currency
				Select object4=new Select(driver.findElement(By.name("Project Currency")));
				object4.selectByValue("ARS");


				//enter the industry
				WebElement Insorce1=	driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']"));
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].click();", Insorce1);

				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']")).sendKeys("Banking");
				Actions krishna1=new Actions(driver);
				krishna1.sendKeys(Keys.ARROW_DOWN).build().perform();
				krishna1.sendKeys(Keys.ARROW_DOWN).build().perform();
				krishna1.sendKeys(Keys.ENTER).build().perform();



				//click on create a project
				WebElement we1=	driver.findElement(By.xpath("//button[text()='Create Project']"));
				JavascriptExecutor js4 = (JavascriptExecutor) driver;
				js4.executeScript("arguments[0].click();", we1);

				//click on get started
				Thread.sleep(3000);
				driver.findElement(By.id("getStarted")).click();
				
				//click on the Visio file
				driver.findElement(By.xpath("//img[@src='/Images/MSVisio.svg']")).click();
				

				//click on the choose file
				WebElement insorce8=driver.findElement(By.xpath("//input[@id='BulkUploadFile']"));
				JavascriptExecutor object6 = (JavascriptExecutor) driver;
				object6.executeScript("arguments[0].click();", insorce8);
		         
				
			driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys(System.getProperty("user.dir")+"/InputProcessmaps/Mahesh_Hyundai.vsdx");
				
				//driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\Insorce_3Cubed\\Automation_3_Cubed\\InputProcessmaps\\Mahesh_Hyundai.vsdx");
			       // crate the robot class 
			        Robot rbe= new Robot();
			        
			        rbe.delay(5000);
			        // Identify the file path and select the file path 
			       // StringSelection ss= new StringSelection("D:\\\\INPUT\\\\4315-AUTOMATION__MORTGAGE__PROJECT88.zip");
			      //  StringSelection ss1= new StringSelection(System.getProperty("user.dir")+"/InputProcessmaps/BrandNewTriples.vsdx");

			        // copy the selected file path into clip board
			      //  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
			        
			        // past the copied file path at File name text box 
			        
			        rbe.keyPress(KeyEvent.VK_CONTROL);
			        rbe.keyPress(KeyEvent.VK_V);
			        rbe.keyRelease(KeyEvent.VK_V);
			        rbe.keyRelease(KeyEvent.VK_CONTROL);
			        
			        // click on enter button 
			        
			        rb.keyPress(KeyEvent.VK_CANCEL);
			        rb.keyRelease(KeyEvent.VK_CANCEL);
			        			 
			     // click on upload 
			        Thread.sleep(5000);
					WebElement click_upload= driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
					JavascriptExecutor next_upload = (JavascriptExecutor) driver;
					next_upload.executeScript("arguments[0].click();", click_upload); 
				
				//click on next
					
					Wait<WebDriver> wait = new FluentWait<>(driver)
			                .withTimeout(Duration.ofSeconds(300))     // Total wait time
			                .pollingEvery(Duration.ofSeconds(60))     // Interval
			                .ignoring(ElementNotInteractableException.class);

			        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']")));
			        		//until(driver1 -> 
			               // driver1.findElement(By.xpath("//button[text()='Next']")));
			        
			        nextButton.click();
					
					
			        
			        
				//click on next
//				Thread.sleep(2000);
//				WebElement click_next1= driver.findElement(By.xpath("//button[text()='Next']"));
//				JavascriptExecutor next_click1 = (JavascriptExecutor) driver;
//				next_click1.executeScript("arguments[0].click();", click_next1); 
				
				Thread.sleep(4000);
				//click on proceed 
				
				//(//button[text()='Proceed'])[1]
				WebElement Proceed= driver.findElement(By.xpath("(//button[text()='Proceed'])[1]"));
				JavascriptExecutor Proceed1 = (JavascriptExecutor) driver;
				Proceed1.executeScript("arguments[0].click();", Proceed);	
				Thread.sleep(10000);
				System.out.println("===============================================================================================");
			     System.out.print("===");
			       System.out.println("VISIO file uploaded successfully");
			       System.out.println(driver.getCurrentUrl());
			       System.out.println(driver.getTitle());
			       Thread.sleep(9000);
			       System.out.println("===============================================================================================");
			       System.out.print("===");

			       
			     //------- Upload the PDF file -------------//

					driver.navigate().to("https://pbl.3-cubed.com/Process/CreateProject");
					//create project
							//driver.findElement(By.cssSelector("div.float-end.my-1")).click();
							//enter project name
							driver.findElement(By.xpath("//input[@name='Project Name']")).sendKeys("PDF UPLOAD_AUTOMATION TESTING " +uuid);
							//enter project description
							driver.findElement(By.xpath("//textarea[@id='projectDescription']")).sendKeys("INSORCE " +uuid);
							//Selecting the  project timezone
							Select object5=new Select(driver.findElement(By.name("Project TimeZone")));
							object5.selectByValue("Dateline Standard Time");
							//Selecting project Currency
							Select object7=new Select(driver.findElement(By.name("Project Currency")));
							object7.selectByValue("ARS");


							//enter the industry
							WebElement Insorce3=	driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']"));
							JavascriptExecutor js3 = (JavascriptExecutor) driver;
							js3.executeScript("arguments[0].click();", Insorce3);

							Thread.sleep(3000);
							driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']")).sendKeys("Banking");
							Actions krishna2=new Actions(driver);
							krishna2.sendKeys(Keys.ARROW_DOWN).build().perform();
							krishna2.sendKeys(Keys.ARROW_DOWN).build().perform();
							krishna2.sendKeys(Keys.ENTER).build().perform();



							//click on create a project
							WebElement we2=	driver.findElement(By.xpath("//button[text()='Create Project']"));
							JavascriptExecutor js5 = (JavascriptExecutor) driver;
							js5.executeScript("arguments[0].click();", we2);

							//click on get started
							Thread.sleep(3000);
							driver.findElement(By.id("getStarted")).click();
							
							//click on the PDF file
							driver.findElement(By.xpath("//img[@src='/Images/pdf.png']")).click();
							

							//click on the choose file
							WebElement insorcej=driver.findElement(By.xpath("//input[@id='BulkUploadFile']"));
							JavascriptExecutor objectj = (JavascriptExecutor) driver;
							objectj.executeScript("arguments[0].click();", insorcej);
					         
							
						driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys(System.getProperty("user.dir")+"/InputProcessmaps/Brandnewtriple.pdf");
							
							//driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\Insorce_3Cubed\\Automation_3_Cubed\\InputProcessmaps\\Brandnewtriple.pdf");
						       // crate the robot class 
						        Robot rb1= new Robot();
						        
						        rb1.delay(5000);
						        // Identify the file path and select the file path 
						       // StringSelection ss= new StringSelection("D:\\\\INPUT\\\\4315-AUTOMATION__MORTGAGE__PROJECT88.zip");
						      //  StringSelection ss1= new StringSelection(System.getProperty("user.dir")+"/InputProcessmaps/BrandNewTriples.vsdx");

						        // copy the selected file path into clip board
						      //  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
						        
						        // past the copied file path at File name text box 
						        
						        rb1.keyPress(KeyEvent.VK_CONTROL);
						        rb1.keyPress(KeyEvent.VK_V);
						        rb1.keyRelease(KeyEvent.VK_V);
						        rb1.keyRelease(KeyEvent.VK_CONTROL);
						        
						        // click on enter button 
						        
						        rb1.keyPress(KeyEvent.VK_CANCEL);
						        rb1.keyRelease(KeyEvent.VK_CANCEL);
						     // click on upload 
						        Thread.sleep(5000);
								WebElement click_pdfupload= driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
								JavascriptExecutor next_pdfupload = (JavascriptExecutor) driver;
								next_pdfupload.executeScript("arguments[0].click();", click_pdfupload); 
							
							//click on next
								
								Wait<WebDriver> wait2 = new FluentWait<>(driver)
						                .withTimeout(Duration.ofSeconds(300))     // Total wait time
						                .pollingEvery(Duration.ofSeconds(60))     // Interval
						                .ignoring(ElementNotInteractableException.class);

						        WebElement nextButton2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']")));
						        		//until(driver1 -> 
						               // driver1.findElement(By.xpath("//button[text()='Next']")));
						        
						        nextButton2.click();
														
															
							Thread.sleep(9000);
							//click on proceed 
							
							//(//button[text()='Proceed'])[1]
							WebElement Proceed2= driver.findElement(By.xpath("(//button[text()='Proceed'])[1]"));
							JavascriptExecutor Proceed3 = (JavascriptExecutor) driver;
							Proceed3.executeScript("arguments[0].click();", Proceed2);	
							Thread.sleep(10000);
							System.out.println("===============================================================================================");
						     System.out.print("===");
						       System.out.println("PDF file uploaded successfully");
						       System.out.println(driver.getCurrentUrl());
						       System.out.println(driver.getTitle());
						       System.out.println("===============================================================================================");
						       System.out.print("===");
						       Thread.sleep(9000);
			 
			       
			       
						       //------- Upload the JSON file -------------//

								driver.navigate().to("https://pbl.3-cubed.com/Process/CreateProject");
								//create project
										//driver.findElement(By.cssSelector("div.float-end.my-1")).click();
										//enter project name
										driver.findElement(By.xpath("//input[@name='Project Name']")).sendKeys("JSON_FILE UPLOAD_AUTOMATION TESTING " +uuid);
										//enter project description
										driver.findElement(By.xpath("//textarea[@id='projectDescription']")).sendKeys("INSORCE " +uuid);
										//Selecting the  project timezone
										Select objecta=new Select(driver.findElement(By.name("Project TimeZone")));
										objecta.selectByValue("Dateline Standard Time");
										//Selecting project Currency
										Select objectb=new Select(driver.findElement(By.name("Project Currency")));
										objectb.selectByValue("ARS");


										//enter the industry
										WebElement Insorce6=	driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']"));
										JavascriptExecutor js6 = (JavascriptExecutor) driver;
										js6.executeScript("arguments[0].click();", Insorce6);

										Thread.sleep(3000);
										driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']")).sendKeys("Banking");
										Actions krishna3=new Actions(driver);
										krishna3.sendKeys(Keys.ARROW_DOWN).build().perform();
										krishna3.sendKeys(Keys.ARROW_DOWN).build().perform();
										krishna3.sendKeys(Keys.ENTER).build().perform();



										//click on create a project
										WebElement we4=	driver.findElement(By.xpath("//button[text()='Create Project']"));
										JavascriptExecutor js7 = (JavascriptExecutor) driver;
										js7.executeScript("arguments[0].click();", we4);

										//click on get started
										Thread.sleep(3000);
										driver.findElement(By.id("getStarted")).click();
										
										//click on the PDF file
										driver.findElement(By.xpath("//img[@src='/Images/JSON.svg']")).click();
										

										//click on the choose file
										WebElement insorcet=driver.findElement(By.xpath("//input[@id='BulkUploadFile']"));
										JavascriptExecutor objectt1 = (JavascriptExecutor) driver;
										objectt1.executeScript("arguments[0].click();", insorcet);
								         
										
									driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys(System.getProperty("user.dir")+"/InputProcessmaps/1243_Json.json");
										
										//driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\Insorce_3Cubed\\Automation_3_Cubed\\InputProcessmaps\\Brandnewtriple.pdf");
									       // crate the robot class 
									        Robot rbt= new Robot();
									        
									        rbt.delay(5000);
									        // Identify the file path and select the file path 
									       // StringSelection ss= new StringSelection("D:\\\\INPUT\\\\4315-AUTOMATION__MORTGAGE__PROJECT88.zip");
									      //  StringSelection ss1= new StringSelection(System.getProperty("user.dir")+"/InputProcessmaps/BrandNewTriples.vsdx");

									        // copy the selected file path into clip board
									      //  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
									        
									        // past the copied file path at File name text box 
									        
									        rbt.keyPress(KeyEvent.VK_CONTROL);
									        rbt.keyPress(KeyEvent.VK_V);
									        rbt.keyRelease(KeyEvent.VK_V);
									        rbt.keyRelease(KeyEvent.VK_CONTROL);
									        
									        // click on enter button 
									        
									        rbt.keyPress(KeyEvent.VK_CANCEL);
									        rbt.keyRelease(KeyEvent.VK_CANCEL);
									     // click on upload 
									        Thread.sleep(5000);
											WebElement click_jsonupload= driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
											JavascriptExecutor next_jsonupload = (JavascriptExecutor) driver;
											next_jsonupload.executeScript("arguments[0].click();", click_jsonupload); 
										
										
										Thread.sleep(Duration.ofSeconds(90).toMillis());
										System.out.println("===============================================================================================");
									     System.out.print("===");
									       System.out.println("JSON file uploaded successfully");
									       System.out.println(driver.getCurrentUrl());
									       System.out.println(driver.getTitle());
									       System.out.println("===============================================================================================");
									       System.out.print("===");
									       Thread.sleep(9000);
						   
			       
			       
			       
			       
			       
			       
	}

}
