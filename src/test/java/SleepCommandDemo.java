import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPage;

public class SleepCommandDemo {
    private static LoginPage loginPage;

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

    }
}
