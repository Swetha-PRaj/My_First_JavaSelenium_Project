#Author: swetha.pr@hcl.com

@TC_3668_Verify_status_pop-up_view_for_multiple_items_with_same_item_status_in_All_Items_Screen
Feature: TC 3668 : Verify user is able to view item status pop-up for multiple items with same item status in All Items Screen.

  Scenario Outline: TC 3668 : Verify user is able to view item status pop-up for multiple items with same item status in All Items Screen.
    Given user able to launch ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    ## add back button method from home screen
    And searching for existing seller "<existingseller>","<tab>"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsold Item>" and click Next button and enter sign save it
    Then Select "5" items of status "Pending"
    Then Click on 3 dots and change the status to
    
    
    
    
    

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus |
      | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Sold          |
