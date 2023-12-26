#Author: swetha.pr@hcl.com
#Keywords Summary :
@5235_ValidationOfCountrylevelCommissionDetailsForNewlyCreatedSellerAndItems
Feature: TC 5235 Validation of Country level Commission details for newly created seller and items

  Scenario Outline: TC 5235 Validation of Country level Commission details for newly created seller and items
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    Then navigate to brand settings update commission "<brandCommission>"
    #Given user go to login page "<url>" and click on Create an account link
    #And enter the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    #And click on Continue button
    Then open resale app
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    Then Verify the commission field
    Then validate seller commission with "<brandCommission>"
    #Then Select HM group employee and bank account check boxes
    #And select the both of the checkboxes and enter the "<validIBANnumber>" and save it
    #And Sign the agreement
    #######Then navigate to Items Tab
    And click on Add Item button and enter "1" and select "<Unsolditem>" and click Next button and enter sign save it
    Then open the "Pending" item and validate the commission with "<brandCommission>"
    Then Login to Resalepportal "<url>","<Email>" and delete the created seller

    Examples: 
      | url                | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | existingseller    | tab         | invIBANNumber   | validIBANnumber | Brand   | Country | Store             | brandCommission | Unsolditem | sellerCommission |
      | resale_portal_url1 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | swetha.pr@hcl.com | All Sellers | invSbIBANnumber | sbIBANnumber    | WEEKDAY | Sweden  | Drottninggatan 63 |              50 | Pickup     |               40 |
