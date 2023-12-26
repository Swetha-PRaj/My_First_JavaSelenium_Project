Feature: TC 5226 Validate Seller Commission with different user roles

  @5226_5229_Validate_Seller_Commission_with_different_User_roles
  Scenario Outline: TC 5226 Validate Seller Commission with different User roles
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<Store_Name>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<serviceName>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When navigate to store settings
    When select brand "<Brand>" and country "<Country>"
    Then Select store "<Store_Name>"
    And click on "<serviceName>" Settings
    Then check the display in portal view is "Enable" for the service
    Then User login to ResalePortal "<portal_url>" with registered credential "<Email>" and "<password>"
    When register an item with below fields "<Store>","<Brand_name>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    And selct the time slot which is enable "<availableSlot>"
    Then click on done
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    And user is selecting "<Brand>","<Country>","<Store_Name>"
    And searching for existing seller "<Email>","<tab>"
    Then Select HM group employee and bank account check boxes
    And select the both of the checkboxes and enter the "<validIBANnumber>" and save it
    And Sign the agreement
    Then save the seller settings
    Then sign agreement for "Pre registered" item
    And clickng on Add Item button and enter "1", select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    Then close the item
   # And clickng on "<status>" and fil details "zara","Women","Hats","42","Never worn ","Leather","Green","500","Drottninggatan 63","2023","November","30","Charity" and save it
    Then change the status from "In Store" to "<Updatedstatus>"

    Examples: 
      | portal_url         | Brand   | Country | creatAccountlinkName | Language | Email              | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | success message          | password               | Store_Name | Store        | Brand_name | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | tab       | status  | Updatedstatus | validIBANnumber | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | serviceName | Unsold Item |
      | resale_portal_url1 | WEEKDAY | Sweden  | Create an account    | English  | v9833950@gmail.com | swetha    | hcl      | 9876543210 | Marathalli     |      554678 | Banglore | Registered successfully. | resale_portal_password | Hansa      | Hansa, Malmö | Other      | Men    | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | All Items | Pending | Sold          | sbIBANnumber    | Store Open  |       11 |     2023 | May       |     11 |   2024 | May     | Resell      | Pickup      |
     # | resale_portal_url1 | WEEKDAY | Sweden  | Create an account    | English  | v9833950@gmail.com | swetha    | hcl      | 9876543210 | Marathalli     |      554678 | Banglore | Registered successfully. | resale_portal_password | Hansa      | Hansa, Malmö | Other      | Men    | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | All Items | Pending | Sold          | sbIBANnumber    | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | Resell      | Pickup      |
