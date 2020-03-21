package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2000);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

//        buttons.get(0).click();
//        BrowserUtils.wait(2000);
//        driver.switchTo().alert().accept();
//
//        String expected = "You successfully clicked an alert";
//        String actual = driver.findElement(By.id("result")).getText();
//        //if will fail, because there is a typo ##BUG##
//        if(expected.equals(actual)){
//            System.out.println("TEST PASSED");
//        }else {
//            System.out.println("TEST FAILED");
//            System.out.println("Expected: "+expected);
//            System.out.println("Actual:   "+actual);
//        }
//        BrowserUtils.wait(3000);
//
//        buttons.get(1).click();
//        driver.switchTo().alert().dismiss();
//
//        String expected2 = "You clicked: Cancel";
//        String actual2 = driver.findElement(By.id("result")).getText();
//
//        if (expected2.equals(actual2)){
//            System.out.println("test passed");
//        }else {
//            System.out.println("test failed");
//            System.out.println("expected: " + expected2);
//            System.out.println("Actual: " + actual2);
//        }

        // task

        buttons.get(2).click();
        driver.switchTo().alert().sendKeys("Hello world");
        driver.switchTo().alert().accept();

        String expected3 = "Hello world";
        String actual3 = driver.findElement(By.id("result")).getText();

        if (actual3.endsWith(expected3)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            System.out.println("expected: " + expected3);
            System.out.println("Actual: " + actual3);
        }


        BrowserUtils.wait(3000);
        driver.quit();
    }
}
