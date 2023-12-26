#Author: swetha.pr@hcl.com
#Keywords Summary :
@6329_Validate_that_store_user_is_not_able_to_set_the_commission_at_seller_and_item_level
Feature: TC 6329 :US 6203: Validate that store user is not able to set the commission at seller and item level

  @6329_Validate_that_store_user_is_not_able_to_set_the_commission_at_seller_and_item_level
  Scenario Outline: TC 6329 :US 6203: Validate that store user is not able to set the commission at seller and item level
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    Then validate seller commission Field "Disabled"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsolditem>" and click Next button and enter sign save it
    Then Open the "Pending" item
    Then validate seller commission Field in Item page "Disabled"
    
    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller    | tab         | Number of Items | Unsolditem |
      | swetha.pr@storelens.com | Store User | WEEKDAY | Sweden  | Drottninggatan 63 | swetha.pr@hcl.com | All Sellers |               1 | Pickup     |
