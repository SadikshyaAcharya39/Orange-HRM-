package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    // Catch the drivers

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    public By dashboardTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");



    // Methods


}
