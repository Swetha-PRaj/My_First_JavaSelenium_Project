#Author: swetha.pr@hcl.com
#Keywords Summary :
@5769_Validation_of_Seller_in_Resale_App_for_ARKET_SE
Feature: TC 5769 : US 5522: Validation of Seller in Resale App for ARKET, SE

  @5769_Validation_of_Seller_in_Resale_App_for_ARKET_SE
  Scenario Outline: TC 5769 : US 5522: Validation of Seller in Resale App for ARKET, SE
    When user navigating to ResaleApp with valid credentials and signin
    #Then click on back button in Home Page
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    Then validate the seller "<existingseller>"

    Examples: 
      | existingseller         | tab         | Brand | Country | Store             | new seller             |
      | swethahcl960@gmail.com | All Sellers | ARKET | Sweden  | Drottninggatan 56 | swethahcl960@gmail.com |
