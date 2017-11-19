package com.cwjobs.site;

import com.cwjobs.page.JobResults;
import org.junit.Test;

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
