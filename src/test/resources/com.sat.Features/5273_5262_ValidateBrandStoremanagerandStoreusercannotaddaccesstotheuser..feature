#Author: your.email@your.domain.com
#Keywords Summary : Store Open  Store Close Absolete
@5273_5262_Validate_Brand_Store_manager_and_Store_user_cannot_add_access_to_the_user.
Feature: TC 5266 :Validate Brand, Store manager and Store user cannot add access to the user.

  @TC_5273-Validate_Brand_Store_manager_and_Store_user_cannot_add_access_to_the_user.
  Scenario Outline: Validate Brand, Store manager and Store user cannot add access to the user.
    When Login to powerapp with valid credentials and sigin
    When User select "<Country>" and "<Brand>"
    And naviagte to powerapp manage users section and search with "<User>" and select role to "<Role>" and save it
    Given User Navigate to New Admin Tool App
    When User select "<Country>" and "<Brand>"
    Then user scroll down to till element is visible in Admin Tool

    Examples: 
      | User                    | Role       | Brand   | Country | Store             |
      | swetha.pr@storelens.com | StoreAdmin | WEEKDAY | Sweden  | Drottninggatan 63 |
    #  | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  |
   #   | swetha.pr@storelens.com | StoreAdmin | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending |
    #  | swetha.pr@storelens.com | StoreStaff | monki | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |          1 | Pickup     | Pending | 
