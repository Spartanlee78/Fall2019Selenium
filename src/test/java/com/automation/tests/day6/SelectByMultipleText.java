package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByMultipleText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        BrowserUtils.wait(3000);

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //let's get all selected options

        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for (WebElement eachSelect : selectedLanguages) {
            System.out.println(eachSelect.getText());
        }
        BrowserUtils.wait(3000);

        languagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(2000);
        languagesSelect.deselectAll();














        BrowserUtils.wait(3000);
        driver.quit();
    }
}
