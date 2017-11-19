package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobResults extends AbstractPage<JobResults>{
    public JobResults(final WebDriver browser) {
        super(browser);
        setImplementor(this);
    }

    public WebElement getJobResults() {
        return browser.findElement(By.className("job-results"));
    }

    public void showDetailsOfJob(int index) {
        browser.findElements(By.className("job-title"))
            .get(index)
            .findElements(By.tagName("a"))
            .get(0)
            .click();
    }

    public String getIdOfJob(int index) {
        return browser.findElements(By.className("job")).get(index).getAttribute("id");
    }
}


