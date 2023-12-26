#Author: your.email@your.domain.com
#Keywords Summary : Store Open  Store Close
@5266_5262_Verify_user_able_to_see_the_personal_shopper_screen_in_the_Admin_tool_app_for_Brand.
Feature: TC 5266 :Verify user able to see the personal shopper screen in the Admin tool app for Brand.

  @TC_5266-Verify_user_able_to_see_the_personal_shopper_screen_in_the_Admin_tool_app_for_Brand.
  Scenario Outline: Verify user able to see the personal shopper screen in the Admin tool app for Brand.
    Given User Navigate to New Admin Tool App
    When User select "<country>" and "<brand>"
    Then user scroll down to till element is visible in Admin Tool
    And Validate user should be able to view the Personal shopper page without any error
    Then Click on Add button and search the email Id of the shopper
   

    Examples: 
      | brand | country | service | defaultvisitors | StoreName     | Storestatus |
      | monki | Sweden  | Resell  |               3 | Hansa(SE0659) | Store Open  |
