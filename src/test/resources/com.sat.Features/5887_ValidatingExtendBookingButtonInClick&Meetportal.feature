#Author: neha.sain@hcl.com
#12/09/2022
#Keywords Summary :
@5887_Validating_extend_booking_button_in_click_and_Meet_Portal
Feature: TC5887 Validating extend booking button in click and Meet Portal(Rental  Service).

  Scenario Outline: Validating extend booking button in click and Meet Portal(Rental  Service).
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<storeName>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<serviceName>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When User Set "<Brand>" "<Country>" "<serviceName>" "5"
    When navigate to store settings
    When select brand "<Brand>" and country "<Country>"
    Then Select store "<storeName>"
    And click on "<serviceName>" Settings
    Then check the display in portal view is "Enable" for the service
    And open booking portal url "<url>"
    Then Check and click on the store "<ClickAndMeetStoreName>"
    And validate the date format
  #  Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    And selct the time slot which is enable "<availableSlot>"
    Then enter required contact details "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<contactPostcode>" "<contactCity>"
    Then validate contact fields "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then validate confirmation page is displayed and Extend button is removed

    Examples: 
      | url                                | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName       | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           | setyear | setmonth | setDate | ClickAndMeetStoreName |
      | Click&MeetPortal_Weekday_SE_Resell | WEEKDAY | Sweden  | (SE0659)  | Resell      | Store Open  |       20 |     2024 | Oct       |      7 |   2025 | Jan     | 13:30         | Swetha | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2024 | December |       9 | Hansa, Malmö          |
     # | Click&MeetPortal_Weekday_NL_Rental| H&M     | The Netherlands | (NL0038)  | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 13:30         | Swetha storeclose | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | December |       2 | H&M Amsterdam Noord   |
     # |  Click&MeetPortal_H&M_NL_Rental  | H&M     | The Netherlands | (NL0038)  | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 13:30         | Swetha storeclose | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | December |       2 | H&M Amsterdam Noord   |
