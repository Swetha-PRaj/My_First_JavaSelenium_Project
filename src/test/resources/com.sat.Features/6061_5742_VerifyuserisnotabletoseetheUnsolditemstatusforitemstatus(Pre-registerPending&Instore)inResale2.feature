#Author: your.email@your.domain.com
#Keywords Summary : Store Open  Store Close
@TC6061_5742_Verify_user_is_able_to_see_the_Unsold_item_status_for_item_status_in_Resale_app
Feature: TC 6062 :Verify user is not able to see the Unsold item status (Pickup/Charity) for item status (Expired and Sold) in Resale app (Pickup/Charity) for item status (Expired and Sold) in Resale app.

  @TC_6061-VVerify_user_is_able_to_see_the_Unsold_item_status_(Pickup/Charity)_for_item_status_(Pre-Regiteres,Pending,In-store)_in_Resale_app
  Scenario Outline: Verify user is able to see the Unsold item status
    Given Login to Admin tool App
    When navigate to store settings
    And select brand "<Brand>" and country "<Country>"
    And Select store "<Store>"
    And click on "<Service>" Settings
    Then check the display in portal view is "Enable" for the service
    When User navigates to ResalePortal "<url>" login page
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    ##  #And veify success msg with username "Tester swathi"
    ### # And click on Registeryouritems
    When register an item with below fields "<store_name>","<Brandname>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    And click on registration Submit
    When User login to Resaleapp with admin credentials
    When selecting "<Brand>","<Country>","<Store>"
    And searching for existing seller "<existingseller>","<tab>"
    And go to Items tab and open the item which we have craeted
    Then go to "<existingseller>","<tab>" open the "Pre registered" item
    And Observe, Unsold item "<Unsold>" status is hidden
    And Click on Cancel Button in item page
    And open the created item "Pre registered" to "In Store"
    And Observe, Unsold item "<Unsold>" status is hidden
    And Click on Cancel Button in item page
    And sign the preregister item
    And click on "<status>" item and generate id by clicking on edit button and save it
    And Observe, Unsold item "<Unsold>" status is hidden
    And Click on Cancel Button in item page

    # And click on "<status>" and enter "Addidas","Women","Hats","42","Never worn ","Leather","Green","500","Drottninggatan 63","2023","November","30","Charity" and save it
    # And update the item to "<Updatedstatus>"
    #  And click on "<status>" item and generate unique id by clcking on edit button and save it
    #   And click on "<status>" and enter "Addidas","Women","Hats","42","Never worn ","Leather","Green","500","Drottninggatan 63","2023","November","30","Charity" and save it
    # And click on cancel button and ok
    #  When searching for the existing seller "<existingseller>","<tab>"
    # And click on Add Item button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    #  And click on "<status>" item and generate unique id by clcking on edit button and save it
    #   And click on "<status>" and enter  "Addidas","Women","Hats","42","Never worn ","Leather","Green","500","Drottninggatan 63","2023","November","30","Charity"
    #  And Observe, Unsold item "<Unsold>" status is hidden
    #  Then Save it
    #  And user open the created item "In Store" and update the end of line item date with todays date as "2023","February","25"
    #  And Observe, Unsold item "<Unsold>" status is hidden
    ##   And click on cancel button and ok
    #  And click on Done button
    # And click on registration Submit
    Examples: 
      | Brand   | Country | Store             | Service | url                | username             | password               | store_name                   | Brandname | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus | Change store | Unsold      |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Other     | Men    | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               4 | Pickup      | Pending | In Store      | Hansa        | unsold item |
