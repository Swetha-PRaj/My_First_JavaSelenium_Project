#Author: swetha.pr@hcl.com
#Keywords Summary :
@4997_Validation_of_Commission_with_Store_User
Feature: TC 4997  Validation of Commission with Store User

  @4997_Validation_of_Commission_with_Store_User
  Scenario Outline: TC 4997  Validation of Commission with Store User
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp
    And Click on one of the item in All items tab
    Then validate commission field is displayed or not
    And commission filed should be disabled or read only

    Examples: 
      | User                    | Role       | Brand   | Country | Store             |
      | swetha.pr@storelens.com | Store User | WEEKDAY | Sweden  | Drottninggatan 63 |
