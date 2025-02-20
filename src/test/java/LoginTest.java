import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.DashboardPage;
import pageobject.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

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
public void verifyingLinkedinIcon() {
    // Click on the LinkedIn icon
    driver.findElement(loginPage.linkedInIcon).click();

    // Store the original window handle
    String originalWindow = driver.getWindowHandle();

    // Wait for the new window/tab to open
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(driver -> driver.getWindowHandles().size() > 1);

    // Switch to the new tab
    for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(originalWindow)) {
            driver.switchTo().window(windowHandle);
            break;
        }
    }

    // Debug: Check if the new tab is opened correctly
    System.out.println("Switched to new window/tab");

    // Wait for the URL of the new tab to load
    wait.until(driver -> !driver.getCurrentUrl().equals("about:blank"));

    // Debug: Print the current URL
    String currentURL = driver.getCurrentUrl();
    System.out.println("Current URL: " + currentURL);

    // Verify the URL contains 'linkedin.com'
    Assertions.assertTrue(currentURL.contains("linkedin.com"), "URL does not contain linkedin.com");

    // Close the new tab and switch back to the original window
    driver.close();
    driver.switchTo().window(originalWindow);
}

@Test
    public void verifyingFacebookIcon(){
    // Click on the Facebook icon
    driver.findElement(loginPage.facebookIcon).click();

    // Store the original window handle
    String originalWindow = driver.getWindowHandle();

    // Wait for the new window/tab to open
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(driver -> driver.getWindowHandles().size() > 1);

    // Switch to the new tab
    for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(originalWindow)) {
            driver.switchTo().window(windowHandle);
            break;
        }
    }

    // Debug: Check if the new tab is opened correctly
    System.out.println("Switched to new window/tab");

    // Wait for the URL of the new tab to load
    wait.until(driver -> !driver.getCurrentUrl().equals("about:blank"));

    // Debug: Print the current URL
    String currentURL = driver.getCurrentUrl();
    System.out.println("Current URL: " + currentURL);

    // Verify the URL contains 'linkedin.com'
    Assertions.assertTrue(currentURL.contains("facebook.com"), "URL does not contain facebook.com");

    // Close the new tab and switch back to the original window
    driver.close();
    driver.switchTo().window(originalWindow);
    }


    /*
    @Test
    public void verifyingTwitterIcon(){
        driver.findElement(loginPage.twitterIcon).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedCondition.numberOfWindowsToBe(2));

        String expectedURL = properties.getProperty("twitterURL");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, currentURL, "URL does not contain twitter.com");

//        String originalWindow = driver.getWindowHandle();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(driver -> driver.getWindowHandles().size()>1);
//
//        for(String windowHandle: driver.getWindowHandles()) {
//            if (!windowHandle.equals(originalWindow)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//
//            wait.until(driver -> !driver.getCurrentUrl().equals("about:blank"));
//            String currentURL = driver.getCurrentUrl();
//            Assertions.assertTrue(currentURL.contains("twitter.com"), "URL does not contain twitter.com.");
//
//            driver.close();
//            driver.switchTo().window(originalWindow);

    }

     */


    @Test
    public void verifyingTwitterIcon(){
//        driver.getWindowHandle();
        driver.findElement(loginPage.twitterIcon).click();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
    }


}



