
# BDD Cucumber Selenium Webdriver Java Test Automation Framework - ebay

This repository contains a collection of sample selenium-cucumber-java projects and libraries that demonstrate how to use the tool and develop automation script using the Cucumber BDD framework with Java as programming language. It generate extent reporters as well. It also generate error shots for your failed test cases.




## Documentation
* [Installations](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/installation.md)
* [Predefined Steps](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/canned_steps.md)

## Features

- **Maven** Project with all the framework dependencies
- Implemented **TestNG** Runner to run the framework
- **Single responsibility principle** to distribute the implementation into multiple Step definitions.
- **Dependency injection** to share the data between the Steps file
- **Page object** Pattern to drive the locators from page files
- **Factory Design pattern** by writing **PageObjectManager** class to create objects of all PO classes
- **driver** configured and distributed across the files in the framework
- **Utilities** for reusable Selenium methods
- **Cucumber Hooks** to capture Screenshots on test failures
- **Extent reports** to capture test results and **screenshots** on failures



## Instructions

- **JDK 1.8+** (make sure Java class path is set)
- **Maven** (make sure .m2 class path is set)
- Plugins for **TestNG, Cucumber, Natural in Eclipse/intelliJ**
- Fork/Clone repository or **download** zip and set it up in your local workspace.
- You can run the test locally simply by pasting the feature tag in **TestNGTestRunner.java** file
- Go to your project directory from terminal and hit following commands
```bash
mvn test 
mvn test "-Dbrowser=chrome" (to use chrome browser)
```
    
## Project Structure

![This is an image](https://user-images.githubusercontent.com/46919369/218550515-8bcfba0c-753b-448f-9913-6e3a1f56b1fa.PNG)


## Extent Reports

![App Screenshot](https://user-images.githubusercontent.com/46919369/218548626-db088421-4448-45ba-ba33-9225896a24f7.PNG)

- The Extent Reports are stored `test-output/SparkReport` folder

