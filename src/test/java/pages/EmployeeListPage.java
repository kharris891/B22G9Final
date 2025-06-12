package pages;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {

    public EmployeeListPage(){
        PageFactory.initElements(driver, this);
    }
}
