package com.automation.tests.day4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(2000);

        // how to collect all links from the page

       List<WebElement> links = driver.findElements(By.tagName("a"));

//        for (WebElement link : links) {
//            System.out.println(link.getText());
//            System.out.println(link.getAttribute("href"));
//            System.out.println();
//
//        }

        for (int i = 1; i < links.size(); i++) {
            links.get(i).click();
            BrowserUtils.wait(500);
            driver.navigate().back();
            BrowserUtils.wait(500);
            links = driver.findElements(By.tagName("a"));
        }


        driver.quit();
    }
}
