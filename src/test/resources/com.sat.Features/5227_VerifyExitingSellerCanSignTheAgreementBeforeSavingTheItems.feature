@5227_VerifyExitingSellerCanSignTheAgreementBeforeSavingTheItems
Feature: TC 5227 Verify user can sign the new agreement for newly created seller

  Scenario Outline: TC 5227 Verify user can sign the new agreement for newly created seller
    Given user go to login page "<url>" and click on Create an account link
    And enter the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    And click on Continue button
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    Then Select HM group employee and bank account check boxes
    And select the both of the checkboxes and enter the "<validIBANnumber>" and save it
    And Sign the agreement
    Then Login to Resalepportal "<url>","<Email>" and delete the created seller

    Examples: 
      | url                | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | existingseller    | tab         | invIBANNumber   | validIBANnumber | Brand   | Country | Store             |
      | resale_portal_url1 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | swetha.pr@hcl.com | All Sellers | invSbIBANnumber | sbIBANnumber    | WEEKDAY | Sweden  | Drottninggatan 63 |

      