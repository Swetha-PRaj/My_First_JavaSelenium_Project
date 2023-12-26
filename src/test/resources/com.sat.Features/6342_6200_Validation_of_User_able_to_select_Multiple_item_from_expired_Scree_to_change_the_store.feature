#Author: your.email@your.domain.com
#Keywords Summary :
@6342_6200_Validation_of_User_able_to_select_Multiple_item_from_AllItem_to_change_the_store_for_allbrand_in_Resale_Portal
Feature: TC 6342 6200 Validation of User able to select Multiple item from expired Scree to change the status for allbrand in Resale Portal2
  

  Scenario Outline: TC 6342_6200 Validation of User able to select Multiple item from expired Scree to change the status for allbrand in Resale Portal2
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsolditem>" and click Next button and enter sign save it
    And Generate unique ID for "<status>"and update the mandatory fields "ASOS","Men","Bags","40","Never worn","Cotton","Green","400","Drottninggatan 63","2024","October","15","C:/Users/hcladmin/Pictures/Screenshots/Screenshot.png" for "<num of items to be update>"
  #  Then select multiple item "<num of items to be update>" on items tab by selecting the checkbox
  #  And Click on three dots and "<change store>" for the selected items
  #  Then click on Save button
  
   
    Examples: 
      | existingseller    | tab       | Brand   | Country | Store             | Number of Items | brandCommission | Unsolditem | sellerCommission | status  | num of items to be update | change store | tab_screen |
      | swetha.pr@hcl.com | All Items | WEEKDAY | Sweden  | Drottninggatan 63 |               3 |              50 | Pickup     |               40 | Pending|                         3 | Change Store       | Storage    |
