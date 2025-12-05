Feature: Login Test Cases

Scenario:
Login with valid username and password

Given user launch the application
Given user is on "LoginPage"
When user enter into textbox "username" "admin123@gmail.com"
When user enter into textbox "password" "admin123"
Then user click on login Button "login"
Given user is on "HomePage"
Then user click on Button "Home"
When user enter name into textbox "name" "ABC"
When user enter name into textbox "lastname" "XYZ"
Then user click on radiobutton "Female"
Then user verify the text "Heading" "Students Registration Form"



