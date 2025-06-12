package utils;

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






    public static void initializePageObjects(){
        // core pages initialization
        loginPage = new LoginPage();
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
