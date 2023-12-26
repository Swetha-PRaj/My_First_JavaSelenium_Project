#Author: neha.sain@hcl.com
#Keywords Summary :
@US_10518_B2B_validation_under_store_side
Feature: B2B validation under store side

  Scenario Outline: B2B validation under store side
    When user navigating to ResaleAppHomePage with valid credentials and signin
    When selecting "<Brand>","<Country>","<Store>"
    Then validate under "<ActionNeeded>" following Entity
      | EXPIRED B2B | IN TRANSIT RECEIVING | IN TRANSIT SENDING |
    Then Validate the count of sending In-transit in resale app with B2B app
    Then User navigated to "<tab>" tab
    And validate the following field are present in "<tab>"
      | Sending | Receiving |
    And validate the count for Sending and receiving count
    Then User navigated to "<B2Btab>" tab
    Then validate Sales data display latest five top categories details

    Examples: 
      | Brand | Country | Store                        | User                    | ManageNewItem    | ManageExpiredItem    | ActionNeeded  | path                                              | tab        | B2Btab |
      | H&M   | Spain   | Passeig de Gràcia 11(ES0200) | swetha.pr@storelens.com | Manage new items | Manage expired items | Action needed | C:/Users/hcladmin/Desktop/B2bTemplateV5-demo.xlsx | In Transit | B2B    |
