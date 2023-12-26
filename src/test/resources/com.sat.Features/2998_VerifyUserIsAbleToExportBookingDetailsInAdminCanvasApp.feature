#Author: swetha.pr@hcl.com
#Keywords Summary :
@2998_Verify_user_is_able_to_export_booking_details_for_selected_Brand_and_Country_in_Admin_Canvas_App
Feature: TC 2998 :Verify user is able to export booking details for selected Brand and Country in Admin Canvas App

  @2998_Verify_user_is_able_to_export_booking_details_for_selected_Brand_and_Country_in_Admin_Canvas_App
  Scenario Outline: TC 2998 : Verify user is able to export booking details for selected Brand and Country in Admin Canvas App
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    Then navigate to Store Settings
    And select "<StoreName>" more option and click on View Store settings
    Then inputs "<Start Date>" "<startYear>" "<startmonth>" "<end Date>" "<endYear>" and "<endMonth>"
    And click on export to excel
    And validate the downloaded file "<StoreName>" in the "<path>"

# please change the path variable data

    Examples: 
      | country         | brand   | StoreName | Start Date | end Date | startYear | startmonth | endYear | endMonth | path                           |
      | Sweden          | WEEKDAY | (SE0659)  |         15 |       20 |      2023 | May        |    2023 | June     | C:\\Users\\hcladmin\\Downloads |
      #| The Netherlands | H&M     | (NL0038)  |         15 |       20 |      2023 | May        |    2023 | June     | C:\\Users\\hcladmin\\Downloads |
      #| The Netherlands | WEEKDAY | (NL0658)  |         15 |       20 |      2023 | May        |    2023 | June     | C:\\Users\\hcladmin\\Downloads |
      #| Germany         | H&M     | (DE0159)  |         15 |       20 |      2023 | May        |    2023 | June     | C:\\Users\\hcladmin\\Downloads |
      #| Sweden          | monki   | (SE0607)  |         15 |       20 |      2023 | May        |    2023 | June     | C:\\Users\\hcladmin\\Downloads |
