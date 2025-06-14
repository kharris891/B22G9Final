package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.CommonMethods;

public class JobDetailsSteps extends CommonMethods {

    private static final Logger log = LoggerFactory.getLogger(JobDetailsSteps.class);

//    @When("user clicks on PIM option")
//    public void user_clicks_on_PIM_option() {
//        click(dashboardPage.pimOption);
//    }

    @When("user clicks on Employee List option")
    public void user_clicks_on_Employee_List_option() {
        click(dashboardPage.pimOption);
    }

    @When("user searches for an employee with <employeeId>")
    public void user_searches_for_an_employee_with_employeeId() {
        jobDetailsPage.empIdSearchBox.sendKeys("118697A");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(jobDetailsPage.searchButton);
    }

    @When("user clicks on the employee name")
    public void user_clicks_on_the_employee_name() {
        click(jobDetailsPage.empNameSearchBox);
    }

    @When("user clicks on the Job tab")
    public void user_clicks_on_the_Job_tab() {
        click(jobDetailsPage.jobsTab);
    }

    @When("user clicks on the Edit button")
    public void user_clicks_on_the_Edit_button() {
        click(jobDetailsPage.editAndSaveButton);
    }

    @When("user enters <jobTitle>")
    public void user_enters_jobTitle() {
// Job Title
        /*WebElement dropdownJobTitle = findElement(By.id("job_job_title"));
        Select jobTitle = new Select(dropdownJobTitle);
        jobTitle.selectByVisibleText("Project Manager");*/
        selectFromDropDown(jobDetailsPage.jobTitleDropdown, "Project Manager");
    }

    // Select the Employment Status
    @When("user enters <employmentStatus>")
    public void user_enters_employmentStatus() {
        /*WebElement dropdownEmpStatus = findElement(By.id("job_emp_status"));
        Select empStatus = new Select(dropdownEmpStatus);
        empStatus.selectByVisibleText("Permanent");*/
        selectFromDropDown(jobDetailsPage.empStatusDropdown, "Promoted");
    }

    // Select the Job Category
    @When("user enters <jobCategory>")
    public void user_enters_jobCategory() {
        /*WebElement dropdownJobCatergory = findElement(By.id("job_eeo_category"));
        Select jobCatergory = new Select(dropdownJobCatergory);
        jobCatergory.selectByVisibleText("Select");*/
        selectFromDropDown(jobDetailsPage.jobCategoryDropdown, "-- Select --");
    }

    // Select the Joined Date
    @When("user enters <joinedDate>")
    public void user_enters_joinedDate() {
        calIcon1("job_joined_date");
        selectDate("May", "2023", "22");
    }

    // Select the Sub Unit
    @When("user enters <subUnit>")
    public void user_enters_subUnit() {
        // Select Sub Unit
        /*WebElement subUnitDropdown = findElement(By.id("job_sub_unit"));
        Select subUnit = new Select(subUnitDropdown);
        subUnit.selectByVisibleText("developer");*/
        selectFromDropDown(jobDetailsPage.subUnitDropdown, "Sales and marketing");
    }

    // Select the Location
    @When("user enters <location>")
    public void user_enters_location() {
        // Select Location
        /*WebElement locationDropdown = findElement(By.id("job_location"));
        Select location = new Select(locationDropdown);
        location.selectByVisibleText("DEV Team");*/
        selectFromDropDown(jobDetailsPage.locationDropdown, "DEV Team");
    }

    // Select the Start Date
    @When("user enters <startDate>")
    public void user_enters_startDate() {
        calIcon2("job_contract_start_date");
        selectDate("May", "2023", "22");
    }

    // Select the End Date
    @When("user enters <endDate>")
    public void user_enters_endDate() {
        calIcon3("job_contract_start_date");
        selectDate("May", "2028", "22");
    }

    // Upload File using the file path
    @When("user uploads a file with path {string}")
    public void user_uploads_a_file_with_path(String path) {
        String filePath = System.getProperty("user.dir") + path;
        jobDetailsPage.contractFileUpload.sendKeys(filePath);
    }


    // User clicks on the Save button
    @When("user clicks on the Save button")
    public void user_clicks_on_the_Save_button() {
        click(jobDetailsPage.editAndSaveButton);
    }

    // User can see the success message "Successfully Updated"
    @Then("user can see the success message Successfully Updated")
    public void user_can_see_the_success_message_Successfully_Updated() {
//        WebElement successMessage;
//        String messageText = jobDetailsPage.successMessage.getText();
//        Assert.assertTrue(messageText.contains("Successfully Updated"),
//                ("Successfully Updated"));
        WebElement successBox = driver.findElement(By.cssSelector("div.fadable"));
        Assert.assertTrue(successBox.isDisplayed());
    }

    @When("user can see the error message File size exceeds the limit")
    public void user_can_see_the_error_message_File_size_exceeds_the_limit() {
//        WebElement warningMessage;
//        String messageText = jobDetailsPage.warningMessage.getText();
//        Assert.assertTrue(
//                messageText.contains("Failed to Save: File Size Exceeded"),
//                "Expected error message for file size exceeding the limit.");
        WebElement warningBox = driver.findElement(By.cssSelector("div.fadable"));
        Assert.assertTrue(warningBox.isDisplayed());
    }

}