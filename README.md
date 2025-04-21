# CURA Healthcare Service - Selenium TestNG Automation

This project automates the functional testing of the [CURA Healthcare Service](https://katalon-demo-cura.herokuapp.com/) web application using **Selenium WebDriver**, **TestNG**, and **ExtentReports**. <br>
It covers both positive and negative scenarios for login and appointment workflows.


---

## 🧪 Features Tested

✅ Login with valid credentials <br>
🩺 Booking an appointment <br>
📅 Verifying appointment confirmation details <br>
📜 Viewing appointment history <br>
🔒 Logout functionality <br>
❌ Login with invalid credentials (Negative scenarios) <br>

## 🧪 Test Scenarios

| Test Case ID | Test Case Name                             | Description                                                         |
|--------------|--------------------------------------------|---------------------------------------------------------------------|
| P_TC01         | Login with Valid Credentials               | Verify successful login with correct username and password.         |
| P_TC02         | Make Appointment                           | Verify successful appointment booking with valid details.           |
| P_TC03         | Appointment Confirmation                   | Verify that appointment details are displayed after booking.        |
| P_TC04         | Appointment History                        | Verify that booked appointments appear in the appointment history.  |
| P_TC05         | Logout                                     | Verify successful logout redirects the user to the home page.        |
| N_TC01       | Login with Valid Username and Empty Password | Verify error message when password field is left empty.             |
| N_TC02       | Login with Valid Username and Invalid Password | Verify login fails with wrong password.                         |
| N_TC03       | Login with Empty Username and Valid Password | Verify login fails when username field is left empty.              |
| N_TC04       | Login with Empty Username and Empty Password | Verify login fails when both username and password are empty.      |
| N_TC05       | Login with Empty Username and Invalid Password | Verify login fails with empty username and wrong password.       |
| N_TC06       | Login with Invalid Username and Valid Password | Verify login fails with wrong username and correct password.     |
| N_TC07       | Login with Invalid Username and Empty Password | Verify login fails with wrong username and no password.          |
| N_TC08       | Login with Invalid Username and Invalid Password | Verify login fails with both wrong username and wrong password.  |

> 📝 **Note:**  
> - `P_` prefix stands for **Positive Test Scenarios** (expected successful actions).  
> - `N_` prefix stands for **Negative Test Scenarios** (expected failure or validation handling).

---

## 🔧 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- ExtentReports
- Page Object Model (POM) structure
- XPath repository (externalized)
- Custom utilities and test data management



---

## 🧑‍💻 Author
**Samindya Vass**  
<br>

<a href="https://www.linkedin.com/in/samindya-umayangani" target="_blank">
  <img src="https://user-images.githubusercontent.com/74038190/235294012-0a55e343-37ad-4b0f-924f-c8431d9d2483.gif" width="70">
</a>
<a href="https://www.instagram.com/samindya_1" target="_blank">
  <img src="https://user-images.githubusercontent.com/74038190/235294013-a33e5c43-a01c-43f6-b44d-a406d8b4ab75.gif" width="70">
</a>
<a href="https://web.facebook.com/samindya.umayangani" target="_blank">
  <img src="https://user-images.githubusercontent.com/74038190/235294010-ec412ef5-e3da-4efa-b1d4-0ab4d4638755.gif" width="70">
</a>
