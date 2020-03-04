package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        /*
        1. go to cybertek practice website "http://practice.cybertekschool.com/"
        2. verify title expected title:Practice
        3.
        */

        WebDriverManager.chromedriver().setup();
        // setting up webdriver
        //connects your browsers

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

        String expectedTitle = "Practice";

        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("This is what we expected");
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
        }


        driver.close();

        driver.quit();


    }
}
