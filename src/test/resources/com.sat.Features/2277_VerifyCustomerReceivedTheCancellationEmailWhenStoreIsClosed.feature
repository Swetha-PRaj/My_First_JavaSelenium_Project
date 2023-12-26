#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_2277_Verify_Customer_received_the_Cancellation_Email_when_Store_is_Closed
Feature: TC 2277 : Verify Customer received the Cancellation Email when Store is Closed

  @TC_2277_Verify_Customer_received_the_Cancellation_Email_when_Store_is_Closed
  Scenario Outline: TC 2277 : Verify Customer received the Cancellation Email when Store is Closed
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<storeName>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<serviceName>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
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
    Then validate contact fields "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then click on done
    And Validate confirmation mail with subject "Appointment Confirmation | Weekday Curated 2nd Hand"
    Then Enter Booking App url
    Then change the Country "<Country>" and brand "<Brand>"
    Then User Check "Store Close" for "<storeName>"
    And Validate confirmation mail with subject "Booking Slot Cancelled"

    # enter today's date to book the slot <setyear | setmonth | setDate>|
    Examples:
      | url                                | Brand   | Country         | storeName  | serviceName  | StoreStatus  | fromDate  | fromYear  | fromMonth  | todate  | toYear  | toMOnth  | availableSlot  | contactName       | contactEmail           | contactMobile  | contactAddress  | contactPostcode  | contactCity  | helpmail           | setyear  | setmonth | setDate  | ClickAndMeetStoreName     |
      | Click&MeetPortal_Weekday_SE_Resale | WEEKDAY | Sweden          | (SE0659)   | Resell       | Store Open   |        11 |      2022 | May        |      11 |    2024 | May      | 10:00          | Swetha storeclose | swethahcl960@gmail.com |      910812081 | tumkur          |           572102 | tumkur       | weekday@second.com |     2022 | November |       25 | Hansa, Malmö              |
      | Click&MeetPortal_H&M_NL_Resell     | H&M     | The Netherlands | (NL0038)   | Resell       | Store Open   |        11 |      2022 | May        |      11 |    2024 | May      | 10:00          | Swetha storeclose | swethahcl960@gmail.com |      910812081 | tumkur          |           572102 | tumkur       | weekday@second.com |     2022 | November |       25 | H&M Amsterdam Noord       |
      | Click&MeetPortal_Weekday_NL_Resell | WEEKDAY | The Netherlands | (NL0658)   | Resell       | Store Open   |        11 |      2022 | May        |      11 |    2024 | May      | 10:00          | Swetha storeclose | swethahcl960@gmail.com |      910812081 | tumkur          |           572102 | tumkur       | weekday@second.com |     2022 | November |       25 | Weekday Amsterdam De Pijp |
      | Click&MeetPortal_Weekday_DE_Resell | H&M     | Germany         | (DE0159)   | Resell       | Store Open   |        11 |      2022 | May        |      11 |    2024 | May      | 10:00          | Swetha storeclose | swethahcl960@gmail.com |      910812081 | tumkur          |           572102 | tumkur       | weekday@second.com |     2022 | November |       25 | Mitte Garten              |
      | Click&MeetPortal_monki_SE_Resale   | monki   | Sweden          | (SE0607)   | Resale       | Store Open   |        11 |      2022 | May        |      11 |    2024 | May      | 10:00          | Swetha storeclose | swethahcl960@gmail.com |      910812081 | tumkur          |           572102 | tumkur       | weekday@second.com |     2022 | November |       25 | Götgatan 19               |
  #| WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha storeclose | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | September |       8 |
      #| WEEKDAY | Sweden  | Drottninggatan 63 | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha storeclose | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | secondhand.drottninggatan@weekday.com |    2022 | September |      5 |
    