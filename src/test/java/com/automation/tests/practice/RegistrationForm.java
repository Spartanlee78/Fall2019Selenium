package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;

    private String firstNameLocator = "firstname";
    private By firstNameBy = By.name("firstname");

    private String lastNameLocator = "lastname";
    private By lastNameBy = By.name( "lastname");

    private By userNameBy = By.name("username");
    private By emailAddressBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBY = By.name("phone");

    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By birthdayBy = By.cssSelector("input[name='birthday']");

    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    private By cPlusPlusBy = By.xpath("//label[text()='C++]/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='Javascript']/preceding-sibling::input");

    private By signUpBy = By.id("wooden_spoon");







    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){

        driver.findElement(firstNameBy).sendKeys("Pat");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(userNameBy).sendKeys("testuser");
        driver.findElement(emailAddressBy).sendKeys("test.email.com");
        driver.findElement(passwordBy).sendKeys("12345");
        driver.findElement(phoneBY).sendKeys("231-231-0000");

        driver.findElement(maleBy).click();
        driver.findElement(birthdayBy).sendKeys("1/1/2000");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobtitleSelect = new Select(driver.findElement(jobTitleBy));
        jobtitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(4000);

        String expected = "You've sucessfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void verifyFirstNameLengthTest(){

        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3000);


        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long'"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }


    @Test
    public void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3000);
     //   WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters'"));
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }


}
