package com.automation.tests.vyTrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By loginButtonBY = By.id("_submit");
    private By warningMessge = By.cssSelector("[class='alert alert-error'] > div");

    private String username = "storemanager85";
    private String password = "UserUser123";


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();

        ChromeOptions chromOptions = new ChromeOptions();
        chromOptions.setAcceptInsecureCerts(true);

        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        if ((driver != null)){
            // close driver
            driver.quit();
            // destroy driver
            driver = null;
        }
    }






    @Test (description = "verify that the warning message displays when user enters wrong name")
    public void loginPageTest(){

        driver.findElement(usernameBy).sendKeys("");
        driver.findElement(passwordBy).sendKeys("");
        driver.findElement(loginButtonBY).click();
        BrowserUtils.wait(2000);
        WebElement warningElement = driver.findElement(warningMessge);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password" ;
        String actual = warningElement.getText();
        assertEquals(expected,actual);
    }


    @Test(description = "login as store manager and verify")
    public void loginAsStoreManager (){

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5000);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(actual,expected,"page title is not correct");

    }





















}
