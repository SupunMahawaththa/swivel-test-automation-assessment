
# Test Automation Assessment - Swivel Group

## Steps to Execution of the Project

1. Open the cloned project using your preferred Integrated Development Environment (IDE).
   > **Note:** I used Eclipse for this project.

2. Build the project.
   > **Note:** All the dependencies required for this project are added to the `pom.xml` file.

3. To execute this project, navigate to the `resources` folder and run the `testplan.xml` using TestNG Suite.
   > **Note:** If you do not have TestNG installed, please install it in your IDE.

   If you encounter an error while running the `testplan.xml` file, such as "TestNG by default disables loading DTD from unsecured URLs," you need to add the following code snippet to the Argument value (Run > Edit Configurations).
   
   ```
   -ea -Dtestng.dtd.http=true
   ```

   By modifying the `config.properties` file (located in the `resources` folder) and changing the browser value, you can run this test scenario on both Chrome and Edge.

4. After the execution is completed, the report will be generated in the `report` folder, and you can view the results by opening that report.

## Folder and File Structure

- **src**
  - `com.testautomation.qa.base` - Includes the Base class.
  - `com.testautomation.qa.extentReportListner` - Includes ExtentManager and TestListener classes.
  - `com.testautomation.qa.util` - Includes the WebEventListener class.

- **test**
  - `com.testautomation.qa.businessComponents` - Includes all the methods.
  - `com.testautomation.qa.pages` - Includes the object repository.
  - `com.testautomation.qa.testSuites` - Includes test cases.

- **resources**
  - `config.properties` - Includes URLs and browser configurations.
  - `testplan` - Includes the names of test cases to execute through the test plan.

- **datatable**

- **report**

- `pom.xml` - Includes all the dependencies.

## Challenges and Solutions

**Challenge:** On the Product Detail Page, a dynamic Price element can take on two different formats at different times.

**Solution:** To address this challenge, I've included both types of objects in the object repository using the "|" operator to accommodate the variability.
