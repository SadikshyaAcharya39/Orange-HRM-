import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class ClosingSpecificBrowserWindow {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
//        System.out.println(driver.getTitle());

        String mainWindow = driver.getWindowHandle();

        Set<String> windowIDs = driver.getWindowHandles();
        for(String windowID : windowIDs){
            // Capture the title of all browser windows
            String title = driver.switchTo().window(windowID).getTitle();
            System.out.println(title);

            if(title.equals("Human Resources Management Software | OrangeHRM")){
                driver.close();
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindow);

    }
}
