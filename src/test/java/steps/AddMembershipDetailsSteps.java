package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.CommonMethods;
import java.util.List;
import java.util.Map;


public class AddMembershipDetailsSteps extends CommonMethods {

//    @Given("the user is on the HRMS login page")
//    public void the_user_is_on_the_hrms_login_page() {
//        String expectedUrl = ConfigReader.read("url");
//        String actualUrl = driver.getCurrentUrl();
//        org.junit.Assert.assertEquals("User is not on the HRMS login page!", expectedUrl, actualUrl);
//        org.junit.Assert.assertTrue("Login button is not visible!", loginPage.loginButton.isDisplayed());
//    }

//    @When("the ess user logs in with valid credentials")
//    public void the_user_logs_in_with_valid_credentials() {
//        loginPage.usernameField.sendKeys(ConfigReader.read("essUsername"));
//        loginPage.passwordField.sendKeys(ConfigReader.read("essPassword"));
//        loginPage.loginButton.click();
//    }

//    @Then("the user should be directed to the dashboard")
//    public void the_user_should_be_redirected_to_the_dashboard() {
//        WebElement dashboardElement = driver.findElement(By.xpath("//*[text()='Dashboard']"));
//        Assert.assertTrue(dashboardElement.isDisplayed());
//    }

    @When("the employee navigates to the Contact Information section")
    public void the_employee_navigates_to_the_contact_information_section() {
        contactDetailsPage.myInfo.click();
        contactDetailsPage.contactDetails.click();
    }

    @Then("the following fields should be displayed and editable:")
    public void the_following_fields_should_be_displayed_and_editable(DataTable dataTable) {
        contactDetailsPage.saveBtn.click();
        List<Map<String, String>> fields = dataTable.asMaps(String.class, String.class);

        Map<String, By> fieldLocators = Map.of(
                "Address Street 1", By.id("contact_street1"),
                "Address Street 2", By.id("contact_street2"),
                "City", By.id("contact_city"),
                "State", By.id("contact_province"),
                "Zip Code", By.id("contact_emp_zipcode"),
                "Country", By.id("contact_country"),
                "Home Phone", By.id("contact_emp_hm_telephone"),
                "Mobile Phone", By.id("contact_emp_mobile"),
                "Work Phone", By.id("contact_emp_work_telephone"),
                "Work Email", By.id("contact_emp_work_email")
        );

        for (Map<String, String> row : fields) {
            String fieldName = row.get("Field");
            String fieldType = row.get("Type");

            if (!fieldLocators.containsKey(fieldName)) {
                Assert.fail("Locator not defined for field: " + fieldName);
            }

            WebElement element = driver.findElement(fieldLocators.get(fieldName));

            // check visibility
            Assert.assertTrue(element.isDisplayed(), "Field '" + fieldName + "' is not displayed");

            // Check editability
            if (fieldType.equalsIgnoreCase("Textbox") || fieldType.equalsIgnoreCase("Dropdown")) {
                Assert.assertTrue(element.isEnabled(), "Field '" + fieldName + "' is not editable");
            } else {
                Assert.fail("Unknown field type: " + fieldType);
            }
        }

    }

    @Given("the employee is on the Contact Information section")
    public void the_employee_is_on_the_contact_information_section() {
        contactDetailsPage.myInfo.click();
        waitForElementToBeClickAble(contactDetailsPage.contactDetails);
        contactDetailsPage.contactDetails.click();
    }

    @When("the employee updates one or more of the contact information fields")
    public void the_employee_updates_one_or_more_of_the_contact_information_fields() {
        contactDetailsPage.saveBtn.click();
        sendText("123 Main Ave", contactDetailsPage.add1);
        sendText("123-456-7890", contactDetailsPage.tele);
    }

    @When("clicks the {string} button")
    public void clicks_the_button(String Save) {
        contactDetailsPage.saveBtn.click();
    }

    @Then("the system should save the updated contact information")
    public void the_system_should_save_the_updated_contact_information() {
        String enteredValue1 = contactDetailsPage.add1.getAttribute("value");
        Assert.assertEquals(enteredValue1, "123 Main Ave");
        String enteredValue2 = contactDetailsPage.tele.getAttribute("value");
        Assert.assertEquals(enteredValue2, "123-456-7890");
    }

    @Given("the employee enters invalid data in contact fields")
    public void the_employee_enters_invalid_data_in_contact_fields() {
        waitForElementToBeClickAble(contactDetailsPage.contactDetails);
        contactDetailsPage.contactDetails.click();
        contactDetailsPage.saveBtn.click();
        waitForElementToBeClickAble(contactDetailsPage.tele);
        contactDetailsPage.tele.clear();
        sendText("abcdef", contactDetailsPage.tele);
    }

    @When("the employee clicks the {string} button")
    public void the_employee_clicks_the_button(String Save) {
        contactDetailsPage.saveBtn.click();
    }

    @Then("the system should display appropriate validation messages")
    public void the_system_should_display_appropriate_validation_messages() {
        //WebElement errormsg = driver.findElement(By.xpath("//*[text()='Allows numbers and only + - / ( )']"));
        String errorText = contactDetailsPage.errormsg.getText();
        Assert.assertEquals(errorText,contactDetailsPage.errormsg);
    }

    @Then("the information should not be saved until valid")
    public void the_information_should_not_be_saved_until_valid() {
        //WebElement tele = driver.findElement(By.id("contact_emp_hm_telephone"));
        sendText("123-456-7890", contactDetailsPage.tele);
        waitForElementToBeClickAble(contactDetailsPage.saveBtn);
        contactDetailsPage.saveBtn.click();
    }

    @Given("the employee has previously saved contact information")
    public void the_employee_has_previously_saved_contact_information() {
        contactDetailsPage.myInfo.click();
        contactDetailsPage.contactDetails.click();
    }

    @Then("all saved details should be displayed in the respective fields")
    public void all_saved_details_should_be_displayed_in_the_respective_fields() {
        //String enteredValue1 = driver.findElement(By.id("contact_street1")).getAttribute("value");
        String enteredValue1 = contactDetailsPage.add1.getAttribute("value");
        Assert.assertEquals(enteredValue1, "123 Main Ave");
        //String enteredValue2 = driver.findElement(By.id("contact_emp_hm_telephone")).getAttribute("value");
        String enteredValue2 = contactDetailsPage.tele.getAttribute("value");
        Assert.assertEquals(enteredValue2, "123-456-7890");
    }


}
