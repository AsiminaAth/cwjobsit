package com.cwjobs.site;

import com.cwjobs.page.RecruiterPage;
import com.cwjobs.page.tools.PageTools;
import org.junit.Test;
import org.openqa.selenium.By;

public class HomePageIT extends AbstractPageIT {

    private PageTools pageTools = new PageTools(browser);
    private RecruiterPage recruiterPage = new RecruiterPage(browser);

    @Test
    public void openCwjobs_landsHomePage() {
        home.waitUntilLoaded();
    }

    @Test
    public void clickOnRecruiting_unfoldsRecruitersPanel() {
        //given
        home.waitUntilLoaded();

        //when
        home.clickOnRecruiting();

        //then
        pageTools.waitUntilExists(By.className("recruiter-open"));

    }

    @Test
    public void clickOnAdvertiseButton_goesToRecruiterPage() {
        //given
        home.waitUntilLoaded();

        //when
        home.clickOnAdvertiseNowButton();

        //then
        recruiterPage.waitUntilTitleContains("Advertise a job");
        recruiterPage.waitUntilLoaded();
    }
}
