#Author: neha.sain@hcl.com
#Keywords Summary :
@TC5240_5200_Verify_User_Is_Available_To_See_All_Sold_Item_In_New_Home_Screen_From_Resale_App
Feature: 5240_5200_Verify_User_Is_Available_To_See_All_Sold_Item_In_New_Home_Screen_From_Resale_App

  Scenario Outline: 5240_5200_Verify_User_Is_Available_To_See_All_Sold_Item_In_New_Home_Screen_From_Resale_App
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then Click to "Find Seller" under Common Tasks
    And user verify the Seller as "testerswathi135@gmail.com"

    Examples: 
      | User                    | Role  | Brand   | Country | Store             | existingseller            |
      | swetha.pr@storelens.com | Admin | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com |
