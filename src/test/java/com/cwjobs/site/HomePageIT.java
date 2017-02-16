package com.cwjobs.site;

import com.cwjobs.page.Home;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by nirvana on 12/11/16.
 */
public class HomePageIT {
    private static WebDriver browser;
    private Home home = new Home(browser);

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver","/home/nirvana/development/selenium/geckodriver");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void openCwjobs_landsHomePage() {
        home.load();
        assertTrue(homePageWasLoaded());
    }

    private boolean homePageWasLoaded() {
        return browser.getPageSource().contains("END APPMEASUREMENT CODE");
    }
//----- isodynamo me :
//    @Test
//    public void openCwjobs_landsHomePage() {
//        browser.navigate().to("http://www.cwjobs.co.uk");
//        assertTrue(browser.getPageSource().contains("END APPMEASUREMENT CODE"));
//    }

    @Test
    public void searchJobs_ReturnsResults() {
        //given
       home.load();

        //when
        browser.findElement(By.id("keywords")).clear();
        browser.findElement(By.id("keywords")).sendKeys("Software Testing");
        browser.findElement(By.id("location")).clear();
        browser.findElement(By.id("location")).sendKeys("London");
        browser.findElement(By.id("search-button")).click();
        waitForLoad();

        //then
        assertNotNull(browser.findElement(By.className("job-results")));
    }

    @Test
    public void clickOnJobTitile_ReturnsJobDetailsPage() {
        //given
        home.load();
        browser.findElement(By.id("keywords")).sendKeys("Software Testing");
        browser.findElement(By.id("location")).clear();
        browser.findElement(By.id("location")).sendKeys("London");
        browser.findElement(By.id("search-button")).click();
        waitForLoad();
        //when
        browser.findElements(By.className("job-title")).get(0).findElements(By.tagName("a")).get(0).click();
        waitForLoad();
        //then
        assertNotNull(browser.findElement(By.className("job-content")));
    }

    @Test
    public void clickOnApply_ReturnsApplyPage() {
        //given

        //go to the home page
        home.load();
        //search for jobs
        browser.findElement(By.id("keywords")).clear();
        browser.findElement(By.id("keywords")).sendKeys("Software Testing");
        browser.findElement(By.id("location")).clear();
        browser.findElement(By.id("location")).sendKeys("London");
        browser.findElement(By.id("search-button")).click();

        //wait until results page is loaded
        //wait until an element of that specific page is loaded
        waitUntilExists(By.className("job-results"));
        //wait until the last block of the page is loaded
        waitUntilExists(By.id("saved-job-toast"));
        //get the id of the first job
        String jobId = browser.findElements(By.className("job")).get(0).getAttribute("id");

        //click on the first job
        browser.findElements(By.className("job-title")).get(0).findElements(By.tagName("a")).get(0).click();

        //wait until the job details page is loaded
        //wait until an element of that specific page is loaded: The element is smth like <input id="jobId" value="67586778" type="hidden">
        waitUntilExists(By.xpath("//input[@id='jobId' and @value='" + jobId + "']")); //e.g. By.xpath("//input[@id='jobId' and @value='67586778']")
        //wait until the last block of the page is loaded
        waitUntilExists(By.id("saved-job-toast"));


        //when
        browser.findElement(By.className("apply-now-btn")).click();
        waitUntil(ExpectedConditions.titleIs("Apply"));

        //then
        //assertTrue("Apply".equals(browser.getTitle()));
        //assertEquals("Apply", browser.getTitle());
    }

    @Test
    public void whenOpenTheJobDetails_clickOnSaveButton_SaveTheJobAndUpdatesInterface() {
        //given

        //go to the home page
        home.load();        //search for jobs
        browser.findElement(By.id("keywords")).clear();
        browser.findElement(By.id("keywords")).sendKeys("Software Testing");
        browser.findElement(By.id("location")).clear();
        browser.findElement(By.id("location")).sendKeys("London");
        browser.findElement(By.id("search-button")).click();

        //wait until results page is loaded
        //wait until an element of that specific page is loaded
        waitUntilExists(By.className("job-results"));
        //wait until the last block of the page is loaded
        waitUntilExists(By.id("saved-job-toast"));
        //get the id of the first job
        String jobId = browser.findElements(By.className("job")).get(0).getAttribute("id");

        //click on the first job
        browser.findElements(By.className("job-title")).get(0).findElements(By.tagName("a")).get(0).click();

        //wait until the job details page is loaded
        //wait until an element of that specific page is loaded: The element is smth like <input id="jobId" value="67586778" type="hidden">
        waitUntilExists(By.xpath("//input[@id='jobId' and @value='" + jobId + "']")); //e.g. By.xpath("//input[@id='jobId' and @value='67586778']")
        //wait until the last block of the page is loaded
        waitUntilExists(By.id("saved-job-toast"));

//        when
        browser.findElement(By.className("btn-savejob")).click();

//        then
        waitUntilVisible(By.id("saved-job-toast"));

    }

    private void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 40);
        wait.until(ExpectedConditions.visibilityOf(browser.findElement(locator)));
    }

    private void waitUntilExists(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 40);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private void waitUntil(ExpectedCondition expectedCondition) {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(expectedCondition);
    }

    private void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        waitUntil(pageLoadCondition);
    }
}
