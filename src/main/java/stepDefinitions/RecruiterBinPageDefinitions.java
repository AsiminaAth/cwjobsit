package stepDefinitions;

import com.cwjobs.page.RecruiterBinPage;
import com.cwjobs.page.RecruiterPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RecruiterBinPageDefinitions {
    private WebDriver browser;
    private RecruiterBinPage recruiterBinPage;
    private BrowserTools browserTools;

    public RecruiterBinPageDefinitions(BrowserTools browserTools) {
        this.browserTools = browserTools;
    }


    @Before
    public void setup() {
        browser = browserTools.startBrowser(this.getClass());
        recruiterBinPage = new RecruiterBinPage(browser);
    }

    @Then("^Page title contains \"(.*)\"$")
    public void pageTitleContains(String pageTitle) {
        recruiterBinPage.waitUntilTitleContains(pageTitle);
    }

}
