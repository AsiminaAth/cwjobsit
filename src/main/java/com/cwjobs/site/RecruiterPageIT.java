package com.cwjobs.site;

import com.cwjobs.page.JobResults;
import com.cwjobs.page.RecruiterPage;
import com.cwjobs.page.RecruiterRegisterPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RecruiterPageIT extends AbstractPageIT{
    private JobResults jobResults = new JobResults(browser);
    private RecruiterPage recruiterPage = new RecruiterPage(browser);
    private RecruiterRegisterPage recruiterRegisterPage = new RecruiterRegisterPage(browser);

    @Test
    public void clickOnRegister_OpensForm() {
        //given
        home.load();
        home.waitUntilLoaded();
        home.clickOnAdvertiseButton();
        recruiterPage.waitUntilLoaded();

        //when
        recruiterPage.clickOnRegisterButton();
        recruiterRegisterPage.waitUntilLoaded();

        //then
        assertTrue(recruiterRegisterPage.isRegisterPanelShown());
    }

}
