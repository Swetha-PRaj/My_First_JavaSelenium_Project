#Author: your.email@your.domain.com
#Keywords Summary :
@5492_Validate_the_Cancel_not_possible_dialog
Feature: TC 5492 Validate the Cancel not possible dialog

  @5492_Validate_the_Cancel_not_possible_dialog
  Scenario Outline: Title of your scenario outline
    # Given Login to Admin tool App
    #  Then change the Country "<Country>" and brand "<Brand>"
    # When clicked on store Calendar then select store "<Store>" and check the "<StoreStatus>"
    # Then check calendar is generated for the "<Service>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    #  When navigate to store settings
    #  When select brand "<Brand>" and country "<Country>"
    #  Then Select store "<Store>"
    #  And click on "<Service>" Settings
    #  Then check the display in portal view is "Enable" for the service
    #  When User navigates to ResalePortal "<url>" login page
    #  And user enters valid ResalePortal "<username>" and "<password>"
    #  And click on signin
    #### And veify success msg with username "Tester swathi"
    ### #And click on Registeryouritems
    #  When register an item with below fields "<Store_Name>","<brand_name>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    ###  And click on registration Submit
    #  And selct the time slot which is enable "<availableSlot>"
    #  Then click on done
    ##  When user navigating to ResaleAppHomePage with valid credentials and signin
    ##  And searching for existing seller "<existingseller>","<tab>"
    # Given User login to Resaleapp
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    And searching for existing seller "<existingseller>","<tab>"
   # And click on Add Item button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And clickng on "Pre registered" item and generate unique id by clicking on edit button and save it

    # And clickng on "Pending" and fil details "zara","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    Examples: 
      | Brand   | Country | Store             | Service | StoreStatus | url                | username             | password               | Store_Name                   | brand_name | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | status         | existingseller            | tab       | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | Unsold Item | Number of Items |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | Store Open  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Other      | Women  | Dresses  | Vintage   | Black | Floral  | Cotton   | Pick-up item from store | Pre-registered | testerswathi135@gmail.com | All Items |       11 |     2023 | May       |     11 |   2024 | May     | 10:00         | Pickup      |               1 |
