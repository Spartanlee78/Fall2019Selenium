package OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SeliniumOH1 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator i1 = keysToSearch.iterator();

        while (i1.hasNext()){
            System.out.println(i1.next());
        }

        System.out.println("--------------------------------");

        // locators in Selenium
        /*
        id
        class - classname
        name
        tag
        linkText
        partial linktext

        css
        xpath

        -----------------------------------------------

        <input id="global-enhancements-search-query" data-id="search-query"
        data-global-enhancements-search-input="" type="text" name="search_query"
        class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7"
         placeholder="Search for items or shops" value="" autocomplete="off" autocorrect="off" autocapitalize="off">


         tag == input
         key == "value" - attributes
         id == global-enhancements-search-query
         name == search_query
         class = wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7
         */

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);

        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));

        searchBar.sendKeys("bags");
        searchBar.click();

    }
}
