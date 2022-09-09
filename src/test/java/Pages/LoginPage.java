package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    By usernameField = By.name("email");
    By passwordField = By.name("password");
    By submitButton = By.xpath("//button[text()=\"Log in\"]");

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);

    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);

    }
    public void clickSubmit(){
        driver.findElement(submitButton).click();

    }

}
