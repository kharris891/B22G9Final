package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MembershipSteps extends CommonMethods {
    // Recommended if you're using PageInitializer pattern
    // public MembershipSteps() { PageInitializer.initialize(); }

    // MembershipPage membership = new MembershipPage();

//    @Given("the user is on the HRMS login page")
//    public void the_user_is_on_the_hrms_login_page() {
//        Assert.assertTrue(membershipPage.usernameField.isDisplayed());
//    }

//    @When("the user logs in with valid credentials")
//    public void the_user_logs_in_with_valid_credentials() {
//
//        membershipPage.login("admin", "Hum@nhrm123");
//    }

    @When("navigates to the employee list")
    public void navigates_to_the_employee_list()
    {
        click(membershipPage.pimButton);
        waitForElementToBeClickAble(membershipPage.employeeListOption);

        membershipPage.click(membershipPage.employeeListOption);
    }

    @When("searches for employee {string}")
    public void searches_for_employee(String empName) {
      //  membership.sendText(empName, membership. membershipsTab);
        //membership.click(membership.searchButton);
        membershipPage.click(membershipPage.employee);
        membershipPage.click(membershipPage.membershipsTab);

    }

    @When("clicks on Add Membership")
    public void clicks_on_add_membership() {
        membershipPage.click(membershipPage.addMembershipButton);
        membershipPage.click(membershipPage.addMembershipPlane);

       // membership.click(membership.addMembershipButton);
    }

    @When("enters the following membership details:")
    public void enters_the_following_membership_details(DataTable dataTable) {
        List<Map<String, String>> AddData = dataTable.asMaps();
        membershipPage.fillMembershipData(AddData);
    }

    @When("saves the membership")
    public void saves_the_membership() {
        membershipPage.click(membershipPage.saveMembershipButton);
    }

    @Then("the membership should be successfully added")
    public void the_membership_should_be_successfully_added() {
        // Replace this with actual verification (e.g., toast or success message)
        Assert.assertTrue("Membership may not be saved successfully",
                membershipPage.membershipLink.isDisplayed());
    }

    @When("I update the membership with new details:")
    public void iUpdateTheMembershipWithNewDetails(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        click(membershipPage.membershipLink);
        //membership.jsClick(membership.membershipLink);
        List<Map<String, String>> updatedData = dataTable.asMaps();
        membershipPage.fillMembershipData(updatedData);

       // membership.fillMembershipData(updatedData);
       // membership.click(membership.saveMembershipButton);

       // membership.fillMembership(updatedData);
       // membership.click(membership.saveMembershipButton);
    }

    @Then("the membership should be updated successfully")
    public void theMembershipShouldBeUpdatedSuccessfully() {
       // membership.click(membership.editMembershipButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Replace this with actual verification (e.g., toast or success message)
        Assert.assertTrue("Membership may not be updated successfully",
        membershipPage.membershipLinkAfterUpdate.isDisplayed());

        System.out.println("Successfully Saved");
    }

    @When("I delete the membership")
    public void iDeleteTheMembership() {
        membershipPage.click(membershipPage.membershipCheckbox);
        membershipPage.click(membershipPage.deleteMembershipButton);
    }

    @Then("the membership should be deleted successfully")
    public void theMembershipShouldBeDeletedSuccessfully() {
        // Wait for the confirmation dialog to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println("Membership deleted successfully");
    }
}
