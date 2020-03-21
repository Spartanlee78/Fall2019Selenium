package myPractice.march_17;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallPageTests {

    private WebDriver driver;
    private By userNameBy = By.id("prependedInput");
    private  By passWordBy = By.id("prependedInput2");
    private Actions action;

    @BeforeMethod
    public void setUp (){
        driver = DriverFactory.createADriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        action = new Actions(driver);
        BrowserUtils.wait(2000);

        driver.findElement(userNameBy).sendKeys("salesmanager145");
        driver.findElement(passWordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(2000);

        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"))).perform();


    }

    @AfterMethod
    public void endTask () {
        if (!driver.equals(null)) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void Test1(){

    }







}
