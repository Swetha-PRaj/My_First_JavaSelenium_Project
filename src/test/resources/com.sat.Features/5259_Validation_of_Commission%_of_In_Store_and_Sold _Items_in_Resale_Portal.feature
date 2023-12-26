#Author: your.email@your.domain.com
#Keywords Summary :
@5259_Validation_of_Commission_%_of_InStore_and_Sold_Items_in_Resale_Portal
Feature: TC 5259 Validation of Commission % of In Store and Sold  Items in Resale Portal

  @5259_Validation_of_Commission_%_of_InStore_and_Sold_Items_in_Resale_Portal
  Scenario Outline: TC 5259 Validation of Commission % of In Store and Sold  Items in Resale Portal
    #Given user go to login page "<url>" and click on Create an account link
    #And enter the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    #And click on Continue button
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
   # And search for existing seller "<existingseller>","<tab>"
   # Then Select HM group employee and bank account check boxes
   # And select the both of the checkboxes and enter the "<validIBANnumber>" and save it
   # And Sign the agreement
    And click on Add Item button and enter "<Number of Items>" and select "<Unsolditem>" and click Next button and enter sign save it
    And Generate unique ID for "<status>" and update the mandatory fields "Adidas","Men","Bags","40","Second hand","Cotton","Green","400","Drottninggatan 63","2024","October","15","C:/Users/hcladmin/Pictures/Screenshots/Screenshot.png" for "<num of items to be update>"
   # And click on "<status>" item and generate id by clicking on edit button and save it
    #And click on cancel button and ok
    And get the Item id for "<num of items to be update>" "In Store" items, navigate to status update tab and change the status to
      | In Store 2nd try              |
      | Expired                       |
      | Missing                       |
      | Broken                        |
      | Broken - waiting for pay out  |
      | Sold - waiting for pay out    |
      | Missing - 2nd Payout          |
      | Sold                          |
      | Sold - Payout Failure         |
      | Missing - waiting for pay out |
      | Sold Archive                  |
      | Missing Archive               |
      | Broken - 2nd Payout           |
      | Broken - Payout Failure       |
      | Broken Archive                |
      | Sold - 2nd Payout             |
      | Missing - Payout Failure      |
     

    Examples: 
      | url                | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | existingseller    | tab       | invIBANNumber   | validIBANnumber | Brand   | Country | Store             | Number of Items | brandCommission | Unsolditem | sellerCommission | status  | num of items to be update |
      | resale_portal_url1 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | swetha.pr@hcl.com | All Items | invSbIBANnumber | sbIBANnumber    | WEEKDAY | Sweden  | Drottninggatan 63 |              19 |              50 | Pickup     |               40 | Pending |                        18 |
