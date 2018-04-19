package stepDefinitions;

import com.cwjobs.page.JobResults;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertNotNull;

public class JobResultsStepDefinitions {

    private final BrowserTools browserTools;
    private WebDriver browser;
    private JobResults jobResults;

    public JobResultsStepDefinitions(BrowserTools browserTools) {
        this.browserTools = browserTools;
    }

    @Before
    public void setup() {
        browser = browserTools.startBrowser(this.getClass());

        jobResults = new JobResults(browser);
    }

    @Then("^I get job results$")
    public void returnJobResults() {
        jobResults.waitUntilLoaded();
        assertNotNull(jobResults.getJobResults());
    }

    @After
    public void tearDown() {
        browserTools.quitBrowser(this.getClass());
    }
}