Feature: Validate checkout functionality
@Reg
Scenario: Validate the chekout functionality working

#Given user launch site url
And user enters valid username "standard_user" and password "secret_sauce"
Then user click on login button 
Then user add product into the basket from plp page
Then user navigate to cart page
And user enters information "Vinay" "yadav" "22100"
And user place order with cash on delivery
Then validate order confirmation

Scenario: Validate checkout without entering the information
#Given user launch site url
And user enters valid username "standard_user" and password "secret_sauce"
Then user click on login button 
Then user add product into the basket from plp page
Then user navigate to cart page
And user enters information "" "" ""
Then validate error message
