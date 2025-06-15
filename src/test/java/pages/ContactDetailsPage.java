package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ContactDetailsPage extends CommonMethods {

    @FindBy (id = "btnSave")
    public WebElement saveBtn;;

    @FindBy (id ="menu_pim_viewMyDetails")
    public WebElement myInfo;

    @FindBy (xpath = "//*[text()='Contact Details']")
    public WebElement contactDetails;

    @FindBy (id = "contact_street1")
    public WebElement add1;

    @FindBy (id = "contact_emp_hm_telephone")
    public WebElement tele;

    @FindBy (xpath = "//*[text()='Allows numbers and only + - / ( )']")
    public WebElement errormsg;

    public ContactDetailsPage(){
        PageFactory.initElements(driver, this);
    }
}
