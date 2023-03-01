## This is a Cucumber framework project designed to automate testing of web applications.

### Prerequisites:
- JAVA Development Kit (JDK) installed on your machine
- An Integrated Development Environment (IDE) such as Eclipse/IntelliJ
- Maven installed on your machine
- Internet connection for downloading dependencies

### Installation:
1. Clone the project repo from GitHub onto your machine using command:
        
```git clone https://github.com/ssali2022/ExigerAssessment```

or simply click on this direct link: [link](https://github.com/ssali2022/ExigerAssessment)

2. Open your IDE and import the project as a Maven project.
3. Wait for Maven to download all the required dependencies.

### Running the tests:

- To run the tests on your local machine, navigate to the root directory of the project and run the command on the terminal:
```mvn clean test```
- 
  To change `browser type` on your local using maven command:
```
mvn test -DBROWSER=remote-chrome
```

To define `test case by tag` using maven command:
```
mvn test -Dcucumber.filter.tags=@smoke
```

### Viewing the report:
After running the tests, navigate to the target folder and open the cucumber-reports folder. Locate `target/cucumber-report.html`

### **Acknowledgements**
***This project was built with the help of the following tools:***
- Cucumber
- Selenium WebDriver
- Junit4
- Maven
- Java

### Prepared by: ###  
Salma Sali