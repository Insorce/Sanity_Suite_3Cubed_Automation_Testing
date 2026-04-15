package PBL_SANITY;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Validation_System_and_application extends PblSanityBase {

    @Test
    public void validateSystemAndApplicationCrud() {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/SystemsandApplications");

        pauseSeconds(3);
        addSystemAndAssociateActivity();
        replaceSystemAssociation();
        deleteSystemAssociation();

        jsClick(By.xpath("//button[text()='Populate Pending']"));
        pauseSeconds(60);
    }

    private void addSystemAndAssociateActivity() {
        jsClick(By.xpath("//button[text()='Manage Systems & Applications']"));
        pauseSeconds(2);
        type(By.id("NewDOEName"), "Test1");
        pauseSeconds(2);
        click(By.xpath("//i[@class='fas fa-plus input-group-text']"));
        pauseSeconds(2);
        click(By.xpath("//div[@class='modal-body']//a[@href='javascript:void(0)']"));
        pauseSeconds(2);

        searchAndSelectFirstActivity();
        WebElement activity = waitUntilVisible(By.xpath("(//div[@id='SearchResults']/table/tbody[2]/tr/td[3])[1]/a"));
        String activityName = activity.getText();

        pauseSeconds(2);
        jsClick(By.xpath("//button[text()='Add/Associate']"));
        pauseSeconds(2);
        driver.navigate().refresh();
        pauseSeconds(2);

        verifyActivityPresent(activityName);
        verifySystemPresent("test1");
    }

    private void replaceSystemAssociation() {
        pauseSeconds(3);
        jsClick(By.xpath("//button[text()='Manage Systems & Applications']"));
        pauseSeconds(2);
        click(By.id("RpleForms-tab"));
        pauseSeconds(2);

        selectByVisibleText(By.xpath("(//select[@id='search-doe'])[1]"), "test1");
        pauseSeconds(2);
        jsClick(By.xpath("(//div[@class='ms-trigger-ico'])[2]"));
        pauseSeconds(2);
        jsClick(By.xpath("//div[@class='ms-res-ctn dropdown-menu']/div[3]"));
        pauseSeconds(2);

        searchAndSelectFirstActivity();
        System.out.println("Activity is selected for replacement");
        pauseSeconds(2);

        jsClick(By.xpath("//button[text()=' Replace']"));
        pauseSeconds(2);
        click(By.id("alertify-ok"));
        pauseSeconds(3);
        driver.navigate().refresh();
        pauseSeconds(2);
    }

    private void deleteSystemAssociation() {
        pauseSeconds(3);
        jsClick(By.xpath("//button[text()='Manage Systems & Applications']"));
        pauseSeconds(2);
        jsClick(By.xpath("//a[text()='Delete from Activity(s)']"));
        pauseSeconds(2);

        List<WebElement> options = driver.findElements(
                By.xpath("//div[@id='CommonDivSearch']/div[2]/div[2]/select/option"));
        options.get(options.size() - 3).click();

        pauseSeconds(2);
        searchAndSelectFirstActivity();
        System.out.println("Attribute selected for deletion");
        pauseSeconds(2);

        jsClick(By.xpath("//button[text()=' Delete']"));
        pauseSeconds(2);
        click(By.id("alertify-ok"));
        driver.navigate().refresh();
        pauseSeconds(2);
    }

    private void searchAndSelectFirstActivity() {
        type(By.id("ActivitySearchText"), "s");
        pauseSeconds(2);
        click(By.xpath("//a[text()='Search']"));
        pauseSeconds(2);
        jsClick(By.xpath("(//div[@id='SearchResults']/table/tbody[2]/tr//td[1])[1]/input"));
    }

    private void verifyActivityPresent(String activityName) {
        List<WebElement> activities = driver.findElements(By.xpath("//div[@id='doeActs']/div/table/tbody/tr/td/a"));
        for (WebElement activity : activities) {
            if (activityName.equals(activity.getText())) {
                System.out.println("Activity is added successfully = " + activityName);
                return;
            }
        }
    }

    private void verifySystemPresent(String systemName) {
        for (WebElement system : driver.findElements(By.xpath("//div[@id='doeActs']/div/table/tbody/tr/td//li/span"))) {
            if (systemName.equals(system.getText())) {
                System.out.println("System is added successfully = " + systemName);
                return;
            }
        }
    }
}
