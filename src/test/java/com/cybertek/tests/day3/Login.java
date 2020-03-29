package com.cybertek.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        driver.manage().window().maximize();

        //locating the welcome message with tagname
        WebElement welcomeMessage = driver.findElement(By.tagName("h4"));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout";
        //converting your welcomeMessage from being an element in html to a text
        String actualWelcomeMessage = welcomeMessage.getText();

        if (actualWelcomeMessage.equals(expectedMessage)) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        driver.close();
    }
}
