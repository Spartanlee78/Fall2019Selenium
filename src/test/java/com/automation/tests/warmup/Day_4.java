package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day_4 {
    public static void main(String[] args) {

      //  ebay();

        amazon();

    }

    public static void ebay(){

      WebDriver driver = DriverFactory.createADriver("chrome");
      driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("samsung earbuds" + Keys.ENTER);

        BrowserUtils.wait(2000);

        WebElement resultNumber = driver.findElement(By.className("srp-controls__count-heading"));
        String resultNum = resultNumber.getText();
        System.out.println(resultNum);

        BrowserUtils.wait(2000);

        driver.quit();
    }

    public static void amazon(){
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://www.amazon.com/");
        BrowserUtils.wait(2000);
        WebElement search_box = driver.findElement(By.id("twotabsearchtextbox"));
        search_box.sendKeys("ear buds" + Keys.ENTER);

        BrowserUtils.wait(2000);
        String title = driver.getTitle();

        System.out.println("Title contains: ear buds -> " + title.contains("ear buds"));
        BrowserUtils.wait(2000);

        driver.quit();
    }

    public static void wiki (){
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://www.wikipedia.org/");

        WebElement search_box = driver.findElement(By.id("searchInput"));
        search_box.sendKeys("selenium webdriver" + Keys.ENTER);

        String link = driver.getCurrentUrl();
        if (link.endsWith("Selenium_(software)")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

    }
}
