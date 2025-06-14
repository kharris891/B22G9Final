package utils;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.SearchEmployeePage;
import pages.EmployeeListPage;
import pages.PersonalDetailsPage;
import pages.ContactDetailsPage;
import pages.PhotographPage;
import pages.DependentsPage;
import pages.JobDetailsPage;
import pages.QualificationsPage;
import pages.MembershipPage;

public class PageInitializer {

    // Core pages from template
    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static DashboardPage dashboardPage;
    public static SearchEmployeePage searchEmployeePage;

    // Additional pages for other user stories
    public static EmployeeListPage employeeListPage;
    public static PersonalDetailsPage personalDetailsPage;
    public static ContactDetailsPage contactDetailsPage;
    public static PhotographPage photographPage;
    public static DependentsPage dependentsPage;
    public static JobDetailsPage jobDetailsPage;
    public static QualificationsPage qualificationsPage;
    public static MembershipPage membershipPage;






    public static void initializePageObjects(WebDriver driver){
        // core pages initialization
        loginPage = new LoginPage(driver);
        addEmployeePage = new AddEmployeePage();
        dashboardPage = new DashboardPage();
        searchEmployeePage = new SearchEmployeePage();

        // additional pages initialization
        personalDetailsPage = new PersonalDetailsPage();
        contactDetailsPage = new ContactDetailsPage();
        photographPage = new PhotographPage();
        dependentsPage = new DependentsPage();
        jobDetailsPage = new JobDetailsPage();
        qualificationsPage = new QualificationsPage();
        membershipPage = new MembershipPage();
        employeeListPage = new EmployeeListPage();


    }


}
