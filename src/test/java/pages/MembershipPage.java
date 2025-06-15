package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;
import java.util.Map;


public class MembershipPage extends CommonMethods {

    // ----- Login Elements -----
    @FindBy(id = "txtUsername")
    public WebElement usernameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    // ----- Navigation -----
    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    // ----- Employee Search -----
    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement empNameSearchField;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    // ----- Membership Section -----
    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimButton;

    @FindBy(xpath = "//a[contains(@href, 'viewMemberships')])")
    public WebElement addMembershipPane;

    @FindBy(id = "btnAddMembershipDetail")
    public WebElement addMembershipButton;

    @FindBy(id = "membership_membership")
    public WebElement membershipField;

    @FindBy(id = "membership_subscriptionPaidBy")
    public WebElement subscriptionPaidByField;

    @FindBy(id = "membership_subscriptionAmount")
    public WebElement subscriptionAmountField;

    @FindBy(id = "membership_currency")
    public WebElement currencyField;

    @FindBy(id = "membership_subscriptionCommenceDate")
    public WebElement subscriptionCommenceDateField;

    @FindBy(id = "membership_subscriptionRenewalDate")
    public WebElement subscriptionRenewalDateField;

    @FindBy(id = "btnSaveMembership")
    public WebElement saveMembershipButton;

    @FindBy(id = "btnCancel")
    public WebElement cancelButton;

    // ----- Deletion Elements -----
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement activeCheckbox;

    @FindBy(id = "delMemsBtn")
    public WebElement deleteMembershipButton;

    // ----- Optional Feedback Elements -----
    // @FindBy(id = "successMsg")
    // public WebElement successMessage;

    // ----- Utility Methods -----
    public void login(String username, String password) {
        sendText(username, usernameField);
        sendText(password, passwordField);
        click(loginButton);
    }

    public void fillMembershipForm(Map<String, String> data) {
        new Select(membershipPage.membershipField).selectByVisibleText(data.get("Membership"));
        new Select(membershipPage.subscriptionAmountField).selectByVisibleText(data.get("Paid By"));
        sendText(data.get ("Amount"), membershipPage.subscriptionAmountField);
        new Select(membershipPage.currencyField).selectByVisibleText(data.get("Currency"));
        sendText(data.get("Commence Date"), membershipPage.subscriptionCommenceDateField); sendText(data.get("Renewal Date"), membershipPage.subscriptionRenewalDateField);
    }



    public MembershipPage(){
        PageFactory.initElements(driver, this);
    }
}