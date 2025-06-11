package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

import java.util.List;

public class JobDetailsSteps extends CommonMethods {

    @When("user clicks on Employee List option")
    public void user_clicks_on_Employee_List_option() {
        click(jobDetailsPage.empListOption);
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
    public void user_enters_joinedDate() throws InterruptedException {
        //Click on the calendar button to open the date picker
        /*WebElement calendarButton1 = findElement(By.xpath("(//img[contains(@src, 'calendar.png')])[1]"));
        calendarButton1.click();*/
        // Select the month from the dropdown
        /*WebElement calendarMonth1 = findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select month1 = new Select(calendarMonth1);
        month1.selectByVisibleText("May");*/
        //selectFromDropDown(jobDetailsPage.calendarMonth1, "May");
        // Select the year from the dropdown
        /*WebElement calendarYear1 = findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select year1 = new Select(calendarYear1);
        year1.selectByVisibleText("2023");*/
        //selectFromDropDown(jobDetailsPage.calendarMonth1, "2023");
        click(jobDetailsPage.calendarBtn1);
        Thread.sleep(1000); // Adding a wait to ensure the calendar is loaded
        jobDetailsPage.selectDate("May", "2023", "22");
    }

// Select the Sub Unit
    @When("user enters <subUnit>")
    public void user_enters_subUnit() {
      // Select Sub Unit
        /*WebElement subUnitDropdown = findElement(By.id("job_sub_unit"));
        Select subUnit = new Select(subUnitDropdown);
        subUnit.selectByVisibleText("developer");*/

        selectFromDropDown(jobDetailsPage.subUnitDropdown, "developer");
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
    public void user_enters_startDate() throws InterruptedException {
        // Select Contract Start Date
        // Select Calendar Button
        /*WebElement calendarButton2 = findElement(By.xpath("(//img[contains(@src, 'calendar.png')])[2]"));
        calendarButton2.click();
        click(jobDetailsPage.calendarBtn2);
        // Select Month from the dropdown
        WebElement calendarMonth2 = findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select month2 = new Select(calendarMonth2);
        month2.selectByVisibleText("May");
        // Select Year from the dropdown
        WebElement calendarYear2 = findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select year2 = new Select(calendarYear2);
        year2.selectByVisibleText("2023");
        // Select day from the dropdown
        List<WebElement> allDates2 = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for(WebElement date2 : allDates2){
            if(date2.getText().equals("22")){
                date2.click();
            }
        }*/
        click(jobDetailsPage.calendarBtn2);
        Thread.sleep(1000); // Adding a wait to ensure the calendar is loaded
        jobDetailsPage.selectDate("May", "2023", "22");
    }

// Select the End Date
    @When("user enters <endDate>")
    public void user_enters_endDate() throws InterruptedException {
        // Select Contract End Date
        // Select Calendar Button
        /*WebElement calendarButton3 = findElement(By.xpath("(//img[contains(@src, 'calendar.png')])[3]"));
        calendarButton3.click();*//*
        // Select Month from the dropdown
        WebElement calendarMonth3 = findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select month3 = new Select(calendarMonth3);
        month3.selectByVisibleText("May");
        // Select Year from the dropdown
        WebElement calendarYear3 = findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select year3 = new Select(calendarYear3);
        year3.selectByVisibleText("2023");
        // Select day from the dropdown
        List<WebElement> allDates3 = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for(WebElement date3 : allDates3){
            if(date3.getText().equals("22")){
                date3.click();
            }
        }*/
        click(jobDetailsPage.calendarBtn3);
        Thread.sleep(1000); // Adding a wait to ensure the calendar is loaded
        jobDetailsPage.selectDate("May", "2028", "22");
    }

// Upload File using the file path
    @When("user uploads a file with path <filePath>")
    public void user_uploads_a_file_with_path_filePath(String filePath) {

    }

// User clicks on the Save button
    @When("user clicks on the Save button")
    public void user_clicks_on_the_Save_button() {
        click(jobDetailsPage.editAndSaveButton);
    }

// User can see the success message "Successfully Updated"
    @Then("user can see the success message Successfully Updated")
    public void user_can_see_the_success_message_Successfully_Updated() {
        WebElement successMessage;
        String messageText = jobDetailsPage.successMessage.getText();
        if (messageText.contains("Successfully Updated")) {
            System.out.println("Test Passed: Job details updated successfully.");
        } else {
            System.out.println("Test Failed: Job details update failed.");
        }
    }

}