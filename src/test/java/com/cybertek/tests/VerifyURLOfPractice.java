package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLOfPractice {
    public static void main(String[] args) {
        /*
        got to cybetek Practice
        "http://practice.cybertekschool.com/"
        verify the URL
        */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        String expectedURL = "http://practice.cybertekschool.com/";
        String actualTitle = driver.getCurrentUrl();

        if (expectedURL.equalsIgnoreCase(actualTitle)) {
            System.out.println("This is what we expected");
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedURL);
            System.out.println(expectedURL + " the actual URL but " + actualTitle);
        }

        driver.quit();
    }
}
