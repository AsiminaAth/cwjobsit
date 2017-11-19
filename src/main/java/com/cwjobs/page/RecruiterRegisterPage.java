package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruiterRegisterPage extends AbstractPage<RecruiterRegisterPage> {
    public RecruiterRegisterPage(WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.className("footer-logos"));
    }

    public boolean isRegisterPanelShown() {
        pageTools.waitUntilVisible(By.id("Register_pnlRegister"));
        return true;
    }
}
