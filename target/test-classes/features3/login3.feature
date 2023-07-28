Feature: Validating the user login
@Reg
Scenario Outline: Validating login of user with valid details
#Scenario: Validating login of user with valid details
#kya bhai
#Given user launch site url
#And user enter valid details
#And user enters valid username "standard_user" and password "secret_sauce"
And user enters valid username "<username>" and password "<password>"
Then user click on login button
Then validate user login 

#Scenario: Validating login of user with invalid details
#Given user launch site url
And user enters valid username "standard_userwa" and password "secret_sauce"
Then user click on login button
Then validate user login 

Examples:
|username|password|
|test|automation|
|test1|automation1|