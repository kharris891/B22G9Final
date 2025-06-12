package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class PersonalDetailsPage extends CommonMethods {

    @FindBy(id = "empPic")
    public WebElement profilePictureLink;

    @FindBy(id = "empPic")
    public WebElement profilePictureImg;


    @FindBy(id = "txtUsername")
    public WebElement usernameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    // My Info Navigation and clicks
    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement MyInfo;

    // ----------- Edit Buttons -----------
    @FindBy(id = "btnSav")  // Possible typo in locator, verify if it should be "btnSave"
    public WebElement editButton;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    // ----------- Personal Details Fields -----------
    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement firstNameField;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement middleNameField;

    @FindBy(id = "personal_txtEmpLastName")
    public WebElement lastNameField;

    // ----------- Gender Radio Buttons -----------
    @FindBy(id = "personal_optGender_1")
    public WebElement maleRadioButton;

    @FindBy(id = "personal_optGender_2")
    public WebElement femaleRadioButton;

    // ----------- Dropdowns -----------
    @FindBy(id = "personal_cmbNation")
    public WebElement nationalityDropdown;

    @FindBy(id = "personal_cmbMarital")
    public WebElement maritalStatusDropdown;

    // ----------- Methods -----------

    public void login(String username, String password) {
        sendText(username, usernameField);
        sendText(password, passwordField);
        click(loginButton);
    }

    public void navigateToMyInfo() {
        click(MyInfo);
    }

    public void clickEdit() {
        click(editButton);
    }

    public void clickSave() {
        click(saveButton);
    }

    public boolean isFieldEditable(WebElement field) {
        return field.isEnabled();
    }

    public boolean areGenderOptionsSelectable() {
        return maleRadioButton.isEnabled() && femaleRadioButton.isEnabled();
    }

    public String getFirstNameValue() {
        return firstNameField.getAttribute("value");
    }

    public String getMiddleNameValue() {
        return middleNameField.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastNameField.getAttribute("value");
    }

    public boolean isDropdownSelectable(WebElement dropdown) {
        return dropdown.isEnabled();
    }


    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }
}
