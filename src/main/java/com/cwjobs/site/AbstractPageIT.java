package com.cwjobs.site;

import com.cwjobs.page.Home;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AbstractPageIT {
    protected static WebDriver browser;
    protected Home home = new Home(browser);

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","/home/nirvana/development/selenium/chromedriver");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Before
    public void setUpTest() {
        home.load();
    }

    @AfterClass
    public static void tearDown() {
        browser.quit();
    }

}
