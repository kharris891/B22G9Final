package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

import java.util.List;
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
    public WebElement subscriptionPaidby;

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

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr[1]/td[2]/a")
    public WebElement employee;

    @FindBy(xpath = "(//a[text()='Memberships'])[2]")
    public WebElement membershipsTab;

    @FindBy(id = "btnCancel")
    public WebElement cancelButton;

    @FindBy(id = "addPaneMembership")
    public WebElement addMembershipPlane;


    // ----- Deletion Elements -----
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement activeCheckbox;

    @FindBy(id = "delMemsBtn")
    public WebElement deleteMembershipButton;

    @FindBy(xpath = "//td[@class='memshipCode']")
    public WebElement addedMembership;

    @FindBy(xpath="//a[text()='Brain Buster']")
    public WebElement membershipLink;

    @FindBy(xpath="//a[text()='Membership1']")
    public WebElement membershipLinkAfterUpdate;


    @FindBy (xpath = "(//input[@type='checkbox'])[2]")
    public WebElement membershipCheckbox;

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

    public void fillMembershipData(List<Map<String, String>> data) {
        new Select(membershipPage.membershipField).selectByVisibleText(data.get(0).get("Membership"));
        new Select(membershipPage.subscriptionPaidby).selectByVisibleText(data.get(0).get("Subscription Paid By"));
        sendText(data.get(0).get("Subscription Amount"), membershipPage.subscriptionAmountField);
        new Select(membershipPage.currencyField).selectByVisibleText(data.get(0).get("Currency"));
        sendText(data.get(0).get("Subscription Commence Date"), membershipPage.subscriptionCommenceDateField);
        sendText(data.get(0).get("Subscription Renewal Date"), membershipPage.subscriptionRenewalDateField);

    }

    public MembershipPage(){
        PageFactory.initElements(driver, this);
    }
}