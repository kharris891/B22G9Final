package pages;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class MembershipPage extends CommonMethods {

    public MembershipPage(){
        PageFactory.initElements(driver, this);
    }
}
