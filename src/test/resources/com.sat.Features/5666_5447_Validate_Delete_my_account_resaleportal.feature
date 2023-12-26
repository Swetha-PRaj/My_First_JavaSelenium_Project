@TC_5665_5666_5447_validate_Send_my_data_dialog_and_delete_my_account_Weekday_BE_resale_portal
Feature: TC5666 : Validate delete my account BE Resale Portal

  Scenario Outline: 5666_validate_delete_my_account_BE_resale_portal
    When User navigates to ResalePortal "<url>" login page
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    Then Navigate to manage account
    Then click on Send me my data and validate the popup
    Then confirmation email should sent with "Personal Data request | weekday 2nd Hand Curated"

    Examples: 
      | Brand   | Country | Store             | Service | StoreStatus | url                | username             | password               | Store_Name                   | brand_name | Gender | Category | Condition | Color | Pattern | Material | Unsolditem              | status         | existingseller            | tab       | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | Unsold Item | Number of Items |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | Store Open  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Other      | Women  | Dresses  | Vintage   | Black | Floral  | Cotton   | Pick-up item from store | Pre-registered | testerswathi135@gmail.com | All Items |       11 |     2023 | May       |     11 |   2024 | May     | 10:00         | Pickup      |               1 |

  Scenario Outline: 5665_validate_delete_data_BE_resale_portal
     Given user naviagtes to login page "<portal_url>" and click on Create an account link Name "<creatAccountlinkName>"
    And check create account page should have required fields "<Language>"
    And enter all the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    And click on Continue verify registered message "<success message>" and click on Ok
    Then remove created seller "<Email>" "<portal_url>"

    Examples: 
      | portal_url                 | creatAccountlinkName     | Language | Email                   | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | success message          |
      | QA_ResalePortal_Weekday_SE | Create an account        | English  | abcdefg@gmail.com       | swetha    | hcl      | 9876543210 | Marathalli     |      554678 | Banglore | Registered successfully. |
  