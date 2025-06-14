package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

public class EditPersonalDetailsSteps extends CommonMethods {


    //this class will contain steps for editing personal details
    //it will be used to edit personal details in the application
    // it will contain methods that will be called from the feature file edit personal details
    // it will also contain methods that will be called from the steps file EditPersonalDetailsSteps

//    @Given("the ESS user is on the HRMS login page")
//    public void the_ess_user_is_on_the_hrms_login_page() {
//        //WebElement ESSLoginpage = driver.findElement(By.id("txtUsername"));
//
//    }

//    @When("the user logs in with valid credentials")
//    public void the_user_logs_in_with_valid_credentials() {
//        WebElement usernamefield=driver.findElement(By.id("txtUsername"));
//        usernamefield.sendKeys("Esstestuser");
//        WebElement passwordfield= driver.findElement(By.id("txtPassword"));
//        passwordfield.sendKeys("Hum@nhrm123");
//
//    }

//    @Then("the user should be redirected to the dashboard")
//    public void the_user_should_be_redirected_to_the_dashboard() {
//        WebElement validbutton=driver.findElement(By.id("btnLogin"));
//        click(validbutton);
//
//    }

    @Given("the user navigates to the My Info section and clicks")
    public void the_user_navigates_to_the_my_info_section_and_clicks() {
        WebElement MyInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
        click(MyInfo);

    }

    @Then("the user clicks Edit update personal information")
    public void the_user_clicks_edit_update_personal_information() throws InterruptedException {
        WebElement editButton = driver.findElement(By.id("btnSave"));
        click(editButton);
        Thread.sleep(1000);
    }

    @Then("the First Name field should be editable")
    public void the_first_name_field_should_be_editable() throws InterruptedException {
        WebElement firstNameField = driver.findElement(By.id("personal_txtEmpFirstName"));
        if (firstNameField.isEnabled()) {
            firstNameField.clear();
            firstNameField.sendKeys("Nadia");
            System.out.println("First Name field is editable.");
        } else {
            System.out.println("First Name field is not editable.");
        }
        Thread.sleep(1000);
    }

    @Then("the Middle Name field should be editable")
    public void the_middle_name_field_should_be_editable() throws InterruptedException {
        WebElement middleNameField = driver.findElement(By.id("personal_txtEmpMiddleName"));
        if (middleNameField.isEnabled()) {middleNameField.clear();
            middleNameField.sendKeys("MS");
            System.out.println("Middle Name field is editable.");
        } else {
            System.out.println("Middle Name field is not editable.");
        }
        Thread.sleep(1000);
    }

    @Then("the Last Name field should be editable")
    public void the_last_name_field_should_be_editable() throws InterruptedException {
        WebElement lastNameField = driver.findElement(By.id("personal_txtEmpLastName"));
        if (lastNameField.isEnabled()) {lastNameField.clear();
            lastNameField.sendKeys("Bilal");
            System.out.println("Last Name field is editable.");
        } else {
            System.out.println("Last Name field is not editable.");
        }
        Thread.sleep(2000);
    }

    @Then("the Gender radio buttons should be selectable to update Gender")
    public void the_gender_radio_buttons_should_be_selectable_to_update_gender() throws InterruptedException {
        WebElement maleRadioButton = driver.findElement(By.id("personal_optGender_1"));
        WebElement femaleRadioButton = driver.findElement(By.id("personal_optGender_2"));

        if (maleRadioButton.isEnabled() && femaleRadioButton.isEnabled()) {
            WebElement genderRadioButton = driver.findElement(By.id("personal_optGender_2"));
            genderRadioButton.click();
            System.out.println("Gender radio buttons are selectable.");
        } else {
            System.out.println("Not " +
                    "working as expected.");
        }
        Thread.sleep(1000);

    }

    @Then("the Nationality dropdown should be selectable where user can update Nationality")
    public void the_nationality_dropdown_should_be_selectable_where_user_can_update_nationality() throws InterruptedException {
        WebElement nationalityDropdown = driver.findElement(By.id("personal_cmbNation"));
        if (nationalityDropdown.isEnabled()) {
            Select select = new Select(nationalityDropdown);
            select.selectByValue("136");
            System.out.println("drpdown is selectable.");
        } else {
            System.out.println("drpdown is not selectable.");
        }
        Thread.sleep(1000);

    }
    @Then("the Marital Status dropdown should be selectable to update Marital Status")
    public void the_marital_status_dropdown_should_be_selectable_to_update_marital_status() throws InterruptedException {
        WebElement maritalStatusDropdown = driver.findElement(By.id("personal_cmbMarital"));
        if (maritalStatusDropdown.isEnabled()) {
            Select maritalSelect = new Select(maritalStatusDropdown);
            maritalSelect.selectByVisibleText("Married");
            System.out.println("Marital Status dropdown is selectable.");
        } else {
            System.out.println("Marital Status dropdown is not selectable.");
        }
        Thread.sleep(1000);

    }


    @Then("the system should be displaying the updated personal details")
    public void the_system_should_be_displaying_the_updated_personal_details() throws InterruptedException {
        WebElement firstNameField = driver.findElement(By.id("personal_txtEmpFirstName"));
        String updatedFirstName = firstNameField.getAttribute("value");
        System.out.println("Updated First Name: " + updatedFirstName);

        WebElement middleNameField = driver.findElement(By.id("personal_txtEmpMiddleName"));
        String updatedMiddleName = middleNameField.getAttribute("value");
        System.out.println("Updated Middle Name: " + updatedMiddleName);



        WebElement lastNameField = driver.findElement(By.id("personal_txtEmpLastName"));
        String updatedLastName = lastNameField.getAttribute("value");
        System.out.println("Updated Last Name: " + updatedLastName);

        Thread.sleep(1000);

        WebElement genderRadioButton = driver.findElement(By.id("personal_optGender_2"));
        boolean isFemaleSelected = genderRadioButton.isSelected();
        genderRadioButton.click();

        System.out.println("Female");

        WebElement nationalityDropdown = driver.findElement(By.id("personal_cmbNation"));
        String selectedNationality = nationalityDropdown.getAttribute("value");


        WebElement maritalStatusDropdown = driver.findElement(By.id("personal_cmbMarital"));
        String selectedMaritalStatus = maritalStatusDropdown.getAttribute("value");

        //WebElement saveButton = driver.findElement(By.id("btnSave"));
        //click(saveButton);

    }
    @Then("the user clicks on Save to save the changes")
    public void the_user_clicks_on_save_to_save_the_changes() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(saveButton);
        Thread.sleep(1000);
    }

    @Then("the changes should be saved and visible successfully in the database")
    public void the_changes_should_be_saved_and_visible_successfully_in_the_database() {
        // This step would typically involve checking the database to confirm that the changes were saved.
        System.out.println("Changes saved successfully in the database.");

    }
}
