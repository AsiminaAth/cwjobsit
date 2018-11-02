package stepDefinitions;

import com.cwjobs.page.RecruiterSignInRegisterPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class AdvertiserPageStepDefinitions {
    private WebDriver browser;
    private RecruiterSignInRegisterPage recruiterSignInRegisterPage;
    private BrowserTools browserTools;

    public AdvertiserPageStepDefinitions(BrowserTools browserTools) {
        this.browserTools = browserTools;
    }


    @Before
    public void setup() {
        browser = browserTools.startBrowser(this.getClass());
        recruiterSignInRegisterPage = new RecruiterSignInRegisterPage(browser);
    }

    @Then("^Goes to Advertise page$")
    public void userIsInAdvertisePage() {
        recruiterSignInRegisterPage.waitUntilLoaded();
    }

    @Then("^Register panel is shown$")
    public void registerPanelIsShown() {
        assertTrue(recruiterSignInRegisterPage.isRegisterPanelShown());
    }

    @Then("^Sign in panel is shown$")
    public void singInPanelIsShown() {
        assertTrue(recruiterSignInRegisterPage.isSignInPanelShown());
    }
}
