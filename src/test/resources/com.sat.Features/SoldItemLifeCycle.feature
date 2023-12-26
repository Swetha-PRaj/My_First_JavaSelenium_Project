#Author: Swetha.pr@hcl.com
#Keywords Summary :
@Sold_Item_Life_Cycle
Feature: Showing full process of creating a seller, registering an item and sold that registered item.

  Scenario Outline: Showing full process of creating a seller, registering an item and sold that registered item.
   # Given user naviagtes to login page "<portal_url>" and click on Create an account link Name "<creatAccountlinkName>"
   # And check create account page should have required fields "<Language>"
   # And enter all the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
   # And click on Continue verify registered message "<success message>" and click on Ok
   # Given Login to Admin tool App
  #  Then change the Country "<Country>" and brand "<Brand>"
  #  When clicked on store Calendar then select store "<Store_Name>" and check the "<StoreStatus>"
  #  Then check calendar is generated for the "<serviceName>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
  #  When navigate to store settings
  #  When select brand "<Brand>" and country "<Country>"
  #  Then Select store "<Store_Name>"
   # And click on "<serviceName>" Settings
  #  Then check the display in portal view is "Enable" for the service
    Then User login to ResalePortal "<portal_url>" with registered credential "<Email>" and "<password>"
    When register an item with below fields "<Store>","<Brand>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    And selct the time slot which is enable "<availableSlot>"
    Then click on done
    When navigate to ResaleAppHomePage
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
    And click on "<status>" and enter  "Nike","Women","Hats","42","Never worn ","Leather","500","Hansa","2023","November","30","Charity" and save it
    Then change the status from "In Store" to "<Updatedstatus>"
    #And open the created item "In Store" to "<Updatedstatus>"
    Then Validate the mail "Sold! | Weekday 2nd-hand Curated"
    And run the job "SendEmail_Seller_SoldToWaitingForPayOut"
    And click on refresh button
    And searching for existing seller "<Email>","<tab>"
    Then check the status "Sold - waiting for pay out"
    And run the job "Seller_WaitingForPayOutToSoldArchive"
    And click on refresh button
    And searching for existing seller "<Email>","<tab>"
    Then open the created item "Sold Archive" and check the status
    Then delete all items
    Then remove created seller "<Email>" "<portal_url>"

    Examples: 
      | portal_url         | Brand   | Country | creatAccountlinkName | Language | Email              | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | success message          | password               | Store_Name | Store        | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | tab       | status  | Updatedstatus | validIBANnumber | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | serviceName | Unsold Item |
      #| resale_portal_url1 | WEEKDAY | Sweden  | Create an account    | English  | nehahhcl@gmail.com | swetha    | hcl      | 9876543210 | Marathalli     |      554678 | Banglore | Registered successfully. | resale_portal_password | Hansa      | Hansa, Malmö | Men    | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | All Items | Pending | Sold          | sbIBANnumber    | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | Resell      | Pickup      |
			| resale_portal_url1 | WEEKDAY | Sweden  | Create an account    | English  | v9833950@gmail.com | swetha    | hcl      | 9876543210 | Marathalli     |      554678 | Banglore | Registered successfully. | resale_portal_password | Hansa      | Hansa, Malmö | Men    | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | All Items | Pending | Sold          | sbIBANnumber    | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | Resell      | Pickup      |
			