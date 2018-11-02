package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplyJob extends AbstractPage<ApplyJob>{
    public ApplyJob(final WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.className("tjg-logo"));
    }

    public ApplyJob forEmail(String email) {
        pageTools.writeTextInElementWithId(email, "txtEmail");
        return this;
    }

    public ApplyJob next() {
        pageTools.clickOnElementWithId("btnVerifyEmail");
        return this;
    }

    public void viewJobDescription() {
        pageTools.clickOnElementWithClassName("btn-default");
    }

    public void waitUntilContinueButtonIsShown() {
        pageTools.waitUntilVisible(By.id("btnRegister"));
    }
}


