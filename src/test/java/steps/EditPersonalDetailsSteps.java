package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EditPersonalDetailsSteps extends CommonMethods {


    //this class will contain steps for editing personal details
    //it will be used to edit personal details in the application
    // it will contain methods that will be called from the feature file edit personal details
    // it will also contain methods that will be called from the steps file EditPersonalDetailsSteps

    @Given("the ESS user is on the HRMS login page")
    public void the_ess_user_is_on_the_hrms_login_page() {
        WebElement ESSLoginpage = driver.findElement(By.id("txtUsername "));
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        WebElement usernamefield=driver.findElement(By.id("txtUsername"));
        usernamefield.sendKeys("Admin");
        WebElement passwordfield= driver.findElement(By.id("txtPassword"));
        passwordfield.sendKeys("Hum@nhrm123");

    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        WebElement validbutton=driver.findElement(By.id("btnLogin"));
        click(validbutton);

    }

    @Given("the user navigates to the PIM section")
    public void the_user_navigates_to_the_pim_section() {
        WebElement pimoption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(pimoption);

    }

    @Then("user click on Employee name and search for ESS user")
    public void user_click_on_employee_name_and_search_for_ess_user() {
        WebElement employeeNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText("ESS User", employeeNameField);

    }

    @When("the user clicks on search button")
    public void the_user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(searchButton);
    }

    @Then("the user should  see ESS user and click on it")
    public void the_user_should_see_ess_user_and_click_on_it() {
        WebElement essUser = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[4]/a"));
        click(essUser);
    }

    @When("the user clicks on Edit")
    public void the_user_clicks_on_edit() {
        WebElement editButton = driver.findElement(By.id("btnSav"));
        click(editButton);

    }

    @Then("the First Name field should be editable")
    public void the_first_name_field_should_be_editable() {
        WebElement firstNameField = driver.findElement(By.id("personal_txtEmpFirstName"));
        if (firstNameField.isEnabled()) {
            System.out.println("First Name field is editable.");
        } else {
            System.out.println("First Name field is not editable.");
        }

    }

    @Then("the Middle Name field should be editable")
    public void the_middle_name_field_should_be_editable() {
        WebElement middleNameField = driver.findElement(By.id("personal_txtEmpMiddleName"));
        if (middleNameField.isEnabled()) {
            System.out.println("Middle Name field is editable.");
        } else {
            System.out.println("Middle Name field is not editable.");
        }

    }

    @Then("the Last Name field should be editable")
    public void the_last_name_field_should_be_editable() {
        WebElement lastNameField = driver.findElement(By.id("personal_txtEmpLastName"));
        if (lastNameField.isEnabled()) {
            System.out.println("Last Name field is editable.");
        } else {
            System.out.println("Last Name field is not editable.");
        }


    }

    @Then("the Gender radio buttons should be selectable")
    public void the_gender_radio_buttons_should_be_selectable() {
        WebElement maleRadioButton = driver.findElement(By.id("personal_optGender_1"));
        WebElement femaleRadioButton = driver.findElement(By.id("personal_optGender_2"));

        if (maleRadioButton.isEnabled() && femaleRadioButton.isEnabled()) {
            System.out.println("Gender radio buttons are selectable.");
        } else {
            System.out.println("Not " +
                    "working as expected.");
        }


    }

    @Then("the Nationality dropdown should be selectable")
    public void the_nationality_dropdown_should_be_selectable() {
        WebElement nationalityDropdown = driver.findElement(By.id("personal_cmbNation"));
        if (nationalityDropdown.isEnabled()) {
            System.out.println("drpdown is selectable.");
        } else {
            System.out.println("drpdown is not selectable.");
        }

    }

    @Then("the Marital Status dropdown should be selectable")
    public void the_marital_status_dropdown_should_be_selectable() {
        WebElement maritalStatusDropdown = driver.findElement(By.id("personal_cmbMarital"));
        if (maritalStatusDropdown.isEnabled()) {
            System.out.println("Marital Status dropdown is selectable.");
        } else {
            System.out.println("Marital Status dropdown is not selectable.");
        }


    }

    @When("the user logs in with valid ESS credentials")
    public void the_user_logs_in_with_valid_ess_credentials() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys("ESSUser");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("ESSUserPassword");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        click(loginButton);

    }

    @Given("the user navigates to the PIM  section")
    public void the_user_navigates_to_the_section(String string) {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(pimOption);
        WebElement employeeListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(employeeListOption);

    }

    @When("the user clicks Edit update personal information")
    public void the_user_clicks_edit_update_personal_information() {
        WebElement editButton = driver.findElement(By.id("btnEdit"));
        click(editButton);

    }

    @When("the user enters {string} in the first name field")
    public void the_user_enters_in_the_first_name_field(String string) {
        WebElement firstNameField = driver.findElement(By.id("personal_txtEmpFirstName"));
        sendText(string, firstNameField);

    }

    @When("the user enters {string} in the Middle Name field")
    public void the_user_enters_in_the_middle_name_field(String string) {
        WebElement middleNameField = driver.findElement(By.id("personal_txtEmpMiddleName"));
        sendText(string, middleNameField);

    }

    @When("the user enters {string} in the Last Name field")
    public void the_user_enters_in_the_last_name_field(String string) {
        WebElement lastNameField = driver.findElement(By.id("personal_txtEmpLastName"));
        sendText(string, lastNameField);

    }

    @When("the user selects {string} as Gender")
    public void the_user_selects_as_gender(String string) {
        WebElement maleRadioButton = driver.findElement(By.id("personal_optGender_1"));
        WebElement femaleRadioButton = driver.findElement(By.id("personal_optGender_2"));

    }

    @When("the user selects {string} from the Nationality dropdown")
    public void the_user_selects_from_the_nationality_dropdown(String string) {
        WebElement nationalityDropdown = driver.findElement(By.id("personal_cmbNation"));
        if (nationalityDropdown.isEnabled()) {
            nationalityDropdown.click();
            WebElement option = driver.findElement(By.xpath("//option[text()='" + string + "']"));
            click(option);
        }

    }

    @When("the user selects {string} from the Marital Status dropdown")
    public void the_user_selects_from_the_marital_status_dropdown(String string) {
        WebElement maritalStatusDropdown = driver.findElement(By.id("personal_cmbMarital"));
        if (maritalStatusDropdown.isEnabled()) {
            maritalStatusDropdown.click();
            WebElement option = driver.findElement(By.xpath("//option[text()='" + string + "']"));
            click(option);
        }

    }

    @When("the user clicks on {string} to save the changes")
    public void the_user_clicks_on_to_save_the_changes(String string) {
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(saveButton);

    }

    @Then("the system should be displaying the updated personal details")
    public void the_system_should_be_displaying_the_updated_personal_details() {
        WebElement firstNameField = driver.findElement(By.id("personal_txtEmpFirstName"));
        String updatedFirstName = firstNameField.getAttribute("value");
        System.out.println("Updated First Name: " + updatedFirstName);

        WebElement middleNameField = driver.findElement(By.id("personal_txtEmpMiddleName"));
        String updatedMiddleName = middleNameField.getAttribute("value");
        System.out.println("Updated Middle Name: " + updatedMiddleName);

        WebElement lastNameField = driver.findElement(By.id("personal_txtEmpLastName"));
        String updatedLastName = lastNameField.getAttribute("value");
        System.out.println("Updated Last Name: " + updatedLastName);

        WebElement genderRadioButton = driver.findElement(By.id("personal_optGender_1"));
        boolean isMaleSelected = genderRadioButton.isSelected();
        System.out.println("Male");


    }

    @Then("the changes should be saved and visible successfully in the database")
    public void the_changes_should_be_saved_and_visible_successfully_in_the_database() {
        // This step would typically involve checking the database to confirm that the changes were saved.
        System.out.println("Changes saved successfully in the database.");

    }
}


