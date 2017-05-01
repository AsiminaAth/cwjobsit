package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage<T> {
    private final By lastElementLocator = By.id("saved-job-toast");
    protected final PageTools pageTools;
    private T implementor;
    protected WebDriver browser;

    public AbstractPage(WebDriver browser) {
        pageTools = new PageTools(browser);
        this.browser = browser;
    }

    public T waitUntilLoaded() {
        pageTools.waitUntilExists(lastElementLocator);
        return implementor;
    }

    protected void setImplementor(T implementor) {
        this.implementor = implementor;
    }
}

