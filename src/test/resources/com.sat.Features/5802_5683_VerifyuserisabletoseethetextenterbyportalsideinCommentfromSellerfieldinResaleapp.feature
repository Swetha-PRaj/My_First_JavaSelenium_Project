#Author: your.email@your.domain.com
#Keywords Summary : Store Open  Store Close
@5683:VerifyuserisabletoseethetextenterbyportalsideinCommentfromSellerfieldinResaleappfor @Brand.
Feature: TC 5802 : 5683_Verify user is able to see the text enter by portal side in Comment from Seller field in Resale app.

  @TC_5802_5683-Verify_User_is_able_to_see_the_text_enter_by_portal_side_in_Comment_from_Seller_field_in_Resale_app.
  Scenario Outline: Verify user is able to see the text enter by portal side in Comment from Seller field in Resale app.
    # Then User login to ResalePortal "<portal_url>" with registered credential "<Email>" and "<password>"
    When User navigates to ResalePortal "<url>" with "<username>" and "<password>"
    When register an item with below fields "<Store>","<brand>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    And selct the time slot which is enable "<availableSlot>"
    Then click on done
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    And searching for existing seller "<existingseller>","<tab>"
    And click on AddItem button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    Then Click on the Add New Brand and validate pop up msg "<Statustxt>","<StatusComment>"
    And User is able to view the comment given by seller

    Examples: 
      | url                | Brand   | Country | Language | Email              | password               | username             | password               | Store                        | User                    | Role  | existingseller            | tab       | Number of Items | Unsold Item | status         | Statustxt                            | StatusComment       | Newbrand | Gender | brand | Category | Condition | Color | Pattern | Material | Unsolditem              | status  | Updatedstatus | validIBANnumber | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | serviceName |
      | resale_portal_url1 | WEEKDAY | Sweden  | English  | v9833950@gmail.com | resale_portal_password | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | swetha.pr@storelens.com | Admin | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pre registered | Type the brand that you want to add. | Comment from seller | Brother    | Men    | Other | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | Pending | Sold          | sbIBANnumber    | Store Open  |       20 |     2023 | Feb       |     11 |   2024 | May     | Resell      |
