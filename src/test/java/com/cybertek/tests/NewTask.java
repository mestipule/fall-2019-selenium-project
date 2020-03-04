package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        String expectedTitle = driver.getTitle();
        driver.navigate().to("https://www.etsy.com/");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        String expectedTitle2 = driver.getTitle();
        driver.navigate().forward();
        String etsyTitle2 = driver.getTitle();
        if(expectedTitle.equalsIgnoreCase(expectedTitle2)) {
            System.out.println("Same title");
        } else {
            System.out.println("Not same title");
        }

        if(etsyTitle.equalsIgnoreCase(etsyTitle2)) {
            System.out.println("Same title");
        } else {
            System.out.println("Not same title");
        }
        driver.quit();
    }
}
