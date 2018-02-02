package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class BrowserTools {
    private static WebDriver browser;
    private static boolean initialized;

    static WebDriver startBrowser(Class clazz) {
        if (!initialized) {
            System.setProperty("webdriver.chrome.driver","/home/nirvana/development/selenium/chromedriver");
            browser = new ChromeDriver();
            browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            initialized = true;
        }
        return browser;
    }

    static void quitBrowser(Class clazz) {
            browser.quit();
            initialized = false;
    }
}
