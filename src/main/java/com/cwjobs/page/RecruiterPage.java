package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruiterPage extends AbstractPage<RecruiterPage>{
    public RecruiterPage(final WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.id("footer"));
    }

    public void clickOnRegisterButton() {
        pageTools.clickOnElementWithClassName("signinbtn");
    }

    public void clickOnAdvertiseNowButton() {
        pageTools.clickOnLinkWithText("ADVERTISE NOW");
    }
}


