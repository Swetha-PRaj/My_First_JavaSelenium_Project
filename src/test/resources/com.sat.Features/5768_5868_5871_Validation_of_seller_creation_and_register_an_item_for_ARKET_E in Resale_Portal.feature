#Author: seetha.pr@hcl.com
#Keywords Summary :
@5768_5868_5871_Validation_of_seller_creation_and_register_an_item_for_ARKET_SE_in_Resale_Portal
Feature: TC_3162_5485 : 5768 TC: US 5522: Validation of seller creation and register an item for ARKET, SE in Resale Portal

  @5768_5868_5871_Validation_of_seller_creation_and_register_an_item_for_ARKET_SE_in_Resale_Portal
  Scenario Outline: TC_3162_5485 : 5768 TC: US 5522: Validation of seller creation and register an item for ARKET, SE in Resale Portal
    ##Given user naviagtes to login page "<portal_url>" and click on Create an account link Name "<creatAccountlinkName>"
    #And check create account page should have required fields "<Language>"
    #And enter all the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    #And click on Continue verify registered message "<success message>" and click on Ok
    #Given Login to Admin tool App
    #Then change the Country "<Country>" and brand "<Brand>"
    #When clicked on store Calendar then select store "<Store>" and check the "<StoreStatus>"
    #Then check calendar is generated for the "<Service>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    #When navigate to store settings
    #When select brand "<Brand>" and country "<Country>"
    #Then Select store "<Store>"
    #And click on "<Service>" Settings
    #Then check the display in portal view is "Enable" for the service
    Given User navigating to login page "<portal_url>"
    #When User navigates to ResalePortal "<portal_url>" login page without gmail
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    Then validate My profile, my Items and my Account in home page
    When register an item with below fields "<storeName>","<Brandname>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    And selct the time slot which is enable "<availableSlot>"
    Then click on done
    And Validate the Registered Item and slot booked item under My appointment
    Then Navigate to my Items and validate the Item
    Then click on back button
    Then Navigate to personal deatils and valiate the page is displayed
    Then click on back button
    Then Navigate to manage account
    Then click on Send me my data and validate the popup
    #Then Login to the gamil "<GmailuserID>" "<GmailPassword>"
    Then confirmation email should sent with "Personal Data request | ReARKET"

    #And Navigate to my agreement page and validate
    #terms and condition , private policy - poage validation ------ this step is pending form 5768 tc
    #Then remove created seller "<Email>" "<portal_url>"
    Examples: 
      | portal_url                | username       | storeName                    | password               | creatAccountlinkName | Language | GmailuserID    | GmailPassword  | Email                  | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | success message          | Brandname | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | Brand | Country | Store             | Service | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | setmonth | setyear | setDate |
      | Dev_ResalePortal_arket_SE | email_username | Drottninggatan 56, Stockholm | resale_portal_password | Create an account    | English  | email_username | email_password | swethahcl960@gmail.com | swetha    | hcl      | 9876543210 | Marathalli     |      554678 | Banglore | Registered successfully. | WEEKDAY   | Women  | Dresses  | Good      | Black | Floral  | Cotton   | Pick-up item from store | ARKET | Sweden  | Drottninggatan 56 | Resell  | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 11:00         | July     |    2023 |       6 |
