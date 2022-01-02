Feature: Duplicate Lead functionality of Leaftaps Application

Background:
Given Open the chrome browser
And load the application url
And Enter Login details and Click login

Scenario: TC002_Duplicate Lead 
And Click on the Leads link
And Find leads by Phone number

When Click on Duplicate button
Then View the Duplicate record
Then driver should be closed
