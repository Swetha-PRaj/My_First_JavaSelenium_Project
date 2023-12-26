#Author: your.email@your.domain.com
#Keywords Summary :
@4998_Verify_Seller_Commission_%_always_overrides_the_Item_commission_%
Feature: TC 5235 Validation of Country level Commission details for newly created seller and items

  Scenario Outline: TC 5235 Validation of Country level Commission details for newly created seller and items
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    Then Verify the commission field
    ####And Go to items Tab     -------- created this step but not using we can use this for future
    And click on Add Item button and enter "1" and select "<Unsolditem>" and click Next button and enter sign save it
    And clickng on "<status>" and fill details "Addidas","Women","Hats","42","Never worn ","Leather","Green","500","Drottninggatan 63","2023","November","30","Charity"
    ###Then open the item "Pending"
    Then Verify the commission field

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsolditem | status  | Updatedstatus | brandCommission |
      | swetha.pr@storelens.com | Admin      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup     | Pending | Sold          |              40 |
      | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup     | Pending | Sold          |              40 |
