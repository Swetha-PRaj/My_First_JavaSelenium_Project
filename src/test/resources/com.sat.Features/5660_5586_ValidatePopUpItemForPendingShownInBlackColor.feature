@TC5660_Validation_the_cancel_pop-ups_for_pending_items
Feature: TC 5660: 5586_Validation the cancel pop-ups for pending items for booking

  Scenario Outline: TC5660_5586-Validation the cancel pop-ups for pending items for booking
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
    When register an item with below fields "<Store_Name>","<brand_name>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    Then click on back button
    Then Navigate to Book a Appointment page
    Then click on Cancle Button
    And click on Cancel "<Color_b>" on popmsg

    Examples: 
      | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           | url                      | username             | password               | Store_Name   | brand_name | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | status         | Color_b |
      | WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 11:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com | resale_portal_serviceurl | resale_portal_userid | resale_portal_password | Hansa, Malmö | Other      | Women  | Dresses  | Vintage   | Black | Floral  | Cotton   | Pick-up item from store | Pre-registered | #000000 |
