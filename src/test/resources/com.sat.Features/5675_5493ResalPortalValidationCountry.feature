@TC5675_Validation_of_countries_dropdown
Feature: TC5675 : Validation of countries dropdown while creating a new seller in Resale portal

  Scenario Outline: US_5493 Validation of countries dropdown while creating a new seller in Resale portal
    Given user naviagtes to login page "<url>" and click on Create an account link
    Then user scroll down to till element is visible
    Then user verifies the field "Country"
      | Sweden | The Netherlands | Denmark | United Kingdom | Germany | USA | France | Switzerland | Canada | Belgium | Norway |

    Examples: 
      | url                          |
      | Weekday_BE_resale_portal_url |
      | resale_portal_url1           |

  Scenario Outline: US_5493 Validation of countries dropdown while creating a new seller in Resale portal
    Given user naviagtes to login page "<url>" and click on Create an account link
    Then user scroll down to till element is visible
    Then user verifies the field "Country"
      | Sweden | The Netherlands | Denmark | United Kingdom | Germany | USA | France | Switzerland | Canada | Belgium | Spain |

    Examples: 
      | url              |
      | hm_de_portal_url |
      | hm_nl_portal_url |
