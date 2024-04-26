Feature: Customer

	Background: Common Steps
		Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view dashboard
   
  @sanity 
  Scenario: Add a new customer
    When User Click on customer menu
    And Click on Customer menu item
    And Click on add new
    Then User can view add new customer page
    When Enter Customer Info Email  as "<email>" password as "<password>" Firstname as "<firstname>" Lastname as "<lastname>" gender as "<gender>" company as "<company>" tax as "<tax>" news as "<news>" role as "<role>" vendor as "<vendor>" comment as "<comment>" 
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully."
		And close browser
		
		Examples:
			| email | password | firstname | lastname | gender | company | tax | news | role | vendor | comment |
			| test10@gmail.com | admin | sai | reddy | male | atos | Yes | Your store name | Vendors | Vendor 1 | NA |
	
	@regression
	Scenario: Search Customer By EmailID
    When User Click on customer menu
    And Click on Customer menu item
    And Enter Customer Email as "<email>"
    And close browser
    
    Examples:
    	| email |
    	| admin@yourStore.com |