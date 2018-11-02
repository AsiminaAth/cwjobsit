package com.cwjobs.site;

import com.cwjobs.page.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RecruiterPageIT extends AbstractPageIT{
    private JobResults jobResults = new JobResults(browser);
    private RecruiterPage recruiterPage = new RecruiterPage(browser);
    private RecruiterSignInRegisterPage recruiterSignInRegisterPage = new RecruiterSignInRegisterPage(browser);
    private RecruiterBinPage recruiterBinPage = new RecruiterBinPage(browser);
    private RecruiterJobAdBuyPage recruiterJobAdBuyPage = new RecruiterJobAdBuyPage(browser);

    @Test
    public void clickOnRegister_OpensSignInRegisterForm() {
        //given
        home.load();
        home.waitUntilLoaded();
        home.clickOnAdvertiseNowButton();
        recruiterPage.waitUntilLoaded();

        //when
        recruiterPage.clickOnRegisterButton();
        recruiterSignInRegisterPage.waitUntilLoaded();

        //then
        assertTrue(recruiterSignInRegisterPage.isRegisterPanelShown());
        assertTrue(recruiterSignInRegisterPage.isSignInPanelShown());
    }

    @Test
    public void clickOnBuyNowTextLink_goesToRecruiterBinPage() throws InterruptedException {
        //given
        home.load();
        home.waitUntilLoaded();
        home.clickOnAdvertiseNowButton();
        recruiterPage.waitUntilLoaded();

        recruiterPage.clickOnBuyJobAdsButton();
        recruiterJobAdBuyPage.waitUntilLoaded();

        //when
        recruiterJobAdBuyPage.clickOnBuyNowTextLink();

        recruiterBinPage.waitUntilTitleContains("Shopping Basket");
    }
}
