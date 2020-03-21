package myPractice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class DriverFactoryTest {
    public static void main(String[] args) throws Exception{
      WebDriver driver =  DriverFactory.createADriver("edge");
        driver.get("https://bing.com");

        Thread.sleep(3000);

        driver.quit();

        WebDriver chromeDriver = DriverFactory.createADriver("chrome");
        chromeDriver.get("https://www.google.com");

        Thread.sleep(3000);

        chromeDriver.quit();

        WebDriver foxDriver = DriverFactory.createADriver("firefox");
        foxDriver.get("https://www.mozilla.org");
        Thread.sleep(6000);

        foxDriver.quit();
    }
}
