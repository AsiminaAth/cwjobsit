package com.cwjobs.site;

import com.cwjobs.page.ApplyJob;
import com.cwjobs.page.JobDetails;
import com.cwjobs.page.JobResults;
import com.cwjobs.page.RecruiterPage;
import com.cwjobs.page.tools.PageTools;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class JobApplyIT extends AbstractPageIT {
    private JobResults jobResults = new JobResults(browser);
    private JobDetails jobDetails = new JobDetails(browser);
    private ApplyJob applyJob = new ApplyJob(browser);
    private PageTools pageTools = new PageTools(browser);
    private RecruiterPage recruiterPage = new RecruiterPage(browser);

    @Test
    public void clickOnApply_ReturnsApplyPage() {

        //given
        home.searchJob("Software Testing", "London");
        jobResults.showDetailsOfJob(0);
        jobDetails.waitUntilLoaded();

        //when
        jobDetails.apply();
        applyJob.waitUntilLoaded();

        //then
        assertTrue("Apply".equals(applyJob.title()));

    }

    @Test
    public void whenOnApplyPageViewAgainJobDescriptionInNewWindow() {
        //given
        //search for jobs
        home
                .forJob("Software Testing")
                .in("London")
                .search();

        jobResults.waitUntilLoaded().getIdOfJob(0);

        jobResults.showDetailsOfJob(0);

        jobDetails.waitUntilLoaded();

        jobDetails.apply();

        applyJob.waitUntilLoaded();

        //when
        int windowsOpened = pageTools.getOpenWindowsNumber();

        applyJob.viewJobDescription();

        //then
        pageTools.waitUntil(ExpectedConditions.numberOfWindowsToBe(windowsOpened+1));

        pageTools.moveToWindow(1);
        jobDetails.waitUntilLoaded();

        //finally close tab and get back
        browser.close();
        pageTools.moveToWindow(0);
    }

    @Test
    public void whenOnApplyPage_EnterTheEmail() {
        home
                .forJob("Software Testing")
                .in("London")
                .search();

        jobResults.waitUntilLoaded().getIdOfJob(0);

        jobResults.showDetailsOfJob(0);

        jobDetails.waitUntilLoaded();

        jobDetails.apply();

        applyJob.waitUntilLoaded();

        //when
        applyJob
                .forEmail("blabla@mail.com")
                .next();
        //then
        applyJob.waitUntilContinueButtonIsShown();
    }
}
