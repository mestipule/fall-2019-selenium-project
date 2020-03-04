package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        //WebDriver object --> Interface

        //this is the binary of the driver and browsers
        WebDriverManager.chromedriver().setup();

        WebDriver drive = new ChromeDriver();
        //i have a drive now
        // you write code under the webdriver
        //we need to connect our webdriver to the website itself
        //this creates objects for the web driver


        //Openning Google homepage
        //the webdriver will do everything for you
        drive.get("https://www.google.com/");
        //interview question
        //how do you launch or download a webpage
        // answer
        //by using a get() -> use url as a string to call website

        //Navigator
        //4or5

        //1. navigate().to -> opens a webpage as well
        drive.navigate().to("https://www.google.com/");
        //what is the difference between get() and navigate()
        // -> get --> wait to load the page
        //navigate -> does not wait

        //navigate.back
        drive.get("https://www.google.com/");
        Thread.sleep(3000);

        drive.navigate().to("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        drive.navigate().back();
        // open google ->

    }
}
