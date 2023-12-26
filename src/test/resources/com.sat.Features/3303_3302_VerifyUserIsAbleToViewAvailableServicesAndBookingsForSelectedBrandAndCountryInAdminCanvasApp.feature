#Author: swetha.pr@hcl.com
#Keywords Summary :
#Feature: List of scenarios.
@3303_3302_Verify_user_is_able_to_view_available_services_and_bookings_for_selected_Brand_and_Country_in_Admin_Canvas_App
Feature: TC 3303_3302 : Verify user is able to view available services and bookings for selected Brand and Country in Admin Canvas App

  @3303_3302_Verify_user_is_able_to_view_available_services_and_bookings_for_selected_Brand_and_Country_in_Admin_Canvas_App
  Scenario Outline: TC 3303_3302 : Verify user is able to view available services and bookings for selected Brand and Country in Admin Canvas App
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    Then User Check "<Storestatus>" for "<StoreName>"
    And validate services "<ServiceName>" under the available service
    And click on Booking tab and veify the booking slots for "<ServiceName>"

    Examples: 
      | brand   | country         | StoreName | ServiceName | Storestatus |
      | WEEKDAY | Sweden          | (SE0659)  | Resell      | Store Open  |
      #| H&M     | The Netherlands | (NL0038)  | Resale      | Store Open  |
      #| WEEKDAY | The Netherlands | (NL0650)  | Resell      | Store Open  |
      #| H&M     | Germany         | (DE0159)  | Resell      | Store Open  |
      #| monki   | Sweden          | (SE0607)  | Resell      | Store Open  |
