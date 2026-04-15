package PBL_SANITY;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Validation_Products_PBL extends PblSanityBase {

    @Test
    public void validateProductCrud() {
        loginToPbl();
        openDefaultProject();
        openProjectPage("Process/Product");

        pauseSeconds(3);
        clickPopulatePending();
        pauseSeconds(30);

        String activityName = addProductAndAssociateActivity();
        editProductRatio("TestProduct1", "2");
        replaceProductAssociation();
        deleteProductAssociation();

        driver.navigate().refresh();
        pauseSeconds(2);
        clickPopulatePending();
        pauseSeconds(30);
        System.out.println("Last validated activity = " + activityName);
        System.out.println(driver.getTitle());
    }

    private String addProductAndAssociateActivity() {
        jsClick(By.xpath("//button[text()='Manage Products']"));
        pauseSeconds(2);
        type(By.id("NewProdName"), "TestProduct1");
        pauseSeconds(2);
        click(By.xpath("//i[@class='fas fa-plus input-group-text']"));
        pauseSeconds(2);
        click(By.xpath("//div[@class='modal-body']//a[@href='javascript:void(0)']"));
        pauseSeconds(4);
        confirmIfPresent();
        pauseSeconds(3);

        String activityName = searchAndSelectFirstProductActivity();
        pauseSeconds(2);
        jsClick(By.xpath("//button[text()='Add/Associate']"));
        pauseSeconds(2);
        driver.navigate().refresh();
        pauseSeconds(2);

        verifyActivityPresent(activityName);
        verifyProductPresent("testproduct1");
        return activityName;
    }

    private void editProductRatio(String productName, String value) {
        pauseSeconds(3);
        jsClick(By.xpath("//button[text()='Manage Products']"));
        pauseSeconds(2);
        jsClick(By.id("EditRatio-tab"));

        List<WebElement> products = driver.findElements(
                By.xpath("(//table[@class='table table-hover table-condensed table-bordered'])[2]/tbody//tr/td[1]"));

        for (int i = 0; i < products.size(); i++) {
            if (!productName.equals(products.get(i).getText())) {
                continue;
            }

            click(By.xpath("(//table[@class='table table-hover table-condensed table-bordered'])[2]/tbody//tr[" + (i + 1)
                    + "]/td[4]/a"));
            pauseSeconds(2);

            WebElement ratioInput = waitUntilVisible(By.xpath("(//input[@id='nooftimes'])[2]"));
            Actions actions = new Actions(driver);
            actions.doubleClick(ratioInput).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                    .sendKeys(value).perform();

            pauseSeconds(2);
            click(By.xpath("//button[text()='OK']"));
            pauseSeconds(2);
            jsClick(By.xpath("(//div[@class='modal-header'])[1]/button"));
            pauseSeconds(2);
            System.out.println("Product ratio is updated successfully for = " + productName);
            return;
        }
    }

    private void replaceProductAssociation() {
        driver.navigate().refresh();
        pauseSeconds(3);
        jsClick(By.xpath("//button[text()='Manage Products']"));
        pauseSeconds(2);
        click(By.id("RpleProds-tab"));
        pauseSeconds(2);

        selectByVisibleText(By.xpath("(//select[@class='form-select enableforall'])[1]"), "TestProduct1");
        pauseSeconds(2);
        selectByIndex(By.id("ProdChgDropDown"), 2);
        pauseSeconds(2);

        searchAndSelectFirstProductActivity();
        System.out.println("Product is selected for replacement");
        pauseSeconds(2);

        jsClick(By.xpath("//button[text()=' Replace']"));
        pauseSeconds(2);
        confirmIfPresent();
        driver.navigate().refresh();
        pauseSeconds(2);
    }

    private void deleteProductAssociation() {
        pauseSeconds(3);
        jsClick(By.xpath("//button[text()='Manage Products']"));
        pauseSeconds(2);
        jsClick(By.id("DelProds-tab"));
        pauseSeconds(2);

        selectByIndex(By.xpath("(//select[@class='form-select enableforall'])[2]"), 2);
        pauseSeconds(2);

        searchAndSelectFirstProductActivity();
        System.out.println("Activity selected for deletion");
        pauseSeconds(2);

        jsClick(By.xpath("//button[text()=' Delete']"));
        pauseSeconds(2);
        confirmIfPresent();
    }

    private String searchAndSelectFirstProductActivity() {
        type(By.id("ActivitySearchText"), "s");
        pauseSeconds(2);
        click(By.xpath("//a[text()='Search']"));
        pauseSeconds(3);
        jsClick(By.xpath("//div[@id='SearchResults']//table/tbody[2]/tr[1]/td[1]/input[@type='checkbox']"));
        WebElement activity = waitUntilVisible(By.xpath("//div[@id='SearchResults']//table/tbody[2]/tr[1]/td[3]/a"));
        return activity.getText();
    }

    private void verifyActivityPresent(String activityName) {
        List<WebElement> activities = driver.findElements(By.xpath("//div[@id='doeActs']/div/table/tbody/tr/td/a"));
        for (WebElement activity : activities) {
            if (activityName.equals(activity.getText())) {
                System.out.println("Product is added successfully for activity = " + activityName);
                return;
            }
        }
    }

    private void verifyProductPresent(String productName) {
        for (WebElement product : driver.findElements(By.xpath("//div[@id='doeActs']/div/table/tbody/tr/td//li/span"))) {
            if (productName.equals(product.getText())) {
                System.out.println("Product is added successfully = " + productName);
                return;
            }
        }
    }

    private void confirmIfPresent() {
        List<WebElement> buttons = driver.findElements(By.id("alertify-ok"));
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
            pauseSeconds(3);
        }
    }
}
