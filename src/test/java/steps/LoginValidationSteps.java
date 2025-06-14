package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginValidationSteps extends CommonMethods {
    @Given("the user is on the HRMS login page")
    public void the_user_is_on_the_hrms_login_page() {
        loginPage = new pages.LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));

        Assert.assertTrue("Login button is not visible!", loginPage.loginButton.isDisplayed());
    }
    @When("the user logs in with valid admin credentials")
    public void the_user_logs_in_with_valid_ess_credentials() {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("password"));
        loginPage.loginButton.click();
    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue("Login failed - Welcome message not visible", dashboardPage.welcomeMessage.isDisplayed());
        String expectedUrl = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("User is not on the dashboard!", expectedUrl, actualUrl);

    }
}
