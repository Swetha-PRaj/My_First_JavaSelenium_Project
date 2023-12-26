#Author: swetha.pr@hcl.com
#Keywords Summary :
@4995_Validation_of_Commission_Set_at_the_Brand_Level
Feature: TC 4995 Validation of Commission Set at the Brand Level

  @4995_4991_Validation_of_Commission_Set_at_the_Brand_Level
  Scenario Outline: TC 4995 Validation of Commission Set at the Brand Level
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
     And searching for existing seller "<existingseller>","<tab>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp
    Then navigate to brand settings update commission "<brandCommission>"
    Then validate Brand commission
  #  Then user login to ResaleApp and search for "<existingseller>","<tab>"
  #  And click on Add Item button and enter "1" and select "<Unsolditem>" and click Next button and enter sign save it
    And clickng on "<status>" and fill details "zara","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity"
  #  And update item commission and validate
    #  | -40 |
    #  |  50 |
    #  | 180 |
    #  |  75 |

    Examples: 
      | User                    | Role          | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsolditem | status  | Updatedstatus | brandCommission |
      | swetha.pr@storelens.com | Admin         | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup     | Pending | Sold          |              40 |
    #  | swetha.pr@storelens.com | Brand User    | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup     | Pending | Sold          |              40 |
    #  | swetha.pr@storelens.com | Store Manager | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup     | Pending | Sold          |              40 |
