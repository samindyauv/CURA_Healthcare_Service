package Negative;

import org.testng.annotations.BeforeMethod;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class CURA_Healthcare_Service extends baseTest {

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loadUrl();
        extentReportManager.startTest("Error Handling Tests", "<b>Login Functionality </b>");
    }
}
