package pages;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DependentsPage extends CommonMethods {

    public DependentsPage(){
        PageFactory.initElements(driver, this);
    }
}
