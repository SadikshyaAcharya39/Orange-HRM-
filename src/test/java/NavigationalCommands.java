import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationalCommands {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new FirefoxDriver();

        // Accepts URL only in String format
//        driver.get("https://www.nopcommerce.com/en");

//        driver.navigate().to("https://www.nopcommerce.com/en");

        // Accept URL in String format and also accepts URL in URL object format


//        URL myURL = new URL("https://www.nopcommerce.com/en");
//        driver.navigate().to(myURL);


        driver.navigate().to("https://www.nopcommerce.com/en");
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();
        driver.close();


    }
}
