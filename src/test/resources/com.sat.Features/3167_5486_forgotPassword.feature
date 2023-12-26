@3167_5486_ResalForgotpassword
Feature: TC3167_5486 : Validate when user forgot the password

@3167_5486_ResalForgotpassword
  Scenario Outline: TC3167_5486_Verify when user is forgot the password
    Given User navigating to login page "<url>"
    When click on forgot password link
    And enter email id "<username>" and click on Reset button
    Then success message should dispaly
    And An email sent to register email address with subject as "<password reset1>" "<password reset2>"
    And click on Reset passowrd and update it
    Then An email sent to register email address with subject as "<password updated1>" "<password updated2>"

    Examples: 
      | url                        | username             | password reset1        | password reset2          | password updated1         | password updated2        |
     | QA_ResalePortal_Weekday_SE | resale_portal_userid | Password reset request | Weekday 2nd-hand Curated | Your password was updated | Weekday 2nd-hand Curated |
    | QA_ResalePortal_Weekday_NL | resale_portal_userid | Password reset request | Weekday 2nd-hand Curated | Your password was updated | Weekday 2nd-hand Curated |
      | QA_ResalePortal_Weekday_BE | resale_portal_userid | Password reset request | Weekday 2nd-hand Curated | Your password was updated | weekday 2nd-hand Curated |
     | QA_ResalePortal_monki_SE   | resale_portal_userid | Password reset request | Monki Pre-Loved        | Your password was updated | monki Pre-Loved          |
   # p  | QA_ResalePortal_HM_NL      | resale_portal_userid | Paswoord vergeten? | hm Resell        | Jouw wachtwoord is veranderd | Resell                   |
    #p  | QA_ResalePortal_HM_DE      | resale_portal_userid | Passwort zurücksetzen  | Resell           | Dein Passwort wurde geändert | hm Resell                |
      #| QA_ResalePortal_arket_SE   | resale_portal_userid |---- mail subjrect is pending from client
  #p    | resale_portal_url1           | resale_portal_userid | Password reset request | Weekday 2nd Hand Curated | Your password was updated    | Curated Secondhand       |
   #  p| Weekday_BE_resale_portal_url | resale_portal_userid | Password reset request | Weekday 2nd-hand Curated | Your password was updated    | weekday 2nd Hand Curated |

    
  