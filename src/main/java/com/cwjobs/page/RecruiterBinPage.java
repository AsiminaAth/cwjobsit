package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruiterBinPage extends AbstractPage<RecruiterBinPage>{
    public RecruiterBinPage(final WebDriver browser) {
        super(browser);
        setImplementor(this);
        setLastElementLocator(By.className("bottom-footer"));
    }

}


