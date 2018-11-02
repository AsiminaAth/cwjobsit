package com.cwjobs.page;

import org.openqa.selenium.WebDriver;

public class Home extends AbstractPage<Home>{

    public Home(final WebDriver browser) {
        super(browser);
        setImplementor(this);
    }

    public void load() {
        browser.navigate().to("http://www.cwjobs.co.uk");
    }

    public void searchJob(String title, String location) {

        forJob(title).in(location).search();
    }

    public Home forJob(String job) {
        pageTools.writeTextInElementWithId(job, "keywords");
        return this;
    }

    public Home in(String locationDescription) {
        pageTools.writeTextInElementWithId(locationDescription, "location");

        return this;
    }

    public Home search() {
        pageTools.clickOnElementWithId("search-button");
        return this;
    }

    public void clickOnRecruiting() {
        pageTools.clickOnElementWithClassName("recruiter-link-tab");
    }

    public void clickOnAdvertiseNowButton() {
        pageTools.clickOnElementWithClassName("recruiter-button");
    }
}


