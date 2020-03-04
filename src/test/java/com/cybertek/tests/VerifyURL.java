package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURL {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        //for verify title --> getTitle()
        //for verify URL --> getCurrentUrl()

        String expectedURL = "https://www.etsy./";
        String acutalURL = driver.getCurrentUrl();

        if (expectedURL.equalsIgnoreCase(acutalURL)) {
            System.out.println("PASS");
            System.out.println(expectedURL + "is expected");

        }else {
            System.out.println("FAIL");
            System.out.println(acutalURL + " is not expected result however, my actual is " + expectedURL);

        }

        driver.quit();
    }
}
