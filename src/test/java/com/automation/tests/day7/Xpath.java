package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

   public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
   public static String userPassword = "//label[text()='Password']/following-sibling::input";
   public static String loginButton = "//button[contains(text(), 'Log')]";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        BrowserUtils.wait(2000);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomSmith");
        driver.findElement(By.xpath(userPassword)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginButton)).click();








        BrowserUtils.wait(2000);
        driver.quit();




    }
}
