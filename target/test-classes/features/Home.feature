@Home
Feature: Testing Functionalities on Home Page

Background: 
  Given user is on login page
  When user clicks on Home Link

Scenario: Verifying if user is on Home Page
  Then "Hello" message is displayed
  And Image is also displayed
  Then verify welcome message
  And verify that Experience Discription is available
  Then verify Courses and Achievements Discriptions are available
  And verify Blog and Courses Link tag are present
  Then Check if footer section is present or not

Scenario: Check wheather SignUp for Newsletter is working properly
  When Enter "Pratik" and "HD@gmail.com"
  When Click on Get xpath button
  Then Verify You are on Confirmation Page
  When Get back to Home Page
  Then Verify You are on Home Page