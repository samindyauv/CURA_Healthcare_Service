package Negative;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class CURA_Healthcare_Service extends baseTest {

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loadUrl();
    }

    @DataProvider(name = "negativeLoginData")
    public Object[][] negativeLoginDataProvider() {
        return new Object[][]{
                {"<b>N_TC01: Verify that the user cannot log in with a valid username and an empty password</b>", "John Doe", "", "Login failed! Please ensure the username and password are valid."},
                {"<b>N_TC02: Verify that the user cannot log in with a valid username and an invalid password</b>", "John Doe", "WrongPassword", "Login failed! Please ensure the username and password are valid."},
                {"<b>N_TC03: Verify that the user cannot log in with an empty username and a valid password</b>", "", "ThisIsNotAPassword", "Login failed! Please ensure the username and password are valid."},
                {"<b>N_TC04: Verify that the user cannot log in with an empty username and an empty password</b>", "", "", "Login failed! Please ensure the username and password are valid."},
                {"<b>N_TC05: Verify that the user cannot log in with an empty username and an invalid password</b>", "", "WrongPassword", "Login failed! Please ensure the username and password are valid."},
                {"<b>N_TC06: Verify that the user cannot log in with an invalid username and a valid password</b>", "WrongUser", "ThisIsNotAPassword", "Login failed! Please ensure the username and password are valid."},
                {"<b>N_TC07: Verify that the user cannot log in with an invalid username and an empty password</b>", "WrongUser", "", "Login failed! Please ensure the username and password are valid."},
                {"<b>N_TC08: Verify that the user cannot log in with an invalid username and an invalid password</b>", "WrongUser", "WrongPassword", "Login failed! Please ensure the username and password are valid."},
        };
    }

    @Test(dataProvider = "negativeLoginData")
    public void loginWithInvalidCredentials(String testCase, String username, String password, String expectedValidation) throws InterruptedException {
        extentReportManager.startTest("Error Handling Tests", "<b>Login Functionality - Negative Testing</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case: </font></b>" + testCase);
        extentReportManager.testSteps("<b><font color='blue'>Test Steps: </font></b> Open the application URL > Enter username (valid/invalid/empty) > Enter password (valid/invalid/empty) > Click on 'Login' button > Verify error message is displayed");

        extentReportManager.testSteps("<b>Username: </b>" + (username.isEmpty() ? "[Empty]" : username));
        extentReportManager.testSteps("<b>Password: </b>" + (password.isEmpty() ? "[Empty]" : password));

        webSteps.type(username, "Login_username");
        webSteps.type(password, "Login_password");
        webSteps.click("LoginButton");

        extentReportManager.testSteps("<b>Checking expected validation: </b>" + expectedValidation);

        Assert.assertEquals(webSteps.getText("LoginErrorMessages"), expectedValidation, "Validation Failed");
    }
}
