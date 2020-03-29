package com.cybertek.tests.day3;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyingErrorMessage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

    /*
            1. go to login page http://practice.cybertekschool.com/login
            2. enter invalid username
            3. enter invalid password
            4. Verify the error massage "Your username is invalid!"
     */

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        Faker fakeData = new Faker();
        String username = fakeData.name().username();
        String password = fakeData.app().author();
        driver.findElement(By.id("wooden_spoon")).click();

//        String expectedErrorMessage = "Your username  is invalid"
//                driver.findElement(By.id("flash"));


    }
}
