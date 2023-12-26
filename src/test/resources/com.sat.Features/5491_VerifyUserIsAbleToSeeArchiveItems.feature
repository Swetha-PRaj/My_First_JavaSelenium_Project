#Author: swetha.pr@hcl.com
@5491_Verify_user_is_able_to_see_Archive_items
Feature: TC 5491 Verify user is able to see Archive items

  @5491_Verify_user_is_able_to_see_Archive_items
  Scenario Outline: TC 5491 Verify user is able to see Archive items
    Given user is able to launch ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    When searching with the existing seller "<existingseller>","<tab>"
    And clickng on Add Item button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And clickng on "<status>" item and generate unique id by clicking on edit button and save it
    And clickng on "<status>" and fil details "zara","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
   
   
    When User login to ResalePortal "<url>" with valid "<username>" and "<password>"

    Examples: 
      | url                | username             | password               |
      | resale_portal_url1 | resale_portal_userid | resale_portal_password |
