package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.Constants;

public class SearchEmployeeSteps extends CommonMethods {

//    @Given("the admin user is logged into the HRMS system")
//    public void admin_logs_in() {
//        sendText(login.usernameField, ConfigReader.read("username"));
//        sendText(login.passwordField, ConfigReader.read("password"));
//        click(login.loginButton);
//    }

    @When("the admin navigates to the Employee List")
    public void admin_navigates_to_employee_list() {
        dashboardPage.pimTab.click();
        dashboardPage.employeeListOption.click();
    }

    @When("the admin enters full name {string}")
    public void the_admin_enters_full_name(String fullName) {
        employeeListPage.employeeNameField.clear();
        employeeListPage.employeeNameField.sendKeys(fullName);
    }

    @When("the admin clicks the Search button")
    public void the_admin_clicks_the_search_button() {
        employeeListPage.searchButton.click();
    }

    @When("the admin clicks the Reset button")
    public void the_admin_clicks_the_reset_button() {
        employeeListPage.resetButton.click();
    }

    @Then("the employee search results should include {string}")
    public void the_employee_search_results_should_include(String expectedName) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(
                By.id("empsearch_employee_name_empName"),
                "class",
                "ac_loading"
        )));

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("empsearch_employee_name_empName")
        ));


        List<WebElement> rows = employeeListPage.searchResultRows;

        boolean nameFound = false;

        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.contains(expectedName)) {
                nameFound = true;
                break;
            }
        }

        Assert.assertTrue("The expected employee name was not found in the results!", nameFound);
    }

    @Then("the system should display {string}")
    public void the_system_should_display(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(CommonMethods.driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        WebElement noRecordsMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//table//td[contains(text(),'No Records Found')]")));


        String actualMessage = noRecordsMessage.getText();
        Assert.assertEquals("Message does not match!", expectedMessage, actualMessage);
    }

}

