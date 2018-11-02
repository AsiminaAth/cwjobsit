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


public class HomePageStepDefinitions {

    private WebDriver browser;
    private PageTools pageTools;
    private BrowserTools browserTools;
    private Home home;

    public HomePageStepDefinitions(BrowserTools browserTools) {
        this.browserTools = browserTools;
    }

    @Before
    public void setup() {
        browser = browserTools.startBrowser(this.getClass());
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
        browserTools.quitBrowser(this.getClass());
    }

    @When("^I click on advertise button$")
    public void iClickOnAdvertiseButton() throws Throwable {
        home.clickOnAdvertiseNowButton();
    }

    @Then("^I click on 'Advertise now' button$")
    public void clickOnAdvertiseNowButton() {
        home.clickOnAdvertiseNowButton();
    }
}