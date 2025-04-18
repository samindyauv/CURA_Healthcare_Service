package Positive;

import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class CURA_Healthcare_Service extends baseTest {

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loadUrl();
        webSteps.login();
    }

    @Test (priority = 1)
    public void loginWithValidCredentials() throws InterruptedException {
        extentReportManager.startTest("Expected Behavior Tests", "<b>Login Functionality </b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC01: Verify user can log in with valid credentials</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b> Open the application URL > Enter valid username and password > Click on 'Login' button");
        webSteps.waiting();
        boolean urlVerification = driver.getCurrentUrl().contains("appointment");
        Assert.assertTrue(urlVerification, "Expecting login success but not navigated to appointment page");
    }

    @Test (priority = 2)
    public void makeAppointment() throws InterruptedException, AWTException {
        extentReportManager.startTest("Expected Behavior Tests", "<b>Make Appointment Functionality </b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC02: Verify user can make an appointment successfully</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b> Login to the system > Fill valid appointment data > Click on 'Book Appointment' button");
        webSteps.waiting();
        webSteps.select("MA_FacilityDropdown",3,2);
        webSteps.click("MA_HealthcareProgramRadioButton");
        webSteps.click("MA_ClickVisitDate");
        webSteps.click("MA_SelectVisitDate");
        webSteps.type("Appointment for medical test review and discussion.","MA_Comment");
        webSteps.click("MA_BookAppointment");
        boolean urlVerification = driver.getCurrentUrl().contains("summary");
        Assert.assertTrue(urlVerification, "Expected appointment to be created successfully, but confirmation message was not displayed.");
    }

    @Test (priority = 3)
    public void appointmentConfirmation() throws InterruptedException, AWTException {
        extentReportManager.startTest("Expected Behavior Tests", "<b>Appointment Confirmation </b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC03: Verify appointment details confirmation after booking</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b> Login to the system > Fill valid appointment data > Click on 'Book Appointment' button > Verify appointment confirmation page and details");
        webSteps.waiting();
        webSteps.select("MA_FacilityDropdown",3,2);
        webSteps.click("MA_HealthcareProgramRadioButton");
        webSteps.click("MA_ClickVisitDate");
        webSteps.click("MA_SelectVisitDate");
        webSteps.type("Appointment for medical test review and discussion.","MA_Comment");
        webSteps.click("MA_BookAppointment");
        boolean urlVerification = driver.getCurrentUrl().contains("summary");
        webSteps.scrollToElement("MA_AppointmentConfirmation");
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Tokyo CURA Healthcare Center"), "Facility not found on page!");
        Assert.assertTrue(pageSource.contains("No"), "Hospital readmission info missing!");
        Assert.assertTrue(pageSource.contains("Medicaid"), "Healthcare Program missing!");
        Assert.assertTrue(pageSource.contains("30/04/2025"), "Visit Date missing!");
        Assert.assertTrue(pageSource.contains("Appointment for medical test review and discussion."), "Comment missing!");
    }

    @Test (priority = 4)
    public void appointmentHistory() throws InterruptedException, AWTException {
        extentReportManager.startTest("Expected Behavior Tests", "<b>Appointment History </b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC03: Verify appointment history after booking</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b> Login to the system > Fill valid appointment data > Click on 'Book Appointment' button > Verify appointment confirmation page and details > View appointment history");
        webSteps.waiting();
        webSteps.select("MA_FacilityDropdown",3,2);
        webSteps.click("MA_HealthcareProgramRadioButton");
        webSteps.click("MA_ClickVisitDate");
        webSteps.click("MA_SelectVisitDate");
        webSteps.type("Appointment for medical test review and discussion.","MA_Comment");
        webSteps.click("MA_BookAppointment");
        boolean urlVerification = driver.getCurrentUrl().contains("summary");
        webSteps.scrollToElement("MA_AppointmentConfirmation");
        webSteps.click("CURAHealthcareMenu");
        webSteps.click("CURAHealthcareHistory");
        webSteps.scrollToElement("VerifyHistoryPage");
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Tokyo CURA Healthcare Center"), "Facility not found on page!");
        Assert.assertTrue(pageSource.contains("No"), "Hospital readmission info missing!");
        Assert.assertTrue(pageSource.contains("Medicaid"), "Healthcare Program missing!");
        Assert.assertTrue(pageSource.contains("30/04/2025"), "Visit Date missing!");
        Assert.assertTrue(pageSource.contains("Appointment for medical test review and discussion."), "Comment missing!");
    }
}
