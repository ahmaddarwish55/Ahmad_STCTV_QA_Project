# QA Task for validating packages (Type, Price and Currency) for https://subscribe.stctv.com/

the project is created with IntelliJ IDEA 2023.1.1, Maven Libraries used: Selenuium WebDrive , TestNG, jackson



## Requirements

- JDK V 11.0.18
- IntelliJ IDEA 2023.1.1
- chromedriver

## Using The Project

the project aim to test packages in both languages "AR", "EN"
please set the chromedriver path in config.properties
#ChromeDriver=D:/Driver/chromedriver.exe
by defualt it is testing arabic language 
you can test for inglish by set langauge variable in config.properties to language = en
#Language = en
please configure the run configuration for test report directory to genrate test report in .idea/workspace.xml
#<option name="OUTPUT_DIRECTORY" value="$PROJECT_DIR$/../Ahmad_STCTV_QA_Project\src\main\output" />
there are 2 json files contain testing data for each language "ar-data.json", "en-data.json" containg country packages info


