Feature: Login

@sanity
Scenario: Successful Login with valid credentials
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "admin@yourstore.com" and password as "admin"
	And Click on login
	Then Page Title Should be "Dashboard / nopCommerce administration"
	When User click on the Log out
	Then Page Title Should be "Your store. Login"
	And close browser
	
@sanity
Scenario Outline: Data Driven Login
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "<email>" and password as "<password>"
	And Click on login
	Then Page Title Should be "Dashboard / nopCommerce administration"
	When User click on the Log out
	Then Page Title Should be "Your store. Login"
	And close browser
	
	Examples:
		| email | password |
		| admin@yourstore.com | admin |
		| admin@yourstore.com | admin |