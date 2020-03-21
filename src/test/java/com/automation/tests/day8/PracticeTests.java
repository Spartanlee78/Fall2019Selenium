package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {

    private WebDriver driver;



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }




    @Test
    public void loginTest (){

        driver.navigate().to("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(1000);
        String user = "tomsmith";
        String pw = "SuperSecretPassword";

        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pw);
        driver.findElement(By.id("wooden_spoon")).click();

        }
    }

