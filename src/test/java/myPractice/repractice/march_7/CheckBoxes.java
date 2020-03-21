package myPractice.repractice.march_7;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxes {

    private WebDriver driver;

    @BeforeMethod
    public void setUp (){

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(1000);

    }

    @AfterMethod
    public void endTask(){
        driver.quit();
    }

    @Test
    public void checkTest1(){

       BrowserUtils.wait(2000);
    }




}
