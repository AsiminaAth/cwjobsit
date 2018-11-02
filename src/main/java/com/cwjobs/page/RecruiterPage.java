package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruiterPage extends AbstractPage<RecruiterPage>{
    public RecruiterPage(final WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.className("bottom-footer"));
    }

    public void clickOnRegisterButton() {
        pageTools.clickOnElementWithClassName("nav__register-button");
    }

    public void clickOnBuyJobAdsButton() {
        pageTools.clickOnLinkWithText("BUY JOB ADS");
    }
}


