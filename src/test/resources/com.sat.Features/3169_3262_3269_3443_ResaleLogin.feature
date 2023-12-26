@3169_3262_3269_3443_5487_5488_5490_User_Login_with_exesting_Account_and_RegisteringCancellingItem
Feature: TC-3169,3262,3169,3443,5487,5488,5490 : Testing Login Functionality , regestering and cancelling Item

  @3169_3262_3269_3443_5487_5488_5490_User_Login_with_exesting_Account_and_RegisteringCancellingItem
  Scenario Outline: TC3169_3262_3269_3443_5487_5488_5490_Verify user can login and register an item in Resale portal and cancel the resgistered item
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<storeName>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<Service>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When navigate to store settings
   When select brand "<Brand>" and country "<Country>"
    Then Select store "<storeName>"
    And click on "<Service>" Settings
    Then check the display in portal view is "Enable" for the service
    When User navigates to ResalePortal "<url>" login page without gmail
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    When register an item with below fields "<Store_Name>","<Brandname>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
   # And click on registration Submit
    ###And user can view Thankyou Msg
    ####And click on Done and success msg with username "Tester swathi"
    Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    And selct the time slot which is enable "<availableSlot>"
    Then click on done
    Then confirmation email should sent with "Confirmation email | Weekday 2nd-hand Curated"
    And click on gmail back button
    Then confirmation email should sent with "Appointment Confirmation | Weekday Curated 2nd Hand"
    # ---- check seller can be delete or not if he have item.
    Then Navigate to Resale Portal tab
    Then Navigate to manage account
    Then click on Send me my data and validate the popup
    Then confirmation email should sent with "Personal Data request | weekday 2nd-hand Curated"
    Then try to delete account, validate the popup unable to delete my data and account
    And click on Resale portal back button
    And click on Resale portal back button
   And check currently created "<status>" item is there in MyItems tab
  #  And cancel item which is register and check the cancellation email "Canceled Item(s) |  Curated Secondhand"

    Examples: 
      | Brand   | Country | storeName             | Service | StoreStatus | url                | username             | password               | Store_Name                   | Brandname | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | status         | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | setmonth | setyear | setDate |
      #| WEEKDAY | Sweden  | Hansa             | Resell  | Store Open  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Hansa, Malmö                 | Biba      | Women  | Dresses  | Vintage   | Black | Floral  | Cotton   | Pick-up item from store | Pre-registered |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         |     2023 | April   |      11 |
      #| WEEKDAY | Sweden  | Drottninggatan 63         | Resell  | Store Open  | QA_ResalePortal_Weekday_SE | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm        | Biba      | Dresses  | Vintage  |Black | Floral  | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| WEEKDAY | The Netherlands | WEEKDAY AMSTERDAM DE PIJP | Resell  | Store Open  | QA_ResalePortal_Weekday_NL | resale_portal_userid | resale_portal_password | Weekday Amsterdam De Pijp,Amsterdam | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| WEEKDAY | Belgium         | MEIR 78                   | Resell  | Store Open  | QA_ResalePortal_Weekday_BE | resale_portal_userid | resale_portal_password | Meir 78,Antwerpen                   | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| Monki   | Sweden          | GÖTGATAN 21               | Resell  | Store Open  | QA_ResalePortal_monki_SE   | resale_portal_userid | resale_portal_password | Götgatan 19,Stockholm               | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| HM      | The Netherlands | H&M AMSTERDAM NOORD       | Resell  | Store Open  | QA_ResalePortal_HM_NL      | resale_portal_userid | resale_portal_password | H&M Amsterdam Noord,Amsterdam       | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| HM      | The Netherlands | MITTE GARTEN              | Resell  | Store Open  | QA_ResalePortal_HM_DE      | resale_portal_userid | resale_portal_password | Mitte Garten,Berlin                 | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      #| Arket   | Sweden          | DROTTNINGGATAN 56         | Resell  | Store Open  | QA_ResalePortal_arket_SE   | resale_portal_userid | resale_portal_password | Drottninggatan 56,Stockholm         | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |      11 |     2022 | May       |     11 |   2024 | May     | 10:00         |
      | WEEKDAY | Sweden  | Hansa  | Resell  | Store Open  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Hansa, Malmö   | Other   | Women  | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | Pre-registered |       11 |     2023 | May       |     11 |   2024 | May     | 10:00         |     2023 | April   |      25 |
