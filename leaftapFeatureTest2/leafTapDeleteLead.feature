Feature: Delete Lead functionality of Leaftaps Application

Background:
Given Open the chrome browser
And load the application url
And Enter Login details and Click login

Scenario: TC002_Delete Lead 
And Click on the Leads link
And Find leads by Phone number

When Click on Delete button
Then View the deleted record
Then Search by deleted Lead No records to display message should be displayed
Then driver should be closed
