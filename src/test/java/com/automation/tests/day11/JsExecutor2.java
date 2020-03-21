package com.automation.tests.day11;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsExecutor2 {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void verifyTitle(){
        String expected = "practice";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actual = (String) js.executeScript("return document.title");

        Assert.assertEquals(actual,expected);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));

        js.executeScript("arguments[0].click()",button6 );

        BrowserUtils.wait(2000);

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(),"Now it's gone!");
    }

    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3000);

        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].setAttribute('value','tomsmith')",userName);
        js.executeScript("arguments[0].setAttribute('value',SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginButton);

        BrowserUtils.wait(2000);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subHeader = js .executeScript("return document.getEmementsByClassName('subheader'[0].textContent").toString();

    }

    public void scrollTOElement(){
        BrowserUtils.wait(2000);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIontoView(true)", link);
    }

    public void scrollTest(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 15; i++) {
            BrowserUtils.wait(1000);
            js.executeScript("window.scrollBy(0,1000)");
        }
        js.executeScript("window.scrollBy(0,1000)");
    }
}

