package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruiterSignInRegisterPage extends AbstractPage<RecruiterSignInRegisterPage> {
    public RecruiterSignInRegisterPage(WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.className("tjg-logo"));
    }

    public boolean isSignInPanelShown() {
        pageTools.waitUntilVisible(By.className("signin"));
        return true;
    }

    public boolean isRegisterPanelShown() {
        pageTools.waitUntilVisible(By.className("register"));
        return true;
    }
}
