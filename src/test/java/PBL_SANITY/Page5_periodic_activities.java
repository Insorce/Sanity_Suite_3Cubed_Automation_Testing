package PBL_SANITY;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Page5_periodic_activities extends PblSanityBase {

    @Test
    public void periodicActivitiesPage() {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/PeriodicActivities");

        pauseSeconds(5);
        jsClick(By.id("obs-tab"));
        pauseSeconds(3);
        jsClick(By.xpath("(//button[text()='Periodic Activities View'])[2]"));
        pauseSeconds(2);

        driver.switchTo().frame(waitUntilVisible(By.id("IframeAdditionalInfo")));
        pauseSeconds(2);
        click(By.xpath("(//a[text()='Click here to view non-daily activities'])[1]"));
        pauseSeconds(3);
        jsClick(By.xpath("(//div[@id='DetailsModal']/div/div/div/button)[1]"));
        pauseSeconds(2);

        driver.switchTo().defaultContent();
        pauseSeconds(2);
        jsClick(By.xpath("//div[@id='IframeDialog']/div/div/div/button"));
        pauseSeconds(2);

        jsClick(By.xpath("//a[text()='AI']"));
        pauseSeconds(2);
        jsClick(By.xpath("//a[@href='#Review']"));
        pauseSeconds(2);
        jsClick(By.xpath("//a[@href='/Process/Volume']"));

        System.out.println(driver.getTitle());
    }
}
