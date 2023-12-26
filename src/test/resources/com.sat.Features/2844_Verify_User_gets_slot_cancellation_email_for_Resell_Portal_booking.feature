#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_2844_Verify_User_gets_slot_cancellation_email_for_Resell_Portal_booking
Feature: Verify User gets slot cancellation email for Resell Portal booking
  =============================pending = need to complete =====================================

  @TC_2844_Verify_User_gets_slot_cancellation_email_for_Resell_Portal_booking
  Scenario Outline: Verify User gets slot cancellation email for Resell Portal booking
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
    Then Check and click on the store "<storeName>"
    Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    And validate the date format
    And selct the time slot which is enable "<availableSlot>"
    Then enter required contact details "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<contactPostcode>" "<contactCity>"
    Then validate contact fields "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then click on done
    Then Enter Booking App url
    Then change the Country "<Country>" and brand "<Brand>"

    Examples: 
      | url                                | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName         | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           | setyear | setmonth | setDate |
      | Click&MeetPortal_Weekday_SE_Resell | WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha serviceclose | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | August   |      27 |
