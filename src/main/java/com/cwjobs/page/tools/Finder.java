package com.cwjobs.page.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Finder {

    private final WebDriver browser;

    public Finder(WebDriver browser) {
        this.browser = browser;
    }

    public WebElement byId(String id) {
        return by(By.id(id));
    }

    public WebElement byClassName(String className) {
        return by(By.className(className));
    }

    public WebElement by(By locator) {
        return browser.findElement(locator);
    }

    public List<WebElement> elementsBy(By locator) {
        return browser.findElements(locator);
    }

    public WebElement linkByText(String text) {
        return browser.findElement(By.linkText(text));
    }
}
