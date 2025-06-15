package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class DependentSteps extends CommonMethods {

    @Given("the employee opens the Dependents section")
    public void the_employee_opens_the_dependents_section() {
        navigateToDependentsTab();
    }

    @When("the employee clicks on Add Dependent")
    public void the_employee_clicks_on_add_dependent() {
        click(dependentsPage.addDependentButton);
    }

    @When("the employee enters {string} in the Name field")
    public void the_employee_enters_in_the_name_field(String name) {
        sendText(name, dependentsPage.nameField);
    }

    @When("the employee selects {string} from the Relationship dropdown")
    public void the_employee_selects_from_the_relationship_dropdown(String relationship) {
        selectFromDropDown(dependentsPage.relationshipDropdown, relationship);
    }

    @When("the employee selects {string} from the Date of Birth field")
    public void the_employee_selects_from_the_date_of_birth_field(String dob) {
        sendText(dob, dependentsPage.dateOfBirthField);
    }

    @When("the employee clicks the Save button")
    public void the_employee_clicks_the_save_button() {
        click(dependentsPage.saveButton);
        takeScreenshot("AfterSavingDependent");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
    }


    @Then("the new dependent {string} should appear in the dependents list")
    public void the_new_dependent_should_appear_in_the_dependents_list(String name) {
        boolean displayed = dependentsPage.getDependentRowByName(name).isDisplayed();
        assert displayed;
    }

    @Then("an error message {string} should be displayed near the Name field")
    public void an_error_message_should_be_displayed_near_the_name_field(String errorMessage) {
        String actualMessage = dependentsPage.nameErrorMessage.getText();
        assert actualMessage.equals(errorMessage);
    }

    @When ("the employee click on the checkbox next to {string}")
    public void the_employee_clicks_on_the_checkbox_next_to(String name){
        click(driver.findElement(By.name("chkdependentdel[]")));
    }

    @When("the employee clicks Remove next to {string}")
    public void the_employee_clicks_remove_next_to(String name) {
        click(driver.findElement(By.id("delDependentBtn")));
    }


    @Then("{string} should no longer appear in the dependents list")
    public void should_no_longer_appear_in_the_dependents_list(String name) {
        boolean exists = isElementPresent("//table[@id='dependent_list']//a[text()='John Doe']");
        assert !exists;
    }
}



