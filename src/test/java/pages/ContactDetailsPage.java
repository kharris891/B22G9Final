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

    public ContactDetailsPage(){
        PageFactory.initElements(driver, this);
    }
}
