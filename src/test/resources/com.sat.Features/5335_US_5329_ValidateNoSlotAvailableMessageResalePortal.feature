#Author: neha.sain@hcl.com
#Keywords Summary :
@TC_5335_US_5329_Verify_No_Time_Slot_Available_Message_where_no_time_slots_from_selected_date_from_Resale_Portal
Feature: TC 5335 : Verify No Time Slot Available Message when there are no time slots for selected date

  @TC_5335_Verify_No_Time_Slot_Available_Message_when_there_are_no_time_slots_for_selected_date
  Scenario Outline: TC 5335 : Verify No Time Slot Available Message when there are no time slots for selected date
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<storeName>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<serviceName>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When navigate to store settings
    When select brand "<Brand>" and country "<Country>"
    Then Select store "<storeName>"
    And click on "<serviceName>" Settings
    Then check the display in portal view is "Enable" for the service
    When User navigates to ResalePortal "<url>" login page without gmail
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    When register an item with below fields "<store_name>","<Brandname>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    Then click on back button
    When Navigate to admin app by entering url
    When navigate to store settings
    When select brand "<Brand>" and country "<Country>"
    Then Select store "<storeName>"
    And click on "<serviceName>" Settings
    Then check the display in portal view is "Disable" for the service
    When User navigates to ResalePortal "<url>" login page without gmail
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    Then Navigate to Book a Appointment page
    And Validate No time Slot msg "<ExpextText1>" "<ExpextText2>"

 
    Examples: 
      | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           | url                      | username             | password               | store_name   | Brandname | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | status         | ExpextText1        | ExpextText2                                                                                                                                                                  |
      | WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com | resale_portal_serviceurl | resale_portal_userid | resale_portal_password | Hansa, Malmö | Other     | Men    | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | Pre-registered | No available times | Unfortunately, there are currently no available time slots in this store. Please come back another day to book an appointment, in the mean time we will add more time slots. |
