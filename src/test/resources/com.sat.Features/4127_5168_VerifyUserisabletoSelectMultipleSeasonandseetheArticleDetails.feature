@TC_4227_3975_Verify__5168_3975_User_is_able_to_Select_Multiple_Season
Feature: TC 4127_5168 : Verify User is able to select Multiple Season in Admin Portal
 
 @TC_4227_3975_Verify__5168_3975_User_is_able_to_Select_Multiple_Season
    Scenario Outline: TC 4227_3975_5168_3975 : Verify User is able to select Multiple Season in Admin Portal
         Given Login to Admin tool App with full menu view
         Then change the Country "<Country>" and brand "<Brand>"
       Then Select store "<proName>"
         #When user search "Automation Demo"
        # Then verify the search text "Automation Demo" "<promationName>" "2025" "October" "15" "2025" "October" "20" "Götgatan 21(SE0652)" "ALL" "202205" "promotions" "50"
         And user select Seasons from Seasons
         |202205|
         |201910|
        # |202001|
        # |201807|

         And select the Divisions from Division
         |Weekday Denim|
         |Weekday Woman|
         |Weekday Man|
         
         And select the Sections from Section
         |Projects|
         |Woman|
         |Man|
         
         And select the Department from Departments
         |Bags & Belts|
         |Dresses|
         |Blouses|
         
       Then click on search button
       Then Navigate to Season
       And select multiple season from seasons
         |202001|
         |201807|
      Then click on apply button
      Then navigate to i symbol next to item count
      
        
   Examples: 
      | Brand   | Country | proName |Season |Division      |Section |Department|promationName|
      | WEEKDAY | Sweden  |All Products |202205 |Weekday Women |Women   |Dresses| James001|
   