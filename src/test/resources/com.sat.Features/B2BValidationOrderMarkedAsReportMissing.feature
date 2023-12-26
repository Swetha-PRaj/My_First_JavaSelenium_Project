#Author: neha.sain@hcl.com
#Keywords Summary :
@10518_B2B_validation_under_store_side
Feature: B2B validation under store side

  Scenario Outline: B2B validation under store side
    When user navigating to ResaleAppHomePage with valid credentials and signin
    When selecting "<Brand>","<Country>","<Store>"
    Then validate under "<ActionNeeded>" following Entity
      | EXPIRED B2B | IN TRANSIT RECEIVING | IN TRANSIT SENDING |
    Then Click on In-Transit Receiving
    And click on three dots and Validate field are visible
      | Report as missing | Report as broken |
    Then Click on Report as "<statusneed>" status
    Then User navigated to "<tab>" tab
    And click on the Advanced Search in All Items page
    Then click on Advance Search Status Dropdown with "<AdvStatus>"
    And Validate order number added in All Items tab matches with In-trasit Receiving page

    Examples: 
      | Brand | Country | Store                        | User                    | ManageNewItem    | ManageExpiredItem    | ActionNeeded  | path                                              | tab       | Status1           | Status2          | AdvStatus | statusneed        |
      | H&M   | Spain   | Passeig de Gràcia 11(ES0200) | swetha.pr@storelens.com | Manage new items | Manage expired items | Action needed | C:/Users/hcladmin/Desktop/B2bTemplateV5-demo.xlsx | All Items | Report as missing | Report as broken | Missing   | Report as missing |
      | H&M   | Spain   | Passeig de Gràcia 11(ES0200) | swetha.pr@storelens.com | Manage new items | Manage expired items | Action needed | C:/Users/hcladmin/Desktop/B2bTemplateV5-demo.xlsx | All Items | Report as missing | Report as broken | Broken   | Report as broken  |
