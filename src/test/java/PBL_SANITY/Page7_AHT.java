package PBL_SANITY;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Page7_AHT extends PblSanityBase {

    @Test
    public void ahtPage() {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/AHT");

        pauseSeconds(3);
        clickPopulatePending();
        pauseSeconds(7);

        List<WebElement> activities = driver.findElements(By.xpath("(//div[@id='AHTTable'])[1]/table/tbody/tr/td/a"));
        for (WebElement activity : activities) {
            System.out.println("Activities are = " + activity.getText());
            clickElement(activity);
        }

        pauseSeconds(3);
        jsClick(By.id("obs-tab"));
        System.out.println("Clicked on the review button");

        selectAllObservationToggles(By.xpath("//div[@id='Observations']//div[@class='float-end my-2']//input"));

        List<WebElement> accordions = driver.findElements(By.xpath("(//div[@class='accordion mt-3'])[2]/div"));
        for (WebElement accordion : accordions) {
            pauseSeconds(2);
            clickElement(accordion);
        }

        pauseSeconds(3);
        jsClick(By.xpath("//a[@href='/Process/GeolocateTeamSize']"));
    }
}
