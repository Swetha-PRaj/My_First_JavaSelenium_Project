#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_2322_Verify_Customer_is_received_Reminder_of_your_appointment_email
Feature: TC 2322 : Verify Customer is received Reminder of your appointment email

  @TC_2322_Verify_Customer_is_received_Reminder_of_your_appointment_email
  Scenario Outline: TC 2322 : Verify Customer is received Reminder of your appointment email
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    #When clicked on store Calendar then select store "<storeName>" and check the "<StoreStatus>"
    #Then check calendar is generated for the "<serviceName>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When navigate to store settings
    When select brand "<Brand>" and country "<Country>"
    Then Select store "<storeName>"
    And click on "<serviceName>" Settings
    Then check the display in portal view is "Enable" for the service
    And open booking portal url "<url>"
    Then Check and click on the store "<ClickAndMeetStoreName>"
    And validate the date format
    Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    And selct the time slot which is enable "<availableSlot>"
    Then enter required contact details "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<contactPostcode>" "<contactCity>"
    ######help is validation is comment in method#######
    Then validate contact fields "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then click on done
    #######And Validate confirmation mail with subject "Appointment Confirmation | weekday"
    And An email sent to register email address with subject as "<mailSubject1>" "<mailSubject2>"
    Then Enter Booking App url
    When User select "<Country>" and "<Brand>"
    Then User selects the store "<storeName>" and clicks on Next
    And validate services "<serviceName>" under the available service
    And click on Booking tab and veify the booking slots for "<serviceName>"
    Then Run the cloud flow "VisitorsNotificationMailBeforeBookingday"
    ###############And Validate confirmation mail with subject "Reminder of your appointment | weekday"
    And An email sent to register email address with subject as "<remaindermailSubject1>" "<mailSubject2>"

    Examples: 
      | url                                | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           | setyear | setmonth | setDate | ClickAndMeetStoreName | mailSubject1             | mailSubject2             | remaindermailSubject1        |
      | Click&MeetPortal_Weekday_SE_Resell | WEEKDAY | Sweden  | (SE0659)  | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 12:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2023 | March    |       2 | Hansa, Malmö          | Appointment Confirmation | Weekday Curated 2nd Hand | Reminder of your appointment |
      #| Click&MeetPortal_H&M_NL_Resell | H&M   | The Netherlands | (NL0038)  | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | September |       8 | H&M Amsterdam Noord, Amsterdam | Appointment Confirmation | Weekday Curated 2nd Hand | Reminder of your appointment |
      #| Click&MeetPortal_Weekday_NL_Resell | WEEKDAY | The Netherlands | (NL0658)  | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | September |       8 |Weekday Amsterdam De Pijp, Amsterdam| Appointment Confirmation | Weekday Curated 2nd Hand | Reminder of your appointment |
      #| Click&MeetPortal_H&M_DE_Resell     | H&M     | Germany         | (DE0159)  | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | September |       8 |Mitte Garten, Berlin| Appointment Confirmation | Weekday Curated 2nd Hand | Reminder of your appointment |
      #| Click&MeetPortal_monki_SE_Resale   | monki   | Sweden          | (SE0607)  | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | September |       8 |Götgatan 19, Stockholm| Appointment Confirmation | Weekday Curated 2nd Hand | Reminder of your appointment |
