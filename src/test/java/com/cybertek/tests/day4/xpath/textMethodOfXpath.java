package com.cybertek.tests.day4.xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class textMethodOfXpath {
    public static void main(String[] args) {
        //verify menu in the page
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/context_menu");

    }
}
