package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class JobDetailsPage extends CommonMethods {

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(id="empsearch_id")
    public WebElement empIdSearchBox;

    @FindBy(xpath="//table[@id='resultTable']//tr[1]/td[3]/a")
    public WebElement empNameSearchBox;

    @FindBy(xpath = "//a[contains(@href, 'viewJobDetails')]")
    public WebElement jobsTab;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="job_job_title")
    public WebElement jobTitleDropdown;

    @FindBy(id="job_emp_status")
    public WebElement empStatusDropdown;

    @FindBy(id="job_eeo_category")
    public WebElement jobCategoryDropdown;

    @FindBy(id="(//img[contains(@src, 'calendar.png')])[1]")
    public WebElement calendarBtn1;

    @FindBy(id="//select[@class='ui-datepicker-month']")
    public WebElement calendarMonth;

    @FindBy(id="//select[@class='ui-datepicker-month']//option[text()='\" + month + \"']")
    public WebElement monthElement;

    @FindBy(id="//select[@class='ui-datepicker-year']")
    public WebElement calendarYear;

    @FindBy(id="//select[@class='ui-datepicker-year']//option[text()='\" + year + \"']")
    public WebElement yearElement;

    @FindBy(id="(//img[contains(@src, 'calendar.png')])[2]")
    public WebElement calendarBtn2;

    /*@FindBy(id="//select[@class='ui-datepicker-month']")
    public WebElement calendarMonth2;

    @FindBy(id="//select[@class='ui-datepicker-month']//option[text()='\" + month + \"']")
    public WebElement monthElement2;

    @FindBy(id="//select[@class='ui-datepicker-year']")
    public WebElement calendarYear2;

    @FindBy(id="//select[@class='ui-datepicker-year']//option[text()='\" + year + \"']")
    public WebElement yearElement2;*/

    @FindBy(id="(//img[contains(@src, 'calendar.png')])[3]")
    public WebElement calendarBtn3;

    /*@FindBy(id="//select[@class='ui-datepicker-month']")
    public WebElement calendarMonth3;

    @FindBy(id="//select[@class='ui-datepicker-month']//option[text()='\" + month + \"']")
    public WebElement monthElement3;

    @FindBy(id="//select[@class='ui-datepicker-year']")
    public WebElement calendarYear3;

    @FindBy(id="//select[@class='ui-datepicker-year']//option[text()='\" + year + \"']")
    public WebElement yearElement3;*/

    @FindBy(id="//table/tbody/tr/td")
    public List<WebElement> allDates;

    @FindBy(id="job_sub_unit")
    public WebElement subUnitDropdown;

    @FindBy(id="job_location")
    public WebElement locationDropdown;

    @FindBy(id="btnSave")
    public WebElement editAndSaveButton;

    @FindBy(id="//div[@class='message success fadable']")
    public WebElement successMessage;

    @FindBy(id="job_contract_file")
    public WebElement contractFileUpload;

    @FindBy(xpath="//div[@class='message warning fadable']")
    public WebElement warningMessage;

    public void selectMonth(String month) {
        calendarMonth.click();  // Open the month dropdown
        WebElement monthElement = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[text()='" + month + "']"));
        monthElement.click();  // Select the month
    }

    public void selectYear(String year) {
        calendarYear.click();  // Open the year dropdown
        WebElement yearElement = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']//option[text()='" + year + "']"));
        yearElement.click();  // Select the year
    }

    public void selectDay(String day) {
        // Loop through all the dates and select the matching day
        List<WebElement> allDates1 = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement date1 : allDates1) {
            if (date1.getText().equals(day)) {
                date1.click();  // Click the day
                break;  // Exit the loop after clicking the day
            }
        }
    }

    public void selectDate(String month, String year, String day) {
        selectMonth(month);
        selectYear(year);
        selectDay(day);
    }



    public JobDetailsPage(){
        PageFactory.initElements(driver, this);
    }

}
