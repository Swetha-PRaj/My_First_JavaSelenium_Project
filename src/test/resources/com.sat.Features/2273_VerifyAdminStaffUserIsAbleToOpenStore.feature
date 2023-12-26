#Author: swetha.pr@hcl.com
#Keywords Summary :
#Feature: List of scenarios.
@2273_VerifyAdminStaffUserIsAbleToOpenStore
Feature: TC 2273: Verify Admin Staff user is able to Open the Store

  @TC_2273-Verify_Admin_Staff_user_is_able_to_close_the_Store
  Scenario Outline: Make sure User is able to close the store
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then User Check "<Storestatus>" for "<StoreName>"
    Given User clicks on Calendar link
    Then User selects the store "<StoreName>" and clicks on Next
    And User click on toggle
    And Enter default allowed visitors "15"
    Then User click Yes and able to see Successfully store Opened Message

    Examples: 
      | brand   | country         | service | defaultvisitors | StoreName                         | Storestatus |
      | WEEKDAY | Sweden          | Resale  |               3 | Hansa(SE0659)                     | Store Close |
      #| H&M     | The Netherlands | Resale  |               3 | H&M Amsterdam Noord(NL0038)       | Store Close |
      #| WEEKDAY | The Netherlands | Resell  |               3 | Weekday Amsterdam De Pijp(NL0658) | Store Close |
      #| H&M     | Germany         | Resell  |               3 | Mitte Garten(DE0159)              | Store Close |
      #| monki   | Sweden          | Resell  |               3 | Götgatan 19(SE0607)               | Store Close |
