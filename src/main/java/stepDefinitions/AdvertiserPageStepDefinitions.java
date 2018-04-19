package stepDefinitions;

import com.cwjobs.page.RecruiterAdvertisePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class AdvertiserPageStepDefinitions {
    private WebDriver browser;
    private RecruiterAdvertisePage recruiterAdvertisePage;
    private BrowserTools browserTools;

    public AdvertiserPageStepDefinitions(BrowserTools browserTools) {
        this.browserTools = browserTools;
    }


    @Before
    public void setup() {
        browser = browserTools.startBrowser(this.getClass());
        recruiterAdvertisePage = new RecruiterAdvertisePage(browser);
    }

    @Then("^Goes to Advertise page$")
    public void userIsInAdvertisePage() {
        recruiterAdvertisePage.waitUntilLoaded();
    }

    @Then("^Register panel is shown$")
    public void registerPanelIsShown() {
        assertTrue(recruiterAdvertisePage.isRegisterPanelShown());
    }
}
