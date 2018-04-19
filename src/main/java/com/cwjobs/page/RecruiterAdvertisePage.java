package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruiterAdvertisePage extends AbstractPage<RecruiterAdvertisePage> {
    public RecruiterAdvertisePage(WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.className("footer-logos"));
    }

    public boolean isRegisterPanelShown() {
        pageTools.waitUntilVisible(By.id("Register_pnlRegister"));
        return true;
    }

    public boolean isPostAJobPage() {
        pageTools.waitUntilExists(By.id("page_post-a-job"));
        return true;
    }
}
