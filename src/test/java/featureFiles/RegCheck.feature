Feature: Checking Vehicle Data
  As a user
  I want to be able to search for a vehicle by its reg number
  So that I can check the details of the vehicle are correct

Scenario: Search for vehicle using spreadsheet data
  Given I have access to the spreadsheets that contain vehicle data
  And I have access to the correct web page
  When I enter a valid reg number from the spreadsheet
  Then I am returned the correct details
  And I can close down the browser