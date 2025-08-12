Feature: Login functionality on Practice Test Automation site

Background:
  Given user is on login page

Scenario Outline: Positive LogIn test
  When user enters <username> and <password>
  And clicks login button
  Then user logged in successfully to home page

Examples:
  | username | password    |
  | student  | Password123 |
  
Scenario: Negative username test
  When user enters "incorrectUser" and "Password123"
  And clicks login button
  Then error message is displayed for invalid username
  
Scenario: Negative password test
  When user gives "student" and "incorrectPassword" for login
  And clicks login button
  Then error message is displayed for invalid password