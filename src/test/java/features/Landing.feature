@ValidateProductViaCategoryAndSearch @Regression 
Feature: Validate a Product via category via category and Search on ebay 

@ValidateProductViaCategory 
Scenario: Validate a Product via category after applying multiple filters 
	Given User is on the eBay homepage 
	When User navigates to Search by category 
	Then User navigates CellPhone and Accesories under Electronics 
	When User navigates to CellPhone and SmartPhone under Navigation section 
	Then User navigates to See All section 
	When User adds filters to Screen, Prize and Item location and Applies 
	Then User verifies if all the filters are applied 
	
@ValidateProductViaSearch 
Scenario: Validate a Product via search after searching particular product 
	Given User is on the eBay homepage 
	When User searches for "MacBook" 
	Then User changes the search category to "Computers/Tablets & Networking" 
	When User searches for product 
	Then User verifies if the page is loaded completely 
	And User verifies if the search string matches the first result name 
	
	
	
	
	
	
	
	
	
