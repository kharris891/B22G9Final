package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.CommonMethods;


public class AddMembershipDetailsSteps extends CommonMethods {

    @Given("the user is on the HRMS login page")
    public void the_user_is_on_the_hrms_login_page() {
        Assert.assertTrue(isElementDisplayed(loginPage.usernameField));
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        sendText("admin", loginPage.usernameField);
        sendText("Hum@nhrm123", loginPage.passwordField);
        click(loginPage.loginButton);
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(isElementDisplayed(dashboardPage.));
    }

    @When("the employee navigates to the Contact Information section")
    public void the_employee_navigates_to_the_contact_information_section() {
        click.(employeeListPage.)
    }

    @Then("the following fields should be displayed and editable:")
    public void the_following_fields_should_be_displayed_and_editable(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }

    @Given("the employee is on the Contact Information section")
    public void the_employee_is_on_the_contact_information_section() {
        Assert.assertTrue(isElementDisplayed());
    }

    @When("the employee updates one or more of the contact information fields")
    public void the_employee_updates_one_or_more_of_the_contact_information_fields() {

    }

    @When("clicks the {string} button")
    public void clicks_the_button(String string) {
        click.
    }

    @Then("the system should validate the input")
    public void the_system_should_validate_the_input() {

    }

    @Then("the system should save the updated contact information")
    public void the_system_should_save_the_updated_contact_information() {

    }

    @Then("the updated fields should be reflected in the employee's profile")
    public void the_updated_fields_should_be_reflected_in_the_employee_s_profile() {

    }

    @Given("the employee enters invalid data in contact fields")
    public void the_employee_enters_invalid_data_in_contact_fields() {

    }

    @When("the employee clicks the {string} button")
    public void the_employee_clicks_the_button(String string) {

    }

    @Then("the system should display appropriate validation messages")
    public void the_system_should_display_appropriate_validation_messages() {

    }

    @Then("the information should not be saved until valid")
    public void the_information_should_not_be_saved_until_valid() {

    }

    @Given("the employee has previously saved contact information")
    public void the_employee_has_previously_saved_contact_information() {

    }

    @Then("all saved details should be displayed in the respective fields")
    public void all_saved_details_should_be_displayed_in_the_respective_fields() {

    }

    @Given("the employee has saved updated contact information")
    public void the_employee_has_saved_updated_contact_information() {

    }

    @Then("the changes should be shown in the database correctly")
    public void the_changes_should_be_shown_in_the_database_correctly() {

    }
}
