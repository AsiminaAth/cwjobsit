package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends AbstractPage<RegisterPage> {
    public RegisterPage(WebDriver browser) {
        super(browser);
    }

    public boolean isRegisterPage() {
        pageTools.waitUntilTitleContains("registration");
        return true;
    }
}
