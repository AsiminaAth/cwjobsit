package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruiterJobAdBuyPage extends AbstractPage<RecruiterJobAdBuyPage> {
    public RecruiterJobAdBuyPage(WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.className("copyright"));
    }

    public void clickOnBuyNowTextLink() {
        pageTools.clickOnElementWithClassName("pdp-slider__buy-btn");
    }

}
