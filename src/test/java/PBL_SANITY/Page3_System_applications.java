package PBL_SANITY;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Page3_System_applications extends PblSanityBase {

    @Test
    public void systemAndApplications() {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/SystemsandApplications");

        pauseSeconds(3);
        clickPopulatePending();
        pauseSeconds(30);

        jsClick(By.xpath("//button[text()='Manage Systems & Applications']"));
        pauseSeconds(2);

        type(By.id("NewDOEName"), "Test1");
        pauseSeconds(2);
        click(By.xpath("//i[@class='fas fa-plus input-group-text']"));
        pauseSeconds(2);
        click(By.xpath("((//div[@class='modal-content'])[10]/div/button)[1]"));
        pauseSeconds(2);
        click(By.id("RpleForms-tab"));
        pauseSeconds(2);
        jsClick(By.xpath("//a[text()='Delete from Activity(s)']"));
        pauseSeconds(2);
        driver.navigate().refresh();
        pauseSeconds(4);

        jsClick(By.xpath("//a[@href='#Review']"));
        pauseSeconds(10);
        jsClick(By.xpath("(//div[@class='modal-content'])[7]/div/div/button"));
        pauseSeconds(3);
        jsClick(By.xpath("(//a[text()='Click to View Popup and interaction model'])[1]"));
        pauseSeconds(3);
        jsClick(By.xpath("((//div[@class='modal-content'])[2]/div/button)[1]"));
        pauseSeconds(3);
        click(By.xpath("//a[@href='/Process/Product']"));
        pauseSeconds(15);

        System.out.println(driver.getTitle());
    }
}
