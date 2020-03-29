package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
    write a method returns webdrivre
    name: getDriver
    it takes parameter => browsertype
    returns chromedriver and firefoxdriver
    */
    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new  ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}


