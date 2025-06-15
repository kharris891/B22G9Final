package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() {
        // initializePageObjects();
        switch (ConfigReader.read("browser")) {

            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
            case "FireFox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.read("url"));
        //this ,method will call all the objects
        initializePageObjects(driver);

    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    public void selectFromDropDown(WebElement dropDown, String visibleText) {
        Select sel = new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }

    public void selectFromDropDown(String value, WebElement dropDown) {
        Select sel = new Select(dropDown);
        sel.selectByValue(value);
    }

    public void selectFromDropDown(WebElement dropDown, int index) {
        Select sel = new Select(dropDown);
        sel.selectByIndex(index);
    }

    public WebDriverWait getwait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public void waitForElementToBeClickAble(WebElement element) {
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitForElementToBeClickAble(element);
        element.click();
    }

    public JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }


    public byte[] takeScreenshot(String fileName) {
        //it accepts array of byte in cucumber for the screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH +
                            fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }

    public String getTimeStamp(String pattern) {
        //this method will return the timestamp which we will add in ss method
        Date date = new Date();

        //yyyy-mm-dd-hh-mm-ss
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Calendar methods for date picker
    //Calendar Icon 1
    public void calIcon1(String inputId) {
        WebElement input = driver.findElement(By.id("job_joined_date"));
        WebElement calIcon = input.findElement(By.xpath("following-sibling::img[contains(@class, 'ui-datepicker-trigger')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calIcon);
    }

    //Calendar Icon 2
    public void calIcon2(String inputId) {
        WebElement input = driver.findElement(By.id("job_contract_start_date"));
        WebElement calIcon = input.findElement(By.xpath("following-sibling::img[contains(@class, 'ui-datepicker-trigger')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calIcon);
    }

    //Calendar Icon 3
    public void calIcon3(String inputId) {
        WebElement input = driver.findElement(By.id("job_contract_end_date"));
        WebElement calIcon = input.findElement(By.xpath("following-sibling::img[contains(@class, 'ui-datepicker-trigger')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calIcon);
    }

    public void selectMonth(String month) {
        WebElement monthDropdown = driver.findElement(By.className("ui-datepicker-month"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month); // e.g. "Jan"
    }

    // Choose Year
    public void selectYear(String year) {
        WebElement yearDropdown = driver.findElement(By.className("ui-datepicker-year"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year); // e.g. "2025"
    }

    public void selectDay(String day) {
        List<WebElement> allDates1 = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement date1 : allDates1) {
            if (date1.getText().equals(day)) {
                date1.click();
                break;
            }
        }
    }

    // Method to select date by month, year, and day
    public void selectDate(String month, String year, String day) {
        selectMonth(month);
        selectYear(year);
        selectDay(day);
    }
}
