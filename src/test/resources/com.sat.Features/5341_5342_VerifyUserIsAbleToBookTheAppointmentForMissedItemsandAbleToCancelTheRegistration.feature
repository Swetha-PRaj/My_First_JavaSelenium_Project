@TC5341_5342_Verify_User_Is_Able_To_Book_The_Appointment_For_Missed_Item_and_able_to_cancle_the_registration
Feature: TC5341_5342_Verify_User_Is_Able_To_Book_The_Appointment_For_Missed_Item__and_able_to_cancle_the_registration

  Scenario Outline: TC5341_5342_Verify_User_Is_Able_To_Book_The_Appointment_For_Missed_Item_and_able_to_cancle_the_registration
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<Store>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<Service>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When User navigates to ResalePortal "<url>" with "<username>" and "<password>"
    When register an item with below fields "<Store_Name>","<brand_name>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    Then click on back button
    Then Navigate to Book a Appointment page
    Then click on Cancle Button
    Then Navigate to Book a Appointment page
    And selct the time slot which is enable "<availableSlot>"
    Then validate the Done button

    Examples: 
      | Brand   | Country | Store | Service | url                | username             | password               | Store_Name | brand_name   | Gender | Category | Condition | Color   | Pattern | Material | Unsolditem | status                  | StoreStatus    | fromDate   | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail | contactMobile          | contactAddress | contactPostcode | contactCity | helpmail | setyear            | setmonth | setDate   |   
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | resale_portal_url1 | resale_portal_userid | resale_portal_password |Drottninggatan 63, Stockholm | Other  | Women    | Dresses   | Vintage | Black   | Floral   | Cotton     | Pick-up item from store | Pre-registered | Store Open |       11 |      2023 | May    |     11 |    2024 | May           | 10:00       | Swetha       | swethahcl960@gmail.com |      910812081 | tumkur          |      572102 | tumkur   | weekday@second.com |     2023 | September | 8 |
  #| WEEKDAY | Sweden          | Drottninggatan 63         | Resell  | Store Open  | QA_ResalePortal_Weekday_SE | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm        | Biba      | Dresses  | Vintage  |Black | Floral  | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| WEEKDAY | The Netherlands | WEEKDAY AMSTERDAM DE PIJP | Resell  | Store Open  | QA_ResalePortal_Weekday_NL | resale_portal_userid | resale_portal_password | Weekday Amsterdam De Pijp,Amsterdam | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| WEEKDAY | Belgium         | MEIR 78                   | Resell  | Store Open  | QA_ResalePortal_Weekday_BE | resale_portal_userid | resale_portal_password | Meir 78,Antwerpen                   | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| Monki   | Sweden          | GÖTGATAN 21               | Resell  | Store Open  | QA_ResalePortal_monki_SE   | resale_portal_userid | resale_portal_password | Götgatan 19,Stockholm               | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| HM      | The Netherlands | H&M AMSTERDAM NOORD       | Resell  | Store Open  | QA_ResalePortal_HM_NL      | resale_portal_userid | resale_portal_password | H&M Amsterdam Noord,Amsterdam       | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| HM      | The Netherlands | MITTE GARTEN              | Resell  | Store Open  | QA_ResalePortal_HM_DE      | resale_portal_userid | resale_portal_password | Mitte Garten,Berlin                 | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| Arket   | Sweden          | DROTTNINGGATAN 56         | Resell  | Store Open  | QA_ResalePortal_arket_SE   | resale_portal_userid | resale_portal_password | Drottninggatan 56,Stockholm         | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
    