package com.cybertek.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /*
            1. go to VyTrack login page
            2. write username data: storemanager52
            3. write password       UserUser123
            4. click login button
        */
        driver.navigate().to("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        String expectedTitle = "Dashboard";

        String expectedURL = "https://app.vytrack.com/";

        if(driver.getTitle().equals(expectedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        if (driver.getCurrentUrl().equals(expectedURL)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver.quit();
    }
}
