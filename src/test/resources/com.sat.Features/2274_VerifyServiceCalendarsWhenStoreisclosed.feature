#Author: your.email@your.domain.com
#Keywords Summary :
@2274_VerifyServiceCalendarsWhenStoreisclosed
Feature: Tc 2274 : Verify Service Calendars When Store is closed

  @TC_2274_Verify_Service_Calendars_When_Store_is_closed
  Scenario Outline: TC 2274 Verify Service Calendars When Store is closed
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then User Check "<Storestatus>" for "<StoreName>"
    Given User clicks on Calendar link
    Then User selects the store "<StoreName>" and clicks on Next
    And User click on toggle
    Then Select Apply Button and verify success message
    And Verify service Calendar is "Disable"

    Examples: 
      | brand   | country         | service | defaultvisitors | StoreName                         | Storestatus |
      | WEEKDAY | Sweden          | Resale  |               3 | Hansa(SE0659)                     | Store Open  |
      #| H&M     | The Netherlands | Resale  |               3 | H&M Amsterdam Noord(NL0038)       | Store Open  |
      #| WEEKDAY | The Netherlands | Resell  |               3 | Weekday Amsterdam De Pijp(NL0658) | Store Open  |
      #| H&M     | Germany         | Resell  |               3 | Mitte Garten(DE0159)              | Store Open  |
      #| monki   | Sweden          | Resell  |               3 | Götgatan 19(SE0607)               | Store Open  |
