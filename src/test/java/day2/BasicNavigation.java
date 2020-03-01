package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(3000);

        String title = driver.getTitle();
        System.out.println("Tittle is : " + title);
        String expectedTitle = "Google";
        if (expectedTitle.equals(title)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        driver.close();

    }
}
