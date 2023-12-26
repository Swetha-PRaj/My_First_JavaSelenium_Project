@TC5638_5586_Validate_click_and_meet_portal_after_cancel_a_slot_cancel_pop-ups_is_showing_in_Black
Feature: TC5638: 5586_Validate click and meet portal after cancel a slot,cancel pop-ups is showing in Black

  @TC5638_5586_Validate_click_and_meet_portal_after_cancel_a_slot_cancel_pop-ups_is_showing_in_Black
  Scenario Outline: TC5638_5586_Validate click and meet portal after cancel a slot,cancel pop-ups is showing in Black
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
    Then Navigate to ClickPortallink
    Then click on ClickPortalCancel
    And click on Cancel "<Color>" on popmsg ClickMeet

    Examples: 
      | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           | url                     | store_Name   | Category | Condition | Material | Unsolditem              | Color   |
      | WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2023 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com | BookingPortalUrl_Resell | Hansa, Malmö | Dresses  | Vintage   | Cotton   | Pick-up item from store | #000000 |
