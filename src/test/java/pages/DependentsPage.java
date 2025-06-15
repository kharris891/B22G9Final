package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DependentsPage extends CommonMethods {

    public DependentsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAddDependent")
    public WebElement addDependentButton;

    @FindBy(id = "dependent_name")
    public WebElement nameField;

    @FindBy(id = "dependent_relationshipType")
    public WebElement relationshipDropdown;

    @FindBy(id = "dependent_dateOfBirth")
    public WebElement dateOfBirthField;

    @FindBy(id = "btnSaveDependent")
    public WebElement saveButton;


    @FindBy(xpath = "//span[@for='dependent_name']")
    public WebElement nameErrorMessage;

    public WebElement getDependentRowByName(String name) {
        String xpath = "//table[@id='dependent_list']//a[text()='John Doe']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getDeleteButtonForDependent(String name) {
        String xpath = "//a[text()='John Doe']/ancestor::tr//a[contains(@href,'deleteDependent')]";

        return driver.findElement(By.xpath(xpath));
    }

    @FindBy(id = "dialogDeleteBtn")
    public WebElement confirmDeleteButton;
}
