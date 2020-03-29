package com.cybertek.tests.day5_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {
    public static void main(String[] args) {
        //get chrome
        //controls the web drivers
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //open browser
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //maximize your browser
        driver.manage().window().maximize();

        //using an interface of WebElement
        //controls all the element
        //represents element from the webpage
        //from the findElement methods
        //how findElement finds element? or findElements => findElements can return several elements
        //using locators
        //using the first fomula or syntax
        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //starts interacting with the element
        String txt = buttonOne.getText();
        System.out.println(txt);
        //combination of two xpath wit the siblings
        WebElement buttonTwo = driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(buttonTwo.getText());

        //this is possible
        //but writing one operation per line
        //will look professional and it's easier to debug
        //less complex xpath that says find the button and the third button
        System.out.println(driver.findElement(By.xpath("//button[3]")).getText());

//        WebElement buttonThree = driver.findElement(By.xpath());

        WebElement buttonFour = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(buttonFour.getText());

        WebElement buttonFive = driver.findElement(By.xpath("//button[.='Button ']"));
        System.out.println(buttonFive.getText());

        //element.getAttributee("value") --> method to get text form element, used with
        WebElement buttonSix = driver.findElement(By.xpath("//button[@id='disappearing_button']"));
        System.out.println(buttonSix.getAttribute("innerHTML"));

        System.out.println(buttonSix.getAttribute("outerHTML"));

        driver.close();
    }
}
