package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeListPage extends CommonMethods {

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement employeeNameField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="resetBtn")
    public WebElement resetButton;

    @FindBy(xpath = "//table[@id='resultTable']")
    public WebElement resultTable;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
    public List<WebElement> searchResultRows;

    @FindBy(xpath = "//td[text()='No Records Found']")
    public WebElement noRecordFoundMessage;

    @FindBy (id = "")
    public WebElement firstName;

    public By searchResultRowsLocator = By.xpath("//table[@id='resultTable']/tbody");

    public EmployeeListPage(){
        PageFactory.initElements(driver, this);
    }
}
