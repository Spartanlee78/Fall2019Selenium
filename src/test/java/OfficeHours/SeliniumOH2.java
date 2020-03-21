package OfficeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeliniumOH2 {
    public static void main(String[] args) {

        // go to http://automationpractice.com
        // search for "tshirt in the search box

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://automationpractice.com");
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        search_box.sendKeys("tshirt" + Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();

        System.out.println(errorText);

        search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear();
        search_box.sendKeys("t-shirt" + Keys.ENTER);

        BrowserUtils.wait(3000);

        WebElement confirm = driver.findElement(By.className("product-count"));
       String ctext = confirm.getText();
        System.out.println( ctext);




        BrowserUtils.wait(3000);

        driver.quit();



    }
}
