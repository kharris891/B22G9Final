package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class PhotographPage extends CommonMethods {

    @FindBy(id = "btnSave")
    public WebElement uploadButton;

    @FindBy(css = ".message.success")
    public WebElement uploadSuccessMessage;

    @FindBy(id = "photofile")
    public WebElement photoFileInput;


    public PhotographPage() {
        PageFactory.initElements(driver, this);
    }
}
