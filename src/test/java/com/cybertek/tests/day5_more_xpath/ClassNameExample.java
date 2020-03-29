package com.cybertek.tests.day5_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        WebElement link = driver.findElement(By.className("nav-link"));
        System.out.println(link.getText());
        /*
        //class name does  not work if the value of the class attribute has a space
        //this will fail

        WebElement loginBtn = driver.findElement(By.className("btn btn-primary"));
        loginBtn.click();
        */
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
// TODO linktext
        //locate Example 1
        WebElement exemple1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
//        System.out.println(exemple1.getAttribute("href"));
// TODO partiallinktext
        WebElement example2 = driver.findElement(By.partialLinkText("2:"));
        System.out.println(example2.getText());

    }
}
