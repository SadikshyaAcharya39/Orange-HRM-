import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ExplicitWaitDemo {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Declaration

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebElement txtUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        txtUsername.sendKeys("Admin");

        WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        txtPassword.sendKeys("admin123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();


        //        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");



    }
}
