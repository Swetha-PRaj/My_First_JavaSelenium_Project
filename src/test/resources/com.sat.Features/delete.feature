#Author: your.email@your.domain.com
#Keywords Summary :
@delete_all_items_and_Sellers
Feature: Delete aal the items in resale app

  @delete_all_items
  Scenario Outline: deleting all items in resale app
    Given launch ResaleApp signin and select "<Brand>","<Country>","<Store>"
    Then click on back button in Home Page
    When searching with the existing seller "<existingseller>","<tab>"
    Then delete all items

    Examples: Götgatan 21(SE0652)
      | Brand   | Country | Store             | existingseller            | tab       |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |
      | WEEKDAY | Sweden  | Hansa             | testerswathi135@gmail.com | All Items |
