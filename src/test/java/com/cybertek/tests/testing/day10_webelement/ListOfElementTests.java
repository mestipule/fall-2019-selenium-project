package com.cybertek.tests.testing.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementTests {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        String expectedTitle = "Practice";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
    /*
    go to page radio buttons
    verify that none of the sports radio button non are selected

    */

    @Test
    public void listOfRadioButtonsTest() {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //driver.findElements ==> return a List of element
        List<WebElement> sports = driver.findElements(By.name("sport"));
        WebElement hockey = driver.findElement(By.id("hockey"));
        hockey.click();
        System.out.println(sports.size());
        for (WebElement eachSports : sports) {
            Assert.assertFalse(eachSports.isSelected());
        }
    }
        /*
        got to practice website
        get all the links
         */

        @Test
        public void allLinksTest() {
            driver.get("http://practice.cybertekschool.com/");
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println(links.size());
            for(WebElement eachLink : links) {
                System.out.println(eachLink.getText());
            }

        }

        @Test
        public void amazonLink() throws Exception{
            driver.get("http://amazon.com");
            WebElement input =  driver.findElement(By.id("twotabsearchtextbox"));
            input.sendKeys("paper towel" + Keys.ENTER);

            List<WebElement> allResult = driver.findElements((By.cssSelector("span.a-size-base-plus")));
            Thread.sleep(3000);
            System.out.println("allResult = " + allResult);
            System.out.println("first result: " + allResult.get(0).getText());
            System.out.println("second result: " + allResult.get(1).getText());
            System.out.println("last result: " + allResult.get(allResult.size()-1).getText());
            for (WebElement eachResult : allResult) {
                for (int i = 1; i <= allResult.size()-1; i++) {
                    System.out.println(i + ". " + eachResult.getText());
                }
            }
        }
    @Test
    public void setWorkTest() throws InterruptedException {
        //go to http://practice.cybertekschool.com/radio_buttons
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //verify the all sports checkboxes are not checked by default
        List<WebElement> radioButtons = driver.findElements(By.name("sport"));
        for (WebElement eachSelected : radioButtons) {
            Assert.assertTrue(eachSelected.isSelected());
        }
        //randomly click any sport
        Random ran = new Random();
        for (int q = 0; q < 5; q++) {
            Thread.sleep(3000);
            int num = ran.nextInt(4);
            radioButtons.get(num).click();
            System.out.println("selecting button " + q);
            for (int i = 0; i < radioButtons.size(); i++) {
                if (i == num) {
                    Assert.assertTrue(radioButtons.get(num).isSelected());
                } else  {
                    Assert.assertFalse(radioButtons.get(i).isSelected());
                }
            }
        }
        for (WebElement notSelected : radioButtons) {
            Assert.assertFalse(notSelected.isSelected());
        }

    }

}
