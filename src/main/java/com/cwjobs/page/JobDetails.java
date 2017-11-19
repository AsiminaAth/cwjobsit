package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobDetails extends AbstractPage<JobDetails> {
    public JobDetails(final WebDriver browser) {
        super(browser);
        setImplementor(this);
    }

    public void saveJob() {
        pageTools.clickOnTheFirstElementWithClass("btn-savejob");
    }

    public void apply() {
        pageTools.clickOnTheFirstElementWithClass("apply-now-btn");
    }

    public void waitUntilJobWasSaved() {
        pageTools.waitUntilVisible(By.id("saved-job-toast"));
    }

    public void nextJob() {
        pageTools.clickOnElementWithId("nextJobButton");
    }

    public void previousJob() {
        pageTools.clickOnElementWithId("previousJobButton");
    }

    public String getIdOfJob() {
        return pageTools.valueOfElement(By.id("jobId"));
    }

    public void backToSearchResults() {
        pageTools.clickOnElementWithId("backToResultsButton");
    }
}


