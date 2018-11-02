package stepDefinitions;

import com.cwjobs.page.RecruiterJobAdBuyPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class RecruiterJobAdBuyPageDefinitions {
    private WebDriver browser;
    private RecruiterJobAdBuyPage recruiterJobAdBuyPage;
    private BrowserTools browserTools;

    public RecruiterJobAdBuyPageDefinitions(BrowserTools browserTools) {
        this.browserTools = browserTools;
    }


    @Before
    public void setup() {
        browser = browserTools.startBrowser(this.getClass());
        recruiterJobAdBuyPage = new RecruiterJobAdBuyPage(browser);
    }


    @Then("^I click on 'BUY NOW'$")
    public void clickOnBuyNowButton() {
        recruiterJobAdBuyPage.waitUntilLoaded();
        recruiterJobAdBuyPage.clickOnBuyNowTextLink();
    }

}
