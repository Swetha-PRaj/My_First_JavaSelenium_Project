#Author: neha.sain@hcl.com
#Keywords Summary :
@Validation_of_B2B_File_Upload_for_a_Existing_Order_for_HM_Flamingo
Feature: Validation of B2B File Upload for a Existing Order for HM Flamingo

  Scenario Outline: Validation of B2B File Upload for a Existing Order for HM Flamingo
    Given user go to login B2BAppHomePage "<url>"
    And user enters valid B2BAppHomePage "<username>" and "<password>"
    Then validate B2B entity "<ManageNewItem>" and "<ManageExpiredItem>"
    Then verify all entities are appearing under Manage new items
      | NEW ORDERS - PENDING | SENDING - IN TRANSIT |
    And Click on New Order pending "<Store>" and "<Store number>"
    Then verify all entities are appearing on the pending screen
      | To make changes upload a new file and select override or add | Step 1/3 | UPLOAD FILE |
    And verify the text display with yellow color highlight "<path>"
    Then verify all entities are appearing on the pending screen
      | Order number | Receiving Store | Sending Store | Receiving Store | Select what this file should do: | Replace items in existing order | Select new file |
    And click on upload file to excel "<path>"
    Then verify all entities are appearing on the pending screen
      | Date | B2B Item ID | Category | Price | Size | Brand | Item ID |
    And click on next button
    Then verify all entities are appearing on the pending screen
      | Step 2/3 | Order number | Created Date | Sending Store | Receiving Store | 2 Items | Passeig de Gràcia 11(ES0200) | Weekday Soho(GB0989) |
    And click on next button
    Then verify all entities are appearing on the pending screen
      | Order number | Created Date | Sending Store | Receiving Store | Step 3/3 | Scan the parcel label to register parcel ID into this system |
    And Click on Scan parcel button
    Then Validate the following entities present in the register parcel ID
      | Scan the parcel label to register parcel ID into this system | Scan barcode on parcel label | Add parcel ID manually |
    And Generate the unique parcel ID and click on done
    And click on Home button
    Then Validate the count of sending In-transit
    And Click on Sending In-transit and valiadate the detail matches with uploaded file
      | Date | B2B Name | Parcel Id | Order Number | Items | Sending Store | Receiving Store | Order Status |

    Examples: 
      | url             | username           | password             | User                    | ManageNewItem    | ManageExpiredItem    | path                                              | Store number | Store name                   | Store           |
      | B2B_url         | B2B_userid         | B2B_password         | swetha.pr@storelens.com | Manage new items | Manage expired items | C:/Users/hcladmin/Desktop/B2bTemplate.xlsx        | ES0200       | Passeig de Gràcia 11(ES0200) | Receiving store |
      | B2B_updated_url | B2B_weekday_userid | B2B_weekday_password | swetha.pr@storelens.com | Manage new items | Manage expired items | C:/Users/hcladmin/Desktop/B2bTemplateWeekday.xlsx | GB0989       | Weekday Soho(GB0989)         | Receiving store |
