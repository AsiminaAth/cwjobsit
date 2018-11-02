package com.cwjobs.site;

import com.cwjobs.page.JobResults;
import com.cwjobs.page.RegisterPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JobResultsIT extends AbstractPageIT{
    private JobResults jobResults = new JobResults(browser);
    private RegisterPage registerPage = new RegisterPage(browser);

    @Test
    public void searchJobs_ReturnsResults() {
        //when
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();

        //then
        assertNotNull(jobResults.getJobResults());
    }

    @Test
    public void clickOnNextResultsPageButton_goesToNextResultsPage() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();

        //when
        jobResults.goToNextResultsPage();
        jobResults.waitUntilLoaded();

        //then
        assertEquals(2, jobResults.activePageIndex());
    }

    @Test
    public void clickOnDropdownToggle_revealsTheToggleMenu() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();

        //when
        jobResults.clickOnDropdownToggle();
        jobResults.waitUntilLoaded();

        //then
        jobResults.isToggleMenuOpen();
    }

    @Test
    public void clickOnRegisterButton_goesToRegisterPage() {
        //given
        home.searchJob("Software Testing", "London");
        jobResults.waitUntilLoaded();

        jobResults.signInJobSeeker();//implement

        //when
        jobResults.clickOnRegisterButton(); //check if needs fix

        //then
        assertTrue(registerPage.isRegisterPage());
    }
}
