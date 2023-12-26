#Author: neha.sain@hcl.com
#Keywords Summary :
@TC5216_5217_5219_Resale_app
Feature: TC 4995 Validation of Commission Set at the Brand Level

  @5216_5200_Validation_of_Commission_Set_at_the_Brand_Level
  Scenario Outline: TC5216 Validation of Commission Set at the Brand Level
    When user navigating to ResaleAppHomePage with valid credentials and signin
    #And select "<Brand>","<Country>","<Store>"
    Then verify all tabs are appearing on the Action Needed
      | PENDING | STORAGE | EXPIRED | PRE \nREGISTERED |
    Then verify all tabs are appearing on the Common Task
      | Find Seller | Search Item | Scan QR |
    Then verify all tabs are appearing on the Sales Data
      | This month | SOLD ITEMS | GOAL : 5 items | Edit |
    And verify upcoming booking with the date format

    Examples: 
      | User                    | Role  | Brand   | Country | Store             | existingseller            |
      | swetha.pr@storelens.com | Admin | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com |

     # @TC5217_5200_Verify_User_Is_Available_To_Find_The_Seller_From_New_Home_Screen_From_Resale_App

#Feature: 5217_5200_Verify_User_Is_Available_To_Find_The_Seller_From_New_Home_Screen_From_Resale_App

  Scenario Outline: 5217_5200_Verify_User_Is_Available_To_Find_The_Seller_From_New_Home_Screen_From_Resale_App
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then Click to "Find Seller" under Common Tasks
    And user verify the Seller as "testerswathi135@gmail.com"

    Examples: 
      | User                    | Role  | Brand   | Country | Store             | existingseller            |
      | swetha.pr@storelens.com | Admin | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com |
   
   
   
   # @TC5219_Verify_User_Is_Available_To_Find_The_Item_From_New_Home_Screen_From_Resale_App
#Feature: 5219_5200_Verify_User_Is_Available_To_Find_The_Item_From_New_Home_Screen_From_Resale_App

  Scenario Outline: 5219_5200_Verify_User_Is_Available_To_Find_The_Item_From_New_Home_Screen_From_Resale_App
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    And searching for existing seller "<existingseller>","<tab>"
    And click on AddItem button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    Then get Id for the item
      | Pending |
    And click on cancel button and ok
    Then User Click on WeekDay on Left Panel
    Then Click to "Search Item" under Common Tasks and user verify the Item

    # Then User Click on WeekDay on Left Panel
    # And click on Add Item button and enter "<Number of Items>" and select "<Unsold Item>" and click Next button and enter sign save it
    # And click on "<status>" item and generate id by clicking on edit button and save it
    Examples: 
      | User                    | Role  | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  |
      | swetha.pr@storelens.com | Admin | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending |
      