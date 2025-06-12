package pages;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class QualificationsPage extends CommonMethods {

    public QualificationsPage(){
        PageFactory.initElements(driver, this);
    }
}
