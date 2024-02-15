#**Project Name: Identify New Bikes Automation**

## Overview
This project aims to automate the ZigWheel website using Selenium WebDriver. The automation process involves navigating to the ZigWheel website Display upcoming bikes details like, bike name, its price and expected launch date in India.Manufacturer should be Honda. Bike price should be less than 4Lac.

## Libraries and Dependencies
- **Maven Repository:** Maven 3.12.1
- **Apache POI:** 5.2.3/5.2.5
- **TestNG:** 7.4.0
- **Extent Report:** 5.1.1
- **Selenium WebDriver:** 4.15.0
- **Loggers:** 2.22.0

## Automation Flow
1. Navigate to `https://www.zigwheels.com/`.
2. Verify title of the website.
3. Hover over the NewBikes of the Navbar.
4. Click on Upcoming Bike from the list of the options.
5. Click on the Manufacturer and select Honda from the dropdown.
6. Display "Upcoming" bikes details like bike name, price and expected launch date in India, for 'Honda'.
7. Bike price should be less than 4Lac.
8. Click on the used car from Navbar.
9. Select Location chennai.
10. Extract all the popular models in a List, Display the same
11. Again go back to home page.
12. Click on login and Signup button.
13. Try to 'Login' with google.
14. Give invalid account details & capture the error message.



## Libraries Explanation
- **Maven Repository:** Used for project management and dependency resolution.
- **Apache POI:** Handles Excel operations for data-driven testing.
- **TestNG:** Facilitates test case organization and execution.
- **Extent Report:** Generates comprehensive test reports.
- **Selenium WebDriver:** Automates browser interactions.
- **Loggers:** Facilitates logging for better debugging.

##The outcomes of Hackathon deliverables are:

- Explore the Innovative Implementations.
- Implement Best practices such as creating Smoke and Regression suite.
- Implement Maven on the created automation test scripts
- Explore Jenkins to execute the test scripts periodically on Selenium Grid.
- Explore Selenium Grid to run test scripts on different platforms and against different browsers.
- Integrate Jenkins with version controller (GIT) and scheduled builds to run automatically.

## Screenshots
Screenshots are captured at relevant steps for documentation and analysis.

## How to Run
1. **Open Eclipse IDE:**
   - Launch Eclipse IDE on your machine.

2. **Import Project:**
   - Select `File` -> `Import` from the menu.
   - Choose `Existing Maven Projects` and click `Next`.
   - Browse to the directory where you cloned the repository and select the project.

3. **Update Maven Project:**
   - Right-click on the project in the Project Explorer.
   - Choose `Maven` -> `Update Project`.
   - Click `OK` to update dependencies.

4. **Set Up Configuration:**
   - Open the `src/test/resources/config.properties` file.
   - Update any configuration parameters like browser type, URLs, etc., as needed.

5. **Run Test Suite:**
   - Locate the test suite file (`testng.xml`)
   - Right-click on the file and choose `Run As` -> `TestNG Suite`.

6. **View Reports:**
   - After execution, open the `test-output` folder.
   - Find the TestNG file (`index.html`) for detailed test case reports.

## Reporting
1. **Locate Test Reports:**
   - After the execution, navigate to the `test-output` folder in the project directory.

2. **Open Extent Report:**
   - Inside the `test-output` folder, find the Extent Report HTML file named `index.html`.

3. **View Test Reports:**
   - Open the `index.html` file using any web browser.
   - This report provides a detailed overview of test executions, including passed and failed tests, test duration, and any exceptions encountered.

4. **Screenshots and Logs:**
   - Extent Report may include screenshots captured during test execution and relevant logs for failed test cases.

5. **Analyze Results:**
   - Utilize the visual representation in the Extent Report to quickly identify test status and any issues encountered during the test run.


## Future Enhancements

- **Enhancement 1: Enhanced Logging**
  - Description: Introduce more detailed logging to aid in debugging and analysis of test results.
  - Timeline: Considered for the upcoming sprint.


- **Enhancement 2: Parallel Execution**
  - Description: Enable parallel execution of tests to improve overall test suite efficiency.
  - Timeline: Investigating implementation feasibility.
  
  
## Contributors
- **Anish Kumar 2303474**



