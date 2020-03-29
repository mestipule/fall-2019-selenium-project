package com.cybertek.tests.officeHours.march23;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class dropdown {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    /*
        go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
        verify that table has dropdown with values Family, Friends, Coworkers, Businesses, Contacts
        select option Corworkers
        verify that that Coworkers is now selected
        select options Contacts
        verify that contacts is selected
    */
    @Test
    //verify all the options
    public void test() throws Exception {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(3000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        //getOptions --> give all available options as a list of web elements
        List<WebElement> allOptionsE1 = categories.getOptions();
        System.out.println("Number of  options: " + allOptionsE1.size());
        List<String> execptionOptions = Arrays.asList("Family", "Friends", "Coworkers", "Business", "Contacts");

        //given a list webElements, extract the text of the elemets into new list of string
        //method good to verify a LIST
        List<String> allOptionsStr = BrowserUtils.getElementsText(allOptionsE1);
        Assert.assertEquals(allOptionsStr, execptionOptions);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(200);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        //select option Coworker
        categories.selectByVisibleText("Coworkers");
        String actual = categories.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, "Coworker");
    }
}
