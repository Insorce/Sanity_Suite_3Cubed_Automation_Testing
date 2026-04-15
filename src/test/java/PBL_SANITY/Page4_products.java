package PBL_SANITY;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Page4_products extends PblSanityBase {

    @Test
    public void productsPage() {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/Product");

        pauseSeconds(3);
        clickPopulatePending();
        pauseSeconds(15);
        List<WebElement> list = driver.findElements(
        	    By.xpath("//div[@id='ProdActs']//table/tbody//td[2]/select")
        	);

        	for (WebElement dropdown : list) {
        	    Select select = new Select(dropdown);
        	    select.selectByIndex(2);
        	}
       
        	 pauseSeconds(2);
       
       jsClick(By.xpath("//button[text()='Manage Products']"));
        pauseSeconds(2);
        jsClick(By.xpath("//button[text()='Manage Products']"));
        pauseSeconds(2);
        type(By.id("NewProdName"), "TestProduct1");
        pauseSeconds(2);
        click(By.xpath("//i[@class='fas fa-plus input-group-text']"));
        pauseSeconds(2);
        click(By.xpath("(//div[@class='modal-header'])[11]/button"));
        pauseSeconds(2);

        jsClick(By.id("EditRatio-tab"));
        pauseSeconds(2);
        click(By.id("RpleProds-tab"));
        pauseSeconds(2);
        jsClick(By.id("DelProds-tab"));
        pauseSeconds(2);
        click(By.xpath("(//div[@class='modal-header'])[1]/button"));
        pauseSeconds(2);

        driver.navigate().refresh();
        pauseSeconds(4);

        jsClick(By.id("obs-tab"));
        try {
            click(By.xpath("(//div[@class='modal-header'])[10]/button"));
        } catch (Exception e) {
            System.out.println("Sync/source error " + e.getMessage());
        }
        pauseSeconds(2);

        jsClick(By.xpath("(//button[text()='View'])[1]"));
        pauseSeconds(2);
        click(By.xpath("(//div[@class='d-flex'])[3]/button"));
        pauseSeconds(2);

        jsClick(By.xpath("(//a[text()='Click to View Popup and interaction model'])[1]"));
        pauseSeconds(2);
        click(By.xpath("(//div[@class='modal-header'])[3]/button"));

        selectAllObservationToggles(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));
        pauseSeconds(5);
        JavascriptExecutor rework = (JavascriptExecutor) driver;
        rework.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//div[@class='tab-pane fade active show']//a)[1]")));
       
        jsClick(By.xpath("(//div[@class='tab-pane fade active show']//a)[1]"));
        pauseSeconds(2);
        jsClick(By.xpath("//button[text()='No']"));
        pauseSeconds(3);

        System.out.println(driver.getTitle());
    }
}