package stepDefinitions;

import com.cwjobs.page.RecruiterPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RecruiterPageStepDefinitions {
    private WebDriver browser;
    private RecruiterPage recruiterPage;
    private BrowserTools browserTools;

    public RecruiterPageStepDefinitions(BrowserTools browserTools) {
        this.browserTools = browserTools;
    }


    @Before
    public void setup() {
        browser = browserTools.startBrowser(this.getClass());
        recruiterPage = new RecruiterPage(browser);
    }

    @Then("^Goes to recruiter's page$")
    public void userIsInRecruiterPage() {
        recruiterPage.waitUntilLoaded();
        assertTrue(recruiterPage.title().contains("Advertise"));
    }

    @Then("^I click on register button$")
    public void clickOnRegisterButton() {
        recruiterPage.clickOnRegisterButton();
    }


    @Then("^I click on 'BUY JOB ADS'$")
    public void clickOnBuyJobAdsButton() {
        recruiterPage.waitUntilLoaded();
        recruiterPage.clickOnBuyJobAdsButton();
    }
}
