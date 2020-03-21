package myPractice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {


    @Test
    public void test(){

        Assert.assertEquals("apple", "apple");
    }

    @Test(description = "Verifying title of practice website")
    public void verifyTitle(){
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle,"Title is wrong");

        driver.quit();
    }

    @Test
    public void test1(){
        String word1 = "java";
        String word2 = "java";

        Assert.assertEquals(word1,word2);
    }
}
