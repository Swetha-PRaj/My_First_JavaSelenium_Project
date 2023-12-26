#Author: your.email@your.domain.com
#Keywords Summary : Store Open  Store Close
@TC6064_6067_6068_5742_Validate_in_Item_details_page_Unsold_item_field_and_Store_field_is_hidden_when_we_open_item_from_screen
Feature: US 5742 :Validate in Item details page Unsold item field and Store field is hidden when we open item from Instore screen.

  @TC_6064_6067_6068_Validate_in_Item_details_page_Unsold_item_field_and_Store_field_is_hidden_when_we_open_item_from_Instore_screen.
  Scenario Outline: Verify user is not able to see Unsold item field and Store field in the Unsold item status
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    When selecting "<Brand>","<Country>","<Store>"
    Then User navigated to "<tab>" tab
    #Then Verify column "<pending_Col>" are not appering on the screen
    #  | UnSold Status |
    And open Item and validate "<field>" are not appering on the screen is not present

    Examples: 
      | Brand   | Country | Store             | existingseller            | tab     | Number of Items | Unsold Item | status  | Updatedstatus | Unsold      | pending_Col   | field         |
      #  | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | In-Store         |               1 | Pickup      | Pending | Sold          | unsold item | UnSold Status | Unsold item * |
      # | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | In-Store 2nd Try |               1 | Pickup      | Pending | Sold          | unsold item | UnSold Status | Unsold item * |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | Pending |               1 | Pickup      | Pending | Sold          | unsold item | UnSold Status | Unsold item * |

  @TC_6064_6067_6068_Validate_in_Item_details_page_Unsold_item_field_and_Store_field_is_hidden_when_we_open_item_from_Instore_screen.
  Scenario Outline: Verify user is not able to see Unsold item field and Store field in the Unsold item status
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    When selecting "<Brand>","<Country>","<Store>"
    Then User navigated to "<tab>" tab
    #Then Verify column "<pending_Col>" are not appering on the screen
    #  | UnSold Status |
    And open Item and validate "<field>" are not appering on the screen is not present

    Examples: 
      | Brand   | Country | Store             | existingseller            | tab              | Number of Items | Unsold Item | status  | Updatedstatus | Unsold      | pending_Col   | field         |
      #  | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | In-Store         |               1 | Pickup      | Pending | Sold          | unsold item | UnSold Status | Unsold item * |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | In-Store 2nd Try |               1 | Pickup      | Pending | Sold          | unsold item | UnSold Status | Unsold item * |
