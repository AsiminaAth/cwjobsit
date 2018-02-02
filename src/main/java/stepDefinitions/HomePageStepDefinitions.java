package stepDefinitions;

import com.cwjobs.page.Home;
import com.cwjobs.page.tools.PageTools;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePageStepDefinitions {

    private WebDriver browser;
    private PageTools pageTools;
    private Home home;

    @Before
    public void setup() {
        browser = BrowserTools.startBrowser(this.getClass());

        home = new Home(browser);
        pageTools = new PageTools(browser);
    }

    @Given("^Home page is loaded$")
    public void loadHomePage() {
        home.load();
        home.waitUntilLoaded();
    }

    @When("^I click on recruiting$")
    public void clickOnRecruiting() {
        home.clickOnRecruiting();
    }

    @Then("^Unfolds recruiters panel$")
    public void unfoldsRecruitersPanel() {
        pageTools.waitUntilExists(By.className("recruiter-open"));
    }

    @When("^I search for job$")
    public void searchForJob() {
        home.searchJob("Software Testing", "London");
    }

    @After
    public void tearDown() {
        BrowserTools.quitBrowser(this.getClass());
    }
}