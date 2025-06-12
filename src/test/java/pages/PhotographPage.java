package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class PhotographPage extends CommonMethods {

    @FindBy(id = "Upload")
    public WebElement profilePictureUpload;

    @FindBy(xpath = "//input[@id='photofile']")
    public WebElement photofileBtn;

    @FindBy(id = "btnSave")
    public WebElement uploadButton;

    @FindBy(css = ".message.success")
    public WebElement uploadSuccessMessage;

    @FindBy(css = ".message.error")
    public WebElement errorMessageContainer;



    public PhotographPage() {
        PageFactory.initElements(driver, this);
    }
}
