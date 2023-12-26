@TC_3454_5492_CancelNotPossible
Feature: TC3454 : Test the Cancel not possible dialog

  @3454_5492_Validate_the_Cancel_not_possible_dialog
  Scenario Outline: TC3454_Check that the Cancel not possible dialog
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<Store>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<Service>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When navigate to store settings
    When select brand "<Brand>" and country "<Country>"
    Then Select store "<Store>"
    And click on "<Service>" Settings
    Then check the display in portal view is "Enable" for the service
    When Login to Resale portal tool with "<url>"
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    # ## And click on Registeryouritems
    When register an item with below fields "<Store_Name>","<brand_name>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    ## And click on registration Submit
    #####And click on Done
    And selct the time slot which is enable "<availableSlot>"
  #  Then click on done
  #  And check the "Pre-registered" item in available in My items tab
 #   When user launching ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
 #   And searching for existing seller "<existingseller>","<tab>"
  #  And sign the preregister item
  #  And click on "<status>" item and generate unique id by clcking on edit button and save it
 #   And click on "<status>" and fil details "Addidas","Women","Hats","42","Never worn ","Leather","Green","500","Drottninggatan 63","2023","November","30","Charity" and save it
    ## And click on "<status>" item and generate id by clicking on edit button and save it
    ## # And enter "Men","40","400" and save it
  #  Then swich to Portal and cancel the item which we have created

    Examples: 
      | Brand   | Country | Store             | Service | url                        | username             | password               | Store_Name                   | brand_name | Gender | Category | Condition  | Color | Pattern | Material | Unsolditem              | status  | existingseller            | tab       | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | QA_ResalePortal_Weekday_SE | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Other      | Men    | Bags     | Never worn | Black | Floral  | Cotton   | Pick-up item from store | Pending | testerswathi135@gmail.com | All Items | Store Open  |       11 |     2023 | May       |     11 |   2024 | May     | 10:00         |
