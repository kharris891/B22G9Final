package pages;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ContactDetailsPage extends CommonMethods {

    public ContactDetailsPage(){
        PageFactory.initElements(driver, this);
    }
}
