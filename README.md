# IE2E-Test-FileReader
IDENTITY E2E – Test 4 - Java Exercise

## Technologies used
> Java | JUnit | Selenium | Cucumber | Gherkin | Ecplise | Git

## How to run

Clone this directory

Change the TEST_PATH and DRIVER_PATH constants (in src/test/java/Constants/Constants) to the location of the test_files folder in the project directory:

![Screenshot](https://i.gyazo.com/cf2a1e39c10bc12f6bd7e1e689755ff2.png)

Run mvn install
    
Run the TestRunner_RegCheckerWebPage class as a junit test

## Brief
Part 1:

Write a Service layer bean to do the following:

    1. Scan configured directory in file system which will return this information --> filename, file mime type, file size, file extension

    2. Use a directory containing a reasonably large number of files, minimum 10.

    3. Provide a way to retrieve certain supported mime type files: configure excel and csv are supported currently

Part 2:

Write a selenium/cucumber framework to do the following:

    1. Use the above service layer bean to get supported files (excel or csv are supported, from input directory)

    2. Go through the file and read vehicle registration details in the file.

    3. Open webpage : https://www.gov.uk/get-vehicle-information-from-dvla and go through all vehicles from excel/csv file.

    4. On the Vehicle details page assert the details (Make/Color) match with expected output in excel/csv file.


## Screenshot
![Screenshot](https://i.gyazo.com/8c799b0598235b39a05c7f8121fee53b.png)
