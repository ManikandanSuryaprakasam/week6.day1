Feature: Login functionality of Leaftaps Application

Background:
Given Open the chrome browser
And load the application url

Scenario Outline: TC001_Login with positive credential
And Enter the username as <username>
And Enter the paswword as <password>

When Click on login button
Then HomePage should be displayed
Then driver should be closed 


Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|



Scenario: TC002_Login with Invalid credential
And Enter the username as 'Demo'
And Enter the paswword as 'crmsfa'

When Click on login button
But Error message should be displayed
Then driver should be closed 


