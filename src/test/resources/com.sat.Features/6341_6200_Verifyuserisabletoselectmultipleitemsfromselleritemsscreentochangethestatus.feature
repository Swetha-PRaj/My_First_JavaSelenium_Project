#Author: neha.sain@hcl.com
#Keywords Summary :
@TC6341_6200_Verifyuserisabletoselectmultipleitemsfromselleritemstochangethestatus
Feature: 6346200: Verify user is able to select multiple items from seller items screen to change the status for all Brands.

  Scenario Outline: 6341_6200_Verify_user_is_able_to_select_multiple_items_from_seller_items_screen_to_change_the_status_for_all_Brands.
   
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsolditem>" and click Next button and enter sign save it
    And Generate unique ID for "<status>"and update the mandatory fields "ASOS","Men","Bags","40","Never worn","Cotton","Green","400","Drottninggatan 63","2024","October","15","C:/Users/hcladmin/Pictures/Screenshots/Screenshot.png" for "<num of items to be update>"
    Then select multiple item "<num of items to be update>" on "<tab>" by selecting the checkbox
    And Click on three dots and "<change store>" for the selected items
    
    Examples: 
      | existingseller    | tab       | Brand   | Country | Store             | Number of Items | brandCommission | Unsolditem | sellerCommission | status  | num of items to be update | change store | tab_screen |
      | swetha.pr@hcl.com | All Items | WEEKDAY | Sweden  | Drottninggatan 63 |               3 |              50 | Pickup     |               40 | Pending|                         3 | Broken      | Storage    |
   

   