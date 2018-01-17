package com.cwjobs.site;

import com.cwjobs.page.JobResults;
import com.cwjobs.page.RecruiterPage;
import com.cwjobs.page.RecruiterAdvertisePage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RecruiterPageIT extends AbstractPageIT{
    private JobResults jobResults = new JobResults(browser);
    private RecruiterPage recruiterPage = new RecruiterPage(browser);
    private RecruiterAdvertisePage recruiterAdvertisePage = new RecruiterAdvertisePage(browser);

    @Test
    public void clickOnRegister_OpensForm() {
        //given
        home.load();
        home.waitUntilLoaded();
        home.clickOnAdvertiseButton();
        recruiterPage.waitUntilLoaded();

        //when
        recruiterPage.clickOnRegisterButton();
        recruiterAdvertisePage.waitUntilLoaded();

        //then
        assertTrue(recruiterAdvertisePage.isRegisterPanelShown());
    }

    @Test
    public void clickOnAdvertiseNowButton_goesToRecruiterAdvertiseJob() {
        //given
        home.load();
        home.waitUntilLoaded();
        home.clickOnAdvertiseButton();
        recruiterPage.waitUntilLoaded();

        //when
        recruiterPage.clickOnAdvertiseNowButton();
        recruiterAdvertisePage.waitUntilLoaded();

        //then
        assertTrue(recruiterAdvertisePage.isPostAJobPage());
    }
}
