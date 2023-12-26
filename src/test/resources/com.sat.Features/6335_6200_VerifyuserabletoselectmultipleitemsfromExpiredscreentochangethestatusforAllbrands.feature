#Author: neha.sain@hcl.com
#Keywords Summary : Store Open  Store Close
@TC6335_6200_Verify_user_is_able_to_select_multiple_items_from_Expired_screen_to_change_the_status_for_All_brands
Feature: TC 6335 6200 :Verify user is able to select multiple items from Expired screen to change the status for All brands

  @6335_6200_Verify_user_is_able_to_select_multiple_items_from_Expired_screen_to_change_the_status_for_All_brands
  Scenario Outline: Verify user is able to select multiple items from Expired screen to change the status for All brands
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    When selecting "<Brand>","<Country>","<Store>"
    Then User navigated to "<tab>" tab
       Then select multiple item "<num of items to be update>" on "<tab>" by selecting the checkbox
    And Click on three dots and "<change store>" for the selected items

    Examples: 
      | Brand   | Country | Store             | existingseller            | tab     | num of items to be update | Unsold Item | status  | Updatedstatus | Unsold      | change store|
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | Expired |                         3 | Pickup      | Pending | Sold          | unsold item | Broken|
