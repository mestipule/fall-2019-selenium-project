package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlertExample {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void htmlPopup() throws Exception {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //this is when you locat the Destroy the world button
        //it using an xpath because you can't use the linkText because there are two
        WebElement button = driver.findElement(By.xpath("//span[text()='Destroy the World']"));
        //click() -> to click found method
        button.click();
        Thread.sleep(3000);

        //locating the button in
        //us
        WebElement no = driver.findElement(By.xpath("//span[.='No']"));
        no.click();
        Thread.sleep(3000);
    }
    @Test
    public void jsAlerts() throws Exception {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button1 = driver.findElement(By.xpath("//button[1]"));
        button1.click();
        Thread.sleep(3000);

        //alert is an interface
        // this control the popup
        Alert alert = driver.switchTo().alert();
        //accept() is a method to close the pop up or prompt
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void jsAlertsCancel() throws Exception {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button2 = driver.findElement(By.xpath("//button[2]"));
        button2.click();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert(); // this control the popup
        //dismiss() -> also close and accept the prompt or pop up
        alert.dismiss();
        Thread.sleep(3000);
    }
    @Test
    public void jsAlertsSendkeys() throws Exception {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button3 = driver.findElement(By.xpath("//button[3]"));
        Thread.sleep(3000);
        button3.click();//if you don't have this method it will
        //you would have NoAlertPresentException

        Thread.sleep(3000);
        Alert alert = null;
        try {
            alert = driver.switchTo().alert(); // this control the popup
            alert.sendKeys("Admiral Kunkka");
            Thread.sleep(3000);
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }
}
