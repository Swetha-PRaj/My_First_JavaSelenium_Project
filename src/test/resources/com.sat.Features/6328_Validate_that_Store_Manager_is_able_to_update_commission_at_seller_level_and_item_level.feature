#Author: Swetha.pr@hcl.com
#Keywords Summary :
@6328_Validate_that_Store_Manager_is_able_to_update_commission_at_seller_level_and_item_level
Feature: TC 6328:US 6203: Validate that Store Manager is able to update commission at seller level and item level

  @6328_Validate_that_Store_Manager_is_able_to_update_commission_at_seller_level_and_item_level
  Scenario Outline: TC 6328:US 6203: Validate that Store Manager is able to update commission at seller level and item level
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    Then Verify the commission field
    Then update seller comission "50"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsolditem>" and click Next button and enter sign save it
    Then Open the "Pending" item
    And update item commission and validate
      | -40 |
      | 180 |
      |  50 |
    Then save pending item

    Examples: 
      | User                    | Role          | Brand   | Country | Store             | existingseller    | tab         | Number of Items | Unsolditem |
      | swetha.pr@storelens.com | Store Manager | WEEKDAY | Sweden  | Drottninggatan 63 | swetha.pr@hcl.com | All Sellers |               1 | Pickup     |
