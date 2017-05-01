package com.cwjobs.site;

import com.cwjobs.page.Home;
import com.cwjobs.page.JobDetails;
import com.cwjobs.page.JobResults;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertNotNull;

public class JobDetailsIT extends AbstractPageIT{
    private JobResults jobResults = new JobResults(browser);
    private JobDetails jobDetails = new JobDetails(browser);

    @Test
    public void clickOnJobTitile_ReturnsJobDetailsPage() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();

        //when
        jobResults.showDetailsOfJob(0);

        jobDetails.waitUntilLoaded();

        //then
        assertNotNull(browser.findElement(By.className("job-content")));
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
}
