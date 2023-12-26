#Author: neha.sain@hcl.com
#Keywords Summary : Store Open  Store Close
@TC6063_6065_6102_5742_Verify_Unsold_item_status_column_is_hidden_in_Pending_screen_in_Resale_app
Feature: TC 6064 6065 6102 :Verify Unsold Item Status (Pending/Charity) column is to be hidden in Pending Screen of Resale app

  @6063_6065_6102_5742_Verify_Unsold_item_status_(Pickup/Charity)_column_is_hidden_in_Pending_screen_in_Resale_app
  Scenario Outline: Verify Unsold Item Status (Pending/Charity) column is to be hidden in Pending Screen of Resale app
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    When selecting "<Brand>","<Country>","<Store>"
    Then User navigated to "<tab>" tab
    Then Verify column "<pending_Col>" are not appering on the screen
      | UnSold Status |

    #   | Items ID | Date | Category | Brand | Size | Price | UnSold Status | Status |
    Examples: 
      | Brand   | Country | Store             | existingseller            | tab              | Number of Items | Unsold Item | status  | Updatedstatus | Unsold      | pending_Col   |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | In-Store         |               1 | Pickup      | Pending | Sold          | unsold item | UnSold Status |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | In-Store 2nd Try |               1 | Pickup      | Pending | Missing       | unsold item | UnSold Status |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | Pending          |               1 | Pickup      | Pending | Missing       | unsold item | UnSold Status |
   