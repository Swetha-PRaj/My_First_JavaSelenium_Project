#Author: your.email@your.domain.com
#Keywords Summary : Store Open  Store Close
@5266_5262_Verify_user_able_to_see_the_personal_shopper_screen_in_the_Admin_tool_app_for_Brand.
Feature: TC 5266 :Verify user able to see the personal shopper screen in the Admin tool app for Brand.

  @TC_5266-Verify_user_able_to_see_the_personal_shopper_screen_in_the_Admin_tool_app_for_Brand.
  Scenario Outline: Make Sure User Is Able To Add New Brand
  
   Then User login to ResalePortal "<portal_url>" with registered credential "<Email>" and "<password>"
     And veify success msg with username "Tester swathi"
    When register an item with below fields "<store>","<brand>","<Gender>","<Category>","<Condition>","<Color>","<Pattern>","<Material>","<Unsolditem>" and submit it
    And selct the time slot which is enable "<availableSlot>"
    Then click on done
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    When selecting "<Brand>","<Country>","<Store>"
   And searching for existing seller "<existingseller>","<tab>"
      And go to Items tab and open the item which we have craeted
     And click on "Pending" item and generate id by clicking on edit button and save it
      And Observe, Unsold item "<Unsold>" status is hidden
      And click on cancel button and ok
      And click on Done button
      And searching for existing seller "<existingseller>","<tab>"
      And go to Items tab and open the item which we have craeted
       #And open the "Pre registered" item and sign the agreeemnt
    #  And click on Add Item button and enter "<Number of Items>" and select "<Unsold Item>" and click Next button and enter sign save it
    #  And click on "<status>" item and generate id by clicking on edit button and save it
       And Observe, Unsold item "<Unsold>" status is hidden
    #  And enter  "Biba","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    #  And Observe, Unsold item "<Unsold>" status is hidden
    
    
    
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp and search for "<existingseller>","<tab>"
    Then change the seller commission "<sellerCommission>"
   # Then user verifies following fields are mandatory on seller tab
     # | First name * | Last name * | Email address | Phone number * | Verify ID | Commission % * | SAVE | CANCEL |

    Examples: 
      | User                    | Role  | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | First_name | Last_name | Email_address | Phone_number | Verify_ID | Commission | Cancel | SAVE |
   #  | swetha.pr@storelens.com | Admin | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | First      | Last      | Email         | Phone        | Verify    | Commission | CANCEL | SAVE |
      | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |          1 | Pickup     | Pending | First      | Last      | Email         | Phone        | Verify    | Commission | CANCEL | SAVE |
      
    Examples: 
      | portal_url         | Email              | password               | Service | Store                        | url                | username             | password               | store        | brand | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | User                    | Role       | Brand   | Country | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus    |
      | resale_portal_url1 | v9833950@gmail.com | resale_portal_password | Resell  | Drottninggatan 63 | resale_portal_url1 | resale_portal_userid | resale_portal_password | Hansa, Malmö | Other | Men    | Dresses  | Vintage   | Black | Dots    | Cotton   | Pick-up item from store | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | testerswathi135@gmail.com | All Items |               4 | Pickup      | Pending | Pending |
