package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(2000);

        String title = driver.getTitle();
        System.out.println("Tittle is : " + title);
        String expectedTitle = "Google";
        if (expectedTitle.equals(title)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        driver.navigate().to("http://Amazon.com");
        Thread.sleep(2000);
        verifyEquals(driver.getTitle(), "Amazon");

        System.out.println(driver.getTitle());

        driver.navigate().back();
        Thread.sleep(2000);



        driver.close();

    }

    public static void verifyEquals (String arg1, String arg2){

        if (arg1.equals(arg2)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
    }
}
