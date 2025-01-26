import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.DashboardPage;
import pageobject.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class DashboardTest {
    private WebDriver driver;
    private Properties properties;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Load properties
        try (InputStream is = new FileInputStream("application.properties")) {
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get(properties.getProperty("baseURL"));
        loginPage = new LoginPage(driver);
        loginPage.loginToApp(properties.getProperty( "correctUsername"), properties.getProperty("correctPassword"));
        dashboardPage = new DashboardPage(driver);
    }

    @AfterEach
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

    @Test
    public void landingOnDashboardPage(){
        WebElement dashboardTitle = driver.findElement(dashboardPage.dashboardTitle);
        Assertions.assertEquals("Dashboard", dashboardTitle.getText().trim(), "Dashboard title is not displayed.");
    }


//    @Test
//    public void


}
