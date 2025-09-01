@Contact
Feature: Test Contact Page Functionality 

Scenario: Give Credentials and submit the page 
  Given user is on login page
  When user clicks on Contact Link
  Then Contact page must get open 
  When user enters the following details
  |      Pratik        |
  |      Singh         |
  |   HD@gmail.com     |
  |  Muchas Gracias    |
  And user clicks the captcha box
  When user clicks the submit button
  Then Thanks message must appear