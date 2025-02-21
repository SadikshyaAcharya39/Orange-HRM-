import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
//        System.out.println(driver.getWindowHandle());

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windowIDs = driver.getWindowHandles();

        // Approach 1
       /*
        // Convert into ArrayList if it has less elements

        List<String> windowList = new ArrayList<>(windowIDs);
        String parentID = windowList.get(0);
        String childID = windowList.get(1);

        // Focus on parent window
//        System.out.println(driver.getTitle());

        // Switching
        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());

        */

        // Approach 2
        // Use looping statements if there are more elements

        for(String windowID: windowIDs){
            String title = driver.switchTo().window(windowID).getTitle();

//            if(title.equals("OrangeHRM")){
//                System.out.println(driver.getCurrentUrl());
//            }

//            System.out.println(driver.getCurrentUrl());
        }








    }
}
