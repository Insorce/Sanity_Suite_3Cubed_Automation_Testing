package PBL_SANITY;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class PblSanityBase {

    protected static final String BASE_URL = "https://prod.3-cubed.com/";
    protected static final String LOGIN_URL = BASE_URL + "Account/LogOn";
    protected static final String WELCOME_URL = BASE_URL + "Projects/Welcome";
    protected static final String USERNAME = "mahesh";
    protected static final String PASSWORD = "Welcome@2026";
    protected static final int DEFAULT_PROJECT_ID = 5600;

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

   @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            logoutFromPbl();
            driver.quit();
        }
    }

    protected void loginToPbl() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(LOGIN_URL);
        pauseSeconds(2);

        if (isAuthenticated()) {
            return;
        }

        submitLogin();
        waitForLoginResult();

        if (isReloginPromptVisible()) {
            WebElement reloginForm = waitUntilVisible(By.id("reloginform"));
            WebElement logoutButton = reloginForm.findElement(By.xpath(".//button[contains(.,'Log Out')]"));
            logoutButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UName")));
            pauseSeconds(2);
            submitLogin();
            waitForLoginResult();
        }

        wait.until(driver -> isAuthenticated());
    }

    protected void submitLogin() {
        WebElement username = waitUntilVisible(By.id("UName"));
        WebElement password = waitUntilVisible(By.id("Password"));

        username.click();
        username.sendKeys(Keys.CONTROL, "a");
        username.sendKeys(Keys.BACK_SPACE);
        username.sendKeys(USERNAME);

        password.click();
        password.sendKeys(Keys.CONTROL, "a");
        password.sendKeys(Keys.BACK_SPACE);
        password.sendKeys(PASSWORD);

        wait.until(ExpectedConditions.elementToBeClickable(By.name("Logon"))).click();
    }

    protected boolean isReloginPromptVisible() {
        return !driver.findElements(By.id("reloginform")).isEmpty()
                && driver.findElement(By.id("reloginform")).isDisplayed();
    }

    protected boolean isAuthenticated() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("/Projects/Welcome")
                || currentUrl.contains("/Projects/DisplayProjects")
                || (!driver.findElements(By.xpath("//a[text()='View Projects']")).isEmpty()
                        && driver.findElement(By.xpath("//a[text()='View Projects']")).isDisplayed());
    }

    protected void logoutFromPbl() {
        try {
            driver.navigate().to(LOGIN_URL);
            pauseSeconds(2);

            if (isReloginPromptVisible()) {
                WebElement reloginForm = waitUntilVisible(By.id("reloginform"));
                WebElement logoutButton = reloginForm.findElement(By.xpath(".//button[contains(.,'Log Out')]"));
                logoutButton.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UName")));
                pauseSeconds(1);
            }
        } catch (Exception e) {
            System.out.println("Logout cleanup skipped: " + e.getMessage());
        }
    }

    protected void waitForLoginResult() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver ->
                isAuthenticated()
                        || isReloginPromptVisible()
                        || (!driver.findElements(By.id("UName")).isEmpty()
                                && driver.findElement(By.id("UName")).isDisplayed())
                        || driver.getCurrentUrl().equals(BASE_URL));
    }

    protected void openDefaultProject() {
        openProject(DEFAULT_PROJECT_ID);
    }

    protected void openProject(int projectId) {
        jsClick(By.xpath("//a[text()='View Projects']"));
        By projectLink = By.xpath("//a[@href='/Projects/Welcome?Pid=" + projectId + "']");
        jsClick(projectLink);
        wait.until(ExpectedConditions.urlContains("Pid=" + projectId));
    }

    protected void openProjectPage(String relativePath) {
        driver.navigate().to(BASE_URL + trimLeadingSlash(relativePath));
    }

    protected void clickPopulatePending() {
        jsClick(By.xpath("//button[text()='Populate Pending']"));
    }

    protected void selectAllObservationToggles(By locator) {
        for (WebElement toggle : driver.findElements(locator)) {
            if (!toggle.isSelected()) {
                clickElement(toggle);
            }
        }
    }

    protected void chooseAutocompleteValue(By locator, String value) {
        WebElement input = waitUntilVisible(locator);
        input.clear();
        input.sendKeys(value);
        pauseSeconds(2);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ENTER);
    }

    protected void clearAndType(By locator, String value) {
        WebElement input = waitUntilVisible(locator);
        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(value);
    }

    protected void type(By locator, String value) {
        waitUntilVisible(locator).sendKeys(value);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void jsClick(By locator) {
        clickElement(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
    }

    protected void clickElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void selectByValue(By locator, String value) {
        new Select(waitUntilVisible(locator)).selectByValue(value);
    }

    protected void selectByVisibleText(By locator, String text) {
        new Select(waitUntilVisible(locator)).selectByVisibleText(text);
    }

    protected void selectByIndex(By locator, int index) {
        new Select(waitUntilVisible(locator)).selectByIndex(index);
    }

    protected void pauseSeconds(long seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting", e);
        }
    }

    private String trimLeadingSlash(String value) {
        return value.startsWith("/") ? value.substring(1) : value;
    }
    
    
    
}
