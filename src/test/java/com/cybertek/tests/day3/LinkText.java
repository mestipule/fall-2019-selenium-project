package com.cybertek.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().window().maximize();
        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        //locator -> using link text
        //to locate to element

        String textVersionOfExample3 = example3.getText();
        System.out.println(textVersionOfExample3);

        WebElement example3Ver2 = driver.findElement(By.partialLinkText("Element on page that is hidden and"));
        String textVersionOfExample3Ver2 = example3Ver2.getText();
        System.out.println(textVersionOfExample3Ver2);

        WebElement cybertek =  driver.findElement(By.linkText("Cybertek School"));
        String cybertekSchool = cybertek.getText();
        System.out.println(cybertekSchool);

        WebElement home =  driver.findElement(By.linkText("Home"));
        String homeElement = home.getText();
        System.out.println(homeElement);
        driver.close();
    }
}