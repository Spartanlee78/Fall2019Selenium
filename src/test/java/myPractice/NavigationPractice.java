package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationPractice {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        Thread.sleep(3000);

        WebElement searchLine = driver.findElement(By.name("q"));
        searchLine.sendKeys("netflix", Keys.ENTER);
        Thread.sleep(3000);

        WebElement netFlixLogin = driver.findElement(By.linkText("Login"));
        netFlixLogin.click();

        Thread.sleep(3000);

        WebElement userName = driver.findElement(By.name("userLoginId"));
        userName.sendKeys("spartanlee78@gmail.com");



    }


}
