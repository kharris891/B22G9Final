package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import java.time.Duration;

public class PhotographPageSteps extends CommonMethods {

//    @Given("I am logged in as an ESS user with valid credentials")
//    public void i_am_logged_in_as_an_ess_user_with_valid_credentials() {
//        String username = ConfigReader.read("essUsername");
//        String password = ConfigReader.read("essPassword");
//        sendText(username,loginPage.usernameField);
//        sendText(password,loginPage.passwordField);
//        click(loginPage.loginButton);
//    }

    @Given("I navigate to the My Info tab")
    public void i_navigate_to_the_my_info_tab() throws InterruptedException {
        click(dashboardPage.myInfoTab);
    }

    @Given("I click on the profile picture section")
    public void i_click_on_the_profile_picture_section() {
        click(personalDetailsPage.profilePictureImg);
    }

    @When("I upload a valid image {string} \\(200x200px, <1MB)")
    public void i_upload_a_valid_image_200x200px_1mb(String string) throws InterruptedException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\mario_resized.jpeg";
        photographPage.photoFileInput.sendKeys(filePath);
        click(photographPage.uploadButton);
    }

    @Then("the system should accept the upload")
    public void the_system_should_accept_the_upload() {
        // 1. verify the appearance of success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(photographPage.uploadSuccessMessage));
    }

    @Then("I should see the success message {string}")
    public void i_should_see_the_success_message(String string) {
        String successMessage = photographPage.uploadSuccessMessage.getText().trim();
        Assert.assertEquals(successMessage, "Successfully Uploaded\n" + "Close");
    }

    @Then("my profile should display the updated picture")
    public void my_profile_should_display_the_updated_picture() {
        // Verify image preview updated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeContains(personalDetailsPage.profilePictureImg, "src", "default")
        ));

        Assert.assertTrue(personalDetailsPage.profilePictureImg.isDisplayed());
    }

    @When("I upload a valid PNG image {string} \\(200x200px, <1MB)")
    public void i_upload_a_valid_png_image_200x200px_1mb(String string) {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\minion_resized.png";
        photographPage.photoFileInput.sendKeys(filePath);
        click(photographPage.uploadButton);
    }

    @When("I upload a valid GIF image {string} \\(200x200px, <1MB)")
    public void i_upload_a_valid_gif_image_200x200px_1mb(String string) {
        click(personalDetailsPage.profilePictureImg);
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\cat.gif";
        photographPage.photoFileInput.sendKeys(filePath);
        click(photographPage.uploadButton);
    }


}
