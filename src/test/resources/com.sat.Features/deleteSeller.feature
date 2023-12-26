#Author: swetha.pr@hcl.com
#Keywords Summary :

@delete_all_sellers
Feature: deleting seller in resale portal
  
@delete_all_sellers
  Scenario Outline: deleting seller in resale portal
    Then remove created seller "<Email>" "<portal_url>"

    Examples: 
      | portal_url | Email                  |
      | WEEKDAY    | swethahcl960@gmail.com |
  