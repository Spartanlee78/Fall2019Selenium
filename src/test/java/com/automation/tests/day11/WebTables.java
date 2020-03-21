package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void getColumnNames(){

        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        for (WebElement eachColumnName : columnNames){
            System.out.println(eachColumnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);
    }

    public void verifyRowCount(){

        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));

        Assert.assertEquals(rows.size(),4);
    }


}
