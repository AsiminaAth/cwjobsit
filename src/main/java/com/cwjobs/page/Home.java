package com.cwjobs.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by nirvana on 1/21/17.
 */
public class Home {
    private final WebDriver browser;

    public Home(final WebDriver browser) {
        this.browser = browser;
    }

    public void load() {
        browser.navigate().to("http://www.cwjobs.co.uk");
    }
}
