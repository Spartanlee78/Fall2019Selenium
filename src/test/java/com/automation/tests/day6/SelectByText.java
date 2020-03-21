package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        BrowserUtils.wait(3000);

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropDown = new Select(simpleDropDown);
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3000);
        selectSimpleDropDown.selectByVisibleText("Option 1");


        //

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("March");
        selectYear.selectByVisibleText("2003");

        //select all months one by one

        List<WebElement> months = selectMonth.getOptions();

        for (WebElement month : months) {
            String monthName = month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1000);
        }

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District of Colombia");

        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District of Columbia")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement stateOption : states) {
            System.out.println(stateOption.getText());
        }








        BrowserUtils.wait(3000);
        driver.quit();
    }
}
