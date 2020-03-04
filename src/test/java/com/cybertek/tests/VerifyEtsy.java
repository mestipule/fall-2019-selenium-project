package com.cybertek.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyEtsy {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/?utm_source=google&utm_medium=cpc&utm_term=etsy_e&utm_campaign=Search_US_Brand_GGL_General-Brand_Core_All_HP_Exact&utm_ag=A1&utm_custom1=2949ec97-657c-4aa2-b8b5-903a22dc7c8c&utm_content=go_227553629_16342445429_310396601160_aud-424578309581:kwd-1818581752_c_&utm_custom2=227553629&gclid=Cj0KCQiA1-3yBRCmARIsAN7B4H05rnJ6SKViQqnPl3X4uzxLO483f5ODatwtJq17ux9S_d8tocgba3MaAv9JEALw_wcB");
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("This is what we expected");
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
        }

//        driver.close();
        //only use one either .close or .quit

        driver.quit();
    }
}
