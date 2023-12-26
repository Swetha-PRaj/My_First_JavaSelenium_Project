#Author: swetha.pr@hcl.com
#Keywords Summary :
@TC_6340_Validate_Size_drop_down_order_from_small_to_big_sizes_(XXS-3XL)_and_then_numbers
Feature: TC 6340: US 6205 : Validate Size drop down order from small to big sizes (XXS-3XL) and then numbers

  @TC_6340_Validate_Size_drop_down_order_from_small_to_big_sizes_(XXS-3XL)_and_then_numbers
  Scenario Outline: TC 6340: US 6205 : Validate Size drop down order from small to big sizes (XXS-3XL) and then numbers
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsolditem>" and click Next button and enter sign save it
    And Open the "<status>" item and validate

    Examples: 
      | url                | Email             | existingseller    | tab       | Brand   | Country | Store             | Number of Items | brandCommission | Unsolditem | sellerCommission | status  | num of items to be update |
      | resale_portal_url1 | swetha.pr@hcl.com | swetha.pr@hcl.com | All Items | WEEKDAY | Sweden  | Drottninggatan 63 |               1 |              50 | Pickup     |               40 | Pending |                        18 |
