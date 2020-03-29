package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassTests {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        String expectedTitle = "Practice";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void dropDown1() {
        //finding your dropdown
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        //selecting your class with web element
        Select dropdownList = new Select(dropdown1);
        //getting your selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
        Assert.assertEquals(selectedOption.getText(), "Please select an option");
    }
    @Test
    public void selectFromList() throws InterruptedException {
        //get the element with select tag
        WebElement dropdown = driver.findElement(By.id("state"));
        //creating select class
        Select states = new Select(dropdown);
        //selectByVisibleText()  --> selects y the text of the option
        //it takes a parameter....
        states.selectByVisibleText("Iowa");
        System.out.println("found Iowa");
        Thread.sleep(3000);
        states.selectByVisibleText("Vermont");
        System.out.println("found Vermont");
        Thread.sleep(3000);
        states.selectByVisibleText("Kentucky");
        System.out.println("found Kentucky");
        Thread.sleep(3000);

        //selecting item by index from the List created before
        states.selectByIndex(0);
        Thread.sleep(1000);
        states.selectByIndex(10);
        Thread.sleep(1000);
        states.selectByIndex(20);
        Thread.sleep(1000);

        //selecting by value
        states.selectByValue("VA");
        Thread.sleep(1000);
        states.selectByValue("SC");
        Thread.sleep(1000);
        states.selectByValue("CO");
        Thread.sleep(1000);
        states.selectByValue("NE");
        Thread.sleep(1000);
    }
    @Test
    public void getAllAvailableOptions() {
        Select monthList = new Select(driver.findElement(By.id("month")));
        //print the current selection
        System.out.println(monthList.getFirstSelectedOption().getText());
        
        List<WebElement> allOptions = monthList.getOptions();
        System.out.println("Number of months = " + allOptions.size());
        for (WebElement month : allOptions) {
            System.out.println("month = " + month.getText());
        }
        //verify tht months list always shoes the current month as slected
        //get the current month
        String expectedMonth = LocalDate.now().getMonth().name();
        String actualMonth =  monthList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth.toLowerCase(), expectedMonth.toLowerCase());
        //verify that month
        List<String> expectedMonths = Arrays.asList("January", "Febuary", "March", "April", "May",
                                                    "June", "July", "August", "September", "October",
                                                    "November", "December");
        //get options gives me list webelements, so alloptions is a list of a webelements
        //but my  epxected it a list strings.  i have to make sure the both list of strings
        //i need to get list string list of webelement

        List<String> actualMonths = new ArrayList<>();
        for (WebElement option : allOptions) {
            actualMonths.add(option.getText());
        }
        Assert.assertEquals(actualMonths, expectedMonths);

    }
    @Test
    public void verifyOption() {
        Select list = new Select(driver.findElement(By.id("dropdown")));
        int expectedSize = 3;
        int actualSize = list.getOptions().size();
        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");

        List<String> actualValues = new ArrayList<>();
        for (WebElement option : list.getOptions()) {
            actualValues.add(option.getText());
        }
    }
}
;
