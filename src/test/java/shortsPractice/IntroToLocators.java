package shortsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IntroToLocators {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com");

        WebElement searchTextInput = driver.findElement(By.name("q"));
        searchTextInput.sendKeys("amazon");
        WebElement btn1 = driver.findElement(By.name("btnI"));
        btn1.click();
        Thread.sleep(3000);


        driver.close();

       // WebElement idElement = driver.findElement();
    }
}
