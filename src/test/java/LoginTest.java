import dev.failsafe.internal.util.Assert;
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

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private Properties properties;
    private DashboardPage dashboardPage;

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

        driver.get(properties.getProperty("baseURL"));

//         Implicitly Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Sending driver to the LoginPage
        loginPage = new LoginPage(driver);

        // Sending driver to the HomePage


    }

    @AfterEach
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

    @Test
    public void displayingLoginPage(){
        String title = driver.getTitle();
        Assertions.assertEquals("OrangeHRM", title, "Title is not displayed.");
    }

    @Test
    public void testWithIncorrectUsernameIncorrectPassword(){
        loginPage.loginToApp("incorrectUsername", "incorrectPassword");
        loginPage.displayErrorMessage();
    }

    @Test
    public void testWithBlankUsernameBlackPassword(){
        loginPage.loginToApp("", "");
        WebElement requiredField = driver.findElement(loginPage.requiredField);
        Assertions.assertTrue(requiredField.isDisplayed(), "Required error message is not displayed.");

    }

    @Test
    public void testWithIncorrectUsernameCorrectPassword(){
        loginPage.loginToApp("incorrectUsername", "correctPassword");
        loginPage.displayErrorMessage();
    }

    @Test
    public void testWithCorrectUsernameIncorrectPassword(){
        loginPage.loginToApp("correctUsername", "IncorrectPassword");
        loginPage.displayErrorMessage();
    }

    @Test
    public void verifyingLinkedinIcon(){
        driver.findElement(loginPage.linkedInIcon).click();
        String originalWindow = driver.getWindowHandle();
        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(originalWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        // Verify the URL of the new tab
        String currentURL = driver.getCurrentUrl();
        Assertions.assertTrue(currentURL.contains("linked.com"), "URL does not contain linkedin.com");
    }
}
