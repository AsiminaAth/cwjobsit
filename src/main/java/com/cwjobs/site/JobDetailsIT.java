package com.cwjobs.site;

import com.cwjobs.page.JobDetails;
import com.cwjobs.page.JobResults;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JobDetailsIT extends AbstractPageIT{
    private JobResults jobResults = new JobResults(browser);
    private JobDetails jobDetails = new JobDetails(browser);

    @Test
    public void clickOnJobTitile_ReturnsJobDetailsPage() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();
        String firstJobId = jobResults.getIdOfJob(0);

        //when
        jobResults.showDetailsOfJob(0);

        jobDetails.waitUntilLoaded();

        //then
        assertNotNull(browser.findElement(By.className("job-content")));
        assertEquals(firstJobId, jobDetails.getIdOfJob());
    }

    @Test
    public void whenOpenTheJobDetails_clickOnSaveButton_SaveTheJobAndUpdatesInterface() {
        //given
        home
                .forJob("Software Testing")
                .in("London")
                .search();

        jobResults.showDetailsOfJob(0);

        jobDetails.waitUntilLoaded();

//        when
        jobDetails.saveJob();

//        then
        jobDetails.waitUntilJobWasSaved();

    }

    @Test
    public void clickOnNextJob_goesToNextJobDetailsPage() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();
        String secondJobId = jobResults.getIdOfJob(1);
        jobResults.showDetailsOfJob(0);
        jobDetails.waitUntilLoaded();

        //when
        jobDetails.nextJob();
        jobDetails.waitUntilLoaded();

        //then
        assertNotNull(browser.findElement(By.className("job-content")));
        assertEquals(secondJobId, jobDetails.getIdOfJob());
    }

    @Test
    public void clickOnPreviousJob_goesToPreviousJobDetailsPage() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();
        String firstJobId = jobResults.getIdOfJob(0);
        jobResults.showDetailsOfJob(1);
        jobDetails.waitUntilLoaded();

        //when
        jobDetails.previousJob();
        jobDetails.waitUntilLoaded();

        //then
        assertNotNull(browser.findElement(By.className("job-content")));
        assertEquals(firstJobId, jobDetails.getIdOfJob());
    }

//    @Test
//    public void clickOnShowMyCommuteTimeButton() {
//        //given
//        home.searchJob("Software Testing", "London");
//        jobResults.waitUntilLoaded();
//        jobResults.showDetailsOfJob(0);
//        jobDetails.waitUntilLoaded();
//
//        //when
//        jobDetails.showMyCommuteTime();
//        jobDetails.waitUntilLoaded();
//    }

    @Test
    public void clicksOnBackToSearchResults() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();
        jobResults.showDetailsOfJob(0);
        jobDetails.waitUntilLoaded();

        //when
        jobDetails.backToSearchResults();
        jobDetails.waitUntilLoaded();

        //then
        assertNotNull(browser.findElement(By.id("search-submit-button-desktop")));
    }
}