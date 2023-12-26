@TC5676_ResalValidation_of_field
Feature: US 5493 :Resale Portal - Validation of Country option for an existing seller in personal information

  Scenario Outline: TC5493_Validation of Country option for an existing seller in personal information
    Given user naviagtes to login page "<url>" and click on Create an account link
    And check create account page should have required fields
    And enter all the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    And check the Country
    And click on Continue
    And login to Resale portal "<url>" and enter "<Email>" and password
    Then user scroll down to till My account element is visible and Click on my Account
    Then Verify Country field is Diabled
    Then remove created seller "<Email>" "<url>"

    # Then remove created seller "<Email>"
    Examples: 
      | url                          | Email                  | Firstname | Lastname | Mobile     | Street Address | Postal code | City     |
      | Weekday_BE_resale_portal_url | swethahcl007@gmail.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore |
