#Author: swetha.pr@hcl.com
#Keywords Summary :
@2295_Verify_Store_when_user_is_opening_the_Closed_Service_All_Services_are_Closed
Feature: TC 2295:  Verify Store when user is opening the Closed Service (All Services are Closed)

  @2295_Verify_Store_when_user_is_opening_the_Closed_Service_All_Services_are_Closed
  Scenario Outline: TC 2295 : Verify Store when user is opening the Closed Service (All Services are Closed)
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then check all the services are "Disable selected" for "<StoreName>"
    Then User Check "<Storestatus>" for "<StoreName>"
    Then Select the service "<service>"
    And Enter the Customise message "Throught Automation store is disabled"
    And check the service status and "Enable" "<defaultvisitors>"
    ######### enabling the service which is disabled ##################
    Then check all the services are "Enable selected" for "<StoreName>"

    Examples: 
      | brand   | country         | service | defaultvisitors | StoreName | Storestatus |
      #| WEEKDAY | Sweden          | Resell  |               3 | Hansa     | Store Close |
      | WEEKDAY | Sweden          | Resale  |               3 | (SE0659)  | Store Close |
      #| H&M     | The Netherlands | Resale  |               3 | (NL0038)  | Store Close |
      #| WEEKDAY | The Netherlands | Resell  |               3 | (NL0658)  | Store Close |
      #| H&M     | Germany         | Resell  |               3 | (DE0159)  | Store Close |
      #| monki   | Sweden          | Resell  |               3 | (SE0607)  | Store Close |
