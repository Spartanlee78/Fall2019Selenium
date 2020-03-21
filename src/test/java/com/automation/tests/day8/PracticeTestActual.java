package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTestActual {

private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();

        ChromeOptions chromOptions = new ChromeOptions();
        chromOptions.setAcceptInsecureCerts(true);

        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest(){
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, "message in case of error")
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    @Test
    public void forgotPassWord(){

        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(1000);
        WebElement enterPW = driver.findElement(By.name("email"));
        enterPW.sendKeys("lucky15.cybertek@gmail.com", Keys.ENTER);
        String expected = "Your e-mail's been sent!";
       String actual = driver.findElement(By.name("confirmation_message")).getText();

       Assert.assertEquals(actual,expected, "confirmation is not valid");
    }

}
