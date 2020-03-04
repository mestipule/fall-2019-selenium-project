package com.cybertek.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigation:
             driver.navigate().to("URL")
             driver.navigate().back()
             driver.navigate().forward()
             driver.navigate().refresh()
        */

        //got to practice --> got to google --> back to practice
        //--> forward to google

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        ChromeDriver driver1 = new ChromeDriver();


        String practiceWebURL = "http://practice.cybertekschool.com/";
        driver.get((practiceWebURL));
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String gglURL = "https://www.google.com/";
        driver.navigate().to(gglURL);
        Thread.sleep(3000);
        //back to practice
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();
        driver.navigate().refresh();

        driver.close();

        driver.quit();

        driver.close();



    }
}
