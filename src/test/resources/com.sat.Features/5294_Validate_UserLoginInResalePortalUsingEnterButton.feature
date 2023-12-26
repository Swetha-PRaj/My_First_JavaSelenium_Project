@5427:5294_Valiadte_User_Is_Able_To_login_Into_Resaleapp_by_pressing_Enter_button
Feature: TC5294 :Valiadate User Is Able To login Into Resaleapp by pressing Enter button

  Scenario Outline: 5294 Valiadate_User Is Able To login Into Resaleapp by pressing Enter button
    Given user go to login page "<url>"
    And user enters valid ResalePortal "<username>" and "<password>" Resale

    #  Given user go to login page "<url>" and click on Create an account link
    # And Go to "<settings>" and select the "<Brand>" disable it and click on save
    #  And Go to "<settings>" and select the "<Brand>" the enable it
    Examples: 
      | url                | username             | password               |
      | resale_portal_url1 | resale_portal_userid | resale_portal_password |
