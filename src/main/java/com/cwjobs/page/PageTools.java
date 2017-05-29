package com.cwjobs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageTools {

    private final WebDriver browser;
    private Finder find;

    public PageTools(WebDriver browser) {
        this.browser = browser;
        this.find = new Finder(browser);
    }

    public <T> void waitUntil(ExpectedCondition<T> expectedCondition) {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(expectedCondition);
    }

    public void waitUntilVisible(By locator) {
        waitUntil(ExpectedConditions.visibilityOf(find.by(locator)));
    }

    public void waitUntilExists(By locator) {
        waitUntil(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickOnTheFirstElement(By locator) {
        find.elementsBy(locator).get(0).click();
    }

    public void clickOnTheFirstElementWithClass(String className) {
        clickOnTheFirstElement(By.className(className));
    }

    public int getOpenWondowsNumber() {
        return browser.getWindowHandles().size();
    }

    public void moveToWindow(int index) {
        List<String> browserTabs = new ArrayList<String>(browser.getWindowHandles());
        browser.switchTo().window(browserTabs .get(index));
    }

    public void writeTextInElementWithId(String text, String id) {
        find.byId(id).clear();
        WebElement elemnt = browser
                .findElement(By.id(id));
        elemnt.sendKeys(text);
    }

    public void clickOnElementWithId(String id) {
        find.byId(id).click();
    }

    public void clickOnElementWithClassName(String className) {
        find.byClassName(className).click();
    }
}
