@Courses
Feature: Test the functionality on Courses page 

Background:
  Given user is on login page
  When user clicks on Courses Link
  Then Courses Page must display
  When user clicks on Selenium Course Link 

Scenario: Test Child Window Functionality 
  Then child window must open
  When user get back to parent window
  Then verify user is on parent window
  
#Scenario: Test Hover Functionality on Child Window 
#  When user hovers and clicks on java
#  Then java page must get open