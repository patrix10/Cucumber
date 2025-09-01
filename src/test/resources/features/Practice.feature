@Practice
Feature: Test the Practice Page

Background:
  Given user is on login page
  When user clicks on Practice Link
  And click on Test Exceptions Link

Scenario: Testing Exceptions pannel on Practice Page
  Then verify you are on Exceptions Page

Scenario: Test NoSuchElementException
  When click on Add button
  Then See that new Row input field is displayed

Scenario: Test ElementNotInteractableException
  When click on Add button
  And Type text into the second input field
  When Push Save button

Scenario: Test InvalidElementStateException
  When Clear input field
  And Type text into the input field

Scenario: Test StaleElementReferenceException
  When Find the instructions text element
  When click on Add button
  Then Verify instruction text element is no longer displayed

Scenario: Test TimeoutException
  When click on Add button
  And Wait for 3 seconds for the second input field to be displayed
  
Scenario: Test Positive Input List Testing
  When click on Add button
  And Enter "Burger" in input field with different locator
  When Push Save button
  And push remove button
  Then Verify text removed