#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_5857_5873_5874_5877_5881_5886_5889_Verify_User_Next_Available_Time_To_Book_The_Appointment_For_Particular_Date_From_Click&Meet
Feature: TC 2839_2855_2858 : Verify user gets visitor notification email

  @TC_5846_5857_5873_5874_5877_5881_5886_5889_User_gets__User_Next_Available_Time_To_Book_The_Appointment_For_Particular_Date_From_Click&Meet
  Scenario Outline: TC 5857_5873_5874_5877_5881_5886_5889 : Verify user gets visitor notification email
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<storeName>" and check the "<StoreStatus>"
    Then check calender is not generated for the "<serviceName>" "<Brand>" "<Country>" "<storeName>" "<click&MeetstoreName>" "Enable" "<url>"
    Then Validate the message is displayed on selecting today date from the Select date & time "<ExpextedText>"
    And Click on Next available time then the validate message "<NextText>" "<ExpextedText>"

    Examples: 
      | Brand   | Country         | storeName | click&MeetstoreName     | serviceName | StoreStatus | url                                | ExpextedText                                                                       | NextText                                                                                                                                   |
      | WEEKDAY | Sweden          | Hansa     | Hansa                   | Resell      | Store Open  | Click&MeetPortal_Weekday_SE_Resell | Unfortunately, we do not have any available times on this day.Next available time  | No future dates available.\nPlease come back another day to book an appointment.\nIn the mean time we will add more days                   |
      | monki   | Sweden          | Hansa     | Hansa                   | Resell      | Store Open  | Click&MeetPortal_monki_SE_Resell   | Tyvärr har vi inga lediga tider denna dag.Nästa tillgängliga tid                   | Inga framtida datum tillgängliga.\nKom tillbaka en annan dag för att boka en tid.\nUnder tiden kommer vi att lägga ut fler dagar.          |
      | H&M     | The Netherlands | (NL0080)  | H&M Almere              | Rental      | Store Open  | Click&MeetPortal_H&M_NL_Rental     | Helaas hebben wij op deze dag geen beschikbare tijdslots.Volgende beschikbare tijd | Geen toekomstige data beschikbaar.\nProbeer het op een andere dag opnieuw.\nWij zullen binnenkort meer dagen toevoegen.                    |
      | WEEKDAY | The Netherlands | (NL0650)  | Weekday Amsterdam       | Resell      | Store Open  | Click&MeetPortal_Weekday_NL_Resell | Helaas hebben wij op deze dag geen beschikbare tijdslots.Volgende beschikbare tijd | Geen toekomstige data beschikbaar.\nProbeer het op een andere dag opnieuw\nWij zullen binnenkort meer dagen toevoegen.                     |
      | H&M     | Germany         | (DE0381)  | A10 Center              | Rental      | Store Open  | Click&MeetPortal_H&M_DE_Rental     | Leider haben wir an diesem Tag keine freien Zeiten.Nächste verfügbare Zeit         | Keine zukünftigen Daten verfügbar.\nBitte versuche es an einem anderen Tag erneut\nIn der Zwischenzeit werden wir weitere Tage hinzufügen. |
      | WEEKDAY | Belgium         | (BE0406)  | Sint-pietersnieuwstraat | Resell      | Store Open  | Click&MeetPortal_Weekday_BE_Resell | Unfortunately, we do not have any available times on this day.Next available time  | No future dates available.\nPlease come back another day to book an appointment.\nIn the mean time we will add more days                   |
