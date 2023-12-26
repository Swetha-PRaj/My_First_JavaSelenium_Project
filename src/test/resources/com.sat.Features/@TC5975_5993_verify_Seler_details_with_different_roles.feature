#Author: neha.sain@hcl.com
#Keywords Summary :
@TC5975_5993_verify_Seler_details_with_different_roles
Feature: TC5975 :Verify BrandManager and Admin_role Is Able To See Seller Name, Email and PhoneNo

@TC5993_Verify_BrandManager_and_Admin_role_Is_Able_To_See_Seller_Name_Email_and_PhoneNo_Sprint_17
  Scenario Outline: 5993_5742_Verify_BrandManager_and_Admin_role_Is_Able_To_See_Seller_Name_Email_and_PhoneNo
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    And user is selecting "<Brand>","<Country>","<Store>"
    And searching for existing seller "<existingseller>","<tab>"
    Then user verifies following fields are mandatory on Admin tab
      | First name * | Last name * | Email address | Phone number * | Address * | Postcode * | Town * | Verify ID | Commission % * | Country | SAVE | CANCEL |

    Examples: 
      | User                    | Role  | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | First_name | Last_name | Email_address | Phone_number | Verify_ID | Commission | Cancel | SAVE |
      | swetha.pr@storelens.com | Admin | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | First      | Last      | Email         | Phone        | Verify    | Commission | CANCEL | SAVE |
      | swetha.pr@storelens.com | Brand Manager | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | First      | Last      | Email         | Phone        | Verify    | Commission | CANCEL | SAVE |

@TC5975_5742_Verify_Store_and_Store_Manager_Is_Able_To_See_Seller_Name_Email_and_PhoneNo
  Scenario Outline: 5975_5742_Verify_Store_and_Store_Manager_Is_Able_To_See_Seller_Name_Email_and_PhoneNo
    When user navigating to ResaleAppHomePage with valid credentials and signin
    Then click on back button in Home Page
    And user is selecting "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp and search for "<existingseller>","<tab>"
    Then user verifies following fields are mandatory on Seller tab
      | First name * | Last name * | Email address | Phone number * | Verify ID | Commission % * | SAVE | CANCEL |

    Examples: 
      | User                    | Role          | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | First_name | Last_name | Email_address | Phone_number | Verify_ID | Commission | Cancel | SAVE |
      | swetha.pr@storelens.com | Store Manager | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | First      | Last      | Email         | Phone        | Verify    | Commission | CANCEL | SAVE |
