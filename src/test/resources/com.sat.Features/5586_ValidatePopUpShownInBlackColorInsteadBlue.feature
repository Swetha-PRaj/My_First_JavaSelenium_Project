@TC5637_ResalValidation_of_cancel_Color_black
Feature: TC 5637:5586_Validate while creating new seller cancel pop-ups is in black instead of blue in Resale Portal

  Scenario Outline: TC_5637_5586_Validate while creating new seller cancel pop-ups is in black instead of blue in Resale Portal
    Given user naviagtes to login page "<url>" and click on Create an account link
    And check create account page should have required fields
    And enter all the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
   # And click on Continue
    And click on Cancel "<Color>"
   # Then remove created seller "<Email>" "<url>"

    Examples: 
      | url                          | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | Color   |
      | Weekday_BE_resale_portal_url | Swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | #000000 |
