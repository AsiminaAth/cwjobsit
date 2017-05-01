package com.cwjobs.site;

import com.cwjobs.page.Home;
import com.cwjobs.page.JobResults;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertNotNull;

public class JobResultsIT extends AbstractPageIT{
    private JobResults jobResults = new JobResults(browser);

    @Test
    public void searchJobs_ReturnsResults() {
        //when
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();

        //then
        assertNotNull(jobResults.getJobResults());
    }
}
