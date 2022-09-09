package WebStepDefinations;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver = null;
    Pages.LoginPage loginPage;
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        driver.navigate().to("https://dashboard.xendit.co/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
    }

    @When("user enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        loginPage.clickSubmit();
    }

    @Then("user is nvaigated to home pages")
    public void userIsNvaigatedToHomePages() {
        driver.getCurrentUrl();
        System.out.println(driver.getTitle());
    }
}
