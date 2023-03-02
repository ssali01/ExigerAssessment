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
  To run tests on `virtual machine` from your local using maven command:
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
- 
### **Core Dependencies:**
```xml
        <!-- This is for base support for anything we do with selenium-->
<dependency>
  <groupId>org.seleniumhq.selenium</groupId>
  <artifactId>selenium-java</artifactId>
  <version>3.141.59</version>
</dependency>
        <!-- This is the dependency to manage web driver-->
<dependency>
<groupId>io.github.bonigarcia</groupId>
<artifactId>webdrivermanager</artifactId>
<version>5.3.0</version>
</dependency>

        <!-- cucumber java -->
<dependency>
<groupId>io.cucumber</groupId>
<artifactId>cucumber-java</artifactId>
<version>7.3.2</version>
</dependency>

        <!-- cucumber with JUnit4-->
<dependency>
<groupId>io.cucumber</groupId>
<artifactId>cucumber-junit</artifactId>
<version>7.3.2</version>
<scope>test</scope>
</dependency>

        <!-- for pretty report-->
<dependency>
<groupId>me.jvt.cucumber</groupId>
<artifactId>reporting-plugin</artifactId>
<version>7.3.0</version>
</dependency>
```

### **Core Plugins:**
```xml
            <!-- to execute tests in parallel from maven command line-->
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <parallel>methods</parallel>
                    <threadCount>4</threadCount>
                    <perCoreThreadCount>false</perCoreThreadCount>
                    <testFailureIgnore>true</testFailureIgnore>
                    <includes>
                        <include>**/CukesRunner*.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
```    

### Prepared by:  
Salma Sali