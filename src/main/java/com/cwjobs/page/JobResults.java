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

    public void goToNextResultsPage() {
        pageTools.clickOnElementWithClassName("next");
    }

    public int activePageIndex() {
        String xpath = "//ul[contains(@class, 'pagination')]/li/span[contains(@class, 'active')]";
        return Integer.valueOf(pageTools.textOfElement(By.xpath(xpath)));
    }

    public void clickOnDropdownToggle() {
        browser.findElement(By.className("dropdown-toggle")).click();
    }

    public boolean isToggleMenuOpen() {
        String expanded = pageTools.attributeOfElement(By.className("dropdown-toggle"), "aria-expanded");
        return "true".equals(expanded);
    }

    public void clickOnRegisterButton() {
        pageTools.clickOnLinkWithText("Register");
    }


    public void signInJobSeeker() {
        pageTools.clickOnElementWithId("navbar-desktop-signin-toggle");

        pageTools.clickOnLinkWithText("Jobseeker sign in");
    }
}


