package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;


public class Hooks extends CommonMethods {

    public static LoginPage loginPage;

    @Before(value = "@java", order = 0)
    public void start(){
        //it is my pre condition
        openBrowserAndLaunchApplication();

        loginPage = new LoginPage(driver);
    }

    @Before(value = "@admin", order = 1)
    public void adminSetup() {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("password"));
        loginPage.loginButton.click();
    }

    @Before(value = "@ess", order = 1)
    public void essSetup() {
        loginPage.usernameField.sendKeys(ConfigReader.read("essUsername"));
        loginPage.passwordField.sendKeys(ConfigReader.read("essPassword"));
        loginPage.loginButton.click();
    }

    @After(value = "@java")
    public void end(Scenario scenario){
        //scenario class holds the complete information about the execution
        //it is my post condition
        byte[] pic;

        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else {
            pic = takeScreenshot("passed/"+scenario.getName());
        }

        //to attach the screenshot in the report
        scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }

}