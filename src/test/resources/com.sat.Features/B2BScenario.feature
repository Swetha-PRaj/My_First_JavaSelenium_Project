#Author: neha.sain@hcl.com
#Keywords Summary :
@Validation_of_B2B_File_Upload_for_a_New_Order_for_HM_Flamingo
Feature: Validation of B2B File Upload for a New Order for HM Flamingo

  Scenario Outline: Validation of B2B File Upload for a New Order for HM Flamingo
    When user navigating to B2BAppHomePage with valid credentials and signin
    Then validate B2B entity "<ManageNewItem>" and "<ManageExpiredItem>"
    Then verify all entities are appearing under Manage new items
      | NEW ORDERS - PENDING | Send items to store |
    Then verify all entities are appearing on the left panel Common Task
      | Home | New order | Items | Orders | Account |
    And click on New Order button
    Then navigate to New Order
    And click on upload file to excel "<path>" and Click on done button
    Then validate the field data with entities "<path>"
      | Item ID | B2bItemID | Item Name | Gender | Category (Lookup) | Size (Lookup) | Color | Material | Pattern | Condition | PriceNew | Brand | Article Number |
    Then verify all entities are appearing on the pending screen
      | Order number | Created Date | Sending Store | Receiving Store | Step 1/3 |
    And click on next button
    Then verify all entities are appearing on the pending screen
      | Order number | Created Date | Sending Store | Receiving Store | Step 2/3 | 2 Items |
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
      | User                    | ManageNewItem    | ManageExpiredItem    | path                                              |
      | swetha.pr@storelens.com | Manage new items | Manage expired items | C:/Users/hcladmin/Desktop/B2bTemplateV5-demo.xlsx |
