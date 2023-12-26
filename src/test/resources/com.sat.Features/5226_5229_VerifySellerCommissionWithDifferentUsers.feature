#Author: swetha.pr@hcl.com
#Keywords Summary :
@5226_5229_Validate_Seller_Commission_with_different_User_roles
Feature: TC 5226 Validate Seller Commission with different user roles

  @5226_5229_Validate_Seller_Commission_with_different_User_roles
  Scenario Outline: TC 5226 Validate Seller Commission with different User roles
    When user navigating to ResaleApp with valid credentials and signin
    Then click on back button
    And select "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp and search for "<existingseller>","<tab>"
    Then change the seller commission "<sellerCommission>"
    Then navigate to Items Tab
    And click on Add Item button and enter "3" and select "<Unsolditem>" and click Next button and enter sign save it
    #Then open the "Pending" item and validate the commission with "<sellerCommission>"   --------- this step is created but not using
    And clickng on "<status>" and fill details "zara","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity"
    And update item commission and validate
      | -40 |
      |  50 |
      | 180 |

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsolditem | status  | Updatedstatus | sellerCommission |
      | swetha.pr@storelens.com | Admin      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup     | Pending | Sold          |               40 |
      #| swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup     | Pending | Sold          |               40 |
