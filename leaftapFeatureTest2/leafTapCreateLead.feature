Feature: Create Lead functionality of Leaftaps Application

Background:
Given Open the chrome browser
And load the application url
And Enter Login details and Click login

Scenario: TC001_Create Lead with valid Names
And Click on the Leads link
And click on the Create Leads link
And Enter Mandatory fields companyName,firstName,lastName,primaryPhoneCountryCode,primaryPhoneNumber

When Click on submit button
Then View Lead page should be displayed
Then Company Name should be displayed
Then driver should be closed
