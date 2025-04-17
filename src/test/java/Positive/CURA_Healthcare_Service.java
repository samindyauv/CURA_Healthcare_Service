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
}
