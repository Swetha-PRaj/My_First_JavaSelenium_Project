@manageruser
Feature: Test admin user able to change the role

  Scenario Outline: Verify admin user is able to change the role of the user
    Given User is login to Resale app with admin credentials
    Then click on back button in Home Page
    When selecting "<Brand>","<Country>","<Store>"
    And search with existing seller "<existingseller>","<tab>"
    And click on AddItem button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    And click on "<status>" and enter  "Biba","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And naviagte to manage users section and search with "<User>" and select role to "<Role>",store to "<Store>" and save it
    And user launch ResaleApp with valid credentials and signin and selecting "<Brand>","<Country>","<Store>"
    And search with existing seller "<existingseller>","<tab>" 
    Then click on "In Store" and check "price" field is disable

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  |
      #| swetha.pr@storelens.com | Admin      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending |
      | swetha.pr@storelens.com | Store User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending |
