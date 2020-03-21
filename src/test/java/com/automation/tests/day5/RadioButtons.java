package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2000);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton : radioButtons ){

            String id = radioButton.getAttribute("id");

            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected ? " + isSelected);

            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("clicked on : : " + id);

                BrowserUtils.wait(1000);

            }else {
                System.out.println("button is disabled, not clicked :: " + id );
            }
            System.out.println();
        }





        driver.quit();
    }
}
