package pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Catching the driver
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    public By loginText = By.xpath("//h5[normalize-space()='Login']");
    public By usernameTextfield = By.xpath("//input[@name='username']");
    public By passwordTextfield = By.xpath("//input[@name='password']");
    public By loginButton = By.xpath("//button[@type='submit']");
    public By requiredField = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    public By errorMessage = By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']");
    public By forgotPasswordText = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    public By linkedInIcon = By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']");
    public By facebookIcon = By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']");
    public By twitterIcon = By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']");
    public By youtubeIcon = By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']");
    public By linkedText = By.xpath("//a[normalize-space()='OrangeHRM, Inc']");

    // Methods
    public void loginToApp(String username, String password){
        driver.findElement(usernameTextfield).sendKeys(username);
        driver.findElement(passwordTextfield).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void displayErrorMessage(){
        WebElement dashboardPageDisplay = driver.findElement(errorMessage);
        Assertions.assertTrue(dashboardPageDisplay.isDisplayed(), "Dashboard page is not displayed.");
    }
}
